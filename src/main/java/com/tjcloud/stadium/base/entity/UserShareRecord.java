package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 用户分享记录表(user_share_record)
 * @author auto bin.yin 2019.02.18
 */
public class UserShareRecord extends AbstractEntity {
	private static final long serialVersionUID = 1550474809141L;

	private String userId; //用户id
	private Long shareTime; //分享时间
	private String shareDate; //分享日期
	private Integer shareType; //分享类型0-小程序 1-场馆 2-项目 3-赛事 4-培训 5-订单
	private String objectId; //分享应用id
	private Long integral; //奖励积分

	public String getSharTimeText() {
		if(this.shareTime != null) {
			return DateUtils.toString(this.shareTime, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getShareTime() {
		return this.shareTime;
	}
	public void setShareTime(Long shareTime) {
		this.shareTime = shareTime;
	}
	public String getShareDate() {
		return this.shareDate;
	}
	public void setShareDate(String shareDate) {
		this.shareDate = shareDate;
	}
	public Integer getShareType() {
		return this.shareType;
	}
	public void setShareType(Integer shareType) {
		this.shareType = shareType;
	}
	public String getObjectId() {
		return this.objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Long getIntegral() {
		return this.integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
}