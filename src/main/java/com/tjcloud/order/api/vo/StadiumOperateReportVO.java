package com.tjcloud.order.api.vo;

import java.io.Serializable;

public class StadiumOperateReportVO implements Serializable{

	private static final long serialVersionUID = 6248428665958512988L;

	private String stadiumId;
	private String stadiumName;
	private String targetAmount;
	private String targetOrderNum;
	private String amount;
	private String amountRate;
	
	private Integer year;
	private Integer month;
	private Long collectTime;
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Long getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Long collectTime) {
		this.collectTime = collectTime;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}
	public String getTargetOrderNum() {
		return targetOrderNum;
	}
	public void setTargetOrderNum(String targetOrderNum) {
		this.targetOrderNum = targetOrderNum;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmountRate() {
		return amountRate;
	}
	public void setAmountRate(String amountRate) {
		this.amountRate = amountRate;
	}
}
