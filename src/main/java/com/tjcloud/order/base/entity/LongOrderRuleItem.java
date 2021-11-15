package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 注释(long_order_rule_item)
 * @author auto bin.yin 2016.07.20
 */
@LogRequired
public class LongOrderRuleItem extends AbstractEntity {
	private static final long serialVersionUID = 1468999365120L;

	private String orderId; 				//订单ID
	private String longOrderRuleId; 		//主表ID
	private Integer dayOfWeek; 				//天的类型
	private String tenantId; 				//租户Id
	private String stadiumId; 				//场馆id
	private String stadiumItemId; 			//子场馆id
	private String fieldId; 				//场地id
	private String fieldName;				//场地名
	private String fieldSessionId; 			//不用传
	private String beginTime; 				//开始时间
	private String endTime; 				//结束时间

	private Object stadiumItem;
	private Object Field;

	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getLongOrderRuleId() {
		return this.longOrderRuleId;
	}
	public void setLongOrderRuleId(String longOrderRuleId) {
		this.longOrderRuleId = longOrderRuleId;
	}

	public Integer getDayOfWeek() {
		return this.dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getFieldId() {
		return this.fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldSessionId() {
		return this.fieldSessionId;
	}
	public void setFieldSessionId(String fieldSessionId) {
		this.fieldSessionId = fieldSessionId;
	}

	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public Object getStadiumItem() {
		return this.stadiumItem;
	}

	public void setStadiumItem(Object stadiumItem) {
		this.stadiumItem = stadiumItem;
	}

	public Object getField() {
		return this.Field;
	}

	public void setField(Object field) {
		this.Field = field;
	}
}