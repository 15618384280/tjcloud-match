package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchInfoDao;
import com.tjcloud.match.base.entity.MatchInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("matchInfoDao")
public class MatchInfoDaoImpl extends AbstractIBatisDaoImpl<MatchInfo, String> implements MatchInfoDao {

	@Override
	public List<String> findMatchCities() {
		return getSessionTemplate().selectList(getStatement("findMatchCities"));
	}

	@Override
	public int findCountAllMatch(Map countMap) {
		return getSessionTemplate().selectOne(getStatement("findCountAllMatch"),countMap);
	}


	@Override
	public List<Map> findSigninCount(Map countMap) {
		return getSessionTemplate().selectList(getStatement("findSigninCount"),countMap);
	}

}
