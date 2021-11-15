package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员卡类型价格售卖设置表(member_category_price)
 * @author auto bin.yin 2018.08.30
 */
public class MemberCategoryPrice extends AbstractEntity {
	private static final long serialVersionUID = 1535607680581L;

	private String categoryId; //卡类型ID
	private String unit; //单位
	private Integer value; //值
	private Integer amount; //价值
	private Integer sort; //排序

	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getUnit() {
		return this.unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getValue() {
		return this.value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getAmount() {
		return this.amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getSort() {
		return this.sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}