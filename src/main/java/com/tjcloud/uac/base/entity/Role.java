package com.tjcloud.uac.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 角色表(uac_role)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class Role extends AbstractEntity {
	private static final long serialVersionUID = 1462848092270L;

	private String name; //名称
	private String description; //角色描述
	private String tenantId; //租户ID
	private String tenantName;//租户名称
	private Integer roleType; //如果是PLATFORM没有数据过滤,如果是TENANT_ADMIN对此租户下没有数据过滤
	
	private String code;      //编码(SUPER_ADMIN,PLATFORM_USER,TENANT_ADMIN,TENANT_USER)
	private Boolean fixed;    //是否自定义

	private List<String> orgIds; //organization
	private List<Organization> organizations;

	private List<String> operationIds;
	private List<String> menuIds;
	private List<Menu> menus; //menu

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return this.tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public List<String> getOrgIds() {
		return this.orgIds;
	}
	public void setOrgIds(List<String> orgIds) {
		this.orgIds = orgIds;
	}

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public List<String> getOperationIds() {
		return this.operationIds;
	}

	public void setOperationIds(List<String> operationIds) {
		this.operationIds = operationIds;
	}

	public List<String> getMenuIds() {
		return this.menuIds;
	}

	public void setMenuIds(List<String> menuIds) {
		this.menuIds = menuIds;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getFixed() {
		return fixed;
	}
	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
	}
}