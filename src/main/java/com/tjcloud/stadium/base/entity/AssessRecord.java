package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (assess_record)考核记录表
 * @author zhujian 2020.03.20
 */
public class AssessRecord extends AbstractEntity {
	private static final long serialVersionUID = -4317315644679685293L;
	
	private String userId;					//用户id
	private Integer mode;					//模式:0-场内考核,1-场外考核
	private String recordDate;				//审核日期,yyyy-MM-dd
	private String year;					//年,yyyy
	private String month;					//月,yyyy-MM
	private Integer score;					//分数
	private String remark;					//备注
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
