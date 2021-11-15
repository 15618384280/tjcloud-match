package com.tjcloud.order.api.vo;

import com.tjcloud.order.base.entity.OtherIncomeSettlement;

/**
 * 其他收入
 * @author lihongzhou
 */
public class OtherIncomeSettlementVO extends OtherIncomeSettlement{

	private static final long serialVersionUID = 5603602560947823890L;

	private String userId;		//用户id
	private String userName;	//用户
	private String phone;		//手机号
	private Integer orderPayType;	//付款方式：1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵 8-会员卡
	private String tenantId;	//商户id
	private Integer channel;    //1-WEB、2-租户后台、3-大众点评、4-口碑、5-IOS、6-Android，7-上海银行，8-微信，9-宝山羽协，10-手机，11-其他
	private String cardNo;		//会员卡号
	private Integer paymentType;//支付方式：1-运动豆、2-场馆卡、3-次卡、4-支付宝、5-微信支付、6-红包支付、7-线下支付、8-租户会员卡
	
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
}
