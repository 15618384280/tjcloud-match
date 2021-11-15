package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (assess_answer)考核答案表
 * @author zhujian 2020.03.20
 */
public class AssessAnswer extends AbstractEntity {
	private static final long serialVersionUID = -5748783240670020786L;

	private String recordId;	//审核评分记录id
	private String topicId;		//题目id
	private String optionId;	//选项id
	
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
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	
	
}
