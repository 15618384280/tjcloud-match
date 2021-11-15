package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆-器材报修记录表(repair_record)
 * @author auto bin.yin 2017.09.11
 */
public class Record extends AbstractEntity {
	private static final long serialVersionUID = 1505119100348L;

	private String stadiumId; //场馆场所ID
	private String equipmentId; //器材ID
	private String stadiumName; //场馆场所名称
	private String equipmentName; //器材名称
	private String reportPeople; //上报人
	private String reportPhone; //上报人-联系方式
	private String description; //上报人-描述
	private String photo; //上报人-上传照片
	private String serviceman; //维修人
	private String servicemanPhone; //维修人-联系方式
	private Integer serviceDay; //维修天数
	private String servicePrice; //维修价格（单位：元）
	private String remarks; //维修人-描述
	private String servicePhoto; //维修人-上传照片
	private String maintenanceGrade; //维修等级：一级、二级、三级
	private String status; //维修状态：0-维修中；1-已完成；
	private Long serviceTime; // 维修完成时间
	/**	查询关联数据-所需属性值	**/
	private String equipmentTypeDesc; // 器材分类名称
	private String factory; //厂家
	private String factoryTheTerm; //保修期限
	private String factoryPhone; //厂家电话
	private String[] equipmentArr; //器材ID列表

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getEquipmentId() {
		return this.equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getReportPeople() {
		return this.reportPeople;
	}
	public void setReportPeople(String reportPeople) {
		this.reportPeople = reportPeople;
	}
	public String getReportPhone() {
		return this.reportPhone;
	}
	public void setReportPhone(String reportPhone) {
		this.reportPhone = reportPhone;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return this.photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getServiceman() {
		return this.serviceman;
	}
	public void setServiceman(String serviceman) {
		this.serviceman = serviceman;
	}
	public String getServicemanPhone() {
		return this.servicemanPhone;
	}
	public void setServicemanPhone(String servicemanPhone) {
		this.servicemanPhone = servicemanPhone;
	}
	public Integer getServiceDay() {
		return this.serviceDay;
	}
	public void setServiceDay(Integer serviceDay) {
		this.serviceDay = serviceDay;
	}
	public String getServicePrice() {
		return this.servicePrice;
	}
	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getServicePhoto() {
		return this.servicePhoto;
	}
	public void setServicePhoto(String servicePhoto) {
		this.servicePhoto = servicePhoto;
	}
	public String getMaintenanceGrade() {
		return this.maintenanceGrade;
	}
	public void setMaintenanceGrade(String maintenanceGrade) {
		this.maintenanceGrade = maintenanceGrade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public Long getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(Long serviceTime) {
		this.serviceTime = serviceTime;
	}
	public String getEquipmentTypeDesc() {
		return equipmentTypeDesc;
	}
	public void setEquipmentTypeDesc(String equipmentTypeDesc) {
		this.equipmentTypeDesc = equipmentTypeDesc;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getFactoryTheTerm() {
		return factoryTheTerm;
	}
	public void setFactoryTheTerm(String factoryTheTerm) {
		this.factoryTheTerm = factoryTheTerm;
	}
	public String getFactoryPhone() {
		return factoryPhone;
	}
	public void setFactoryPhone(String factoryPhone) {
		this.factoryPhone = factoryPhone;
	}
	public String[] getEquipmentArr() {
		return equipmentArr;
	}
	public void setEquipmentArr(String[] equipmentArr) {
		this.equipmentArr = equipmentArr;
	}
	
}