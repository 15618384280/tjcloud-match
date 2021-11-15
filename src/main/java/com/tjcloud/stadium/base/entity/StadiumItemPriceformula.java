package com.tjcloud.stadium.base.entity;

import java.math.BigDecimal;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 场馆项目(stadium_item_priceformula)
 * @author auto bin.yin 2017.12.18
 */
public class StadiumItemPriceformula extends AbstractEntity {
	private static final long serialVersionUID = 1513579468758L;

	private String stadiumId; 					//所属场馆,关键字段
	private String memberCategoryId; 			//会员类型ID
	private String categoryName; 				//类似金卡，银卡
	private String stadiumItemId; 				//子场馆ID
	private Integer chargeMode; 				//计费方式：1-计时，2-记次，3-包场
	private Long validStartTime; 				//有效开始时间
	private Long validEndTime; 					//有效结束时间
	private Integer validType; 					//有效类型：1-正常，2-周末，3-节假日
	private Integer startTime; 					//当天有效开始时间
	private Integer endTime; 					//当天有效结束时间
	private Integer unitTime; 					//计时单位（分钟）
	private Long unitPrice; 					//计时单价
	private Integer overtopUnitTime; 			//超出时间单位（分钟）
	private Long overtopUnitPrice; 				//超出部分计时单价
	private Integer overtopMaxTime; 			//超出时间封顶（分钟）
	private Long overtopMaxPrice; 				//封顶单价

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getMemberCategoryId() {
		return this.memberCategoryId;
	}
	public void setMemberCategoryId(String memberCategoryId) {
		this.memberCategoryId = memberCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public Integer getChargeMode() {
		return this.chargeMode;
	}
	public void setChargeMode(Integer chargeMode) {
		this.chargeMode = chargeMode;
	}
	public Long getValidStartTime() {
		return this.validStartTime;
	}
	public void setValidStartTime(Long validStartTime) {
		this.validStartTime = validStartTime;
	}
	public Long getValidEndTime() {
		return this.validEndTime;
	}
	public void setValidEndTime(Long validEndTime) {
		this.validEndTime = validEndTime;
	}
	public Integer getValidType() {
		return this.validType;
	}
	public void setValidType(Integer validType) {
		this.validType = validType;
	}
	public Integer getStartTime() {
		return this.startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public Integer getUnitTime() {
		return this.unitTime;
	}
	public void setUnitTime(Integer unitTime) {
		this.unitTime = unitTime;
	}
	public Long getUnitPrice() {
		return this.unitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getOvertopUnitTime() {
		return this.overtopUnitTime;
	}
	public void setOvertopUnitTime(Integer overtopUnitTime) {
		this.overtopUnitTime = overtopUnitTime;
	}
	public Long getOvertopUnitPrice() {
		return this.overtopUnitPrice;
	}
	public void setOvertopUnitPrice(Long overtopUnitPrice) {
		this.overtopUnitPrice = overtopUnitPrice;
	}
	
	public String getStartTimeStr() {
		if(this.getStartTime() == null){
    		return null;
    	}else{
    		String timeStr = new BigDecimal(this.getStartTime()).divide(new BigDecimal(100)).toString().replace(".", ":");
    		if (timeStr.length() == 1 || timeStr.length() == 3) {
    			timeStr = "0" + timeStr;
    			if (timeStr.length() == 2) {
    				timeStr += ":00";
    			} else if (timeStr.length() == 4) {
    				timeStr += "0";
    			}
    		}else if (timeStr.length() == 4 && timeStr.indexOf(":") == 1) {
    			timeStr = "0" + timeStr;
    		}else if (timeStr.length() == 4) {
    			timeStr += "0";
    		} else if (timeStr.length() == 2) {
    			timeStr += ":00";
    		}
    		return timeStr;
    	}
    }
    public void setStartTimeStr(String startTimeStr) {
        this.setStartTime(Integer.parseInt(startTimeStr.replaceAll(":", "")));
    }
    
    public String getEndTimeStr() {
    	if(this.getEndTime() == null){
    		return null;
    	}else{
    		String timeStr = new BigDecimal(this.getEndTime()).divide(new BigDecimal(100)).toString().replace(".", ":");
    		if (timeStr.length() == 1 || timeStr.length() == 3) {
    			timeStr = "0" + timeStr;
    			if (timeStr.length() == 2) {
    				timeStr += ":00";
    			} else if (timeStr.length() == 4) {
    				timeStr += "0";
    			}
    		}else if (timeStr.length() == 4 && timeStr.indexOf(":") == 1) {
    			timeStr = "0" + timeStr;
    		}else if (timeStr.length() == 4) {
    			timeStr += "0";
    		} else if (timeStr.length() == 2) {
    			timeStr += ":00";
    		}
    		return timeStr;
    	}
    }
    public void setEndTimeStr(String endTimeStr) {
        this.setEndTime(Integer.parseInt(endTimeStr.replaceAll(":", "")));
    }
    
    public String getValidStartTimeStr() {
		return DateUtils.formatDate(this.validStartTime, "yyyy-MM-dd");
	}
	public void setValidStartTimeStr(String validStartTimeStr) {
		this.validStartTime = DateUtils.toLong(validStartTimeStr);
	}
	public String getValidEndTimeStr() {
		return DateUtils.formatDate(this.validEndTime, "yyyy-MM-dd");
	}
	public void setValidEndTimeStr(String validEndTimeStr) {
		this.validEndTime = DateUtils.plusDays(validEndTimeStr, "yyyy-MM-dd", 1);

	}
	public Integer getOvertopMaxTime() {
		return overtopMaxTime;
	}
	public void setOvertopMaxTime(Integer overtopMaxTime) {
		this.overtopMaxTime = overtopMaxTime;
	}
	public Long getOvertopMaxPrice() {
		return overtopMaxPrice;
	}
	public void setOvertopMaxPrice(Long overtopMaxPrice) {
		this.overtopMaxPrice = overtopMaxPrice;
	}
	
}