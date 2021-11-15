package com.tjcloud.face.base.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class FaceDetectBody implements Serializable{
	
	private static final long serialVersionUID = 7379537694438821010L;

	@JSONField(name="image") 
	private String images; 					//  图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断
	
	@JSONField(name="image_type") 
	private String imageType; 				//  图片类型
											//	BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
											//	URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
											//	FACE_TOKEN: 人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。
	
	@JSONField(name="face_field") 
	private String faceField; 				//  包括age,beauty,expression,face_shape,gender,glasses,landmark,landmark72，landmark150，race,quality,eye_status,emotion,face_type信息
											//	逗号分隔. 默认只返回face_token、人脸框、概率和旋转角度
	
	@JSONField(name="max_face_num") 
	private String maxFaceNum; 				//	最多处理人脸的数目，默认值为1，仅检测图片中面积最大的那个人脸；最大值10，检测图片中面积最大的几张人脸。
	
	@JSONField(name="face_type") 
	private String faceType; 				//	人脸的类型
											//	LIVE表示生活照：通常为手机、相机拍摄的人像图片、或从网络获取的人像图片等
											//	IDCARD表示身份证芯片照：二代身份证内置芯片中的人像照片
											//	WATERMARK表示带水印证件照：一般为带水印的小图，如公安网小图
											//	CERT表示证件照片：如拍摄的身份证、工卡、护照、学生证等证件图片
											//	默认LIVE

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

	public String getFaceField() {
		return faceField;
	}

	public void setFaceField(String faceField) {
		this.faceField = faceField;
	}

	public String getMaxFaceNum() {
		return maxFaceNum;
	}

	public void setMaxFaceNum(String maxFaceNum) {
		this.maxFaceNum = maxFaceNum;
	}

	public String getFaceType() {
		return faceType;
	}

	public void setFaceType(String faceType) {
		this.faceType = faceType;
	}
	
	
	
	
}
