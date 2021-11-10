package com.tjcloud.match.base.dao;

import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import com.tjcloud.match.base.entity.SportPlaceSignRecord;

import java.util.Map;

public interface SportPlaceSignRecordDao extends AbstractIBatisDao<SportPlaceSignRecord, String> {
    long findALLCountGroupByEveryDay(Map<String, Object> param);

    SportPlaceSignRecord findEndOne(Map<String, Object> param);
}
