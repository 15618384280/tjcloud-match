package com.tjcloud.log.push.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 短信日志
 * @author bin.yin 2016.04.16
 */
public class PushLog extends AbstractEntity {
	private static final long serialVersionUID = -2869793849410155282L;

	private String receiverId; //接收人ID
	private String buzKey;     //业务主键ID
	private String buzType;    //业务类型
	private String receivers;  //接收人
	private String tplId;      //短信模板
	private String channel;    //发送渠道
	private String subject;    //标题
	private String content;    //短信内容
	private String type;       //消息类型
	private Boolean success;   //是否发送成功
	private String message;    //失败原因
	private String sendResult; //响应结果

	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getBuzKey() {
		return buzKey;
	}
	public void setBuzKey(String buzKey) {
		this.buzKey = buzKey;
	}
	public String getBuzType() {
		return buzType;
	}
	public void setBuzType(String buzType) {
		this.buzType = buzType;
	}
	public String getReceivers() {
		return receivers;
	}
	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}
	public String getTplId() {
		return tplId;
	}
	public void setTplId(String tplId) {
		this.tplId = tplId;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSendResult() {
		return sendResult;
	}
	public void setSendResult(String sendResult) {
		this.sendResult = sendResult;
	}
}
