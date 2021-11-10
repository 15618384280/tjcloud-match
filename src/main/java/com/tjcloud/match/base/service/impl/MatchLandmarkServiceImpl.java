package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.MatchLandmarkDao;
import com.tjcloud.match.base.entity.MatchLandmark;
import com.tjcloud.match.base.service.MatchLandmarkService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 地标主表(MatchLandmark)表服务实现类
 *
 * @author lucheng 2020-10-19 11:21:51
 */
@Service("matchLandmarkService")
public class MatchLandmarkServiceImpl extends AbstractIbatisServiceImpl<MatchLandmarkDao, MatchLandmark, String> implements MatchLandmarkService {

    @Override
    public Long findCount(Map<String, Object> params) {
        return getDao().findCount(params);
    }
}