package com.tjcloud.push.service;

import java.util.Map;

public interface SmsPushService {

	boolean pushSms(String receivers, Map<String, Object> data);

	boolean pushSms(String mmId, String signName, String receivers, String content, Map<String, Object> data);
}
