package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 老平台订单(old_platform_order)
 * @author auto bin.yin 2018.04.12
 */
public class OldPlatformOrder extends AbstractEntity {
	private static final long serialVersionUID = 1523501073951L;

	private String orderId; //订单id
	private String orderNo; //订单号
	private Integer orderStatus; //订单状态 0-已支付 1-已退款
	private Long orderAmount; //订单金额
	private String tenantId; //租户id

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOrderStatus() {
		return this.orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Long getOrderAmount() {
		return this.orderAmount;
	}
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}