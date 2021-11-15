package com.tjcloud.sms.service;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.fastjson.JSON;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.sms.dao.SmsTplDao;
import com.tjcloud.sms.entity.SmsTpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 短信/微信 模板表
 * @author yinbin 2016.07.12
 */
@Service("smsTplService")
public class SmsTplServiceImpl implements SmsTplService {
	private static final Logger logger = LoggerFactory.getLogger(SmsTplServiceImpl.class);

	@Autowired
	private SmsTplDao smsTplDao;

	/**
	 * 获取短信模板列表
	 * @param param
	 * @return
	 */
	@Override
	public List<SmsTpl> getSmsTplList(Map<String, Object> param){
		if(param == null){
			param = new HashMap<String, Object>();
		}
		param.put("type", "1");
		param.put(Constants.DISABLED_KEY, 0);
		List<SmsTpl> dataList = smsTplDao.findBy(param);
//		return fillKeyList(dataList);
		return dataList;
	}

	/**
	 * 获取微信模板列表
	 * @param param
	 * @return
	 */
	@Override
	public List<SmsTpl> getWxTplList(Map<String, Object> param){
		if(param == null){
			param = new HashMap<String, Object>();
		}
		param.put("type", "2");
		param.put(Constants.DISABLED_KEY, 0);
		List<SmsTpl> dataList = smsTplDao.findBy(param);
//		return fillKeyList(dataList);
		return dataList;
		
	}
	

	/**
	 * 短信、微信模板 keyList 抓取
	 * @param regex
	 * @param source
	 * @return
	 */
	private List<SmsTpl> fillKeyList(List<SmsTpl> dataList) {
		if(dataList == null || dataList.isEmpty()){
			return null;
		}
		for (SmsTpl smsTpl : dataList) {
			String expression = smsTpl.getExpression();
			logger.debug("init getKeyList, param={}",expression);
			if(StringUtils.isEmpty(expression)){
				continue;
			}
			String regex = "(\\{\\w+\\})";
			String result = "";
			List<String> keyList = new ArrayList<String>();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(expression);
			logger.debug("param regex ={}", regex);
			while (matcher.find()) {
				result = matcher.group(1);
				keyList.add(result.substring(1, result.length() - 1));	
			}
			smsTpl.setTplKeys(keyList);
			logger.debug("result keyList ={}", JSON.toJSONString(keyList));
		}
		return dataList;
	}
	
	/**
	 * 获取模板对象
	 * @param id
	 * @return
	 */
	@Override
	public SmsTpl get(String id){
		logger.debug("get id:{}",id);
		return smsTplDao.get(id);
	}
}
