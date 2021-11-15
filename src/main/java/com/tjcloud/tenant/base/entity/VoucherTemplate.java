package com.tjcloud.tenant.base.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.StringUtils;

/**
 * 代金券模板表(voucher_template)
 * @author auto bin.yin 2018.11.28
 */
public class VoucherTemplate extends AbstractEntity {
	private static final long serialVersionUID = 1543390416384L;

	private String tenantId; //代金券名称
	private String statidumId; //场馆ID
	private String activityId; //活动ID
	private Integer type; //类型(1.新人券,2.抽奖券,3.抵扣券)
	private String voucherName; //代金券名称
	private String description; //代金券描述
	private Long receiveStartDate; //领取开始时间
	private Long receiveEndDate;   //领取结束时间
	private Long startDate; //代金券有效期开始时间
	private Long endDate;   //代金券有效期结束时间
	private Integer validDays;	//有效期
	private Boolean limitUsetime;  //限制使用时间
	private String startTime; //限定开始时间
	private String endTime;  //限定结束时间
	private Boolean limitHolidayUsetime; //限制节假日使用时间
	private String holidayStartTime; //节假日限定开始时间
	private String holidayEndTime; //节假日限定开始时间
	private Integer price; //代金券面额
	private Integer limitPrice; //代金券使用时的订单限额
	private String stadiumId; //代金券的店铺id
	private String stadiumName; //店铺名称
	private Integer total; //可发放的代金券总数
	private Integer giveOut; //已发放的代金券数量
	private Integer used; //已经使用过的代金券
	private String quotaId; //套餐编号
	private Integer points; //兑换所需积分
	private Integer eachLimit; //每人限领张数
	private String custImg; //自定义代金券图片
	private String sportTypes;	// 运动类型  jsonArray
	private String channels;	// 渠道 001-运动合肥
	private Boolean isOnline;	// isOnline
	private JSONArray sportTypeArray;  // 运动类型
	private JSONArray channelArray;  // 渠道
	private String receiveStartDateText; 
	private String receiveEndDateText;
	private String startDateText;
	private String endDateText;
	
	public Boolean getLimitUsetime() {
		return limitUsetime;
	}
	public void setLimitUsetime(Boolean limitUsetime) {
		this.limitUsetime = limitUsetime;
	}
	public Boolean getLimitHolidayUsetime() {
		return limitHolidayUsetime;
	}
	public void setLimitHolidayUsetime(Boolean limitHolidayUsetime) {
		this.limitHolidayUsetime = limitHolidayUsetime;
	}
	public String getHolidayStartTime() {
		return holidayStartTime;
	}
	public void setHolidayStartTime(String holidayStartTime) {
		this.holidayStartTime = holidayStartTime;
	}
	public String getHolidayEndTime() {
		return holidayEndTime;
	}
	public void setHolidayEndTime(String holidayEndTime) {
		this.holidayEndTime = holidayEndTime;
	}
	public Integer getValidDays() {
		return validDays;
	}
	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}
	public Boolean getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}
	public JSONArray getChannelArray() {
		if(StringUtils.isNotEmpty(this.channels)) {
			return JSON.parseArray(this.channels);
		}
		return channelArray;
	}
	public void setChannelArray(JSONArray channelArray) {
		if(channelArray != null) {
			setChannels(channelArray.toString());
		}
		this.channelArray = channelArray;
	}
	
	public String getChannels() {
		return channels;
	}
	public void setChannels(String channels) {
		this.channels = channels;
	}
	public JSONArray getSportTypeArray() {
		if(StringUtils.isNotEmpty(this.sportTypes)) {
			return JSON.parseArray(this.sportTypes);
		}
		return sportTypeArray;
	}
	public void setSportTypeArray(JSONArray sportTypeArray) {
		if(sportTypeArray != null) {
			setSportTypes(sportTypeArray.toString());
		}
		this.sportTypeArray = sportTypeArray;
	}
	public String getSportTypes() {
		return sportTypes;
	}
	public void setSportTypes(String sportTypes) {
		this.sportTypes = sportTypes;
	}
	public String getReceiveStartDateText() {
		if(this.receiveStartDate != null) {
			return DateUtils.toString(this.receiveStartDate, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return receiveStartDateText;
	}
	public void setReceiveStartDateText(String receiveStartDateText) {
		if(StringUtils.isNotEmpty(receiveStartDateText)) {
			setReceiveStartDate(DateUtils.toLong(receiveStartDateText, Constants.YYYY_MM_DD_HH_MM_SS));
		}
		this.receiveStartDateText = receiveStartDateText;
	}
	public String getReceiveEndDateText() {
		if(this.receiveEndDate != null) {
			return DateUtils.toString(this.receiveEndDate, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return receiveEndDateText;
	}
	public void setReceiveEndDateText(String receiveEndDateText) {
		if(StringUtils.isNotEmpty(receiveEndDateText)) {
			setReceiveEndDate(DateUtils.toLong(receiveEndDateText, Constants.YYYY_MM_DD_HH_MM_SS));
		}
		this.receiveEndDateText = receiveEndDateText;
	}
	public String getStartDateText() {
		if(this.startDate != null) {
			return DateUtils.toString(this.startDate, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return startDateText;
	}
	public void setStartDateText(String startDateText) {
		if(StringUtils.isNotEmpty(startDateText)) {
			setStartDate(DateUtils.toLong(startDateText, Constants.YYYY_MM_DD_HH_MM_SS));
		}
		this.startDateText = startDateText;
	}
	public String getEndDateText() {
		if(this.endDate != null) {
			return DateUtils.toString(this.endDate, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return endDateText;
	}
	public void setEndDateText(String endDateText) {
		if(StringUtils.isNotEmpty(endDateText)) {
			setEndDate(DateUtils.toLong(endDateText, Constants.YYYY_MM_DD_HH_MM_SS));
		}
		this.endDateText = endDateText;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Long getReceiveStartDate() {
		return receiveStartDate;
	}
	public void setReceiveStartDate(Long receiveStartDate) {
		this.receiveStartDate = receiveStartDate;
	}
	public Long getReceiveEndDate() {
		return receiveEndDate;
	}
	public void setReceiveEndDate(Long receiveEndDate) {
		this.receiveEndDate = receiveEndDate;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStatidumId() {
		return this.statidumId;
	}
	public void setStatidumId(String statidumId) {
		this.statidumId = statidumId;
	}
	public String getActivityId() {
		return this.activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getVoucherName() {
		return this.voucherName;
	}
	public void setVoucherName(String voucherName) {
		this.voucherName = voucherName;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getStartDate() {
		return this.startDate;
	}
	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}
	public Long getEndDate() {
		return this.endDate;
	}
	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}
	public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getLimitPrice() {
		return this.limitPrice;
	}
	public void setLimitPrice(Integer limitPrice) {
		this.limitPrice = limitPrice;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public Integer getTotal() {
		return this.total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getGiveOut() {
		return this.giveOut;
	}
	public void setGiveOut(Integer giveOut) {
		this.giveOut = giveOut;
	}
	public Integer getUsed() {
		return this.used;
	}
	public void setUsed(Integer used) {
		this.used = used;
	}
	public String getQuotaId() {
		return this.quotaId;
	}
	public void setQuotaId(String quotaId) {
		this.quotaId = quotaId;
	}
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getEachLimit() {
		return this.eachLimit;
	}
	public void setEachLimit(Integer eachLimit) {
		this.eachLimit = eachLimit;
	}
	public String getCustImg() {
		return this.custImg;
	}
	public void setCustImg(String custImg) {
		this.custImg = custImg;
	}
}