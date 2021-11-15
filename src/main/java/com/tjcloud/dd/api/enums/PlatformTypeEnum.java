package com.tjcloud.dd.api.enums;

public enum PlatformTypeEnum {
	YYD("yyd", "我要运动");

	private String code;
	private String text;

	PlatformTypeEnum(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public static String getText(String code) {
		for(PlatformTypeEnum e : PlatformTypeEnum.values()) {
			if(e.getCode().equals(code)) {
				return e.getText();
			}
		}
		return "";
	}
	
	@Override
	public String toString() {
		return this.code;
	}
}
