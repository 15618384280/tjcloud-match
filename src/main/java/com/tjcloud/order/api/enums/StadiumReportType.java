package com.tjcloud.order.api.enums;

public enum StadiumReportType {
	OTHERS("其他", 0),
	PLATFORM("网络预定", 1),
	FIT("散客", 2),
	MEMBER("会员卡消费", 3),
	LONGORDER("长订", 4),
	ACTIVEORDER("活动包场", 5),
	GOODS("商品", 6);
	
	private final String text;
	private final int status;

	private StadiumReportType(String text, int status){
		this.text = text;
		this.status = status;
	}

	public String getText(){
		return text;
	}

	public int getStatus(){
		return status;
	}

	public static String getText(int status){
		for (StadiumReportType e : StadiumReportType.values()){
			if (e.getStatus() == status){
				return e.getText();
			}
		}
		return "";
	}
}
