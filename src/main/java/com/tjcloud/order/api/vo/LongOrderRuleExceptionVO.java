package com.tjcloud.order.api.vo;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.order.base.entity.LongOrderRuleException;
import com.tjcloud.order.base.entity.LongOrderRuleExceptionItem;

import java.io.Serializable;
import java.util.List;

/**
 * 长订微调
 * @author lihongzhou
 */
public class LongOrderRuleExceptionVO implements Serializable{

	private static final long serialVersionUID = -6557794135405847757L;

	private String longOrderRuleExceptionId;// 微调id
	private String longOrderRuleId;			// 长订id
	private String stadiumId;				// 场馆id	
	private String stadiumName;				// 场馆名
	private String stadiumItemId;			// 项目id
	private String stadiumItemName;			// 项目名
	private String resourceDate;			// 资源日期
	private String beginTime;				// 开始时间
	private String endTime;					// 结束时间
	private String tenantId;				// 租户id
	private Integer exceptionType;			// 状态 0-释放 1-占用
	private Boolean finished;				// 是否完成
	private List<LongOrderRuleExceptionItem> fields;		// 场地信息
	private List<JSONObject> fieldInfos;

	public List<JSONObject> getFieldInfos() {
		return fieldInfos;
	}
	public void setFieldInfos(List<JSONObject> fieldInfos) {
		this.fieldInfos = fieldInfos;
	}
	public Boolean getFinished() {
		return finished;
	}
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public String getLongOrderRuleExceptionId() {
		return longOrderRuleExceptionId;
	}

	public void setLongOrderRuleExceptionId(String longOrderRuleExceptionId) {
		this.longOrderRuleExceptionId = longOrderRuleExceptionId;
	}

	public String getLongOrderRuleId() {
		return longOrderRuleId;
	}

	public void setLongOrderRuleId(String longOrderRuleId) {
		this.longOrderRuleId = longOrderRuleId;
	}

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumItemId() {
		return stadiumItemId;
	}

	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumItemName() {
		return stadiumItemName;
	}

	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public String getResourceDate() {
		return resourceDate;
	}

	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getExceptionType() {
		return exceptionType;
	}
	public void setExceptionType(Integer exceptionType) {
		this.exceptionType = exceptionType;
	}
	public List<LongOrderRuleExceptionItem> getFields() {
		return fields;
	}

	public void setFields(List<LongOrderRuleExceptionItem> fields) {
		this.fields = fields;
	}
	public LongOrderRuleExceptionVO() {
		super();
	}
	public LongOrderRuleExceptionVO(LongOrderRuleException longOrderRuleException) {
		setLongOrderRuleExceptionId(longOrderRuleException.getId());
		setLongOrderRuleId(longOrderRuleException.getLongOrderRuleId());
		setResourceDate(longOrderRuleException.getResourceDate());
		setBeginTime(longOrderRuleException.getBeginTime());
		setEndTime(longOrderRuleException.getEndTime());
		setTenantId(longOrderRuleException.getTenantId());
		setStadiumId(longOrderRuleException.getStadiumId());
		setStadiumName(longOrderRuleException.getStadiumName());
		setStadiumItemId(longOrderRuleException.getStadiumItemId());
		setStadiumItemName(longOrderRuleException.getStadiumItemName());
		setExceptionType(longOrderRuleException.getExceptionType());
		setFinished(longOrderRuleException.getFinished());
	}
}
