package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 价格规则会员关联表(price_rule_member)
 * @author auto bin.yin 2016.06.29
 */
@LogRequired
public class PriceRuleMember extends AbstractEntity {
	private static final long serialVersionUID = 1467168088928L;

	private String ruleMainId; //价格规则主Id
	private String memberCategoryId; //会员类型Id
	private String memberCardCategoryName;

	public String getRuleMainId() {
		return this.ruleMainId;
	}
	public void setRuleMainId(String ruleMainId) {
		this.ruleMainId = ruleMainId;
	}

	public String getMemberCategoryId() {
		return this.memberCategoryId;
	}
	public void setMemberCategoryId(String memberCategoryId) {
		this.memberCategoryId = memberCategoryId;
	}

	public String getMemberCardCategoryName() {
		return this.memberCardCategoryName;
	}

	public void setMemberCardCategoryName(String memberCardCategoryName) {
		this.memberCardCategoryName = memberCardCategoryName;
	}
}