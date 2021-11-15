package com.tjcloud.enums;

public enum MQTopicEnums {
	NEW_MOBILE_LOGIN("新用户注册", "new_mobile_login"),
	TENANT_CREATE_RIGHT("创建租户权限", "tenant_create_right"),
	DATA_COLLECT_SWIM("人流量数据采集", "data_collect_swim");

	private String code;
	private String text;

	private MQTopicEnums(String text, String code) {
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
		MQTopicEnums[] array = values();
		for (MQTopicEnums en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
}
