package com.tjcloud.pubsport.enums;

//调查类型（0-单位调查表，1-场地调查表）
public enum DcpoType {
	DC_ENQUIRER("单位调查表", 0),
	DC_STADIUM("场地调查表", 1);
	
	private String text;
	private Integer code;

	private DcpoType(String text, Integer code) {
		this.text = text;
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	
	public static String getText(Integer code) {
		DcpoType[] array = values();
		for (DcpoType en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static DcpoType get(Integer code) {
		DcpoType[] array = values();
		for (DcpoType en : array) {
			if (en.getCode() == code) {
				return en;
			}
		}
		return null;
	}
}
