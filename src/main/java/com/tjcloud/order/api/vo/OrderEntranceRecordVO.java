package com.tjcloud.order.api.vo;

import java.io.Serializable;
import java.util.List;

public class OrderEntranceRecordVO implements Serializable{

	private static final long serialVersionUID = 393852158778733987L;
	
	private List<String> orderDetailIds;	// 订单明细
	private Integer orderType;				// 订单类型
	private String orderNo;					// 订单号
	private String stadiumItemId;			// 场馆id
	private String entranceCode;			// 入场验证码
	private String tenantId;				// 租户id
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getEntranceCode() {
		return entranceCode;
	}
	public void setEntranceCode(String entranceCode) {
		this.entranceCode = entranceCode;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public List<String> getOrderDetailIds() {
		return orderDetailIds;
	}
	public void setOrderDetailIds(List<String> orderDetailIds) {
		this.orderDetailIds = orderDetailIds;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
}
