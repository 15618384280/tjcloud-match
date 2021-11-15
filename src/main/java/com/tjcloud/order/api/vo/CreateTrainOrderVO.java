package com.tjcloud.order.api.vo;

import com.tjcloud.order.api.enums.OrderType;
import com.tjcloud.order.base.entity.Order;
import com.tjcloud.order.base.entity.OrderDetailField;

import java.io.Serializable;

/**
 * 创建培训订单
 */
public class CreateTrainOrderVO implements Serializable{

	private static final long serialVersionUID = 1576298295881132282L;
	private String tokenId;				  // 创建人
	private String tenantId;			  // 租户ID
	/**
	 * {@link OrderType}
	 * @see Order#orderType
	 */
	private Integer orderType;			  // 订单类型
	private String orderNo;			  // 订单号
	private Integer paymentType;		  // 支付类型
	private Long actualAmount;			// 实收
	private Long tenantDisAmount;		// 优惠金额
	private String remark;				// 备注

	private String userName;			// 用户姓名
	private String phone;				// 手机号
	private String cardNo;				// 会员卡号
	private String memberCardId;		// 会员卡ID
	private String userId;				// 用户Id

	private OrderDetailField orderDetailField;

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

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
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

	public String getMemberCardId() {
		return memberCardId;
	}

	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public OrderDetailField getOrderDetailField() {
		return orderDetailField;
	}

	public void setOrderDetailField(OrderDetailField orderDetailField) {
		this.orderDetailField = orderDetailField;
	}
}
