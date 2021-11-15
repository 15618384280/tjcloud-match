package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 长订订单微调明细表(long_order_rule_exception_item)
 * @author auto bin.yin 2016.11.08
 */
@LogRequired
public class LongOrderRuleExceptionItem extends AbstractEntity {
	private static final long serialVersionUID = 1478575190737L;

	private String longOrderRuleExceptionId; //长订微调id
	private String longOrderRuleId; //长订规则id
	private String tenantId; //租户id
	private String stadiumId; //场馆id
	private String stadiumItemId; //项目id
	private String fieldId; //场地id
	private String fieldName; //场地名

	public String getLongOrderRuleExceptionId() {
		return this.longOrderRuleExceptionId;
	}
	public void setLongOrderRuleExceptionId(String longOrderRuleExceptionId) {
		this.longOrderRuleExceptionId = longOrderRuleExceptionId;
	}
	public String getLongOrderRuleId() {
		return this.longOrderRuleId;
	}
	public void setLongOrderRuleId(String longOrderRuleId) {
		this.longOrderRuleId = longOrderRuleId;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
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
	public String getFieldName() {
		return this.fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}