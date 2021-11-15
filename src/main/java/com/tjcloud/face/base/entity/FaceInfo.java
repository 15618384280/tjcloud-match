package com.tjcloud.face.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 人脸信息表(face_info)
 * @author auto bin.yin 2018.10.17
 */
public class FaceInfo extends AbstractEntity {
	private static final long serialVersionUID = 1539778425724L;

	@JSONField(name="image") 
	private String image; //图片
	
	@JSONField(name="image_type") 
	private String imageType; //图片类型: 1-BASE64,2-URL,3-FACE_TOKEN
	
	@JSONField(name="group_id") 
	private String groupId; //FACE组ID
	
	@JSONField(name="user_id") 
	private String userId; //用户id
	
	@JSONField(name="user_info") 
	private String userInfo; //用户资料
	
	@JSONField(name="quality_control") 
	private String qualityControl; //图片质量控制 NONE: 不进行控制 LOW:较低的质量要求 NORMAL: 一般的质量要求 HIGH: 较高的质量要求 默认 NONE
	
	@JSONField(name="liveness_control") 
	private String livenessControl; //活体检测控制 NONE: 不进行控制 LOW:较低的活体要求(高通过率 低攻击拒绝率) NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率) HIGH: 较高的活体要求(高攻击拒绝率 低通过率) 默认NONE
	
	private String logId; //请求标识码，随机数，唯一
	private String faceToken; //人脸图片的唯一标识
	private String location; //人脸在图片中的位置
	private Integer left; //人脸区域离左边界的距离
	private Integer top; //人脸区域离上边界的距离
	private Integer width; //人脸区域的宽度
	private Integer height; //人脸区域的高度
	private String rotation; //人脸框相对于竖直方向的顺时针旋转角，[-180,180]

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImageType() {
		return this.imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserInfo() {
		return this.userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public String getQualityControl() {
		return this.qualityControl;
	}
	public void setQualityControl(String qualityControl) {
		this.qualityControl = qualityControl;
	}
	public String getLivenessControl() {
		return this.livenessControl;
	}
	public void setLivenessControl(String livenessControl) {
		this.livenessControl = livenessControl;
	}
	public String getLogId() {
		return this.logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getFaceToken() {
		return this.faceToken;
	}
	public void setFaceToken(String faceToken) {
		this.faceToken = faceToken;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getLeft() {
		return this.left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getTop() {
		return this.top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getWidth() {
		return this.width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return this.height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getRotation() {
		return this.rotation;
	}
	public void setRotation(String rotation) {
		this.rotation = rotation;
	}
}