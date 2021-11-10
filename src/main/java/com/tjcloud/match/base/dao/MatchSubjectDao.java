package com.tjcloud.match.base.dao;

import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import com.tjcloud.match.base.entity.MatchSubject;

import java.util.Map;

/**
 * 赛事科目表(match_subject)
 * @author auto bin.yin 2016.12.12
 */
public interface MatchSubjectDao extends AbstractIBatisDao<MatchSubject, String> {
	/**
	 * 统计赛事科目的最大报名人数、报名人数
	 * @param param
	 * @return
	 */
	Map<String,Object> sumMatchSubjectSignCount(Map<String, Object> param);
}
