package com.tjcloud.match.base.dao.impl;

import com.google.common.collect.Maps;
import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.SubjectTeamDao;
import com.tjcloud.match.base.entity.SubjectTeam;
import com.tjcloud.match.base.vo.SubjectTeamVO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;


@Repository("subjectTeamDao")
public class SubjectTeamDaoImpl extends AbstractIBatisDaoImpl<SubjectTeam, String> implements SubjectTeamDao {
    @Override
    public int signCount(String subjectId) {
        return getSessionTemplate().selectOne(getStatement("signCount"), subjectId);
    }

    @Override
    public int signCountAll(String subjectId) {
        return getSessionTemplate().selectOne(getStatement("signCountAll"), subjectId);
    }
    
    // 以下是分页
    @Override
	public List<SubjectTeamVO> queryTeamlist(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList(getStatement("teamlist"), params);
	}
	@Override
	public Pagination queryTeamlistPage(PageParam pageparam, Map<String,Object> params, String countSQL, String pageSQL) {
		return this.queryPage(pageparam, params, countSQL, pageSQL);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Pagination<SubjectTeamVO> queryTeamlistPage(PageParam page, Map<String,Object> params) throws DAOException{
        if(params == null)
            params = Maps.newHashMapWithExpectedSize(8);
        if(page != null && page.getPageSize() > 0)
        {
            if(page.getPageNo() < 0)
                page.setPageNo(1);
            params.put("pageFirst", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
            params.put("pageSize", Integer.valueOf(page.getPageSize()));
            params.put("startRowNum", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
            params.put("endRowNum", Integer.valueOf(page.getPageNo() * page.getPageSize()));
            Long count = (Long)getSessionTemplate().selectOne(getStatement("teamlistCount"), params);
            int maxPage = (new BigDecimal(count.longValue())).divide(new BigDecimal(page.getPageSize()), RoundingMode.CEILING).intValue();
            if(maxPage < page.getPageNo())
                page.setPageNo(maxPage);
            List list = getSessionTemplate().selectList(getStatement("getteamlistPage"), params);
            ValidateUtils.isFalse(list.size() > 10000, 0, "Found more than 10000 rows.");
            return new Pagination(page.getPageNo(), page.getPageSize(), count.intValue(), list);
        } 
        else 
        {
            return new Pagination(findBy(params));
        }
    }
    
//    teamlist
}
