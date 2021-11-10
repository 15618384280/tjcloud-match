package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchRqCodeDao;
import com.tjcloud.match.base.entity.MatchRqCode;
import org.springframework.stereotype.Repository;

@Repository("matchRqCodeDao")
public class MatchRqCodeDaoImpl extends AbstractIBatisDaoImpl<MatchRqCode, String> implements MatchRqCodeDao {

}
