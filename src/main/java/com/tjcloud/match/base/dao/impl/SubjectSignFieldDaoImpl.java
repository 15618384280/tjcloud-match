package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.SubjectSignFieldDao;
import com.tjcloud.match.base.entity.SubjectSignField;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("subjectSignFieldDao")
public class SubjectSignFieldDaoImpl extends AbstractIBatisDaoImpl<SubjectSignField, String> implements SubjectSignFieldDao {
	
	@Override
	public String getMaxSubjectSignFieldSortNo(Map<String, Object> param) {
		return getSessionTemplate().selectOne(getStatement("getMaxSubjectSignFieldSortNo"),param);
	}
}
