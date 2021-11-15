package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 科目二维码表(match_rq_code)
 * @author auto bin.yin 2016.12.12
 */
public class MatchRqCode extends AbstractEntity {
	private static final long serialVersionUID = 1481527808545L;

	private String tenantId; 									//租户Id
	private String matchId; 									//赛事Id
	private String subjectId; 									//科目ID
	private String purpose; 									//用途
	private String rqCodeValue; 								//二维码值
	private String rqPhotoUrl; 									//二维码图片
	private String parameter; 									//参数

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
	public String getPurpose() {
		return this.purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getRqCodeValue() {
		return this.rqCodeValue;
	}
	public void setRqCodeValue(String rqCodeValue) {
		this.rqCodeValue = rqCodeValue;
	}
	public String getRqPhotoUrl() {
		return this.rqPhotoUrl;
	}
	public void setRqPhotoUrl(String rqPhotoUrl) {
		this.rqPhotoUrl = rqPhotoUrl;
	}
	public String getParameter() {
		return this.parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}