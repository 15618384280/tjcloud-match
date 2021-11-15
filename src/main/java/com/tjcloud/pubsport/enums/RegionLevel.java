package com.tjcloud.pubsport.enums;

public enum RegionLevel {
	NATION(0,  "国", 1),
	PROVINCE(1, "省", 2),
	CITY(2,   "市", 3),
	DISTRICT(3,  "区", 4),
	STREET(4,  "街道", 5);

	private Integer code;
	private String text;
	private Integer ddType;

	private RegionLevel(Integer code, String text,Integer ddType) {
		this.code = code;
		this.text = text;
		this.ddType = ddType;
	}

	public Integer getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	public Integer getDdType() {
		return this.ddType;
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
	
	public static Integer getDdType(Integer code) {
		RegionLevel[] array = values();
		for (RegionLevel en : array) {
			if (en.getCode().equals(code)) {
				return en.getDdType();
			}
		}
		return null;
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
