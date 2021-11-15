package com.tjcloud.match.base.vo;

import com.tjcloud.match.base.entity.SubjectTeam;

public class SubjectTeamVO extends  SubjectTeam{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6746014168552409800L;
	private String matchId; 									//赛事Id
	private String matchName; 									//赛事名称
	private Integer type; 										//赛制类型（0-个人,1-团体）
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	
}
