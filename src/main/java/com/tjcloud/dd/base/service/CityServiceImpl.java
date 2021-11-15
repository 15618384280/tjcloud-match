package com.tjcloud.dd.base.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.data.utils.DBContextHolder;
import com.tjcloud.data.utils.DBSource;
import com.tjcloud.dd.base.dao.CityDao;
import com.tjcloud.dd.base.entity.City;

@Service("cityService")
public class CityServiceImpl extends AbstractIbatisServiceImpl<CityDao, City, String> implements CityService {

    @Autowired
    private DBContextHolder dbContextHolder;

    @Override
    public List<JSONObject> findByCities(List<String> cityCodes) {
        return getDao().findByCities(cityCodes);
    }

    @Override
    public List<JSONObject> findByCityByMap(Integer type, String parentCode) {
        JSONObject param = new JSONObject();
        param.put("parentCode", parentCode);
        if (type != null) {
            param.put("type", type);
        }
        return getDao().findByCityByMap(param);
    }

    @Override
    public List<JSONObject> findByCityByMap(Integer type, List<String> codeArray) {
        JSONObject param = new JSONObject();
        param.put("codeArray", codeArray);
        if (type != null) {
            param.put("type", type);
        }
        return getDao().findByCityByMap(param);
    }

    @Override
    public List<JSONObject> findAllProvince(Integer type) {

        JSONObject param = new JSONObject();
        param.put("type", type);
        return getDao().findAllProvince(param);
    }

    @Override
    public List<JSONObject> findByCityNames(List<String> cityNames) {
        return getDao().findByCityNames(cityNames);
    }

    @Override
    public List<City> findParentByCities(List<String> cityCodes, List<String> parentCityCodes, String parentCode) {
        return getDao().findParentByCities(cityCodes, parentCityCodes, parentCode);
    }

    @Override
    public List<City> findByParentCities(List<String> cityCodes, List<String> parentCityCodes, String parentCode) {
        return getDao().findByParentCities(cityCodes, parentCityCodes, parentCode);
    }

    @Override
    public List<City> readBy(Map<String, Object> params) {
        dbContextHolder.setDBSource(DBSource.DB_SOURCE_READE_ONE);
        return getDao().findBy(params);
    }
}
