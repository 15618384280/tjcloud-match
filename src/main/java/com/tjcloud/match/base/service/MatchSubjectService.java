package com.tjcloud.match.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.MatchSubject;
import com.tjcloud.match.base.entity.SignRecord;

import java.util.Map;

/**
 * 赛事科目表(match_subject)
 * @author auto bin.yin 2016.12.12
 */
public interface MatchSubjectService extends AbstractService<MatchSubject, String> {

	/**
	 * 统计赛事科目的最大报名人数、报名人数
	 * @param param
	 * @return
	 */
	Map<String,Object> sumMatchSubjectSignCount(Map<String, Object> param);
	
	/**
	 * 定时更改赛事科目状态
	 * @return
	 */
	void changeMatchSubjectStateSchedule() throws BusinessException;
	
	/**
	 * 生成参赛号码
	 * @return
	 */
	void systemMatchNo(MatchSubject matchSubject) throws BusinessException;
	
	/**
	 * 生成报名参赛号码
	 * @param param
	 * @param dataList
	 * @param matchno
	 * @param formatHead
	 * @param formatLength
	 */
	void setMatchNo(JSONObject param, SignRecord signRecord, MatchSubject matchSubject);
}
