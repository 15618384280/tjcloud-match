package com.tjcloud.uac.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 消息中心(message_center)
 * @author auto bin.yin 2018.08.15
 */
public class MessageCenter extends AbstractEntity {
	private static final long serialVersionUID = 1534325984982L;

	private Integer msgType; //0-订场信息
	private Integer userType; //0-用户端 1-管理端
	private String msgTitle;	//消息主题
	private String msgImage;	//图片
	private String msgUrl;		//链接
	private String msgContent; //消息内容
	private String tenantId; //租户id
	private String stadiumId; //场馆id
	private String stadiumItemId; //项目id
	private String userId; //用户id
	private String objectId; //业务主键
	private Boolean isRead; //0-未读 1-已读
	private String stadiumName;
	private String stadiumItemName;
	
	public MessageCenter(){
		
	}

	public MessageCenter(Integer msgType,Integer userType,String msgTitle, String msgUrl,String msgContent,String userId){
		this.msgType = msgType;
		this.userType = userType;
		this.msgTitle = msgTitle;
		this.msgUrl = msgUrl;
		this.msgContent = msgContent;
		this.userId = userId;
		this.isRead = false;
	}
	
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	public String getMsgImage() {
		return msgImage;
	}
	public void setMsgImage(String msgImage) {
		this.msgImage = msgImage;
	}
	public String getMsgUrl() {
		return msgUrl;
	}
	public void setMsgUrl(String msgUrl) {
		this.msgUrl = msgUrl;
	}
	public Integer getMsgType() {
		return this.msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	public Integer getUserType() {
		return this.userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getMsgContent() {
		return this.msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
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
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getObjectId() {
		return this.objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Boolean getIsRead() {
		return this.isRead;
	}
	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}
}