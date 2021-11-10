package com.tjcloud.dd.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.dd.base.entity.City;

import java.util.List;

/**
 * 城市(dd_city)
 *
 * @author auto bin.yin 2016.06.16
 */
public interface CityService extends AbstractService<City, String> {

    List<JSONObject> findByCityNames(List<String> cityNames);

}
