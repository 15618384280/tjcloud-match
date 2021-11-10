package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.SignRecordFieldTableDao;
import com.tjcloud.match.base.entity.SignRecordFieldTable;
import org.springframework.stereotype.Repository;

@Repository("signRecordFieldTableDao")
public class SignRecordFieldTableDaoImpl extends AbstractIBatisDaoImpl<SignRecordFieldTable, String> implements SignRecordFieldTableDao {

    @Override
    public int deleteByRecordId(String recordId) {
        return getSessionTemplate().delete(getStatement("deleteByRecordId"), recordId);
    }
}
