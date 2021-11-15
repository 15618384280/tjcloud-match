package com.tjcloud.push.support;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.Constants;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.push.PushConstants;
import com.tjcloud.sms.vo.SmsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JPushSms {
	private static final Logger logger = LoggerFactory.getLogger(JPushSms.class);

	public static SmsResult push(String alert, String title, String extras, boolean alias, String... registrationIds) {
		SmsResult result = new SmsResult();
		JSONObject apilog = new JSONObject();
		try {
			JSONObject params = new JSONObject();
			params.put("alert", alert);
			params.put("title", title);
			if (alias) {
				params.put("aliasIds", registrationIds);
			} else {
				params.put("registrationIds", registrationIds);
			}
			if (StringUtils.isNotEmpty(extras)) {
				params.put("extras", extras);
			}
			
	        PushPayload payload = buildPush(alert, title, extras, alias, registrationIds);
            PushResult jpushResponse = getJPushClient().sendPush(payload);
            logger.info("Got result - " + jpushResponse);
            
            apilog.put(Constants.REQUEST_ATTR, JSON.toJSONString(params));
            
            if (jpushResponse != null && jpushResponse.isResultOK()) {
				result.setSuccess(true);
				result.setMessage("" + jpushResponse.msg_id);
				apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.SUCCESS);
			} else {
				apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.FAILED);
				result.setMessage("" + jpushResponse.msg_id);
			}
		
			apilog.put(Constants.RESPONSE_ATTR, JSON.toJSONString(jpushResponse));
		}  catch (APIConnectionException e) {
	        logger.error("Connection error. Should retry later. ", e);
	    } catch (APIRequestException e) {
			logger.error(e.getMessage(), e);
	        logger.info("HTTP Status: " + e.getStatus());
	        logger.info("Error Code: " + e.getErrorCode());
	        logger.info("Error Message: " + e.getErrorMessage());
	        logger.info("Msg ID: " + e.getMsgId());
			
			apilog.put("response", e.getMessage());
			apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.FAILED);
		} finally {
			result.setApilog(apilog);
		}
        return result;
	}

	public static SmsResult push(String alert, String title, String extras, boolean alias, Map<String, Object> data, String... registrationIds) {
		SmsResult result = new SmsResult();
		JSONObject apilog = new JSONObject();
		try {
			JSONObject params = new JSONObject();
			params.put("alert", alert);
			params.put("title", title);
			if (alias) {
				params.put("aliasIds", registrationIds);
			} else {
				params.put("registrationIds", registrationIds);
			}
			if (StringUtils.isNotEmpty(extras)) {
				params.put("extras", extras);
			}

			String pushMaster = StringUtils.msNull((String) data.get("pushMaster"));
			String pushAppKey = StringUtils.msNull((String) data.get("pushAppKey"));
			JPushClient jpClient = getJPushClient();
			if (StringUtils.isNotEmpty(pushMaster) && StringUtils.isNotEmpty(pushAppKey)) {
				jpClient = getJPushClient(pushMaster, pushAppKey);
			}

			PushPayload payload = buildPush(alert, title, extras, alias, registrationIds);
			PushResult jpushResponse = jpClient.sendPush(payload);
			logger.info("Got result - " + jpushResponse);

			apilog.put(Constants.REQUEST_ATTR, JSON.toJSONString(params));

			if (jpushResponse != null && jpushResponse.isResultOK()) {
				result.setSuccess(true);
				result.setMessage("" + jpushResponse.msg_id);
				apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.SUCCESS);
			} else {
				apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.FAILED);
				result.setMessage("" + jpushResponse.msg_id);
			}

			apilog.put(Constants.RESPONSE_ATTR, JSON.toJSONString(jpushResponse));
		}  catch (APIConnectionException e) {
			logger.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			logger.error(e.getMessage(), e);
			logger.info("HTTP Status: " + e.getStatus());
			logger.info("Error Code: " + e.getErrorCode());
			logger.info("Error Message: " + e.getErrorMessage());
			logger.info("Msg ID: " + e.getMsgId());

			apilog.put("response", e.getMessage());
			apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.FAILED);
		} finally {
			result.setApilog(apilog);
		}
		return result;
	}


	private static PushPayload buildPush(String alert, String title, String extras, boolean alias, String... registrationIds) {
		PushPayload.Builder builder = PushPayload.newBuilder().setPlatform(Platform.all());
		if (alias) {
			builder.setAudience(Audience.alias(registrationIds));
		} else {
			builder.setAudience(Audience.registrationId(registrationIds));
		}
		// builder.setAudience(Audience.all());
		AndroidNotification.Builder androidNotificationBuiler = AndroidNotification.newBuilder();
		IosNotification.Builder iosNotificationBuilder = IosNotification.newBuilder().setSound("default");
		if (StringUtils.isNotEmpty(title)){
			androidNotificationBuiler.setTitle(title);
		}
		if (StringUtils.isNotEmpty(extras)) {
			//JsonParser parser = new JsonParser();
			//JsonObject jsonExtra = (JsonObject) parser.parse(extras);

			androidNotificationBuiler.addExtra("extras", extras);
			iosNotificationBuilder.addExtra("extras", extras);
		}
		return builder.setNotification(Notification.newBuilder().setAlert(alert)
				.addPlatformNotification(androidNotificationBuiler.build())
				.addPlatformNotification(iosNotificationBuilder.build())
				.build())
				.setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
	}

	private static JPushClient getJPushClient() {
		ClientConfig clientConfig = ClientConfig.getInstance();
        return new JPushClient(PushConstants.JPUSH.JPUSH_MASTER_SECRET, PushConstants.JPUSH.JPUSH_APP_KEY, null, clientConfig);
	}

	private static JPushClient getJPushClient(String masterSec, String appKey) {
		ClientConfig clientConfig = ClientConfig.getInstance();
		return new JPushClient(masterSec, appKey, null, clientConfig);
	}
}
