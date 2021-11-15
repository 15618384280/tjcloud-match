package com.tjcloud.sms.service;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.Constants;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.crypto.Cryption;
import com.tjcloud.data.redis.service.RedisCache;
import com.tjcloud.engine.utils.TemplateUtils;
import com.tjcloud.enums.SmsTypeEnums;
import com.tjcloud.log.sms.entity.SmsLog;
import com.tjcloud.mmq.producer.MMQProducer;
import com.tjcloud.push.service.SmsPushService;
import com.tjcloud.sms.SmsConstants;
import com.tjcloud.sms.dao.SmsTplDao;
import com.tjcloud.sms.entity.SmsTpl;
import com.tjcloud.sms.support.TaobaoSms;
import com.tjcloud.sms.vo.SmsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 短信发送
 * @author yinbin 2016.07.12
 */
@Service("smsSendService")
public class SmsSendServiceImpl implements SmsSendService {
	private static final Logger logger = LoggerFactory.getLogger(SmsSendServiceImpl.class);

	@Autowired
	private SmsTplDao smsTplDao;
	@Autowired
	private MMQProducer mmqProducer;

	@Autowired
    private SmsPushService smsPushService;

	@Autowired
	private RedisCache redisCache;

	@Override
	public boolean sendSms(String mobiles, Map<String, Object> data) {
		String mmId = StringUtils.msNull((String) data.get("tplId"));
		return sendSms(mmId, mobiles, data);
	}

	@Override
	public boolean sendSms(String mmId, String mobiles, Map<String, Object> data) {
		if(mmId.equals(SmsTypeEnums.SMS_STADIUM_NOTICE_SUCCESS.getCode())
				|| mmId.equals(SmsTypeEnums.SMS_CODE_TICKET_ORDER_SUCCESS.getCode())
				|| mmId.equals(SmsTypeEnums.SMS_THIRDPARTY_ORDER_SUCCESS.getCode())) {

		}else {
			boolean sendInOneMinutes = redisCache.exists(Constants.SMS_SEND_MOBILE + mmId + "_" + mobiles);
			if (sendInOneMinutes) {
				logger.error("^-^ You have send a sms in one minutes. skip {}, {}", mmId, mobiles);
				return false;
			}
		}
		logger.info("^_^ send sms params template {}, mobiles {}, data {}", mmId, mobiles, data);
		boolean sendSuccess = false;
		SmsTpl smsTpl = smsTplDao.get(mmId);
		if(smsTpl != null && !smsTpl.isDisabled() && data != null) {
			String content = TemplateUtils.formatString(smsTpl.getExpression(), data);
			if (SmsConstants.Channel.SMS_CHANNEL_TAOBAO.equals(SmsConstants.SMS_CHANNEL_DEFAULT)) {
				content = String.format(SmsConstants.SMS_FORMAT_SIGN, smsTpl.getSignName()) + content;
			}
			logger.info("^_^ send sms mobiles is {}, content is {}", mobiles, content);
			sendSuccess = sendSms(mmId, smsTpl.getSignName(), smsTpl.getTplId(), mobiles, content, data);

			try {
				if(smsTpl.isPushApp()){
					smsPushService.pushSms(mmId, smsTpl.getSignName(), Cryption.md5Hex(mobiles).toLowerCase(), content, data);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		} else {
			logger.error("^_^ send sms params template not found or is disabled. {}", mmId);
		}
		return sendSuccess;
	}

	private boolean sendSms(String mmId, String signName, String tplId, String mobiles, String content, Map<String, Object> data) {
		SmsResult sendResult = TaobaoSms.send(mobiles, signName, tplId, data); //CcpSms.send(mobiles, tplId, content);
		boolean sendSuccess = sendResult.isSuccess();

		String receiverId = StringUtils.msNull((String) data.get("receiverId"));
		String buzKey = StringUtils.msNull((String) data.get("buzKey"));
		String buzType = StringUtils.msNull((String) data.get("buzType"));

		SmsLog smslog = new SmsLog();
		if (StringUtils.isNotEmpty(receiverId)) {
			smslog.setReceiverId(receiverId);
		}
		if (StringUtils.isNotEmpty(buzKey)) {
			smslog.setBuzKey(buzKey);
		}
		if (StringUtils.isNotEmpty(buzType)) {
			smslog.setBuzType(buzType);
		}
		smslog.setReceivers(mobiles);
		smslog.setTplId(mmId);
		smslog.setChannel(SmsConstants.SMS_CHANNEL_DEFAULT);
		smslog.setContent(content);
		smslog.setSuccess(sendSuccess);
		if (StringUtils.isNotEmpty(sendResult.getMessage())) {
			smslog.setMessage(sendResult.getMessage());
		}
		smslog.setSendResult(JSON.toJSONString(sendResult));
		if (sendSuccess) {
			redisCache.set(Constants.SMS_SEND_MOBILE + mmId + "_" + mobiles, mobiles, Constants.ONE_MINUTES_SECONDS);
		}

		mmqProducer.sendMessage(Constants.LOGGING.API_LOGGING.toString(), JSON.toJSONString(sendResult.getApilog()));
		mmqProducer.sendMessage(Constants.LOGGING.SMS_LOGGING.toString(), JSON.toJSONString(smslog));
		return sendSuccess;
	}
}
