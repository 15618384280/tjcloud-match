package com.tjcloud.match.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.MarkRecord;
import com.tjcloud.match.base.entity.MatchLandmark;

import java.util.List;

/**
 * 地标点亮记录表(MarkRecord)表服务接口
 *
 * @author lucheng 2020-10-19 11:51:26
 */
public interface MarkRecordService extends AbstractService<MarkRecord, String> {

    MarkRecord signMark(String userId, String markId);

    MatchLandmark nextSignMark(String userId, String markId);

    List<MarkRecord> getUserIdMarkRecord(String userId);

    MarkRecord getMarkIdMarkRecord(String userId, String markId);

    MarkRecord firstSignMark(String id, String markId);

    MatchLandmark nextUserSignMark(String id, String matchId);

    List<MarkRecord> getUserIdAndTenantIdMarkRecord(String id);
}