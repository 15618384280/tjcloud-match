package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.tjcloud.stadium.base.entity.ImageAsset;

/**
 * 首页查询场馆信息
 * @author lihongzhou
 */
public class SelStadiumItemInfoVO implements Serializable{

	private static final long serialVersionUID = 2113814558985468761L;
	private String stadiumItemId;		//项目id
	private String stadiumItemName;		//项目
	private String contactName;			//联系人
	private String telephone;			//电话
	private Integer bookMode;			//预定模式
	private String bookPhone;			//预定电话
	private String sportType;			//运动类型
	private String sportTypeCode;		//运动类型
	private String stadiumId;			//场馆id
	private String stadiumName;			//场馆名
	private String tenantId;			//租户id
	private String longitude;			//经度
	private String latitude;			//纬度
	private String province;			//省
	private String city;				//市
	private String district;			//区
	private String street;				//街道
	private String address;				//地址
	private String mainPictureUrl;		//图片
	private String introduction;		//描述
	private String stadiumContactName;	//场馆联系人
	private String stadiumPhone;		//场馆电话
	private Boolean platformOnline;		//平台上线
	private Boolean online;				//上线
	private Integer minPrice;			//最低价
	private Integer maxPrice;			//最高价
	private String floorHeight;			//层高
	private String environment;			//环境
	private Integer fieldCount;			//场地数量
	private String notice;				//场馆公告
	private String tagLabel;			//标签
	private String material;			//材质
	private String description;			//描述
	private Integer opennessSchool;		//0-普通场馆 1-学校场地开放
	
	private List<ImageAsset> imageList;
	private List<String> tagLabelList;	//标签
	private double distance;			//距离
	private List<String> sportTypes;	//运动类型
	private long hotTimes;				//人气
	private long holdNum;				//上限人数
	private long onlineNum;				//在场人员
	private Integer hotStatus;			//0-空闲 1-接近满员 2-满员
	private String tenantUserId;		//管理员
	private String grade;				//综合评分
	private String shortName;			//首字母
	private Boolean selfShop;			//是否为自营场馆

	private Boolean vipOpenStadium;                             //是否vip开放场馆

	private Boolean isServiceProvider;	//是否服务商模式
	private Boolean subAccount;  // 是否只在电子地图分账

	/**
	 * 开放时间
	 */
	private String openTime;
	/**
	 * 面积
	 */
	private String area;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public Boolean getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(Boolean subAccount) {
		this.subAccount = subAccount;
	}

	public Boolean getVipOpenStadium() {
		return vipOpenStadium;
	}

	public void setVipOpenStadium(Boolean vipOpenStadium) {
		this.vipOpenStadium = vipOpenStadium;
	}
	
	public Boolean getSelfShop() {
		return selfShop;
	}
	public void setSelfShop(Boolean selfShop) {
		this.selfShop = selfShop;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTenantUserId() {
		return tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
	public long getOnlineNum() {
		return onlineNum;
	}
	public void setOnlineNum(long onlineNum) {
		this.onlineNum = onlineNum;
	}
	public Integer getHotStatus() {
		return hotStatus;
	}
	public void setHotStatus(Integer hotStatus) {
		this.hotStatus = hotStatus;
	}
	public long getHoldNum() {
		return holdNum;
	}
	public void setHoldNum(long holdNum) {
		this.holdNum = holdNum;
	}
	public long getHotTimes() {
		return hotTimes;
	}
	public void setHotTimes(long hotTimes) {
		this.hotTimes = hotTimes;
	}
	public List<String> getSportTypes() {
		return sportTypes;
	}
	public void setSportTypes(List<String> sportTypes) {
		this.sportTypes = sportTypes;
	}
	public Integer getOpennessSchool() {
		return opennessSchool;
	}
	public void setOpennessSchool(Integer opennessSchool) {
		this.opennessSchool = opennessSchool;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFieldCount() {
		return fieldCount;
	}
	public void setFieldCount(Integer fieldCount) {
		this.fieldCount = fieldCount;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getFloorHeight() {
		return floorHeight;
	}
	public void setFloorHeight(String floorHeight) {
		this.floorHeight = floorHeight;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public List<String> getTagLabelList() {
		if(this.tagLabel != null && !"".equals(this.tagLabel)) {
			String[] strs = this.tagLabel.split(",");
			return Arrays.asList(strs);
		}
		return tagLabelList;
	}
	public void setTagLabelList(List<String> tagLabelList) {
		this.tagLabelList = tagLabelList;
	}
	public List<ImageAsset> getImageList() {
		return imageList;
	}
	public void setImageList(List<ImageAsset> imageList) {
		this.imageList = imageList;
	}
	public Boolean getPlatformOnline() {
		return platformOnline;
	}
	public void setPlatformOnline(Boolean platformOnline) {
		this.platformOnline = platformOnline;
	}
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
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
	public Integer getBookMode() {
		return bookMode;
	}
	public void setBookMode(Integer bookMode) {
		this.bookMode = bookMode;
	}
	public String getBookPhone() {
		return bookPhone;
	}
	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}
	public String getSportType() {
		return sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	public String getSportTypeCode() {
		return sportTypeCode;
	}
	public void setSportTypeCode(String sportTypeCode) {
		this.sportTypeCode = sportTypeCode;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMainPictureUrl() {
		return mainPictureUrl;
	}
	public void setMainPictureUrl(String mainPictureUrl) {
		this.mainPictureUrl = mainPictureUrl;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getStadiumContactName() {
		return stadiumContactName;
	}
	public void setStadiumContactName(String stadiumContactName) {
		this.stadiumContactName = stadiumContactName;
	}
	public String getStadiumPhone() {
		return stadiumPhone;
	}
	public void setStadiumPhone(String stadiumPhone) {
		this.stadiumPhone = stadiumPhone;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public String getTagLabel() {
		return tagLabel;
	}
	public void setTagLabel(String tagLabel) {
		this.tagLabel = tagLabel;
	}

	public Boolean getIsServiceProvider() {
		return isServiceProvider;
	}

	public void setIsServiceProvider(Boolean isServiceProvider) {
		this.isServiceProvider = isServiceProvider;
	}
}


