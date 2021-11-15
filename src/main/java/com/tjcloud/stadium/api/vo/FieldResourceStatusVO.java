package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 场地资源
 *
 */
public class FieldResourceStatusVO implements Serializable{

	private static final long serialVersionUID = 2227884891176556646L;

	private List<StadiumItemOpeningTimeDateVO> openingTimeList;
	private List<JSONObject> sessionList;
	private List<JSONObject> orderList;
	private List<JSONObject> longOrderList;
	private List<JSONObject> holdOnList;
	private List<JSONObject> fieldList;
	
	public List<StadiumItemOpeningTimeDateVO> getOpeningTimeList() {
		return openingTimeList;
	}
	public void setOpeningTimeList(List<StadiumItemOpeningTimeDateVO> openingTimeList) {
		this.openingTimeList = openingTimeList;
	}
	public List<JSONObject> getSessionList() {
		return sessionList;
	}
	public void setSessionList(List<JSONObject> sessionList) {
		this.sessionList = sessionList;
	}
	public List<JSONObject> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<JSONObject> orderList) {
		this.orderList = orderList;
	}
	public List<JSONObject> getLongOrderList() {
		return longOrderList;
	}
	public void setLongOrderList(List<JSONObject> longOrderList) {
		this.longOrderList = longOrderList;
	}
	public List<JSONObject> getHoldOnList() {
		return holdOnList;
	}
	public void setHoldOnList(List<JSONObject> holdOnList) {
		this.holdOnList = holdOnList;
	}
	public List<JSONObject> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<JSONObject> fieldList) {
		this.fieldList = fieldList;
	}
}