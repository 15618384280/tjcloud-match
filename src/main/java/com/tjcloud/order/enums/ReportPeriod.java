package com.tjcloud.order.enums;

public enum ReportPeriod {
	YEAR("Y",  "年"),
	MONTH("M", "月"),
	DAY("D",   "天"),
	HOUR("H",  "时");

	private String code;
	private String text;

	private ReportPeriod(String code, String text) {
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
		ReportPeriod[] array = values();
		for (ReportPeriod en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}

	public static ReportPeriod get(String code) {
		ReportPeriod[] array = values();
		for (ReportPeriod en : array) {
			if (en.getCode().equals(code)) {
				return en;
			}
		}
		return null;
	}
}
