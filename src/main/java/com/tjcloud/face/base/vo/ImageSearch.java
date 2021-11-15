package com.tjcloud.face.base.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ImageSearch implements Serializable{

	private static final long serialVersionUID = 2841142892242227633L;

	@JSONField(name="image") 
	private String images; 					//图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断
	
	@JSONField(name="image_type") 
	private String imageType; 				//图片类型
	
	@JSONField(name="group_id_list") 
	private String groupIdList; 				//从指定的group中进行查找 用逗号分隔，上限10个
	
	@JSONField(name="quality_control") 
	private String qualityControl; 			//图片质量控制
	
	@JSONField(name="liveness_control") 
	private String livenessControl; 			//活体检测控制
	
	@JSONField(name="user_id") 
	private String userId; 					//当需要对特定用户进行比对时，指定user_id进行比对。即人脸认证功能
	
	@JSONField(name="max_user_num") 
	private String maxUsernum; 			//查找后返回的用户数量。返回相似度最高的几个用户，默认为1，最多返回20个

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
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

	public String getGroupIdList() {
		return groupIdList;
	}

	public void setGroupIdList(String groupIdList) {
		this.groupIdList = groupIdList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMaxUsernum() {
		return maxUsernum;
	}

	public void setMaxUsernum(String maxUsernum) {
		this.maxUsernum = maxUsernum;
	}

}
