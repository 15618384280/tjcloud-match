package com.tjcloud.match.base.dao;

import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import com.tjcloud.match.base.entity.SignRecordFieldTable;

/**
 * 参赛人员报名字段信息记录表(sign_record_field_table)
 * @author auto bin.yin 2016.12.12
 */
public interface SignRecordFieldTableDao extends AbstractIBatisDao<SignRecordFieldTable, String> {
    int deleteByRecordId(String subjectId);
}
