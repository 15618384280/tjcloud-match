package com.tjcloud.match.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.MatchInfo;

import java.util.List;
import java.util.Map;

/**
 * 赛事主表(match_info)
 * @author auto bin.yin 2016.12.12
 */
public interface MatchInfoService extends AbstractService<MatchInfo, String> {
	/**
	 * 重置赛事科目的最大报名人数、报名人数
	 * @param matchId
	 * @param objects
	 */
	MatchInfo setMatchSubjectSignCount(String matchId,Object...objects);
	
	/**
	 * 定时更改赛事状态
	 * @return
	 */
	void changeMatchStateSchedule() throws BusinessException;

	List<JSONObject> findMatchCities();

	int findCountAllMatch(Map<String, Object> countMap);

	List<Map> findSigninCount(Map<String, Object> countMap);
}
