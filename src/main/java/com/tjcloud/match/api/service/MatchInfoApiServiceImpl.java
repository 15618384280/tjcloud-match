package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.data.redis.service.RedisCache;
import com.tjcloud.face.base.entity.FaceGroup;
import com.tjcloud.face.base.service.FaceGroupService;
import com.tjcloud.match.api.enums.MatchState;
import com.tjcloud.match.api.enums.MatchSubjectState;
import com.tjcloud.match.api.enums.OutlineInvalld;
import com.tjcloud.match.api.enums.OutlineType;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.base.entity.MatchInfo;
import com.tjcloud.match.base.entity.MatchOutline;
import com.tjcloud.match.base.entity.MatchRqCode;
import com.tjcloud.match.base.entity.MatchSubject;
import com.tjcloud.match.base.service.MatchInfoService;
import com.tjcloud.match.base.service.MatchOutlineService;
import com.tjcloud.match.base.service.MatchRqCodeService;
import com.tjcloud.match.base.service.MatchSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("matchInfoApiService")
public class MatchInfoApiServiceImpl implements MatchInfoApiService {
	
	private static final Logger logger = LoggerFactory.getLogger(MatchInfoApiServiceImpl.class);

	@Autowired
	private MatchInfoService matchInfoService;
	@Autowired
	private MatchOutlineService matchOutlineService;
	@Autowired
	private MatchRqCodeService matchRqCodeService;
	@Autowired
	private MatchSubjectService matchSubjectService;
	@Autowired
	private RedisCache redisCache;
	@Autowired
	private FaceGroupService faceGroupService;
	
