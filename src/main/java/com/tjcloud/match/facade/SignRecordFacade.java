package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tjcloud.auth.base.entity.AuthUser;
import com.tjcloud.auth.base.service.AuthUserService;
import com.tjcloud.core.Constants;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.exception.ValidationException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.*;
import com.tjcloud.enums.TenantUserType;
import com.tjcloud.match.api.enums.PaymentStatus;
import com.tjcloud.match.api.enums.Sex;
import com.tjcloud.match.api.enums.SubjectType;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.service.SignRecordApiService;
import com.tjcloud.match.api.utils.AlipayService;
import com.tjcloud.match.api.utils.SignRecordFieldUtils;
import com.tjcloud.match.api.utils.Tuple;
import com.tjcloud.match.base.entity.*;
import com.tjcloud.match.base.service.*;
import com.tjcloud.match.base.vo.MatchInfoReport;
import com.tjcloud.match.base.vo.SignRecordVO;
import com.tjcloud.match.base.vo.TeamSignRecordVO;
import com.tjcloud.match.utils.ExcelUtils;
import com.tjcloud.order.api.enums.PaymentType;
import com.tjcloud.order.api.message.OrderMessageLocale;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.entity.User;
import com.tjcloud.uac.base.service.TenantUserService;
import com.tjcloud.uac.base.service.UserService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@RestController
@RequestMapping("/match/signs/record")
public class SignRecordFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(SignRecordFacade.class);

    @Autowired
    private MatchSubjectService matchSubjectService;
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private SubjectTeamService subjectTeamService;
    @Autowired
    private SignRecordFieldTableService signRecordFieldTableService;
    @Autowired
    private UserService userService;
    @Autowired
    private SignRecordApiService signRecordApiService;
    @Autowired
    private TenantUserService tenantUserService;
    @Autowired
    private SubjectSignFieldService subjectSignFieldService;
    @Autowired
    private AuthUserService authUserService;

    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        PageParam page = getPageParam(request);
        JSONObject param = getJSONObject(request);
        logger.debug("~~~~~ get param = {}", JSON.toJSONString(param));
        List<SignRecord> listVO = Lists.newArrayList();
        Pagination<SignRecord> dataList = signRecordService.queryPage(page, param);
        dataList.getDataList().forEach(signRecord -> listVO.add(signRecordApiService.querySignRecord(signRecord.getId())));
        dataList.setDataList(listVO);
        return ResponseResult.getResponse().setData(dataList);
    }
    
    /**
     * ??????????????????
     * @param request
     * @return
     * @throws BusinessException
     */
    @AllowAnonymous
    @GetMapping("/info")
    public ResponseResult info(HttpServletRequest request, HttpServletResponse response) throws BusinessException {
    	PageParam page = getPageParam(request); 
		JSONObject param = getJSONObject(request); 
        String subjectId = param.getString("subjectId");
        ValidateUtils.notEmpty(subjectId, MatchMessageLocale.SUBJECT_IS_ERROR); // ?????????subjectId?????????subject?????????????????????????????????????????????matchId????????????
        MatchSubject matchSubject = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubject, MatchMessageLocale.SUBJECT_IS_ERROR); // ?????????subjectId?????????subject?????????????????????????????????????????????matchId????????????
        Map<String, Object> signFieldParam = Maps.newHashMap();
        signFieldParam.put("subjectId", subjectId);
        List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(signFieldParam);
        // ??????????????????
        ArrayList<String> controlKeys = new ArrayList<>();
        for (SubjectSignField subjectSignField : subjectSignFields) {
            controlKeys.add(subjectSignField.getControlKey());
        }

        param.put("signRecordFieldArray", controlKeys);
        Pagination<Map<String, Object>> dataList = signRecordService.exportSignRecordPage(page, param);
        ValidateUtils.notEmpty(dataList.getDataList(), MatchMessageLocale.DATA_EMPTY);

        // ???????????????
        HashMap<String, SubjectTeam> teamMap = null;
        if (matchSubject.getType() == SubjectType.TEAM.getType()) {
            teamMap = Maps.newHashMap();
            List<SubjectTeam> teams = subjectTeamService.findBy(param);
            for (SubjectTeam team : teams) {
                teamMap.put(team.getId(), team);
            }
        }

        ArrayList<Map<String, Object>> list = new ArrayList<>();

        for (Map<String, Object> stringObjectMap : dataList.getDataList()) {

            if (matchSubject.getType() == SubjectType.TEAM.getType()){
                String certificateNo = stringObjectMap.get("certificateNo").toString(); // ?????????
                String joinUserId = stringObjectMap.get("joinUserId").toString();// ??????ID
                if (joinUserId == null) continue;
                SubjectTeam subjectTeam = teamMap.get(joinUserId);
                if (subjectTeam == null) continue;
                if (StringUtils.equals(subjectTeam.getCertificateNo(), certificateNo)){ // ??????
                } else {
                    stringObjectMap.remove("review");
                    stringObjectMap.remove("orderNo");
                    stringObjectMap.remove("paymentType");
                    stringObjectMap.remove("payment");
                    stringObjectMap.remove("expenses");
                }
                stringObjectMap.put("team", subjectTeam.getTeamName());
            }else { // ?????????
            }
            //????????????(0-?????????,1-??????,2-?????????)
            if (stringObjectMap.containsKey("review")) {
                int review = NumberUtils.toInteger(stringObjectMap.get("review").toString());
                stringObjectMap.put("review", review == 0 ? "?????????" : review == 1 ? "??????" : "?????????");
            }
            // ????????????
            if (stringObjectMap.containsKey("paymentType")) {
                stringObjectMap.put("paymentType", PaymentType.getText(NumberUtils.toInteger(stringObjectMap.get("paymentType").toString())));
            }
            // ????????????
            if (stringObjectMap.containsKey("payment")) {
                stringObjectMap.put("payment", PaymentStatus.getText(NumberUtils.toInteger(stringObjectMap.get("payment").toString())));
            }
            stringObjectMap.put("matchName", matchSubject.getMatchName());
            stringObjectMap.put("subject", matchSubject.getSubject());
            list.add(stringObjectMap);
        }
        dataList.setDataList(list);
        return ResponseResult.getResponse().setData(dataList);
    }

    @AllowAnonymous
    @GetMapping("/team/member")
    public ResponseResult queryTeamMember(HttpServletRequest request) throws BusinessException {
        JSONObject param = getJSONObject(request);
        logger.debug("~~~~~ queryTeamMember param = {}", JSON.toJSONString(param));
        String joinUserId = param.getString("joinUserId");
        if (StringUtils.isEmpty(joinUserId)) {
            throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR);
        }

        SubjectTeam subjectTeam = subjectTeamService.get(joinUserId);
        ValidateUtils.notNull(subjectTeam, MatchMessageLocale.TEAM_IS_ERROR);

        List<SignRecord> signRecords = signRecordService.findBy(param); // ????????????
        List<SignRecordVO<SignRecordFieldTable>> listVO = new ArrayList<>();

        Map<String, Object> paramMap = Maps.newHashMap();

        for (SignRecord signRecord : signRecords) {
            SignRecordVO<SignRecordFieldTable> signRecordVO = new SignRecordVO<>();
            BeanUtils.copyProperties(signRecord, signRecordVO);

            paramMap.put("recordId", signRecord.getId());
            List<SignRecordFieldTable> recordFieldTables = signRecordFieldTableService.findBy(paramMap);
            signRecordVO.setSignRecordInfo(recordFieldTables);
            listVO.add(signRecordVO);
        }

        HashMap<String, Object> result = Maps.newHashMap();
        result.put("membersInfo",listVO);
        result.put("teamInfo",subjectTeam);
        MatchSubject matchSubject = matchSubjectService.get(subjectTeam.getSubjectId());
        result.put("teamNum",(ObjectUtils.isEmpty(matchSubject)) ? 0 : matchSubject.getTeamNum());
        result.put("matchSubject", matchSubject);
        return ResponseResult.getResponse().setData(result);
    }

    @AllowAnonymous
    @GetMapping("/query")
    public ResponseResult query(@PathParam("certificateNo") String certificateNo,
                                @PathParam("phone") String phone, HttpServletRequest request) throws BusinessException {
        PageParam page = getPageParam(request);
        JSONObject param = getJSONObject(request);
        param.put("certificateNo", certificateNo);
        param.put("phone", phone);
        param.put("querySign", true);
        List<SignRecord> listVO = Lists.newArrayList();
        Pagination<SignRecord> dataList = signRecordService.queryPage(page, param);
        dataList.getDataList().forEach(signRecord -> listVO.add(signRecordApiService.querySignRecord(signRecord.getId())));
        dataList.setDataList(listVO);
        return ResponseResult.getResponse().setData(dataList);
    }
    
    @SuppressWarnings("static-access")
	@AllowAnonymous
    @GetMapping("/matchno")
    public ResponseResult matchNo(HttpServletRequest request) throws BusinessException {
    	PageParam page = getPageParam(request);
        JSONObject param = getJSONObject(request);
        logger.debug("~~~~~ matchNo param = {}", JSON.toJSONString(param));
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
					signRecordApiService.setMatchNo(param, dataList.getDataList(), matchno, formatHead, formatLength);
				}
			}else{
				signRecordApiService.setMatchNo(param, dataList.getDataList(), matchno, formatHead, formatLength);
			}
		}
        return ResponseResult.getResponse().ok();
    }
    
    @GetMapping("/self")
    public ResponseResult self(HttpServletRequest request) throws BusinessException {
    	PageParam page = getPageParam(request);
    	JSONObject param = getJSONObject(request);
    	String authId = getCurrentAuthId(request);
    	if (!StringUtils.isEmpty(authId)) {
    		User user = userService.findByAuthId(authId);
    		if (!ObjectUtils.isEmpty(user)) {
    			param.put("userId", user.getId());
    		} else {
    			return ResponseResult.ok();
    		}
    	} else if (StringUtils.isEmpty(authId)) {
    		return ResponseResult.ok();
    	}
    	Integer[] integers = {0, 1, 2};
    	List<Integer> memberTypes = Arrays.asList(integers);
    	param.put("memberTypes", memberTypes);
    	logger.debug("~~~~~~~~~~~~ authId param = {}", JSON.toJSONString(param));
    	List<SignRecord> listVO = Lists.newArrayList();
    	Pagination<SignRecord> dataList = signRecordService.queryPage(page, param);
    	dataList.getDataList().forEach(signRecord -> listVO.add(signRecordApiService.querySignRecord(signRecord.getId())));
    	dataList.setDataList(listVO);
    	
    	return ResponseResult.getResponse().setData(dataList);
    }

    @AllowAnonymous
    @GetMapping("/{id:\\w+}/success")
    public ResponseResult success(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);
        SubjectTeam subjectTeam = subjectTeamService.get(id);
        Map<String, Object> map = Maps.newHashMap();
        if (!ObjectUtils.isEmpty(subjectTeam)) {
            map.put("matchName", matchSubjectService.get(subjectTeam.getSubjectId()).getMatchName());
            map.put("subjectName", subjectTeam.getSubjectName());
            map.put("expenses", subjectTeam.getExpenses());
            map.put("orderNo", subjectTeam.getOrderNo());
            map.put("createdTime", subjectTeam.getCreatedTime());
            map.put("phone", subjectTeam.getPhone());
            map.put("certificateNo", subjectTeam.getCertificateNo());
            return ResponseResult.getResponse().setData(map);
        } else {
            SignRecordVO<SignRecordFieldTable> signRecord = signRecordApiService.querySignRecord(id);
            if (!ObjectUtils.isEmpty(signRecord)) {
                map.put("matchName", signRecord.getMatchName());
                map.put("subjectName", signRecord.getSubjectName());
                map.put("expenses", signRecord.getExpenses());
                map.put("orderNo", signRecord.getOrderNo());
                map.put("createdTime", signRecord.getCreatedTime());
                map.put("phone", signRecord.getPhone());
                map.put("certificateNo", signRecord.getCertificateNo());
            }
        }
        return ResponseResult.getResponse().setData(map);
    }

    @AllowAnonymous
    @GetMapping("/{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);
        return ResponseResult.getResponse().setData(signRecordApiService.querySignRecord(id));
    }

    @AllowAnonymous
    @GetMapping("/by/orderno/{orderNo:\\w+}")
    public ResponseResult getByOrderNo(@PathVariable("orderNo") String orderNo) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", orderNo);
        return ResponseResult.getResponse().setData(signRecordApiService.querySignRecordByOrderNo(orderNo));
    }

    @AllowAnonymous
    @GetMapping("/zjg/paid/{orderNo:\\w+}")
    public ResponseResult paidByOrderNo(@PathVariable("orderNo") String orderNo, @QueryParam("channel") String channel, @QueryParam("time") Long time) throws BusinessException {
        logger.debug("~~~~~ get param id = ({}) channel={}", orderNo, channel);
        PaymentType paymentType = null;
        if (channel != null){
            if (channel.startsWith("wx")) paymentType = PaymentType.TENPAY;
            if (channel.startsWith("alipay")) paymentType = PaymentType.ALIPAY;
        }
        return ResponseResult.getResponse().setData(signRecordApiService.savePaidZJGmatch(orderNo, paymentType, time));
    }

    /**
     * ???????????????????????? ????????????
     * ??????????????? signRecord id
     *
     * @param signRecord
     * @param request
     * @return
     * @throws BusinessException
     */
    @PostMapping("/user")
    public ResponseResult createEnter(@RequestBody SignRecordVO<SignRecordFieldTable> signRecord, HttpServletRequest request) throws BusinessException {
        String authId = getCurrentAuthId(request);
        AuthUser authUser = authUserService.get(authId);
        ValidateUtils.isFalse(authUser.isLocked(), MessageLocale.EMPTY_CODE, "?????????????????????");
        return save(signRecord, request);
    }

    /**
     * ???????????????????????? ????????????
     * ??????????????? signRecord id
     *
     * @param signRecord
     * @param request
     * @return
     * @throws BusinessException
     */
    @AllowAnonymous
    @PostMapping
    public ResponseResult create(@RequestBody SignRecordVO<SignRecordFieldTable> signRecord, HttpServletRequest request) throws BusinessException {
        return save(signRecord, request);
    }
    /**
     * ???????????????????????? ????????????
     * ??????????????? signRecord id
     *
     * @param signRecord
     * @param request
     * @return
     * @throws BusinessException
     */
    @PostMapping("/teamsign")
    public ResponseResult teamsign(@RequestBody TeamSignRecordVO teamSignRecord, HttpServletRequest request) throws BusinessException {
    		 SignRecordVO<SignRecordFieldTable> signRecord = teamSignRecord.getHeadman();
	    	 List<SignRecordVO<SignRecordFieldTable>> teamMember = teamSignRecord.getTeamMember();
	    	 logger.debug("~~~~~ post param = {}", JSON.toJSONString(signRecord));
         ValidateUtils.notNull(signRecord, MessageLocale.NOT_NULL);
         ValidateUtils.notNull(teamMember, MessageLocale.NOT_NULL);
         ValidateUtils.notEmpty(signRecord.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
         ValidateUtils.notEmpty(signRecord.getTeamName(), MatchMessageLocale.TEAM_NAME_EMPTY);
         MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
         if (ObjectUtils.isEmpty(matchSubject))
             throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);

         if (matchSubject.getType() != SubjectType.TEAM.getType())  // ??????????????????????????????????????????
             throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);

         signRecord.setMemberType(1);// ??????
         signRecord.setSubjectName(matchSubject.getSubject());
         signRecord.setMatchId(matchSubject.getMatchId());
         signRecord.setExpenses(matchSubject.getExpenses());
         signRecord.setMatchName(matchSubject.getMatchName());
         signRecord.setTenantId(matchSubject.getTenantId());
         String authId = getCurrentAuthId(request);
         if (!StringUtils.isEmpty(authId)) {
	        	 User user = userService.findByAuthId(authId);
	        	 if (!ObjectUtils.isEmpty(user)) {
	        		 signRecord.setUserId(user.getId());
	        	 }
         }
         //??????
         for (SignRecordVO<SignRecordFieldTable> signRecordVO : teamMember) {
	        	 signRecordVO.setSubjectName(matchSubject.getSubject());
	        	 signRecordVO.setMatchId(matchSubject.getMatchId());
	        	 signRecordVO.setExpenses(matchSubject.getExpenses());
	        	 signRecordVO.setMatchName(matchSubject.getMatchName());
	        	 signRecordVO.setTenantId(matchSubject.getTenantId());
	        	 signRecordVO.setUserId(signRecord.getId());
		 }
         //??????????????????????????????
         if(matchSubject.getTeamNumMin() > BigDecimal.ZERO.intValue()){
	        	 if(teamMember.size() < matchSubject.getTeamNumMin()-1){
	        		 throw new BusinessException(MessageLocale.EMPTY_CODE, "???????????????????????????????????????????????????????????????" + matchSubject.getTeamNumMin() + "???");
	        	 }
         }
         //??????????????????????????????
         if(matchSubject.getTeamNum() > BigDecimal.ZERO.intValue()){
	        	 if(teamMember.size() > matchSubject.getTeamNum()-1){
	        		 throw new BusinessException(MessageLocale.EMPTY_CODE, "???????????????????????????????????????????????????????????????" + matchSubject.getTeamNum() + "???");
	        	 }
         }
    	 	return ResponseResult.getResponse().setData(signRecordApiService.saveTeamsign(teamSignRecord));
    }
    
    /**
     * ???????????????????????? ????????????
     * ??????????????? signRecord id
     *
     * @param signRecord
     * @param request
     * @return
     * @throws BusinessException
     */
    @AllowAnonymous
    @PostMapping("/web/teamsign")
    public ResponseResult webTeamsign(@RequestBody TeamSignRecordVO teamSignRecord, HttpServletRequest request) throws BusinessException {
    	SignRecordVO<SignRecordFieldTable> signRecord = teamSignRecord.getHeadman();
    	List<SignRecordVO<SignRecordFieldTable>> teamMember = teamSignRecord.getTeamMember();
    	logger.debug("~~~~~ post param = {}", JSON.toJSONString(signRecord));
    	ValidateUtils.notNull(signRecord, MessageLocale.NOT_NULL);
    	ValidateUtils.notNull(teamMember, MessageLocale.NOT_NULL);
    	ValidateUtils.notEmpty(signRecord.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
    	ValidateUtils.notEmpty(signRecord.getTeamName(), MatchMessageLocale.TEAM_NAME_EMPTY);
    	MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
    	if (ObjectUtils.isEmpty(matchSubject))
    		throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
    	
    	if (matchSubject.getType() != SubjectType.TEAM.getType()) { // ??????????????????????????????????????????
    		throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
    	}
    	signRecord.setMemberType(1);// ??????
    	signRecord.setSubjectName(matchSubject.getSubject());
    	signRecord.setMatchId(matchSubject.getMatchId());
    	signRecord.setExpenses(matchSubject.getExpenses());
    	signRecord.setMatchName(matchSubject.getMatchName());
    	signRecord.setTenantId(matchSubject.getTenantId());
//    	String authId = getCurrentAuthId(request);
//    	if (!StringUtils.isEmpty(authId)) {
//    		User user = userService.findByAuthId(authId);
//    		if (!ObjectUtils.isEmpty(user)) {
//    			signRecord.setUserId(user.getId());
//    		}
//    	}
    	//??????
    	for (SignRecordVO<SignRecordFieldTable> signRecordVO : teamMember) {
    		signRecordVO.setSubjectName(matchSubject.getSubject());
    		signRecordVO.setMatchId(matchSubject.getMatchId());
    		signRecordVO.setExpenses(matchSubject.getExpenses());
    		signRecordVO.setMatchName(matchSubject.getMatchName());
    		signRecordVO.setTenantId(matchSubject.getTenantId());
    		signRecordVO.setUserId(signRecord.getId());
    	}
    	//??????????????????????????????
    	if(matchSubject.getTeamNumMin() > BigDecimal.ZERO.intValue()){
    		if(teamMember.size() < matchSubject.getTeamNumMin()-1){
    			throw new BusinessException(MessageLocale.EMPTY_CODE, "???????????????????????????????????????????????????????????????" + matchSubject.getTeamNumMin() + "???");
    		}
    	}
    	//??????????????????????????????
    	if(matchSubject.getTeamNum() > BigDecimal.ZERO.intValue()){
    		if(teamMember.size() > matchSubject.getTeamNum()-1){
    			throw new BusinessException(MessageLocale.EMPTY_CODE, "???????????????????????????????????????????????????????????????" + matchSubject.getTeamNum() + "???");
    		}
    	}
    	return ResponseResult.getResponse().setData(signRecordApiService.saveTeamsign(teamSignRecord));
    }

    private ResponseResult save(SignRecordVO<SignRecordFieldTable> signRecord, HttpServletRequest request) {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(signRecord));
        ValidateUtils.notNull(signRecord, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(signRecord.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
        MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
        if (ObjectUtils.isEmpty(matchSubject))
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);

        if (matchSubject.getType() != SubjectType.SINGLE.getType()) { // ??????????????????
            SubjectTeam subjectTeam;
            if (StringUtils.isEmpty(signRecord.getJoinUserId()) // ??????????????????????????????ID
                    || ObjectUtils.isEmpty(subjectTeam = subjectTeamService.get(signRecord.getJoinUserId()))) {
                throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
            } else if (!StringUtils.equals(subjectTeam.getSubjectId(), signRecord.getSubjectId())) {// ???????????????????????????
                throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
            }
        }

        signRecord.setSubjectName(matchSubject.getSubject());
        signRecord.setMatchId(matchSubject.getMatchId());
        signRecord.setExpenses(matchSubject.getExpenses());
        signRecord.setMatchName(matchSubject.getMatchName());
        signRecord.setTenantId(matchSubject.getTenantId());
        String authId = getCurrentAuthId(request);
        if (!signRecord.isManageUser().booleanValue() && !StringUtils.isEmpty(authId)) {
            User user = userService.findByAuthId(authId);
            if (!ObjectUtils.isEmpty(user)) {
                signRecord.setUserId(user.getId());
            }
        }
        signRecord = signRecordApiService.saveSignRecord(signRecord);

        return ResponseResult.getResponse().setData(signRecord);
    }

    /**
     * ???????????????????????? ????????????
     * ??????????????? signRecord id
     *
     * @param signRecord
     * @param request
     * @return
     * @throws BusinessException
     */
    @AllowAnonymous
    @PostMapping("/web")
    public ResponseResult update(@RequestBody SignRecord signRecord, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(signRecord));
        ValidateUtils.notNull(signRecord, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(signRecord.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
        //??????ID???????????????????????????????????????????????????
        SignRecord signRecordEmpty = signRecordService.get(signRecord.getId());
        //????????????ID
        if (ObjectUtils.isEmpty(signRecordEmpty)) {
            throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR);//????????????
        } else {
            if (StringUtils.isNotEmpty(signRecord.getName())) {
                signRecordEmpty.setName(signRecord.getName());
            }
            if (!ObjectUtils.isEmpty(signRecord.getSex())) {
                signRecordEmpty.setSex(signRecord.getSex());
            }
            if (StringUtils.isNotEmpty(signRecord.getCertificateNo())) {
                signRecordEmpty.setCertificateNo(signRecord.getCertificateNo());
            }
            if (StringUtils.isNotEmpty(signRecord.getPhone())) {
                signRecordEmpty.setPhone(signRecord.getPhone());
            }
            signRecordService.modify(signRecordEmpty);
            signRecord = signRecordEmpty;
        }
        return ResponseResult.getResponse().setData(signRecord);
    }


    /**
     * ??????????????????
     * @param request
     * @param matchId
     * @return
     * @throws BusinessException
     */
    @GetMapping("/myrecord")
    public ResponseResult myRecord(HttpServletRequest request, @PathParam("matchId") String matchId) throws BusinessException {
        String authId = getCurrentAuthId(request);
        ValidateUtils.isTrue(StringUtils.isNotEmpty(authId), MessageLocale.EMPTY_CODE, "authId??????");
        User user = userService.findByAuthId(authId);
        Map<String, Object> param = Maps.newHashMap();
        param.put("userId", user.getId());
        param.put("matchId", matchId);
        List<SignRecord> dataList = signRecordService.findBy(param);
        ValidateUtils.isFalse(ObjectUtils.isEmpty(dataList), MessageLocale.EMPTY_CODE, "??????????????????");
        return ResponseResult.getResponse().setData(dataList.subList(0, dataList.size() > 5 ? 5 : dataList.size()));
    }
    /**
     * ???????????? ?????????/????????????
     * @param id
     * @param request
     * @return
     * @throws BusinessException
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult remove(@PathVariable("id") String id, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
        ValidateUtils.notEmpty(id, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
        SignRecord signRecord = signRecordService.get(id);
        ValidateUtils.notNull(signRecord, MatchMessageLocale.SIGN_RECORD_IS_ERROR);

        String authId = getCurrentAuthId(request);
        if (!StringUtils.isEmpty(authId)) {
            TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
            if (ObjectUtils.isEmpty(tenantUser)) {
                return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
            } else {
                //?????????????????????tenantId????????????????????????
                ValidateUtils.isTrue(StringUtils.equals(signRecord.getTenantId(), tenantUser.getTenantId()), MessageLocale.INVALID_ACCESS_TOKEN_ALLOW_TO_THE_URI);
            }
        }
        // ????????????????????????????????????0????????????
        ValidateUtils.isTrue(signRecord.getPayment()== PaymentStatus.PAYABLE.getStatus() || signRecord.getExpenses() <= 0, MatchMessageLocale.MATCH_SIGN_CANT_DELETE);

        // ??????????????????????????????
        if ( StringUtils.isNotEmpty(signRecord.getJoinUserId())){
            SubjectTeam subjectTeam = subjectTeamService.get(signRecord.getJoinUserId());
            String certificateNo = subjectTeam.getCertificateNo();// ???????????????
            ValidateUtils.isTrue(!StringUtils.equals(certificateNo, signRecord.getCertificateNo()), MatchMessageLocale.CAPTAIN_CANT_DELETE);
            signRecordApiService.deleteSignRecord(id);

            // ????????????
            HashMap<String, Object> param = new HashMap<>();
            param.put("joinUserId",signRecord.getJoinUserId());
            int size = signRecordService.findBy(param).size();
            subjectTeam.setTeamNum(size);
            subjectTeamService.modify(subjectTeam);
        }else {
            signRecordApiService.deleteSignRecord(id);
        }

        String subjectId = signRecord.getSubjectId();
        signRecordApiService.resetSignCount(matchSubjectService.get(subjectId));
        return ResponseResult.ok();
    }

    /**
     * ??????signRecord id????????????
     *
     * @param cancelIds
     * @return
     */
    @PostMapping("cancelSigns")
    public ResponseResult cancelSigns(@RequestBody Map<String, HashSet<String>> cancelIds) throws BusinessException {
        Set<String> ids = cancelIds.get("recordIds");
        ValidateUtils.notEmpty(ids, MessageLocale.NOT_EMPTY);
        ArrayList<SignRecord> signRecords = new ArrayList<>();

        for (String recordId : ids) {
            if (!StringUtils.isEmpty(recordId)) {
                SignRecord signRecord = null;
                try {
                    signRecord = signRecordApiService.cancelSign(recordId);
                } catch (ValidationException ignored) {
                }
                if (null != signRecord) signRecords.add(signRecord);
            }
        }
        return ResponseResult.getResponse().setData(signRecords);
    }

    /**
     * ??????????????????
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    @GetMapping("/exportExcel")
    public ResponseResult exportExcel(HttpServletRequest request, HttpServletResponse response) throws BusinessException {
        JSONObject param = getJSONObject(request);
        String subjectId = param.getString("subjectId");
        ValidateUtils.notEmpty(subjectId, MatchMessageLocale.SUBJECT_IS_ERROR); // ?????????subjectId?????????subject?????????????????????????????????????????????matchId????????????
        MatchSubject matchSubject = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubject, MatchMessageLocale.SUBJECT_IS_ERROR); // ?????????subjectId?????????subject?????????????????????????????????????????????matchId????????????

        List<Tuple<String, String>> relation = new ArrayList<>(); // ????????????????????????

        Map<String, Object> signFieldParam = Maps.newHashMap();
        signFieldParam.put("subjectId", subjectId);
        List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(signFieldParam);
        subjectSignFields.forEach(new Consumer<SubjectSignField>() {
            @Override
            public void accept(SubjectSignField subjectSignField) {
                // ?????? ???????????????
                if (subjectSignField.getState() != 0) {
                    relation.add(new Tuple<>(subjectSignField.getControlKey(), subjectSignField.getComment()));
                }
            }
        });
//        relation.add(new Tuple<>("matchNo", "????????????"));
        relation.add(new Tuple<>("review", "????????????"));
        relation.add(new Tuple<>("orderNo", "?????????"));
        relation.add(new Tuple<>("paymentType", "????????????"));
        relation.add(new Tuple<>("payment", "????????????"));
        relation.add(new Tuple<>("expenses", "??????(??????:???)"));

        // ??????????????????
        ArrayList<String> controlKeys = new ArrayList<>();
        for (SubjectSignField subjectSignField : subjectSignFields) {
            controlKeys.add(subjectSignField.getControlKey());
        }

        param.put("signRecordFieldArray", controlKeys);
        List<Map<String, Object>> dataList = signRecordService.exportSignRecord(param);
        ValidateUtils.notEmpty(dataList, MatchMessageLocale.DATA_EMPTY);

        // ???????????????
        HashMap<String, SubjectTeam> teamMap = null;
        if (matchSubject.getType() == SubjectType.TEAM.getType()) {
            teamMap = Maps.newHashMap();
            List<SubjectTeam> teams = subjectTeamService.findBy(param);
            for (SubjectTeam team : teams) {
                teamMap.put(team.getId(), team);
            }
            relation.add(0, new Tuple<>("team", "????????????"));
        }

        ArrayList<Map<String, Object>> list = new ArrayList<>();

        for (Map<String, Object> stringObjectMap : dataList) {

            if (matchSubject.getType() == SubjectType.TEAM.getType()){
                String certificateNo = stringObjectMap.get("certificateNo").toString(); // ?????????
                String joinUserId = stringObjectMap.get("joinUserId").toString();// ??????ID
                if (joinUserId == null) continue;
                SubjectTeam subjectTeam = teamMap.get(joinUserId);
                if (subjectTeam == null) continue;
                if (StringUtils.equals(subjectTeam.getCertificateNo(), certificateNo)){ // ??????
                		stringObjectMap.put("sf734362", stringObjectMap.get("sf734362") + "(??????)");
                } else {
                    stringObjectMap.remove("review");
                    stringObjectMap.remove("orderNo");
                    stringObjectMap.remove("paymentType");
                    stringObjectMap.remove("payment");
                    stringObjectMap.remove("expenses");
                }
                stringObjectMap.put("team", subjectTeam.getTeamName());
            }else { // ?????????
            }
            //????????????(0-?????????,1-??????,2-?????????)
            if (stringObjectMap.containsKey("review")) {
                int review = NumberUtils.toInteger(stringObjectMap.get("review").toString());
                stringObjectMap.put("review", review == 0 ? "?????????" : review == 1 ? "??????" : "?????????");
            }
            // ????????????
            if (stringObjectMap.containsKey("paymentType")) {
                stringObjectMap.put("paymentType", PaymentType.getText(NumberUtils.toInteger(stringObjectMap.get("paymentType").toString())));
            }
            // ????????????
            if (stringObjectMap.containsKey("payment")) {
                stringObjectMap.put("payment", PaymentStatus.getText(NumberUtils.toInteger(stringObjectMap.get("payment").toString())));
            }

            list.add(stringObjectMap);
        }

        try {
            ExcelUtils.excelExport(list, relation, matchSubject.getSubject() + "????????????????????????", response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(MatchMessageLocale.EXCEL_INFO_IS_ERROR);
        }
        return ResponseResult.ok();
    }

    /**
     * ??????????????????
     * <p>
     * //     * @param file
     * //     * @param subjectId
     *
     * @return
     * @throws Exception
     */
    @Transactional
    @PostMapping("/importExcel")
    public ResponseResult modifyImportExcel(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws Exception {
        ValidateUtils.notNull(file, MessageLocale.NOT_NULL);
        JSONObject param = getJSONObject(request);
        String subjectId = param.getString("subjectId");// ??????ID
        String joinUserId = param.getString("joinUserId"); // ??????ID
        ValidateUtils.notEmpty(subjectId, MatchMessageLocale.SUBJECT_IS_ERROR);
        MatchSubject matchSubject = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubject, MatchMessageLocale.SUBJECT_IS_ERROR);

        SubjectTeam subjectTeam = null;
        if (matchSubject.getType() == SubjectType.TEAM.getType()) { // ???????????????
            if (StringUtils.isEmpty(joinUserId) // ??????????????????????????????ID
                    || ObjectUtils.isEmpty(subjectTeam = subjectTeamService.get(joinUserId))) {
                throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
            } else if (StringUtils.equals(subjectTeam.getSubjectId(), subjectId)) {// ???????????????????????????
                throw new BusinessException(MatchMessageLocale.TEAM_IS_ERROR);
            }
        }

        String authId = getCurrentAuthId(request);
        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        if (ObjectUtils.isEmpty(tenantUser))
            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);

        // ??????????????????
        Map<Tuple<String, String>, Integer> relation = new HashMap<>();

        Map<String, Object> signFieldParam = Maps.newHashMap();
        signFieldParam.put("subjectId", subjectId);
        List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(signFieldParam);
        subjectSignFields.forEach(new Consumer<SubjectSignField>() {
            @Override
            public void accept(SubjectSignField subjectSignField) {
                // ?????? ???????????????
                if (subjectSignField.getState() != 0) {
                    relation.put(new Tuple<>(subjectSignField.getControlKey(), subjectSignField.getComment()), subjectSignField.getState());
                }
            }
        });

        logger.debug("~~~~~ relation param ~~~~~{}", JSONObject.toJSONString(relation));

        Tuple<List<JSONObject>, List<String>> result = ExcelUtils.resolveExcel(file, -1, relation);
        if (result.value.size() > 0) {
            return ResponseResult.ok().setData(result.value);
        }
//        if (matchSubject.getType() == SubjectType.SINGLE.getType()) // ?????????????????????????????????
//            signRecordApiService.checkLimit(matchSubject, result.key.size());

        for (JSONObject jsonObject : result.key) {

            String name = jsonObject.getString(SignRecordFieldUtils.nameControlKey);
            String phone = jsonObject.getString(SignRecordFieldUtils.phoneControlKey);
            String certificateNo = jsonObject.getString(SignRecordFieldUtils.cerControlKey);
            String matchNo = jsonObject.getString(SignRecordFieldUtils.matchNoControlKey);
            Integer gradeNo = jsonObject.getInteger(SignRecordFieldUtils.gradeNoControlKey);
            String sex = jsonObject.getString(SignRecordFieldUtils.sexControlKey);

            SignRecord signRecord = new SignRecord();

            signRecord.setTenantId(matchSubject.getTenantId());//??????Id
            signRecord.setMatchId(matchSubject.getMatchId());//??????Id
            signRecord.setMatchName(matchSubject.getMatchName());//????????????
            signRecord.setSubjectId(subjectId);//??????ID
            signRecord.setSubjectName(matchSubject.getSubject());//????????????
            if (matchSubject.getType() != SubjectType.SINGLE.getType()) signRecord.setJoinUserId(joinUserId); // ??????ID

            signRecord.setName(name);                                    // ??????
            signRecord.setSex(Sex.WOMAN.getText().equals(sex) ? 0 : 1);  // ??????
            signRecord.setPhone(phone);                                  // ?????????
            signRecord.setCertificateNo(certificateNo);                  // ????????????
            signRecord.setMatchNo(matchNo);								 // ????????????
            signRecord.setGradeNo(gradeNo);							 	 // ??????
            
            if (matchSubject.getType() == SubjectType.TEAM.getType()) { // ?????????????????????
                signRecord.setPayment(subjectTeam.getPayment());
                signRecord.setPaymentType(subjectTeam.getPaymentType());
                signRecord.setPaymentTime(subjectTeam.getPaymentTime());
            }else {
                signRecord.setPayment(PaymentStatus.IMPORT.getStatus());     // ????????????
                signRecord.setPaymentTime(System.currentTimeMillis());
                signRecord.setPaymentType(PaymentType.CASH.getStatus());
            }
            signRecord.setReview(1);                                     // ????????????(0-?????????,1-??????,2-?????????)
            signRecord.setAvailable(1);                                  // ????????????
            
            // ??????????????????
            if(signRecordApiService.checkRepetition(matchSubject, signRecord)){
            	Map<String,Object> checkParam = Maps.newHashMap();
        		checkParam.put("subjectId", signRecord.getSubjectId());
        		checkParam.put("name", signRecord.getName());
        		checkParam.put("certificateNo", signRecord.getCertificateNo());
        		checkParam.put("payment", PaymentStatus.PAID.getStatus());
        		List<SignRecord> signRecordEmpty = signRecordService.findBy(checkParam);
        		if(ObjectUtils.isEmpty(signRecordEmpty)){
        			checkParam.put("payment", PaymentStatus.IMPORT.getStatus());
        			signRecordEmpty = signRecordService.findBy(checkParam);
        		}
        		logger.debug("~~~~~ signRecordService modify ~~~~~{}", JSONObject.toJSONString(checkParam));
        		logger.debug("~~~~~ signRecordService modify ~~~~~{}", JSONObject.toJSONString(signRecordEmpty));
            	signRecord.setPayment(null);     // ????????????
                signRecord.setPaymentTime(null);
                signRecord.setPaymentType(null);
                signRecord.setId(signRecordEmpty.get(0).getId());
            	signRecordService.modify(signRecord);
            	// ????????????????????????????????????????????????
                relation.forEach(new BiConsumer<Tuple<String, String>, Integer>() {
                    @Override
                    public void accept(Tuple<String, String> tuple, Integer integer) {
                        SignRecordFieldTable table = new SignRecordFieldTable();
                        table.setRecordId(signRecord.getId());
                        table.setComment(tuple.value);
                        table.setControlKey(tuple.key);
                        table.setValue(jsonObject.getString(tuple.key));
                        Map<String, Object> signRecordFieldTableParam = Maps.newHashMap();
                        signRecordFieldTableParam.put("recordId", signRecord.getId());
                        signRecordFieldTableParam.put("controlKey", tuple.key);
                        SignRecordFieldTable signRecordFieldTableEmpty = signRecordFieldTableService.findOne(signRecordFieldTableParam);
                        if(ObjectUtils.isEmpty(signRecordFieldTableEmpty)){
                        	signRecordFieldTableService.create(table);
                        }else{
                        	table.setId(signRecordFieldTableEmpty.getId());
                        	signRecordFieldTableService.modify(table);
                        }
                    }
                });
            	continue;
            }
            // ??????????????????
            SignRecord record = signRecordService.create(signRecord);
            // ????????????????????????????????????????????????
            relation.forEach(new BiConsumer<Tuple<String, String>, Integer>() {
                @Override
                public void accept(Tuple<String, String> tuple, Integer integer) {
                    SignRecordFieldTable table = new SignRecordFieldTable();
                    table.setRecordId(record.getId());
                    table.setComment(tuple.value);
                    table.setControlKey(tuple.key);
                    table.setValue(jsonObject.getString(tuple.key));

                    signRecordFieldTableService.create(table);
                }
            });
        }

        // ???????????????
        signRecordApiService.resetSignCount(matchSubject);
        return ResponseResult.ok();
    }

    /**
     * ???????????????????????????????????????
     *
     * @param request
     */
    @AllowAnonymous
    @GetMapping(value = "/pay/alipay/web/return")
    public String doReturn(HttpServletRequest request) throws Exception {
        JSONObject requestParams = getJSONObject(request);
        logger.debug("~~~~~ alipayEscrow param paramRequest = ({})", JSONObject.toJSONString(requestParams));
        Validate.notNull(requestParams, "can't do return, resquestparams is null");
        return signRecordApiService.alipayEscrowReturn(requestParams);
    }

    /**
     * ??????????????????
     * @param orderNo
     * @param paymentType
     * @param request
     * @return
     */
    @PutMapping("/{orderNo:\\w+}/pay/{paymentType:\\d+}")
    public ResponseResult payOrder(@PathVariable String orderNo,
                                   @PathVariable Integer paymentType,
                                   HttpServletRequest request) throws BusinessException{
        logger.debug("~~~~~ param paymentType={}}", paymentType);
        if(paymentType == PaymentType.MEMBER_CARD.getStatus()) {
            // TODO: 2017/7/11 ??????????????????????????? ???????????????
            String authId = getCurrentAuthId(request);
            ValidateUtils.notEmpty(authId, UserMessageLocale.USER_NOT_ENTER);
            User user = userService.findByAuthId(authId);
            ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_ENTER);
            ValidateUtils.notEmpty(user.getId(), UserMessageLocale.USER_NOT_ENTER);

            Map<String, Object> params = getParameterMap(request);
            params.put("userId", user.getId());
            params.put("tokenId", getCurrentTokenId(request));
            logger.debug("~~~~~ param paramRequest = ({})", JSONObject.toJSONString(params));
            return ResponseResult.ok().setData(signRecordApiService.payOrder(orderNo, paymentType, params));
        }else {
            throw new BusinessException(OrderMessageLocale.ORDER_PAYMENT_TYPE_NOT_EXISTED);
        }
    }

    /**
     * ?????????????????????
     *
     * @param request
     * @return
     * @throws IOException
     */
    @AllowAnonymous
    @GetMapping(value = "/pay/alipay/web")
    public void payUrl(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        JSONObject paramRequest = getJSONObject(request);
        logger.debug("~~~~~ alipayEscrow param paramRequest = ({})", JSONObject.toJSONString(paramRequest));
        BigDecimal pay_amount = new BigDecimal(0);
        String outTradeNo = paramRequest.getString("outTradeNo");
        Map<String, Object> findMap = Maps.newHashMap();
        findMap.put("orderNo", outTradeNo);
        SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
//        if (ObjectUtils.isEmpty(subjectTeam)) {
//            SignRecord signRecord = signRecordService.findOne(findMap);
//            pay_amount = new BigDecimal(signRecord.getExpenses());
//        } else {
//            pay_amount = new BigDecimal(subjectTeam.getExpenses());
//        }

        String subjectId;
        if (ObjectUtils.isEmpty(subjectTeam)) {
            SignRecord signRecord = signRecordService.findOne(findMap);
            pay_amount = new BigDecimal(signRecord.getExpenses());
            subjectId = signRecord.getSubjectId();
        } else {
            pay_amount = new BigDecimal(subjectTeam.getExpenses());
            subjectId = subjectTeam.getSubjectId();
        }
        // ??????????????????
        MatchSubject matchSubjectEmpty = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubjectEmpty, MatchMessageLocale.SUBJECT_IS_ERROR);
        signRecordApiService.checkLimit(matchSubjectEmpty,1);

        String subject = paramRequest.getString("subject");
        String body = paramRequest.getString("body");
        pay_amount = pay_amount.divide(new BigDecimal(100));
        String notifyUrl = paramRequest.getString("notifyUrl");
        String returnUrl = paramRequest.getString("returnUrl");

        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("payment_type", "1");
        sParaTemp.put("out_trade_no", outTradeNo);
        sParaTemp.put("subject", subject);
        sParaTemp.put("body", body);
        sParaTemp.put("total_fee", pay_amount.toString());
        sParaTemp.put("return_url", returnUrl);
        sParaTemp.put("notify_url", notifyUrl);
