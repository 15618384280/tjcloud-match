package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.SportPlaceSignRecordDao;
import com.tjcloud.match.base.entity.SportPlaceSignRecord;
import com.tjcloud.match.base.service.SportPlaceSignRecordService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 健身苑点打卡记录表(SportPlaceSignRecord)表服务实现类
 *
 * @author makejava 2021-06-24 16:47:48
 */
@Service("sportPlaceSignRecordService")
public class SportPlaceSignRecordServiceImpl extends AbstractIbatisServiceImpl<SportPlaceSignRecordDao, SportPlaceSignRecord, String> implements SportPlaceSignRecordService {
    @Override
    public long findALLCountGroupByEveryDay(Map<String, Object> param) {
        return getDao().findALLCountGroupByEveryDay(param);
    }

    @Override
    public SportPlaceSignRecord findEndOne(Map<String, Object> param) {
        return getDao().findEndOne(param);
    }
}
