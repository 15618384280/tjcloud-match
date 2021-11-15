package com.tjcloud.uac.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum IntegralChannelEnum {
	FIRST_LOGIN(0,"首次登录", "FIRST_LOGIN"),
	CHECK_IN(1, "签到" , "CHECK_IN"),
	SHARE(2, "分享", "SHARE"),
	COMMENT(3, "评价", "COMMENT"),
	FIELD_ORDER(4, "场地预定", "FIELD_ORDER"),
	MATCH_ORDER(5, "报名赛事", "MATCH_ORDER"),
	EXCHANGE(6, "积分兑换", "EXCHANGE"),
	BANK_CARD_APPLY(7, "银行卡申请", "BANK_CARD_APPLY"),
	WX_WALK_COUNT(8, "微信计步", "WX_WALK_COUNT");

	private int code;
	private String text;
	private String key;

	IntegralChannelEnum(int code, String text, String key) {
		this.code = code;
		this.text = text;
		this.key = key;
	}
	public int getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public String getKey() {
		return key;
	}
	public static String getText(int code) {
		for(IntegralChannelEnum e : IntegralChannelEnum.values()) {
			if(e.getCode() == code) {
				return e.getText();
			}
		}
		return "";
	}
	public static String getText(String key) {
		for(IntegralChannelEnum e : IntegralChannelEnum.values()) {
			if(e.getKey().equals(key)) {
				return e.getText();
			}
		}
		return "";
	}
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", this.getCode());
		map.put("text", this.getText());
		map.put("key", this.getKey());
		return map;
	}
}
