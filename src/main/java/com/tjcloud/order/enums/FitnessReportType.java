package com.tjcloud.order.enums;

public enum FitnessReportType {
	SPORT_TYPE(1,  "按运动类型"),
	SEX_RATIO(2, "按男女比"),
	EARLY_LATE_RATIO(3,   "按早晚比"),
	GENERATION_RATIO(4,  "按年龄阶段比"),
	STADIUM_NAME_GROUPING (5,  "排名靠前的学校"),
	PUNCH_CARD_DETAIL(6,  "排名靠前的打卡记录"),
	SCHOOL_OPEN_DATA(7,  "学校开放信息"),
	THE_MONTH_COUNT(8, "当月运动人次");

	private Integer code;
	private String text;

	private FitnessReportType(Integer code, String text) {
		this.code = code;
		this.text = text;
	}

	public Integer getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	public static String getText(Integer code) {
		FitnessReportType[] array = values();
		for (FitnessReportType en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}

	public static FitnessReportType get(Integer code) {
		FitnessReportType[] array = values();
		for (FitnessReportType en : array) {
			if (en.getCode().equals(code)) {
				return en;
			}
		}
		return null;
	}
}
