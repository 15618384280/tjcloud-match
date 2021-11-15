package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 用户评价(user_comment)
 * @author auto bin.yin 2018.06.28
 */
public class UserComment extends AbstractEntity {
	private static final long serialVersionUID = 1530171765009L;

	private String tenantId; //租户id
	private String stadiumId; //场馆id
	private String objectId; //评论项目id
	private String objectName;	//评价项目
	private String objectImage;	//评价图片
	private Integer commentType; //评论类型0-场馆管理员 1-stadiumitem项目 2-stadiumItem服务评价
	private String userId; //用户id
	private String userName; //用户昵称
	private String userImage;	//用户头像
	private String message; //评论信息
	private String grade; //综合评分
	private String activeId;	//活动id
	private String orderId;		//订单id
	
	private String commentTime;
	
	public String getCommentTime() {
		if(getCreatedTime() != null) {
			return DateUtils.toString(getCreatedTime(), Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getObjectImage() {
		return objectImage;
	}
	public void setObjectImage(String objectImage) {
		this.objectImage = objectImage;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getActiveId() {
		return activeId;
	}
	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getObjectId() {
		return this.objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Integer getCommentType() {
		return this.commentType;
	}
	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGrade() {
		return this.grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}