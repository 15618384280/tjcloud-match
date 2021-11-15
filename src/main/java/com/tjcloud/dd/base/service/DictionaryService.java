package com.tjcloud.dd.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.dd.base.entity.Dictionary;

/**
 * 数据字典表(dictionary)
 * @author auto bin.yin 2016.05.12
 */
public interface DictionaryService extends AbstractService<Dictionary, String> {

	String getName(String key, String value);

	Dictionary get(String key, String value);
}
