package com.tjcloud.dd.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum AppVersionEnum {
	YYD_IOS(2, "我要运动IOS", 1),
	PT_IOS(10, "普陀大学堂IOS", 1),
	ZJG_IOS(21, "乐动港城IOS", 1),
	HF_IOS(98, "运动合肥IOS", 1),
	TJ_IOS(18, "天津场馆IOS", 1),
	TY_IOS(19, "上体场馆IOS", 1),
	
	YYD_ANDROID(1, "我要运动Android", 2),
	PT_ANDROID(9, "普陀大学堂Android", 2),
	ZJG_ANDROID(11, "乐动港城Android", 2),
    YYD_MANAGE_ANDROID(12, "我要运动商户版Android", 2),
    TY_ANDROID(13, "上体场馆Android", 2),
    TY_MANAGE_ANDROID(15, "上体场馆管理端Android", 2),
    TJ_ANDROID(14, "天津场馆Android", 2),
    TJ_MANAGE_ANDROID(16, "天津场馆管理端Android", 2),
    SCHOOL_MANAGE_ANDROID(17, "学校场地开放场馆Android", 2),
    HF_ANDROID(99, "运动合肥Android", 2);

	private int appId;
	private String text;
	private int appType;

	AppVersionEnum(int appId, String text, int appType) {
		this.appId = appId;
		this.text = text;
		this.appType = appType;
	}

	public int getAppId() {
		return appId;
	}
	public int getAppType() {
		return appType;
	}
	public String getText() {
		return text;
	}
	
	public Map<String, Object> toMap(Integer appType){
		Map<String, Object> map = null;
		if(appType != null ) {
			if(appType.intValue() == this.getAppType()) {
				map = new HashMap<String, Object>();
				map.put("appId", this.getAppId());
				map.put("text", this.getText());
			}
		}else {
			map = new HashMap<String, Object>();
			map.put("appId", this.getAppId());
			map.put("text", this.getText());
			map.put("appType", this.getAppType());
		}
		return map;
	}
}
