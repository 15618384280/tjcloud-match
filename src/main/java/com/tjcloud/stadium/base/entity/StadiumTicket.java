package com.tjcloud.stadium.base.entity;

import org.springframework.beans.BeanUtils;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.stadium.api.vo.StadiumTicketVO;

/**
 * 票券表(ticket)
 * 
 * @author auto bin.yin 2016.06.29
 */
@LogRequired
public class StadiumTicket extends AbstractEntity {
	private static final long serialVersionUID = 1467182854215L;

	private String tenantId; 					// 所属商户,关键字段
	private String stadiumId; 					// 所属场馆,关键字段
	private String stadiumName;					// 场馆名
	private String stadiumItemId; 				// 项目Id
	private String stadiumItemName;				// 子项目名称 
	private String ticketName; 					// 票券名称
	private Integer price; 						// 价格，后台存储单位为分
	private Boolean quantityLimited; 			// 数量限制,true-限制,false-不限制
	private Integer quantityPerDay; 			// 当isLimited=true时，需要每日数量
	private Boolean timeLimited; 				// 限时，true-限制，false-不限制
	private String hours; 						// 时长，小时，如果时间限制TRUE，这里需要填写时间
	private Long validBeginDate; 				// 有效开始日期
	private Long validEndDate; 					// 有效结束日期，不填写即永久有效
	private Integer ticketPeriod; 				// 0-通用  1-工作日 2-周末
	private Integer monday;                     // 周一
	private Integer tuesday;                    // 周二
	private Integer wednesday;                  // 周三
	private Integer thursday;                   // 周四
	private Integer friday;                     // 周五
	private Integer workday;                    // 调整日
	private Integer saturday;                   // 周六
	private Integer sunday;                     // 周日
	private Integer holiday;                    // 节假日
	private String entranceBeginTime; 			// 入场时间开始时间
	private String entranceEndTime; 			// 入场时间开始时间
	private String remark; 						// 说明
	private Long soldNum; 						// 已售多少张

	private Boolean workdayShow;                //工作日展示
	private Boolean holidayShow;                //节假日展示

	private Integer buyToday; 			// 当isLimited=true时，今日购买数量
	
	public StadiumTicket(StadiumTicketVO ticketVO) {
		BeanUtils.copyProperties(ticketVO, this);
		if (ticketVO.getValidBeginDate() != null && ticketVO.getValidBeginDate().length() > 0) {
			validBeginDate = DateUtils.toLong(ticketVO.getValidBeginDate());
			setValidBeginDate(validBeginDate);
		}
		if (ticketVO.getValidEndDate() != null && ticketVO.getValidEndDate().length() > 0) {
			validEndDate = DateUtils.toLong(ticketVO.getValidEndDate());
			setValidEndDate(validEndDate);
		}
	}
	
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public Long getSoldNum() {
		return soldNum;
	}
	public void setSoldNum(Long soldNum) {
		this.soldNum = soldNum;
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

	public Integer getTicketPeriod() {
		return ticketPeriod;
	}
	public void setTicketPeriod(Integer ticketPeriod) {
		this.ticketPeriod = ticketPeriod;
	}

	public String getStadiumItemName() {
		return stadiumItemName;
	}

	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public StadiumTicket() {

	}

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}

	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getTicketName() {
		return this.ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getQuantityLimited() {
		return this.quantityLimited;
	}

	public void setQuantityLimited(Boolean quantityLimited) {
		this.quantityLimited = quantityLimited;
	}

	public Integer getQuantityPerDay() {
		return this.quantityPerDay;
	}

	public void setQuantityPerDay(Integer quantityPerDay) {
		this.quantityPerDay = quantityPerDay;
	}

	public Boolean getTimeLimited() {
		return this.timeLimited;
	}

	public void setTimeLimited(Boolean timeLimited) {
		this.timeLimited = timeLimited;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}

	public Long getValidBeginDate() {
		return this.validBeginDate;
	}

	public void setValidBeginDate(Long validBeginDate) {
		this.validBeginDate = validBeginDate;
	}

	public Long getValidEndDate() {
		return this.validEndDate;
	}

	public void setValidEndDate(Long validEndDate) {
		this.validEndDate = validEndDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getWorkday() {
		return workday;
	}

	public void setWorkday(Integer workday) {
		this.workday = workday;
	}

	public Integer getHoliday() {
		return holiday;
	}

	public void setHoliday(Integer holiday) {
		this.holiday = holiday;
	}

	public Boolean getWorkdayShow() {
		return workdayShow;
	}

	public void setWorkdayShow(Boolean workdayShow) {
		this.workdayShow = workdayShow;
	}

	public Boolean getHolidayShow() {
		return holidayShow;
	}

	public void setHolidayShow(Boolean holidayShow) {
		this.holidayShow = holidayShow;
	}

	public Integer getBuyToday() {
		return buyToday;
	}

	public void setBuyToday(Integer buyToday) {
		this.buyToday = buyToday;
	}
}