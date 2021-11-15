package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 健身场所(ps_sports_place)
 * @author auto bin.yin 2018.02.27
 */
public class SportsPlace extends AbstractEntity {
	private static final long serialVersionUID = 1519719772134L;

	private String tenantId; //租户ID
	private String code; //场所编号
	private String name; //场所名称
	private String address; //场所地址
	private String typeId; //场所类型ID
	private String typeName; //场所类型名称
	private Double footpathLength; //长度
	private Double wide; //宽
	private String texture; // 材质
	private Double acreage; //面积
	private String buildUpTime; //建成时间
	private String investmentNature; //投资性质(旧)
	private String investmentSource; //投资性质
	private String patrolman; //巡查人员
	private String patrolmanName; //巡查人员
	private String supervisePhone; //监督电话
	private String repairman; //维修人员
	private String repairmanName; //维修人员
	private String socialInstructor; //社会指导员
	private String repairPhone; //维修人员
	private String province; //省
	private String provinceName; //省名称
	private String city; //市
	private String cityName; //市名称
	private String district; //区
	private String districtName; //区名称
	private String street; //街道
	private String streetName; //街道名称
	private String committee; //居委
	private String committeeName; //居委名称
	private String longitude; //经度
	private String latitude; //纬度
	private String gpsLongitude; //GPS坐标系-经度
	private String gpsLatitude; //GPS坐标系-纬度
	private String workdayOpenTime; //工作日开放开始时间
	private String workdayCloseTime; //工作日开放结束时间
	private String weekdayOpenTime; //节假日开放开始时间
	private String weekdayCloseTime; //节假日开放结束时间
	private String trafficInformation; //交通信息
	private String image; //健身场所图片
	private Boolean needCollect; //是否需要信息采集
	private Integer collectStatus; //信息采集状态
	private String collectId;
	private String collectName;
	private Long collectTime;
	private Integer collectAuditStatus; //信息采集审核状态
	private String collectAuditId; //信息采集审核人员ID
	private String collectAuditName; //信息采集审核人员名称
	private Long collectAuditTime; //信息采集审核时间
	private String collectAuditText; //信息采集审核意见
	private Boolean isOnline; //是否在线
	private Integer auditStatus; //审核状态(0.待审核,1.审核通过,2.审核不通过)
	private String auditName; //审核人
	private Long auditTime; //审核时间
	private String auditText; //审核意见
	private String distance; //距离
	private Boolean isBind; //是否被绑定
	private Boolean hasBoard; //是否有公示牌
	private Boolean isOpen;//是否开放

	private String phone;
	private List<SportsPlaceMaterial> materialList;
	private String regional;    //所属地域
    private List<SportsPlaceItem> sportsPlaceItemList;  // 子项目列表
	private String constructionType; //建设类型(1-新建，2-改建)
	private String projectType; //工程类型(1-市政府实施工程、2-市政府常规项目)
	private Boolean internalDisabled;  //内部删除(签到不计算)

	public Boolean getInternalDisabled() {
		return internalDisabled;
	}

	public void setInternalDisabled(Boolean internalDisabled) {
		this.internalDisabled = internalDisabled;
	}

