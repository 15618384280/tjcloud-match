package com.tjcloud.face.base.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class FaceInfoVO implements Serializable{

	private static final long serialVersionUID = -2398404436853793338L;
	
	@JSONField(name="images") 
	private String images; 				//分别base64编码后的2张图片数据，需urlencode，半角逗号分隔，单次请求最大不超过20M
	
	@JSONField(name="ext_fields") 
	private String extFields; 			//返回质量信息，取值固定，目前支持qualities(质量检测)(对所有图片都会做改处理)
	
	@JSONField(name="image_liveness") 
	private String imageLiveness; 
	
	@JSONField(name="types") 
	private String types; 				//返回质量信息，取值固定，目前支持qualities(质量检测)(对所有图片都会做改处理)

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getExtFields() {
		return extFields;
	}

	public void setExtFields(String extFields) {
		this.extFields = extFields;
	}

	public String getImageLiveness() {
		return imageLiveness;
	}

	public void setImageLiveness(String imageLiveness) {
		this.imageLiveness = imageLiveness;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}
	

}
