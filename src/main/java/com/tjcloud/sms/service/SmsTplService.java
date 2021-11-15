package com.tjcloud.sms.service;

import com.tjcloud.sms.entity.SmsTpl;

import java.util.List;
import java.util.Map;

/**
 * 短信/微信模板表(dd_sms_tpl)
 * @author auto bin.yin 2016.06.01
 */
public interface SmsTplService {

	/**
	 * 获取短信模板列表
	 * @return
	 */
	List<SmsTpl> getSmsTplList(Map<String, Object> param);

	/**
	 * 获取微信模板列表
	 * @return
	 */
	List<SmsTpl> getWxTplList(Map<String, Object> param);

	/**
	 * 获取模板对象
	 * @param id
	 * @return
	 */
	SmsTpl get(String id);

}
