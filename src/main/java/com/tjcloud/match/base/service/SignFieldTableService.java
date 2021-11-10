package com.tjcloud.match.base.service;

import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.SignFieldTable;

import java.util.List;

/**
 * 系统定义报名字段表 (sign_field_table)
 * @author auto bin.yin 2016.12.12
 */
public interface SignFieldTableService extends AbstractService<SignFieldTable, String> {


	/**
	 * 获取租户自定义报名字段
	 * @param tenantId
	 * @return
	 * @throws BusinessException
	 */
	List<SignFieldTable> getSignFieldTableByTenantId(String tenantId) throws BusinessException;
	
}
