package com.tjcloud.tenant.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.tenant.api.enums.CardCategoryTypeEnums;

/**
 * 会员卡类型数据字典(member_card_category)
 * @author auto bin.yin 2016.06.20
 */
@LogRequired
public class MemberCardCategory extends AbstractEntity {
	private static final long serialVersionUID = 1466411795760L;

	private String categoryName; 								//类似金卡，银卡
	private String tenantId; 									//商户Id,没有商户Id为平台卡
	private Integer type; 										//1-充值卡,2-次卡,3-主从卡,4-时间卡
	private Integer usingScope; 								//使用范围,1-租户卡,2-平台卡
	private Integer initialTimes; 								//次卡初始次数
	private Integer initialAmount; 								//次卡、时间卡初始金额
	
	private Boolean editable;									//true-可编辑禁用，false-不可编辑禁用
	private Long expiryDate;									//有效期至（yyyy-mm-dd）
	private Integer durationDays;								//有效期
	private Boolean nationalFitness;							//是否全民健身卡（默认：否）
	private Integer attrType;								    //0-属于租户（所有场馆可办），1-属于场馆（所属场馆可办），2-属于项目（所属项目可办）
	private String stadiumId; 									//场馆ID
	private String stadiumName; 								//场馆名称
	private String stadiumItemId; 								//场馆项目ID
	private String stadiumItemName; 							//场馆项目名称
	
	private List<String> stadiumItemIdList; // 子场馆Id
	private List<MemberCardLimittime> limittime; // 时间卡限制设置
	
	private Integer application;//申请限制
	private String cardUrl;	//图片url

	public Boolean getEditable() {
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public Integer getDurationDays() {
		return durationDays;
	}
	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}
	public Integer getInitialTimes() {
		return initialTimes;
	}
	public void setInitialTimes(Integer initialTimes) {
		this.initialTimes = initialTimes;
	}
	
	public Integer getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(Integer initialAmount) {
		this.initialAmount = initialAmount;
	}
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public Integer getUsingScope() {
		return this.usingScope;
	}
	public void setUsingScope(Integer usingScope) {
		this.usingScope = usingScope;
	}

	public List<String> getStadiumItemIdList() {
		return stadiumItemIdList;
	}
	public void setStadiumItemIdList(List<String> stadiumItemIdList) {
		this.stadiumItemIdList = stadiumItemIdList;
	}
	public Long getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getExpiryDateText() {
		return DateUtils.formatDate(this.expiryDate);
	}
	public void setExpiryDateText(String expiryDateText) {
		this.expiryDate = DateUtils.toLong(expiryDateText);
	}
	public Boolean getNationalFitness() {
		return nationalFitness;
	}
	public void setNationalFitness(Boolean nationalFitness) {
		this.nationalFitness = nationalFitness;
	}
	public List<MemberCardLimittime> getLimittime() {
		return limittime;
	}
	public void setLimittime(List<MemberCardLimittime> limittime) {
		this.limittime = limittime;
	}
	public Integer getAttrType() {
		return attrType;
	}
	public void setAttrType(Integer attrType) {
		this.attrType = attrType;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public Integer getApplication() {
		return application;
	}
	public void setApplication(Integer application) {
		this.application = application;
	}
	
	public String getTypeMsg() {
		return CardCategoryTypeEnums.getText(getType());
	}
	public String getExpiryDateMsg() {
		return DateUtils.toString(getExpiryDate(), "yyyy-MM-dd");
	}
	public String getCardUrl() {
		return cardUrl;
	}
	public void setCardUrl(String cardUrl) {
		this.cardUrl = cardUrl;
	}
	
}