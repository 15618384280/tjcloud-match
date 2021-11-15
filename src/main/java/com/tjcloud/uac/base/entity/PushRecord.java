package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 推送记录表(push_record)
 * @author auto bin.yin 2016.12.07
 */
@LogRequired
public class PushRecord extends AbstractEntity {
	private static final long serialVersionUID = 1481079810354L;

	private String pushJobPersonId;
	private String operatorId; //操作人
	private String operatorName; //操作人名称
	private String receiverId; //接收人id
	private String receiverName; //接收人名称
	private String deviceId; //设备号
	private String message; //消息
	private Long pushTime; //推送时间
	private String jobId; //jobid

	public String getPushJobPersonId() {
		return this.pushJobPersonId;
	}

	public void setPushJobPersonId(String pushJobPersonId) {
		this.pushJobPersonId = pushJobPersonId;
	}

	public String getOperatorId() {
		return this.operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return this.operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getReceiverId() {
		return this.receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverName() {
		return this.receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getDeviceId() {
		return this.deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Long getPushTime() {
		return this.pushTime;
	}
	public void setPushTime(Long pushTime) {
		this.pushTime = pushTime;
	}

	public String getJobId() {
		return this.jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
}