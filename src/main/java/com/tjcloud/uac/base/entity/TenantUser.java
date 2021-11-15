package com.tjcloud.uac.base.entity;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 租户管理用户表(uac_tenant_user)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class TenantUser extends AbstractEntity {
	private static final long serialVersionUID = 1462848093543L;

	private String authId;     //认证ID
	private String mobile;
	private String realName;   //名称
	private String tenantId;   //租户ID
	private Integer userType;  //用户类型
	private String avatarIcon; //头像Icon
	private String password; //密码

	private String account;
	private List<String> roleIdList;
	private List<?> roleList;
	private List<String> stadiumIdList;
	private List<String> stadiumItemIdList;
	private List<?> stadiumList;
	private List<?> stadiumItemList;
	
	private List<JSONObject> chooseList;

	private String roleName; //角色名称

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<JSONObject> getChooseList() {
		return chooseList;
	}

	public void setChooseList(List<JSONObject> chooseList) {
		this.chooseList = chooseList;
	}

	public List<String> getStadiumItemIdList() {
		return this.stadiumItemIdList;
	}

	public void setStadiumItemIdList(List<String> stadiumItemIdList) {
		this.stadiumItemIdList = stadiumItemIdList;
	}

	public List<?> getStadiumList() {
		return this.stadiumList;
	}

	public void setStadiumList(List<?> stadiumList) {
		this.stadiumList = stadiumList;
	}

	public String getAuthId() {
		return this.authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRealName() {
		return this.realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Integer getUserType() {
		return this.userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getAvatarIcon() {
		return this.avatarIcon;
	}
	public void setAvatarIcon(String avatarIcon) {
		this.avatarIcon = avatarIcon;
	}
	public String getAccount() {
		return this.account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public List<String> getRoleIdList() {
		return roleIdList;
	}
	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}
	public List<?> getRoleList() {
		return this.roleList;
	}
	public void setRoleList(List<?> roleList) {
		this.roleList = roleList;
	}
	public List<String> getStadiumIdList() {
		return this.stadiumIdList;
	}
	public void setStadiumIdList(List<String> stadiumIdList) {
		this.stadiumIdList = stadiumIdList;
	}

	public List<?> getStadiumItemList() {
		return this.stadiumItemList;
	}
	public void setStadiumItemList(List<?> stadiumItemList) {
		this.stadiumItemList = stadiumItemList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}