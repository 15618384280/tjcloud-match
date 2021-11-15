package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 第三方订单
 * @author Administrator
 *
 */

@LogRequired
public class EscrowOrder extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7187464792130302589L;
	
	private String orderNo;//订单号
	private String orderId;//订单ID
	private String escrowOrderNo;//第三方订单号
	private String escrowOrderId;//第三方订单id
	private Integer escrowType;//第三方类型（携程，百度糯米。。。）1：携程。。。
	private String validateCode;
	private Integer entranceStatus;	//0-未入场 1-入场
	private Integer orderAmount;	//订单金额
	private String tradeNo;	//交易流水号
	
	public String getEscrowOrderId() {
		return escrowOrderId;
	}
	public void setEscrowOrderId(String escrowOrderId) {
		this.escrowOrderId = escrowOrderId;
	}
	public Integer getEntranceStatus() {
		return entranceStatus;
	}
	public void setEntranceStatus(Integer entranceStatus) {
		this.entranceStatus = entranceStatus;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Integer getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getEscrowOrderNo() {
		return escrowOrderNo;
	}
	public void setEscrowOrderNo(String escrowOrderNo) {
		this.escrowOrderNo = escrowOrderNo;
	}
	public Integer getEscrowType() {
		return escrowType;
	}
	public void setEscrowType(Integer escrowType) {
		this.escrowType = escrowType;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}
