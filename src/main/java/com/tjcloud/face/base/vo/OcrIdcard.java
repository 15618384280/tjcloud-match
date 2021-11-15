package com.tjcloud.face.base.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.tjcloud.core.utils.StringUtils;

import java.io.Serializable;

public class OcrIdcard implements Serializable{

	private static final long serialVersionUID = -6861550090219843762L;

	@JSONField(name="image") 
	private String images; 						//图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	
	@JSONField(name="id_card_side") 
	private String idCardSide; 					//front：身份证含照片的一面；back：身份证带国徽的一面
	
	@JSONField(name="detect_direction") 
	private String detectDirection; 				//是否检测图像旋转角度，默认检测，即：true。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
												//- true：检测旋转角度；
												//- false：不检测旋转角度。
	
	@JSONField(name="detect_risk") 
	private String detectRisk; 					//是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getIdCardSide() {
		return StringUtils.isEmpty(idCardSide) ? "front" : idCardSide;
	}

	public void setIdCardSide(String idCardSide) {
		this.idCardSide = idCardSide;
	}

	public String getDetectDirection() {
		return detectDirection;
	}

	public void setDetectDirection(String detectDirection) {
		this.detectDirection = detectDirection;
	}

	public String getDetectRisk() {
		return detectRisk;
	}

	public void setDetectRisk(String detectRisk) {
		this.detectRisk = detectRisk;
	}
	
}
