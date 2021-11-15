package com.tjcloud.face.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 人脸库信息表(face_pool)
 * @author auto bin.yin 2018.10.17
 */
public class FacePool extends AbstractEntity {
	private static final long serialVersionUID = 1539778425888L;

	private String appId; //应用ID
	private String apiKey; //Api Key
	private String secretKey; //Secret Key
	private Integer maxFace; //最大人脸数量
	private String remark; //备注

	public String getAppId() {
		return this.appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getApiKey() {
		return this.apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getSecretKey() {
		return this.secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public Integer getMaxFace() {
		return this.maxFace;
	}
	public void setMaxFace(Integer maxFace) {
		this.maxFace = maxFace;
	}
	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}