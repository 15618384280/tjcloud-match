package com.tjcloud.match.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.vo.MatchInfoReport;

import java.util.List;
import java.util.Map;

/**
 * 报名记录表(sign_record)
 *
 * @author auto bin.yin 2016.12.12
 */
public interface SignRecordService extends AbstractService<SignRecord, String> {
    /**
     * 已报名人数
     *
     * @param subjectId
     * @return
     */
    int recordSignCount(String subjectId);

    /**
     * 全部报名人数
     *
     * @param subjectId
     * @return
     */
    int recordSignCountAll(String subjectId);

    /**
     * 导出报名信息
     * @param params
     * @return
     */
    List<Map<String,Object>> exportSignRecord(Map<String,Object> params);
    
    /**
     * 分页报名信息
     * @param page
     * @param params
     * @return
     */
    Pagination<Map<String, Object>> exportSignRecordPage(PageParam page, Map<String, Object> params);

    /**
     * 分页查询赛事报表
     * @param page
     * @param params
     * @return
     * @throws DAOException
     */
    Pagination<MatchInfoReport> subjectReportPage(PageParam page, Map<String, Object> params) throws DAOException;

    /**
     * 查询报表所有
     * @param params
     * @return
     * @throws DAOException
     */
    Map<String, Object> allSubjectReport(Map<String, Object> params) throws DAOException;

    /**
     * 查询赛事报表
     * @param params
     * @return
     * @throws DAOException
     */
    List<Map<String, Object>> subjectReport(Map<String, Object> params) throws DAOException;
    
    /**
     * 根据团队ID获取团队成员信息
     * @param teamId
     * @return
     */
    List<JSONObject> getTeamMember(String teamId);

    List<JSONObject> signMatch(Map<String, Object> param);
}
