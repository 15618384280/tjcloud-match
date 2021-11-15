package com.tjcloud.sms.service;

import java.util.Map;

public interface SmsSendService {

	/**
	 * 发送短信
	 * @param mobiles 手机号码
	 * @param data 数据
	 * @return boolean true/false
	 */
	boolean sendSms(String mobiles, Map<String, Object> data);

	/**
	 * 发送短信
	 * @param tplId 模板ID
	 * @param mobiles 手机号码
	 * @param data 数据
	 * @return boolean true/false
	 */
	boolean sendSms(String tplId, String mobiles, Map<String, Object> data);
}
