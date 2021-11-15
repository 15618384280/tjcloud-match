package com.tjcloud.tenant.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum IntegralExchangeChannel {
	HF_MINNI(0, "运动合肥小程序", "0"),
	HF_APP_IOS(1, "运动合肥App_IOS", "0"),
	HF_APP_ANDROID(2, "运动合肥App_Android", "0"),
	YYD_MINI(3, "我要运动小程序", "1"),
	YYD_APP_IOS(4, "我要运动App_IOS", "1"),
	YYD_APP_ANDROID(5, "我要运动App_Android", "1"),
	XM_MINI(6, "运动厦门小程序", "2"),
	XM_APP_IOS(7, "运动厦门App_IOS", "2"),
	XM_APP_ANDROID(8, "运动厦门App_Android", "2");	
	
	private final int code;
	private final String text;
	private final String tenantId;
	
	private IntegralExchangeChannel(int code, String text, String tenantId){
		this.code = code;
		this.text = text;
		this.tenantId = tenantId;
	}
	public int getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public String getTenantId() {
		return tenantId;
	}
	public static String getText(int code) {
		for (IntegralExchangeChannel e : IntegralExchangeChannel.values()) {
			if (e.getCode() == code) {
				return e.getText();
			}
		}
		return "";
	}
	
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", this.getCode());
		map.put("text", this.getText());
		map.put("tenantId", this.getTenantId());
		return map;
	}
}
