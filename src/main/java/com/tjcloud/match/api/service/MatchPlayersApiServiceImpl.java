package com.tjcloud.match.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.match.api.enums.MatchPlayersValid;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.base.entity.MatchPlayers;
import com.tjcloud.match.base.entity.MatchSubject;
import com.tjcloud.match.base.service.MatchPlayersService;
import com.tjcloud.match.base.service.MatchSubjectService;
import com.tjcloud.match.base.vo.MatchPlayersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ryan on 2017/3/10.
 */
@Service("matchPlayersApiService")
public class MatchPlayersApiServiceImpl implements MatchPlayersApiService {
    private static final Logger logger = LoggerFactory.getLogger(MatchPlayersApiServiceImpl.class);

    @Autowired
    private MatchPlayersService matchPlayersService;
    @Autowired
    private MatchSubjectService matchSubjectService;

    /**
     * 新增、修改参赛选手
     *
     * @param matchPlayers
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public ResponseResult saveMatchPlayer(MatchPlayers matchPlayers) throws BusinessException {
        //租户ID
        if (StringUtils.isEmpty(matchPlayers.getTenantId()))
            throw new BusinessException(MatchMessageLocale.TENANT_IS_NULL);//租户不能为空
        if (StringUtils.isEmpty(matchPlayers.getSubjectId()))
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);//科目不能为空

        if (StringUtils.isEmpty(matchPlayers.getMatchId())) { // 赛事ID
            MatchSubject matchSubject = matchSubjectService.get(matchPlayers.getSubjectId());
            if (ObjectUtils.isEmpty(matchSubject))
                throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);//科目ID错误
            matchPlayers.setMatchId(matchSubject.getMatchId());
        }

        //数据库不存在则新增
        if (StringUtils.isEmpty(matchPlayers.getId())) {
            matchPlayersService.create(matchPlayers);
        } else { // 修改
            MatchPlayers matchPlayersEmpty = matchPlayersService.get(matchPlayers.getId());
            if (ObjectUtils.isEmpty(matchPlayersEmpty))
                throw new BusinessException(MatchMessageLocale.PLAYERS_IS_ERROR);//选手ID错误
            String matchPlayersStr = JSONObject.toJSONString(matchPlayers);
            Map<String, Object> matchPlayersMap = JSONObject.parseObject(matchPlayersStr, HashMap.class);
            String matchPlayersEmptyStr = JSONObject.toJSONString(matchPlayersEmpty);
            Map<String, Object> matchPlayersEmptyMap = JSONObject.parseObject(matchPlayersEmptyStr, HashMap.class);
            matchPlayersEmptyMap.putAll(matchPlayersMap);
            matchPlayersEmpty = JSONObject.parseObject(JSONObject.toJSONString(matchPlayersEmptyMap), matchPlayersEmpty.getClass());
            matchPlayersService.modify(matchPlayersEmpty);
            matchPlayers = matchPlayersEmpty;
        }
        return ResponseResult.ok().setData(matchPlayers);
    }

    /**
     * 根据ID删除参赛选手
     *
     * @param playersId
     * @return
     * @throws BusinessException
     */
    @Override
    public ResponseResult removeMatchPlayer(String playersId) throws BusinessException {
        MatchPlayers matchPlayersEmpty = matchPlayersService.get(playersId);
        if (ObjectUtils.isEmpty(matchPlayersEmpty)) // 参赛选手ID错误
            throw new BusinessException(MatchMessageLocale.PLAYERS_IS_ERROR);
        matchPlayersEmpty.setDel(MatchPlayersValid.MATCH_PLAYERS_INVALID.getStatus());
        matchPlayersService.modify(matchPlayersEmpty);
        return ResponseResult.ok().setData(matchPlayersEmpty);
    }

    /**
     * 根据ID查询参赛选手信息
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
	@Override
    public MatchPlayers getMatchPlayerById(String id) throws BusinessException {
        MatchPlayers matchPlayers = matchPlayersService.get(id);
        if (ObjectUtils.isEmpty(matchPlayers)) // 参赛选手ID错误
            throw new BusinessException(MatchMessageLocale.PLAYERS_IS_ERROR);
        MatchSubject matchSubject = matchSubjectService.get(matchPlayers.getSubjectId());
        if (ObjectUtils.isEmpty(matchSubject))
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);//科目ID错误

        MatchPlayersVO matchPlayersVO = new MatchPlayersVO();
        String matchPlayersStr = JSONObject.toJSONString(matchPlayers);
        Map<String, Object> matchPlayersMap = JSONObject.parseObject(matchPlayersStr, HashMap.class);
        String matchPlayersVOStr = JSONObject.toJSONString(matchPlayersVO);
        Map<String, Object> matchPlayersVOMap = JSONObject.parseObject(matchPlayersVOStr, HashMap.class);
        matchPlayersVOMap.putAll(matchPlayersMap);
        matchPlayersVO = JSONObject.parseObject(JSONObject.toJSONString(matchPlayersVOMap), matchPlayersVO.getClass());

        matchPlayersVO.setSubjectName(matchSubject.getSubject());

        return matchPlayersVO;
    }

    /**
     * 分页查询参赛选手
     *
     * @param page
     * @param param
     * @return
     * @throws BusinessException
     */
    @Override
    public Pagination<MatchPlayers> queryPage(PageParam page, JSONObject param) throws BusinessException {
        logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
        return matchPlayersService.queryPage(page, param);
    }
}