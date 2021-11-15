package com.tjcloud.face.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 学校开放非法越界告警信息表
(face_warn)
 * @author auto bin.yin 2019.08.26
 */
public class FaceWarn extends AbstractEntity {
	private static final long serialVersionUID = 1389790432112L;

	private String cameraId; //摄像头ID
	private Long warnTime; //越界时间
	private String warnUrl; //告警图片URL
	private Integer state; //0-待处理，1-处理中，2-已处理
	private String schoolUrl; //学校MQ的Url
	private String stdId; //学校Id

	public String getCameraId() {
		return cameraId;
	}

	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}

	public Long getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(Long warnTime) {
		this.warnTime = warnTime;
	}

	public String getWarnUrl() {
		return warnUrl;
	}

	public void setWarnUrl(String warnUrl) {
		this.warnUrl = warnUrl;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getSchoolUrl() {
		return schoolUrl;
	}

	public void setSchoolUrl(String schoolUrl) {
		this.schoolUrl = schoolUrl;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
}