package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.FieldHoldonRuleItemVO;

/**
 * 场地挂起规则明细(field_holdon_rule_item)
 * @author auto bin.yin 2016.07.22
 */
@LogRequired
public class FieldHoldonRuleItem extends AbstractEntity {
	private static final long serialVersionUID = 1469171900299L;

	private String fieldHoldonRuleId; //挂起规则Id
	private String fieldId; //场地Id
	private String fieldName; //场地名
	private String fieldSessionId; //场次Id
	private String beginDate; //开始日期
	private String endDate; //结束日期
	private String beginTime; //开始时间
	private String endTime; //结束时间
	
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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

	public String getBeginDate() {
		return this.beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return this.endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getFieldHoldonRuleId() {
		return fieldHoldonRuleId;
	}
	public void setFieldHoldonRuleId(String fieldHoldonRuleId) {
		this.fieldHoldonRuleId = fieldHoldonRuleId;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public FieldHoldonRuleItem() {
		super();
	}
	
	public FieldHoldonRuleItem(FieldHoldonRuleItemVO fieldHoldonRuleItemVO) {
		setId(fieldHoldonRuleItemVO.getId());
		setFieldHoldonRuleId(fieldHoldonRuleItemVO.getFieldHoldonRuleId());
		setFieldId(fieldHoldonRuleItemVO.getFieldId());
		setFieldName(fieldHoldonRuleItemVO.getFieldName());
		setFieldSessionId(fieldHoldonRuleItemVO.getFieldSessionId());
		setBeginDate(fieldHoldonRuleItemVO.getBeginDate());
		setEndDate(fieldHoldonRuleItemVO.getEndDate());
		setBeginTime(fieldHoldonRuleItemVO.getBeginTime());
		setEndTime(fieldHoldonRuleItemVO.getEndTime());
	}
}