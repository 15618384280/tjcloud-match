package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.dd.api.enums.IntegralTypeEnum;

/**
 * 积分规则(dd_integral_rule)
 * @author auto bin.yin 2019.02.18
 */
public class IntegralRule extends AbstractEntity {
	private static final long serialVersionUID = 1550474711189L;

	private String platformId; //平台ID 0-我要运动
	private Long integral; //积分
	private Integer integralType; //积分类型0-新用户1-签到 2-分享 3-评价 4-订单5-赛事 7-银行卡申请 8-微信计步
	private Boolean isCycle; //是否周期性
	private Integer cycleType; //周期类型0-天1-周2-月3-年
	private Boolean isLimitTimes; //是否限制次数
	private Integer limitTimes; //限制次数
	private Long targetValue; //冗余备注目标值
	private Boolean online; //是否生效
	
	public Long getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(Long targetValue) {
		this.targetValue = targetValue;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getIntegral() {
		return this.integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
	public Integer getIntegralType() {
		return this.integralType;
	}
	public void setIntegralType(Integer integralType) {
		this.integralType = integralType;
	}
	public Boolean getIsCycle() {
		return this.isCycle;
	}
	public void setIsCycle(Boolean isCycle) {
		this.isCycle = isCycle;
	}
	public Integer getCycleType() {
		return this.cycleType;
	}
	public void setCycleType(Integer cycleType) {
		this.cycleType = cycleType;
	}
	public Boolean getIsLimitTimes() {
		return this.isLimitTimes;
	}
	public void setIsLimitTimes(Boolean isLimitTimes) {
		this.isLimitTimes = isLimitTimes;
	}
	public Integer getLimitTimes() {
		return this.limitTimes;
	}
	public void setLimitTimes(Integer limitTimes) {
		this.limitTimes = limitTimes;
	}
	public Boolean getOnline() {
		return this.online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public String getIntegralTypeText() {
		return IntegralTypeEnum.getText(this.integralType);
	}
	
}