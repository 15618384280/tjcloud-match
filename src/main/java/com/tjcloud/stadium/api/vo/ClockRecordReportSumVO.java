package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

public class ClockRecordReportSumVO implements Serializable{

	private static final long serialVersionUID = -8716148497155863126L;

	private long sum;
	private String stadiumItemId;
	private String stadiumItemName;
	
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
}
