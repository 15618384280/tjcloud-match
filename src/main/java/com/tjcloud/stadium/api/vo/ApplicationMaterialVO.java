package com.tjcloud.stadium.api.vo;

import com.tjcloud.stadium.base.entity.ImageAsset;

import java.io.Serializable;
import java.util.List;

/**
 * 申请物料
 */
public class ApplicationMaterialVO implements Serializable{


	private static final long serialVersionUID = 6142133104609289542L;

	private String applicationId;
	private String school;
	private String location;
	private String phone;
	private String remark;

	private String flowCard;
	private String summerWorkingSuit;
	private String winterWorkingSuit;
	private String nameTag;
	private String besom;

	private String mop;
	private String bigBag;
	private String smallBag;
	private String status;


	private List<ImageAsset> imageList; // 图片集


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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ImageAsset> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageAsset> imageList) {
		this.imageList = imageList;
	}
}
