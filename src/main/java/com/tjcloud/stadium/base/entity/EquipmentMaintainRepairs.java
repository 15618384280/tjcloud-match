package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 *器材维修保修实体
 *
 */

public class EquipmentMaintainRepairs extends AbstractEntity {
	private static final long serialVersionUID = 6311418689798035789L;

	private String id;
	private String  name;
	private String  peopleId;

	private  Integer status;
	private String  school;
	private String  location;
	private String  type;
	private String  stadiumId;
	//报修人id
	private String  stadiumManagerId;
	//审批人id     管理员
	private String  adminId;

	private String tenantUserId;						//租户用户Id

	private String userId;								//用户Id

	private List<HelperImage> maintainRepairsImageList;	//报修图片集


	private List<HelperImage> repairsedImageList;	//已维修图片集

	private String other;						//其他

	private String descripe;								//描述

	private String approver;//审批者姓名

	private List<Integer> statusArray;	//状态数组

	private String bxName;//报修者姓名

	private String bxPhone;//报修者电话


	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(String peopleId) {
		this.peopleId = peopleId;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}


	public String getStadiumManagerId() {
		return stadiumManagerId;
	}

	public void setStadiumManagerId(String stadiumManagerId) {
		this.stadiumManagerId = stadiumManagerId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public List<HelperImage> getMaintainRepairsImageList() {
		return maintainRepairsImageList;
	}

	public void setMaintainRepairsImageList(List<HelperImage> maintainRepairsImageList) {
		this.maintainRepairsImageList = maintainRepairsImageList;
	}

	public String getTenantUserId() {
		return tenantUserId;
	}

	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	public List<HelperImage> getRepairsedImageList() {
		return repairsedImageList;
	}

	public void setRepairsedImageList(List<HelperImage> repairsedImageList) {
		this.repairsedImageList = repairsedImageList;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public List<Integer> getStatusArray() {
		return statusArray;
	}

	public void setStatusArray(List<Integer> statusArray) {
		this.statusArray = statusArray;
	}

	public String getBxName() {
		return bxName;
	}

	public void setBxName(String bxName) {
		this.bxName = bxName;
	}

	public String getBxPhone() {
		return bxPhone;
	}

	public void setBxPhone(String bxPhone) {
		this.bxPhone = bxPhone;
	}
}