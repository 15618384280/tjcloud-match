package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.tjcloud.stadium.base.entity.Stadium;
import com.tjcloud.stadium.base.entity.StadiumItem;

/**
 * 场馆基本信息兼子项列表
 * @author lihongzhou
 */
public class StadiumListVO implements Serializable{

	private static final long serialVersionUID = 8180964186767099237L;

	private String stadiumId;
	private String tenantId;
	private String stadiumName;
	private String longitude; //经度,东经为正数
	private String latitude; //纬度
	private String province; // 省
	private String city;	// 市
	private String district; // 区
	private String street; 										// 街道
	private String address; //场馆地址
	private String floor; //楼层
	private String mainPictureUrl; //场馆图片
	private String area; //面积
	private String contactName; //联系人姓名
	private String telephone; //联系电话
	private String licenseUrl; //营业执照
	private String introduction; //场馆描述
	
	private List<StadiumItem> stadiumItemList; //子项目

	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
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

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getMainPictureUrl() {
		return mainPictureUrl;
	}
	public void setMainPictureUrl(String mainPictureUrl) {
		this.mainPictureUrl = mainPictureUrl;
	}

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

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

	public String getLicenseUrl() {
		return licenseUrl;
	}
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<StadiumItem> getStadiumItemList() {
		return stadiumItemList;
	}
	public void setStadiumItemList(List<StadiumItem> stadiumItemList) {
		this.stadiumItemList = stadiumItemList;
	}
	public StadiumListVO() {
		super();
	}
	
	public StadiumListVO(Stadium stadium) {
		setStadiumId(stadium.getId());
		setStadiumName(stadium.getStadiumName());
		setTenantId(stadium.getTenantId());
		setLongitude(stadium.getLongitude());
		setLatitude(stadium.getLatitude());
		setProvince(stadium.getProvince());
		setCity(stadium.getCity());
		setDistrict(stadium.getDistrict());
		setStreet(stadium.getStreet());
		setAddress(stadium.getAddress());
		setFloor(stadium.getFloor());
		setMainPictureUrl(stadium.getMainPictureUrl());
		setArea(stadium.getArea());
		setContactName(stadium.getContactName());
		setTelephone(stadium.getTelephone());
		setLicenseUrl(stadium.getLicenseUrl());
		setIntroduction(stadium.getIntroduction());
	}
}
