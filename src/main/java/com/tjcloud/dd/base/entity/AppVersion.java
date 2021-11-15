package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class AppVersion extends AbstractEntity{

	private static final long serialVersionUID = 7582341667414733260L;
	
	private Integer appId;         //1  安卓  2 IOs
	private String appName;          //名字
	private String appVersion;       //版本号
	private Integer appVersionCode;   //版本code
	private String url;       //链接
	private Boolean isUpdate;  //是否需要更新
	private String appSrc;   //来源
	private String description; //描述

	
	
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public Integer getAppVersionCode() {
		return appVersionCode;
	}
	public void setAppVersionCode(Integer appVersionCode) {
		this.appVersionCode = appVersionCode;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAppSrc() {
		return appSrc;
	}
	public void setAppSrc(String appSrc) {
		this.appSrc = appSrc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
