package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.MatchRqCodeDao;
import com.tjcloud.match.base.entity.MatchRqCode;
import com.tjcloud.match.base.service.MatchRqCodeService;
import org.springframework.stereotype.Service;

@Service("matchRqCodeService")
public class MatchRqCodeServiceImpl extends AbstractIbatisServiceImpl<MatchRqCodeDao, MatchRqCode, String> implements MatchRqCodeService {

}
