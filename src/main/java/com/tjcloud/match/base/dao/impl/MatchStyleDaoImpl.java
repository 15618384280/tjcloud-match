package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchStyleDao;
import com.tjcloud.match.base.entity.MatchStyle;
import org.springframework.stereotype.Repository;

@Repository("matchStyleDao")
public class MatchStyleDaoImpl extends AbstractIBatisDaoImpl<MatchStyle, String> implements MatchStyleDao {

}
