package com.tjcloud.face.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 人脸范围信息表(face_from)
 * @author auto bin.yin 2018.12.05
 */
public class FaceFrom extends AbstractEntity {
	private static final long serialVersionUID = 1543987976607L;

	private String poolId; //人脸库配置ID
	private Integer type; //人脸库类型：0-租户，1-场馆，2-区域
	private String tenantId; //租户ID
	private String tenantName; //租户名称
	private String stadiumId; //场馆ID
	private String stadiumName; //场馆名称
	private String areaCode; //区域CODE
	private String areaName; //区域名称
	private String matchId; //赛事ID
	private String matchName; //赛事名称
	private String doorId; //闸机ID
	private String doorName; //闸机别名
	private Boolean doorExit; //进、出方向

	public String getPoolId() {
		return poolId;
	}
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getAreaCode() {
		return this.areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return this.areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public String getDoorId() {
		return doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}
	public String getDoorName() {
		return doorName;
	}
	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}
	public Boolean getDoorExit() {
		return doorExit;
	}
	public void setDoorExit(Boolean doorExit) {
		this.doorExit = doorExit;
	}
	
}