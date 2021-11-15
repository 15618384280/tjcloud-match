package com.tjcloud.uac.api.enums;

public enum IntegralTransTypeEnum {
	ADD(0, "获取"),
	PAY(1, "消费");

	private int code;
	private String text;

	IntegralTransTypeEnum(int code, String text) {
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
		for(IntegralTransTypeEnum e : IntegralTransTypeEnum.values()) {
			if(e.getCode() == code) {
				return e.getText();
			}
		}
		return "";
	}
}
