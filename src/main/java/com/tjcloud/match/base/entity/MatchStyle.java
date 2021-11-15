package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 赛事风采(match_style)
 * @author auto bin.yin 2016.12.12
 */
public class MatchStyle extends AbstractEntity {
	private static final long serialVersionUID = 1481527808564L;

	private String playersId; 									//参赛记录ID
	private Integer mvType; 									//0-图片，1-视频
	private String matchId; 									//赛事Id
	private String subjectId; 									//科目ID
	private String tenantId; 									//租户Id
	private String photoURL; 									//照片URL
	private String matchNo; 									//参赛号
	private Integer sortNo; 									//排序
	private String backgroundURL; 									//视频默认背景图
	
	public String getPlayersId() {
		return this.playersId;
	}
	public void setPlayersId(String playersId) {
		this.playersId = playersId;
	}
	
	public Integer getMvType() {
		return mvType;
	}
	public void setMvType(Integer mvType) {
		this.mvType = mvType;
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
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getPhotoURL() {
		return this.photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	
	public String getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(String matchNo) {
		this.matchNo = matchNo;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public String getBackgroundURL() {
		return backgroundURL;
	}
	public void setBackgroundURL(String backgroundURL) {
		this.backgroundURL = backgroundURL;
	}
	
}