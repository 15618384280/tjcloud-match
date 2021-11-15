package com.tjcloud.stadium.base.entity;

import java.util.Date;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.StadiumItemOpeningTimeDateVO;

/**
 * 场馆生成营业时间-日期表(stadium_item_openingtime_date)
 * @author auto bin.yin 2016.06.28
 */
@LogRequired
public class StadiumItemOpeningtimeDate extends AbstractEntity {
	private static final long serialVersionUID = 1467103891338L;

	private String openingTimeDayId; //关联表ID
	private String beginTime; //开始日期
	private String endTime; //结束日期
	private String createdId; //创建人id
	private String updateId; //修改人
	private String updateBy; //修改人
	private Integer created_by; //创建人
	private Date created_time; //创建时间
	private Integer modified_by; //修改人
	private Date modified_time; //修改时间

	public String getOpeningTimeDayId() {
		return this.openingTimeDayId;
	}
	public void setOpeningTimeDayId(String openingTimeDayId) {
		this.openingTimeDayId = openingTimeDayId;
	}

	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCreatedId() {
		return this.createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	public String getUpdateId() {
		return this.updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getCreated_by() {
		return this.created_by;
	}
	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_time() {
		return this.created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Integer getModified_by() {
		return this.modified_by;
	}
	public void setModified_by(Integer modified_by) {
		this.modified_by = modified_by;
	}

	public Date getModified_time() {
		return this.modified_time;
	}
	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}

	public StadiumItemOpeningTimeDateVO getStadiumItemOpeningTimeDateVO(){
		StadiumItemOpeningTimeDateVO stadiumItemOpeningTimeDateVO = new StadiumItemOpeningTimeDateVO();
		stadiumItemOpeningTimeDateVO.setId(getId());
		stadiumItemOpeningTimeDateVO.setBeginTime(beginTime);
		stadiumItemOpeningTimeDateVO.setEndTime(endTime);
		stadiumItemOpeningTimeDateVO.setOpeningTimeDayId(openingTimeDayId);
		return stadiumItemOpeningTimeDateVO;
	}

}