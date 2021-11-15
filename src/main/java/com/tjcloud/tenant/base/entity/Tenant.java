package com.tjcloud.tenant.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.base.entity.ImageAsset;

/**
 * 租户表(tenant)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class Tenant extends AbstractEntity {
	private static final long serialVersionUID = 1462850469651L;

	private String tenantName; //公司全称
	private String shortName; //公司简称
	private String province; // 省
	private String city;	// 市
	private String district;// 区
	private String address; //公司地址
	private String phone; //公司电话 
	private String postcode; //邮编
	private String legalPerson; //法人代表
	private String tenantCode;	// 租户编码
	private String businessLicenseImg; // 营业执照
	private String remark;      //公司描述
	private String tenantIcon;	//公司照片
	private String score;	//评分
	private String subMchId;			//子商户号
	private Boolean isServiceProvider;	//是否服务商模式
	private Boolean subAccount;  // 是否只在电子地图分账
	
	private List<ImageAsset> imageList; // 租户图片集


	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTenantIcon() {
		return tenantIcon;
	}
	public void setTenantIcon(String tenantIcon) {
		this.tenantIcon = tenantIcon;
	}
	public String getTenantCode() {
		return tenantCode;
	}
	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
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
	
	public String getTenantName() {
		return this.tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return this.postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getBusinessLicenseImg() {
		return businessLicenseImg;
	}

	public void setBusinessLicenseImg(String businessLicenseImg) {
		this.businessLicenseImg = businessLicenseImg;
	}

	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getSubMchId() {
		return subMchId;
	}

	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}

	public Boolean getIsServiceProvider() {
		return isServiceProvider;
	}

	public void setIsServiceProvider(Boolean serviceProvider) {
		isServiceProvider = serviceProvider;
	}

	public List<ImageAsset> getImageList() {
		return imageList;
	}
	public void setImageList(List<ImageAsset> imageList) {
		this.imageList = imageList;
	}

	public Boolean getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(Boolean subAccount) {
		this.subAccount = subAccount;
	}
}