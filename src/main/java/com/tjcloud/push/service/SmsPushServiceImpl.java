package com.tjcloud.push.service;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.Constants;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.engine.utils.TemplateUtils;
import com.tjcloud.log.push.entity.PushLog;
import com.tjcloud.mmq.producer.MMQProducer;
import com.tjcloud.push.PushConstants;
import com.tjcloud.push.support.JPushSms;
import com.tjcloud.sms.dao.SmsTplDao;
import com.tjcloud.sms.entity.SmsTpl;
import com.tjcloud.sms.vo.SmsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 消息推送
 * @author yinbin 2016.07.12
 */
@Service("smsPushService")
public class SmsPushServiceImpl implements SmsPushService {
	private static final Logger logger = LoggerFactory.getLogger(SmsPushServiceImpl.class);

	@Autowired
	private SmsTplDao smsTplDao;
	@Autowired
	private MMQProducer mmqProducer;

	@Override
	public boolean pushSms(String receivers, Map<String, Object> data) {
		String mmId = StringUtils.msNull((String) data.get("tplId"));
		return pushSms(mmId, receivers, data);
	}

	public boolean pushSms(String mmId, String receivers, Map<String, Object> data) {
		logger.info("### push sms params template {}, receivers {}, data {}", mmId, receivers, data);
		boolean sendSuccess = false;
		SmsTpl smsTpl = smsTplDao.get(mmId);
		if(smsTpl != null && !smsTpl.isDisabled() && data != null) {
			String content = TemplateUtils.formatString(smsTpl.getExpression(), data);

			logger.info("##### push sms receivers is {}, content is {}", receivers, content);
			sendSuccess = pushSms(mmId, smsTpl.getSignName(), receivers, content, data);
		} else {
			logger.error("###### push sms params template not found or is disabled. {}", mmId);
		}
		return sendSuccess;
	}

	public boolean pushSms(String mmId, String signName, String receivers, String content, Map<String, Object> data) {
		Boolean alias = (Boolean) data.get("alias");
		
		String extras = StringUtils.msNull((String)data.get("extras"));
		SmsResult sendResult = JPushSms.push(content, signName, extras, (alias == null ? true : alias), data, receivers);

		String receiverId = StringUtils.msNull((String) data.get("receiverId"));
		String buzKey = StringUtils.msNull((String) data.get("buzKey"));
		String buzType = StringUtils.msNull((String) data.get("buzType"));
		String subject = StringUtils.msNull((String) data.get("subject"));
		
		PushLog pushlog = new PushLog();
		if (StringUtils.isNotEmpty(receiverId)) {
			pushlog.setReceiverId(receiverId);
		}
		if (StringUtils.isNotEmpty(buzKey)) {
			pushlog.setBuzKey(buzKey);
		}
		if (StringUtils.isNotEmpty(buzType)) {
			pushlog.setBuzType(buzType);
		}
		if (StringUtils.isNotEmpty(subject)) {
			pushlog.setSubject(subject);
		}
		pushlog.setReceivers(receivers);
		pushlog.setTplId(mmId);
		pushlog.setChannel(PushConstants.Channel.PUSH_CHANNEL_JPUSH);
		pushlog.setContent(content);
		pushlog.setSuccess(sendResult.isSuccess());
		if (StringUtils.isNotEmpty(sendResult.getMessage())) {
			pushlog.setMessage(sendResult.getMessage());
		}
		pushlog.setSendResult(JSON.toJSONString(sendResult));
		
		mmqProducer.sendMessage(Constants.LOGGING.API_LOGGING.toString(), JSON.toJSONString(sendResult.getApilog()));
		mmqProducer.sendMessage(Constants.LOGGING.PUSH_LOGGING.toString(), JSON.toJSONString(pushlog));
		return sendResult.isSuccess();
	}

}
