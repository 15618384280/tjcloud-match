package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.enums.MarkState;
import com.tjcloud.match.base.entity.MarkRecord;
import com.tjcloud.match.base.entity.MatchLandmark;
import com.tjcloud.match.base.service.MarkRecordService;
import com.tjcloud.match.base.service.MatchLandmarkService;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.User;
import com.tjcloud.uac.base.service.UserService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 地标主表(MatchLandmark)表控制层
 *
 * @author lucheng 2020-10-19 11:21:52
 */
@RestController
@RequestMapping("/matchLandmark")
public class MatchLandmarkFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(MatchLandmarkFacade.class);
    /**
     * 服务对象
     */
    @Autowired
    private MatchLandmarkService matchLandmarkService;
    @Autowired
    private UserService userService;
    @Autowired
    private MarkRecordService markRecordService;

    /**
     * 分页查询列表
     *
     * @param request
     */
    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Pagination<MatchLandmark> dataList = getPagination(request, matchLandmarkService);
        return ResponseResult.getResponse().setData(dataList);
    }

    /**
     * 用户地标
     *
     * @param request
     */
    @PostMapping("/user")
    public ResponseResult userLandmark(HttpServletRequest request) throws BusinessException {
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);
        Map<String,Object> params = Maps.newHashMap();
        params.put("tenantId","123");
        List<MatchLandmark> dataList = matchLandmarkService.findBy(params);
        for (MatchLandmark matchLandmark : dataList) {
            MarkRecord markRecord = markRecordService.getMarkIdMarkRecord(user.getId(), matchLandmark.getId());
            matchLandmark.setState(ObjectUtils.isEmpty(markRecord) ? MarkState.MARK_STATE_NO.getStatus() : MarkState.MARK_STATE_YES.getStatus());
        }
        return ResponseResult.ok().setData(dataList);
    }

    /**
     * 搜索列表
     *
     * @param json
     */
    @PostMapping("/search")
    public ResponseResult query(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        List<MatchLandmark> dataList = matchLandmarkService.findBy(json);
        return ResponseResult.ok().setData(dataList);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     */
    @GetMapping("{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);

        MatchLandmark matchLandmark = matchLandmarkService.get(id);
        return ResponseResult.getResponse().setData(matchLandmark);
    }

    /**
     * 创建
     *
     * @param matchLandmark
     */
    @PostMapping
    public ResponseResult create(@RequestBody MatchLandmark matchLandmark) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchLandmark));

        ValidateUtils.notNull(matchLandmark, MessageLocale.NOT_NULL);
        MatchLandmark data = matchLandmarkService.create(matchLandmark);
        return ResponseResult.getResponse().setData(data);
    }

    /**
     * 修改
     *
     * @param matchLandmark
     */
    @PutMapping
    public ResponseResult modify(@RequestBody MatchLandmark matchLandmark) throws BusinessException {
        logger.debug("~~~~~ put param = {}", JSON.toJSONString(matchLandmark));

        ValidateUtils.notNull(matchLandmark, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(matchLandmark.getId(), MessageLocale.NOT_EMPTY);
        int count = matchLandmarkService.modify(matchLandmark);

        return ResponseResult.getResponse().setData(count);
    }

    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult remove(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
        MatchLandmark data = new MatchLandmark();
        data.setId(id);
        return ResponseResult.getResponse().setData(matchLandmarkService.remove(id));
    }

    /**
     * 用户地标
     *
     * @param request
     */
    @PostMapping("/user/landmark")
    public ResponseResult Landmark(HttpServletRequest request) throws BusinessException {
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);
        Map<String,Object> params = Maps.newHashMap();
        params.put("tenantId","456");
        List<MatchLandmark> dataList = matchLandmarkService.findBy(params);
        for (MatchLandmark matchLandmark : dataList) {
            MarkRecord markRecord = markRecordService.getMarkIdMarkRecord(user.getId(), matchLandmark.getId());
            matchLandmark.setState(ObjectUtils.isEmpty(markRecord) ? MarkState.MARK_STATE_NO.getStatus() : MarkState.MARK_STATE_YES.getStatus());
        }
        return ResponseResult.ok().setData(dataList);
    }
}