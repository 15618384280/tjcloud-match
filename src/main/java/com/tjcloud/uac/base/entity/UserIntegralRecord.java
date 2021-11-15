package com.tjcloud.uac.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.uac.api.enums.IntegralChannelEnum;

/**
 * 用户积分记录(user_integral_record)
 * @author auto bin.yin 2019.02.15
 */
public class UserIntegralRecord extends AbstractEntity {
	private static final long serialVersionUID = 1550216792363L;

	private String platformId; //平台id
	private String userId; //用户id
	private Integer channel; //获取/消费渠道
	private Integer type; //业务类型0-增加 1-消费
	private Long integral; //积分
	private Long beforeIntegral; //记录前积分
	private Long afterIntegral; //记录后积分
	private String objectId; //业务主键
	
	public String getCreatedTimeText() {
		if(this.getCreatedTime() != null) {
			return DateUtils.toString(this.getCreatedTime(), Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	public String getChannelText() {
		if(this.channel != null) {
			return IntegralChannelEnum.getText(this.channel);
		}
		return "";
	}
	public String getPlatformId() {
		return this.platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getChannel() {
		return this.channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getIntegral() {
		return this.integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
	public Long getBeforeIntegral() {
		return this.beforeIntegral;
	}
	public void setBeforeIntegral(Long beforeIntegral) {
		this.beforeIntegral = beforeIntegral;
	}
	public Long getAfterIntegral() {
		return this.afterIntegral;
	}
	public void setAfterIntegral(Long afterIntegral) {
		this.afterIntegral = afterIntegral;
	}
	public String getObjectId() {
		return this.objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
}