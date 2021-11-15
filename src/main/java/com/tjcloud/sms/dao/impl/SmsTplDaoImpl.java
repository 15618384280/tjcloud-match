package com.tjcloud.sms.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.sms.dao.SmsTplDao;
import com.tjcloud.sms.entity.SmsTpl;
import org.springframework.stereotype.Repository;

@Repository("smsTplDao")
public class SmsTplDaoImpl extends AbstractIBatisDaoImpl<SmsTpl, String> implements SmsTplDao {

}
