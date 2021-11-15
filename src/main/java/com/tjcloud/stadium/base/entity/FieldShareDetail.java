package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.FieldShareDetailVO;

/**
 * 场地共享明细表(field_share_detail)
 * @author auto bin.yin 2016.07.19
 */
@LogRequired
public class FieldShareDetail extends AbstractEntity {
	private static final long serialVersionUID = 1468917986622L;

	private String shareId; //共享Id
	private String manyStadiumItemId; //对多的场馆ItemId
	private String manyFieldId; //对多的场地Id

	public String getShareId() {
		return this.shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getManyStadiumItemId() {
		return this.manyStadiumItemId;
	}
	public void setManyStadiumItemId(String manyStadiumItemId) {
		this.manyStadiumItemId = manyStadiumItemId;
	}

	public String getManyFieldId() {
		return this.manyFieldId;
	}
	public void setManyFieldId(String manyFieldId) {
		this.manyFieldId = manyFieldId;
	}
	public FieldShareDetail() {
		super();
	}
	public FieldShareDetail(FieldShareDetailVO detailVO) {
		setId(detailVO.getId());
		setManyStadiumItemId(detailVO.getManyStadiumItemId());
		setManyFieldId(detailVO.getManyFieldId());
	}
}