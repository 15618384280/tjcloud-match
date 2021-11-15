package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 赛事概要表(match_outline)
 * @author auto bin.yin 2016.12.12
 */
public class MatchOutline extends AbstractEntity {
	private static final long serialVersionUID = 1481527808498L;

	private String matchId; 									//赛事Id
	private String subjectId; 									//科目ID
	private Integer type; 										//类型（1-赛事概要,2-免责申明,7-赛事成绩）
	private String disclaimerHtml; 								//免责申明
	private String outlineHtml; 								//概要
	private String gradeHtml; 									//成绩
	private Integer invalid; 									//失效
	private String mapCoord; 									//地图坐标，json数组
	private String mapLine; 										//地图线路，json数组

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
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDisclaimerHtml() {
		return this.disclaimerHtml;
	}
	public void setDisclaimerHtml(String disclaimerHtml) {
		this.disclaimerHtml = disclaimerHtml;
	}
	public String getOutlineHtml() {
		return this.outlineHtml;
	}
	public void setOutlineHtml(String outlineHtml) {
		this.outlineHtml = outlineHtml;
	}
	
	public String getGradeHtml() {
		return gradeHtml;
	}
	public void setGradeHtml(String gradeHtml) {
		this.gradeHtml = gradeHtml;
	}
	public Integer getInvalid() {
		return this.invalid;
	}
	public void setInvalid(Integer invalid) {
		this.invalid = invalid;
	}
	public String getMapCoord() {
		return mapCoord;
	}
	public void setMapCoord(String mapCoord) {
		this.mapCoord = mapCoord;
	}
	public String getMapLine() {
		return mapLine;
	}
	public void setMapLine(String mapLine) {
		this.mapLine = mapLine;
	}
	
}