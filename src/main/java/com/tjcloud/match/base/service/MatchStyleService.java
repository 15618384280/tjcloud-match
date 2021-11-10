package com.tjcloud.match.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.MatchStyle;

/**
 * 赛事风采(match_style)
 * @author auto bin.yin 2016.12.12
 */
public interface MatchStyleService extends AbstractService<MatchStyle, String> {
	/**
	 * 根据人脸搜索赛事风采
	 * @param face
	 * @return
	 */
	Pagination<MatchStyle> faceMatchStyle(PageParam page, JSONObject face);
}
