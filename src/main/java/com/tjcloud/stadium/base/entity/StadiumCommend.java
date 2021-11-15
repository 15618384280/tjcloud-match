package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class StadiumCommend extends AbstractEntity{

	private static final long serialVersionUID = 7808164948438931301L;
	
	private String stadiumItemId;  //推荐场馆的id
	private Integer staNum;    //排序ID
	private Integer oldPrice;  //原价
	private Integer nowPrice;  //折后价
	private String source;     //ANDROID_USER 或是 IOS_USER
	private String cityCode;  //城市
	private String cityName;  //城市
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(Integer nowPrice) {
		this.nowPrice = nowPrice;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public Integer getStaNum() {
		return staNum;
	}
	public void setStaNum(Integer staNum) {
		this.staNum = staNum;
	}
	public Integer getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(Integer oldPrice) {
		this.oldPrice = oldPrice;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