	public String getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(String constructionType) {
		this.constructionType = constructionType;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Double getAcreage() {
		return acreage;
	}

	public void setAcreage(Double acreage) {
		this.acreage = acreage;
	}

	public String getBuildUpTime() {
		return buildUpTime;
	}
	public void setBuildUpTime(String buildUpTime) {
		this.buildUpTime = buildUpTime;
	}
	public String getInvestmentNature() {
		return investmentNature;
	}
	public void setInvestmentNature(String investmentNature) {
		this.investmentNature = investmentNature;
	}
	public String getPatrolman() {
		return patrolman;
	}
	public void setPatrolman(String patrolman) {
		this.patrolman = patrolman;
	}
	public String getPatrolmanName() {
		return patrolmanName;
	}
	public void setPatrolmanName(String patrolmanName) {
		this.patrolmanName = patrolmanName;
	}
	public String getSupervisePhone() {
		return supervisePhone;
	}
	public void setSupervisePhone(String supervisePhone) {
		this.supervisePhone = supervisePhone;
	}
	public String getRepairman() {
		return repairman;
	}
	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}
	public String getRepairmanName() {
		return repairmanName;
	}
	public void setRepairmanName(String repairmanName) {
		this.repairmanName = repairmanName;
	}
	public String getSocialInstructor() {
		return socialInstructor;
	}
	public void setSocialInstructor(String socialInstructor) {
		this.socialInstructor = socialInstructor;
	}
	public String getRepairPhone() {
		return repairPhone;
	}
	public void setRepairPhone(String repairPhone) {
		this.repairPhone = repairPhone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	public String getWorkdayOpenTime() {
		return workdayOpenTime;
	}
	public void setWorkdayOpenTime(String workdayOpenTime) {
		this.workdayOpenTime = workdayOpenTime;
	}
	public String getWorkdayCloseTime() {
		return workdayCloseTime;
	}
	public void setWorkdayCloseTime(String workdayCloseTime) {
		this.workdayCloseTime = workdayCloseTime;
	}
	public String getWeekdayOpenTime() {
		return weekdayOpenTime;
	}
	public void setWeekdayOpenTime(String weekdayOpenTime) {
		this.weekdayOpenTime = weekdayOpenTime;
	}
	public String getWeekdayCloseTime() {
		return weekdayCloseTime;
	}
	public void setWeekdayCloseTime(String weekdayCloseTime) {
		this.weekdayCloseTime = weekdayCloseTime;
	}
	public String getTrafficInformation() {
		return trafficInformation;
	}
	public void setTrafficInformation(String trafficInformation) {
		this.trafficInformation = trafficInformation;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getNeedCollect() {
		return needCollect;
	}
	public void setNeedCollect(Boolean needCollect) {
		this.needCollect = needCollect;
	}
	public Integer getCollectStatus() {
		return collectStatus;
	}
	public void setCollectStatus(Integer collectStatus) {
		this.collectStatus = collectStatus;
	}
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public String getCollectName() {
		return collectName;
	}
	public void setCollectName(String collectName) {
		this.collectName = collectName;
	}
	public Long getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Long collectTime) {
		this.collectTime = collectTime;
	}
	public Integer getCollectAuditStatus() {
		return collectAuditStatus;
	}
	public void setCollectAuditStatus(Integer collectAuditStatus) {
		this.collectAuditStatus = collectAuditStatus;
	}
	public String getCollectAuditId() {
		return collectAuditId;
	}
	public void setCollectAuditId(String collectAuditId) {
		this.collectAuditId = collectAuditId;
	}
	public String getCollectAuditName() {
		return collectAuditName;
	}
	public void setCollectAuditName(String collectAuditName) {
		this.collectAuditName = collectAuditName;
	}
	public Long getCollectAuditTime() {
		return collectAuditTime;
	}
	public void setCollectAuditTime(Long collectAuditTime) {
		this.collectAuditTime = collectAuditTime;
	}
	public String getCollectAuditText() {
		return collectAuditText;
	}
	public void setCollectAuditText(String collectAuditText) {
		this.collectAuditText = collectAuditText;
	}
	public Boolean getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getAuditName() {
		return auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	public Long getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Long auditTime) {
		this.auditTime = auditTime;
	}
	public String getAuditText() {
		return auditText;
	}
	public void setAuditText(String auditText) {
		this.auditText = auditText;
	}
	public String getGpsLongitude() {
		return gpsLongitude;
	}
	public void setGpsLongitude(String gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	public String getGpsLatitude() {
		return gpsLatitude;
	}
	public void setGpsLatitude(String gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public Boolean getHasBoard() {
		return hasBoard;
	}
	public void setHasBoard(Boolean hasBoard) {
		this.hasBoard = hasBoard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<SportsPlaceMaterial> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(List<SportsPlaceMaterial> materialList) {
		this.materialList = materialList;
	}
	public Boolean getIsBind() {
		return isBind;
	}
	public void setIsBind(Boolean isBind) {
		this.isBind = isBind;
	}

	public String getInvestmentSource() {
		return investmentSource;
	}

	public void setInvestmentSource(String investmentSource) {
		this.investmentSource = investmentSource;
	}

	public List<SportsPlaceItem> getSportsPlaceItemList() {
		return sportsPlaceItemList;
	}

	public void setSportsPlaceItemList(List<SportsPlaceItem> sportsPlaceItemList) {
		this.sportsPlaceItemList = sportsPlaceItemList;
	}

	public String getCommittee() {
		return committee;
	}

	public void setCommittee(String committee) {
		this.committee = committee;
	}

	public String getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}

	public Double getFootpathLength() {
		return footpathLength;
	}

	public void setFootpathLength(Double footpathLength) {
		this.footpathLength = footpathLength;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public Double getWide() {
		return wide;
	}

	public void setWide(Double wide) {
		this.wide = wide;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
}