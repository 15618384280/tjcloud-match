package com.tjcloud.match.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.api.service.FaceApiService;
import com.tjcloud.face.base.vo.ImageSearch;
import com.tjcloud.match.base.dao.MatchStyleDao;
import com.tjcloud.match.base.entity.MatchStyle;
import com.tjcloud.match.base.service.MatchStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("matchStyleService")
public class MatchStyleServiceImpl extends AbstractIbatisServiceImpl<MatchStyleDao, MatchStyle, String> implements MatchStyleService {
	
	@Autowired
	private FaceApiService faceApiService;
	
	public Pagination<MatchStyle> faceMatchStyle(PageParam page, JSONObject face){
		ImageSearch images = new ImageSearch();
		images.setImages(face.getString("images"));
		images.setImageType(face.getString("imageType"));
		images.setGroupIdList(face.getString("groupIdList"));
		images.setMaxUsernum(face.getString("maxUsernum"));
		logger.debug("MatchStyleServiceImpl faceMatchStyle:{}", JSONObject.toJSONString(images));
		List<String> idList = faceApiService.faceSearchImage(images);
		Map<String, Object> params = Maps.newHashMap();
		params.put("idList", (ObjectUtils.isEmpty(idList)) ? new String[] {"0"} : idList);
		return queryPage(page, params);
	}
}
