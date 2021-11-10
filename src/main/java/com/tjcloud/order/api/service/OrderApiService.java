package com.tjcloud.order.api.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.order.api.vo.CreateTrainOrderVO;

public interface OrderApiService{

	/**
	 * 创建培训订单
	 * @param orderVO
	 * @return
	 */
	JSONObject createTrainOrder(CreateTrainOrderVO orderVO);

}
