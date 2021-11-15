package com.tjcloud.sms.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class SmsResult implements Serializable {
	private static final long serialVersionUID = -8234942270252291375L;

	private boolean success = false;
	private String message;
	private JSONObject apilog;

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public JSONObject getApilog() {
		return apilog;
	}
	public void setApilog(JSONObject apilog) {
		this.apilog = apilog;
	}
}
