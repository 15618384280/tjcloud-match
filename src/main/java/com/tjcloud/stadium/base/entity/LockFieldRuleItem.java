package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.LockFieldRuleItemVO;
/**
 * 注释(lock_field_rule_item)
 * @author auto bin.yin 2016.10.10
 */
@LogRequired
public class LockFieldRuleItem extends AbstractEntity {
	private static final long serialVersionUID = 1476095044205L;

	private String lockFieldRuleId; //锁定主表ID
	private Integer dayOfWeek; //天的类型
	private String fieldId; //场地id
	private String fieldName; //场地名
	private String beginTime; //开始时间
	private String endTime; //结束时间

	public String getLockFieldRuleId() {
		return this.lockFieldRuleId;
	}
	public void setLockFieldRuleId(String lockFieldRuleId) {
		this.lockFieldRuleId = lockFieldRuleId;
	}

	public Integer getDayOfWeek() {
		return this.dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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

	public LockFieldRuleItem() {
		super();
	}
	public LockFieldRuleItem(LockFieldRuleItemVO lockFieldRuleItemVO) {
		setId(lockFieldRuleItemVO.getLockFieldRuleItemId());
		setLockFieldRuleId(lockFieldRuleItemVO.getLockFieldRuleId());
		setFieldId(lockFieldRuleItemVO.getFieldId());
		setFieldName(lockFieldRuleItemVO.getFieldName());
		setBeginTime(lockFieldRuleItemVO.getBeginTime());
		setEndTime(lockFieldRuleItemVO.getEndTime());
		setDayOfWeek(lockFieldRuleItemVO.getDayOfWeek());
	}
}