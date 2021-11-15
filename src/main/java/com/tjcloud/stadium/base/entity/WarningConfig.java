package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 告警邮箱设置(warning_config)
 * @author auto bin.yin 2018.08.21
 */
public class WarningConfig extends AbstractEntity {
	private static final long serialVersionUID = 1534831854545L;

	private Integer buzType; //告警类型
	private String tenantId; //租户id
	private String name; //组名
	private String phone; //手机号
	private Boolean phoneOpen; //手机号开启
	private String email; //邮箱
	private Boolean emailOpen; //邮箱开启

	public Integer getBuzType() {
		return this.buzType;
	}
	public void setBuzType(Integer buzType) {
		this.buzType = buzType;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getPhoneOpen() {
		return this.phoneOpen;
	}
	public void setPhoneOpen(Boolean phoneOpen) {
		this.phoneOpen = phoneOpen;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEmailOpen() {
		return this.emailOpen;
	}
	public void setEmailOpen(Boolean emailOpen) {
		this.emailOpen = emailOpen;
	}
}