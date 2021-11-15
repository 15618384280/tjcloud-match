package com.tjcloud.face.base.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FaceWarnDao;
import com.tjcloud.face.base.entity.FaceWarn;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Repository("faceWarnDao")
public class FaceWarnDaoImpl extends AbstractIBatisDaoImpl<FaceWarn, String> implements FaceWarnDao {
    @Override
    public List<JSONObject> findWithLoc(Map<String, Object> params) {
        return getSessionTemplate().selectList(getStatement("findWithLoc"), params);
    }

    @Override
    public Pagination<JSONObject> queryFaceWarnListPage(PageParam page, Map<String, Object> params) {
        if (params == null) {
            params = Maps.newHashMapWithExpectedSize(8);
        }

        if (page != null && page.getPageSize() > 0) {
            if (page.getPageNo() < 0) {
                page.setPageNo(1);
            }

            ((Map<String, Object>) params).put("pageFirst", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
            ((Map<String, Object>) params).put("pageSize", Integer.valueOf(page.getPageSize()));
            ((Map<String, Object>) params).put("startRowNum", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
            ((Map<String, Object>) params).put("endRowNum", Integer.valueOf(page.getPageNo() * page.getPageSize()));
            Long count = (Long) this.getSessionTemplate()
                    .selectOne(this.getStatement("queryFaceWarnListPageCount"), params);
            int maxPage = (new BigDecimal(count.longValue()))
                    .divide(new BigDecimal(page.getPageSize()), RoundingMode.CEILING).intValue();
            if (maxPage < page.getPageNo()) {
                page.setPageNo(maxPage);
            }

            List<JSONObject> list = this.getSessionTemplate().selectList(this.getStatement("queryFaceWarnListPage"),params);
            ValidateUtils.isFalse(list.size() > 10000, 0, "Found more than 10000 rows.");
            return new Pagination(page.getPageNo(), page.getPageSize(), count.intValue(), list);
        } else {
            return new Pagination(this.getSessionTemplate().selectList(this.getStatement("queryFaceWarnListBy"), params));
        }
    }

    @Override
    public List<JSONObject> queryFaceWarnDeal(Map<String, Object> params) {
        return getSessionTemplate().selectList(getStatement("queryFaceWarnDeal"), params);
    }
}
