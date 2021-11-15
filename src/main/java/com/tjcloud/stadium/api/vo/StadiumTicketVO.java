package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.stadium.base.entity.StadiumTicket;

public class StadiumTicketVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;//票券主键id
	private String stadiumItemId; //项目Id
	private String stadiumItemName;	//子项目名称 
	private String ticketName; //票券名称
	private Integer price; //价格，后台存储单位为分
	private Boolean quantityLimited; //数量限制,true-限制,false-不限制
	private Integer quantityPerDay; //当isLimited=true时，需要每日数量
	private Boolean timeLimited; //限时，true-限制，false-不限制
	private String hours; //时长，小时，如果时间限制TRUE，这里需要填写时间
	private String validBeginDate; //有效开始日期
	private String validEndDate; //有效结束日期，不填写即永久有效
	private Integer ticketPeriod; // 0-通用  1-工作日 2-周末
	private String entranceBeginTime; // 入场时间开始时间
	private String entranceEndTime; // 入场时间开始时间
	private String remark; //说明
	private Long soldNum;	//已售多少张
	private String tokenId;	//操作人id
	private Boolean disabled; //逻辑删除false时为可用

	private Integer monday;                     // 周一
	private Integer tuesday;                    // 周二
	private Integer wednesday;                  // 周三
	private Integer thursday;                   // 周四
	private Integer friday;                     // 周五
	private Integer workday;                    // 调整日
	private Integer saturday;                   // 周六
	private Integer sunday;                     // 周日
	private Integer holiday;                    // 节假日
	
	public StadiumTicketVO(StadiumTicket ticket) {
		BeanUtils.copyProperties(ticket, this);
		setValidBeginDate(ticket.getValidBeginDate() == 0 ? null : DateUtils.toString(ticket.getValidBeginDate()));
		setValidEndDate(ticket.getValidEndDate() == 0 ? null : DateUtils.toString(ticket.getValidEndDate()));
	}
	
	
	public Long getSoldNum() {
		return soldNum;
	}
	public void setSoldNum(Long soldNum) {
		this.soldNum = soldNum;
	}

	public Integer getTicketPeriod() {
		return ticketPeriod;
	}
	public void setTicketPeriod(Integer ticketPeriod) {
		this.ticketPeriod = ticketPeriod;
	}

	public String getEntranceBeginTime() {
		return entranceBeginTime;
	}
	public void setEntranceBeginTime(String entranceBeginTime) {
		this.entranceBeginTime = entranceBeginTime;
	}

	public String getEntranceEndTime() {
		return entranceEndTime;
	}
	public void setEntranceEndTime(String entranceEndTime) {
		this.entranceEndTime = entranceEndTime;
	}

	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public StadiumTicketVO() {
	}
	
	public Boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Boolean getQuantityLimited() {
		return quantityLimited;
	}
	public void setQuantityLimited(Boolean quantityLimited) {
		this.quantityLimited = quantityLimited;
	}
	public Integer getQuantityPerDay() {
		return quantityPerDay;
	}
	public void setQuantityPerDay(Integer quantityPerDay) {
		this.quantityPerDay = quantityPerDay;
	}
	public Boolean getTimeLimited() {
		return timeLimited;
	}
	public void setTimeLimited(Boolean timeLimited) {
		this.timeLimited = timeLimited;
	}
	
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getValidBeginDate() {
		return validBeginDate;
	}
	public void setValidBeginDate(String validBeginDate) {
		this.validBeginDate = validBeginDate;
	}
	public String getValidEndDate() {
		return validEndDate;
	}
	public void setValidEndDate(String validEndDate) {
		this.validEndDate = validEndDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getMonday() {
		return monday;
	}

	public void setMonday(Integer monday) {
		this.monday = monday;
	}

	public Integer getTuesday() {
		return tuesday;
	}

	public void setTuesday(Integer tuesday) {
		this.tuesday = tuesday;
	}

	public Integer getWednesday() {
		return wednesday;
	}

	public void setWednesday(Integer wednesday) {
		this.wednesday = wednesday;
	}

	public Integer getThursday() {
		return thursday;
	}

	public void setThursday(Integer thursday) {
		this.thursday = thursday;
	}

	public Integer getFriday() {
		return friday;
	}

	public void setFriday(Integer friday) {
		this.friday = friday;
	}

	public Integer getWorkday() {
		return workday;
	}

	public void setWorkday(Integer workday) {
		this.workday = workday;
	}

	public Integer getSaturday() {
		return saturday;
	}

	public void setSaturday(Integer saturday) {
		this.saturday = saturday;
	}

	public Integer getSunday() {
		return sunday;
	}

	public void setSunday(Integer sunday) {
		this.sunday = sunday;
	}

	public Integer getHoliday() {
		return holiday;
	}

	public void setHoliday(Integer holiday) {
		this.holiday = holiday;
	}
}
