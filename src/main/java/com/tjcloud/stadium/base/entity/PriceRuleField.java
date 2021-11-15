package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 价格规则场地关联表(price_rule_field)
 * @author auto bin.yin 2016.06.29
 */
@LogRequired
public class PriceRuleField extends AbstractEntity {
	private static final long serialVersionUID = 1467168088253L;

	private String ruleMainId; //价格规则主Id
	private String fieldId; //场地Id

	private String fieldName;

	public String getRuleMainId() {
		return this.ruleMainId;
	}
	public void setRuleMainId(String ruleMainId) {
		this.ruleMainId = ruleMainId;
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