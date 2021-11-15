package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.FieldShareVO;

/**
 * 场馆共享表(field_share)
 * @author auto bin.yin 2016.06.03
 */
@LogRequired
public class FieldShare extends AbstractEntity {
	private static final long serialVersionUID = 1464942279669L;

	private String stadiumId; //场馆Id
	private String oneFiledId; //场地Id
	private String oneStadiumItemId; //场馆ItemId
	private Boolean enable; //1-启用，0-切断关联

	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getOneFiledId() {
		return this.oneFiledId;
	}
	public void setOneFiledId(String oneFiledId) {
		this.oneFiledId = oneFiledId;
	}

	public String getOneStadiumItemId() {
		return this.oneStadiumItemId;
	}
	public void setOneStadiumItemId(String oneStadiumItemId) {
		this.oneStadiumItemId = oneStadiumItemId;
	}

	public Boolean getEnable() {
		return this.enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public FieldShare() {
		super();
	}
	public FieldShare(FieldShareVO fieldShareVO) {
		setId(fieldShareVO.getId());
		setStadiumId(fieldShareVO.getStadiumId());
		setOneFiledId(fieldShareVO.getOneFiledId());
		setOneStadiumItemId(fieldShareVO.getOneStadiumItemId());
		setEnable(fieldShareVO.getEnable());
	}
}