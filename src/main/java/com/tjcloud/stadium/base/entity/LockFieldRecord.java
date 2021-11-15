package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
/**
 * 场地锁定记录表(lock_field_record)
 * @author auto bin.yin 2016.10.10
 */
@LogRequired
public class LockFieldRecord extends AbstractEntity {
	private static final long serialVersionUID = 1476095043722L;

	private String lockFieldRuleId; //锁定规则id
	private String stadiumId; //场馆id
	private String stadiumName; //场馆名称
	private String stadiumItemId; //项目id
	private String stadiumItemName; //项目名
	private String fieldId; //场地id
	private String fieldName; //场地名
	private String tenantId; //租户id
	private String lockDate; //锁定日期 yyyy-MM-dd
	private String beginTime; //开始时间 HH:mm
	private String endTime; //结束时间 HH:mm

	public String getLockFieldRuleId() {
		return this.lockFieldRuleId;
	}
	public void setLockFieldRuleId(String lockFieldRuleId) {
		this.lockFieldRuleId = lockFieldRuleId;
	}

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public String getFieldId() {
		return this.fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return this.fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getLockDate() {
		return this.lockDate;
	}
	public void setLockDate(String lockDate) {
		this.lockDate = lockDate;
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
}