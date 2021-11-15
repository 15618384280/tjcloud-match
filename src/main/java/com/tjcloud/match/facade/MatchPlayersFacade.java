package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.service.MatchPlayersApiService;
import com.tjcloud.match.base.entity.MatchPlayers;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.service.TenantUserService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/matchs/players")
public class MatchPlayersFacade extends AbstractFacade {

    @Autowired
    private MatchPlayersApiService matchPlayersApiService;

    @Autowired
    private TenantUserService tenantUserService;

    /**
     * 分页查询参赛选手
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        PageParam page = getPageParam(request);
        JSONObject param = getJSONObject(request);
        if (StringUtils.isEmpty(param.get("matchId")) && StringUtils.isEmpty(param.get("subjectId"))) {
            if (StringUtils.isEmpty(param.get("matchId")))
                throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);
            if (StringUtils.isEmpty(param.get("subjectId")))
                throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
        }
        return ResponseResult.ok().setData(matchPlayersApiService.queryPage(page, param));
    }

    /**
     * 根据ID查询参赛选手
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @GetMapping("{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);

        ValidateUtils.notNull(id, MatchMessageLocale.PARAM_IS_ERROR);
        return ResponseResult.getResponse().setData(matchPlayersApiService.getMatchPlayerById(id));
    }

    /**
     * 新增参赛选手
     *
     * @param matchPlayers
     * @return
     * @throws BusinessException
     */
    @PostMapping
    public ResponseResult create(@RequestBody MatchPlayers matchPlayers, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchPlayers));
        ValidateUtils.notNull(matchPlayers, MessageLocale.NOT_NULL);
        ValidateUtils.isTrue(StringUtils.isEmpty(matchPlayers.getId()), MatchMessageLocale.PLAYERS_IS_ERROR);
        String authId = getCurrentAuthId(request);
        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        if (ObjectUtils.isEmpty(tenantUser)) {
            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
        } else {
            matchPlayers.setTenantId(tenantUser.getTenantId());
        }
        // TODO: 2017/3/10 个人、团体、userID
        return matchPlayersApiService.saveMatchPlayer(matchPlayers);
    }

    /**
     * 修改参赛选手
     *
     * @param matchPlayers
     * @return
     * @throws BusinessException
     */
    @PutMapping
    public ResponseResult modify(@RequestBody MatchPlayers matchPlayers, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ put param = {}", JSON.toJSONString(matchPlayers));
        ValidateUtils.notNull(matchPlayers, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(matchPlayers.getId(), MatchMessageLocale.PLAYERS_IS_ERROR);
        String authId = getCurrentAuthId(request);
        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        if (ObjectUtils.isEmpty(tenantUser)) {
            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
        } else {
            matchPlayers.setTenantId(tenantUser.getTenantId());
        }
        return matchPlayersApiService.saveMatchPlayer(matchPlayers);
    }

    /**
     * 删除参赛选手
     *
     * @param id
     * @throws BusinessException
     */
    @DeleteMapping("{id:\\w+}")
    public ResponseResult remove(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
        return matchPlayersApiService.removeMatchPlayer(id);
    }
}
