package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.order.api.vo.LongOrderRuleExceptionVO;

/**
 * 长订订单微调表(long_order_rule_exception)
 * @author auto bin.yin 2016.10.27
 */
@LogRequired
public class LongOrderRuleException extends AbstractEntity {
	private static final long serialVersionUID = 1477561024715L;

	private String longOrderRuleId; //长订规则id
	private String stadiumId; //场馆id
	private String stadiumName; //场馆名称
	private String stadiumItemId; //项目id
	private String stadiumItemName; //项目名
	private String tenantId; //租户id
	private String resourceDate; //锁定日期
	private String beginTime; //开始时间 HH:mm
	private String endTime; //结束时间 HH:mm
	private Integer exceptionType; //状态 0-释放 1-占用
	private Boolean finished;	//是否已完成

	public Integer getExceptionType() {
		return exceptionType;
	}
	public void setExceptionType(Integer exceptionType) {
		this.exceptionType = exceptionType;
	}
	public Boolean getFinished() {
		return finished;
	}
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
	public String getLongOrderRuleId() {
		return this.longOrderRuleId;
	}
	public void setLongOrderRuleId(String longOrderRuleId) {
		this.longOrderRuleId = longOrderRuleId;
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
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getResourceDate() {
		return this.resourceDate;
	}
	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
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
	public LongOrderRuleException() {
		super();
	}
	public LongOrderRuleException(LongOrderRuleExceptionVO longOrderRuleExceptionVO) {
		setId(longOrderRuleExceptionVO.getLongOrderRuleExceptionId());
		setLongOrderRuleId(longOrderRuleExceptionVO.getLongOrderRuleId());
		setTenantId(longOrderRuleExceptionVO.getTenantId());
		setStadiumId(longOrderRuleExceptionVO.getStadiumId());
		setStadiumName(longOrderRuleExceptionVO.getStadiumName());
		setStadiumItemId(longOrderRuleExceptionVO.getStadiumItemId());
		setStadiumItemName(longOrderRuleExceptionVO.getStadiumItemName());
		setResourceDate(longOrderRuleExceptionVO.getResourceDate());
		setBeginTime(longOrderRuleExceptionVO.getBeginTime());
		setEndTime(longOrderRuleExceptionVO.getEndTime());
		setExceptionType(longOrderRuleExceptionVO.getExceptionType());
	}
}