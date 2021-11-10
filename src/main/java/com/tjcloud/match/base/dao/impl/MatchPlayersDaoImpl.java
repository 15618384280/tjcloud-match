package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchPlayersDao;
import com.tjcloud.match.base.entity.MatchPlayers;
import org.springframework.stereotype.Repository;

@Repository("matchPlayersDao")
public class MatchPlayersDaoImpl extends AbstractIBatisDaoImpl<MatchPlayers, String> implements MatchPlayersDao {

}