	/**
	 * ????????????????????????????????????
	 * @param matchInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResponseResult saveMatchInfo(MatchInfo matchInfo) throws BusinessException{
		//??????ID??????
		if(StringUtils.isEmpty(matchInfo.getTenantId())){
			throw new BusinessException(MatchMessageLocale.TENANT_IS_NULL);//??????????????????
		}
		//??????ID???????????????????????????????????????
		String matchId = matchInfo.getId();
		//??????ID???????????????????????????????????????????????????
		if(StringUtils.isEmpty(matchId)){
			matchInfoService.create(matchInfo);
		}else{
			MatchInfo matchInfoEmpty = matchInfoService.get(matchInfo.getId());
			//????????????ID
			if(ObjectUtils.isEmpty(matchInfoEmpty)){
				throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//??????ID??????
			}else{
				String matchInfoStr = JSONObject.toJSONString(matchInfo);
				Map<String,Object> matchInfoMap = JSONObject.parseObject(matchInfoStr, HashMap.class);
				String matchInfoEmptyStr = JSONObject.toJSONString(matchInfoEmpty);
				Map<String,Object> matchInfoEmptyMap = JSONObject.parseObject(matchInfoEmptyStr, HashMap.class);
				matchInfoEmptyMap.putAll(matchInfoMap);
				matchInfoEmpty = JSONObject.parseObject(JSONObject.toJSONString(matchInfoEmptyMap), matchInfoEmpty.getClass());
				matchInfoEmpty.setTenantId(null);
				matchInfoService.modify(matchInfoEmpty);
				matchInfo = matchInfoEmpty;
				//?????????????????????????????????
				Map<String,Object> param = Maps.newHashMap(); 
		        param.put("matchId", matchInfo.getId());
				List<MatchSubject> matchSubjectList= matchSubjectService.findBy(param);
				for (MatchSubject matchSubject : matchSubjectList) {
					/**
					 *	@see SubjectApiServiceImpl#saveSubject(com.tjcloud.match.base.vo.MatchSubjectVO)}
					 */
//					matchSubject.setState(matchInfo.getState());
//					matchSubject.setType(matchInfo.getType());
//					matchSubject.setOpenState(matchInfo.getOpenState());
//					matchSubject.setPayMode(matchInfoEmpty.getPayMode());
					matchSubject.setMatchName(matchInfoEmpty.getMatchName());
//					matchSubject.setGameTime(matchInfoEmpty.getStartTime());// ??????????????????
//					matchSubject.setGameEndTime(matchInfoEmpty.getEndTime());// ??????????????????
					matchSubject.setUpStartTime(matchInfoEmpty.getUpStartTime());
					matchSubject.setUpEndTime(matchInfoEmpty.getUpEndTime());
					matchSubject.setTenantId(matchInfoEmpty.getTenantId());
					matchSubjectService.modify(matchSubject);
				}
			}
		}
		
		//???????????????????????? 
		FaceGroup faceGroup = faceGroupService.getFaceGroupByBaiduGroupId(matchInfo.getId());
		if(faceGroup == null){
			faceGroup = new FaceGroup();
			faceGroup.setPoolId("32744e78b93211e78ebc0242ac110045");
			faceGroup.setBaiduGroupId(matchInfo.getId());
			faceGroup.setGroupName(matchInfo.getMatchName());
			faceGroupService.createFaceGroup(faceGroup);
		}
		try {
			redisCache.del("match_cache" + matchInfo.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return ResponseResult.ok().setData(matchInfo);
	}
	
	/**
	 * ????????????
	 * @param matchId
	 * @return
	 */
	@Override
	public ResponseResult removeMatchInfo(String matchId) throws BusinessException{
		//????????????ID
		MatchInfo matchInfoEmpty = matchInfoService.get(matchId);
		if(ObjectUtils.isEmpty(matchInfoEmpty)){
			throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);//??????ID??????
		}else{
			matchInfoEmpty.setState(MatchState.MATCH_STATE_REMOVE.getStatus());
			//?????????????????????????????????
			Map<String,Object> param = Maps.newHashMap();
			param.put("matchId", matchInfoEmpty.getId());
			List<MatchSubject> matchSubjectList= matchSubjectService.findBy(param);
			for (MatchSubject matchSubject : matchSubjectList) {
				/**
				 *	@see SubjectApiServiceImpl#saveSubject(com.tjcloud.match.base.vo.MatchSubjectVO)}
				 */
				matchSubject.setState(MatchSubjectState.MATCH_STATE_REMOVE.getStatus());
				matchSubjectService.modify(matchSubject);
			}
			matchInfoService.modify(matchInfoEmpty);
		}
		return ResponseResult.ok().setData(matchInfoEmpty);
	}
	
	/**
	 * ??????ID??????????????????
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult getMatchInfoById(String id) throws BusinessException{
		MatchInfo matchInfo = matchInfoService.get(id);
		return ResponseResult.ok().setData(matchInfo);
	}
	
	/**
	 * ????????????????????????
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult queryPage(PageParam page,JSONObject param) throws BusinessException {
		logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
		return ResponseResult.getResponse().setData(matchInfoService.queryPage(page, param));
	}
	
	/**
	 * ???????????????????????????????????????
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult queryTenantMatchPage(PageParam page,JSONObject param) throws BusinessException {
		logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
		//??????ID??????
		if(StringUtils.isEmpty(param.get("tenantId"))){
			throw new BusinessException(MatchMessageLocale.TENANT_IS_NULL);//??????????????????
		}
		return ResponseResult.getResponse().setData(matchInfoService.queryPage(page, param));
	}
	
	/**
	 * ???????????????????????????????????????
	 * ???????????????????????????
	 * @param page
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ResponseResult queryTenantMatchAll(PageParam page,JSONObject param) throws BusinessException {
		logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
		//??????ID??????
		if(StringUtils.isEmpty(param.get("tenantId"))){
			throw new BusinessException(MatchMessageLocale.TENANT_IS_NULL);//??????????????????
		}
		return ResponseResult.getResponse().setData(matchInfoService.queryPage(page, param));
	}
	
	/**
	 * ??????????????????HTML
	 * @return
	 */
	@Override
	public ResponseResult searchMatchInfoHtml(String matchId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("matchId", matchId);
		param.put("type", OutlineType.MATCH_SUMMARY.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutLine = matchOutlineService.findOne(param);
		return ResponseResult.getResponse().setData(matchOutLine);
	}
	
	/**
	 * ?????????????????????HTML
	 * @return
	 */
	@Override
	public ResponseResult searchMatchInfoHtml(String matchId, Integer type){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("matchId", matchId);
		param.put("type", type);
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutLine = matchOutlineService.findOne(param);
		return ResponseResult.getResponse().setData(matchOutLine);
	}
	
	/**
	 * ??????????????????HTML
	 * @return
	 */
	@Override
	public ResponseResult saveMatchInfoHtml(String matchId, String outlineHtml){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("matchId", matchId);
		param.put("type", OutlineType.MATCH_SUMMARY.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutline = matchOutlineService.findOne(param);
		if(ObjectUtils.isEmpty(matchOutline)){
			matchOutline = new MatchOutline();
			matchOutline.setMatchId(matchId);
			matchOutline.setOutlineHtml(outlineHtml);
			matchOutline.setType(OutlineType.MATCH_SUMMARY.getStatus());
			matchOutline.setInvalid(OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			matchOutlineService.create(matchOutline);
		}else{
			matchOutline.setOutlineHtml(outlineHtml);
			matchOutlineService.modify(matchOutline);
		}
		return ResponseResult.getResponse().setData(matchOutline);
	} 
	
	/**
	 * ?????????????????????
	 * @return
	 */
	@Override
	public ResponseResult saveMatchInfoHtml(String matchId, String outlineHtml, Integer type, String mapCoord, String mapLine){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("matchId", matchId);
		param.put("type", type);
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutline = matchOutlineService.findOne(param);
		if(ObjectUtils.isEmpty(matchOutline)){
			matchOutline = new MatchOutline();
			matchOutline.setMatchId(matchId);
			matchOutline.setOutlineHtml(outlineHtml);
			matchOutline.setType(type);
			matchOutline.setInvalid(OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			matchOutline.setMapCoord(mapCoord);
			matchOutline.setMapLine(mapLine);
			matchOutlineService.create(matchOutline);
		}else{
			matchOutline.setMapLine(mapLine);
			matchOutline.setMapCoord(mapCoord);
			matchOutline.setOutlineHtml(outlineHtml);
			matchOutlineService.modify(matchOutline);
		}
		return ResponseResult.getResponse().setData(matchOutline);
	} 
	
	/**
	 * ????????????????????????HTML
	 * @return
	 */
	@Override
	public ResponseResult searchMatchInfoDisclaimerHtml(String matchId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("matchId", matchId);
		param.put("type", OutlineType.MATCH_STATEMENT.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutLine = matchOutlineService.findOne(param);
		return ResponseResult.getResponse().setData(matchOutLine);
	}
	
	/**
	 * ????????????????????????HTML
	 * @return
	 */
	@Override
	public ResponseResult saveMatchInfoDisclaimerHtml(String matchId, String disclaimerHtml){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("matchId", matchId);
		param.put("type", OutlineType.MATCH_STATEMENT.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutline = matchOutlineService.findOne(param);
		if(ObjectUtils.isEmpty(matchOutline)){
			matchOutline = new MatchOutline();
			matchOutline.setMatchId(matchId);
			matchOutline.setDisclaimerHtml(disclaimerHtml);
			matchOutline.setType(OutlineType.MATCH_STATEMENT.getStatus());
			matchOutline.setInvalid(OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			matchOutlineService.create(matchOutline);
		}else{
			matchOutline.setDisclaimerHtml(disclaimerHtml);
			matchOutlineService.modify(matchOutline);
		}
		return ResponseResult.getResponse().setData(matchOutline);
	} 
	
	/**
	 * ??????????????????HTML
	 * @return
	 */
	@Override
	public ResponseResult searchMatchInfoGradeHtml(String matchId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("matchId", matchId);
		param.put("type", OutlineType.MATCH_GRADE.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutLine = matchOutlineService.findOne(param);
		return ResponseResult.getResponse().setData(matchOutLine);
	}
	
	/**
	 * ??????????????????HTML
	 * @return
	 */
	@Transactional
	@Override
	public ResponseResult saveMatchInfoGradeHtml(String matchId, String gradeHtml){
		MatchInfo matchInfoEmpty = new MatchInfo();
		matchInfoEmpty.setId(matchId);
		matchInfoEmpty.setGradeType(1);
		matchInfoService.modify(matchInfoEmpty);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("matchId", matchId);
		param.put("type", OutlineType.MATCH_GRADE.getStatus());
		param.put("invalid", OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
		MatchOutline matchOutline = matchOutlineService.findOne(param);
		if(ObjectUtils.isEmpty(matchOutline)){
			matchOutline = new MatchOutline();
			matchOutline.setMatchId(matchId);
			matchOutline.setGradeHtml(gradeHtml);
			matchOutline.setType(OutlineType.MATCH_GRADE.getStatus());
			matchOutline.setInvalid(OutlineInvalld.OUTLINE_NOT_INVALLD.getStatus());
			matchOutlineService.create(matchOutline);
		}else{
			matchOutline.setGradeHtml(gradeHtml);
			matchOutlineService.modify(matchOutline);
		}
		return ResponseResult.getResponse().setData(matchOutline);
	} 
	
	/**
	 * ??????????????????????????????
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResponseResult saveMatchRqCode(MatchRqCode matchRqCode) throws BusinessException {
		if(StringUtils.isEmpty(matchRqCode.getId())){
			matchRqCodeService.create(matchRqCode);
		}else{
			MatchRqCode matchRqCodeEntity = matchRqCodeService.get(matchRqCode.getId());
			if(ObjectUtils.isEmpty(matchRqCodeEntity)){
				matchRqCodeService.create(matchRqCode);
			}else{
				String rqCodeStr = JSONObject.toJSONString(matchRqCode);
				Map<String,Object> rqCodeMap = JSONObject.parseObject(rqCodeStr, HashMap.class);
				String rqCodeEmptyStr = JSONObject.toJSONString(matchRqCode);
				Map<String,Object> rqCodeEmptyMap = JSONObject.parseObject(rqCodeEmptyStr, HashMap.class);
				rqCodeEmptyMap.putAll(rqCodeMap);
				matchRqCodeEntity = JSONObject.parseObject(JSONObject.toJSONString(rqCodeEmptyMap), matchRqCodeEntity.getClass());
				matchRqCodeService.modify(matchRqCodeEntity);
				matchRqCode = matchRqCodeEntity;
			}
		}
		return ResponseResult.getResponse().setData(matchRqCode);
	} 
	
	/**
	 * ?????????????????????
	 * @return
	 */
	@Override
	public ResponseResult queryMatchRqCode(Map<String, Object> param) throws BusinessException {
		return ResponseResult.getResponse().setData(matchRqCodeService.findOne(param));
	}
}
