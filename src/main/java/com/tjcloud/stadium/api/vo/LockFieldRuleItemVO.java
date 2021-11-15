package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

/**
 * 锁定明细
 * @author lihongzhou
 */
public class LockFieldRuleItemVO implements Serializable{

	private static final long serialVersionUID = 4066390404153220184L;

	private String lockFieldRuleItemId;		// 明细ID
	private String lockFieldRuleId;			// 规则ID
	private Integer dayOfWeek;				// 周期
	private String fieldId;					// 场地ID
	private String fieldName;				// 场地名
	private String beginTime;				// 开始时间
	private String endTime;					// 结束时间
	
	public String getLockFieldRuleItemId() {
		return lockFieldRuleItemId;
	}
	public void setLockFieldRuleItemId(String lockFieldRuleItemId) {
		this.lockFieldRuleItemId = lockFieldRuleItemId;
	}
	public String getLockFieldRuleId() {
		return lockFieldRuleId;
	}
	public void setLockFieldRuleId(String lockFieldRuleId) {
		this.lockFieldRuleId = lockFieldRuleId;
	}
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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
	
}
