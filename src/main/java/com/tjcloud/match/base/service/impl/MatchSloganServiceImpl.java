package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.MatchSloganDao;
import com.tjcloud.match.base.entity.MatchSlogan;
import com.tjcloud.match.base.service.MatchSloganService;
import org.springframework.stereotype.Service;

/**
 * 赛事标题(MatchSlogan)表服务实现类
 *
 * @author makejava 2021-06-24 13:49:18
 */
@Service("matchSloganService")
public class MatchSloganServiceImpl extends AbstractIbatisServiceImpl<MatchSloganDao, MatchSlogan, String> implements MatchSloganService {
}
