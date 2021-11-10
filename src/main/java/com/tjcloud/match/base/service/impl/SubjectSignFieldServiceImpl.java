package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.SubjectSignFieldDao;
import com.tjcloud.match.base.entity.SubjectSignField;
import com.tjcloud.match.base.service.SubjectSignFieldService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("subjectSignFieldService")
public class SubjectSignFieldServiceImpl extends AbstractIbatisServiceImpl<SubjectSignFieldDao, SubjectSignField, String> implements SubjectSignFieldService {
	
	@Override
	public String getMaxSubjectSignFieldSortNo(Map<String,Object> param){
		return getDao().getMaxSubjectSignFieldSortNo(param);
	}
}
