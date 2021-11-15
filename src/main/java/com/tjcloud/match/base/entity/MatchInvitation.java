package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 赛事邀请码(match_invitation)
 * @author auto bin.yin 2019.01.22
 */
public class MatchInvitation extends AbstractEntity {
	private static final long serialVersionUID = 1548145901537L;

	private String matchId; //赛事ID
	private String subjectId; //科目ID
	private String userId; //用户ID
	private String invitationCode; //邀请码
	private Integer count; //邀请数量
	private Integer sortNo; //排序

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
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInvitationCode() {
		return this.invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getSortNo() {
		return this.sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
}