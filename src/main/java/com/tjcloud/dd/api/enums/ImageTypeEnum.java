package com.tjcloud.dd.api.enums;

public enum ImageTypeEnum {
	IMAGE("IMAGE", "图片"),
	QR_CODE("QRCODE", "二维码"),
	BR_CODE("BRCODE", "一维码");

	private String code;
	private String text;

	ImageTypeEnum(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return code;
	}
	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return this.code;
	}
}
