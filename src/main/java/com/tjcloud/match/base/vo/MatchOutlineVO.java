package com.tjcloud.match.base.vo;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.match.base.entity.MatchOutline;

import java.util.List;

public class MatchOutlineVO extends MatchOutline{

	private static final long serialVersionUID = 7336958208139986888L;
	
	private List<MapCoordVO> mapCoordVO;

	public List<MapCoordVO> getMapCoordVO() {
		return mapCoordVO;
	}

	public void setMapCoordVO(List<MapCoordVO> mapCoordVO) {
		this.mapCoordVO = mapCoordVO;
		super.setMapCoord((ObjectUtils.isEmpty(this.mapCoordVO)) ? null : JSONObject.toJSONString(this.mapCoordVO));
	}

}
