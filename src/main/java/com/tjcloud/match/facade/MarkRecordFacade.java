package com.tjcloud.match.facade;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.base.entity.MarkRecord;
import com.tjcloud.match.base.entity.MatchLandmark;
import com.tjcloud.match.base.entity.MatchSubject;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.service.MarkRecordService;
import com.tjcloud.match.base.service.MatchLandmarkService;
import com.tjcloud.match.base.service.MatchSubjectService;
import com.tjcloud.match.base.service.SignRecordService;
import com.tjcloud.tenant.base.entity.UserStepcount;
import com.tjcloud.tenant.base.service.UserStepcountService;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.User;
import com.tjcloud.uac.base.service.UserService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 地标点亮记录表(MarkRecord)表控制层
 *
 * @author lucheng 2020-10-19 11:51:30
 */
@RestController
@RequestMapping("/markRecord")
public class MarkRecordFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(MarkRecordFacade.class);
    /**
     * 服务对象
     */
    @Autowired
    private MarkRecordService markRecordService;
    @Autowired
    private MatchLandmarkService matchLandmarkService;
    @Autowired
    private UserService userService;
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private UserStepcountService userStepcountService;
    @Autowired
    private MatchSubjectService matchSubjectService;
    /**
     * 分页查询列表
     *
     * @param request
     */
    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Pagination<MarkRecord> dataList = getPagination(request, markRecordService);
        return ResponseResult.getResponse().setData(dataList);
    }

    /**
     * 搜索列表
     *
     * @param json
     */
    @PostMapping("/search")
    public ResponseResult query(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        json.put("disabled", false);
        List<MarkRecord> dataList = markRecordService.findBy(json);
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

        MarkRecord markRecord = markRecordService.get(id);
        return ResponseResult.getResponse().setData(markRecord);
    }

    /**
     * 创建
     *
     * @param markRecord
     */
    @PostMapping
    public ResponseResult create(@RequestBody MarkRecord markRecord) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(markRecord));

        ValidateUtils.notNull(markRecord, MessageLocale.NOT_NULL);
        MarkRecord data = markRecordService.create(markRecord);
        return ResponseResult.getResponse().setData(data);
    }

    /**
     * 修改
     *
     * @param markRecord
     */
    @PutMapping
    public ResponseResult modify(@RequestBody MarkRecord markRecord) throws BusinessException {
        logger.debug("~~~~~ put param = {}", JSON.toJSONString(markRecord));

        ValidateUtils.notNull(markRecord, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(markRecord.getId(), MessageLocale.NOT_EMPTY);
        int count = markRecordService.modify(markRecord);

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
        MarkRecord data = new MarkRecord();
        data.setId(id);
        data.setDisabled(true);
        return ResponseResult.getResponse().setData(markRecordService.remove(id));
    }

    /**
     * 用户地标记录
     *
     * @param request
     */
    @PostMapping("/user")
    public ResponseResult userMarkRecord(HttpServletRequest request) throws BusinessException {
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);

        JSONObject jsonObject = new JSONObject();
        List<MarkRecord> markRecords = markRecordService.getUserIdMarkRecord(user.getId());
        if (!ObjectUtils.isEmpty(markRecords)) {
            jsonObject.put("markRecord", markRecords);
            Map<String,Object> params = Maps.newHashMap();
            params.put("tenantId","123");
            Boolean isFinish = markRecords.size() < matchLandmarkService.findCount(params) ? false : true;
            jsonObject.put("isFinish", isFinish);
            jsonObject.put("markRecordCount", markRecords.size());
            if (isFinish) {
                // 证书信息
                MatchLandmark matchLandmark = matchLandmarkService.get(markRecords.get(0).getMarkId());
                JSONObject matchParam = new JSONObject();
                matchParam.put("userId", user.getId());
                matchParam.put("matchId", matchLandmark.getMatchId());
                SignRecord signRecord = signRecordService.findOne(matchParam);
                jsonObject.put("name", signRecord.getName());
                jsonObject.put("matchName", signRecord.getMatchName());
                // 完赛时间
                List<Long> tiemList = markRecords.stream().map(MarkRecord::getCreatedTime).collect(Collectors.toList());
                Long maxTiemList = Collections.max(tiemList);
                jsonObject.put("finishTime", DateUtils.formatDate(maxTiemList, "yyyy年MM月dd日 HH时mm分ss秒"));
            }
        }
        return ResponseResult.ok().setData(jsonObject);
    }


    /**
     * 用户点亮地标
     *
     * @param json
     */
    @PostMapping("/userSignMark")
    public ResponseResult userSignMark(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(json));
        String markId = json.getString("markId");
        ValidateUtils.notEmpty(markId, MessageLocale.EMPTY_CODE, "地标ID不能为空");
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);
        return ResponseResult.getResponse().setData(markRecordService.signMark(user.getId(), markId));
    }


    /**
     * 用户下一个点亮地标
     *
     * @param json
     */
    @PostMapping("/userNextSignMark")
    public ResponseResult userNextSignMark(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(json));
        String matchId = json.getString("matchId");
        ValidateUtils.notEmpty(matchId, MessageLocale.EMPTY_CODE, "赛事ID不能为空");
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);
        return ResponseResult.getResponse().setData(markRecordService.nextSignMark(user.getId(), matchId));
    }



    /**
     * 用户点亮地标
     *
     * @param json
     */
    @PostMapping("/first/userSignMark")
    public ResponseResult firstUserSignMark(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(json));
        String markId = json.getString("markId");
        ValidateUtils.notEmpty(markId, MessageLocale.EMPTY_CODE, "地标ID不能为空");
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);
        return ResponseResult.getResponse().setData(markRecordService.firstSignMark(user.getId(), markId));
    }


    /**
     * 用户下一个点亮地标
     *
     * @param json
     */
    @PostMapping("/next/userSignMark")
    public ResponseResult nextUserSignMark(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(json));
        String matchId = json.getString("matchId");
        ValidateUtils.notEmpty(matchId, MessageLocale.EMPTY_CODE, "赛事ID不能为空");
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);
        return ResponseResult.getResponse().setData(markRecordService.nextUserSignMark(user.getId(), matchId));
    }


    /**
     * 用户地标记录
     *
     * @param request
     */
    @PostMapping("/userMarkRecord")
    public ResponseResult markRecord(HttpServletRequest request) throws BusinessException {
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, UserMessageLocale.USER_NOT_NULL);

        JSONObject jsonObject = new JSONObject();
        List<MarkRecord> markRecords = markRecordService.getUserIdAndTenantIdMarkRecord(user.getId());
        if (!ObjectUtils.isEmpty(markRecords)) {
            jsonObject.put("markRecord", markRecords);
            Map<String,Object> params = Maps.newHashMap();
            params.put("tenantId","456");
            Boolean isFinish = markRecords.size() < matchLandmarkService.findCount(params) ? false : true;
            jsonObject.put("isFinish", isFinish);
            jsonObject.put("markRecordCount", markRecords.size());
            if (isFinish) {
                // 证书信息
                MatchLandmark matchLandmark = matchLandmarkService.get(markRecords.get(0).getMarkId());
                JSONObject matchParam = new JSONObject();
                matchParam.put("userId", user.getId());
                matchParam.put("matchId", matchLandmark.getMatchId());
                SignRecord signRecord = signRecordService.findOne(matchParam);
                jsonObject.put("name", signRecord.getName());
                jsonObject.put("matchName", signRecord.getMatchName());
                // 完赛时间
                List<Long> tiemList = markRecords.stream().map(MarkRecord::getCreatedTime).collect(Collectors.toList());
                Long maxTiemList = Collections.max(tiemList);
                jsonObject.put("finishTime", DateUtils.formatDate(maxTiemList, "yyyy年MM月dd日 HH时mm分ss秒"));
            }
        }
        return ResponseResult.ok().setData(jsonObject);
    }


    /**
     *@Description:获取累计步数
     *@return ResponseResult
     *@author:lihongzhou
     *@time:2019年4月15日 下午2:51:21
     */
    @PostMapping("/wyyd/walkcounts")
    public ResponseResult wyydWalkCounts(@RequestBody JSONObject json, HttpServletRequest request) {
        User user = userService.findByAuthId(getCurrentAuthId(request));
        ValidateUtils.notNull(user, MessageLocale.EMPTY_CODE, "获取用户信息失败");
        String subjectId = json.get("subjectId").toString();
        MatchSubject matchSubject = matchSubjectService.get(subjectId);
        List<UserStepcount> userStepcountList = userStepcountService.findByUserIdAndTime(user.getId(), matchSubject.getGameTime(), matchSubject.getGameEndTime());
        Integer stepcount = 0;
        for (UserStepcount userStepcount : userStepcountList) {
            stepcount += userStepcount.getStepcount();
        }
        return ResponseResult.ok().setData(stepcount);
    }
}