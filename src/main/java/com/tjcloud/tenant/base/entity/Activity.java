package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.StringUtils;

/**
 * 营销活动表(activity)
 * @author auto bin.yin 2018.11.28
 */
public class Activity extends AbstractEntity {
	private static final long serialVersionUID = 1543390415932L;

	private String tenantId; //租户ID
	private String stadiumId; //活动的场馆id
	private String name; //活动名称
	private Integer type; //0-平台 1-商户（场馆）
	private Boolean isOnline; //0-未上架 1-已上架
	private Integer budget; //活动预算
	private Integer pullBudget; //已领取活动金额
	private Integer usedBudget; //已使用活动金额
	private Integer unUsedBudget; //未使用活动金额
	private Long startDate; //活动开始时间
	private Long endDate; //活动结束时间
	private String image; //活动图片
	
	private String startDateText;
	private String endDateText;

	public void setStartDateText(String startDateText) {
		if(StringUtils.isNotEmpty(startDateText)) {
			setStartDate(DateUtils.toLong(startDateText, Constants.YYYY_MM_DD_HH_MM));
		}
		this.startDateText = startDateText;
	}
	public void setEndDateText(String endDateText) {
		if(StringUtils.isNotEmpty(endDateText)) {
			setEndDate(DateUtils.toLong(endDateText, Constants.YYYY_MM_DD_HH_MM));
		}
		this.endDateText = endDateText;
	}
	public String getStartDateText() {
		if(this.startDate != null) {
			return DateUtils.toString(this.startDate, Constants.YYYY_MM_DD_HH_MM);
		}
		return this.startDateText;
	}
	public String getEndDateText() {
		if(this.endDate != null) {
			return DateUtils.toString(this.endDate, Constants.YYYY_MM_DD_HH_MM);
		}
		return this.endDateText;
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
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Boolean getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}
	public Integer getBudget() {
		return this.budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	public Integer getPullBudget() {
		return this.pullBudget;
	}
	public void setPullBudget(Integer pullBudget) {
		this.pullBudget = pullBudget;
	}
	public Integer getUsedBudget() {
		return this.usedBudget;
	}
	public void setUsedBudget(Integer usedBudget) {
		this.usedBudget = usedBudget;
	}
	public Integer getUnUsedBudget() {
		return this.unUsedBudget;
	}
	public void setUnUsedBudget(Integer unUsedBudget) {
		this.unUsedBudget = unUsedBudget;
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
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}