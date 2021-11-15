package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.service.SubjectApiService;
import com.tjcloud.match.base.entity.MatchOutline;
import com.tjcloud.match.base.vo.MatchSubjectVO;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.service.TenantUserService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/matchs/subject")
public class MatchSubjectFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(MatchSubjectFacade.class);

	@Autowired
	private SubjectApiService subjectApiService;
	@Autowired
	private TenantUserService tenantUserService;
	
	/**
	 * 保存、修改赛事科目、保存、修改并发布赛事科目
	 * @param matchSubject
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping
	public ResponseResult create(@RequestBody MatchSubjectVO matchSubject, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchSubject));

		ValidateUtils.notNull(matchSubject, MessageLocale.NOT_NULL);
		String authId = getCurrentAuthId(request);
		TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
		if(ObjectUtils.isEmpty(tenantUser)){
			return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
		}else{
			matchSubject.setTenantId(tenantUser.getTenantId());
		}
		return subjectApiService.saveSubject(matchSubject);
	}
	
	/**
	 * 根据ID查询赛事科目信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);
		return subjectApiService.getMatchSubjectById(id);
	}

	/**
	 * 分页查询赛事科目信息
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		PageParam page = getPageParam(request); 
		JSONObject param = getJSONObject(request); 
		return subjectApiService.queryPage(page, param);
	}
	
	/**
	 * 查询赛事所有科目
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/info/all")
	public ResponseResult queryAllInfoSubject(HttpServletRequest request) throws BusinessException {
		Map<String, Object> param = getParameterMap(request);
		return subjectApiService.queryMatchInfo(param);
	}
	
	/**
	 * 查询赛事所有科目
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/all")
	public ResponseResult queryAllSubject(HttpServletRequest request) throws BusinessException {
		Map<String, Object> param = getParameterMap(request);
		return subjectApiService.queryMatchSubject(param);
	}

	/**
	 * 保存、修改赛事科目、保存、修改并发布赛事科目
	 * @param matchSubject
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping
	public ResponseResult modify(@RequestBody MatchSubjectVO matchSubject) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(matchSubject));

		ValidateUtils.notNull(matchSubject, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(matchSubject.getId(), MessageLocale.NOT_EMPTY);
		return subjectApiService.saveSubject(matchSubject);
	}
	
	/**
	 * 分页下拉框查询租户赛事科目列表
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/page")
	public ResponseResult queryMatchSubjectPage(HttpServletRequest request) throws BusinessException {
		PageParam page = getPageParam(request); 
		JSONObject param = getJSONObject(request); 
		return subjectApiService.queryMatchSubjectPage(page, param);
	}

	@DeleteMapping("/{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
	
	/**
	 * 返回赛事科目概要HTML
	 * @param matchId
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{matchId:\\w+}/html/outline/{subjectId:\\w+}")
	public ResponseResult searchMatchInfoHtml(@PathVariable("matchId") String matchId, 
											  @PathVariable("subjectId") String subjectId,
											  HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param matchId = ({})", matchId);
		ValidateUtils.notNull(matchId, MatchMessageLocale.MATCH_IS_ERROR);
		return subjectApiService.searchMatchSubjectHtml(matchId, subjectId);
	}
	
	/**
	 * 保存赛事科目概要HTML
	 * @param matchInfo
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/html/outline")
	public ResponseResult saveMatchInfoHtml(@RequestBody MatchOutline matchOutline, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchOutline));

		ValidateUtils.notNull(matchOutline, MessageLocale.NOT_NULL);
		ValidateUtils.notNull(matchOutline.getMatchId(), MatchMessageLocale.MATCH_IS_ERROR);
		return subjectApiService.saveMatchInfoHtml(matchOutline.getMatchId(), matchOutline.getSubjectId(), matchOutline.getOutlineHtml());
	}
	
	/**
	 * 返回赛事科目免责申明HTML
	 * @param matchId
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{matchId:\\w+}/html/disclaimer/{subjectId:\\w+}")
	public ResponseResult searchMatchSubjectHtml(@PathVariable("matchId") String matchId, 
											  @PathVariable("subjectId") String subjectId,
											  HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param matchId = ({})", matchId);
		ValidateUtils.notNull(matchId, MatchMessageLocale.MATCH_IS_ERROR);
		ValidateUtils.notEmpty(subjectId, MatchMessageLocale.SUBJECT_IS_ERROR);
		return subjectApiService.searchMatchSubjectDisclaimerHtml(matchId, subjectId);
	}
	
	/**
	 * 保存赛事科目免责申明HTML
	 * @param matchInfo
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/html/disclaimer")
	public ResponseResult saveMatchSubjectHtml(@RequestBody MatchOutline matchOutline, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchOutline));

		ValidateUtils.notNull(matchOutline, MessageLocale.NOT_NULL);
		ValidateUtils.notNull(matchOutline.getMatchId(), MatchMessageLocale.MATCH_IS_ERROR);
		ValidateUtils.notEmpty(matchOutline.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
		return subjectApiService.saveMatchSubjectDisclaimerHtml(matchOutline.getMatchId(), matchOutline.getSubjectId(), matchOutline.getDisclaimerHtml());
	}
	
	/**
	 * 分页查询赛事科目报名信息
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/signrecord")
	public ResponseResult querySubjectSingRecord(HttpServletRequest request) throws BusinessException {
		PageParam page = getPageParam(request); 
		JSONObject param = getJSONObject(request); 
		return subjectApiService.subjectSingRecord(page, param);
	}
	
}
