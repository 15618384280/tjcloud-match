package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.match.api.enums.MatchOpenState;
import com.tjcloud.match.api.enums.OutlineInvalld;
import com.tjcloud.match.api.enums.OutlineType;
import com.tjcloud.match.api.enums.SubjectType;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.base.entity.*;
import com.tjcloud.match.base.service.*;
import com.tjcloud.match.base.vo.MatchSubjectVO;
import com.tjcloud.match.base.vo.SignRecordVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("subjectApiService")
public class SubjectApiServiceImpl implements SubjectApiService {

	private static final Logger logger = LoggerFactory.getLogger(SubjectApiServiceImpl.class);

	@Autowired
	private MatchInfoService matchInfoService;
	@Autowired
	private MatchOutlineService matchOutlineService;
	@Autowired
	private MatchSubjectService matchSubjectService;
	@Autowired
	private SignFieldTableService signFieldTableService;
	@Autowired
	private SubjectSignFieldService subjectSignFieldService;
	@Autowired
	private SignRecordService signRecordService;
	@Autowired
	private SubjectTeamService subjectTeamService;
	@Autowired
	private SignRecordFieldTableService signRecordFieldTableService;

	/**
	 * 保存、修改赛事科目、保存、修改并发布赛事科目
	 * @param param
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@SuppressWarnings({ "unchecked"})
	@Override
	public ResponseResult saveSubject(MatchSubjectVO matchSubject) throws BusinessException{
		//赛事ID必传
		if(StringUtils.isEmpty(matchSubject.getMatchId())){
			throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//赛事ID错误
		}
		MatchInfo matchInfoEmpty = matchInfoService.get(matchSubject.getMatchId());
		if(ObjectUtils.isEmpty(matchInfoEmpty))
			throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//赛事ID错误

		matchSubject.setMatchName(matchInfoEmpty.getMatchName());
		matchSubject.setTenantId(matchInfoEmpty.getTenantId());
		MatchSubject matchSubjecEmpty;
		if(StringUtils.isEmpty(matchSubject.getId())){
			matchSubject.setMatchName(matchInfoEmpty.getMatchName());
			matchSubject.setTenantId(matchInfoEmpty.getTenantId());
			matchSubject.setUpStartTime(matchInfoEmpty.getUpStartTime());
			matchSubject.setUpEndTime(matchInfoEmpty.getUpEndTime());
			matchSubjectService.create(matchSubject);
			//默认添加科目报名字段
			insertSignFieldTable(matchSubject.getTenantId(), matchSubject.getId());
			//将赛事概要默认赋值给科目概要
			Map<String, Object> outLineMap = Maps.newHashMap();
			outLineMap.put("matchId", matchSubject.getMatchId());
			outLineMap.put("type", OutlineType.MATCH_SUMMARY.getStatus());
			outLineMap.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			MatchOutline matchOutline = matchOutlineService.findOne(outLineMap);
			if(!ObjectUtils.isEmpty(matchOutline)){
				matchOutline.setId(null);
				matchOutline.setSubjectId(matchSubject.getId());
				matchOutline.setType(OutlineType.MATCH_SUBJECT_SUMMARY.getStatus());
				matchOutline.setSubjectId(matchSubject.getId());
				matchOutlineService.create(matchOutline);
			}
			//将赛事声明默认赋值给科目声明
			Map<String, Object> disclaimerMap = Maps.newHashMap();
			disclaimerMap.put("matchId", matchSubject.getMatchId());
			disclaimerMap.put("type", OutlineType.MATCH_STATEMENT.getStatus());
			disclaimerMap.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			MatchOutline matchDisclaimer = matchOutlineService.findOne(disclaimerMap);
			if(!ObjectUtils.isEmpty(matchDisclaimer)){
				matchDisclaimer.setId(null);
				matchDisclaimer.setSubjectId(matchSubject.getId());
				matchDisclaimer.setType(OutlineType.MATCH_SUBJECT_STATEMENT.getStatus());
				matchDisclaimer.setSubjectId(matchSubject.getId());
				matchOutlineService.create(matchDisclaimer);
			}
		}else if (ObjectUtils.isEmpty(matchSubjecEmpty = matchSubjectService.get(matchSubject.getId()))) {
			throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
		}else {
            // 修改赛事、校验报名人数
            if (matchSubjecEmpty.getType()==SubjectType.TEAM.getType()){ // 如果是团体赛
                int teamSignCount = subjectTeamService.teamSignCount(matchSubject.getId());
                if (teamSignCount > matchSubject.getMaxNum().intValue()) throw new BusinessException(MatchMessageLocale.LESS_THAN_ENROLLMENT);
            }else {
            	int recordSignCount = signRecordService.recordSignCount(matchSubject.getId());
                if (recordSignCount > matchSubject.getMaxNum().intValue()) throw new BusinessException(MatchMessageLocale.LESS_THAN_ENROLLMENT);
            }
            String subjecStr = JSONObject.toJSONString(matchSubject);
			Map<String,Object> subjecMap = JSONObject.parseObject(subjecStr, HashMap.class);
			String subjecEmptyStr = JSONObject.toJSONString(matchSubjecEmpty);
			Map<String,Object> subjecEmptyMap = JSONObject.parseObject(subjecEmptyStr, HashMap.class);
			subjecEmptyMap.putAll(subjecMap);
			matchSubjecEmpty = JSONObject.parseObject(JSONObject.toJSONString(subjecEmptyMap), matchSubjecEmpty.getClass());
			matchSubjectService.modify(matchSubjecEmpty);
			BeanUtils.copyProperties(matchSubjecEmpty, matchSubject);
			
		}
		//统计赛事科目的最大报名人数、报名人数
		matchInfoService.setMatchSubjectSignCount(matchSubject.getMatchId(), matchInfoEmpty);
		return ResponseResult.getResponse().setData(matchSubject);
	}

	/**
	 * 根据ID查询赛事科目信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult getMatchSubjectById(String id) throws BusinessException{
		MatchSubject matchSubjecEmpty = matchSubjectService.get(id);
		return ResponseResult.getResponse().setData(matchSubjecEmpty);
	}

	/**
	 * 分页查询赛事科目信息
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult queryPage(PageParam page,JSONObject param) throws BusinessException {
		logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
		//租户ID必传
		if(StringUtils.isEmpty(param.get("tenantId"))){
			throw new BusinessException(MatchMessageLocale.TENANT_IS_NULL);//租户不能为空
		}
		return ResponseResult.getResponse().setData(matchSubjectService.queryPage(page, param));
	}

	/**
	 * 查询赛事所有科目
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult queryMatchSubject(Map<String, Object> param) throws BusinessException {
		logger.debug("~~~~~ put param = {}", param);
		//赛事ID必传
		if(StringUtils.isEmpty(param.get("matchId"))){
			throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR);//租户不能为空
		}
		return ResponseResult.getResponse().setData(matchSubjectService.findBy(param));
	}
	
	/**
	 * 查询赛事可报名所有科目
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult queryMatchInfo(Map<String, Object> param) throws BusinessException {
		logger.debug("~~~~~ put param = {}", param);
		
		//赛事ID必传
		if(StringUtils.isEmpty(param.get("matchId"))){
				throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//赛事ID错误
		}
		MatchInfo matchInfoEmpty = matchInfoService.get(param.get("matchId").toString());
		if(ObjectUtils.isEmpty(matchInfoEmpty))
				throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//赛事ID错误
		
		param.put("openState", MatchOpenState.PLATFORM_SHOW.getStatus());
//		param.put("state", MatchSubjectState.MATCH_STATE_SIGN.getStatus());
		List<MatchSubject> subjectList = matchSubjectService.findBy(param);
		Map<String, Object> resultMap = Maps.newHashMap();
		resultMap.put("matchInfo", matchInfoEmpty);
		resultMap.put("subjectList", subjectList);
		return ResponseResult.getResponse().setData(resultMap);
	}

	/**
	 * 分页下拉框查询租户赛事科目列表
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult queryMatchSubjectPage(PageParam page,JSONObject param) throws BusinessException {
		logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
		//赛事ID必传
		if(StringUtils.isEmpty(param.get("matchId"))){
			throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//租户不能为空
		}
		return ResponseResult.getResponse().setData(matchSubjectService.queryPage(page, param));
	}

	/**
	 * 下拉框查询租户所有赛事科目列表
	 * 赛事名称、赛事科目
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult querySubjectMatchAll(PageParam page,JSONObject param) throws BusinessException {
		logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
		//租户ID必传
		if(StringUtils.isEmpty(param.get("matchId"))){
			throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//租户不能为空
		}
		return ResponseResult.getResponse().setData(matchSubjectService.queryPage(page, param));
	}

	/**
	 * 返回赛事科目概要HTML
	 * @return
	 */
	@Override
	public ResponseResult searchMatchSubjectHtml(String matchId,String subjectId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("matchId", matchId);
		param.put("subjectId", subjectId);
		param.put("type", OutlineType.MATCH_SUBJECT_SUMMARY.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutLine = matchOutlineService.findOne(param);
		return ResponseResult.getResponse().setData(matchOutLine);
	}

	/**
	 * 保存赛事科目概要HTML
	 * @return
	 */
	@Override
	public ResponseResult saveMatchInfoHtml(String matchId, String subjectId, String outlineHtml){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("matchId", matchId);
		param.put("subjectId", subjectId);
		param.put("type", OutlineType.MATCH_SUBJECT_SUMMARY.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutline = matchOutlineService.findOne(param);
		if(ObjectUtils.isEmpty(matchOutline)){
			matchOutline = new MatchOutline();
			matchOutline.setMatchId(matchId);
			matchOutline.setSubjectId(subjectId);
			matchOutline.setOutlineHtml(outlineHtml);
			matchOutline.setType(OutlineType.MATCH_SUBJECT_SUMMARY.getStatus());
			matchOutline.setInvalid(OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			matchOutlineService.create(matchOutline);
		}else{
			matchOutline.setOutlineHtml(outlineHtml);
			matchOutlineService.modify(matchOutline);
		}
		return ResponseResult.getResponse().setData(matchOutline);
	}
	
	/**
	 * 返回赛事科目免责声明HTML
	 * @return
	 */
	@Override
	public ResponseResult searchMatchSubjectDisclaimerHtml(String matchId,String subjectId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("matchId", matchId);
		param.put("subjectId", subjectId);
		param.put("type", OutlineType.MATCH_SUBJECT_STATEMENT.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutLine = matchOutlineService.findOne(param);
		return ResponseResult.getResponse().setData(matchOutLine);
	}

	/**
	 * 保存赛事科目免责声明HTML
	 * @return
	 */
	@Override
	public ResponseResult saveMatchSubjectDisclaimerHtml(String matchId, String subjectId, String disclaimerHtml){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("matchId", matchId);
		param.put("subjectId", subjectId);
		param.put("type", OutlineType.MATCH_SUBJECT_STATEMENT.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutline = matchOutlineService.findOne(param);
		if(ObjectUtils.isEmpty(matchOutline)){
			matchOutline = new MatchOutline();
			matchOutline.setMatchId(matchId);
			matchOutline.setSubjectId(subjectId);
			matchOutline.setDisclaimerHtml(disclaimerHtml);
			matchOutline.setType(OutlineType.MATCH_SUBJECT_STATEMENT.getStatus());
			matchOutline.setInvalid(OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			matchOutlineService.create(matchOutline);
		}else{
			matchOutline.setDisclaimerHtml(disclaimerHtml);
			matchOutlineService.modify(matchOutline);
		}
		return ResponseResult.getResponse().setData(matchOutline);
	}

	@Override
	public List<SubjectSignField> insertSignFieldTable(String tenantId, String subjectId) throws BusinessException{
		//默认添加科目自定义报名
		List<SubjectSignField> listSign = Lists.newArrayList();

//		List<SignFieldTable> listData = signFieldTableService.getSignFieldTableByTenantId(tenantId);
		List<SignFieldTable> listData = signFieldTableService.findBy(null);
		for (SignFieldTable signFieldTable : listData) {
			SubjectSignField  subjectSignField = new SubjectSignField();
			BeanUtils.copyProperties(signFieldTable, subjectSignField);
			subjectSignField.setSubjectId(subjectId);
			subjectSignFieldService.create(subjectSignField);
			listSign.add(subjectSignField);
		}

		return ObjectUtils.isEmpty(listData) ? null : listSign;
	}

	@Override
	public ResponseResult subjectSingRecord(PageParam page, JSONObject param) throws BusinessException {
		Pagination<SignRecordVO<SignRecordFieldTable>> dataListVO = new Pagination<SignRecordVO<SignRecordFieldTable>>();
		List<SignRecordVO<SignRecordFieldTable>> listVO = Lists.newArrayList();
		Pagination<SignRecord> dataList = signRecordService.queryPage(page, param);
		for (SignRecord signRecord : dataList.getDataList()) {
			SignRecordVO<SignRecordFieldTable> signRecordVO = new SignRecordVO<SignRecordFieldTable>();
			BeanUtils.copyProperties(signRecord, signRecordVO);
			Map<String,Object> paramMap = Maps.newHashMap();
			paramMap.put("recordId", signRecord.getId());
			List<SignRecordFieldTable> signRecordInfo = signRecordFieldTableService.findBy(paramMap);
			signRecordVO.setSignRecordInfo(signRecordInfo);
			listVO.add(signRecordVO);
		}
		dataListVO.setDataList(listVO);
		return ResponseResult.getResponse().setData(dataListVO);
	}



}
