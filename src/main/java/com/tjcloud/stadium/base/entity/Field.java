package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场地表(field)
 * @author auto bin.yin 2016.06.03
 */
@LogRequired
public class Field extends AbstractEntity {
	private static final long serialVersionUID = 1464942278936L;

	private String stadiumItemId; //场馆项目Id
	private String fieldName; //场地名称，一个场馆Item下，场馆名称做防重复校验
	private Integer fieldType; //场地类型，1-普通，2-会员，展示字段，暂无意义
	private String fieldCode;	// 场地编号
	private Integer sortNo; //一个场馆Item下，场馆名称做防重复校验
	private Boolean active; //一个场馆Item下，场馆名称做防重复校验
	private String tenantId; //租户Id,冗余字段
	private String stadiumId; //场馆Id,冗余字段
	
	private Long sid; 		//京东outerId 
	private Long skuId;		//京东skuId
	private Long jSkuId;  	//京东skuId
	
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public Long getjSkuId() {
		return jSkuId;
	}
	public void setjSkuId(Long jSkuId) {
		this.jSkuId = jSkuId;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getFieldName() {
		return this.fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getFieldType() {
		return this.fieldType;
	}
	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}

	public Boolean getActive() {
		return this.active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
}