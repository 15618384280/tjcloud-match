package com.tjcloud.uac.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 用户实名认证信息表(user_certification_hf)
 * @author auto bin.yin 2019.03.08
 */
public class UserCertificationHf extends AbstractEntity {
	private static final long serialVersionUID = 1552012224707L;

	private String userId; //用户id
	private String name; //姓名
	private Integer certificateType; //0-身份证
	private String idCard; //身份证
	private String gender; //性别
	private String nation; //民族
	private String birthday; //生日
	private String address; //住址
	private String idUrl; //身份证正面
	
	public Integer getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return this.idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return this.nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
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
	public String getIdUrl() {
		return this.idUrl;
	}
	public void setIdUrl(String idUrl) {
		this.idUrl = idUrl;
	}
}