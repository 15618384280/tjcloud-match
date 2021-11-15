package com.tjcloud.tenant.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum IntegralProductType {
	VOUCHER(0,"优惠券"),
	YYD_BALANCE(1, "运动豆"),
	GOODS(2, "实物");
	
	private final int code;
	private final String text;
	
	private IntegralProductType(int code, String text){
		this.code = code;
		this.text = text;
	}
	public int getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public static String getText(int code) {
		for (IntegralProductType e : IntegralProductType.values()) {
			if (e.getCode() == code) {
				return e.getText();
			}
		}
		return "";
	}
	
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", this.getCode());
		map.put("text", this.getText());
		return map;
	}
}
