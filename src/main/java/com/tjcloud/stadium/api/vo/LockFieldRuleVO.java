package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 场地锁定
 * @author lihongzhou
 */
public class LockFieldRuleVO implements Serializable{

	private static final long serialVersionUID = 3734482713420571895L;
	
	private String lockFieldRuleId;		// 规则ID
	private String tenantId;			// 租户ID
	private String stadiumId;			// 场馆ID
	private String stadiumName;			// 场馆名
	private String stadiumItemId;		// 项目ID
	private String stadiumItemName;		// 项目名

	private String beginPeriod;			// 开始周期
	private String endPeriod;			// 结束周期
	private String beginTime;			// 开始时间
	private String endTime;				// 结束时间
	
	private String mobile;				// 电话
	private String note;				// 描述

	private Integer dayOfWeek;			// 周期
	private String lockFieldRuleItemId;	// 明细id
	private String fieldId;				// 场地ID
	private String fieldName;			// 场地名
	
	List<Integer> dayOfWeeks;			// 周期
	List<JSONObject> fields;			// 场地信息
	
	private String tokenId;				// 操作人
	
	private List<LockFieldRuleItemVO> lockFieldRuleItems; // 锁定明细
	
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public List<Integer> getDayOfWeeks() {
		return dayOfWeeks;
	}
	public void setDayOfWeeks(List<Integer> dayOfWeeks) {
		this.dayOfWeeks = dayOfWeeks;
	}
	public List<JSONObject> getFields() {
		return fields;
	}
	public void setFields(List<JSONObject> fields) {
		this.fields = fields;
	}
	public String getLockFieldRuleId() {
		return lockFieldRuleId;
	}
	public void setLockFieldRuleId(String lockFieldRuleId) {
		this.lockFieldRuleId = lockFieldRuleId;
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
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public String getBeginPeriod() {
		return beginPeriod;
	}
	public void setBeginPeriod(String beginPeriod) {
		this.beginPeriod = beginPeriod;
	}

	public String getEndPeriod() {
		return endPeriod;
	}
	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public List<LockFieldRuleItemVO> getLockFieldRuleItems() {
		return lockFieldRuleItems;
	}
	public void setLockFieldRuleItems(List<LockFieldRuleItemVO> lockFieldRuleItems) {
		this.lockFieldRuleItems = lockFieldRuleItems;
	}
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getLockFieldRuleItemId() {
		return lockFieldRuleItemId;
	}
	public void setLockFieldRuleItemId(String lockFieldRuleItemId) {
		this.lockFieldRuleItemId = lockFieldRuleItemId;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
}
