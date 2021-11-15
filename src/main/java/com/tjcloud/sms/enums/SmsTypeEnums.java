package com.tjcloud.sms.enums;

public enum SmsTypeEnums {
	SMS_CODE_LOGIN("短信验证码登录", "1"),
	SMS_CODE_FORGOT_PASSWORD("忘记密码", "2"),
	SMS_CODE_ALIPAY_SHOP_BIND("支付宝商户绑定", "3"),
	SMS_CODE_ALIPAY_USER_BIND("支付宝用户绑定", "4"),
	SMS_CREATE_NEW_USER_PWD("新用户创建", "5"),
	SMS_CODE_NEW_USER("新用户注册验证码", "6");
	

	private String text;
	private String code;

	private SmsTypeEnums(String text, String code) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}

	public static String getText(String code) {
		SmsTypeEnums[] array = values();
		for (SmsTypeEnums en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
}
