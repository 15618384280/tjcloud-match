package com.tjcloud.dd.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum CycleTypeEnum {
	DAY(0, "日"),
	WEEK(1, "周"),
	MONTH(2, "月"),
	YEAR(3, "年");

	private int code;
	private String text;

	CycleTypeEnum(int code, String text) {
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public static String getText(int code) {
		for(CycleTypeEnum e : CycleTypeEnum.values()) {
			if(e.getCode() == code) {
				return e.getText();
			}
		}
		return "";
	}
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", this.getCode());
		map.put("text", this.getText());
		return map;
	}
}
