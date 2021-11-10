package com.tjcloud.match.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.dd.base.service.CityService;
import com.tjcloud.match.api.enums.MatchState;
import com.tjcloud.match.base.dao.MatchInfoDao;
import com.tjcloud.match.base.entity.MatchInfo;
import com.tjcloud.match.base.service.MatchInfoService;
import com.tjcloud.match.base.service.MatchSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service("matchInfoService")
public class MatchInfoServiceImpl extends AbstractIbatisServiceImpl<MatchInfoDao, MatchInfo, String> implements MatchInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(MatchInfoServiceImpl.class);

	@Autowired
	private CityService cityService;
	
	@Autowired
	private MatchSubjectService matchSubjectService;
	
	public MatchInfo setMatchSubjectSignCount(String matchId,Object...objects){
		MatchInfo matchInfoEmpty = null;
		if(ObjectUtils.isEmpty(objects)){
			matchInfoEmpty = getDao().get(matchId);
		}else{
			for (Object object : objects) {
				if(object instanceof MatchInfo){
					matchInfoEmpty = (MatchInfo) object;
				}
			}
			if(ObjectUtils.isEmpty(matchInfoEmpty)){
				matchInfoEmpty = getDao().get(matchId);
			}
		}
		//统计赛事科目的最大报名人数、报名人数
		Map<String, Object> paramMap = Maps.newHashMap();
		paramMap.put("matchId", matchId);
//		paramMap.put("state", MatchSubjectState.MATCH_STATE_SIGN.getStatus());
		Map<String, Object> numMap = matchSubjectService.sumMatchSubjectSignCount(paramMap);
		if(!ObjectUtils.isEmpty(numMap)){
			matchInfoEmpty.setMaxNum((numMap.get("maxNum") == null) ? 0 : Integer.valueOf(numMap.get("maxNum").toString()));
			matchInfoEmpty.setSignCount((numMap.get("signCount") == null) ? 0 : Integer.valueOf(numMap.get("signCount").toString()));
			matchInfoEmpty.setShamCount((numMap.get("shamCount") == null) ? 0 : Integer.valueOf(numMap.get("shamCount").toString()));
		}
		getDao().update(matchInfoEmpty);
		return matchInfoEmpty;
	}
	
	/**
	 * 定时更改赛事状态
	 * @return
	 */
	@Override
	public void changeMatchStateSchedule() throws BusinessException {
			Map<String,Object> param = Maps.newHashMap();
	        param.put("stateList", new Integer[]{MatchState.MATCH_STATE_SAVE.getStatus(),
	        									 MatchState.MATCH_STATE_SIGN.getStatus(),
	        								     MatchState.MATCH_STATE_BEING.getStatus(),
	        								     MatchState.MATCH_STATE_CLOSE.getStatus()
	        								     });
	        List<MatchInfo> matchlist  = findBy(param);
	        BigDecimal time = new BigDecimal(System.currentTimeMillis()); 						//系统当前时间
	        for (MatchInfo matchInfo : matchlist) {
	        	logger.debug("~~~~~赛事信息如： {}", JSON.toJSONString(matchInfo));
	        	try {
	        		BigDecimal upStartTime = new BigDecimal(matchInfo.getUpStartTime()); 			//赛事报名开始时间
	        		BigDecimal upEndTime = new BigDecimal(matchInfo.getUpEndTime()); 				//赛事报名结束时间
	        		BigDecimal startTime = new BigDecimal(matchInfo.getStartTime()); 				//赛事开始时间
	        		BigDecimal endTime =  new BigDecimal(matchInfo.getEndTime());					//赛事结束时间
	        		switch (matchInfo.getState().intValue()) {
	        		case 0://保存
	        			if(upStartTime.compareTo(time)<0){//当前时间大于赛事报名开始时间改为：报名中
	        				matchInfo.setState(MatchState.MATCH_STATE_SIGN.getStatus());
	        			}
	        			break;
	        		case 1://报名中
	        			if(upStartTime.compareTo(time)>0){//当前时间小于赛事报名开始时间改为：保存中
	        				matchInfo.setState(MatchState.MATCH_STATE_SAVE.getStatus());
	        			}
	        			if(endTime.compareTo(time)<0){//当前时间大于赛事结束时间改为：已结束
	        				matchInfo.setState(MatchState.MATCH_STATE_END.getStatus());
	        			}else if(startTime.compareTo(time)<0){//当前时间大于赛事开始时间改为：比赛中
	        				matchInfo.setState(MatchState.MATCH_STATE_BEING.getStatus());
	        			}else if(upEndTime.compareTo(time)<0){//当前时间大于赛事报名结束时间改为：报名截止
	        				matchInfo.setState(MatchState.MATCH_STATE_CLOSE.getStatus());
	        			}else{
	        				//查询报名人数
	                    	if(matchInfo.getMaxNum().intValue() <= matchInfo.getSignCount().intValue()){
	                    		matchInfo.setState(MatchState.MATCH_STATE_CLOSE.getStatus());
	                    	}
	        			}
	        			break;
	        		case 2://报名截止
	        			if(endTime.compareTo(time)<0){//当前时间大于赛事结束时间改为：已结束
	        				matchInfo.setState(MatchState.MATCH_STATE_END.getStatus());
	        			}else if(startTime.compareTo(time)<0){//当前时间大于赛事开始时间改为：比赛中
	        				matchInfo.setState(MatchState.MATCH_STATE_BEING.getStatus());
	        			}else{
	        				if(upStartTime.compareTo(time)<0 && upEndTime.compareTo(time)>0){//当前时间大于赛事报名开始时间改为：报名中
	        					//查询报名人数
		                    	if(matchInfo.getMaxNum().intValue() > matchInfo.getSignCount().intValue()){
		                    		matchInfo.setState(MatchState.MATCH_STATE_SIGN.getStatus());
		                    	}
	        				}
	        			}
	        			break;
	        		case 3://比赛中
	        			if(endTime.compareTo(time)<0){//当前时间大于赛事结束时间改为：已结束
	        				matchInfo.setState(MatchState.MATCH_STATE_END.getStatus());
	        			}
	        			break;
	        		}
	        		modify(matchInfo);
	        		logger.debug("~~~~~ 定时修改赛事状态成功，赛事信息如： {}", JSON.toJSONString(matchInfo));
				} catch (Exception e) {
					logger.error("~~~~~ 定时修改赛事状态异常，赛事信息如： {}", JSON.toJSONString(matchInfo),e.getMessage());
				}
			}
	}

	@Override
	public List<JSONObject> findMatchCities() {
		//将场地所在的城市code查询出来
		List<String> cityCodes = getDao().findMatchCities();
		//查询城市信息
		List<JSONObject> cityInfo = cityService.findByCityNames(cityCodes);
		return cityInfo;
	}

	@Override
	public int findCountAllMatch(Map<String, Object> countMap) {
		int findCountAllMatch = getDao().findCountAllMatch(countMap);
		return findCountAllMatch;
	}

	@Override
	public List<Map> findSigninCount(Map<String, Object> countMap) {
		List<Map> findSigninCount = getDao().findSigninCount(countMap);
		return findSigninCount;
	}
}
