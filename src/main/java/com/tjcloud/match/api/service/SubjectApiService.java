package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.match.base.entity.SubjectSignField;
import com.tjcloud.match.base.vo.MatchSubjectVO;

import java.util.List;
import java.util.Map;

public interface SubjectApiService {

	/**
	 * 保存赛事科目、保存并发布赛事科目
	 * @param param
	 * @return
	 */
	ResponseResult saveSubject(MatchSubjectVO matchSubject) throws BusinessException;
	
	/**
	 * 根据ID查询赛事科目信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult getMatchSubjectById(String id) throws BusinessException;
	
	/**
	 * 查询赛事所有科目
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	 ResponseResult queryMatchSubject(Map<String, Object> param) throws BusinessException;
	 
	 /**
	  * 查询赛事所有科目
	  * @param page
	  * @param param
	  * @return
	  * @throws BusinessException
	*/
	ResponseResult queryMatchInfo(Map<String, Object> param) throws BusinessException; 
	
	/**
	 * 分页查询赛事科目信息
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult queryPage(PageParam page,JSONObject param) throws BusinessException;
	
	/**
	 * 分页下拉框查询租户赛事列表
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult queryMatchSubjectPage(PageParam page,JSONObject param) throws BusinessException;
	
	/**
	 * 下拉框查询租户所有赛事科目列表
	 * 赛事名称、赛事科目
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult querySubjectMatchAll(PageParam page,JSONObject param) throws BusinessException;
	
	/**
	 * 返回赛事科目概要HTML
	 * @return
	 */
	ResponseResult searchMatchSubjectHtml(String matchId,String subjectId);
	
	/**
	 * 保存赛事科目概要HTML
	 * @return
	 */
	ResponseResult saveMatchInfoHtml(String matchId, String subjectId, String outlineHtml);
	
	/**
	 * 返回赛事科目免责声明HTML
	 * @return
	 */
	ResponseResult searchMatchSubjectDisclaimerHtml(String matchId,String subjectId);

	/**
	 * 保存赛事科目免责声明HTML
	 * @return
	 */
	ResponseResult saveMatchSubjectDisclaimerHtml(String matchId, String subjectId, String outlineHtml);
	
	
	/**
	 * 默认添加科目报名字段
	 * @param tenantId
	 * @param subjectId
	 * @return
	 * @throws BusinessException
	 */
	List<SubjectSignField> insertSignFieldTable(String tenantId, String subjectId) throws BusinessException;
	
	/**
	 * 分页查询赛事科目报名
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult subjectSingRecord(PageParam page,JSONObject param) throws BusinessException;
	
}
