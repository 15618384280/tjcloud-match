package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.alipay.api.enums.AlipayTradeStatus;
import com.tjcloud.alipay.api.service.AlipayTradeApiService;
import com.tjcloud.core.Constants;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.exception.ServiceException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.enums.*;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.utils.UrlConfig;
import com.tjcloud.match.base.entity.*;
import com.tjcloud.match.base.service.*;
import com.tjcloud.match.base.vo.MatchInfoVO;
import com.tjcloud.match.base.vo.SignRecordVO;
import com.tjcloud.match.base.vo.TeamSignRecordVO;
import com.tjcloud.mmq.producer.MMQProducer;
import com.tjcloud.order.api.enums.OrderType;
import com.tjcloud.order.api.enums.PaymentType;
import com.tjcloud.order.api.message.OrderMessageLocale;
import com.tjcloud.order.api.service.OrderApiService;
import com.tjcloud.order.api.service.OrderEscrowPay;
import com.tjcloud.order.api.vo.CreateTrainOrderVO;
import com.tjcloud.order.base.entity.OrderDetailField;
import com.tjcloud.tenpay.api.WechatConstants;
import com.tjcloud.tenpay.api.bean.mchpay.MchOrderInfoResult;
import com.tjcloud.tenpay.api.bean.mchpay.MchOrderquery;
import com.tjcloud.tenpay.api.bean.mchpay.Unifiedorder;
import com.tjcloud.tenpay.api.bean.mchpay.UnifiedorderResult;
import com.tjcloud.tenpay.api.enums.TenpayTradeStatus;
import com.tjcloud.tenpay.api.service.*;
import com.tjcloud.tenpay.api.utils.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ryan on 2017/3/16.
 */
@Service("signRecordApiService")
public class SignRecordApiServiceImpl implements SignRecordApiService {
    private static final Logger logger = LoggerFactory.getLogger(SignRecordApiServiceImpl.class);

    @Autowired
    private SubjectSignFieldService subjectSignFieldService;
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private MatchSubjectService matchSubjectService;
    @Autowired
    private MatchInfoService matchInfoService;
    @Autowired
    private SignRecordFieldTableService signRecordFieldTableService;
    @Autowired
    private SubjectTeamService subjectTeamService;

    @Autowired
    private TenpayMchService tenpayMchService;
	@Autowired
	private HFTenpayMchService hfTenpayMchService;
	@Autowired
	private TXTenpayMchService txTenpayMchService;
	@Autowired
	private CMTenpayMchService cmTenpayMchService;
    @Autowired
    private ZjgTenpayMchService zjgTenpayMchService;

    @Autowired
    private AlipayTradeApiService alipayTradeApiService;

    @Autowired
    private OrderEscrowPay orderEscrowPay;

    @Autowired
    private OrderApiService orderApiService;
    
    @Autowired
    private MMQProducer mmqProducer;
    @Autowired
	private IdentityCardService identityCardService;
    
    /**
     * 根据订单号查询 报名记录
     * @param orderNo
     * @return
     */
    @Override
    public SignRecordVO<SignRecordFieldTable> querySignRecordByOrderNo(String orderNo) {
    	ValidateUtils.notEmpty(orderNo, MatchMessageLocale.PARAM_IS_ERROR);
    	Map<String,Object> param = Maps.newHashMap();
    	param.put("orderNo", orderNo);
    	SignRecord signRecord = signRecordService.findOne(param);
    	if (ObjectUtils.isEmpty(signRecord)) throw new BusinessException(MatchMessageLocale.SIGN_RECORD_IS_ERROR);

    	SignRecordVO<SignRecordFieldTable> signRecordVO = new SignRecordVO<SignRecordFieldTable>();
    	BeanUtils.copyProperties(signRecord, signRecordVO);

    	Map<String, Object> paramMap = Maps.newHashMap();
    	paramMap.put("recordId", signRecord.getId());
    	List<SignRecordFieldTable> recordFieldTables = signRecordFieldTableService.findBy(paramMap);
    	signRecordVO.setSignRecordInfo(recordFieldTables);
    	//查询科目信息
    	MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
    	signRecordVO.setMatchSubject(matchSubject);
    	MatchInfo matchInfo = matchInfoService.get(signRecord.getMatchId());
    	MatchInfoVO MatchInfoVO = new MatchInfoVO();
    	BeanUtils.copyProperties(matchInfo, MatchInfoVO);
    	MatchInfoVO.setStateStr(MatchState.getText(matchInfo.getState()));
    	signRecordVO.setMatchInfo(MatchInfoVO);
    	return signRecordVO;
    }

    /**
     * 将张家港的赛事报名改为已支付
     * @param orderNo
     * @return
     */
    @Override
    public SignRecord savePaidZJGmatch(String orderNo, PaymentType paymentType, Long paymentTime) {
    	ValidateUtils.notEmpty(orderNo, MatchMessageLocale.PARAM_IS_ERROR);
        Map<String, Object> findMap = Maps.newHashMap();
        findMap.put("orderNo", orderNo);
        SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
        if(!ObjectUtils.isEmpty(subjectTeam)){
            paySign(subjectTeam, paymentType, paymentTime);
            findMap.put("joinUserId", subjectTeam.getId());
            return signRecordService.findOne(findMap);
        }else{
            SignRecord signRecord = signRecordService.findOne(findMap);
            return paySign(signRecord, paymentType, paymentTime);
        }
    }

