package com.tjcloud.tenant.api.vo;

import java.io.Serializable;

/**
 * 新增会员卡
 * @author lihongzhou
 */

public class AddMemberCardVO implements Serializable{

	private static final long serialVersionUID = 3324054331651983784L;
	
	private String id;						// ID
	private String insideNo; 			// 会员卡芯片ID
	
	private String userName;				// 姓名
	private String phone;					// 电话
	private String idCard;					// 身份证
	private Integer type; 				// 卡类型,冗余字段,1-充值卡,2-次卡,3-主从卡,4-时间卡

	private String cardNo;					// 卡号
	private String cardCategoryId;			// 会员卡类型
	private Integer times;					// 次数
	private Integer balance;				// 充值金额
	private Integer fee;					// 工本费
	private Integer rechargeValue;			//充值金额/次数
	private String expiryDate;			//充值金额/次数
	private Integer durationDays;								//有效期
	
	private String cardFrontURL; 								//身份证正面URL
	private String cardVersoURL; 								//身份证反面URL
	private String cardHeadURL; 								//身份证头像URL
	
	private String tenantUserId; 								// 经办人ID
	private String tenantUserName; 								// 经办人
	private String cardLocale; 									// 经办地点
	private String cardLocaleCode; 								// 经办地点
	private Boolean nationalFitness; 							//是否全民健身会员
	
	private String birthdayStr;				// 出生时间
	private String gender;					// 性别
	
	private Integer flow; 				// 经办进度(0-申请中，1-办理中，2-已领取)
	private Boolean reapply; 			// 补办(0-否，1-是)
	private Long reapplyTime;			// 补办时间
	private Long getTime;				// 领取时间
	private String oldCardNo;			// 原卡号
	
	private String tenantId;				// 租户Id
	private String memberId;				//会员id
	private String stadiumId;				// 场馆id
	private String poolId;					// 卡池Id
	private Integer orderPayType;			// 付款方式：1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵 8-会员卡 9-会员卡按天扣除
	private Integer cardAttr;				//0-线下办卡 1-虚拟卡 2-线上申请
	private String nation;				// 民族
	private String address;				// 住址	
	private String tokenId;				//
	private String remark;				// 用户备注

	private String province; //省
	private String provinceName; //省名称
	private String city; //市
	private String cityName; //市名称
	private String district; //区
	private String districtName; //区名称
	private String street; //街道
	private String streetName; //街道名称
	
	
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCardAttr() {
		return cardAttr;
	}
	public void setCardAttr(Integer cardAttr) {
		this.cardAttr = cardAttr;
	}
	public Integer getRechargeValue() {
		return rechargeValue;
	}
	public void setRechargeValue(Integer rechargeValue) {
		this.rechargeValue = rechargeValue;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getInsideNo() {
		return insideNo;
	}
	public void setInsideNo(String insideNo) {
		this.insideNo = insideNo;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public Integer getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Boolean getNationalFitness() {
		return nationalFitness;
	}
	public void setNationalFitness(Boolean nationalFitness) {
		this.nationalFitness = nationalFitness;
	}
	public String getTenantUserId() {
		return tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
	public String getTenantUserName() {
		return tenantUserName;
	}
	public void setTenantUserName(String tenantUserName) {
		this.tenantUserName = tenantUserName;
	}
	
	public String getCardLocale() {
		return cardLocale;
	}
	public void setCardLocale(String cardLocale) {
		this.cardLocale = cardLocale;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardCategoryId() {
		return cardCategoryId;
	}
	public void setCardCategoryId(String cardCategoryId) {
		this.cardCategoryId = cardCategoryId;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getPoolId() {
		return poolId;
	}
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}
	public String getCardFrontURL() {
		return cardFrontURL;
	}
	public void setCardFrontURL(String cardFrontURL) {
		this.cardFrontURL = cardFrontURL;
	}
	public String getCardVersoURL() {
		return cardVersoURL;
	}
	public void setCardVersoURL(String cardVersoURL) {
		this.cardVersoURL = cardVersoURL;
	}
	public String getCardHeadURL() {
		return cardHeadURL;
	}
	public void setCardHeadURL(String cardHeadURL) {
		this.cardHeadURL = cardHeadURL;
	}
	public String getBirthdayStr() {
		return birthdayStr;
	}
	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getFlow() {
		return flow;
	}
	public void setFlow(Integer flow) {
		this.flow = flow;
	}
	public Boolean getReapply() {
		return reapply;
	}
	public void setReapply(Boolean reapply) {
		this.reapply = reapply;
	}
	public Long getReapplyTime() {
		return reapplyTime;
	}
	public void setReapplyTime(Long reapplyTime) {
		this.reapplyTime = reapplyTime;
	}
	public String getCardLocaleCode() {
		return cardLocaleCode;
	}
	public void setCardLocaleCode(String cardLocaleCode) {
		this.cardLocaleCode = cardLocaleCode;
	}
	public Long getGetTime() {
		return getTime;
	}
	public void setGetTime(Long getTime) {
		this.getTime = getTime;
	}
	public String getOldCardNo() {
		return oldCardNo;
	}
	public void setOldCardNo(String oldCardNo) {
		this.oldCardNo = oldCardNo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getDurationDays() {
		return durationDays;
	}
	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
}
