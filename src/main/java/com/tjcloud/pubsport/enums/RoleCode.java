package com.tjcloud.pubsport.enums;

public enum RoleCode {
	ADMIN("ADMIN",  "超级管理员", 1),
	SUPER_ADMIN("SUPER_ADMIN",  "超级管理员", 1),
	CITY_ADMIN("CITY_ADMIN", "市级管理员", 2),
	DISTRICT_ADMIN("DISTRICT_ADMIN",   "区级管理员", 3),
	STREET_ADMIN("STREET_ADMIN",  "街道管理员", 4),
	ROLE_XUNCHA("ROLE_XUNCHA",  "巡检员", 5),
	COLLECT_INFO("COLLECT_INFO",  "信息录入员",6),
	ROLE_REPAIR("ROLE_REPAIR",  "维修人员", 6);
	
	private String code;
	private String text;
	private Integer level;

	private RoleCode(String code, String text, Integer level) {
		this.code = code;
		this.text = text;
		this.level = level;
	}

	public String getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	public Integer getLevel() {
		return this.level;
	}
	public static String getText(String code) {
		RoleCode[] array = values();
		for (RoleCode en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static Integer getLevel(String code) {
		RoleCode[] array = values();
		for (RoleCode en : array) {
			if (en.getCode().equals(code)) {
				return en.getLevel();
			}
		}
		return 0;
	}

	public static RoleCode get(String code) {
		RoleCode[] array = values();
		for (RoleCode en : array) {
			if (en.getCode().equals(code)) {
				return en;
			}
		}
		return null;
	}
}
