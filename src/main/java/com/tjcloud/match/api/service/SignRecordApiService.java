package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.exception.ServiceException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.match.base.entity.MatchSubject;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.entity.SignRecordFieldTable;
import com.tjcloud.match.base.vo.SignRecordVO;
import com.tjcloud.match.base.vo.TeamSignRecordVO;
import com.tjcloud.order.api.enums.PaymentType;

import java.util.List;
import java.util.Map;

/**
 * Created by ryan on 2017/3/16.
 */
public interface SignRecordApiService {
	
	/**
     * 团队-保存、新增 报名记录
     *
     * @param TeamSignRecordVO teamSignRecord
     * @return SignRecordVO<SignRecordFieldTable>
     */
	SignRecordVO<SignRecordFieldTable> saveTeamsign(TeamSignRecordVO teamSignRecord)  throws BusinessException;

    /**
     * 保存、新增 SignRecord
     *
     * @param signRecord
     * @return
     */
    SignRecordVO<SignRecordFieldTable> saveSignRecord(SignRecordVO<SignRecordFieldTable> signRecord);
    
    /**
     * 团队成员自己加入团队
     * @param teamId
     * @param signRecord
     * @return
     */
    SignRecordVO<SignRecordFieldTable> addTeamMember(String teamId,SignRecordVO<SignRecordFieldTable> signRecord);

    /**
     * 根据订单号查询 报名记录
     * @param recordId
     * @return
     */
   SignRecordVO<SignRecordFieldTable> querySignRecordByOrderNo(String orderNo);

   /**
    * 将张家港的赛事报名改为已支付
    * @param orderNo
    * @return
    */
   SignRecord savePaidZJGmatch(String orderNo, PaymentType paymentType, Long paymentTime);

    /**
     * 查询 报名记录
     *
     * @param recordId
     * @return
     */
    SignRecordVO<SignRecordFieldTable> querySignRecord(String recordId);

    /**
	 *
	 * @param outTradeNo    商户订单号
	 * @param subject		支付title（ps：我要运动）
	 * @param body			消费类型（ps:场地预定消费）
	 * @param amount		支付金额（单位：分）
	 * @param notifyUrl		支付回调地址
	 * @param method		支付方式（alipay.trade.wap.pay：网页，alipay.trade.app.pay：APP移动应用）
	 */
	ResponseResult alipayEscrow(String outTradeNo, String subject, String body, String amount, String notifyUrl, String method, String returnUrl);

	/**
     * @param outTradeNo 	商户订单号
     * @param notifyId  	支付回调地址验证
     * @param tradeStatus  	支付状态
     */
   String alipayEscrowReturn(JSONObject requestParams);

	/**
	 *
	 * @param outTradeNo	商户订单号
	 * @param subject		支付title（ps：我要运动）
	 * @param body			消费类型（ps:场地预定消费）
	 * @param amount		支付金额（单位：分）
	 * @param notifyUrl		支付回调地址
	 * @param tradeType		微信支付方式（JSAPI：网页，NATIVE：微信，APP：移动应用，WAP：扫码支付）
	 */
	ResponseResult tenpayEscrow(String outTradeNo, String body, String amount, String notifyUrl, String tradeType, String opentId, String spbillIp,String tenantId, String source);


    /**
	 *
	 * @param paymentType  支付类型（PS:4:支付宝，5：微信支付）
	 * @param outTradeNo   商户订单号
	 * @param tradeType	   微信支付方式（JSAPI：网页，NATIVE：微信，APP：移动应用，WAP：扫码支付）
	 * @return
	 * @throws ServiceException
	 */
	ResponseResult signPayCallback(int paymentType,String outTradeNo, String tradeType)  throws BusinessException;

	/**
	 * 支付宝支付回调接口
	 * @param parameterMap
	 */
	void alipayMatchWebHook(JSONObject parameterMap);
	/**
	 * 支付宝支付回调接口
	 * @param parameterMap
	 */
	void alipayMatchScheduleWebHook(String orderNo);

	/**
	 * 微信支付回调接口
	 * @param body
	 */
	void wxRechargeWebHook(String body);
	
	/**
	 * 校验重复报名
	 *
	 * @param matchSubject
	 * @param signRecord
	 */
	boolean checkRepetition(MatchSubject matchSubject, SignRecord signRecord);

	/**
	 * 校验重复报名
	 *
	 * @param matchSubject
	 * @param signRecord
	 */
	void checkDuplicate(MatchSubject matchSubject, SignRecord signRecord);

		/**
         * 取消报名
         * @param recordId
         * @return
         */
	SignRecord cancelSign(String recordId);

	/**
	 * 删除报名记录同时删除报名字段
	 * @param recordId
	 * @return
	 */
	void deleteSignRecord(String recordId);

	/**
	 * @param matchSubject 赛事科目
	 * @param addCount     需要新增的报名数
	 */
	void checkLimit(MatchSubject matchSubject, int addCount);

	/**
	 * @param matchSubject 赛事科目
	 */
	MatchSubject resetSignCount(MatchSubject matchSubject);

	Boolean escrowRefund(JSONObject json);

	/**
	 * 订单支付
	 * @param orderNo
	 * @param paymentType
	 * @param params
	 * @return
	 */
	SignRecord payOrder(String orderNo, Integer paymentType, Map<String, Object> params);
	
	/**
	 * 赛事生成号码牌
	 * @param page
	 * @param param
	 */
	void createMatchNo(PageParam page, JSONObject param);
	
	/**
	 * 设置参赛号码
	 * @param param	参赛者查询参数
	 * @param dataList	参数者集合
	 * @param matchno	参数者初始号码
	 * @param formatHead	号码前缀
	 * @param formatLength	号码数字长度
	 */
	void setMatchNo(JSONObject param, List<SignRecord> dataList, Long matchno, String formatHead, String formatLength);
	
}
