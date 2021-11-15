package com.tjcloud.face.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.face.base.entity.FaceWarn;

import java.util.List;
import java.util.Map;

/**
 * 学校开放非法越界告警信息表
(face_warn)
 * @author auto bin.yin 2019.08.26
 */
public interface FaceWarnService extends AbstractService<FaceWarn, String> {
    List<JSONObject> findWithLoc(Map<String, Object> params);

    Pagination<JSONObject> queryFaceWarnListPage(PageParam page, Map<String, Object> params);

    List<JSONObject> queryFaceWarnDeal(Map<String, Object> params);

    boolean saveData(Map<String, Object> params);

}