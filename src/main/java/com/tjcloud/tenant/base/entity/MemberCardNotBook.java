package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 不可预定会员卡(member_card_not_book)
 * @author auto bin.yin 2018.03.06
 */
public class MemberCardNotBook extends AbstractEntity {
	private static final long serialVersionUID = 1520306825765L;

	private String tenantId;		//商户id
	private String cardCategoryId; //会员卡类型id
	private String cardCategoryName; //会员卡类型名

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getCardCategoryId() {
		return this.cardCategoryId;
	}
	public void setCardCategoryId(String cardCategoryId) {
		this.cardCategoryId = cardCategoryId;
	}
	public String getCardCategoryName() {
		return this.cardCategoryName;
	}
	public void setCardCategoryName(String cardCategoryName) {
		this.cardCategoryName = cardCategoryName;
	}
}