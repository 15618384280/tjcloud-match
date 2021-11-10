package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.SportPlaceSignRecordDao;
import com.tjcloud.match.base.entity.SportPlaceSignRecord;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 健身苑点打卡记录表(SportPlaceSignRecord)表数据库访问层
 *
 * @author makejava 2021-06-24 16:47:51
 */
@Repository("sportPlaceSignRecordDao")
public class SportPlaceSignRecordDaoImpl extends AbstractIBatisDaoImpl<SportPlaceSignRecord, String> implements SportPlaceSignRecordDao {
    @Override
    public long findALLCountGroupByEveryDay(Map<String, Object> param) {
        return getSessionTemplate().selectOne(getStatement("findALLCountGroupByEveryDay"),param);
    }

    @Override
    public SportPlaceSignRecord findEndOne(Map<String, Object> param) {
        return getSessionTemplate().selectOne(getStatement("findEndOne"),param);
    }
}
