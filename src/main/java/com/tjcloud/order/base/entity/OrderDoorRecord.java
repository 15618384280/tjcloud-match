package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 全民健身打卡记录(order_door_record)
 * @author auto bin.yin 2017.08.29
 */
public class OrderDoorRecord extends AbstractEntity {
	private static final long serialVersionUID = 1503971570267L;

	private String doorId; 				//闸机Id
	private String stadiumId; 			//场馆Id
	private String stadiumItemId; 		//场馆项目Id
	private String orderId; 			//订单Id
	private String userId; 				//用户Id
	private String userName; 			//用户姓名
	private Long entranceTime; 			//入场时间（打卡时间）
	private Long outTime;				//出场时间
	private Integer status;				//0-未出场 1-已出场

	public String getDoorId() {
		return doorId;
	}

	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumItemId() {
		return stadiumItemId;
	}

	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public Long getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(Long entranceTime) {
		this.entranceTime = entranceTime;
	}

	public Long getOutTime() {
		return outTime;
	}

	public void setOutTime(Long outTime) {
		this.outTime = outTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}