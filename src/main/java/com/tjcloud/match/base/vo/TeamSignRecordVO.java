package com.tjcloud.match.base.vo;

import com.tjcloud.match.base.entity.SignRecordFieldTable;

import java.util.List;

public class TeamSignRecordVO {
	private SignRecordVO<SignRecordFieldTable> headman;
	private List<SignRecordVO<SignRecordFieldTable>> teamMember;
	public SignRecordVO<SignRecordFieldTable> getHeadman() {
		return headman;
	}
	public void setHeadman(SignRecordVO<SignRecordFieldTable> headman) {
		this.headman = headman;
	}
	public List<SignRecordVO<SignRecordFieldTable>> getTeamMember() {
		return teamMember;
	}
	public void setTeamMember(List<SignRecordVO<SignRecordFieldTable>> teamMember) {
		this.teamMember = teamMember;
	}
	
	
}
