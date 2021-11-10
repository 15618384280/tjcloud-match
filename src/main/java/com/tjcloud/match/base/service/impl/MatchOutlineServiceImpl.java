package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.MatchOutlineDao;
import com.tjcloud.match.base.entity.MatchOutline;
import com.tjcloud.match.base.service.MatchOutlineService;
import org.springframework.stereotype.Service;

@Service("matchOutlineService")
public class MatchOutlineServiceImpl extends AbstractIbatisServiceImpl<MatchOutlineDao, MatchOutline, String> implements MatchOutlineService {

}