//        sParaTemp.put("show_url", show_url);
        // ???????????????????????????URL
        String sHtmlText = AlipayService.create_direct_pay_by_user(sParaTemp);
        response.setCharacterEncoding("UTF-8");                // ??????????????????
        response.setContentType("text/html");                    // ??????????????????
        PrintWriter out = response.getWriter();                // ??????????????????
        out.print(sHtmlText);                                    // ???json??????????????????
        out.flush();
    }

    /**
     * ????????????????????????
     */
    @AllowAnonymous
    @PostMapping("/pay/alipay")
    public ResponseResult alipayEscrow(@RequestBody Map<String, String> paramRequest) {
        logger.debug("~~~~~ alipayEscrow param paramRequest = ({})", JSONObject.toJSONString(paramRequest));
        String outTradeNo = paramRequest.get("outTradeNo");
        Map<String, Object> findMap = Maps.newHashMap();
        findMap.put("orderNo", outTradeNo);
        BigDecimal pay_amount = new BigDecimal(0);
        SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
        String subjectId;
        if (ObjectUtils.isEmpty(subjectTeam)) {
            SignRecord signRecord = signRecordService.findOne(findMap);
            pay_amount = new BigDecimal(signRecord.getExpenses());
            subjectId = signRecord.getSubjectId();
        } else {
            pay_amount = new BigDecimal(subjectTeam.getExpenses());
            subjectId = subjectTeam.getSubjectId();
        }
        // ??????????????????
        MatchSubject matchSubjectEmpty = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubjectEmpty, MatchMessageLocale.SUBJECT_IS_ERROR);
        signRecordApiService.checkLimit(matchSubjectEmpty,1);

        String subject = paramRequest.get("subject");
        String body = paramRequest.get("body");
        String amount = pay_amount.toString();
        String notifyUrl = paramRequest.get("notifyUrl");
        String method = paramRequest.get("method");
        String returnUrl = paramRequest.get("returnUrl");
        return signRecordApiService.alipayEscrow(outTradeNo, subject, body, amount, notifyUrl, method, returnUrl);
    }

    /**
     * ?????????????????????
     */
    @AllowAnonymous
    @PostMapping("/pay/tenpay")
    public ResponseResult tenpayEscrow(@RequestBody Map<String, String> paramRequest, HttpServletRequest request) {
        logger.debug("~~~~~ tenpayEscrow param paramRequest = ({})", JSONObject.toJSONString(paramRequest));
        String outTradeNo = paramRequest.get("outTradeNo");
        String tenantId = paramRequest.get("tenantId");
        Map<String, Object> findMap = Maps.newHashMap();
        findMap.put("orderNo", outTradeNo);
        BigDecimal pay_amount = new BigDecimal(0);
        SubjectTeam subjectTeam = subjectTeamService.findOne(findMap);
        String subjectId;
        if (ObjectUtils.isEmpty(subjectTeam)) {
            SignRecord signRecord = signRecordService.findOne(findMap);
            pay_amount = new BigDecimal(signRecord.getExpenses());
            subjectId = signRecord.getSubjectId();
        } else {
            pay_amount = new BigDecimal(subjectTeam.getExpenses());
            subjectId = subjectTeam.getSubjectId();
        }
        // ??????????????????
        MatchSubject matchSubjectEmpty = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubjectEmpty, MatchMessageLocale.SUBJECT_IS_ERROR);
        signRecordApiService.checkLimit(matchSubjectEmpty,1);

        String body = paramRequest.get("body");
        String notifyUrl = paramRequest.get("notifyUrl");
        String tradeType = paramRequest.get("tradeType");
        String opentId = paramRequest.get("opentId");
        String spbillIp = paramRequest.get("spbillIp");
        String source = paramRequest.get("source");
        if (StringUtils.isEmpty(spbillIp)) {
            spbillIp = getIpAddress(request);
        }
        return signRecordApiService.tenpayEscrow(outTradeNo, body, pay_amount.toString(), notifyUrl, tradeType, opentId, spbillIp, tenantId, source);
    }

    /**
     * ??????????????????IP??????,?????????????????????????????????????????????????????????IP??????;
     *
     * @param request
     * @return
     * @throws IOException
     */
    private final String getIpAddress(HttpServletRequest request){
        // ??????????????????IP??????,?????????????????????????????????????????????????????????IP??????  
    	try {
    		String ip = request.getHeader("X-Forwarded-For");
    		if (logger.isInfoEnabled()) {
    			logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
    		}
    		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    				ip = request.getHeader("Proxy-Client-IP");
    				if (logger.isInfoEnabled()) {
    					logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
    				}
    			}
    			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    				ip = request.getHeader("WL-Proxy-Client-IP");
    				if (logger.isInfoEnabled()) {
    					logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
    				}
    			}
    			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    				ip = request.getHeader("HTTP_CLIENT_IP");
    				if (logger.isInfoEnabled()) {
    					logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
    				}
    			}
    			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    				if (logger.isInfoEnabled()) {
    					logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
    				}
    			}
    			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    				ip = request.getRemoteAddr();
    				if (logger.isInfoEnabled()) {
    					logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
    				}
    			}
    		} else if (ip.length() > 15) {
    			String[] ips = ip.split(",");
    			for (int index = 0; index < ips.length; index++) {
    				String strIp = (String) ips[index];
    				if (!("unknown".equalsIgnoreCase(strIp))) {
    					ip = strIp;
    					break;
    				}
    			}
    		}
    		return ip;
		} catch (Exception e) {
			return "127.0.0.1";
		}
    }

    /**
     * ?????????????????????????????????????????????
     */
    @AllowAnonymous
    @PostMapping("/pay/callback")
    public ResponseResult payEscrowCallback(@RequestBody Map<String, String> paramRequest) {
        logger.debug("~~~~~ payEscrowCallback param paramRequest = ({})", JSONObject.toJSONString(paramRequest));
        int paymentType = Integer.parseInt(paramRequest.get("paymentType"));
        String outTradeNo = paramRequest.get("outTradeNo");
        String tradeType = paramRequest.get("tradeType");
        return signRecordApiService.signPayCallback(paymentType, outTradeNo, tradeType);
    }

    /**
     * ???????????????????????????
     *
     * @param request(??????????????????????????????????????????)
     */
    @AllowAnonymous
    @PostMapping(value = "/pay/callback/alipay/webhook")
    public void alipayRechargeWebHook(HttpServletRequest request, HttpServletResponse response) throws IOException {

        JSONObject parameterMap = getJSONObject(request);

        logger.debug("alipay_webhook call back info: {}", JSON.toJSONString(parameterMap));

        signRecordApiService.alipayMatchWebHook(parameterMap);
        PrintWriter out = response.getWriter();
        out.print("success");
        out.flush();
        out.close();
    }

    /**
     * ????????????????????????
     *
     * @param body(???????????????????????????????????????)
     */
    @AllowAnonymous
    @PostMapping(value = "/pay/callback/wx/webhook")
    public void wxRechargeWebHook(@RequestBody String body, HttpServletResponse response) throws IOException {
        // ?????????????????????????????????????????????
        logger.debug("wx_recharge_webhook:" + JSON.toJSONString(body));

        signRecordApiService.wxRechargeWebHook(body);
        PrintWriter out = response.getWriter();
        out.print("SUCCESS");
        out.flush();
        out.close();
    }


    @GetMapping("/subjectPageReport")
    public ResponseResult subjectPageReport(HttpServletRequest request) throws Exception{
        PageParam page = getPageParam(request);
        Map<String, Object> param = getSubjectReportParam(request);
        logger.debug("~~~~~ get param = {}", JSON.toJSONString(param));
        Pagination<MatchInfoReport> pagination = signRecordService.subjectReportPage(page, param); // ???????????????????????????
        List<MatchInfoReport> dataList = pagination.getDataList();
        for (MatchInfoReport matchInfo : dataList) {
            param.put("matchId", matchInfo.getId());
            List<Map<String, Object>> matchSubjectReports = signRecordService.subjectReport(param);
            matchInfo.setMatchSubjectReports(matchSubjectReports);
        }
        return ResponseResult.ok().setData(pagination);
    }

    @GetMapping("/allSubjectReport")
    public ResponseResult allSubjectReport(HttpServletRequest request) throws Exception {
        Map<String, Object> param = getSubjectReportParam(request);
        logger.debug("~~~~~ get param = {}", JSON.toJSONString(param));
        return ResponseResult.ok().setData(signRecordService.allSubjectReport(param));
    }

    @GetMapping("/subjectReport")
    public ResponseResult subjectReport(HttpServletRequest request) throws Exception {
        Map<String, Object> param = getSubjectReportParam(request);
        logger.debug("~~~~~ get param = {}", JSON.toJSONString(param));
        return ResponseResult.ok().setData(signRecordService.subjectReport(param));
    }


    @GetMapping("/subjectReport/exportExcel")
    public ResponseResult courseReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> param = getSubjectReportParam(request);
        logger.debug("~~~~~ get param = {}", JSON.toJSONString(param));
        List<Map<String, Object>> list = signRecordService.subjectReport(param);
