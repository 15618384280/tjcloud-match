package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 推送人记录表(push_job_person)
 * @author auto bin.yin 2016.12.07
 */
@LogRequired
public class PushJobPerson extends AbstractEntity {
	private static final long serialVersionUID = 1481079810205L;

	private String jobId;
	private String recipientId; //接收人id 对应userId app的user表的id
	private String recipientName; //接收人名称
	private String message; //消息
	private String deviceId;
	private String mobile;

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getRecipientId() {
		return this.recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getRecipientName() {
		return this.recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}