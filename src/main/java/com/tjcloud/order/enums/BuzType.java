package com.tjcloud.order.enums;

public enum BuzType {
	// 智能球场
	SHARE_BALLPARK_QRCODE(0, "智能球场", 0, "扫码成功"),
	SHARE_BALLPARK_UNPAID(0, "智能球场", 1, "待支付"),
	SHARE_BALLPARK_OPENDOORING(0, "智能球场", 2, "开门中..."),
	SHARE_BALLPARK_OPENDOOTED(0, "智能球场", 3, "开门成功"),
	SHARE_BALLPARK_OPENFAIR(0, "智能球场", 4, "开门失败"),
	SHARE_BALLPARK_OPENFAIR_COMPLEMENT(0, "智能球场", 5, "补充信息"),
	SHARE_BALLPARK_OPENDOOTED_MESSAGE(0, "智能球场", 6, "开门成功消息"),
	// 学校开放
	SHARE_SCHOOL_PUNCHCARD_IN(1, "学校开放", 1, "入场打卡成功"),
	SHARE_SCHOOL_PUNCHCARD_OUT(1, "学校开放", 2, "出场打卡成功"),
	// 游泳闸机
	SWIM_DOOR_RING(2, "游泳闸机", 0, "开门中..."),
	SWIM_DOOR_IN(2, "游泳闸机", 1, "入场开门成功"),
	SWIM_DOOR_OUT(2, "游泳闸机", 2, "出场开门成功"),
	//商飞
	SF_IN(99, "商飞", 1, "入场打卡成功"),
	SF_OUT(99, "商飞", 2, "出场打卡成功"),
	SF_FIELD(99, "商飞", 3, "剩余场次");

	private int buzType;			//业务类型
	private String buzText;
	private int buzState;		//业务状态
	private String buzStateText;

	private BuzType(int buzType, String buzText, int buzState, String buzStateText) {
		this.buzType = buzType;
		this.buzText = buzText;
		this.buzState = buzState;
		this.buzStateText = buzStateText;
	}
	
	public static String getBuzText(Integer buzType) {
		BuzType[] array = values();
		for (BuzType en : array) {
			if (en.getBuzType() == buzType) {
				return en.getBuzText();
			}
		}
		return "";
	}
	
	public static String getBuzStateText(Integer buzType, Integer buzState) {
		BuzType[] array = values();
		for (BuzType en : array) {
			if (en.getBuzType() == buzType && en.getBuzState() == buzState) {
				return en.getBuzStateText();
			}
		}
		return "";
	}

	public int getBuzType() {
		return buzType;
	}

	public String getBuzText() {
		return buzText;
	}

	public int getBuzState() {
		return buzState;
	}

	public String getBuzStateText() {
		return buzStateText;
	}
}
