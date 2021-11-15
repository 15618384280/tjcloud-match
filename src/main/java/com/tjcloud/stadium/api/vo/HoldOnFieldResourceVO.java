package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
/**
 * 场地资源挂起
 * @author lihongzhou
 */
public class HoldOnFieldResourceVO implements Serializable{

	private static final long serialVersionUID = -8814731821973651315L;

	private String fieldId;		// 场地Id
	private String resourceDate;// 资源日期
	private String beginTime;	// 开始时间
	private String endTime;		// 结束时间
	
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getResourceDate() {
		return resourceDate;
	}
	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
