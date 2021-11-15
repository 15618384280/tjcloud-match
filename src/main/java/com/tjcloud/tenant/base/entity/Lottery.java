package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 抽奖活动(lottery)
 * @author auto bin.yin 2018.07.26
 */
public class Lottery extends AbstractEntity {
	private static final long serialVersionUID = 1532590515573L;

	private String tenantId; //租户ID
	private Integer type; //抽奖类型（1.,99.广告）
	private String title; //抽奖主题
	private String subtitle; //抽奖子主题
	private Long beginTime; //开始时间
	private Long endTime; //截止时间
	private Long awardBeginTime; //领奖开始时间
	private Long awardEndTime;   //领奖截止时间
	private String note; //备注说明
	private String notice; //注意事项
	private String ruleText; //规则说明
	private String lotteryImage; //活动图片
	private String lotteryUrl; //活动地址
	private String qrcode; //抽奖二维码
	private Integer chance; //抽奖机会
	private Boolean limitChance; //是否限制抽奖机会
	private Integer limitChanceType; //限制抽奖机会类型(0.按人,1.按天)
	private Integer award; //中奖机会
	private Boolean limitAward; //是否限制中奖机会
	private Integer limitAwardType; //限制中奖机会类型(0.按人,1.按天)
	private Boolean limitArea; //是否限制区域
	private Integer distance; //方圆半径(米)
	private String latitude; //中心经度
	private String longitude; //中心纬度
	private Boolean online;	//0-下线 1-上线
	private Boolean isDefault; //是否默认
	
	private Integer showLife; //显示周期(1.只显示一次，2.每次都显示)
	
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public Long getAwardBeginTime() {
		return awardBeginTime;
	}
	public void setAwardBeginTime(Long awardBeginTime) {
		this.awardBeginTime = awardBeginTime;
	}
	public Long getAwardEndTime() {
		return awardEndTime;
	}
	public void setAwardEndTime(Long awardEndTime) {
		this.awardEndTime = awardEndTime;
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
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return this.subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Long getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public Long getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNotice() {
		return this.notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getRuleText() {
		return this.ruleText;
	}
	public void setRuleText(String ruleText) {
		this.ruleText = ruleText;
	}
	public String getLotteryImage() {
		return this.lotteryImage;
	}
	public void setLotteryImage(String lotteryImage) {
		this.lotteryImage = lotteryImage;
	}
	public String getLotteryUrl() {
		return this.lotteryUrl;
	}
	public void setLotteryUrl(String lotteryUrl) {
		this.lotteryUrl = lotteryUrl;
	}
	public String getQrcode() {
		return this.qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public Integer getChance() {
		return this.chance;
	}
	public void setChance(Integer chance) {
		this.chance = chance;
	}
	public Boolean getLimitChance() {
		return this.limitChance;
	}
	public void setLimitChance(Boolean limitChance) {
		this.limitChance = limitChance;
	}
	public Integer getLimitChanceType() {
		return this.limitChanceType;
	}
	public void setLimitChanceType(Integer limitChanceType) {
		this.limitChanceType = limitChanceType;
	}
	public Integer getAward() {
		return this.award;
	}
	public void setAward(Integer award) {
		this.award = award;
	}
	public Boolean getLimitAward() {
		return this.limitAward;
	}
	public void setLimitAward(Boolean limitAward) {
		this.limitAward = limitAward;
	}
	public Integer getLimitAwardType() {
		return this.limitAwardType;
	}
	public void setLimitAwardType(Integer limitAwardType) {
		this.limitAwardType = limitAwardType;
	}
	public Boolean getLimitArea() {
		return this.limitArea;
	}
	public void setLimitArea(Boolean limitArea) {
		this.limitArea = limitArea;
	}
	public Integer getDistance() {
		return this.distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getLatitude() {
		return this.latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return this.longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Boolean getIsDefault() {
		return this.isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getShowLife() {
		return showLife;
	}
	public void setShowLife(Integer showLife) {
		this.showLife = showLife;
	}
}