package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.SignFieldTableDao;
import com.tjcloud.match.base.entity.SignFieldTable;
import org.springframework.stereotype.Repository;

@Repository("signFieldTableDao")
public class SignFieldTableDaoImpl extends AbstractIBatisDaoImpl<SignFieldTable, String> implements SignFieldTableDao {

}
