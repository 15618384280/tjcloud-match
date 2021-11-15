package com.tjcloud.pubsport.enums;

public enum SportsLogOperate {
	INSERT("新增", 0),
	UPDATE("修改", 1),
	DELETE("删除", 2);
	
	private String text;
	private Integer code;

	private SportsLogOperate(String text, Integer code) {
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
		SportsLogOperate[] array = values();
		for (SportsLogOperate en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static SportsLogOperate get(Integer code) {
		SportsLogOperate[] array = values();
		for (SportsLogOperate en : array) {
			if (en.getCode() == code) {
				return en;
			}
		}
		return null;
	}
}
