package com.tjcloud.face.base.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ImageAttr implements Serializable{

	private static final long serialVersionUID = 5675984637081997627L;

	@JSONField(name="image") 
	private String images; 					//图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断
	
	@JSONField(name="image_type") 
	private String imageType; 				//图片类型
	
	@JSONField(name="face_type") 
	private String faceType; 				//人脸的类型
	
	@JSONField(name="quality_control") 
	private String qualityControl; 			//图片质量控制
	
	@JSONField(name="liveness_control") 
	private String livenessControl; 			//活体检测控制

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

	public String getFaceType() {
		return faceType;
	}

	public void setFaceType(String faceType) {
		this.faceType = faceType;
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
	
}
