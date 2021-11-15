package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

public class FieldShareDetailVO implements Serializable{

	private static final long serialVersionUID = -8402313350446562917L;

	private String id;
	private String shareId; //共享Id
	private String manyStadiumItemId; //对多的场馆ItemId
	private String manyFieldId; //对多的场地Id

	private String manyStadiumItemName; // 项目名
	private String manyFieldName;	 // 场地名

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	public String getManyStadiumItemId() {
		return manyStadiumItemId;
	}
	public void setManyStadiumItemId(String manyStadiumItemId) {
		this.manyStadiumItemId = manyStadiumItemId;
	}
	public String getManyFieldId() {
		return manyFieldId;
	}
	public void setManyFieldId(String manyFieldId) {
		this.manyFieldId = manyFieldId;
	}
	public String getManyStadiumItemName() {
		return manyStadiumItemName;
	}
	public void setManyStadiumItemName(String manyStadiumItemName) {
		this.manyStadiumItemName = manyStadiumItemName;
	}
	public String getManyFieldName() {
		return manyFieldName;
	}
	public void setManyFieldName(String manyFieldName) {
		this.manyFieldName = manyFieldName;
	}
}
