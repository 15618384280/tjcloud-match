package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.MemberHouseSign;

public class MemberHouseSignVO extends MemberHouseSign {

	private static final long serialVersionUID = -1569007289517697579L;
	
	private String memberHouseName; //协会名称
	private String signCount; //入会人数
	private String logo; //协会logo
	
	public String getMemberHouseName() {
		return memberHouseName;
	}
	public void setMemberHouseName(String memberHouseName) {
		this.memberHouseName = memberHouseName;
	}
	public String getSignCount() {
		return signCount;
	}
	public void setSignCount(String signCount) {
		this.signCount = signCount;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
