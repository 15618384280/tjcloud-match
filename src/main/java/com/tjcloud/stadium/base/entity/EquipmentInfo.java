package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆-器材信息表(repair_equipment_info)
 * @author auto bin.yin 2017.09.11
 */
public class EquipmentInfo extends AbstractEntity {
	private static final long serialVersionUID = 1505119100320L;

	private String stadiumId; //场馆ID
	private String stadiumName; //场馆名称
	private String equipmentType; //器材类型
	private String equipmentTypeDesc; //器材类型名称
	private String equipmentCode; //器材编号
	private String equipmentName; //器材名称
	private String factory; //厂家
	private String factoryTheTerm; //保修期限
	private String factoryPhone; //厂家电话
	private String imageUrl; //现场照片URL
	private String nameplateUrl; //铭牌照片URL
	private String status; //状态：0-正常；1-维修中；
	
	private String brand; //品牌
	private String model; //规格/型号
	private Integer quantity; //数量
	private String remark; //备注（场地基本器材/器材/耗材）
	private String place; //使用/存放地点

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getEquipmentType() {
		return this.equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getEquipmentCode() {
		return this.equipmentCode;
	}
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	public String getEquipmentName() {
		return this.equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getFactory() {
		return this.factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getFactoryTheTerm() {
		return this.factoryTheTerm;
	}
	public void setFactoryTheTerm(String factoryTheTerm) {
		this.factoryTheTerm = factoryTheTerm;
	}
	public String getFactoryPhone() {
		return this.factoryPhone;
	}
	public void setFactoryPhone(String factoryPhone) {
		this.factoryPhone = factoryPhone;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNameplateUrl() {
		return this.nameplateUrl;
	}
	public void setNameplateUrl(String nameplateUrl) {
		this.nameplateUrl = nameplateUrl;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEquipmentTypeDesc() {
		return equipmentTypeDesc;
	}
	public void setEquipmentTypeDesc(String equipmentTypeDesc) {
		this.equipmentTypeDesc = equipmentTypeDesc;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
}