package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 参赛人员记录表(match_players)
 * @author auto bin.yin 2016.12.12
 */
public class MatchPlayers extends AbstractEntity {
	private static final long serialVersionUID = 1481527808523L;

	private String tenantId; 									//租户Id
	private String matchId; 									//赛事Id
	private String subjectId; 									//科目ID
	private String subjectName;									//科目名称
	private String userId; 										//报名用户ID
	private String joinUserId; 									//参赛个体ID（个体为用户表userId）
	private String joinTeamId; 									//参赛团体ID（团体为团队表teamId）
	private String joinTeamName; 								//参赛团体名称
	private Integer type; 										//赛制类型（0-个人,1-团体）
	private String name; 										//姓名
	private Integer sex; 										//性别（0-女,1-男,2-'）
	private String phone; 										//手机号
	private String certificateNo; 								//证件号
	private String achievement; 								//成绩
	private Integer del; 										//状态(0-有效,1-删除)

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getMatchId() {
		return this.matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public String getSubjectId() {
		return this.subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJoinUserId() {
		return this.joinUserId;
	}
	public void setJoinUserId(String joinUserId) {
		this.joinUserId = joinUserId;
	}
	public String getJoinTeamId() {
		return this.joinTeamId;
	}
	public void setJoinTeamId(String joinTeamId) {
		this.joinTeamId = joinTeamId;
	}
	public String getJoinTeamName() {
		return this.joinTeamName;
	}
	public void setJoinTeamName(String joinTeamName) {
		this.joinTeamName = joinTeamName;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return this.sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCertificateNo() {
		return this.certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getAchievement() {
		return this.achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public Integer getDel() {
		return this.del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "MatchPlayers{" +
				"tenantId='" + tenantId + '\'' +
				", matchId='" + matchId + '\'' +
				", subjectId='" + subjectId + '\'' +
				", userId='" + userId + '\'' +
				", joinUserId='" + joinUserId + '\'' +
				", joinTeamId='" + joinTeamId + '\'' +
				", joinTeamName='" + joinTeamName + '\'' +
				", type=" + type +
				", name='" + name + '\'' +
				", sex=" + sex +
				", phone='" + phone + '\'' +
				", certificateNo='" + certificateNo + '\'' +
				", achievement='" + achievement + '\'' +
				", del=" + del +
				'}';
	}
}