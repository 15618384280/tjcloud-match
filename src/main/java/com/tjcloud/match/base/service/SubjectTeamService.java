package com.tjcloud.match.base.service;

import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.SubjectTeam;
import com.tjcloud.match.base.vo.SubjectTeamVO;

import java.util.Map;


/**
 * 赛事报名团队表(subject_team)
 * @author auto bin.yin 2016.12.12
 */
public interface SubjectTeamService extends AbstractService<SubjectTeam, String> {
    /**
     * 已报名团队
     *
     * @param subjectId
     * @return
     */
    int teamSignCount(String subjectId);

    /**
     * 全部报名团队
     *
     * @param subjectId
     * @return
     */
    int teamSignCountAll(String subjectId);
    
    /*
     * 赛事退订分页
     * */
    Pagination<SubjectTeamVO> queryOrderList(PageParam page, Map<String, Object> params) throws DAOException;
    
    
}
