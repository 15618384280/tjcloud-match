package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.match.base.entity.MatchInfo;
import com.tjcloud.match.base.entity.MatchRqCode;

import java.util.Map;

public interface MatchInfoApiService {

	/**
	 * 保存新增赛事信息
	 * @param param
	 * @return
	 */
	ResponseResult saveMatchInfo(MatchInfo matchInfo) throws BusinessException;

	/**
	 * 删除赛事
	 * @param param
	 * @return
	 */
	ResponseResult removeMatchInfo(String matchId) throws BusinessException;

	/**
	 * 根据ID查询赛事信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult getMatchInfoById(String id) throws BusinessException;

	/**
	 * 分页查询赛事信息
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult queryPage(PageParam page, JSONObject param) throws BusinessException;

	/**
	 * 分页下拉框查询租户赛事列表
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult queryTenantMatchPage(PageParam page, JSONObject param) throws BusinessException;

	/**
	 * 下拉框查询租户所有赛事列表 赛事名称、赛事科目
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	ResponseResult queryTenantMatchAll(PageParam page, JSONObject param) throws BusinessException;

	/**
	 * 返回赛事概要HTML
	 * @return
	 */
	ResponseResult searchMatchInfoHtml(String matchId);
	
	/**
	 * 返回赛事富文本HTML
	 * @return
	 */
	ResponseResult searchMatchInfoHtml(String matchId, Integer type);

	/**
	 * 保存赛事概要HTML
	 * @return
	 */
	ResponseResult saveMatchInfoHtml(String matchId, String outlineHtml);

	/**
	 * 返回赛事免责声明HTML
	 * @return
	 */
	ResponseResult searchMatchInfoDisclaimerHtml(String matchId);

	/**
	 * 保存赛事免责声明HTML
	 * @return
	 */
	ResponseResult saveMatchInfoDisclaimerHtml(String matchId, String outlineHtml);

	/**
	 * 保存、修改赛事二维码
	 * @return
	 */
	ResponseResult saveMatchRqCode(MatchRqCode matchRqCode) throws BusinessException;

	/**
	 * 返回赛事成绩HTML
	 * @return
	 */
	ResponseResult searchMatchInfoGradeHtml(String matchId);

	/**
	 * 保存赛事成绩HTML
	 * @return
	 */
	ResponseResult saveMatchInfoGradeHtml(String matchId, String gradeHtml);
	
	/**
	 * 保存赛事富文本
	 * @return
	 */
	ResponseResult saveMatchInfoHtml(String matchId, String outlineHtml, Integer type, String mapCoord, String mapLine);

	/**
	 * 查询赛事二维码
	 * @return
	 */
	ResponseResult queryMatchRqCode(Map<String, Object> param) throws BusinessException;
}
