package com.tjcloud.match.base.service.impl;

import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.SignFieldTableDao;
import com.tjcloud.match.base.entity.SignFieldTable;
import com.tjcloud.match.base.service.SignFieldTableService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("signFieldTableService")
public class SignFieldTableServiceImpl extends AbstractIbatisServiceImpl<SignFieldTableDao, SignFieldTable, String> implements SignFieldTableService {
	
	@Override
	public List<SignFieldTable> getSignFieldTableByTenantId(String tenantId) throws BusinessException{
		//默认添加科目自定义报名
		Map<String, Object> param = Maps.newHashMap();
		param.put("tenantId", tenantId);
		return findBy(param);
	}
	
}
