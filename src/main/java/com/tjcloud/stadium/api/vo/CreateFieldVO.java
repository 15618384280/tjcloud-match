package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

public class CreateFieldVO implements Serializable{

	private static final long serialVersionUID = 7953324367921877260L;

	private String stadiumItemId; 	// 子场馆Id
	private String fieldName;	  	// 场地名
	private Integer fieldType; 	  	// 场地类型，1-普通，2-会员，展示字段，暂无意义
	private String tenantId;		// 租户Id
	private String stadiumId;		// 场馆Id
	private Boolean disabled;		// 是否禁用
	
	private Integer fieldNum; 		// 场地数量
	private Integer fieldTail;		// 场地尾缀 1-数字 2-字母
	private String fieldCode;		// 场地编号
	
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	
	public Integer getFieldNum() {
		return fieldNum;
	}
	public void setFieldNum(Integer fieldNum) {
		this.fieldNum = fieldNum;
	}
	
	public Integer getFieldTail() {
		return fieldTail;
	}
	public void setFieldTail(Integer fieldTail) {
		this.fieldTail = fieldTail;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public Integer getFieldType() {
		return fieldType;
	}
	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}
	
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
	
	public Boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
}
