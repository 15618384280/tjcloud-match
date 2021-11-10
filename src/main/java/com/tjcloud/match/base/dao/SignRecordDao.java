package com.tjcloud.match.base.dao;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import com.tjcloud.match.base.entity.SignRecord;

import java.util.List;
import java.util.Map;

/**
 * 结算表(sign_record)
 * @author auto bin.yin 2016.12.12
 */
public interface SignRecordDao extends AbstractIBatisDao<SignRecord, String> {
	
    int signCount(String subjectId);
    
    int signCountAll(String subjectId);
    
    List<Map<String,Object>> exportSignRecord(Map<String,Object> params);
    
    Pagination<Map<String, Object>> exportSignRecordPage(PageParam page, Map<String, Object> params);
    
    List<JSONObject> getTeamMember(String teamId);

    List<JSONObject> signMatch(Map<String, Object> param);
}
