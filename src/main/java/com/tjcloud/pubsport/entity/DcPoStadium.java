package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 调查记录场地信息表(dc_po_stadium)
 * @author auto bin.yin 2019.02.20
 */
public class DcPoStadium extends AbstractEntity {
	private static final long serialVersionUID = 1550639073818L;

	private Long number; //场地编码
	private Long typeNumber; //调查表类型-标识场地编码
	private Long enqNumber; //单位编码
	private Integer enteringYear; //调查年份
	private String tenantId; //所属商户
	private String enquierId; //所属单位
	private String stadiumName; //场地名称
	private String shortName; //首字母排序
	private String completionYear; //建成年份
	private Long investmentTotals; //投资合计
	private Long fiscalFunds; //财政资金
	private Long societyInvestment; //社会资本投资
	private Long annualTotal; //年度投资合计
	private Long annualTotalFinance; //2018年财政资金（万元）
	private Long annualTotalFolk; //2018年民间投资（万元）
	private String longitude; //经度,东经为正数
	private String latitude; //纬度
	private String longitude84; //经度,东经为正数
	private String latitude84; //纬度
	private String province; //省
	private String provinceNo; //省、自治区、直辖市
	private String city; //市
	private String cityNo; //市、地、州、盟
	private String district; //区
	private String districtNo; //县、市、区、旗
	private String street; //街道
	private String streetNo; //街道
	private String community; //社区（居委会）
	private String communityNo; //社区（居委会）
	private String address; //场馆地址（街、路、村）
	private String horn; //号
	private String ridgepole; //栋
	private String townCode; //城乡代码
	private String sportTypeText; //场馆运动类型
	private String floor; //楼层
	private String mainPictureUrl; //场馆图片
	private String area; //面积
	private Long holdNum; //可容纳人数
	private String contactName; //联系人姓名
	private String telephone; //联系电话
	private String transport; //交通信息
	private String licenseUrl; //营业执照
	private String introduction; //场馆描述
	private String tenantUserId; //管理员
	private String tenantUserName; //管理员
	private String paceId; //公共体育设施场地ID
	private String paceName; //公共体育设施场地名称
	private String stadiumId; //落地的场馆ID
	
	private Long chnNumber; //国家体育总局场地编码
	private Long chEnqNumber; //国家体育总局单位编码
	private String chEnquirerId;	//国标单位id
	
