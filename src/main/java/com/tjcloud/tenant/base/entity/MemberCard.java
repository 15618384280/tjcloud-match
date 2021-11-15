package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.tenant.api.enums.FlowTypeEnums;
import com.tjcloud.tenant.api.enums.MemberCardCategoryTypeEnums;

/**
 * 会员卡表(member_card)
 * @author auto bin.yin 2016.06.30
 */
@LogRequired
public class MemberCard extends AbstractEntity {
	private static final long serialVersionUID = 1467273344534L;

	private String cardNo; 				// 卡号
	private String insideNo; 			// 会员卡芯片ID
	private String poolId;				// 卡池id
	private String cardCategoryId;		// 会员卡类型Id
	private String userId; 				// 绑定的用户Id
	private String tenantId; 			// 租户Id
	private String stadiumId;			// 场馆id
	private String memberId;			// 会员Id
	private Integer type; 				// 卡类型,冗余字段,1-充值卡,2-次卡,3-主从卡,4-时间卡
	private Integer balance; 			// 余额,当为从卡时余额一直是0
	private Integer beforBalance; 		// 上一次结余
	private Integer otherFee; 			// 工本费
	private Integer times; 				// 次数,当卡类型为次卡时有值
	private String parentCardId;		// 父卡Id
	private Boolean isMaster; 			// 是否主卡,此字段仅为3-主从卡时使用
	private String userName; 			// 会员姓名
	private String phone; 				// 手机号
	private String idCard; 				// 身份证
	private String valBeginTime;		// 有效期开始时间
	private String valEndTime;  		// 有效期结束时间
	private Boolean pending; 			// 会员卡挂失,1-冻结,0-可用
	private String pendingBeginTime;	// 开始冻结时间
	private String pendingEndTime;  	// 结束冻结时间
	private String lossReason;			// 挂失原因

	private String cardFrontURL; 								//身份证正面URL
	private String cardVersoURL; 								//身份证反面URL
	private String cardHeadURL; 								//身份证头像URL
	private Boolean nationalFitness;	// 是否全民健身卡（默认：否）
	private String tenantUserId; 		// 经办人ID
	private String tenantUserName; 		// 经办人
	private String cardLocale; 			// 经办地点
	private String cardLocaleCode; 		// 经办地点
	private Integer flow; 				// 经办进度(0-申请中，1-办理中，2-已领取)
	private String flowNote;			// 流程注释
	private Boolean reapply; 			// 补办(0-否，1-是)
	private Long reapplyTime;			// 补办时间
	private Long birthday;				// 出生时间
	private String gender;				// 性别
	private Long getTime;				// 领取时间
	private String oldCardNo;			// 原卡号
	private Integer cardAttr;			// 0-实体卡 1- 虚拟卡
	private Long lastRechargeTime;		// 最后充值时间
	
	private String nation;				//民族
	private String address;				//住址
	private String province; //省
	private String provinceName; //省名称
	private String city; //市
	private String cityName; //市名称
	private String district; //区
	private String districtName; //区名称
	private String street; //街道
	private String streetName; //街道名称
	
	// 非DB属性
	private String cardCategoryName;  	//会员卡类型名称
	
	public Long getLastRechargeTime() {
		return lastRechargeTime;
	}
	public void setLastRechargeTime(Long lastRechargeTime) {
		this.lastRechargeTime = lastRechargeTime;
	}
	public String getCardCategoryName() {
		return cardCategoryName;
	}
	public void setCardCategoryName(String cardCategoryName) {
		this.cardCategoryName = cardCategoryName;
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
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getFlowNote() {
		return flowNote;
	}
	public void setFlowNote(String flowNote) {
		this.flowNote = flowNote;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getValBeginTime() {
		if(StringUtils.isEmpty(this.valBeginTime)){
			return DateUtils.toString(this.getCreatedTime());
		}
		return valBeginTime;
	}
	public void setValBeginTime(String valBeginTime) {
		this.valBeginTime = valBeginTime;
	}
	public String getValEndTime() {
		return valEndTime;
	}
	public void setValEndTime(String valEndTime) {
		this.valEndTime = valEndTime;
	}
	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getInsideNo() {
		return insideNo;
	}
	public void setInsideNo(String insideNo) {
		this.insideNo = insideNo;
	}
	public String getCardCategoryId() {
		return this.cardCategoryId;
	}
	public void setCardCategoryId(String cardCategoryId) {
		this.cardCategoryId = cardCategoryId;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getBalance() {
		return this.balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getBeforBalance() {
		return beforBalance;
	}
	public void setBeforBalance(Integer beforBalance) {
		this.beforBalance = beforBalance;
	}
	public Integer getTimes() {
		return this.times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getParentCardId() {
		return this.parentCardId;
	}
	public void setParentCardId(String parentCardId) {
		this.parentCardId = parentCardId;
	}

	public Boolean getIsMaster() {
		return this.isMaster;
	}
	public void setIsMaster(Boolean isMaster) {
		this.isMaster = isMaster;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return this.idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Boolean getPending() {
		return this.pending;
	}
	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public String getPoolId() {
		return poolId;
	}
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}
	public Integer getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(Integer otherFee) {
		this.otherFee = otherFee;
	}
	public String getLossReason() {
		return lossReason;
	}
	public void setLossReason(String lossReason) {
		this.lossReason = lossReason;
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
	public Boolean getNationalFitness() {
		return nationalFitness;
	}
	public void setNationalFitness(Boolean nationalFitness) {
		this.nationalFitness = nationalFitness;
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
	public Long getBirthday() {
		return birthday;
	}
	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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

	public String getPendingBeginTime() {
		return pendingBeginTime;
	}
	public void setPendingBeginTime(String pendingBeginTime) {
		this.pendingBeginTime = pendingBeginTime;
	}
	public String getPendingEndTime() {
		return pendingEndTime;
	}
	public void setPendingEndTime(String pendingEndTime) {
		this.pendingEndTime = pendingEndTime;
	}
	public String getReapplyTimeText() {
		if(this.getReapplyTime() == null){
			return "";
		}	
		return (0 == this.getReapplyTime()) ? "" : DateUtils.toString(this.getReapplyTime());
	}
	public String getCreatorTimeText() {
		if(this.getCreatedTime() == null){
			return "";
		}
		return (0 == this.getCreatedTime()) ? "" : DateUtils.toString(this.getCreatedTime());
	}
	public String getGetTimeText() {
		if(this.getGetTime() == null){
			return "";
		}
		return (0 == this.getGetTime()) ? "" : DateUtils.toString(this.getGetTime());
	}
	public String getFlowText() {
		if(this.flow == null){
			return "";
		}
		return FlowTypeEnums.getText(this.flow);
	}
	
	public String getTypeText() {
		if(this.type == null){
			return "";
		}
		return MemberCardCategoryTypeEnums.getText(this.type);
	}

	public Integer getBalanceOrTimes(){
		if(this.type == null){
			return 0;
		}
		if(this.type.intValue() == 2){
			return this.times;
		}
		return this.balance;
	}

	public String getValBeginTimeText(){
		if(StringUtils.isEmpty(this.valBeginTime)){
			return getCreatorTimeText();
		}
		return this.valBeginTime;
	}
	
	public String getValEndTimeText(){
		if(StringUtils.isEmpty(this.valEndTime)){
			return "长期有效";
		}
		return this.valEndTime;
	}


	public Boolean getMaster() {
		return isMaster;
	}

	public void setMaster(Boolean master) {
		isMaster = master;
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