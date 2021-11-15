package com.tjcloud.uac.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.entity.TenantUser;

/**
 * 租户管理用户表(uac_tenant_user)
 * @author auto bin.yin 2016.05.10
 */
public interface TenantUserService extends AbstractService<TenantUser, String> {

	TenantUser findTenantUserByAuthId(String authId);

}