	private Long subQuantitySpace; 	//分项体育场地数量
	private Long subFloorSpace; 	//分项体育场地面积
	private Long auxQuantitySpace;	//附属体育场地数量
	private Long auxFloorSpace;		//附属体育场地面积
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Integer getEnteringYear() {
		return this.enteringYear;
	}
	public void setEnteringYear(Integer enteringYear) {
		this.enteringYear = enteringYear;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getEnquierId() {
		return this.enquierId;
	}
	public void setEnquierId(String enquierId) {
		this.enquierId = enquierId;
	}
	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getCompletionYear() {
		return this.completionYear;
	}
	public void setCompletionYear(String completionYear) {
		this.completionYear = completionYear;
	}
	public Long getInvestmentTotals() {
		return this.investmentTotals;
	}
	public void setInvestmentTotals(Long investmentTotals) {
		this.investmentTotals = investmentTotals;
	}
	public Long getFiscalFunds() {
		return this.fiscalFunds;
	}
	public void setFiscalFunds(Long fiscalFunds) {
		this.fiscalFunds = fiscalFunds;
	}
	public Long getSocietyInvestment() {
		return this.societyInvestment;
	}
	public void setSocietyInvestment(Long societyInvestment) {
		this.societyInvestment = societyInvestment;
	}
	public Long getAnnualTotal() {
		return annualTotal;
	}
	public void setAnnualTotal(Long annualTotal) {
		this.annualTotal = annualTotal;
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
	public String getLongitude84() {
		return longitude84;
	}
	public void setLongitude84(String longitude84) {
		this.longitude84 = longitude84;
	}
	public String getLatitude84() {
		return latitude84;
	}
	public void setLatitude84(String latitude84) {
		this.latitude84 = latitude84;
	}
	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return this.district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return this.street;
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
	
	public String getSportTypeText() {
		return sportTypeText;
	}
	public void setSportTypeText(String sportTypeText) {
		this.sportTypeText = sportTypeText;
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
	public Long getHoldNum() {
		return this.holdNum;
	}
	public void setHoldNum(Long holdNum) {
		this.holdNum = holdNum;
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
	public String getTransport() {
		return this.transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
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
	public String getTenantUserId() {
		return this.tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
	public String getTenantUserName() {
		return this.tenantUserName;
	}
	public void setTenantUserName(String tenantUserName) {
		this.tenantUserName = tenantUserName;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}
	public String getCityNo() {
		return cityNo;
	}
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}
	public String getDistrictNo() {
		return districtNo;
	}
	public void setDistrictNo(String districtNo) {
		this.districtNo = districtNo;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(String communityNo) {
		this.communityNo = communityNo;
	}
	public String getTownCode() {
		return townCode;
	}
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}
	public String getHorn() {
		return horn;
	}
	public void setHorn(String horn) {
		this.horn = horn;
	}
	public String getRidgepole() {
		return ridgepole;
	}
	public void setRidgepole(String ridgepole) {
		this.ridgepole = ridgepole;
	}
	public String getPaceId() {
		return paceId;
	}
	public void setPaceId(String paceId) {
		this.paceId = paceId;
	}
	public String getPaceName() {
		return paceName;
	}
	public void setPaceName(String paceName) {
		this.paceName = paceName;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public Long getAnnualTotalFinance() {
		return annualTotalFinance;
	}
	public void setAnnualTotalFinance(Long annualTotalFinance) {
		this.annualTotalFinance = annualTotalFinance;
	}
	public Long getAnnualTotalFolk() {
		return annualTotalFolk;
	}
	public void setAnnualTotalFolk(Long annualTotalFolk) {
		this.annualTotalFolk = annualTotalFolk;
	}
	public Long getTypeNumber() {
		return typeNumber;
	}
	public void setTypeNumber(Long typeNumber) {
		this.typeNumber = typeNumber;
	}
	public Long getEnqNumber() {
		return enqNumber;
	}
	public void setEnqNumber(Long enqNumber) {
		this.enqNumber = enqNumber;
	}
	public Long getChnNumber() {
		return chnNumber;
	}
	public void setChnNumber(Long chnNumber) {
		this.chnNumber = chnNumber;
	}
	public Long getChEnqNumber() {
		return chEnqNumber;
	}
	public void setChEnqNumber(Long chEnqNumber) {
		this.chEnqNumber = chEnqNumber;
	}
	public String getChEnquirerId() {
		return chEnquirerId;
	}
	public void setChEnquirerId(String chEnquirerId) {
		this.chEnquirerId = chEnquirerId;
	}
	public Long getSubQuantitySpace() {
		return subQuantitySpace;
	}
	public void setSubQuantitySpace(Long subQuantitySpace) {
		this.subQuantitySpace = subQuantitySpace;
	}
	public Long getSubFloorSpace() {
		return subFloorSpace;
	}
	public void setSubFloorSpace(Long subFloorSpace) {
		this.subFloorSpace = subFloorSpace;
	}
	public Long getAuxQuantitySpace() {
		return auxQuantitySpace;
	}
	public void setAuxQuantitySpace(Long auxQuantitySpace) {
		this.auxQuantitySpace = auxQuantitySpace;
	}
	public Long getAuxFloorSpace() {
		return auxFloorSpace;
	}
	public void setAuxFloorSpace(Long auxFloorSpace) {
		this.auxFloorSpace = auxFloorSpace;
	}
	
}