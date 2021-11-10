package com.tjcloud.match.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.base.dao.IdentityCardDao;
import com.tjcloud.match.base.entity.IdentityCard;
import com.tjcloud.match.base.service.IdentityCardService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Service("identityCardService")
public class IdentityCardServiceImpl extends AbstractIbatisServiceImpl<IdentityCardDao, IdentityCard, String> implements IdentityCardService {
	
	
	/**
     * 验证身份证
     * @param cardNo
     * @param realName
     * @return
     */
    public IdentityCard verifyIdcardv(String idcard, String name){
    		ValidateUtils.notEmpty(idcard, MessageLocale.EMPTY_CODE, "身份证号码不能为空");
    		ValidateUtils.notEmpty(name, MessageLocale.EMPTY_CODE, "姓名不能为空");
    		Map<String, Object> params = Maps.newHashMap();
    		params.put("idcard", idcard);
    		params.put("name", name);
    		IdentityCard identityCard = findOne(params);
    		if(ObjectUtils.isEmpty(identityCard)){
    			identityCard = new IdentityCard();
    			identityCard.setIdcard(idcard);
			identityCard.setName(name);
    			try {
    				String url = String.format("http://aliyunverifyidcard.haoservice.com/idcard/VerifyIdcardv2?cardNo=%s&realName=%s", idcard, name);
    				Connection connection = Jsoup.connect(url);
    				connection.header("Authorization", "APPCODE 091a854763db4678b2816d4af7b0e886");
    				Document document = connection.get();
    				logger.debug("Verification information of id card info {}", document.text());
    				ValidateUtils.notEmpty(document.text(), MessageLocale.EMPTY_CODE, "身份证校验异常");
    				JSONObject identityJson = JSONObject.parseObject(document.text());
    				JSONObject result = identityJson.getJSONObject("result");
    				Boolean isTrue = result.getBoolean("isok");
    				identityCard.setIsTrue(isTrue);
    				if(identityJson.getInteger("error_code") == BigDecimal.ZERO.intValue()){
    					JSONObject idCardInfor = result.getJSONObject("IdCardInfor");
    					String area = idCardInfor.getString("area");
    					String sex = idCardInfor.getString("sex");
    					String birthday = idCardInfor.getString("birthday");
    					identityCard.setSex(sex);
    					identityCard.setBirthday(birthday);
    					identityCard.setAddress(area);
    				}
    				save(identityCard);
    			} catch (IOException e) {
    				logger.error(e.getMessage(), e);
    				throw new BusinessException(MessageLocale.EMPTY_CODE, "身份证校验异常");
    			}
    		}
    		return identityCard;
    }
}
