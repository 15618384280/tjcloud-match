package com.tjcloud.stadium.api.vo;

import com.tjcloud.stadium.base.entity.StadiumNotice;

public class StadiumNoticeVo extends StadiumNotice {
	
	private static final long serialVersionUID = -8040794438619860238L;
	
	private String stadiumName; //场馆名称
	
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
}
