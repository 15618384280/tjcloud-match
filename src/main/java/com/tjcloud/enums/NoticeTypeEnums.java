package com.tjcloud.enums;

public enum NoticeTypeEnums {
	ORDER_PAY_SUCCESS("1", "下单支付成功提醒");

	private String code;
	private String text;

	private NoticeTypeEnums(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}

	public String getText(String status) {
		NoticeTypeEnums[] array = values();
		for (NoticeTypeEnums en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
}
