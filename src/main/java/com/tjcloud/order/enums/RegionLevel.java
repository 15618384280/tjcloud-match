package com.tjcloud.order.enums;

public enum RegionLevel {
	NATION(0,  "国"),
	PROVINCE(1, "省"),
	CITY(2,   "市"),
	DISTRICT(3,  "区"),
	STREET(4,  "街道");

	private Integer code;
	private String text;

	private RegionLevel(Integer code, String text) {
		this.code = code;
		this.text = text;
	}

	public Integer getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	public static String getText(Integer code) {
		RegionLevel[] array = values();
		for (RegionLevel en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}

	public static RegionLevel get(Integer code) {
		RegionLevel[] array = values();
		for (RegionLevel en : array) {
			if (en.getCode().equals(code)) {
				return en;
			}
		}
		return null;
	}
}
