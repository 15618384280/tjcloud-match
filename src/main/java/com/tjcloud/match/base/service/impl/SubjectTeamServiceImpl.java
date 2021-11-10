package com.tjcloud.match.base.service.impl;

import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.SubjectTeamDao;
import com.tjcloud.match.base.entity.SubjectTeam;
import com.tjcloud.match.base.service.SubjectTeamService;
import com.tjcloud.match.base.vo.SubjectTeamVO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("subjectTeamService")
public class SubjectTeamServiceImpl extends AbstractIbatisServiceImpl<SubjectTeamDao, SubjectTeam, String> implements SubjectTeamService {

	@Override
	public int teamSignCount(String subjectId) {
		return getDao().signCount(subjectId);
	}

	@Override
	public int teamSignCountAll(String subjectId) {
		return getDao().signCountAll(subjectId);
	}
	
	// 分页
	@Override	
	public Pagination<SubjectTeamVO> queryOrderList(PageParam page, Map<String, Object> params) throws DAOException {
		// TODO Auto-generated method stub
		
		return getDao().queryTeamlistPage(page, params);
	}
}
