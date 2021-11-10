package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchSloganDao;
import com.tjcloud.match.base.entity.MatchSlogan;
import org.springframework.stereotype.Repository;

/**
 * 赛事标题(MatchSlogan)表数据库访问层
 *
 * @author makejava 2021-06-24 13:49:21
 */
@Repository("matchSloganDao")
public class MatchSloganDaoImpl extends AbstractIBatisDaoImpl<MatchSlogan, String> implements MatchSloganDao {
}
