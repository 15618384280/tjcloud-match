package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.tjcloud.stadium.base.entity.LockFieldRecord;

/**
 * 锁定记录
 * @author lihongzhou
 */
public class LockFieldRecordVO implements Serializable{

	private static final long serialVersionUID = 5488308151424388222L;
	
	private String lockFieldRecordId;		// 锁定记录id
	private String lockFieldRuleId;			// 锁定规则id
	private String stadiumId;				// 场馆id
	private String stadiumName;				// 场馆名
	private String stadiumItemId;			// 项目id
	private String stadiumItemName;			// 项目名
	private String fieldId;					// 场地id
	private String fieldName;				// 场地名
	private String tenantId;				// 租户id
	private String lockDate;				// 锁定日期
	private String beginTime;				// 开始时间
	private String endTime;					// 结束时间
	private String tokenId;					// 操作人
	private String createdBy;				// 操作人
	
	private List<LockFieldRecord> lockFieldRecords;

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public String getLockFieldRecordId() {
		return lockFieldRecordId;
	}
	public void setLockFieldRecordId(String lockFieldRecordId) {
		this.lockFieldRecordId = lockFieldRecordId;
	}

	public String getLockFieldRuleId() {
		return lockFieldRuleId;
	}
	public void setLockFieldRuleId(String lockFieldRuleId) {
		this.lockFieldRuleId = lockFieldRuleId;
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

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getLockDate() {
		return lockDate;
	}
	public void setLockDate(String lockDate) {
		this.lockDate = lockDate;
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

	public List<LockFieldRecord> getLockFieldRecords() {
		return lockFieldRecords;
	}
	public void setLockFieldRecords(List<LockFieldRecord> lockFieldRecords) {
		this.lockFieldRecords = lockFieldRecords;
	}
}
