package com.tjcloud.pubsport.enums;

public enum SportsLogResource {
	PLACE("场所", 0),
	MATERIAL("器材", 1);
	
	private String text;
	private Integer code;

	private SportsLogResource(String text, Integer code) {
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
		SportsLogResource[] array = values();
		for (SportsLogResource en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static SportsLogResource get(Integer code) {
		SportsLogResource[] array = values();
		for (SportsLogResource en : array) {
			if (en.getCode() == code) {
				return en;
			}
		}
		return null;
	}
}
