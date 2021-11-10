package com.tjcloud.match.base.dao;

import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.match.base.vo.MatchInfoReport;

import java.util.List;
import java.util.Map;

/**
 * 赛事报名表(sign_record)
 */
public interface MatchReportDao {

    Pagination<MatchInfoReport> queryPage(PageParam page, Map<String, Object> params) throws DAOException;

    Map<String, Object> allSubjectReport(Map<String, Object> params) throws DAOException;

    List<Map<String, Object>> subjectReport(Map<String, Object> params) throws DAOException;
}
