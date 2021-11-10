package com.tjcloud.match.base.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.SignRecordDao;
import com.tjcloud.match.base.entity.SignRecord;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Repository("signRecordDao")
public class SignRecordDaoImpl extends AbstractIBatisDaoImpl<SignRecord, String> implements SignRecordDao {

    @Override
    public int signCount(String subjectId) {
        return getSessionTemplate().selectOne(getStatement("signCount"), subjectId);
    }

    @Override
    public int signCountAll(String subjectId) {
        return getSessionTemplate().selectOne(getStatement("signCountAll"), subjectId);
    }

    @Override
    public List<Map<String, Object>> exportSignRecord(Map<String, Object> params) {
        return getSessionTemplate().selectList(getStatement("exportSignRecord"), params);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pagination<Map<String, Object>> exportSignRecordPage(PageParam page, Map<String, Object> params) {
		if (params == null) {
			params = Maps.newHashMapWithExpectedSize(8);
		}
		if (page != null && page.getPageSize() > 0) {
			if (page.getPageNo() < 0) {
				page.setPageNo(1);
			}
			
			((Map) params).put("pageFirst", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
			((Map) params).put("pageSize", Integer.valueOf(page.getPageSize()));
			((Map) params).put("startRowNum", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
			((Map) params).put("endRowNum", Integer.valueOf(page.getPageNo() * page.getPageSize()));
			Long count = (Long) this.getSessionTemplate().selectOne(this.getStatement("exportSignRecordPageCount"), params);
			int maxPage = (new BigDecimal(count.longValue()))
					.divide(new BigDecimal(page.getPageSize()), RoundingMode.CEILING).intValue();
			if (maxPage < page.getPageNo()) {
				page.setPageNo(maxPage);
			}
			List<Map<String, Object>> list = this.getSessionTemplate().selectList(this.getStatement("exportSignRecordPage"),params);
			return new Pagination(page.getPageNo(), page.getPageSize(), count.intValue(), list);
		} else {
			List<Map<String, Object>> list = this.getSessionTemplate().selectList(this.getStatement("exportSignRecordPage"),params);
			return new Pagination(list);
		}
	}
    
    @Override
    public List<JSONObject> getTeamMember(String teamId) {
        return getSessionTemplate().selectList(getStatement("getTeamMember"), teamId);
    }

	@Override
	public List<JSONObject> signMatch(Map<String, Object> param) {
		return getSessionTemplate().selectList(getStatement("signMatch"), param);
	}
}
