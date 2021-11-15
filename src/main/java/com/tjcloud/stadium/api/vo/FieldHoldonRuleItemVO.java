package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

import com.tjcloud.stadium.base.entity.FieldHoldonRuleItem;

/**
 * 场地挂起明细
 * @author lihongzhou
 */

public class FieldHoldonRuleItemVO implements Serializable{

	private static final long serialVersionUID = -8985359687305494800L;

	private String id;
	private String fieldId;			// 场地Id
	private String fieldName;		// 场地名
	private String beginDate;		// 开始日期
	private String endDate;			// 结束日期
	private String beginTime;		// 开始时间
	private String endTime;			// 结束时间
	private String fieldHoldonRuleId; // 挂起规则Id
	private String fieldSessionId;	  // 场次Id
	
	public String getFieldHoldonRuleId() {
		return fieldHoldonRuleId;
	}
	public void setFieldHoldonRuleId(String fieldHoldonRuleId) {
		this.fieldHoldonRuleId = fieldHoldonRuleId;
	}
	public String getFieldSessionId() {
		return fieldSessionId;
	}
	public void setFieldSessionId(String fieldSessionId) {
		this.fieldSessionId = fieldSessionId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public FieldHoldonRuleItemVO() {
		super();
	}
	public FieldHoldonRuleItemVO(FieldHoldonRuleItem item) {
		setId(item.getId());
		setFieldHoldonRuleId(item.getFieldHoldonRuleId());
		setFieldId(item.getFieldId());
		setFieldName(item.getFieldName());
		setFieldSessionId(item.getFieldSessionId());
		setBeginDate(item.getBeginDate());
		setEndDate(item.getEndDate());
		setBeginTime(item.getBeginTime());
		setEndTime(item.getEndTime());
	}
}
