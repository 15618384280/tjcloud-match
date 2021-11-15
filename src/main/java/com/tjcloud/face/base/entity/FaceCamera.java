package com.tjcloud.face.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 学校开放摄像头安装位置信息表(face_camera)
 * @author auto bin.yin 2019.08.26
 */
public class FaceCamera extends AbstractEntity {
	private static final long serialVersionUID = 1566790430790L;

	private String stadiumItemId; //学校项目ID
	private String stadiumItemName; //学校项目
	private String stadiumId; //学校ID
	private String stadiumName; //学校名称
	private String deviceCode; //摄像机编码
	private String modelVersion; //摄像机版本
	private String cameraName; //摄像机名称
	private String describeLocation; //位置描述
	private String locatinPhotoUrl; //摄像头位置实景照片URL
	private String longitude; //经度,东经为正数
	private String latitude; //纬度
	private String longitude84; //经度,东经为正数
	private String latitude84; //纬度

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getDeviceCode() {
		return this.deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getModelVersion() {
		return this.modelVersion;
	}
	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}
	public String getCameraName() {
		return this.cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	public String getDescribeLocation() {
		return this.describeLocation;
	}
	public void setDescribeLocation(String describeLocation) {
		this.describeLocation = describeLocation;
	}
	public String getLocatinPhotoUrl() {
		return this.locatinPhotoUrl;
	}
	public void setLocatinPhotoUrl(String locatinPhotoUrl) {
		this.locatinPhotoUrl = locatinPhotoUrl;
	}
	public String getLongitude() {
		return this.longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return this.latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude84() {
		return this.longitude84;
	}
	public void setLongitude84(String longitude84) {
		this.longitude84 = longitude84;
	}
	public String getLatitude84() {
		return this.latitude84;
	}
	public void setLatitude84(String latitude84) {
		this.latitude84 = latitude84;
	}
}