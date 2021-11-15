package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (assess_option)考核选项表
 * @author zhujian 2020.03.20
 */
public class AssessOption extends AbstractEntity {
	private static final long serialVersionUID = 6048610997878048257L;

	private String topicId;			//题目id
	private String option;			//选项内容
	private Integer score;			//分数
	private Integer sort;			//排序号
	private Boolean status;			//状态:0-未勾选，1-勾选
	
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
