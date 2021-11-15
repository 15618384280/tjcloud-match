package com.tjcloud.stadium.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆表(stadium)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class Stadium extends AbstractEntity {
	private static final long serialVersionUID = 1462853057536L;

	private String tenantId; 									//所属商户
	private String stadiumName; 								//场馆名称
	private String shortName;									//首字母拼音
	private String longitude; 									//经度,东经为正数
	private String latitude; 									//纬度
	private String province; 									// 省
	private String city;										// 市
	private String district; 									// 区
	private String street; 										// 街道
	private String address; 									//场馆地址
	private String floor; 										//楼层
	private String mainPictureUrl; 								//场馆图片
	private String area; 										//面积
	private Integer holdNum;									//可容纳人数
	private String contactName; 								//联系人姓名
	private String telephone; 									//联系电话
	private String licenseUrl; 									//营业执照
	private String introduction; 								//场馆描述
	private Boolean opennessSchool; 							//学校开放场馆
	private Boolean isShare; 									//是否共享场馆
	private Integer source;										//0-我要运动,1-携程,2-上海体育局
	private String venueId;										//第三方渠道场馆id
	private String tenantUserId;								//管理员
	private String tenantUserName;								//管理员
	private String transport;									//交通信息
	private String services;									//周边服务
	private String discountInfo;								//打折信息
	private String openTime;									//开放时间
	private String grade;										//评分
	private Long hotTimes;										//人气
	private Long onlineNum;										//在场人数
	private Long sid;								
	private Boolean selfShop;									//是否自营
	private Boolean vipOpenStadium;                             //是否vip开放场馆
	private Boolean zfbOnline;                                  //支付宝上线,true-上线
	private String zfbVenueId;                                  //支付宝场馆id

	/**
	 * 场馆所属 0 我要运动，1 健身房
	 */
	private Integer stadiumType;

	public Integer getStadiumType() {
		return stadiumType;
	}

	public void setStadiumType(Integer stadiumType) {
		this.stadiumType = stadiumType;
	}

	public Boolean getVipOpenStadium() {
		return vipOpenStadium;
	}

	public void setVipOpenStadium(Boolean vipOpenStadium) {
		this.vipOpenStadium = vipOpenStadium;
	}

	private List<ImageAsset> slideImageList; // 幻灯片集
	
	public Boolean getSelfShop() {
		return selfShop;
	}
	public void setSelfShop(Boolean selfShop) {
		this.selfShop = selfShop;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public Long getOnlineNum() {
		return onlineNum;
	}
	public void setOnlineNum(Long onlineNum) {
		this.onlineNum = onlineNum;
	}
	public Long getHotTimes() {
		return hotTimes;
	}
	public void setHotTimes(Long hotTimes) {
		this.hotTimes = hotTimes;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
	public Integer getHoldNum() {
		return holdNum;
	}
	public void setHoldNum(Integer holdNum) {
		this.holdNum = holdNum;
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public List<ImageAsset> getSlideImageList() {
		return slideImageList;
	}
	public void setSlideImageList(List<ImageAsset> slideImageList) {
		this.slideImageList = slideImageList;
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
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getLongitude() {
		return this.longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getFloor() {
		return this.floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getMainPictureUrl() {
		return this.mainPictureUrl;
	}
	public void setMainPictureUrl(String mainPictureUrl) {
		this.mainPictureUrl = mainPictureUrl;
	}

	public String getArea() {
		return this.area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLicenseUrl() {
		return this.licenseUrl;
	}
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getIntroduction() {
		return this.introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Boolean getOpennessSchool() {
		return opennessSchool;
	}
	public void setOpennessSchool(Boolean opennessSchool) {
		this.opennessSchool = opennessSchool;
	}
	public Boolean getIsShare() {
		return isShare;
	}
	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
	}

	public Boolean getZfbOnline() {
		return zfbOnline;
	}

	public void setZfbOnline(Boolean zfbOnline) {
		this.zfbOnline = zfbOnline;
	}

	public String getZfbVenueId() {
		return zfbVenueId;
	}

	public void setZfbVenueId(String zfbVenueId) {
		this.zfbVenueId = zfbVenueId;
	}
}