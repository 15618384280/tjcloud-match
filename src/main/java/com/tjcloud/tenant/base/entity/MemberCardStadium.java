package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员卡能使用的场馆，平台卡才使用此表(member_card_stadium)
 * @author auto bin.yin 2016.06.20
 */
@LogRequired
public class MemberCardStadium extends AbstractEntity {
	private static final long serialVersionUID = 1466411796360L;

	private String memberCardCategoryId; //会员卡类型Id
	private String stadiumItemId; //stadiumItemId
	private Boolean disabled; //

	public String getMemberCardCategoryId() {
		return this.memberCardCategoryId;
	}
	public void setMemberCardCategoryId(String memberCardCategoryId) {
		this.memberCardCategoryId = memberCardCategoryId;
	}

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public Boolean isDisabled() {
		return this.disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
}