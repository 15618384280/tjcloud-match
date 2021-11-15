package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 *
 * 助手管理图片
 */
public class HelperImage extends AbstractEntity {


	private static final long serialVersionUID = 6108010127735304289L;
	private String objectId;		//对象id
	private Integer type;			//类型
	private String imageUrl;		//图片url
	private Integer sort;			//排序号


	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
