package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 入馆记录
 * @author lihongzhou
 */
public class ClockRecordReportDetailVO implements Serializable{

	private static final long serialVersionUID = 6434765896953889505L;
	
	private String recordId; 		// 打卡记录
	private String stadiumItemId;	// 子项目Id
	private String userId;			// 用户id
	private String userName;		// 用户名
	private String recordDate;		// 打卡日期
	private String recordTime;		// 打卡时间

	private List<ClockRecordReportDetailVO> records;  // 打卡记录
	
	public List<ClockRecordReportDetailVO> getRecords() {
		return records;
	}
	public void setRecords(List<ClockRecordReportDetailVO> records) {
		this.records = records;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
}
