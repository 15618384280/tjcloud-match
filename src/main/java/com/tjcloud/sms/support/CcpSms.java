package com.tjcloud.sms.support;

import com.alibaba.fastjson.JSON;
import com.cloopen.rest.sdk.CCPRestSDK;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.sms.SmsConstants;
import com.tjcloud.sms.vo.SmsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CcpSms {
	private static final Logger logger = LoggerFactory.getLogger(CcpSms.class);

	public static SmsResult send(String mobiles, String tplId, String... content) {
		SmsResult result = new SmsResult();
		try {
			CCPRestSDK restAPI = new CCPRestSDK();
			restAPI.init(SmsConstants.CCP.SMS_CCP_HOST, SmsConstants.CCP.SMS_CCP_PORT);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
			restAPI.setAccount(SmsConstants.CCP.SMS_CCP_SID, SmsConstants.CCP.SMS_CCP_TOKEN);// 初始化主帐号和主帐号TOKEN
			restAPI.setAppId(SmsConstants.CCP.SMS_CCP_APPID);// 初始化应用ID
			
			Map<String, Object> sendResult = restAPI.sendTemplateSMS(mobiles, tplId, content); //sendResult.put("statusCode", "000000");
			logger.info("CcpSms.send result=" + JSON.toJSONString(sendResult));
			if (sendResult != null) {
				if (StringUtils.msNull(SmsConstants.CCP.SMS_CCP_SUCCESS_CODE).equals(sendResult.get("statusCode"))) {
					result.setSuccess(true);
				} else {
					String message = (String) sendResult.get("statusMsg");
					result.setMessage(message);
					// 异常返回输出错误码和错误信息
					logger.error("短信发送失败！错误码：{}, 错误信息：{}", sendResult.get("statusCode"), message);
				}
			}
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}
