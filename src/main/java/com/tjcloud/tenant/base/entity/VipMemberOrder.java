package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
/**
 * vip会员表(vip_member_order)
 * @author auto bin.yin 2016.06.30
 */
public class VipMemberOrder extends AbstractEntity {

    private static final long serialVersionUID = 3337990528301450661L;

    private String userId;          //用户Id
    private String phone;          //用户手机号
    private String orderNo; 		//订单号
    private String rechargeRuleId;  //充值规则Id
    private Long rechargeAmount;    //充值金额
    private Long valBeginTime;		// 有效期开始时间
    private Long valEndTime;  		// 有效期结束时间
    private int cancelTimeNum;  	// 退订次数
    private Integer paymentType;    // 支付方式
    private Integer paymentStatus;  // 订单状态
    private Integer source;         // 订单来源
    private Long paymentTime; 	    // 支付时间

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRechargeRuleId() {
        return rechargeRuleId;
    }

    public void setRechargeRuleId(String rechargeRuleId) {
        this.rechargeRuleId = rechargeRuleId;
    }

    public Long getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Long rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Long getValBeginTime() {
        return valBeginTime;
    }

    public void setValBeginTime(Long valBeginTime) {
        this.valBeginTime = valBeginTime;
    }

    public Long getValEndTime() {
        return valEndTime;
    }

    public void setValEndTime(Long valEndTime) {
        this.valEndTime = valEndTime;
    }

    public int getCancelTimeNum() {
        return cancelTimeNum;
    }

    public void setCancelTimeNum(int cancelTimeNum) {
        this.cancelTimeNum = cancelTimeNum;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Long getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Long paymentTime) {
        this.paymentTime = paymentTime;
    }
}
