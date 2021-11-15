package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.tjcloud.stadium.base.entity.ImageAsset;
import com.tjcloud.stadium.base.entity.Stadium;
import com.tjcloud.stadium.base.entity.StadiumItem;

/**
 * 场馆
 * @author lihz
 */
public class StadiumVO implements Serializable{

	private static final long serialVersionUID = 8086760951940148378L;

	private String id;
	private String stadiumName;
	private String shortName;
	private String tenantId;
	private String longitude; //经度,东经为正数
	private String latitude; //纬度
	private String province; // 省
	private String city;	// 市
	private String district; // 区
	private String street;	//街道
	private String address; //场馆地址
	private String floor; //楼层
	private String mainPictureUrl; //场馆图片
	private String area; //面积
	private String contactName; //联系人姓名
	private String telephone; //联系电话
	private String licenseUrl; //营业执照
	private String introduction; //场馆描述
	private Boolean disabled; //启用禁用
	
	private String provinceText;
	private String cityText;
	private String districtText;
	private String streetText;
	
	private Boolean opennessSchool; 							//学校开放场馆
	private Integer holdNum;									//可容纳人数
	private String tenantUserId;								//管理员
	private String tenantUserName;								//管理员
	private String transport;									//交通信息
	private String services;									//周边服务
	private String discountInfo;								//打折信息
	private String openTime;									//开放时间
	private String grade;										//评分
	private Long hotTimes;										//人气
	private Long onlineNum;										//在场人数
	private Boolean vipOpenStadium;                             //是否vip开放场馆


	public Boolean getVipOpenStadium() {
		return vipOpenStadium;
	}

	public void setVipOpenStadium(Boolean vipOpenStadium) {
		this.vipOpenStadium = vipOpenStadium;
	}
	
	private List<ImageAsset> slideImageList; // 幻灯片集	
	private List<StadiumItem> stadiumItem; // 幻灯片集	
	
	public Boolean getOpennessSchool() {
		return opennessSchool;
	}
	public void setOpennessSchool(Boolean opennessSchool) {
		this.opennessSchool = opennessSchool;
	}
	public Integer getHoldNum() {
		return holdNum;
	}
	public void setHoldNum(Integer holdNum) {
		this.holdNum = holdNum;
	}
	public String getTenantUserId() {
		return tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
	public String getTenantUserName() {
		return tenantUserName;
	}
	public void setTenantUserName(String tenantUserName) {
		this.tenantUserName = tenantUserName;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getDiscountInfo() {
		return discountInfo;
	}
	public void setDiscountInfo(String discountInfo) {
		this.discountInfo = discountInfo;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getHotTimes() {
		return hotTimes;
	}
	public void setHotTimes(Long hotTimes) {
		this.hotTimes = hotTimes;
	}
	public Long getOnlineNum() {
		return onlineNum;
	}
	public void setOnlineNum(Long onlineNum) {
		this.onlineNum = onlineNum;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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
	public Boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public String getProvinceText() {
		return provinceText;
	}
	public void setProvinceText(String provinceText) {
		this.provinceText = provinceText;
	}
	public String getCityText() {
		return cityText;
	}
	public void setCityText(String cityText) {
		this.cityText = cityText;
	}
	public String getDistrictText() {
		return districtText;
	}
	public void setDistrictText(String districtText) {
		this.districtText = districtText;
	}
	public String getStreetText() {
		return streetText;
	}
	public void setStreetText(String streetText) {
		this.streetText = streetText;
	}
	public List<ImageAsset> getSlideImageList() {
		return slideImageList;
	}
	public void setSlideImageList(List<ImageAsset> slideImageList) {
		this.slideImageList = slideImageList;
	}
	public List<StadiumItem> getStadiumItem() {
		return stadiumItem;
	}
	public void setStadiumItem(List<StadiumItem> stadiumItem) {
		this.stadiumItem = stadiumItem;
	}
	public StadiumVO() {
		super();
	}
	public StadiumVO(Stadium stadium) {
		setId(stadium.getId());
		setStadiumName(stadium.getStadiumName());
		setShortName(stadium.getShortName());
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
		setDisabled(stadium.isDisabled());
		setOpennessSchool(stadium.getOpennessSchool());
		setHoldNum(stadium.getHoldNum());
		setTenantUserId(stadium.getTenantUserId());
		setTenantUserName(stadium.getTenantUserName());
		setTransport(stadium.getTransport());
		setServices(stadium.getServices());
		setDiscountInfo(stadium.getDiscountInfo());
		setOpenTime(stadium.getOpenTime());
		setGrade(stadium.getGrade());
		setHotTimes(stadium.getHotTimes());
		setOnlineNum(stadium.getOnlineNum());
		setVipOpenStadium(stadium.getVipOpenStadium());
	}
}
