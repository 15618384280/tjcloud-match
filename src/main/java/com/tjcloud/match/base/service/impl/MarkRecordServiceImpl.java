package com.tjcloud.match.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.api.enums.MatchState;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.base.dao.MarkRecordDao;
import com.tjcloud.match.base.entity.*;
import com.tjcloud.match.base.service.*;
import com.tjcloud.tenant.base.entity.UserStepcount;
import com.tjcloud.tenant.base.service.UserStepcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 地标点亮记录表(MarkRecord)表服务实现类
 *
 * @author lucheng 2020-10-19 11:51:27
 */
@Service("markRecordService")
public class MarkRecordServiceImpl extends AbstractIbatisServiceImpl<MarkRecordDao, MarkRecord, String> implements MarkRecordService {

    @Autowired
    private MarkRecordService markRecordService;
    @Autowired
    private MatchLandmarkService matchLandmarkService;
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private UserStepcountService userStepcountService;
    @Autowired
    private MatchInfoService matchInfoService;
    @Autowired
    private MatchSubjectService matchSubjectService;

    @Override
    public MarkRecord signMark(String userId, String markId) {
        MatchLandmark matchLandmark = matchLandmarkService.get(markId);
        ValidateUtils.notNull(matchLandmark, MessageLocale.EMPTY_CODE, "地标不存在!");
        // 用户是否报名
        JSONObject matchParam = new JSONObject();
        matchParam.put("userId", userId);
        matchParam.put("matchId", matchLandmark.getMatchId());
        SignRecord signRecord = signRecordService.findOne(matchParam);
        ValidateUtils.isFalse(ObjectUtils.isEmpty(signRecord), MessageLocale.EMPTY_CODE, "还未报名!");
        // 用户是否已点亮
        MarkRecord markRecord = markRecordService.getMarkIdMarkRecord(userId, markId);
        ValidateUtils.isTrue(ObjectUtils.isEmpty(markRecord), MessageLocale.EMPTY_CODE, "该地标已点亮!");
        // 用户步数是否达到要求
        UserStepcount userStepcount = userStepcountService.findByUserIdAndDate(userId, DateUtils.getCurrentDate());
        ValidateUtils.notNull(userStepcount, MessageLocale.EMPTY_CODE, "没有上传步数!");
        ValidateUtils.isTrue(isStandard(userStepcount.getStepcount(), matchLandmark.getSortNo().intValue()), MessageLocale.EMPTY_CODE, "步数不足,请继续运动!");
        // 保存用户地标点亮记录
        MarkRecord newMarkRecord = new MarkRecord();
        newMarkRecord.setTenantId(matchLandmark.getTenantId());
        newMarkRecord.setMarkId(markId);
        newMarkRecord.setUserId(userId);
        newMarkRecord.setMarkSortNo(matchLandmark.getSortNo());
        newMarkRecord.setMarkLogo(matchLandmark.getLogoHref());
        newMarkRecord.setMatchSignId(signRecord.getId());
        return markRecordService.create(newMarkRecord);
    }

    @Override
    public MatchLandmark nextSignMark(String userId, String matchId) {
        MatchInfo matchInfo = matchInfoService.get(matchId);
        ValidateUtils.notNull(matchInfo, MatchMessageLocale.DATA_EMPTY);
        // 赛事是否已结束
        ValidateUtils.isFalse(MatchState.MATCH_STATE_END.getStatus() == matchInfo.getState(), MessageLocale.EMPTY_CODE, "赛事已结束!");
        // 用户已点亮地标
        List<MarkRecord> markRecords = markRecordService.getUserIdMarkRecord(userId);
        Long nextSortNo = 0L;
        if (!ObjectUtils.isEmpty(markRecords)) {
            // 已点亮地标的最大排序
            List<Long> sortNoList = markRecords.stream().map(MarkRecord::getMarkSortNo).collect(Collectors.toList());
            nextSortNo = Collections.max(sortNoList) + 1;
        }
        // 是否已完成任务
        Map<String,Object> params = Maps.newHashMap();
        params.put("tenantId","123");
        ValidateUtils.isFalse(markRecords.size() >= matchLandmarkService.findCount(params), MessageLocale.EMPTY_CODE, "已完成任务!");
        // 下一个点亮地标
        UserStepcount userStepcount = userStepcountService.findByUserIdAndDate(userId, DateUtils.getCurrentDate());
        ValidateUtils.notNull(userStepcount, MessageLocale.EMPTY_CODE, "没有上传步数!");
        ValidateUtils.isTrue(isStandard(userStepcount.getStepcount(), nextSortNo.intValue()), MessageLocale.EMPTY_CODE, "步数不足,请继续运动!");
        // 可继续点亮地标数量
        Integer standardMarkNum = 0;
        if (userStepcount.getStepcount() >= 10000) {
            standardMarkNum = 5;
        } else if (userStepcount.getStepcount() >= 8000) {
            standardMarkNum = 4;
        } else if (userStepcount.getStepcount() >= 6000) {
            standardMarkNum = 3;
        } else if (userStepcount.getStepcount() >= 4000) {
            standardMarkNum = 2;
        } else if (userStepcount.getStepcount() >= 2000) {
            standardMarkNum = 1;
        }

        JSONObject markParam = new JSONObject();
        markParam.put("matchId", matchId);
        markParam.put("sortNo", nextSortNo);
        MatchLandmark matchLandmark = matchLandmarkService.findOne(markParam);
        matchLandmark.setStandardMarkNum(standardMarkNum - markRecords.size());
        return matchLandmark;
    }

