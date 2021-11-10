package com.tjcloud.match.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.SignRecordFieldTable;

/**
 * 参赛人员报名字段信息记录表(sign_record_field_table)
 * @author auto bin.yin 2016.12.12
 */
public interface SignRecordFieldTableService extends AbstractService<SignRecordFieldTable, String> {
    /**
     * 保存、新增 SignRecordFieldTable
     * @param signRecordFieldTable
     * @return
     */
    SignRecordFieldTable updateSignRecordField(SignRecordFieldTable signRecordFieldTable);


    /**
     * 根据recordId删除报名字段记录
     * @param recordId
     * @return
     */
    int deleteByRecordId(String recordId);
}