//        list.add(signRecordService.allSubjectReport(param));
        List<Tuple<String, String>> relation = new ArrayList<>(); // ????????????????????????
//        relation.add(new Tuple<>("trainCourseId", "??????Id"));
        relation.add(new Tuple<>("matchName", "????????????"));
        relation.add(new Tuple<>("matchSubjectName", "????????????"));
//        relation.add(new Tuple<>("type", "????????????"));
//        relation.add(new Tuple<>("trainCourseAmount", "????????????"));
        relation.add(new Tuple<>("signCount", "????????????"));
        relation.add(new Tuple<>("totalAmount", "?????????(??????:???)"));

        relation.add(new Tuple<>("aliPayCount", "???????????????"));
        relation.add(new Tuple<>("aliPayAmount", "???????????????(??????:???)"));
        relation.add(new Tuple<>("aliPayAmountPercent", "??????????????????"));

        relation.add(new Tuple<>("wxPayCount", "????????????"));
        relation.add(new Tuple<>("wxPayAmount", "????????????(??????:???)"));
        relation.add(new Tuple<>("wxPayAmountPercent", "???????????????"));

        relation.add(new Tuple<>("otherPayCount", "????????????"));
        relation.add(new Tuple<>("otherPayAmount", "????????????(??????:???)"));
        relation.add(new Tuple<>("otherPayAmountPercent", "???????????????"));
        logger.debug(JSONObject.toJSONString(relation));

        try {
            StringBuilder fileName = new StringBuilder();
            String paidTimeBegin = request.getParameter("paidTimeBegin");
            String paidTimeEnd = request.getParameter("paidTimeEnd");
            if (StringUtils.isNotEmpty(paidTimeBegin)) fileName.append(paidTimeBegin);
            if (StringUtils.isNotEmpty(paidTimeEnd)) fileName.append("~").append(paidTimeEnd);
            fileName.append("??????????????????");
            ExcelUtils.excelExport(list, relation, fileName.toString(), response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(MatchMessageLocale.EXCEL_INFO_IS_ERROR);
        }
        return ResponseResult.ok();
    }


    private Map<String, Object> getSubjectReportParam(HttpServletRequest request) {
        JSONObject param = getJSONObject(request);
        String authId = getCurrentAuthId(request);
        ValidateUtils.notEmpty(authId,UserMessageLocale.USER_NOT_ENTER);
        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        ValidateUtils.notNull(tenantUser, UserMessageLocale.USER_NOT_ENTER);
        // ??????????????????????????????????????????????????????ID
        if (tenantUser.getUserType() == TenantUserType.TENANT_USER.getStatus())param.put("tenantId", tenantUser.getTenantId());
        String paidTimeBegin = param.getString("paidTimeBegin");
        if (!ObjectUtils.isEmpty(paidTimeBegin)){
            param.put("paidTimeBegin", String.valueOf(DateUtils.toLong(paidTimeBegin, Constants.YYYY_MM_DD)));
        }
        String paidTimeEnd = param.getString("paidTimeEnd");
        if (!ObjectUtils.isEmpty(paidTimeEnd)){
            param.put("paidTimeEnd", String.valueOf(DateUtils.toLong(paidTimeEnd, Constants.YYYY_MM_DD) + 24 * 3600 * 1000));
//            param.put("paidTimeEnd",  String.valueOf(DateUtils.toLong(paidTimeEnd, Constants.YYYY_MM_DD)));
        }
        return param;
    }

    /**
     * ????????????
     * @param orderNo
     * @return
     * @throws BusinessException
     */
    @PostMapping("/refund")
    public ResponseResult signRecordRefund(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
    	if(!signRecordApiService.escrowRefund(json)){
    		throw new BusinessException(0,"????????????");
        }
    	return ResponseResult.ok();
    }

    /**
     * ????????????????????????
     * @param orderNo
     * @return
     * @throws BusinessException
     */
    @PostMapping("/add/signRecord")
    public ResponseResult addSignRecord(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        String authId = getCurrentAuthId(request);
        ValidateUtils.notEmpty(authId, UserMessageLocale.USER_NOT_ENTER);
        User user = userService.findByAuthId(authId);
        String matchId = json.getString("matchId");
        ValidateUtils.notEmpty(matchId, MessageLocale.EMPTY_CODE, "matchId????????????");
        String subjectId = json.getString("subjectId");
        ValidateUtils.notEmpty(matchId, MessageLocale.EMPTY_CODE, "??????ID????????????");
        Map<String,Object> params  = Maps.newHashMap();
        Map<String,Object> map  = Maps.newHashMap();
        params.put("matchId",matchId);
        params.put("subjectId",subjectId);
        params.put("userId",user.getId());
        List<SignRecord> signRecords = signRecordService.findBy(params);
        if (!ObjectUtils.isEmpty(signRecords)&&signRecords.size()>0){
            map.put("join",true);
        }else {
            map.put("join",false);
        }
        return ResponseResult.ok().setData(map);
    }
}
