package com.tjcloud.tenant.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum VoucherTemplateTypeEnums {
	NEW_USER("新用户",1),
	LOTTERY("抽奖券",2),
	COUPON("抵扣券",3),
	INTEGRAL_EXCHANGE("积分兑换券", 4);
	
	private final String text;
	private final int code;
	
	private VoucherTemplateTypeEnums(String text, int code) {
		this.text = text;
		this.code = code;
	}
	
	public String getText() {
		return text;
	}
	public int getCode() {
		return code;
	}
	public static String getText(int status) {
		for (VoucherTemplateTypeEnums e : VoucherTemplateTypeEnums.values()) {
			if (e.getCode() == status) {
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
