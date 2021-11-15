package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.tjcloud.stadium.base.entity.ImageAsset;

public class SelectStadiumVO implements Serializable{
	private static final long serialVersionUID = 7644829218862120815L;

	private String stadiumId;		// 场馆Id
	private String stadiumName; 	// 场馆名
	private String province;		// 省
	private String city;			// 市
	private String district;		// 区
	private String address;			// 地址
	private String longitude;		// 经度
	private String latitude;		// 纬度
	private String introduction;	// 场馆介绍
	private String tagLabel;		// 服务标签
	private String contactName;		// 联系人
	private String telephone;		// 电话
	private double distance;		// 距离

	private List<ImageAsset> imageUrlList;// 图片

	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTagLabel() {
		return tagLabel;
	}
	public void setTagLabel(String tagLabel) {
		this.tagLabel = tagLabel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public List<ImageAsset> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<ImageAsset> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
}
