package com.tjcloud.match.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.MatchLandmark;

import java.util.Map;

/**
 * 地标主表(MatchLandmark)表服务接口
 *
 * @author lucheng 2020-10-19 11:21:50
 */
public interface MatchLandmarkService extends AbstractService<MatchLandmark, String> {


    Long findCount(Map<String, Object> params);
}