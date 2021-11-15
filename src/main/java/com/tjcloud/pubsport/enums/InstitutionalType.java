package com.tjcloud.pubsport.enums;

//机构类型
public enum InstitutionalType {
	INS_COMPANY("企业", 1),
	PUBLIC_INSTITUTION("事业单位", 2),
	INSTITUTION("机关", 3),
	SOCIAL_ORGANIZATION("社会团体", 4),
	PRIVATE_NON_ENTERPRISE("民办非企业单位", 5),
	FOUNDATION("基金会", 6),
	NEIGHBORHOOD("居委会", 7),
	VILLAGE_COMMITTEE("村委会", 8),
	COOPERATION("农村专业合作社", 9),
	ECONOMIC_ORGANIZATION("农村集体经济组织", 10),
	INSTITUTIONAL_FRAMEWORK("其他组织机构", 11);
	
	private String text;
	private Integer code;

	private InstitutionalType(String text, Integer code) {
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
		InstitutionalType[] array = values();
		for (InstitutionalType en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static InstitutionalType get(Integer code) {
		InstitutionalType[] array = values();
		for (InstitutionalType en : array) {
			if (en.getCode() == code) {
				return en;
			}
		}
		return null;
	}
}