    @Override
    public List<MarkRecord> getUserIdMarkRecord(String userId) {
        JSONObject param = new JSONObject();
        param.put("userId", userId);
        param.put("tenantId", "123");
        param.put("createdTimeStart", DateUtils.toLongDateTime(DateUtils.getCurrentDate() + " 00:00:00"));
        param.put("createdTimeEnd", DateUtils.toLongDateTime(DateUtils.getCurrentDate() + " 23:59:59"));
        List<MarkRecord> markRecords = markRecordService.findBy(param);
        return markRecords;
    }

    @Override
    public MarkRecord getMarkIdMarkRecord(String userId, String markId) {
        JSONObject param = new JSONObject();
        param.put("userId", userId);
        param.put("markId", markId);
//        param.put("createdTimeStart", DateUtils.toLongDateTime(DateUtils.getCurrentDate() + " 00:00:00"));
//        param.put("createdTimeEnd", DateUtils.toLongDateTime(DateUtils.getCurrentDate() + " 23:59:59"));
        MarkRecord markRecords = markRecordService.findOne(param);
        return markRecords;
    }

    @Override
    public MarkRecord firstSignMark(String userId, String markId) {
        MatchLandmark matchLandmark = matchLandmarkService.get(markId);
        ValidateUtils.notNull(matchLandmark, MessageLocale.EMPTY_CODE, "地标不存在!");
        // 用户是否报名
        JSONObject matchParam = new JSONObject();
        matchParam.put("userId", userId);
        matchParam.put("matchId", matchLandmark.getMatchId());
        SignRecord signRecord = signRecordService.findOne(matchParam);
        ValidateUtils.isFalse(ObjectUtils.isEmpty(signRecord), MessageLocale.EMPTY_CODE, "还未报名!");
        // 用户是否已点亮
        MarkRecord markRecord = markRecordService.getMarkIdMarkRecord(userId, markId);
        ValidateUtils.isTrue(ObjectUtils.isEmpty(markRecord), MessageLocale.EMPTY_CODE, "该地标已点亮!");
        // 用户步数是否达到要求
        JSONObject param = new JSONObject();
        param.put("matchId", matchLandmark.getMatchId());
        List<MatchSubject> matchSubjectList = matchSubjectService.findBy(param);
        Long gameTime = 0l;
        Long gameEndTime = 0l;
        if (!ObjectUtils.isEmpty(matchSubjectList)){
            gameTime = matchSubjectList.get(0).getGameTime();
            if (System.currentTimeMillis()<gameTime){
                throw new BusinessException(MessageLocale.EMPTY_CODE, "比赛未开始");
            }
            gameEndTime = matchSubjectList.get(0).getGameEndTime();
        }
        List<UserStepcount> userStepcountList = userStepcountService.findByUserIdAndTime(userId,gameTime,gameEndTime);
        Integer stepcount = 0;
        if (!ObjectUtils.isEmpty(userStepcountList)){
            for (UserStepcount userStepcount : userStepcountList) {
                stepcount += userStepcount.getStepcount();
            }
        }
        ValidateUtils.notNull(userStepcountList, MessageLocale.EMPTY_CODE, "没有上传步数!");
        ValidateUtils.isTrue(isSignStandard(stepcount, matchLandmark.getSortNo().intValue()), MessageLocale.EMPTY_CODE, "步数不足,请继续运动!");
        // 保存用户地标点亮记录
        MarkRecord newMarkRecord = new MarkRecord();
        newMarkRecord.setTenantId(matchLandmark.getTenantId());
        newMarkRecord.setMarkId(markId);
        newMarkRecord.setUserId(userId);
        newMarkRecord.setMarkSortNo(matchLandmark.getSortNo());
        newMarkRecord.setMarkLogo(matchLandmark.getLogoHref());
        newMarkRecord.setMatchSignId(signRecord.getId());
        return markRecordService.create(newMarkRecord);
    }

