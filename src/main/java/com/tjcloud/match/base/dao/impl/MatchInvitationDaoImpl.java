package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchInvitationDao;
import com.tjcloud.match.base.entity.MatchInvitation;
import org.springframework.stereotype.Repository;

@Repository("matchInvitationDao")
public class MatchInvitationDaoImpl extends AbstractIBatisDaoImpl<MatchInvitation, String> implements MatchInvitationDao {

}
