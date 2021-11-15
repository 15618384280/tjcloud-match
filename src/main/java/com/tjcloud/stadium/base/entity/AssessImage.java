package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (assess_image)考核图片表
 * @author zhujian 2020.03.20
 */
public class AssessImage extends AbstractEntity {
	private static final long serialVersionUID = 5642199764904890739L;

	private String recordId;
	private String topicId;
	private String imageUrl;
	private Integer sort;
	
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
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
