package com.tjcloud.match.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.api.enums.MatchSubjectState;
import com.tjcloud.match.api.enums.PaymentStatus;
import com.tjcloud.match.api.enums.Sex;
import com.tjcloud.match.base.dao.MatchSubjectDao;
import com.tjcloud.match.base.entity.MatchSubject;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.service.MatchSubjectService;
import com.tjcloud.match.base.service.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service("matchSubjectService")
public class MatchSubjectServiceImpl extends AbstractIbatisServiceImpl<MatchSubjectDao, MatchSubject, String> implements MatchSubjectService {

	@Autowired
	private SignRecordService signRecordService;
	
	@Override
	public Map<String,Object> sumMatchSubjectSignCount(Map<String,Object> param){
		return getDao().sumMatchSubjectSignCount(param);
	}
	
	/**
	 * 定时更改赛事科目状态
	 * @return
	 */
	@Override
	public void changeMatchSubjectStateSchedule() throws BusinessException {
			Map<String,Object> param = Maps.newHashMap();
	        param.put("stateList", new Integer[]{MatchSubjectState.MATCH_STATE_SAVE.getStatus(),
								        		 MatchSubjectState.MATCH_STATE_SIGN.getStatus(),
								        		 MatchSubjectState.MATCH_STATE_BEING.getStatus(),
								        		 MatchSubjectState.MATCH_STATE_CLOSE.getStatus()
	        								     });
	        List<MatchSubject> matchSubjectlist  = findBy(param);
	        BigDecimal time = new BigDecimal(System.currentTimeMillis()); 					//系统当前时间
	        for (MatchSubject matchSubject : matchSubjectlist) {
	        	logger.debug("~~~~~赛事科目信息如： {}", JSON.toJSONString(matchSubject));
	        	try {
	        		BigDecimal upStartTime = new BigDecimal(matchSubject.getUpStartTime()); 			//赛事报名开始时间
	        		BigDecimal upEndTime = new BigDecimal(matchSubject.getUpEndTime()); 				//赛事报名结束时间
	        		BigDecimal startTime = new BigDecimal(matchSubject.getGameTime()); 					//赛事开始时间
	        		BigDecimal endTime =  new BigDecimal(matchSubject.getGameEndTime());				//赛事结束时间
	        		switch (matchSubject.getState().intValue()) {
	        		case 0://保存
	        			if(upStartTime.compareTo(time)<0){//当前时间大于赛事科目报名开始时间改为：报名中
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_SIGN.getStatus());
	        			}
	        			break;
	        		case 1://报名中
	        			if(upStartTime.compareTo(time)>0){//当前时间小于赛事报名开始时间改为：保存中
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_SAVE.getStatus());
	        			}
	        			if(endTime.compareTo(time)<0){//当前时间大于赛事科目结束时间改为：已结束
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_END.getStatus());
	        			}else if(startTime.compareTo(time)<0){//当前时间大于赛事科目开始时间改为：比赛中
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_BEING.getStatus());
	        			}else if(upEndTime.compareTo(time)<0){//当前时间大于赛事科目报名结束时间改为：报名截止
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_CLOSE.getStatus());
	        			}else{
	                    	if(matchSubject.getMaxNum().intValue() <= matchSubject.getSignCount().intValue()){
	                    		matchSubject.setState(MatchSubjectState.MATCH_STATE_CLOSE.getStatus());
	                    	}
	        			}
	        			break;
	        		case 2://报名截止
	        			if(endTime.compareTo(time)<0){//当前时间大于赛事科目结束时间改为：已结束
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_END.getStatus());
	        			}else if(startTime.compareTo(time)<0){//当前时间大于赛事科目开始时间改为：比赛中
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_BEING.getStatus());
	        			}else{
	        				if(upStartTime.compareTo(time)<0 && upEndTime.compareTo(time)>0){//当前时间大于赛事报名开始时间改为：报名中
	        					if(matchSubject.getMaxNum().intValue() > matchSubject.getSignCount().intValue()){
	        						matchSubject.setState(MatchSubjectState.MATCH_STATE_SIGN.getStatus());
	        					}
	        				}
	        			}
	        			break;
	        		case 3://比赛中
	        			if(endTime.compareTo(time)<0){//当前时间大于赛事科目结束时间改为：已结束
	        				matchSubject.setState(MatchSubjectState.MATCH_STATE_END.getStatus());
	        			}
	        			break;
	        		}
	        		modify(matchSubject);
	        		//报名截止生成参赛号码
	        		if(matchSubject.getState().intValue() == MatchSubjectState.MATCH_STATE_CLOSE.getStatus()){
	        			systemMatchNo(matchSubject);
	        		}
				} catch (Exception e) {
					logger.error("~~~~~ 定时修改赛事科目状态异常，赛事科目信息如： {}", JSON.toJSONString(matchSubject),e.getMessage());
				}
			}
	}
	
	/**
	 * 生成参赛号码
	 * @return
	 */
	@Override
	public void systemMatchNo(MatchSubject matchSubject) throws BusinessException {
		if( StringUtils.isNotEmpty(matchSubject.getManMatchNoHead())
		 && StringUtils.isNotEmpty(matchSubject.getWomanMatchNoHead())
		 && matchSubject.getManMatchNoLength().intValue() > 0
		 && matchSubject.getWomanMatchNoLength().intValue() > 0
		 && matchSubject.getManMatchNoNumber().intValue() > 0
		 && matchSubject.getWomanMatchNoNumber().intValue() > 0
		){
			PageParam page = new PageParam();
			page.setPageNo(1);
			page.setPageSize(25);
			JSONObject param = new JSONObject();
			param.put("subjectId", matchSubject.getId());
			param.put("matchNoIsNull", true);
			List<Integer> payments = Lists.newArrayList();
			payments.add(PaymentStatus.PAID.getStatus());
			payments.add(PaymentStatus.IMPORT.getStatus());
			payments.add(PaymentStatus.PAYMENT_LINE.getStatus());
			param.put("payments", payments);
			param.put("timeDesc", true);
			Pagination<SignRecord> dataList = signRecordService.queryPage(page, param);
			if(dataList.getPageCount() > BigDecimal.ZERO.intValue()){
				if(matchSubject.getSystemMatchNo()){
					for (SignRecord signRecord : dataList.getDataList()) {
						setMatchNo(param, signRecord, matchSubject);
					}
				}
			}
		}
	}
	
	/**
	 * 生成报名参赛号码
	 * @param param
	 * @param dataList
	 * @param matchno
	 * @param formatHead
	 * @param formatLength
	 */
	@Transactional
	public void setMatchNo(JSONObject param, SignRecord signRecord, MatchSubject matchSubject){
		if(
				PaymentStatus.PAID.getStatus() == signRecord.getPayment()
			||	PaymentStatus.IMPORT.getStatus() == signRecord.getPayment()
			||	PaymentStatus.PAYMENT_LINE.getStatus() == signRecord.getPayment()
		){
			Integer matchno = 0;
			Integer formatLength = 0;
			String formatHead = "";
			if(Sex.MAN.getStatus() == signRecord.getSex().intValue()){
				matchno = matchSubject.getManMatchNoNumber();
				formatHead = matchSubject.getManMatchNoHead();
				formatLength = matchSubject.getManMatchNoLength();
			}else if(Sex.WOMAN.getStatus() == signRecord.getSex().intValue()){
				matchno = matchSubject.getWomanMatchNoNumber();
				formatHead = matchSubject.getWomanMatchNoHead();
				formatLength = matchSubject.getWomanMatchNoLength();
			}
			SignRecord existSignRecord = null;
			String newString = null;
			do {
				matchno ++;
				if("4".equals(matchno.toString().substring(matchno.toString().length()-1, matchno.toString().length()))){
					matchno ++;
				}
				newString = formatHead + String.format("%0"+ formatLength +"d", matchno.intValue());  
				param.put("matchNo", newString);
				param.put("matchNoIsNull", null);
				existSignRecord = signRecordService.findOne(param);
			} while (!ObjectUtils.isEmpty(existSignRecord));
			signRecord.setMatchNo(newString);
			signRecordService.modify(signRecord);
			if(Sex.MAN.getStatus() == signRecord.getSex().intValue()){
				matchSubject.setManMatchNoNumber(matchno);
			}else if(Sex.WOMAN.getStatus() == signRecord.getSex().intValue()){
				matchSubject.setWomanMatchNoNumber(matchno);
			}
			modify(matchSubject);
		}
    }
	
}
