package com.tjcloud.tenant.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.base.entity.ImageAsset;

/**
 * 租户入驻申请(tenant_settle_apply)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class TenantSettleApply extends AbstractEntity {
	private static final long serialVersionUID = 1462850176640L;

	private String id; //id主键
	private String province; // 省
	private String city;	// 市
	private String district;// 区
	private String provinceName;// 省名
	private String cityName;// 市名
	private String districtName;
	private String companyName; //公司名称
	private String companyAbbreviation;//公司简称
	private String applicantName; //联系人名称
	private String phone; //联系电话
	private String address; //地址
	private Integer applyState; //状态(0.已提交申请,1.申请中,2.审批通过,3.驳回)
	private List<ImageAsset> licenseImgUrlList; // 图片集
	private String businessLicenseImg;//营业执照

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
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

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAbbreviation() {
		return companyAbbreviation;
	}

	public void setCompanyAbbreviation(String companyAbbreviation) {
		this.companyAbbreviation = companyAbbreviation;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getApplyState() {
		return applyState;
	}

	public void setApplyState(Integer applyState) {
		this.applyState = applyState;
	}

	public List<ImageAsset> getLicenseImgUrlList() {
		return licenseImgUrlList;
	}

	public void setLicenseImgUrlList(List<ImageAsset> licenseImgUrlList) {
		this.licenseImgUrlList = licenseImgUrlList;
	}

	public String getBusinessLicenseImg() {
		return businessLicenseImg;
	}

	public void setBusinessLicenseImg(String businessLicenseImg) {
		this.businessLicenseImg = businessLicenseImg;
	}
}