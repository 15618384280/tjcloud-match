package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 消息推送任务记录表(push_job)
 * @author auto bin.yin 2016.12.07
 */
@LogRequired
public class PushJob extends AbstractEntity {
	private static final long serialVersionUID = 1481079809724L;

	private String userId; //用户id
	private String userName; //用户名称
	private String message; //消息
	private Integer msgType; //消息类型
	private Long pushTime; //推送时间
	private String pushTimes;
	private Boolean pushType; //推送类型 0-立即推送 1-定时推送
	private String note; //备注
	private String templateCode; //模板code
	private String templateId; //模板id
	private Long startPeriod;
	private Long endPeriod;
	private Integer frequencyType;
	private List<String> frequencyS;
	private String frequencys;
	private String frequencyTime;
	private String frequencyDay;
	private Boolean status = false; //0-未推 1-已推
	private List<PushJobPerson> pushJobPersons;

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMsgType() {
		return this.msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Long getPushTime() {
		return this.pushTime;
	}
	public void setPushTime(Long pushTime) {
		this.pushTime = pushTime;
	}

	public String getPushTimes() {
		return this.pushTimes;
	}

	public void setPushTimes(String pushTimes) {
		this.pushTimes = pushTimes;
	}

	public Boolean getPushType() {
		return this.pushType;
	}
	public void setPushType(Boolean pushType) {
		this.pushType = pushType;
	}

	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public String getTemplateCode() {
		return this.templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Long getStartPeriod() {
		return this.startPeriod;
	}

	public void setStartPeriod(Long startPeriod) {
		this.startPeriod = startPeriod;
	}

	public Long getEndPeriod() {
		return this.endPeriod;
	}

	public void setEndPeriod(Long endPeriod) {
		this.endPeriod = endPeriod;
	}

	public Integer getFrequencyType() {
		return this.frequencyType;
	}

	public void setFrequencyType(Integer frequencyType) {
		this.frequencyType = frequencyType;
	}

	public List<String> getFrequencyS() {
		return this.frequencyS;
	}

	public void setFrequencyS(List<String> frequencyS) {
		this.frequencyS = frequencyS;
	}

	public String getFrequencys() {
		return this.frequencys;
	}

	public void setFrequencys(String frequencys) {
		this.frequencys = frequencys;
	}

	public String getFrequencyTime() {
		return this.frequencyTime;
	}

	public void setFrequencyTime(String frequencyTime) {
		this.frequencyTime = frequencyTime;
	}

	public String getFrequencyDay() {
		return this.frequencyDay;
	}

	public void setFrequencyDay(String frequencyDay) {
		this.frequencyDay = frequencyDay;
	}

	public Boolean getStatus() {
		return this.status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<PushJobPerson> getPushJobPersons() {
		return this.pushJobPersons;
	}

	public void setPushJobPersons(List<PushJobPerson> pushJobPersons) {
		this.pushJobPersons = pushJobPersons;
	}
}