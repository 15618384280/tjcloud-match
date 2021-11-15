package com.tjcloud.pubsport.enums;

//机构类型
public enum Institutional {
	INS_COMPANY("企业", "10"),
	PUBLIC_INSTITUTION("事业单位", "20"),
	INSTITUTION("机关", "30"),
	SOCIAL_ORGANIZATION("社会团体", "40"),
	PRIVATE_NON_ENTERPRISE("民办非企业单位", "51"),
	FOUNDATION("基金会", "52"),
	NEIGHBORHOOD("居委会", "53"),
	VILLAGE_COMMITTEE("村委会", "54"),
	COOPERATION("农村专业合作社", "55"),
	ECONOMIC_ORGANIZATION("农村集体经济组织", "56"),
	INSTITUTIONAL_FRAMEWORK("其他组织机构", "90");
	
	private String text;
	private String code;

	private Institutional(String text, String code) {
		this.text = text;
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	
	public static String getText(String code) {
		Institutional[] array = values();
		for (Institutional en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static String getCode(String text) {
		Institutional[] array = values();
		for (Institutional en : array) {
			if (en.getText().equals(text)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static Institutional get(String code) {
		Institutional[] array = values();
		for (Institutional en : array) {
			if (en.getCode() == code) {
				return en;
			}
		}
		return null;
	}
}
