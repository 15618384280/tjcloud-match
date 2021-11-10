package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.match.base.entity.MatchPlayers;

/**
 * Created by ryan on 2017/3/10.
 */
public interface MatchPlayersApiService {
    /**
     * 保存新增参赛人员
     *
     * @param matchPlayers
     * @return
     */
    ResponseResult saveMatchPlayer(MatchPlayers matchPlayers) throws BusinessException;

    /**
     * 删除参赛人员
     *
     * @param playersId
     * @return
     */
    ResponseResult removeMatchPlayer(String playersId) throws BusinessException;

    /**
     * 根据ID查询参赛人员
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    MatchPlayers getMatchPlayerById(String id) throws BusinessException;

    /**
     * 分页查询参赛人员
     *
     * @param page
     * @param param
     * @return
     * @throws BusinessException
     */
    Pagination<MatchPlayers> queryPage(PageParam page, JSONObject param) throws BusinessException;
}
