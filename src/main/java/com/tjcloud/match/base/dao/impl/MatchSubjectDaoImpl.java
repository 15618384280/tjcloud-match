package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchSubjectDao;
import com.tjcloud.match.base.entity.MatchSubject;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("matchSubjectDao")
public class MatchSubjectDaoImpl extends AbstractIBatisDaoImpl<MatchSubject, String> implements MatchSubjectDao {
	
	@Override
	public Map<String,Object> sumMatchSubjectSignCount(Map<String, Object> param) {
		return getSessionTemplate().selectOne(getStatement("sumMatchSubjectSignCount"),param);
	}
	
}
