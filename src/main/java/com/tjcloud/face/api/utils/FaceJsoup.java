package com.tjcloud.face.api.utils;

import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.utils.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FaceJsoup{
	private static final Logger logger = LoggerFactory.getLogger(FaceJsoup.class);

	@Autowired
	private FaceConst faceConst;
	
	public Connection fillHeaders(Connection connection) {
		connection.header("Accept-Encoding", "gzip, deflate, br");
		connection.header("Accept-Language", "zh-CN,zh;q=0.8");
		connection.header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
		return connection.ignoreContentType(true).timeout(60000);
	}
	
	public String doGet(String url, Map<String, String> params) {
		try {
			Connection connection = Jsoup.connect(setUrl(url, params, false));

			Document result = fillHeaders(connection).get();
			logger.debug(result.text());
			return result.text();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public String doPost(String url, String body, Boolean accessToken) {
		try {
			Connection connection = Jsoup.connect(setUrl(url, null, accessToken));
			if (body != null) {
				connection.requestBody(body);
			}
			
			Document result = fillHeaders(connection).post();
			logger.debug(result.text());
			return result.text();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public String doPost(String url, String body, Map<String, String> params, Boolean accessToken) {
		logger.debug("~~~~~ doPost body info: {}", body);
		try {
			Connection connection = Jsoup.connect(setUrl(url, params, accessToken));
			if (body != null) {
				connection.requestBody(body);
			}
			Document result = fillHeaders(connection).post();
			return result.text();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			Connection connection = Jsoup.connect("https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token=24.a265637e64a551d157472d7b342e4bb2.2592000.1564902854.282335-11455433");
				connection.requestBody("{\"id_card_side\":\"front\",\"image\":\"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\"}");
//				connection.header("Accept-Encoding", "gzip, deflate, br");
//				connection.header("Accept-Language", "zh-CN,zh;q=0.8");
				connection.header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
//				connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
				connection.ignoreContentType(true).timeout(60000);
				
			Document result = connection.post();
			System.out.println(result.text());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private String setUrl(String url, Map<String, String> params, Boolean accessToken){
		 String requertUrl =FaceConfigUrl.FACE_DOMAIN + url;
		 if (params != null) {
			 if(accessToken){
				 String poolId = params.get(FaceConfigUrl.APP_POOLID);
				 if(StringUtils.isNotEmpty(poolId)){
					 requertUrl = requertUrl + "?access_token=" + faceConst.getAccessToken(poolId);
				 }else{
					 throw new BusinessException(MessageLocale.EMPTY_CODE, "参数错误");
				 }
			 }
			 Iterator<String> keys = params.keySet().iterator();
			 while (keys.hasNext()) {
				 String key = keys.next();
				 String pattern = "\\{" + key + "\\}";
				 Pattern ref = Pattern.compile(pattern);
				 Matcher matcher = ref.matcher(requertUrl);
					 requertUrl = matcher.replaceAll(params.get(key));
			 }
		 }
		 logger.debug("~~~~~ BAIDUBC API EXEC URL: {}", requertUrl);
		 return requertUrl;
	}
}