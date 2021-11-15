package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场次表(field_session)
 * @author auto bin.yin 2016.06.03
 */
@LogRequired
public class FieldSession extends AbstractEntity {
	private static final long serialVersionUID = 1464942279303L;

	private String fieldId; //场地Id
	private String beginTime; //开始时间
	private String endTime; //结束时间
	private Integer dayOfWeek; //1-工作日，2-节假日
	private Boolean always; //1-永久，2-临时
	private Boolean used = false;

	public String getFieldId() {
		return this.fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
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

	public Integer getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Boolean getAlways() {
		return this.always;
	}
	public void setAlways(Boolean always) {
		this.always = always;
	}

	public Boolean getUsed() {
		return this.used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
}