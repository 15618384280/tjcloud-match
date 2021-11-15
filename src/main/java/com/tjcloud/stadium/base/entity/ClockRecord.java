package com.tjcloud.stadium.base.entity;


import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 注释(stadium_clock_record)
 * @author auto bin.yin 2016.09.07
 */
@LogRequired
public class ClockRecord extends AbstractEntity {
	private static final long serialVersionUID = 1473246775272L;

	private String stadiumId; //场馆id
	private String stadiumName; //场馆名称
	private String stadiumItemId; //子场馆id
	private String stadiumItemName; //子场馆名称
	private String userId; //用户id
	private String userName; // 用户名
	private String recordDate;
	private List<ClockRecord> clockRecords;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public List<ClockRecord> getClockRecords() {
		return this.clockRecords;
	}

	public void setClockRecords(List<ClockRecord> clockRecords) {
		this.clockRecords = clockRecords;
	}
}