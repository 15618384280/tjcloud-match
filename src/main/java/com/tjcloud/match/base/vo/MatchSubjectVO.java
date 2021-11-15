package com.tjcloud.match.base.vo;

import com.tjcloud.core.Constants;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.match.base.entity.MatchSubject;

/**
 * 赛事科目表(match_subject)
 * @author auto bin.yin 2016.12.12
 */
public class MatchSubjectVO extends MatchSubject {

	private static final long serialVersionUID = -6625196782935914818L;
	
	private String tenantId; 									//租户Id
	private String gameTimeStr; 								//比赛开始时间
	private String gameEndTimeStr; 								//比赛结束时间
	private String upStartTimeStr; 								//科目报名开始时间
	private String upEndTimeStr; 								//科目报名结束时间
	
	
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getGameTimeStr() {
		if(!ObjectUtils.isEmpty(super.getGameTime())){
			gameTimeStr = DateUtils.formatDate(super.getGameTime(), Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return gameTimeStr;
	}
	public void setGameTimeStr(String gameTimeStr) {
		this.gameTimeStr = gameTimeStr;
		super.setGameTime(DateUtils.toLong(gameTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}
	
	public String getGameEndTimeStr() {
		if(!ObjectUtils.isEmpty(super.getGameEndTime())){
			gameEndTimeStr = DateUtils.formatDate(super.getGameEndTime(), Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return gameEndTimeStr;
	}
	public void setGameEndTimeStr(String gameEndTimeStr) {
		this.gameEndTimeStr = gameEndTimeStr;
		super.setGameEndTime(DateUtils.toLong(gameEndTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}
	
	public String getUpStartTimeStr() {
		if(!ObjectUtils.isEmpty(super.getUpStartTime())){
			upStartTimeStr = DateUtils.formatDate(super.getUpStartTime(), Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return upStartTimeStr;
	}
	public void setUpStartTimeStr(String upStartTimeStr) {
		this.upStartTimeStr = upStartTimeStr;
		super.setUpStartTime(DateUtils.toLong(upStartTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}
	
	public String getUpEndTimeStr() {
		if(!ObjectUtils.isEmpty(super.getUpEndTime())){
			upEndTimeStr = DateUtils.formatDate(super.getUpEndTime(), Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return upEndTimeStr;
	}
	public void setUpEndTimeStr(String upEndTimeStr) {
		this.upEndTimeStr = upEndTimeStr;
		super.setUpEndTime(DateUtils.toLong(upEndTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}

}