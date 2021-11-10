package com.tjcloud.match.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.SubjectSignField;

import java.util.Map;

/**
 * 定义科目报名字段表(subject_sign_field)
 * @author auto bin.yin 2017.03.04
 */
public interface SubjectSignFieldService extends AbstractService<SubjectSignField, String> {
	/**
	 * 获取科目自定义字段最大排序值
	 * @param param
	 * @return
	 */
	String getMaxSubjectSignFieldSortNo(Map<String, Object> param);
}
