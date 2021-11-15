package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 计时闸机进出场记录关联订单(order_door_note)
 * @author gcy 2020年12月3日19:09:53
 */
public class OrderDoorNote extends AbstractEntity {

	private static final long serialVersionUID = -3885608722956564953L;

	private String doorId; 				//闸机Id
	private String recordId; 			//进出场记录id
	private String orderId; 			//订单Id
	private String orderNo; 			//订单号
	private String userId; 				//用户id

	public String getDoorId() {
		return doorId;
	}

	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}