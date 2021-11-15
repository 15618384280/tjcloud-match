package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 身份证信息库(identity_card)
 * @author auto bin.yin 2019.01.14
 */
public class IdentityCard extends AbstractEntity {
	private static final long serialVersionUID = 1547458141095L;

	private String idcard; //身份证号码
	private String name; //姓名
	private String sex; //性别
	private String birthday; //出生日
	private String address; //地址
	private String province; //省
	private String city; //市
	private String county; //区县
	private Boolean isTrue; //身份证是否正确（0-不正确，1-正确）
	private Integer sortNo; //排序

	public String getIdcard() {
		return this.idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return this.birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getCounty() {
		return this.county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public Boolean getIsTrue() {
		return this.isTrue;
	}
	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}
	public Integer getSortNo() {
		return this.sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
}