package com.tjcloud.match.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.SportPlaceSignRecord;

import java.util.Map;

public interface SportPlaceSignRecordService extends AbstractService<SportPlaceSignRecord, String> {
    long findALLCountGroupByEveryDay(Map<String, Object> param);

    SportPlaceSignRecord findEndOne(Map<String, Object> param);
}
