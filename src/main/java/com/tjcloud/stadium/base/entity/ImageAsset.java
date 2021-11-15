package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆图片集(image_asset)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class ImageAsset extends AbstractEntity {
	private static final long serialVersionUID = 1462853058019L;

	private String objectId; //场馆Id
	private String imageUrl; //图片url
	private Integer orderNo; //序号

	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
}