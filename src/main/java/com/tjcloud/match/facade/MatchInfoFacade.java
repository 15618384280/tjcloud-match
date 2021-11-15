package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.Constants;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.redis.service.RedisCache;
import com.tjcloud.enums.TenantUserType;
import com.tjcloud.match.api.enums.MatchOpenState;
import com.tjcloud.match.api.enums.MatchState;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.service.MatchInfoApiService;
import com.tjcloud.match.api.utils.MatchTenantLocale;
import com.tjcloud.match.base.entity.MatchInfo;
import com.tjcloud.match.base.entity.MatchOutline;
import com.tjcloud.match.base.service.MatchInfoService;
import com.tjcloud.match.base.vo.MatchInfoVO;
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
import javax.ws.rs.QueryParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/matchs/info")
public class MatchInfoFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(MatchInfoFacade.class);

	@Autowired
	private MatchInfoApiService matchInfoApiService;
	@Autowired
	private MatchInfoService matchInfoService;
	@Autowired
	private TenantUserService tenantUserService;
	@Autowired
	private RedisCache redisCache;
	
	
	/**
	 * 保存赛事、保存并发布赛事
	 * @param matchInfo
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping
	public ResponseResult create(@RequestBody MatchInfoVO matchInfo, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchInfo));

		ValidateUtils.notNull(matchInfo, MessageLocale.NOT_NULL);
		String authId = getCurrentAuthId(request);
		TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
		if(ObjectUtils.isEmpty(tenantUser)){
			return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
		}else{
			matchInfo.setTenantId(tenantUser.getTenantId());
		}
		return matchInfoApiService.saveMatchInfo(matchInfo);
	}
	
    /**
     * 分页查询赛事信息
     * @param request
     * @return
     * @throws BusinessException
     */
	@AllowAnonymous
	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		PageParam page = getPageParam(request); 
		JSONObject param = getJSONObject(request); 
		String authId = getCurrentAuthId(request);
        if (!StringUtils.isEmpty(authId)) {
        	TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        	if(ObjectUtils.isEmpty(tenantUser)){
        		return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
        	}else{
        		//如果是租户的管理员则参数必须传入租户ID
        		if(TenantUserType.TENANT_USER.getText().equals(TenantUserType.getText(tenantUser.getUserType()))){
        			param.put("isTenantUset",true);
        			param.put("tenantId", tenantUser.getTenantId());
        		}
        	}
        }
		return matchInfoApiService.queryPage(page, param);
	}
	
	/**
     * 1yd后台分页查询赛事信息
     * @param request
     * @return
     * @throws BusinessException
     */
	@AllowAnonymous
	@GetMapping("/sign/1yd")
	public ResponseResult query1yd(HttpServletRequest request) throws BusinessException {
		PageParam page = getPageParam(request); 
		JSONObject param = getJSONObject(request); 
        param.put("stateList", new Integer[]{MatchState.MATCH_STATE_SIGN.getStatus(),
        								     MatchState.MATCH_STATE_BEING.getStatus(),
        								     MatchState.MATCH_STATE_CLOSE.getStatus(),
        								     MatchState.MATCH_STATE_END.getStatus()
        								     });
        param.put("openState", MatchOpenState.PLATFORM_SHOW.getStatus());
		return matchInfoApiService.queryPage(page, param);
	}
	
	/**
	* @author ZhangHui
	* @Description 查询赛事总数和报名人数
	* @Date 14:49 2020/9/23
	* @Param 
	* @return 
	**/
    @AllowAnonymous
    @PostMapping("/sign/matchcount")
    public ResponseResult matchCount(@RequestBody JSONObject json) throws BusinessException {
    	String areaRegion = json.getString("areaRegion");
        JSONObject res = new JSONObject();
		String timestamp = null;
		String nowstamp = null;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR)-1; // 累计2020年数据
		String time = year+"-01-01 00:00:00";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Long longTime = sdf.parse(time).getTime();
			Long longNow = sdf.parse(sdf.format(new Date())).getTime();
			timestamp = Long.toString(longTime);
			nowstamp = Long.toString(longNow);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Map<String, Object> countMap = new HashMap<>();
		countMap.put("areaRegion",areaRegion);
		countMap.put("thisYear",timestamp);
		countMap.put("nowTime",nowstamp);
		logger.info("---------------------------------area:{}",countMap);
		int matchCount = matchInfoService.findCountAllMatch(countMap);
        List<Map> signinCount = matchInfoService.findSigninCount(countMap);
        res.put("matchCount",matchCount);
        res.put("signinCountList",signinCount);
        return ResponseResult.ok().setData(res);
    }
	
	/**..
     * 1yd后台分页查询赛事信息
     * @param request
     * @return
     * @throws BusinessException
     */
	@AllowAnonymous
	@GetMapping("/sign/zjg")
	public ResponseResult queryzjg(HttpServletRequest request) throws BusinessException {
		PageParam page = getPageParam(request); 
		JSONObject param = getJSONObject(request); 
        param.put("stateList", new Integer[]{MatchState.MATCH_STATE_SIGN.getStatus(),
        								     MatchState.MATCH_STATE_BEING.getStatus(),
        								     MatchState.MATCH_STATE_CLOSE.getStatus(),
        								     MatchState.MATCH_STATE_END.getStatus()
        								     });
        param.put("openState", MatchOpenState.PLATFORM_SHOW.getStatus());
        param.put("tenantId", MatchTenantLocale.TENANT_ZJG_TIYUZHONGXIN);
		return matchInfoApiService.queryPage(page, param);
	}


	/**
     * 分页查询赛事信息
     * @param request
     * @return
     * @throws BusinessException
     */
	@GetMapping("/backstage")
	public ResponseResult queryBackstage(HttpServletRequest request,
										 @QueryParam("pageNo")Integer pageNo,
										 @QueryParam("pageSize")Integer pageSize) throws BusinessException {
		JSONObject param = getJSONObject(request);
		String authId = getCurrentAuthId(request);
        if (!StringUtils.isEmpty(authId)) {
        	TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        	if(ObjectUtils.isEmpty(tenantUser)){
        		return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
        	}else{
        		//如果是租户的管理员则参数必须传入租户ID
        		if(TenantUserType.TENANT_USER.getText().equals(TenantUserType.getText(tenantUser.getUserType()))){
        			param.put("isTenantUset",true);
        			param.put("tenantId", tenantUser.getTenantId());
        		}
        	}
        }
		if(pageNo == null){			// 查询所有
			HashMap<String, Object> result = Maps.newHashMap();
			result.put("dataList", matchInfoService.findBy(param));
			return ResponseResult.getResponse().setData(result);
		}else {			// 分页
			PageParam page = getPageParam(request);
			return matchInfoApiService.queryPage(page, param);
		}
	}

	/**
	 * 修改赛事修改并发布赛事
	 * @param matchInfo
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping
	public ResponseResult modify(@RequestBody MatchInfoVO matchInfo, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchInfo));

		ValidateUtils.notNull(matchInfo, MessageLocale.NOT_NULL);
		String authId = getCurrentAuthId(request);
		TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
		if(ObjectUtils.isEmpty(tenantUser)){
			return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
		}else{
			matchInfo.setTenantId(tenantUser.getTenantId());
		}
		
		return matchInfoApiService.saveMatchInfo(matchInfo);
	}

	/**
	 * 删除赛事
	 * @param id
	 * @throws BusinessException
	 */
	@DeleteMapping("/{id:\\w+}")
	public ResponseResult remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
		 return matchInfoApiService.removeMatchInfo(id);
	}
	
	/**
	 * 根据ID查询赛事信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);
		ValidateUtils.notNull(id, MatchMessageLocale.MATCH_IS_ERROR);
		return matchInfoApiService.getMatchInfoById(id);
	}

	@AllowAnonymous
	@GetMapping("/{id:\\w+}/fast")
	public ResponseResult getFast(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);
		ValidateUtils.notNull(id, MatchMessageLocale.MATCH_IS_ERROR);
		
		String match_cache_key= "match_cache" + id;
		MatchInfo matchInfo = null;
		try {
			String jsonStr = redisCache.get(match_cache_key);
			if (StringUtils.isNotEmpty(jsonStr)) {
				matchInfo = JSON.parseObject(jsonStr, MatchInfo.class);
				ValidateUtils.notNull(matchInfo, MessageLocale.EMPTY_CODE, "赛事缓存为空");
				ValidateUtils.notEmpty(matchInfo.getMatchName(), MessageLocale.EMPTY_CODE, "赛事缓存错误");
			}
		} catch (Exception e) {
			matchInfo = null;
			logger.error(e.getMessage(), e);
		}
		if (matchInfo == null) {
			matchInfo = matchInfoService.get(id);
			try {
				redisCache.set(match_cache_key, JSON.toJSONString(matchInfo), Constants.ONE_DAY_SECONDS);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return ResponseResult.ok().setData(matchInfo);
	}
	
	/**
	 * 返回赛事概要HTML
	 * @param matchId
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{matchId:\\w+}/html/outline")
	public ResponseResult searchMatchInfoHtml(@PathVariable("matchId") String matchId, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param matchId = ({})", matchId);
		ValidateUtils.notNull(matchId, MatchMessageLocale.MATCH_IS_ERROR);
		return matchInfoApiService.searchMatchInfoHtml(matchId);
	}
	
	/**
	 * 返回赛事富文本HTML
	 * @param matchId
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{matchId:\\w+}/html/outline/{type:\\d+}")
	public ResponseResult searchMatchInfoHtml(@PathVariable("matchId") String matchId,@PathVariable("type") Integer type, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param matchId = ({})", matchId);
		ValidateUtils.notNull(matchId, MatchMessageLocale.MATCH_IS_ERROR);
		return matchInfoApiService.searchMatchInfoHtml(matchId, type);
	}
	
	/**
	 * 保存赛事富文本
	 * @param matchOutline
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/html/outline")
	public ResponseResult saveMatchInfoHtml(@RequestBody MatchOutline matchOutlineVO, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchOutlineVO));
		ValidateUtils.notNull(matchOutlineVO, MessageLocale.NOT_NULL);
		ValidateUtils.notNull(matchOutlineVO.getMatchId(), MatchMessageLocale.MATCH_IS_ERROR);
		if(ObjectUtils.isEmpty(matchOutlineVO.getType())){
			return matchInfoApiService.saveMatchInfoHtml(matchOutlineVO.getMatchId(), matchOutlineVO.getOutlineHtml());// 保存赛事概要HTML
		}else{
			return matchInfoApiService.saveMatchInfoHtml(matchOutlineVO.getMatchId(), matchOutlineVO.getOutlineHtml(), matchOutlineVO.getType(), matchOutlineVO.getMapCoord(), matchOutlineVO.getMapLine());
		}
	}
	
	/**
	 * 返回赛事免责声明HTML
	 * @param matchId
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{matchId:\\w+}/html/disclaimer")
	public ResponseResult searchMatchInfoDisclaimerHtml(@PathVariable("matchId") String matchId, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param matchId = ({})", matchId);
		ValidateUtils.notNull(matchId, MatchMessageLocale.MATCH_IS_ERROR);
		return matchInfoApiService.searchMatchInfoDisclaimerHtml(matchId);
	}
	
	/**
	 * 保存赛事免责声明HTML
	 * @param matchOutline
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/html/disclaimer")
	public ResponseResult saveMatchInfoDisclaimerHtml(@RequestBody MatchOutline matchOutline, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchOutline));

		ValidateUtils.notNull(matchOutline, MessageLocale.NOT_NULL);
		ValidateUtils.notNull(matchOutline.getMatchId(), MatchMessageLocale.MATCH_IS_ERROR);
		return matchInfoApiService.saveMatchInfoDisclaimerHtml(matchOutline.getMatchId(),matchOutline.getDisclaimerHtml());
	}
	
	/**
	 * 返回赛事成绩HTML
	 * @param matchId
	 * @return
	 * @throws BusinessException
	 */
	@AllowAnonymous
	@GetMapping("/{matchId:\\w+}/html/grade")
	public ResponseResult searchMatchInfoGradeHtml(@PathVariable("matchId") String matchId, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param matchId = ({})", matchId);
		ValidateUtils.notNull(matchId, MatchMessageLocale.MATCH_IS_ERROR);
		return matchInfoApiService.searchMatchInfoGradeHtml(matchId);
	}
	
	/**
	 * 保存赛事成绩HTML
	 * @param matchOutline
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/html/grade")
	public ResponseResult saveMatchInfoGradeHtml(@RequestBody MatchOutline matchOutline, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchOutline));

		ValidateUtils.notNull(matchOutline, MessageLocale.NOT_NULL);
		ValidateUtils.notNull(matchOutline.getMatchId(), MatchMessageLocale.MATCH_IS_ERROR);
		return matchInfoApiService.saveMatchInfoGradeHtml(matchOutline.getMatchId(), matchOutline.getGradeHtml());
	}

	@AllowAnonymous
	@GetMapping("/city/open")
	public ResponseResult matchCitiesList(){
		return ResponseResult.ok().setData(matchInfoService.findMatchCities());
	}
}