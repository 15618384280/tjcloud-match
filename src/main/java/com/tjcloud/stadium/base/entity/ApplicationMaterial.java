package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 申请物料表
 *
 */

public class ApplicationMaterial extends AbstractEntity {


	private static final long serialVersionUID = 7934080597699652634L;

	private String applicationId;//申请人id
	private String school; //学校
	private String location; //位置
	private String phone;//电话
	private String remark;//备注

	private String flowCard; //流量卡
	private String summerWorkingSuit; //夏天工作服
	private String winterWorkingSuit; //冬天工作服
	private String nameTag;//胸牌
	private String besom; //扫把

	private String mop;//拖把
	private String bigBag; //大垃圾袋
	private String smallBag; //小垃圾袋
	private Integer status;    //审核状态   10已申请（管理员看到的待处理） 20 已发放 25已拒绝 30已确认

	private String stdId;//场馆id

	private String approveName;//审批人姓名

	private String  other;//其他类型

	private String  applicationName;//申领人姓名

	private String  applicationPhone;//申领人电话




	private List<HelperImage> applicationMaterialImageList;	//维修保修图片集

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFlowCard() {
		return flowCard;
	}

	public void setFlowCard(String flowCard) {
		this.flowCard = flowCard;
	}

	public String getSummerWorkingSuit() {
		return summerWorkingSuit;
	}

	public void setSummerWorkingSuit(String summerWorkingSuit) {
		this.summerWorkingSuit = summerWorkingSuit;
	}

	public String getWinterWorkingSuit() {
		return winterWorkingSuit;
	}

	public void setWinterWorkingSuit(String winterWorkingSuit) {
		this.winterWorkingSuit = winterWorkingSuit;
	}

	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	public String getBesom() {
		return besom;
	}

	public void setBesom(String besom) {
		this.besom = besom;
	}

	public String getMop() {
		return mop;
	}

	public void setMop(String mop) {
		this.mop = mop;
	}

	public String getBigBag() {
		return bigBag;
	}

	public void setBigBag(String bigBag) {
		this.bigBag = bigBag;
	}

	public String getSmallBag() {
		return smallBag;
	}

	public void setSmallBag(String smallBag) {
		this.smallBag = smallBag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public List<HelperImage> getApplicationMaterialImageList() {
		return applicationMaterialImageList;
	}

	public void setApplicationMaterialImageList(List<HelperImage> applicationMaterialImageList) {
		this.applicationMaterialImageList = applicationMaterialImageList;
	}

	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationPhone() {
		return applicationPhone;
	}

	public void setApplicationPhone(String applicationPhone) {
		this.applicationPhone = applicationPhone;
	}

}