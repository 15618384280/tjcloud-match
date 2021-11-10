package com.tjcloud.match.base.dao;

import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import com.tjcloud.match.base.entity.MatchInfo;

import java.util.List;
import java.util.Map;

/**
 * 赛事主表(match_info)
 * @author auto bin.yin 2016.12.12
 */
public interface MatchInfoDao extends AbstractIBatisDao<MatchInfo, String> {

	List<String> findMatchCities();

	int findCountAllMatch(Map<String, Object> countMap);

	List<Map> findSigninCount(Map<String, Object> countMap);
}
