package com.tjcloud.dd.base.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.dd.base.entity.City;

/**
 * 城市(dd_city)
 *
 * @author auto bin.yin 2016.06.16
 */
public interface CityService extends AbstractService<City, String> {

    List<JSONObject> findByCities(List<String> cityCodes);

    List<JSONObject> findByCityNames(List<String> cityNames);

    List<City> findParentByCities(List<String> cityCodes, List<String> parentCityCodes, String parentCode);

    List<City> findByParentCities(List<String> cityCodes, List<String> parentCityCodes, String parentCode);

    List<JSONObject> findByCityByMap(Integer type, String parentCode);

    List<JSONObject> findByCityByMap(Integer type, List<String> codeArray);

    List<City> readBy(Map<String, Object> params);

    List<JSONObject> findAllProvince(Integer type);
}
