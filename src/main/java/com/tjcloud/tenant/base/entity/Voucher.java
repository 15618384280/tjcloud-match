package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.StringUtils;

/**
 * 代金券表(voucher)
 * @author auto bin.yin 2018.11.28
 */
public class Voucher extends AbstractEntity {
	private static final long serialVersionUID = 1543390416180L;

	private String tenantId; //租户ID
	private String stadiumId; //代金券的店铺id
	private String activityId; //活动ID
	private String code; //代金券编码
	private String tplId; //代金券模版编号
	private String voucherName; //代金券标题
	private String description; //代金券描述
	private Long pullStartDate; //代金券领取开始时间
	private Long pullEndDate; //代金券领取结束时间
	private Long startDate; //代金券有效期开始时间
	private Long endDate; //代金券有效期结束时间
	private Boolean limitUsetime; //限制使用时间
	private String startTime; //代金券订场时间限定
	private String endTime; //代金券订场时间限定
	private Boolean limitHolidayUsetime; //限制节假日使用时间
	private String holidayStartTime; //节假日限定开始时间
	private String holidayEndTime; //节假日限定开始时间
	private Integer price; //代金券面额
	private Integer limitPrice; //代金券使用时的订单限额
	private Integer state; //代金券状态(1-未用,2-已用,3-过期,4-收回)
	private Long activeDate; //代金券发放日期
	private Long usedDate; //代金券使用日期
	private Integer type; //代金券类别
	private String ownerId; //代金券所有者id
	private String ownerName; //代金券所有者名称
	private String phone; //代金券所有者电话
	private String orderId; //使用该代金券的订单编号
	private Long orderAmount; //使用该代金券的订单金额
	private Long orderRealAmount; //使用该代金券的订单实付金额
	private Integer receiveChannel; //领取渠道 0-运动合肥小程序 1-积分兑换

	private String pullStartDateText; 
	private String pullEndDateText;
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
	public String getActiveDateText() {
		if(this.activeDate != null) {
			return DateUtils.toString(this.activeDate, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	public Integer getReceiveChannel() {
		return receiveChannel;
	}
	public void setReceiveChannel(Integer receiveChannel) {
		this.receiveChannel = receiveChannel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPullStartDateText() {
		if(this.pullStartDate != null) {
			return DateUtils.toString(this.pullStartDate, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return pullStartDateText;
	}
	public void setPullStartDateText(String pullStartDateText) {
		if(StringUtils.isNotEmpty(pullStartDateText)) {
			setPullStartDate(DateUtils.toLong(pullStartDateText, Constants.YYYY_MM_DD_HH_MM_SS));
		}
		this.pullStartDateText = pullStartDateText;
	}
	public String getPullEndDateText() {
		if(this.pullEndDate != null) {
			return DateUtils.toString(this.pullEndDate, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return pullEndDateText;
	}
	public void setPullEndDateText(String pullEndDateText) {
		if(StringUtils.isNotEmpty(pullEndDateText)) {
			setPullEndDate(DateUtils.toLong(pullEndDateText, Constants.YYYY_MM_DD_HH_MM_SS));
		}
		this.pullEndDateText = pullEndDateText;
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
	
	public Voucher() {
	}
	public Voucher(VoucherTemplate voucherTemplate) {
		super();
		setTenantId(voucherTemplate.getTenantId());
		setStadiumId(voucherTemplate.getStadiumId());
		setActivityId(voucherTemplate.getActivityId());
		setTplId(voucherTemplate.getId());
		setVoucherName(voucherTemplate.getVoucherName());
		setDescription(voucherTemplate.getDescription());
		setPullStartDate(voucherTemplate.getReceiveStartDate());
		setPullEndDate(voucherTemplate.getReceiveEndDate());
		setStartDate(voucherTemplate.getStartDate());
		setEndDate(voucherTemplate.getEndDate());
		setLimitUsetime(voucherTemplate.getLimitUsetime());
		setStartTime(voucherTemplate.getStartTime());
		setEndTime(voucherTemplate.getEndTime());
		setLimitHolidayUsetime(voucherTemplate.getLimitHolidayUsetime());
		setHolidayStartTime(voucherTemplate.getHolidayStartTime());
		setHolidayEndTime(voucherTemplate.getHolidayEndTime());
		setPrice(voucherTemplate.getPrice());
		setLimitPrice(voucherTemplate.getLimitPrice());
		setType(voucherTemplate.getType());
	}
	
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getActivityId() {
		return this.activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTplId() {
		return this.tplId;
	}
	public void setTplId(String tplId) {
		this.tplId = tplId;
	}
	public String getVoucherName() {
		return this.voucherName;
	}
	public void setVoucherName(String voucherName) {
		this.voucherName = voucherName;
	}
	public Long getPullStartDate() {
		return this.pullStartDate;
	}
	public void setPullStartDate(Long pullStartDate) {
		this.pullStartDate = pullStartDate;
	}
	public Long getPullEndDate() {
		return this.pullEndDate;
	}
	public void setPullEndDate(Long pullEndDate) {
		this.pullEndDate = pullEndDate;
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
	public String getStartTime() {
		return this.startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(Integer limitPrice) {
		this.limitPrice = limitPrice;
	}
	public Integer getState() {
		return this.state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Long getActiveDate() {
		return this.activeDate;
	}
	public void setActiveDate(Long activeDate) {
		this.activeDate = activeDate;
	}
	public Long getUsedDate() {
		return this.usedDate;
	}
	public void setUsedDate(Long usedDate) {
		this.usedDate = usedDate;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getOwnerId() {
		return this.ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return this.ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Long getOrderAmount() {
		return this.orderAmount;
	}
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Long getOrderRealAmount() {
		return this.orderRealAmount;
	}
	public void setOrderRealAmount(Long orderRealAmount) {
		this.orderRealAmount = orderRealAmount;
	}
}