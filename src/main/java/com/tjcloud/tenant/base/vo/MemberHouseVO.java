package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.MemberHouse;

public class MemberHouseVO extends MemberHouse{

	private static final long serialVersionUID = -8556623692810736938L;
	
	private String categoryName; //类型名称

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
