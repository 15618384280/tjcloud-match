package com.tjcloud.order.api.vo;

import com.tjcloud.order.base.entity.OrderTicket;

import java.io.Serializable;
import java.util.List;

/**
 * 创建票劵订单
 * @author lihongzhou
 */
public class CreateTicketOrderVO implements Serializable{

	private static final long serialVersionUID = -2883171981128136116L;
	
	private String tokenId;				  // 创建人
	private String tenantId;			  // 租户ID
	private Integer orderPayType;		  // 付款方式：1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵 8-会员卡
	private Integer orderType;			  // 订单类型
	private Integer paymentType;		  // 支付类型
	private String keyNo;				// 钥匙序列号
	private Long actualAmount;			// 实收
	private Long tenantDisAmount;		// 优惠金额
	private String remark;				// 备注
	
	private String userName;			// 用户姓名
	private String phone;				// 手机号
	private String cardNo;				// 会员卡号
	private String userId;				// 用户Id

	public List<OrderTicket> orderTicket; //票卷订单明细订单

	
	public String getKeyNo() {
		return keyNo;
	}
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	public Long getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(Long actualAmount) {
		this.actualAmount = actualAmount;
	}
	public Long getTenantDisAmount() {
		return tenantDisAmount;
	}
	public void setTenantDisAmount(Long tenantDisAmount) {
		this.tenantDisAmount = tenantDisAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}

	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
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

	public List<OrderTicket> getOrderTicket() {
		return orderTicket;
	}
	public void setOrderTicket(List<OrderTicket> orderTicket) {
		this.orderTicket = orderTicket;
	}
	
}
