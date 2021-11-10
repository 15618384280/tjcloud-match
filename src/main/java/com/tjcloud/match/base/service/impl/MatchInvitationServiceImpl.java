package com.tjcloud.match.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.MatchInvitationDao;
import com.tjcloud.match.base.entity.MatchInvitation;
import com.tjcloud.match.base.service.MatchInvitationService;
import org.springframework.stereotype.Service;

@Service("matchInvitationService")
public class MatchInvitationServiceImpl extends AbstractIbatisServiceImpl<MatchInvitationDao, MatchInvitation, String> implements MatchInvitationService {

}
