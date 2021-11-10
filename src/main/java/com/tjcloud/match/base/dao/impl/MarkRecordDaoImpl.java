package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.MarkRecordDao;
import com.tjcloud.match.base.entity.MarkRecord;
import org.springframework.stereotype.Repository;


/**
 * 地标点亮记录表(MarkRecord)表数据库访问层
 *
 * @author lucheng 2020-10-19 11:51:36
 */
@Repository("markRecordDao")
public class MarkRecordDaoImpl extends AbstractIBatisDaoImpl<MarkRecord, String> implements MarkRecordDao {

}