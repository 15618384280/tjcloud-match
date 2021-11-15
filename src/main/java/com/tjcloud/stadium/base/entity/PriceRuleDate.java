package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 价格规则日期关联表(price_rule_date)
 * @author auto bin.yin 2016.06.29
 */
@LogRequired
public class PriceRuleDate extends AbstractEntity {
	private static final long serialVersionUID = 1467168087968L;

	private String ruleMainId; //价格规则主Id
	private String dayOfWeek; //1-7周一到周日,并且还有8-法定假日,9-双休日调班

	public String getRuleMainId() {
		return this.ruleMainId;
	}
	public void setRuleMainId(String ruleMainId) {
		this.ruleMainId = ruleMainId;
	}

	public String getDayOfWeek() {
		return this.dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
}