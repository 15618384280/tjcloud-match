package com.tjcloud.match.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.MatchReportDao;
import com.tjcloud.match.base.dao.SignRecordDao;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.service.SignRecordService;
import com.tjcloud.match.base.vo.MatchInfoReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("signRecordService")
public class SignRecordServiceImpl extends AbstractIbatisServiceImpl<SignRecordDao, SignRecord, String> implements SignRecordService {
    @Autowired
    private MatchReportDao matchReportDao;

    @Override
    public int recordSignCount(String subjectId) {
        return getDao().signCount(subjectId);
    }

    @Override
    public int recordSignCountAll(String subjectId) {
        return getDao().signCountAll(subjectId);
    }

    @Override
    public List<Map<String, Object>> exportSignRecord(Map<String, Object> params) {
        return getDao().exportSignRecord(params);
    }
    
    @Override
    public Pagination<Map<String, Object>> exportSignRecordPage(PageParam page, Map<String, Object> params) {
    	return getDao().exportSignRecordPage(page, params);
    }

    @Override
    public Pagination<MatchInfoReport> subjectReportPage(PageParam page, Map<String, Object> params) throws DAOException {
        if (page == null) page = new PageParam(1, 10);
        return matchReportDao.queryPage(page, params);
    }

    @Override
    public Map<String, Object> allSubjectReport(Map<String, Object> params) throws DAOException {
        return matchReportDao.allSubjectReport(params);
    }

    @Override
    public List<Map<String, Object>> subjectReport(Map<String, Object> params) throws DAOException {
        return matchReportDao.subjectReport(params);
    }
    
    @Override
    public List<JSONObject> getTeamMember(String teamId) {
        return getDao().getTeamMember(teamId);
    }

    @Override
    public List<JSONObject> signMatch(Map<String, Object> param) {
        return getDao().signMatch(param);
    }
}
