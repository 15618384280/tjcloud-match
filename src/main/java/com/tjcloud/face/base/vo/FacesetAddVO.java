package com.tjcloud.face.base.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class FacesetAddVO implements Serializable{

	private static final long serialVersionUID = 3193049888232293346L;
	
	@JSONField(name="image") 
	private String image; 				//图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断
	
	@JSONField(name="image_type") 
	private String imageType; 			//图片类型
	
	@JSONField(name="group_id") 
	private String groupId; 				//用户组id，标识一组用户（由数字、字母、下划线组成），长度限制48B。产品建议：根据您的业务需求，可以将需要注册的用户，按照业务划分，分配到不同的group下，例如按照会员手机尾号作为groupid，用于刷脸支付、会员计费消费等，这样可以尽可能控制每个group下的用户数与人脸数，提升检索的准确率
	
	@JSONField(name="user_id") 
	private String userId; 				//用户id（由数字、字母、下划线组成），长度限制128B
	
	@JSONField(name="user_info") 
	private String userInfo; 			//用户资料，长度限制256B 默认空
	
	@JSONField(name="quality_control") 
	private String qualityControl; 		//图片质量控制
	
	@JSONField(name="liveness_control") 
	private String livenessControl; 		//活体检测控制
	
	private Boolean clearFlag;			// 清除人脸库-userId标识

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getQualityControl() {
		return qualityControl;
	}

	public void setQualityControl(String qualityControl) {
		this.qualityControl = qualityControl;
	}

	public String getLivenessControl() {
		return livenessControl;
	}

	public void setLivenessControl(String livenessControl) {
		this.livenessControl = livenessControl;
	}

	public Boolean getClearFlag() {
		return clearFlag;
	}

	public void setClearFlag(Boolean clearFlag) {
		this.clearFlag = clearFlag;
	}
}