    /**
     * 查询 报名记录
     * @param recordId
     * @return
     */
    @Override
    public SignRecordVO<SignRecordFieldTable> querySignRecord(String recordId) {
        ValidateUtils.notEmpty(recordId, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
        SignRecord signRecord = signRecordService.get(recordId);
        if (ObjectUtils.isEmpty(signRecord)) throw new BusinessException(MatchMessageLocale.SIGN_RECORD_IS_ERROR);

        SignRecordVO<SignRecordFieldTable> signRecordVO = new SignRecordVO<SignRecordFieldTable>();
        BeanUtils.copyProperties(signRecord, signRecordVO);

        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("recordId", recordId);
        List<SignRecordFieldTable> recordFieldTables = signRecordFieldTableService.findBy(paramMap);
        signRecordVO.setSignRecordInfo(recordFieldTables);
        //查询科目信息
        MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
        signRecordVO.setMatchSubject(matchSubject);
        MatchInfo matchInfo = matchInfoService.get(signRecord.getMatchId());
        MatchInfoVO MatchInfoVO = new MatchInfoVO();
        BeanUtils.copyProperties(matchInfo, MatchInfoVO);
        MatchInfoVO.setStateStr(MatchState.getText(matchInfo.getState()));
        signRecordVO.setMatchInfo(MatchInfoVO);
        return signRecordVO;
    }

    /**
     * 团队-保存、新增 报名记录
     *
     * @param TeamSignRecordVO teamSignRecord
     * @return SignRecordVO<SignRecordFieldTable>
     */
    @Transactional
    @Override
    public SignRecordVO<SignRecordFieldTable> saveTeamsign(TeamSignRecordVO teamSignRecord)  throws BusinessException{
	    	 SignRecordVO<SignRecordFieldTable> signRecord = teamSignRecord.getHeadman();
	    	 signRecord = saveRecord(signRecord);
	    	 //保存队员
         SubjectTeam subjectTeam = subjectTeamService.get(signRecord.getJoinUserId());
         List<SignRecordVO<SignRecordFieldTable>> teamMember = teamSignRecord.getTeamMember();
         for (SignRecordVO<SignRecordFieldTable> signRecordVO : teamMember) {
	        	 signRecordVO.setJoinUserId(subjectTeam.getId());
	        	 signRecordVO.setSubjectId(subjectTeam.getSubjectId());
	        	 saveRecord(signRecordVO);
         }
         return signRecord;
    }
    /**
     * 保存、新增 报名记录
     *
     * @param signRecord
     * @return
     */
    @Transactional
    @Override
    public SignRecordVO<SignRecordFieldTable> saveSignRecord(SignRecordVO<SignRecordFieldTable> signRecord)  throws BusinessException{
    		return saveRecord(signRecord);
    }

	private Boolean checkIdcard(String idcard){
		if(StringUtils.isEmpty(idcard)) {
			return false;
		}
		String regex = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
		return idcard.matches(regex);
	}
    
    @SuppressWarnings("unchecked")
	private SignRecordVO<SignRecordFieldTable> saveRecord(SignRecordVO<SignRecordFieldTable> signRecord)  throws BusinessException{
    	// 科目ID必传
    	ValidateUtils.notEmpty(signRecord.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
    	MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
    	ValidateUtils.notNull(matchSubject, MatchMessageLocale.SUBJECT_IS_ERROR);
    	Map<String, Object> paramMap = Maps.newHashMap();
    	paramMap.put("subjectId", signRecord.getSubjectId());
    	List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(paramMap);// 该科目的所有报名字段
    	Map<String, SignRecordFieldTable> mapvo = signRecord.getMapvo();
    	
    	SignRecord signRecordEmpty;
    	if (StringUtils.isEmpty(signRecord.getId())) { // 新增报名选手
    		logger.debug("新增报名选手");
    		//检验科目最大报名人数，大于最大报名人数，科目提示已报满
    		if (ObjectUtils.nullSafeEquals(signRecord.getMemberType(), 1) || StringUtils.isEmpty(signRecord.getJoinUserId())) {
    			checkLimit(matchSubject, 1);
    		}
    		ValidateUtils.notEmpty(signRecord.getName(), MatchMessageLocale.SIGN_FIELD_MISSING); // 校验姓名
    		ValidateUtils.notEmpty(signRecord.getPhone(), MatchMessageLocale.SIGN_FIELD_MISSING);// 校验手机号
    		ValidateUtils.notEmpty(signRecord.getCertificateNo(), MatchMessageLocale.SIGN_FIELD_MISSING);// 校验证件号
    		
    		// 校验重复报名
    		checkDuplicate(matchSubject, signRecord);
    		
    		signRecord.setPayment(PaymentStatus.PAYABLE.getStatus()); // 未支付
    		signRecord.setReview(1);// 通过
    		signRecord.setOrderNo("000000"+(new DateTime()).toString("yyMMddHHmmssSSS"));
    		signRecordEmpty = signRecordService.create(signRecord);
    		
    		for (SubjectSignField subjectSignField : subjectSignFields) {
    			String controlKey = subjectSignField.getControlKey();
    			SignRecordFieldTable signRecordFieldTable = mapvo.get(controlKey);
    			if (ObjectUtils.isEmpty(signRecordFieldTable)) {
    				// 如果必填项但没传值
    				if (subjectSignField.getState() == 2) {
    					throw new BusinessException(MatchMessageLocale.SIGN_FIELD_MISSING, "缺少{}报名字段", subjectSignField.getComment());
    				}
    			} else { // 添加报名字段
    				//校验身份证与姓名是否一致
            		if(matchSubject.getCheckCardId()){
            			if("sf1086268549".equals(controlKey) && "身份证".equals(signRecordFieldTable.getValue()) ){
							ValidateUtils.isTrue(checkIdcard(signRecord.getCertificateNo()), MessageLocale.EMPTY_CODE, "身份证号检查未通过。");
//            				IdentityCard identityCard = identityCardService.verifyIdcardv(signRecord.getCertificateNo(), signRecord.getName());
//            				if(identityCard != null){
//            					ValidateUtils.isTrue(identityCard.getIsTrue(), MessageLocale.EMPTY_CODE, "身份证号与姓名不一致");
//            				}
            			}
            		}
    				signRecordFieldTable.setRecordId(signRecordEmpty.getId());
    				signRecordFieldTableService.updateSignRecordField(signRecordFieldTable);
    			}
    		}
    		if (matchSubject.getType() == SubjectType.SINGLE.getType()) { // 个人
    			//判断科目如果免费则直接报名成功
    			if(matchSubject.getPayMode() == 0 || matchSubject.getExpenses() == 0){
    				paySign(signRecordEmpty, PaymentType.CASH, System.currentTimeMillis());
    				return querySignRecord(signRecordEmpty.getId());
    			}
    		} else { // 团体
    			if (StringUtils.isEmpty(signRecordEmpty.getJoinUserId())){ // 如果没有团队id
    				if (ObjectUtils.nullSafeEquals(signRecord.getMemberType(), 1) ){ // 是队长，则新增团队
    					SubjectTeam subjectTeam = new SubjectTeam();
    					subjectTeam.setSubjectId(matchSubject.getId());
    					subjectTeam.setSubjectName(matchSubject.getSubject());
    					subjectTeam.setTeamName(signRecord.getTeamName());
    					subjectTeam.setCaptainName(signRecord.getName());
    					subjectTeam.setSex(signRecord.getSex());
    					subjectTeam.setPhone(signRecord.getPhone());
    					subjectTeam.setCertificateNo(signRecord.getCertificateNo());
    					subjectTeam.setOrderNo(signRecordEmpty.getOrderNo());
    					subjectTeam.setPayment(signRecordEmpty.getPayment());
    					//判断科目如果免费则直接报名成功
    					if(matchSubject.getPayMode() == 0 || matchSubject.getExpenses()==0){
    						subjectTeam.setPayment(PaymentStatus.PAID.getStatus());
    						subjectTeam.setPaymentType(PaymentType.CASH.getStatus());
    						subjectTeam.setPaymentTime(System.currentTimeMillis());
    					}
    					subjectTeam.setExpenses(matchSubject.getExpenses());
    					subjectTeam = subjectTeamService.create(subjectTeam);
    					signRecordEmpty.setJoinUserId(subjectTeam.getId());
    				}else {
    					throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
    				}
    			}
    			if (ObjectUtils.nullSafeEquals(signRecord.getMemberType(), 1) ) {
    				signRecordEmpty.setMemberType(1);// 队长
    			}else {
    				signRecordEmpty.setMemberType(2); // 队员
    			}
    			//记录团队成员的订单号
    			SubjectTeam subjectTeam = subjectTeamService.get(signRecordEmpty.getJoinUserId());
    			signRecordEmpty.setOrderNo(subjectTeam.getOrderNo());
    			signRecordEmpty.setPayment(subjectTeam.getPayment());
    			signRecordEmpty.setPaymentType(subjectTeam.getPaymentType());
    			signRecordEmpty.setPaymentTime(subjectTeam.getPaymentTime());
    			signRecordEmpty.setUserId(null);
    			signRecordService.modify(signRecordEmpty);
    			subjectTeam.setTeamNum(subjectTeam.getTeamNum() + 1);
    			subjectTeamService.modify(subjectTeam);
    		}
    		//科目报名人数
    		resetSignCount(matchSubject);
    	} else if (ObjectUtils.isEmpty(signRecordEmpty = signRecordService.get(signRecord.getId()))) {
    		throw new BusinessException(MatchMessageLocale.SIGN_RECORD_IS_ERROR);
    	} else {
	    		// 修改报名选手
	    		ValidateUtils.isTrue(StringUtils.equals(signRecord.getSubjectId(), signRecordEmpty.getSubjectId()), MatchMessageLocale.PARAM_IS_ERROR);
	    		
	    		String signRecordStr = JSONObject.toJSONString(signRecord);
	    		Map<String, Object> signRecordMap = JSONObject.parseObject(signRecordStr, HashMap.class);
	    		String signRecordEmptyStr = JSONObject.toJSONString(signRecordEmpty);
	    		Map<String, Object> signRecordEmptyMap = JSONObject.parseObject(signRecordEmptyStr, HashMap.class);
	    		signRecordEmptyMap.putAll(signRecordMap);
	    		signRecordEmpty = JSONObject.parseObject(JSONObject.toJSONString(signRecordEmptyMap), signRecordEmpty.getClass());
	    		signRecordEmpty.setUserId(null);
	    		signRecordService.modify(signRecordEmpty);
    		
    			if (signRecord.getSignRecordInfo() != null && signRecord.getSignRecordInfo().size() > 0)
    			for (SubjectSignField subjectSignField : subjectSignFields) {
    				String controlKey = subjectSignField.getControlKey();
    				SignRecordFieldTable signRecordFieldTable = mapvo.get(controlKey);
    				if (ObjectUtils.isEmpty(signRecordFieldTable)) continue;// 如果没有修改该字段
    				// 添加、修改报名字段
    				signRecordFieldTable.setRecordId(signRecordEmpty.getId());
    				signRecordFieldTableService.updateSignRecordField(signRecordFieldTable);
    			}
    			
    		}
    		return querySignRecord(signRecordEmpty.getId());
    }
    
    public SignRecordVO<SignRecordFieldTable> addTeamMember(String teamId,SignRecordVO<SignRecordFieldTable> signRecord){
	    	SubjectTeam subjectTeam = subjectTeamService.get(teamId);
		MatchSubject matchSubject = matchSubjectService.get(subjectTeam.getSubjectId());
	    	ValidateUtils.notNull(matchSubject, MatchMessageLocale.SUBJECT_IS_ERROR);
		// 校验重复报名
		checkDuplicate(matchSubject, signRecord);
	    	signRecord.setReview(1);// 通过
		signRecord.setOrderNo(subjectTeam.getOrderNo());
		signRecord.setPayment(subjectTeam.getPayment());
		signRecord.setPaymentType(subjectTeam.getPaymentType());
		signRecord.setPaymentTime(subjectTeam.getPaymentTime());
		SignRecord signRecordEmpty = signRecordService.create(signRecord);
		Map<String, Object> paramMap = Maps.newHashMap();
	    	paramMap.put("subjectId", signRecord.getSubjectId());
	    	List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(paramMap);// 该科目的所有报名字段
	    	Map<String, SignRecordFieldTable> mapvo = signRecord.getMapvo();
			if (signRecord.getSignRecordInfo() != null && signRecord.getSignRecordInfo().size() > 0){
				for (SubjectSignField subjectSignField : subjectSignFields) {
					String controlKey = subjectSignField.getControlKey();
					SignRecordFieldTable signRecordFieldTable = mapvo.get(controlKey);
					if (ObjectUtils.isEmpty(signRecordFieldTable)) continue;// 如果没有修改该字段
					// 添加、修改报名字段
					signRecordFieldTable.setRecordId(signRecord.getId());
					signRecordFieldTableService.updateSignRecordField(signRecordFieldTable);
				}
			}
		subjectTeam.setTeamNum(subjectTeam.getTeamNum() + 1);
		subjectTeamService.modify(subjectTeam);
		return querySignRecord(signRecordEmpty.getId()); 
    }

    /**
     * @param outTradeNo 商户订单号
     * @param subject    支付title（ps：我要运动）
     * @param body       消费类型（ps:场地预定消费）
     * @param amount     支付金额（单位：分）
     * @param notifyUrl  支付回调地址
     * @param method     支付方式（alipay.trade.wap.pay：网页，alipay.trade.app.pay：APP移动应用）
     */
	@Override
    public String alipayEscrowReturn(JSONObject requestParams) {
        String tradeStatus = requestParams.getString("trade_status");
        String outTradeNo = requestParams.getString("out_trade_no");
//        String notify_id = requestParams.getString("notify_id");
        String returnId = "";
        logger.debug(String .format("get alipay pay vertify request! out_trade_no [%s]", outTradeNo));

//        boolean verify = AlipayNotify.verifyResponse(notify_id).equals("true");
//        logger.debug(String .format("get alipay pay vertify request! verify [%s]", verify));
        String alipayRuturnURL = String.format("<script>window.location.href='%s';</script>",UrlConfig.SIGN_PAY_PRO+"/"+outTradeNo);
        if(
           (AlipayTradeStatus.TRADE_SUCCESS.getStatus().equals(tradeStatus)
           ||
           AlipayTradeStatus.TRADE_FINISHED.getStatus().equals(tradeStatus))){
            // alipay支付时间
            String gmt_payment = requestParams.getString("gmt_payment"); // 支付时间
            long paymentTime = 0;
            if (StringUtils.isNotEmpty(gmt_payment)) paymentTime = DateUtils.toLong(gmt_payment, Constants.YYYY_MM_DD_HH_MM_SS);

            Map<String, Object> findMap = Maps.newHashMap();
        		findMap.put("orderNo", outTradeNo);
        		SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
                if(!ObjectUtils.isEmpty(subjectTeam)){
                    returnId = paySign(subjectTeam,PaymentType.ALIPAY, paymentTime).getId();
                }else{
                	SignRecord signRecord = signRecordService.findOne(findMap);
                    returnId = paySign(signRecord, PaymentType.ALIPAY, paymentTime).getId();
                }
            alipayRuturnURL = String.format("<script>window.location.href='%s';</script>",UrlConfig.SIGN_PAY_PRO+"?"+returnId);

        }

        return alipayRuturnURL;
    }

    /**
     * @param outTradeNo 商户订单号
     * @param subject    支付title（ps：我要运动）
     * @param body       消费类型（ps:场地预定消费）
     * @param amount     支付金额（单位：分）
     * @param notifyUrl  支付回调地址
     * @param method     支付方式（alipay.trade.wap.pay：网页，alipay.trade.app.pay：APP移动应用）
     */
    @Override
    public ResponseResult alipayEscrow(String outTradeNo, String subject, String body, String amount, String notifyUrl, String method, String returnUrl) {
        try {
            BigDecimal pay_amount = new BigDecimal(amount);
            pay_amount = pay_amount.divide(new BigDecimal(100));
            return alipayTradeApiService.getRSASign(outTradeNo, subject, body, pay_amount.toString(), notifyUrl, method, returnUrl);
        } catch (Exception e) {
            logger.error("Order payment failed,outTradeNo is{},error info:{}", outTradeNo, e.getMessage(), e);
            throw new BusinessException(MatchMessageLocale.ORDER_ALIPAY_FAILED);//支付宝支付失败
        }
    }

    /**
     * @param outTradeNo 商户订单号
     *                   //     * @param subject    支付title（ps：我要运动）
     * @param body       消费类型（ps:场地预定消费）
     * @param amount     支付金额（单位：分）
     * @param notifyUrl  支付回调地址
     * @param tradeType  微信支付方式（JSAPI：网页，NATIVE：微信，APP：移动应用，WAP：扫码支付）
     */
    @Override
    public ResponseResult tenpayEscrow(String outTradeNo, String body, String amount, String notifyUrl, String tradeType, String opentId, String spbillIp,String tenantId, String source) {
        try {
            Unifiedorder unifiedorder = new Unifiedorder();
            unifiedorder.setNonce_str(UUID.randomUUID().toString().replace("-", ""));//随机字符串
            unifiedorder.setBody(body);
            unifiedorder.setAttach("我要运动");//附加数据(PS:订单ID)
            unifiedorder.setOut_trade_no(outTradeNo);
            unifiedorder.setTotal_fee(amount);
            unifiedorder.setSpbill_create_ip(spbillIp);
            unifiedorder.setTrade_type(tradeType);
            unifiedorder.setProduct_id(outTradeNo);//商品ID
            unifiedorder.setOpenid((StringUtils.isEmpty(opentId)) ? null : opentId);
            unifiedorder.setNotify_url(notifyUrl);                //通知地址
            UnifiedorderResult unifiedorderResult = null;
            String payJson = null;
			if(StringUtils.isNotEmpty(tenantId)){
            	switch (tenantId) {
					case WechatConstants.TX_YDC_TENANTID:
						unifiedorderResult = txTenpayMchService.payUnifiedorder(unifiedorder);
						payJson = TxPayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(),
								unifiedorder.getOut_trade_no(), unifiedorder.getTrade_type());
						break;
					case WechatConstants.JZG_YDC_TENANTID:
						unifiedorder.setBody("乐动港城-赛事报名");//商品描述
						unifiedorderResult = zjgTenpayMchService.payUnifiedorder(unifiedorder);
						payJson = ZjgPayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(),
								unifiedorder.getOut_trade_no(), unifiedorder.getTrade_type());
						break;
					default:
						unifiedorderResult = tenpayMchService.payUnifiedorder(unifiedorder);
						payJson = PayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(),
								unifiedorder.getOut_trade_no(), unifiedorder.getTrade_type());
						break;
				}
            }else{
				if(WechatConstants.HF_YDC_SPORTS.equals(source)){
					unifiedorder.setBody("运动合肥-赛事报名");//商品描述
					unifiedorderResult = hfTenpayMchService.payUnifiedorder(unifiedorder);
					payJson = HfPayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(), unifiedorder.getOut_trade_no(), unifiedorder.getTrade_type());

				} else if (WechatConstants.CM_YDC_SPORTS.equals(source)) {
					unifiedorder.setAttach("乐动崇明-赛事报名");
					unifiedorderResult = cmTenpayMchService.payUnifiedorder(unifiedorder);
					payJson = CmPayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(),
							unifiedorder.getOut_trade_no(), unifiedorder.getTrade_type());
				} else {
					unifiedorderResult = tenpayMchService.payUnifiedorder(unifiedorder);
					payJson = PayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(),
							unifiedorder.getOut_trade_no(), unifiedorder.getTrade_type());
				}

            }
            return ResponseResult.ok().setData(payJson);
        } catch (Exception e) {
            logger.error("Order payment failed,outTradeNo is{},error info:{}", outTradeNo, e.getMessage(), e);
            throw new BusinessException(MatchMessageLocale.ORDER_TENPAY_FAILED);//微信支付失败
        }
    }

    /**
     * @param paymentType 支付类型（PS:4:支付宝，5：微信支付）
     * @param outTradeNo  商户订单号
     * @param tradeType   微信支付方式（JSAPI：网页，NATIVE：微信，APP：移动应用，WAP：扫码支付）
     * @return
     * @throws ServiceException
     */
    @Override
    public ResponseResult signPayCallback(int paymentType, String outTradeNo, String tradeType) throws BusinessException {
        if (paymentType == 4) {
            //支付宝支付订单查询
            ResponseResult result = alipayTradeApiService.queryAlipayByOrderNo(outTradeNo);
            JSONObject alipayResponse = (JSONObject) result.getData();
            if (!AlipayTradeStatus.TRADE_SUCCESS.getStatus().equals(alipayResponse.getString("tradeStatus"))) {
                logger.debug("Order payEscrowCallback failed,outTradeNo is:{}", outTradeNo);
                throw new BusinessException(MatchMessageLocale.ORDER_ALIPAY_CALLBACK_FAILED);//订单支付宝支付回调失败
            }
            Map<String, Object> findMap = Maps.newHashMap();
            findMap.put("orderNo", outTradeNo);
            SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
            // alipay支付时间
            String gmt_payment = alipayResponse.getString("gmt_payment"); // 支付时间
            long paymentTime = 0;
            if (StringUtils.isNotEmpty(gmt_payment)) paymentTime = DateUtils.toLong(gmt_payment, Constants.YYYY_MM_DD_HH_MM_SS);

            if(!ObjectUtils.isEmpty(subjectTeam)){
                paySign(subjectTeam,PaymentType.ALIPAY, paymentTime);
            }else{
                SignRecord signRecord = signRecordService.findOne(findMap);
                paySign(signRecord, PaymentType.ALIPAY, paymentTime);
            }
            return result;
        } else if (paymentType == 5) {
            //微信支付
            MchOrderquery mchOrderquery = new MchOrderquery();
            mchOrderquery.setOut_trade_no(outTradeNo);//商户订单号
            MchOrderInfoResult mchorderInfoResult = tenpayMchService.payOrderquery(mchOrderquery, tradeType);
            if (!TenpayTradeStatus.SUCCESS.getStatus().equals(mchorderInfoResult.getTrade_state())) {
                logger.debug("Order payEscrowCallback failed,outTradeNo is:{}", outTradeNo);
                throw new BusinessException(MatchMessageLocale.ORDER_TENPAY_CALLBACK_FAILED);//订单微信支付回调失败
            }
            // wxpay支付时间
            String time_end = mchorderInfoResult.getTime_end();
            long paymentTime = 0;
            if (StringUtils.isNotEmpty(time_end)) paymentTime = DateUtils.toLong(time_end, Constants.YYYYMMDDHHMMSS);

            Map<String, Object> findMap = Maps.newHashMap();
            findMap.put("orderNo", outTradeNo);
            SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
            if(!ObjectUtils.isEmpty(subjectTeam)){
                paySign(subjectTeam,PaymentType.TENPAY, paymentTime);
            }else{
                SignRecord signRecord = signRecordService.findOne(findMap);
                paySign(signRecord, PaymentType.TENPAY, paymentTime);
            }
            return ResponseResult.ok().setData(mchorderInfoResult);
        } else {
            throw new BusinessException(MatchMessageLocale.ORDER_PAYMENT_TYPE_NOT_EXISTED);//订单支付类型不存在
        }
    }

    @Override
    public void alipayMatchWebHook(JSONObject parameterMap) {
        // 获取支付状态进行判断
        String tradeStatus = parameterMap.getString("trade_status");

        if (tradeStatus != null && AlipayTradeStatus.TRADE_SUCCESS.getStatus().equals(tradeStatus)) {
            // alipay支付时间
            String gmt_payment = parameterMap.getString("gmt_payment"); // 支付时间
            long paymentTime = 0;
            if (StringUtils.isNotEmpty(gmt_payment)) paymentTime = DateUtils.toLong(gmt_payment, Constants.YYYY_MM_DD_HH_MM_SS);

            // 获取订单号，完成支付
            String outTradeNo = parameterMap.getString("out_trade_no");
            Map<String, Object> findMap = Maps.newHashMap();
            findMap.put("orderNo", outTradeNo);
            SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
            if(!ObjectUtils.isEmpty(subjectTeam)){
                paySign(subjectTeam,PaymentType.ALIPAY, paymentTime);
            }else{
                SignRecord signRecord = signRecordService.findOne(findMap);
                paySign(signRecord, PaymentType.ALIPAY, paymentTime);
            }
        } else {
            logger.debug("pay by alipay is fail , fail tradeStatus: {}", tradeStatus);
            throw new BusinessException(MessageLocale.SYSTEM_EXCEPTION,"pay by alipay is fail , fail tradeStatus: {}", tradeStatus);
        }

    }
    
    @Override
    public void alipayMatchScheduleWebHook(String orderNo) {
    	//支付宝支付订单查询
		ResponseResult result= alipayTradeApiService.queryAlipayByOrderNo(orderNo);
		JSONObject alipayResponse = (JSONObject) result.getData();
    	if (AlipayTradeStatus.TRADE_SUCCESS.getStatus().equals(alipayResponse.getString("tradeStatus"))) {
    		// 获取订单号，完成支付
    		Map<String, Object> findMap = Maps.newHashMap();
    		findMap.put("orderNo", orderNo);
    		SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
    		if(!ObjectUtils.isEmpty(subjectTeam)){
    			paySign(subjectTeam,PaymentType.ALIPAY, System.currentTimeMillis());
    		}else{
    			SignRecord signRecord = signRecordService.findOne(findMap);
    			paySign(signRecord, PaymentType.ALIPAY,  System.currentTimeMillis());
    		}
    	} else {
    		logger.debug("pay by alipay is fail , fail tradeStatus: {}", alipayResponse.getString("tradeStatus"));
    	}
    }

    @Override
    public void wxRechargeWebHook(String body) {
        //将xml转换为map
        Map<String, String> responseXml = new HashMap<>();
        try {
            responseXml = XMLUtil.convertToMap(body);
        } catch (Exception e1) {
            logger.debug("wx_webhook prase xml fail ,xml msg:{}", JSON.toJSON(responseXml));
        }

        String returnCode = responseXml.get("return_code");

        if (returnCode != null && TenpayTradeStatus.SUCCESS.getStatus().equals(returnCode)) {
            // wxpay支付时间
            String time_end = responseXml.get("time_end");
            long paymentTime = 0;
            if (StringUtils.isNotEmpty(time_end)) paymentTime = DateUtils.toLong(time_end, Constants.YYYYMMDDHHMMSS);

            //获取商户订单号
            String outTradeNo = responseXml.get("out_trade_no");
            Map<String, Object> findMap = Maps.newHashMap();
            findMap.put("orderNo", outTradeNo);
            SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
            if(!ObjectUtils.isEmpty(subjectTeam)){
                paySign(subjectTeam,PaymentType.TENPAY, paymentTime);
            }else{
                SignRecord signRecord = signRecordService.findOne(findMap);
                paySign(signRecord, PaymentType.TENPAY, paymentTime);
            }
        } else {
            String returnMsg = responseXml.get("return_msg");
            logger.debug("pay by wx is fail , fail msg {}", returnMsg);
            throw new BusinessException(MessageLocale.SYSTEM_EXCEPTION,"pay by wx is fail , fail msg {}",returnMsg);
        }

    }


    /**
     * 修改团队为已支付
     * @param subjectTeam
     * @param paymentType
     * @return
     */
    private SubjectTeam paySign(SubjectTeam subjectTeam, PaymentType paymentType, long paymentTime) {
        ValidateUtils.notNull(subjectTeam, MatchMessageLocale.TEAM_IS_ERROR);
        subjectTeam.setPayment(PaymentStatus.PAID.getStatus());
        if (paymentType != null) subjectTeam.setPaymentType(paymentType.getStatus());
        if (paymentTime > 0) subjectTeam.setPaymentTime(paymentTime);
        subjectTeamService.modify(subjectTeam);
        subjectTeam = subjectTeamService.get(subjectTeam.getId());
        HashMap<String, Object> param = new HashMap<>();
        param.put("subjectId", subjectTeam.getSubjectId());
        param.put("joinUserId", subjectTeam.getId());
        List<SignRecord> signRecords = signRecordService.findBy(param);
        for (SignRecord signRecord : signRecords) {
            signRecord.setPayment(subjectTeam.getPayment());
            signRecord.setPaymentType(subjectTeam.getPaymentType());
            signRecord.setPaymentTime(subjectTeam.getPaymentTime());
            signRecord.setUserId(null);
            signRecordService.modify(signRecord);
        }
        MatchSubject matchSubject = matchSubjectService.get(subjectTeam.getSubjectId());
        resetSignCount(matchSubject);
        MatchInfo matchInfo = matchInfoService.get(matchSubject.getMatchId());
        if(!matchSubject.getSmsNotice()){
	        	JSONObject sms = new JSONObject();
	        	sms.put("mobiles", subjectTeam.getPhone());
	        	sms.put("receiverId", subjectTeam.getId());
	        	sms.put("buzKey", subjectTeam.getSubjectId());
	        	sms.put("tplId", ("09e606dcad1011e986687cd30ac0ab14".equals(matchSubject.getMatchId())) ? "29" : "21");
	        	sms.put("matchName", matchInfo.getMatchName());
	        	sms.put("time", DateUtils.toFullString(matchInfo.getStartTime()) +"-" + DateUtils.toFullString(matchInfo.getEndTime()));
	        	sms.put("address", matchInfo.getCity()+matchInfo.getArea()+matchInfo.getAddress());
	        	mmqProducer.sendMessage(Constants.QUEUE.SMS_SENDING.toString(), sms.toJSONString());
        }
        return subjectTeamService.get(subjectTeam.getId());
    }

    /**
     * 修改个人为已支付
     * @param signRecord
     * @param paymentType
     * @return
     */
    private SignRecord paySign(SignRecord signRecord, PaymentType paymentType, long paymentTime) {
        ValidateUtils.notNull(signRecord, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
		String userId = signRecord.getUserId();
        signRecord.setPayment(PaymentStatus.PAID.getStatus());
        if (paymentType != null) signRecord.setPaymentType(paymentType.getStatus());
        if (paymentTime > 0) signRecord.setPaymentTime(paymentTime);
        signRecord.setUserId(null);
        signRecordService.modify(signRecord);
        MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
        resetSignCount(matchSubject);
        MatchInfo matchInfo = matchInfoService.get(matchSubject.getMatchId());
		if (!"培训部临时用".equals(signRecord.getMatchName())) {
			if (!matchSubject.getSmsNotice()) {
				JSONObject sms = new JSONObject();
				sms.put("mobiles", signRecord.getPhone());
				sms.put("receiverId", signRecord.getId());
				sms.put("buzKey", signRecord.getSubjectId());
				sms.put("tplId", ("09e606dcad1011e986687cd30ac0ab14".equals(matchSubject.getMatchId())) ? "29" : "21");
				sms.put("matchName", matchInfo.getMatchName());
				sms.put("time", DateUtils.toFullString(matchInfo.getStartTime()) + "-" + DateUtils.toFullString(matchInfo.getEndTime()));
				sms.put("address", matchInfo.getCity() + matchInfo.getArea() + matchInfo.getAddress());
				mmqProducer.sendMessage(Constants.QUEUE.SMS_SENDING.toString(), sms.toJSONString());
			}
		}
        //发送积分MQ
        try {
        	JSONObject message = new JSONObject();
        	message.put("userId", userId);
        	message.put("objectId", signRecord.getId());
        	mmqProducer.sendMessage("integral_match_order", message.toJSONString());
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return signRecordService.get(signRecord.getId());
    }

    /**
     * 校验重复报名
     * @param matchSubject
     * @param signRecord
     */
    @SuppressWarnings("rawtypes")
    public boolean checkRepetition(MatchSubject matchSubject, SignRecord signRecord) {
    	if (matchSubject.getType() == SubjectType.SINGLE.getType()){ // 个人赛
    		//判断重复报名
    		Map<String,Object> checkParam = Maps.newHashMap();
    		checkParam.put("subjectId", signRecord.getSubjectId());
    		checkParam.put("name", signRecord.getName());
    		checkParam.put("certificateNo", signRecord.getCertificateNo());
    		checkParam.put("payment", PaymentStatus.PAID.getStatus());
    		List<SignRecord> obj = signRecordService.findBy(checkParam);
    		if(obj.size() != 0){
    			return true;
    		}else{
    			checkParam.put("payment", PaymentStatus.IMPORT.getStatus());
    			obj = signRecordService.findBy(checkParam);
    			if(obj.size() != 0){
    				return true;
        		}
    		}
    	}else if (matchSubject.getType()==SubjectType.TEAM.getType()){ // 团队赛
    		if (StringUtils.isEmpty(signRecord.getJoinUserId())){ // 如果没有团队id
    			HashMap<String, Object> param = Maps.newHashMap();
    			param.put("subjectId",matchSubject.getId());
    			if (ObjectUtils.nullSafeEquals(signRecord.getMemberType(), 1) ) { // 是队长，则新增团队
    				if (signRecord instanceof SignRecordVO){
    					param.put("teamName",((SignRecordVO)signRecord).getTeamName());
    					SubjectTeam subjectTeam = subjectTeamService.findOne(param);
    					ValidateUtils.isTrue(subjectTeam == null, MatchMessageLocale.TEAM_IS_SIGNING);//团队名已存在
    				}else {
    					throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
    				}
    			}else { // 不是队长
    				throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
    			}
    		}else {
    			//判断重复报名
    			Map<String,Object> checkParam = Maps.newHashMap();
    			checkParam.put("subjectId", signRecord.getSubjectId());
    			checkParam.put("joinUserId", signRecord.getJoinUserId());
    			checkParam.put("name", signRecord.getName());
    			checkParam.put("certificateNo", signRecord.getCertificateNo());
    			checkParam.put("payment", PaymentStatus.PAID.getStatus());
    			List<SignRecord> members = signRecordService.findBy(checkParam);
    			if(members.size() != 0){
    				signRecord.setId(members.get(0).getId());
    				return true;
        		}
    		}
    	}
    	return false;
    }
    /**
     * 校验重复报名
     * @param matchSubject
     * @param signRecord
     */
    @SuppressWarnings("rawtypes")
	public void checkDuplicate(MatchSubject matchSubject, SignRecord signRecord) {
    		MatchInfo matchInfo = matchInfoService.get(matchSubject.getMatchId());
        if (matchSubject.getType() == SubjectType.SINGLE.getType()){ // 个人赛
            //判断重复报名
        		if(LimitReg.MATCH_NO_LIMIT.getStatus() != matchInfo.getLimitReg()){
        			Map<String,Object> checkParam = Maps.newHashMap();
        			if(LimitReg.MATCH_ALLOW_ONCE.getStatus() == matchInfo.getLimitReg()){
        				checkParam.put("matchId", matchSubject.getMatchId());
        			}else if(LimitReg.SUBJECT_ALLOW_ONCE.getStatus() == matchInfo.getLimitReg()){
        				checkParam.put("subjectId", matchSubject.getId());
        			}else{
        				return;
        			}
        			checkParam.put("name", signRecord.getName());
        			checkParam.put("certificateNo", signRecord.getCertificateNo());
        			checkParam.put("payment", PaymentStatus.PAID.getStatus());
        			List<SignRecord> obj = signRecordService.findBy(checkParam);
        			ValidateUtils.isTrue(obj.size()==0, MatchMessageLocale.MATCH_IS_SIGNING,"{}重复报名", signRecord.getName());//您已经报名该赛事
        			checkParam.put("payment", PaymentStatus.IMPORT.getStatus());
        			obj = signRecordService.findBy(checkParam);
        			ValidateUtils.isTrue(obj.size()==0, MatchMessageLocale.MATCH_IS_SIGNING,"{}重复导入报名", signRecord.getName());//您已经报名该赛事
        		}
        }else if (matchSubject.getType() == SubjectType.TEAM.getType()){ // 团队赛
        		Map<String,Object> checkParam = Maps.newHashMap();
        		if (StringUtils.isEmpty(signRecord.getJoinUserId())){ // 如果没有团队id
                HashMap<String, Object> param = Maps.newHashMap();
            		param.put("subjectId", matchSubject.getId());
                if (ObjectUtils.nullSafeEquals(signRecord.getMemberType(), 1)) { // 是队长，则新增团队
                    if (signRecord instanceof SignRecordVO){
                        param.put("teamName",((SignRecordVO)signRecord).getTeamName());
                        SubjectTeam subjectTeam = subjectTeamService.findOne(param);
                        ValidateUtils.isTrue(subjectTeam == null, MatchMessageLocale.TEAM_IS_SIGNING);//团队名已存在
                    }else {
                        throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
                    }
                }else { // 不是队长
                    throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
                }
            }else {
                //判断重复报名
            		if(LimitReg.MATCH_NO_LIMIT.getStatus() != matchInfo.getLimitReg()){
            			checkParam.put("joinUserId", signRecord.getJoinUserId());
            			checkParam.put("name", signRecord.getName());
            			checkParam.put("certificateNo", signRecord.getCertificateNo());
            			checkParam.put("payment", PaymentStatus.PAID.getStatus());
            			List<SignRecord> members = signRecordService.findBy(checkParam);
            			ValidateUtils.isTrue(members.size()==0, MatchMessageLocale.MEMBER_IS_DUPLICATE,"{}队员重复报名", signRecord.getName());//队员重复
            		}
            }
			checkParam.put("name", signRecord.getName());
			checkParam.put("certificateNo", signRecord.getCertificateNo());
			checkParam.put("payment", PaymentStatus.PAID.getStatus());
            if(LimitReg.MATCH_ALLOW_ONCE.getStatus() == matchInfo.getLimitReg()){
				checkParam.put("matchId", matchSubject.getMatchId());
			}else if(LimitReg.SUBJECT_ALLOW_ONCE.getStatus() == matchInfo.getLimitReg()){
				checkParam.put("subjectId", matchSubject.getId());
			}else{
				return;
			}
            checkParam.put("joinUserId", null);
			List<SignRecord> members = signRecordService.findBy(checkParam);
			ValidateUtils.isTrue(members.size() == 0, MatchMessageLocale.MATCH_IS_SIGNING,"{}重复报名", signRecord.getName());//队员重复
        }
    }

    @Override
    public SignRecord cancelSign(String recordId) {
        ValidateUtils.notEmpty(recordId, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
        SignRecord signRecord = signRecordService.get(recordId);
        ValidateUtils.isNull(signRecord, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
        if (signRecord.getPayment()==PaymentStatus.PAID.getStatus()){
            // 已支付
            // TODO: 2017/3/29 退款
        }
        signRecord.setReview(2);
        signRecord.setUserId(null);
        signRecordService.modify(signRecord);
        return signRecordService.get(recordId);
    }

    @Transactional
    @Override
    public void deleteSignRecord(String recordId) {
        signRecordFieldTableService.deleteByRecordId(recordId);
        signRecordService.remove(recordId);
    }

    @Override
    public void checkLimit(MatchSubject matchSubject, int addCount) {
        matchSubject = resetSignCount(matchSubject);
        if (addCount + matchSubject.getSignCount() > matchSubject.getMaxNum()) {
            throw new BusinessException(MatchMessageLocale.SUBJECT_SIGN_PLUMP);
        }
    }

    @Override
    public MatchSubject resetSignCount(MatchSubject matchSubject) {
    		Integer shamCount = matchSubject.getShamCount();
        if (matchSubject.getType()==0){ // 个人
            matchSubject.setSignCount(signRecordService.recordSignCount(matchSubject.getId()) + shamCount );
        }else {
            matchSubject.setSignCount(subjectTeamService.teamSignCount(matchSubject.getId()) + shamCount );
        }
        matchSubjectService.modify(matchSubject);
        matchInfoService.setMatchSubjectSignCount(matchSubject.getMatchId());
        return matchSubject;
    }

    @Override
    public Boolean escrowRefund(JSONObject json) {
    	String outTradeNo = json.getString("outTradeNo");
    	String actualAmount = json.getString("actualAmount");
    	String reason = json.getString("reason");
    	if(StringUtils.isEmpty(outTradeNo)){
    		throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR, "参数错误");
    	}else if(StringUtils.isEmpty(actualAmount)){
    		throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR, "参数错误");
    	}
    	if(StringUtils.isEmpty(reason)){
    		reason = "赛事订单退款";
    	}
    	Map<String, Object> param = Maps.newHashMap();
    	param.put("orderNo", outTradeNo);
    	List<SignRecord> signRecordList = signRecordService.findBy(param);
    	if(ObjectUtils.isEmpty(signRecordList)){
    		throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR, "参数错误");
    	}
    	SignRecord signRecord = signRecordList.get(0);
    	MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
    	if(orderEscrowPay.escrowRefund(outTradeNo, outTradeNo, signRecord.getExpenses().toString(), actualAmount, reason)){
    		if(matchSubject.getType() == SubjectType.SINGLE.getType()){
    			signRecord.setPayment(PaymentStatus.REFUND.getStatus());
    			signRecord.setUserId(null);
    			signRecordService.modify(signRecord);
    			resetSignCount(matchSubject);
    		}else if(matchSubject.getType() == SubjectType.TEAM.getType()){
    			for (SignRecord record : signRecordList) {
    				record.setPayment(PaymentStatus.REFUND.getStatus());
    				signRecord.setUserId(null);
        			signRecordService.modify(record);
				}
    			SubjectTeam subjectTeam = subjectTeamService.get(signRecord.getJoinUserId());
    			subjectTeam.setPayment(PaymentStatus.REFUND.getStatus());
    			subjectTeamService.modify(subjectTeam);
    		}
    		return true;
    	}else{
    		return false;
    	}
    }

    @Override
    public SignRecord payOrder(String orderNo, Integer paymentType, Map<String, Object> extras) {
        ValidateUtils.notEmpty(orderNo, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
        // 查询订单
        Map<String, Object> findMap = Maps.newHashMap();
        findMap.put("orderNo", orderNo);
        SignRecord signRecord = signRecordService.findOne(findMap);
        ValidateUtils.notNull(signRecord, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
        if (signRecord.getPayment() != PaymentStatus.PAYABLE.getStatus()){
            throw new BusinessException(OrderMessageLocale.ORDER_IS_NOT_PAYABLE);
        }
        // 校验报名人数
        MatchSubject matchSubjectEmpty = matchSubjectService.get(signRecord.getSubjectId());
        ValidateUtils.notNull(matchSubjectEmpty, MatchMessageLocale.SUBJECT_IS_ERROR);
        checkLimit(matchSubjectEmpty,1);

        SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);

        if (paymentType == PaymentType.MEMBER_CARD.getStatus()){ // 场馆卡支付
            String tokenId = (String) extras.get("tokenId");
            String tenantId = matchSubjectEmpty.getTenantId();
            String cardNo = (String) extras.get("cardNo");
            String memberCategoryId = (String) extras.get("memberCategoryId");
            String memberCardId = (String) extras.get("memberCardId");

            ValidateUtils.notEmpty(cardNo, OrderMessageLocale.MEMBER_CARD_NOT_NULL);//会员卡号不能为空
            ValidateUtils.notEmpty(memberCardId, OrderMessageLocale.MEMBER_CATEGORY_ID_NOT_NULL);//会员ID不能为空
            ValidateUtils.notEmpty(memberCategoryId, OrderMessageLocale.MEMBER_CATEGORY_ID_NOT_NULL);//会员ID不能为空

            CreateTrainOrderVO createTrainOrderVO = new CreateTrainOrderVO();
            createTrainOrderVO.setTokenId(tokenId);
            createTrainOrderVO.setTenantId(tenantId);
            createTrainOrderVO.setOrderType(OrderType.TRAIN.getStatus());
            createTrainOrderVO.setOrderNo(signRecord.getOrderNo());
            createTrainOrderVO.setPaymentType(paymentType);
            createTrainOrderVO.setActualAmount(ObjectUtils.isEmpty(subjectTeam) ?
                    signRecord.getExpenses().longValue() : subjectTeam.getExpenses().longValue());
            createTrainOrderVO.setTenantDisAmount(0L);
            createTrainOrderVO.setCardNo(cardNo);
            createTrainOrderVO.setMemberCardId(memberCardId);
            OrderDetailField orderDetailField = new OrderDetailField();
            orderDetailField.setAmount(createTrainOrderVO.getActualAmount().intValue());
            JSONObject result = orderApiService.createTrainOrder(createTrainOrderVO);
            JSONObject order = result.getJSONObject("order");

            if(!ObjectUtils.isEmpty(subjectTeam)){
                paySign(subjectTeam, PaymentType.getPaymentType(paymentType),  order.getLong("paymentTime"));
                findMap.put("memberType", 1);
                return signRecordService.findOne(findMap);
            }else {
                return paySign(signRecord, PaymentType.getPaymentType(paymentType), order.getLong("paymentTime"));
            }
        }else {
            throw new BusinessException(OrderMessageLocale.ORDER_PAYMENT_TYPE_NOT_EXISTED);
        }
    }
    
    
    public void createMatchNo(PageParam page, JSONObject param){
    	String matchId = param.getString("matchId");
        String subjectId = param.getString("subjectId");
        if(StringUtils.isEmpty(matchId) && StringUtils.isEmpty(subjectId)){
        	throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR);
        }
        String formatLength = param.getString("formatLength");
        if(StringUtils.isEmpty(formatLength)){
        	formatLength = "5";
        }
        String formatHead = param.getString("formatHead");
        if(StringUtils.isEmpty(formatHead)){
        	formatHead = "";
        }
        String numberNo = param.getString("numberNo");
        if(StringUtils.isEmpty(numberNo)){
        	numberNo = "1010";
        }
        Pagination<SignRecord> dataList = signRecordService.queryPage(page, param);
		if(dataList.getPageCount() > BigDecimal.ZERO.intValue()){
			Long matchno = new BigDecimal(numberNo).longValue();
			if(dataList.getPageCount() > BigDecimal.ONE.intValue()){
				for (int i = 1; i <= dataList.getPageCount(); i++) {
					page.setPageNo(i + 1);
					dataList = signRecordService.queryPage(page, param);
					setMatchNo(param, dataList.getDataList(), matchno, formatHead, formatLength);
				}
			}else{
				setMatchNo(param, dataList.getDataList(), matchno, formatHead, formatLength);
			}
		}
    }
    
    public void setMatchNo(JSONObject param, List<SignRecord> dataList, Long matchno, String formatHead, String formatLength){
    	for (SignRecord signRecord : dataList) {
			if(
					PaymentStatus.PAID.getStatus() == signRecord.getPayment()
				||	PaymentStatus.IMPORT.getStatus() == signRecord.getPayment()
				||	PaymentStatus.PAYMENT_LINE.getStatus() == signRecord.getPayment()
			){
				SignRecord existSignRecord = null;
				String newString = null;
				do {
					matchno ++;
					if("4".equals(matchno.toString().substring(matchno.toString().length()-1, matchno.toString().length()))){
						matchno ++;
					}
					newString = formatHead + String.format("%0"+ formatLength +"d", matchno.intValue());  
					param.put("matchNo", newString);
					param.put("matchNoIsNull", null);
					existSignRecord = signRecordService.findOne(param);
				} while (!ObjectUtils.isEmpty(existSignRecord));
				signRecord.setMatchNo(newString);
				signRecord.setUserId(null);
				signRecordService.modify(signRecord);
				MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
				if(Sex.MAN.getStatus() == signRecord.getSex().intValue()){
					matchSubject.setManMatchNoNumber(matchno.intValue());
				}else if(Sex.WOMAN.getStatus() == signRecord.getSex().intValue()){
					matchSubject.setWomanMatchNoNumber(matchno.intValue());
				}
				matchSubjectService.modify(matchSubject);
			}
		}
    }

}
