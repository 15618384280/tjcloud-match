package com.tjcloud.stadium.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 价格规则主表(price_rule_main)
 * @author auto bin.yin 2016.06.29
 */
@LogRequired
public class PriceRuleMain extends AbstractEntity {
	private static final long serialVersionUID = 1467168088327L;

	private String beginTime; //开始时刻
	private String endTime; //结束时刻
	private Boolean always; //false-为临时价格
	private Integer price; //单位为分
	private String stadiumItemId; //冗余字段
	private String stadiumId; //冗余字段
	private String beginEffectDateString;
	private String endEffectDateString;
	private Long beginEffectDate; //生效开始日期
	private Long endEffectDate; //生效结束日期
	private List<PriceRuleDate> priceRuleDates;
	private List<PriceRuleField> priceRuleFields;
	private List<PriceRuleMember> priceRuleMembers;

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

	public Boolean getAlways() {
		return this.always;
	}
	public void setAlways(Boolean always) {
		this.always = always;
	}

	public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getBeginEffectDateString() {
		return this.beginEffectDateString;
	}

	public void setBeginEffectDateString(String beginEffectDateString) {
		this.beginEffectDateString = beginEffectDateString;
	}

	public String getEndEffectDateString() {
		return this.endEffectDateString;
	}

	public void setEndEffectDateString(String endEffectDateString) {
		this.endEffectDateString = endEffectDateString;
	}

	public Long getBeginEffectDate() {
		return this.beginEffectDate;
	}
	public void setBeginEffectDate(Long beginEffectDate) {
		this.beginEffectDate = beginEffectDate;
	}

	public Long getEndEffectDate() {
		return this.endEffectDate;
	}
	public void setEndEffectDate(Long endEffectDate) {
		this.endEffectDate = endEffectDate;
	}

	public List<PriceRuleDate> getPriceRuleDates() {
		return this.priceRuleDates;
	}

	public void setPriceRuleDates(List<PriceRuleDate> priceRuleDates) {
		this.priceRuleDates = priceRuleDates;
	}

	public List<PriceRuleField> getPriceRuleFields() {
		return this.priceRuleFields;
	}

	public void setPriceRuleFields(List<PriceRuleField> priceRuleFields) {
		this.priceRuleFields = priceRuleFields;
	}

	public List<PriceRuleMember> getPriceRuleMembers() {
		return this.priceRuleMembers;
	}

	public void setPriceRuleMembers(List<PriceRuleMember> priceRuleMembers) {
		this.priceRuleMembers = priceRuleMembers;
	}
}