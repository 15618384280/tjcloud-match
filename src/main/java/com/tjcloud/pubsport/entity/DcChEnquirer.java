package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 国标单位表(dc_ch_enquirer)
 * @author zhu.jian 2019.08.10
 */
public class DcChEnquirer extends AbstractEntity {
	private static final long serialVersionUID = 5915116151409235379L;
	
	private Long number; //单位编码
	private Long chnNumber; //国家体育总局单位编码
	private String tenantId; //租户ID
	private String orgCode; //组织机构代码、统一社会信用代码
	private String orgName; //单位详细名称
	private String brandId; //品牌ID
	private String legalPerson; //法定代表人
	private String telephone; //单位联系电话
	private String areaCode; //电话区号
	private String phone; //电话
	private String extPhone; //电话分机号
	private String province; //省、自治区、直辖市
	private String provinceNo; //省、自治区、直辖市
	private String city; //市、地、州、盟
	private String cityNo; //市、地、州、盟
	private String district; //县、市、区、旗
	private String districtNo; //县、市、区、旗
	private String town; //乡、镇
	private String townNo; //乡、镇
	private String street; //街、路、村
	private String horn; //号
	private String ridgepole; //栋
	private String streetOffice; //街道办事处
	private String community; //社区（居委会）
	private String communityNo; //社区（居委会）
	private String divisonCode; //区划代码
	private String townCode; //城乡代码
	private String institutional; //机构类型
	private String institutionalType; //机构类型
	private String industry; //行业类别
	private String industryCategory; //行业类别
	private String submitDate; //报出日期
	private String longitude; //经度,东经为正数
	private String latitude; //纬度

	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Long getChnNumber() {
		return chnNumber;
	}
	public void setChnNumber(Long chnNumber) {
		this.chnNumber = chnNumber;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getOrgCode() {
		return this.orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return this.orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getBrandId() {
		return this.brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getLegalPerson() {
		return this.legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExtPhone() {
		return extPhone;
	}
	public void setExtPhone(String extPhone) {
		this.extPhone = extPhone;
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
	public String getTown() {
		return this.town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return this.street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHorn() {
		return this.horn;
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
	public String getStreetOffice() {
		return this.streetOffice;
	}
	public void setStreetOffice(String streetOffice) {
		this.streetOffice = streetOffice;
	}
	public String getCommunity() {
		return this.community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getDivisonCode() {
		return this.divisonCode;
	}
	public void setDivisonCode(String divisonCode) {
		this.divisonCode = divisonCode;
	}
	public String getTownCode() {
		return this.townCode;
	}
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}
	public String getInstitutional() {
		return this.institutional;
	}
	public void setInstitutional(String institutional) {
		this.institutional = institutional;
	}
	public String getInstitutionalType() {
		return this.institutionalType;
	}
	public void setInstitutionalType(String institutionalType) {
		this.institutionalType = institutionalType;
	}
	public String getIndustry() {
		return this.industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getIndustryCategory() {
		return this.industryCategory;
	}
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}
	public String getSubmitDate() {
		return this.submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
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
	public String getTownNo() {
		return townNo;
	}
	public void setTownNo(String townNo) {
		this.townNo = townNo;
	}
	public String getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(String communityNo) {
		this.communityNo = communityNo;
	}
	
}