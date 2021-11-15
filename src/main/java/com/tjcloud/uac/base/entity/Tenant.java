package com.tjcloud.uac.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 租户表(uac_tenant)
 * @author auto bin.yin 2016.10.21
 */
public class Tenant extends AbstractEntity {
	private static final long serialVersionUID = 1477049082257L;

	private String code; //公司代码
	private String name; //公司全称
	private String shortName; //公司简称
	private String province; //省
	private String city; //市
	private String district; //区
	private String address; //公司地址
	private String phone; //公司电话 
	private String postcode; //邮编
	private String legalPerson; //法人代表

	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
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
	public String getLegalPerson() {
		return this.legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
}