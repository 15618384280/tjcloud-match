package com.tjcloud.order.base.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 运动人次统计表(order_fitness_report)
 * @author auto bin.yin 2018.10.22
 */
public class OrderFitnessReport extends AbstractEntity {
	private static final long serialVersionUID = 1494922995976L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Integer reginLevel;	// 区域级别：1-国；2-省；3-市；4-区；
	private String reginCode;	// 区域
	private Integer type;		// 统计类型：1-按运动类型；2-男女比；3-早晚比；4-年龄阶段比；5-排名靠前的学校；6-排名靠前的打卡记录；7-学校开放信息；
	private String stadiumId;	// 场馆Id
	private String period;      // 区间(Y.年,M.月,D.日,H.时)
	private Long people;        // 结果
	private String jsonData;	// jsonData
	private Long collectTime;   // 时间

	/**	非DB属性	**/
	private String collectDate; //日期
	
	public OrderFitnessReport(){
		
	}
	public OrderFitnessReport(Integer reginLevel, String reginCode, Integer type, String period, String jsonData, Long collectTime){
		this.reginLevel = reginLevel;
		this.reginCode = reginCode;
		this.type = type;
		this.period = period;
		this.jsonData = jsonData;
		this.collectTime = collectTime;
	}
	public OrderFitnessReport(Integer reginLevel, String reginCode, Integer type, String period, Long people, String jsonData, Long collectTime){
		this.reginLevel = reginLevel;
		this.reginCode = reginCode;
		this.type = type;
		this.period = period;
		this.people = people;
		this.jsonData = jsonData;
		this.collectTime = collectTime;
	}
	
	public OrderFitnessReport(Integer reginLevel, String reginCode, String period, Long people, Long collectTime){
		this.reginLevel = reginLevel;
		this.reginCode = reginCode;
		this.period = period;
		this.people = people;
		this.collectTime = collectTime;
	}
	
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Long getPeople() {
		return people;
	}
	public void setPeople(Long people) {
		this.people = people;
	}
	public Long getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Long collectTime) {
		this.collectTime = collectTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public Integer getReginLevel() {
		return reginLevel;
	}
	public void setReginLevel(Integer reginLevel) {
		this.reginLevel = reginLevel;
	}
	public String getReginCode() {
		return reginCode;
	}
	public void setReginCode(String reginCode) {
		this.reginCode = reginCode;
	}
	public JSONObject getJsonObject(){
		if(StringUtils.isEmpty(this.jsonData)){
			return null;
		}
		try{
			return JSONObject.parseObject(this.jsonData);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	public JSONArray getJsonArray(){
		if(StringUtils.isEmpty(this.jsonData)){
			return null;
		}
		try{
			if(this.jsonData.indexOf("[") != 0){
				return null;
			}
			return JSON.parseArray(this.jsonData);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
}