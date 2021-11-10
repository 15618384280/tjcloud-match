package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.MatchPlayersDao;
import com.tjcloud.match.base.entity.MatchPlayers;
import com.tjcloud.match.base.service.MatchPlayersService;
import org.springframework.stereotype.Service;

@Service("matchPlayersService")
public class MatchPlayersServiceImpl extends AbstractIbatisServiceImpl<MatchPlayersDao, MatchPlayers, String> implements MatchPlayersService {

}
