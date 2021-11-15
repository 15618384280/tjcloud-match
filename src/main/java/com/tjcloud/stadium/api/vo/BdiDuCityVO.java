package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

public class BdiDuCityVO implements Serializable{

	private static final long serialVersionUID = -1022869093451227831L;
	private String code;
	private String name;
	private String cityCode;
	private String cityName;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
