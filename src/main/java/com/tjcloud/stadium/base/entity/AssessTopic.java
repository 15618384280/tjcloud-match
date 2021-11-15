package com.tjcloud.stadium.base.entity;

import java.util.List;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (assess_topic)考核题目表
 * @author zhujian 2020.03.20
 */
public class AssessTopic extends AbstractEntity {
	private static final long serialVersionUID = -4863494809931336385L;
	
	private String title;		//标题
	private Integer mode;		//模式:0-场内考核,1-场外考核
	private Integer type;		//类型:0-单选题,1-多选题
	private Integer sort;		//排序号
	
	private List<AssessOption> options;	//考核题目选项列表
	
	private List<AssessImage> images;	//题目上传照片列表
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public List<AssessOption> getOptions() {
		return options;
	}
	public void setOptions(List<AssessOption> options) {
		this.options = options;
	}
	public List<AssessImage> getImages() {
		return images;
	}
	public void setImages(List<AssessImage> images) {
		this.images = images;
	}
	
	
}
