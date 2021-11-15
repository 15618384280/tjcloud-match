package com.tjcloud.sms.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 短信/微信模板表(dd_sms_tpl)
 * @author auto bin.yin 2016.06.01
 */
public class SmsTpl extends AbstractEntity {
	private static final long serialVersionUID = 1464752063785L;

	private Integer type;		//模板类型：1-短信；2-微信；
	private String tplId;      //供应商模板ID
	private String signName;   //短信签名
	private String name;       //模板名称
	private String expression; //模板表达式
	private String interval;   //发送间隔
	private String frequency;  //发送频率
	private Boolean pushApp;   //推送APP消息
	
	private List<String> tplKeys;

	public Boolean isPushApp() {
		return pushApp;
	}
	public void setPushApp(Boolean pushApp) {
		this.pushApp = pushApp;
	}
	public String getTplId() {
		return tplId;
	}
	public void setTplId(String tplId) {
		this.tplId = tplId;
	}
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpression() {
		return this.expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getInterval() {
		return this.interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String getFrequency() {
		return this.frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<String> getTplKeys() {
		if(this.tplKeys != null && !this.tplKeys.isEmpty()){
			return this.tplKeys;
		}
		return getKeyList(this.expression);
	}
	public void setTplKeys(List<String> tplKeys) {
		this.tplKeys = tplKeys;
	}
	
	/**
	 * 短信、微信模板 keyList 抓取
	 * @param regex
	 * @param source
	 * @return
	 */
	private List<String> getKeyList(String expression) {
		if(StringUtils.isEmpty(expression)){
			return null;
		}
		String regex = "(\\{\\w+\\})";
		String result = "";
		List<String> keyList = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			result = matcher.group(1);
			keyList.add(result.substring(1, result.length() - 1));	
		}
		return keyList;
	}
	
}