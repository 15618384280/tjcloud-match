package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.enums.MVType;
import com.tjcloud.match.base.entity.MatchInfo;
import com.tjcloud.match.base.entity.MatchStyle;
import com.tjcloud.match.base.service.MatchInfoService;
import com.tjcloud.match.base.service.MatchStyleService;
// import com.tjcloud.mmq.producer.MMQProducer;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matchs/style")
public class MatchStyleFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(MatchStyleFacade.class);

	@Autowired
	private MatchStyleService matchStyleService;
	@Autowired
	private TenantUserService tenantUserService;
	@Autowired
	private MatchInfoService matchInfoService;
	@Autowired
	// private MMQProducer mmqProducer;
	
	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<MatchStyle> dataList = getPagination(request, matchStyleService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		MatchStyle matchStyle = matchStyleService.get(id);
		return ResponseResult.getResponse().setData(matchStyle);
	}
	
	@AllowAnonymous
	@GetMapping("/matchno/{matchNo:\\w+}")
	public ResponseResult getMatchStyle(@PathVariable("matchNo") String matchNo,HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param matchNo = ({})", matchNo);
		JSONObject param = getJSONObject(request); 
		param.put("matchNo", matchNo);
		List<MatchStyle> dataList = matchStyleService.findBy(param);
		return ResponseResult.getResponse().setData(dataList);
	}
	
	@AllowAnonymous
	@PostMapping("/face")
	public ResponseResult faceMatchStyle(@RequestBody JSONObject face,HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ get param = ({})", face.toJSONString());
		PageParam page = this.getPageParam(face);
		Pagination<MatchStyle> dataList = matchStyleService.faceMatchStyle(page, face);
		return ResponseResult.getResponse().setData(dataList);
	}
	
	@AllowAnonymous
	@GetMapping("/wap")
	public ResponseResult getwap(HttpServletRequest request) throws BusinessException {
		Pagination<MatchStyle> dataList = getPagination(request, matchStyleService);
		JSONObject param = getJSONObject(request); 
		if(StringUtils.isNotEmpty(param.getString("matchId"))){
			MatchInfo  matchInfo = matchInfoService.get(param.getString("matchId"));
			if(matchInfo != null){
				matchInfo.setStylePv(matchInfo.getStylePv() + 1);
				matchInfoService.save(matchInfo);
				Map<String, Object> countResultMap = Maps.newHashMap();
				countResultMap.put("stylePv", matchInfo.getStylePv());
				dataList.setCountResultMap(countResultMap);
			}
		}
		return ResponseResult.getResponse().setData(dataList);
	}

	@PostMapping
	public ResponseResult create(@RequestBody MatchStyle matchStyle,HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchStyle));
		ValidateUtils.notNull(matchStyle, MessageLocale.NOT_NULL);
		String authId = getCurrentAuthId(request);
		TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
		if(ObjectUtils.isEmpty(tenantUser)){
			return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
		}else{
			matchStyle.setTenantId(tenantUser.getTenantId());
		}
		// 赛事风采ID为空，或者数据库不存在改赛事风采做新增
		if (StringUtils.isEmpty(matchStyle.getId())) {
			matchStyle = matchStyleService.create(matchStyle);
		} else {
			MatchStyle matchStyleEmpty = matchStyleService.get(matchStyle.getId());
			// 校验赛事风采ID
			if (!ObjectUtils.isEmpty(matchStyleEmpty)) {
				matchStyle.setId(matchStyleEmpty.getId());
			}
			matchStyle = matchStyleService.save(matchStyle);
		}
		//TODO 注册人脸信息
		if(matchStyle.getMvType()==null || MVType.VIDEO.getStatus() != matchStyle.getMvType()){
			JSONObject obj = new JSONObject();
			obj.put("image", matchStyle.getPhotoURL());
			obj.put("image_type", "URL");
			obj.put("group_id", matchStyle.getMatchId());
			obj.put("user_id", matchStyle.getId());
			// mmqProducer.sendMessage("face_set_user", JSONObject.toJSONString(obj));
		}
		return ResponseResult.getResponse().setData(matchStyle);
	}

	@DeleteMapping("/{id:\\w+}")
	public ResponseResult remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
		matchStyleService.remove(id);
		return ResponseResult.ok();
	}
}
