package com.tjcloud.tenant.api.enums;

import java.util.HashMap;
import java.util.Map;


public enum VoucherChannelEnums {
	HF_MINNI("001", "运动合肥小程序", 1),
	HF_APP_IOS("002", "运动合肥App_IOS", 1),
	HF_APP_ANDROID("003", "运动合肥App_Android", 1),
	YYD_MINI("004","我要运动小程序", 2),
	YYD_APP_IOS("005","我要运动App_IOS", 2),
	YYD_APP_ANDROID("006","我要运动App_Android", 2),
	XM_MINI("007","运动厦门小程序", 3),
	XM_APP_IOS("008","运动厦门App_IOS", 3),
	XM_APP_ANDROID("009","运动厦门App_Android", 3);

	private String code;
	private String text;
	private int platfromId;
	
	public String getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public int getPlatfromId() {
		return platfromId;
	}
	
	VoucherChannelEnums(String code, String text, int platfromId) {
		this.code = code;
		this.text = text;
		this.platfromId = platfromId;
	}
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", this.getCode());
		map.put("text", this.getText());
		map.put("platfromId", this.getPlatfromId());
		return map;
	}
}
