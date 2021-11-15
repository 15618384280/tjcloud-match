package com.tjcloud.order.enums;

public enum WXMessageType {
	NOTICE_ENTER("0", "T5Ioj4u5Hct0x04O2toXXTjtI_UDnDwgCr6771f7gjc", "入场通知"),
	NOTICE_OUT("1", "R0AzVdObf31Aob7OwTSe9eMJUcrAex9-j6q0Cy66tvM", "出场通知");

	private String code;
	private String text;
	private String tplId;

	private WXMessageType(String code, String tplId, String text) {
		this.code = code;
		this.tplId = tplId;
		this.text = text;
	}

	public String getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	public String getTplId() {
		return this.tplId;
	}
	public static String getText(String code) {
		WXMessageType[] array = values();
		for (WXMessageType en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static String getTplId(String code) {
		WXMessageType[] array = values();
		for (WXMessageType en : array) {
			if (en.getCode().equals(code)) {
				return en.getTplId();
			}
		}
		return "";
	}

	public static WXMessageType get(String code) {
		WXMessageType[] array = values();
		for (WXMessageType en : array) {
			if (en.getCode().equals(code)) {
				return en;
			}
		}
		return null;
	}
}
