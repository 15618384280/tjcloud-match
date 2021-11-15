package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆收藏(stadium_item_collect)
 * @author auto bin.yin 2017.08.16
 */
public class StadiumItemCollect extends AbstractEntity {
	private static final long serialVersionUID = 1502872941834L;

	private String userId; //用户id
	private String stadiumItemId; //项目id
	private String collectName;	//收藏信息
	private Integer collectType;	// 收藏类型 0-项目 1-场馆 2-赛事
	private String collectImage; //收藏图片

	public String getCollectImage() {
		return collectImage;
	}
	public void setCollectImage(String collectImage) {
		this.collectImage = collectImage;
	}
	public String getCollectName() {
		return collectName;
	}
	public void setCollectName(String collectName) {
		this.collectName = collectName;
	}
	public Integer getCollectType() {
		return collectType;
	}
	public void setCollectType(Integer collectType) {
		this.collectType = collectType;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
}