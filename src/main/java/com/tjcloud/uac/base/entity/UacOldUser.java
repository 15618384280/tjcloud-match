package com.tjcloud.uac.base.entity;

import java.util.Date;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (uac_old_user)
 * @author auto bin.yin 2017.07.21
 */
public class UacOldUser extends AbstractEntity {
	private static final long serialVersionUID = 1500608434854L;

	private String account; //
	private String password; //
	private String nickname; //
	private String mobile; //
	private Boolean mobile_validated; //
	private String email; //
	private Boolean email_validated; //
	private String gender; //
	private String photo; //
	private Integer account_balance; //
	private Date creation_time; //
	private Date modification_time; //
	private Date last_login_time; //
	private String type; //
	private Integer point; //
	private String province; //
	private String country; //
	private String city; //
	private String role; //
	private Boolean is_tenant; //
	private Double longitude; //
	private Double latitude; //
	private String activity_id; //来源
	private Integer sign_point; //
	private Integer card_point; //
	private Integer order_point; //
	private Integer used_point; //
	private String registeration_channel; //
	private String alipay_user_id; //支付宝会员ID
	private String registration_id; //
	private Integer tenant_id; //
	private String new_access_token; //
	private Boolean synchroAccount; //同步账号(0.未同步,1.已同步)
	private Boolean synchroBalance; //同步余额(0.未同步,1.已同步)

	public String getAccount() {
		return this.account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return this.nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Boolean getMobile_validated() {
		return this.mobile_validated;
	}
	public void setMobile_validated(Boolean mobile_validated) {
		this.mobile_validated = mobile_validated;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEmail_validated() {
		return this.email_validated;
	}
	public void setEmail_validated(Boolean email_validated) {
		this.email_validated = email_validated;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoto() {
		return this.photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getAccount_balance() {
		return this.account_balance;
	}
	public void setAccount_balance(Integer account_balance) {
		this.account_balance = account_balance;
	}
	public Date getCreation_time() {
		return this.creation_time;
	}
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	public Date getModification_time() {
		return this.modification_time;
	}
	public void setModification_time(Date modification_time) {
		this.modification_time = modification_time;
	}
	public Date getLast_login_time() {
		return this.last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPoint() {
		return this.point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getIs_tenant() {
		return this.is_tenant;
	}
	public void setIs_tenant(Boolean is_tenant) {
		this.is_tenant = is_tenant;
	}
	public Double getLongitude() {
		return this.longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return this.latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getActivity_id() {
		return this.activity_id;
	}
	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}
	public Integer getSign_point() {
		return this.sign_point;
	}
	public void setSign_point(Integer sign_point) {
		this.sign_point = sign_point;
	}
	public Integer getCard_point() {
		return this.card_point;
	}
	public void setCard_point(Integer card_point) {
		this.card_point = card_point;
	}
	public Integer getOrder_point() {
		return this.order_point;
	}
	public void setOrder_point(Integer order_point) {
		this.order_point = order_point;
	}
	public Integer getUsed_point() {
		return this.used_point;
	}
	public void setUsed_point(Integer used_point) {
		this.used_point = used_point;
	}
	public String getRegisteration_channel() {
		return this.registeration_channel;
	}
	public void setRegisteration_channel(String registeration_channel) {
		this.registeration_channel = registeration_channel;
	}
	public String getAlipay_user_id() {
		return this.alipay_user_id;
	}
	public void setAlipay_user_id(String alipay_user_id) {
		this.alipay_user_id = alipay_user_id;
	}
	public String getRegistration_id() {
		return this.registration_id;
	}
	public void setRegistration_id(String registration_id) {
		this.registration_id = registration_id;
	}
	public Integer getTenant_id() {
		return this.tenant_id;
	}
	public void setTenant_id(Integer tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getNew_access_token() {
		return this.new_access_token;
	}
	public void setNew_access_token(String new_access_token) {
		this.new_access_token = new_access_token;
	}
	public Boolean getSynchroAccount() {
		return this.synchroAccount;
	}
	public void setSynchroAccount(Boolean synchroAccount) {
		this.synchroAccount = synchroAccount;
	}
	public Boolean getSynchroBalance() {
		return this.synchroBalance;
	}
	public void setSynchroBalance(Boolean synchroBalance) {
		this.synchroBalance = synchroBalance;
	}
}