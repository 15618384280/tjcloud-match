package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchOutlineDao;
import com.tjcloud.match.base.entity.MatchOutline;
import org.springframework.stereotype.Repository;

@Repository("matchOutlineDao")
public class MatchOutlineDaoImpl extends AbstractIBatisDaoImpl<MatchOutline, String> implements MatchOutlineDao {

}
