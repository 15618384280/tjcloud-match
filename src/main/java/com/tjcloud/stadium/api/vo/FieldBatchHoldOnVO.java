package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 批量挂起VO
 * @author lihongzhou
 */
public class FieldBatchHoldOnVO implements Serializable{

	private static final long serialVersionUID = -2128915573281106964L;
	
	private String stadiumId;		// 场馆Id
	private String stadiumItemId;	// 场馆项目Id
	private String beginDate;		// 开始日期
	private String endDate;			// 结束日期
	private String beginTime;		// 开始时间
	private String endTime;			// 结束时间
	private Integer reasonType;		// 挂起原因
	private String remark;			// 挂起原因补充
	private String tenantId;		// 租户Id
	
	private List<String> fieldIds;	// 场地Id

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public Integer getReasonType() {
		return reasonType;
	}
	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<String> getFieldIds() {
		return fieldIds;
	}
	public void setFieldIds(List<String> fieldIds) {
		this.fieldIds = fieldIds;
	}
}
