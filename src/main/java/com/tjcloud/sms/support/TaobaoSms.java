package com.tjcloud.sms.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.tjcloud.core.Constants;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.sms.SmsConstants;
import com.tjcloud.sms.vo.SmsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TaobaoSms {
	private static final Logger logger = LoggerFactory.getLogger(TaobaoSms.class);

	public static SmsResult send(String mobiles, String signName, String tplId, Map<String, Object> data) {
		SmsResult result = new SmsResult();
		JSONObject apilog = new JSONObject();
		try {
			TaobaoClient client = new DefaultTaobaoClient(SmsConstants.TAOBAO.SMS_TAOBAO_API_URL, SmsConstants.TAOBAO.SMS_TAOBAO_APP_KEY, SmsConstants.TAOBAO.SMS_TAOBAO_APP_SECRET);
			AlibabaAliqinFcSmsNumSendRequest request = new AlibabaAliqinFcSmsNumSendRequest();
			request.setExtend("123456");
			request.setSmsType("normal");
			request.setSmsFreeSignName(signName);
			request.setSmsParamString(JSON.toJSONString(data));
			request.setRecNum(mobiles);
			request.setSmsTemplateCode(tplId);
			
			apilog.put(Constants.REQUEST_ATTR, JSON.toJSONString(request));
			
			AlibabaAliqinFcSmsNumSendResponse alibabaResponse = client.execute(request);
			if (alibabaResponse != null && alibabaResponse.isSuccess()) {
				result.setSuccess(true);
				result.setMessage(alibabaResponse.getMsg());
				apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.SUCCESS);
			} else {
				apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.FAILED);
				result.setMessage(alibabaResponse.getSubMsg());
			}

			apilog.put(Constants.METHOD_ATTR, request.getApiMethodName());
			apilog.put(Constants.BODY_ATTR, alibabaResponse.getBody());
			apilog.put(Constants.RESPONSE_ATTR, JSON.toJSONString(alibabaResponse));
		} catch (ApiException e) {
			logger.error(e.getMessage(), e);
			apilog.put("response", e.getMessage());
			apilog.put(Constants.RESPONSE_SUCCESS_ATTR, ResponseResult.RESPONSE.FAILED);
		} finally {
			result.setApilog(apilog);
		}
		return result;
	}
}
