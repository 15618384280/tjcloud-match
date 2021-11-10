package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MatchLandmarkDao;
import com.tjcloud.match.base.entity.MatchLandmark;
import org.springframework.stereotype.Repository;


/**
 * 地标主表(MatchLandmark)表数据库访问层
 *
 * @author lucheng 2020-10-19 11:21:57
 */
@Repository("matchLandmarkDao")
public class MatchLandmarkDaoImpl extends AbstractIBatisDaoImpl<MatchLandmark, String> implements MatchLandmarkDao {

}