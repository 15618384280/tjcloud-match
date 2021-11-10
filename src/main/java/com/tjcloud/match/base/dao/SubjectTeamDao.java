package com.tjcloud.match.base.dao;

import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import com.tjcloud.match.base.entity.SubjectTeam;
import com.tjcloud.match.base.vo.SubjectTeamVO;

import java.util.List;
import java.util.Map;


/**
 * 赛事报名团队表(subject_team)
 * @author auto bin.yin 2016.12.12
 */
public interface SubjectTeamDao extends AbstractIBatisDao<SubjectTeam, String> {
    int signCount(String subjectId);
    int signCountAll(String subjectId);
    
    // 分页
    List<SubjectTeamVO> queryTeamlist(Map<String,Object> params);
    @SuppressWarnings("rawtypes")
	Pagination queryTeamlistPage(PageParam pageparam, Map<String,Object> params, String countSQL, String pageSQL);
    Pagination<SubjectTeamVO> queryTeamlistPage(PageParam page, Map<String, Object> params) throws DAOException;
}
