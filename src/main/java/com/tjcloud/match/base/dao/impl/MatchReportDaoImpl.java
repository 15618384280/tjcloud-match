package com.tjcloud.match.base.dao.impl;

import com.tjcloud.core.exception.DAOException;
import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchReportDao;
import com.tjcloud.match.base.vo.MatchInfoReport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("matchReportDao")
public class MatchReportDaoImpl extends AbstractIBatisDaoImpl<MatchInfoReport, String> implements MatchReportDao {

    @Override
    public Map<String, Object> allSubjectReport(Map<String, Object> params) throws DAOException {
        return getSessionTemplate().selectOne(getStatement("allSubjectReport"), params);
    }

    @Override
    public List<Map<String, Object>> subjectReport(Map<String, Object> params) throws DAOException {
        return getSessionTemplate().selectList(getStatement("subjectReport"), params);
    }
}
