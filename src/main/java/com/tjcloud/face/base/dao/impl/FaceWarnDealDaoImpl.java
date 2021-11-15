package com.tjcloud.face.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FaceWarnDealDao;
import com.tjcloud.face.base.entity.FaceWarnDeal;
import org.springframework.stereotype.Repository;

@Repository("faceWarnDealDao")
public class FaceWarnDealDaoImpl extends AbstractIBatisDaoImpl<FaceWarnDeal, String> implements FaceWarnDealDao {

}
