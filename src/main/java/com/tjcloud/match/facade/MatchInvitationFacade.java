package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.base.entity.MatchInvitation;
import com.tjcloud.match.base.service.MatchInvitationService;
import com.tjcloud.uac.base.entity.User;
import com.tjcloud.uac.base.service.UserService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/matchs/invitation")
public class MatchInvitationFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(MatchInvitationFacade.class);

	@Autowired
	private MatchInvitationService matchInvitationService;
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<MatchInvitation> dataList = getPagination(request, matchInvitationService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		MatchInvitation matchInvitation = matchInvitationService.get(id);
		return ResponseResult.getResponse().setData(matchInvitation);
	}

	@PostMapping("/{matchId:\\w+}")
	public ResponseResult create(@PathVariable("matchId") String matchId, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", matchId);
		ValidateUtils.notNull(matchId, MessageLocale.NOT_NULL);
		User user = userService.findByAuthId(getCurrentAuthId(request));
		String invitationCode = getInvitationCode();
		Map<String, Object> params = Maps.newHashMap();
//		params.put("invitationCode", invitationCode);
		params.put("userId", user.getId());
		params.put("matchId", matchId);
		MatchInvitation matchInvitation = matchInvitationService.findOne(params);
		if(matchInvitation == null){
			params.put("invitationCode", invitationCode);
			params.put("matchId", matchId);
			params.put("userId", null);
			matchInvitation = matchInvitationService.findOne(params);
			if(matchInvitation == null){
				matchInvitation = new MatchInvitation();
				matchInvitation.setMatchId(matchId);
				matchInvitation.setUserId(user.getId());
				matchInvitation.setInvitationCode(invitationCode);
				matchInvitation = matchInvitationService.create(matchInvitation);
			}else{
				create(matchId, request);
			}
		}
		return ResponseResult.getResponse().setData(matchInvitation);
	}

	@PutMapping
	public ResponseResult modify(@RequestBody MatchInvitation matchInvitation) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(matchInvitation));

		ValidateUtils.notNull(matchInvitation, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(matchInvitation.getId(), MessageLocale.NOT_EMPTY);
		int count = matchInvitationService.modify(matchInvitation);
		
		return ResponseResult.getResponse().setData(count);
	}

	@DeleteMapping("/{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
	
	private String getInvitationCode() { 
		Random r = new Random();
		int youNumber = r.nextInt(100000);
		return String.format("%06d", youNumber);      
	}     
	
}