    @Override
    public MatchLandmark nextUserSignMark(String userId, String matchId) {
        MatchInfo matchInfo = matchInfoService.get(matchId);
        ValidateUtils.notNull(matchInfo, MatchMessageLocale.DATA_EMPTY);
        // 赛事是否已结束
        ValidateUtils.isFalse(MatchState.MATCH_STATE_END.getStatus() == matchInfo.getState(), MessageLocale.EMPTY_CODE, "赛事已结束!");
        // 用户已点亮地标
        List<MarkRecord> markRecords = markRecordService.getUserIdAndTenantIdMarkRecord(userId);
        Long nextSortNo = 0L;
        if (!ObjectUtils.isEmpty(markRecords)) {
            // 已点亮地标的最大排序
            List<Long> sortNoList = markRecords.stream().map(MarkRecord::getMarkSortNo).collect(Collectors.toList());
            nextSortNo = Collections.max(sortNoList) + 1;
        }
        // 是否已完成任务
        Map<String,Object> params = Maps.newHashMap();
        params.put("tenantId","456");
        ValidateUtils.isFalse(markRecords.size() >= matchLandmarkService.findCount(params), MessageLocale.EMPTY_CODE, "已完成任务!");
        // 下一个点亮地标
        JSONObject param = new JSONObject();
        param.put("matchId", matchId);
        List<MatchSubject> matchSubjectList = matchSubjectService.findBy(param);
        Long gameTime = 0l;
        Long gameEndTime = 0l;
        if (!ObjectUtils.isEmpty(matchSubjectList)){
            if (System.currentTimeMillis()<gameTime){
                throw new BusinessException(MessageLocale.EMPTY_CODE, "比赛未开始");
            }
            gameTime = matchSubjectList.get(0).getGameTime();
            gameEndTime = matchSubjectList.get(0).getGameEndTime();
        }
        List<UserStepcount> userStepcountList = userStepcountService.findByUserIdAndTime(userId,gameTime,gameEndTime);
        Integer stepcount = 0;
        if (!ObjectUtils.isEmpty(userStepcountList)){
            for (UserStepcount userStepcount : userStepcountList) {
                stepcount += userStepcount.getStepcount();
            }
        }
        ValidateUtils.notNull(stepcount, MessageLocale.EMPTY_CODE, "没有上传步数!");
        ValidateUtils.isTrue(isSignStandard(stepcount, nextSortNo.intValue()), MessageLocale.EMPTY_CODE, "步数不足,请继续运动!");
        // 可继续点亮地标数量
        Integer standardMarkNum = 0;
        if (stepcount >= 25000) {
            standardMarkNum = 7;
        } else if (stepcount >= 20000) {
            standardMarkNum = 6;
        } else if (stepcount >= 16000) {
            standardMarkNum = 5;
        } else if (stepcount >= 12000) {
            standardMarkNum = 4;
        } else if (stepcount >= 8000) {
            standardMarkNum = 3;
        } else if (stepcount >= 4000) {
            standardMarkNum = 2;
        } else if (stepcount >= 0) {
            standardMarkNum = 1;
        }

        JSONObject markParam = new JSONObject();
        markParam.put("matchId", matchId);
        markParam.put("sortNo", nextSortNo);
        MatchLandmark matchLandmark = matchLandmarkService.findOne(markParam);
        matchLandmark.setStandardMarkNum(standardMarkNum - markRecords.size());
        return matchLandmark;
    }

    @Override
    public List<MarkRecord> getUserIdAndTenantIdMarkRecord(String userId) {
        JSONObject param = new JSONObject();
        param.put("userId", userId);
        param.put("tenantId", "456");
//        param.put("createdTimeStart", DateUtils.toLongDateTime(DateUtils.getCurrentDate() + " 00:00:00"));
//        param.put("createdTimeEnd", DateUtils.toLongDateTime(DateUtils.getCurrentDate() + " 23:59:59"));
        List<MarkRecord> markRecords = markRecordService.findBy(param);
        return markRecords;
    }

    private Boolean isStandard(Integer userStepcount, Integer nextSortNo) {
        Integer stepcount;
        switch (nextSortNo) {
            case 1:
                stepcount = 4000;
                break;
            case 2:
                stepcount = 6000;
                break;
            case 3:
                stepcount = 8000;
                break;
            case 4:
                stepcount = 10000;
                break;
            default:
                stepcount = 2000;
                break;
        }
        if (userStepcount >= stepcount) {
            return true;
        }
        return false;
    }

    private Boolean isSignStandard(Integer userStepcount, Integer nextSortNo) {
        Integer stepcount;
        switch (nextSortNo) {
            case 1:
                stepcount = 4000;
                break;
            case 2:
                stepcount = 8000;
                break;
            case 3:
                stepcount = 12000;
                break;
            case 4:
                stepcount = 16000;
                break;
            case 5:
                stepcount = 20000;
                break;
            case 6:
                stepcount = 25000;
                break;
            default:
                stepcount = 0;
                break;
        }
        if (userStepcount >= stepcount) {
            return true;
        }
        return false;
    }

}