package com.tjcloud.enums;

public enum SmsTypeEnums {
	SMS_CODE_LOGIN("短信验证码登录", "1"),
	SMS_CODE_FORGOT_PASSWORD("忘记密码", "2"),
	SMS_CODE_ALIPAY_SHOP_BIND("支付宝商户绑定", "3"),
	SMS_CODE_ALIPAY_USER_BIND("支付宝用户绑定", "4"),
	SMS_CREATE_NEW_USER_PASSWORD("新用户创建", "5"),
	SMS_CODE_NEW_USER("新用户注册验证码", "6"),
	SMS_CODE_TENANT_APPLY_REJECT("入驻申请驳回通知", "8"),
	SMS_CODE_APP_HAS_AUTHUSER("APP用户绑定租户用户", "9"),
	SMS_CODE_TENANT_APPLY_PASS("入驻申请通过通知", "10"),
	SMS_UPDATE_USER_PASSWORD("密码修改成功短信提醒", "11"),
	SMS_CODE_UPDATE_TENANT_ACCOUNT("修改租户帐号信息", "12"),
	SMS_CODE_TICKET_ORDER_SUCCESS("票劵预定成功短信通知", "13"),
	SMS_CODE_ORDER_CANCEL_SUCCESS("订单退订成功短信通知", "14"),
	SMS_STADIUM_NOTICE_SUCCESS("订场成功短信通知场馆方", "17"),
	SMS_CODE_BINDING("手机号绑定我要运动公众号", "18"),
	SMS_THIRDPARTY_ORDER_SUCCESS("第三方订单成功通知", "19"),
	SMS_REPAIR_MESSAGE("维修短信提醒", "20"),
	SMS_REPAIR_NOTICE_MESSAGE("维修短信提醒(巡检员)", "22"),
	SMS_PASS_NOTICE_MESSAGE("维修完成短信提醒(用户)", "25"),
	SMS_CODE_LOGIN_HF("短信验证码登录", "26"),
	SMS_CODE_BINDING_HF("手机号绑定运动合肥小程序", "27"),
	SMS_CODE_CITY_APPRAISE("市民建议推送短信", "33"),
	SMS_CODE_CITY_REPAIR("市民报修通知短信", "34");

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
