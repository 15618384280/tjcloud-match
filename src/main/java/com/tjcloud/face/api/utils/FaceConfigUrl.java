package com.tjcloud.face.api.utils;

public class FaceConfigUrl {
	// 百度 API 
	public static final String BAIDUBCE_API_ACCESS_TOKEN_KEY = "BAIDUBCE_API_ACCESS_TOKEN_KEY";
	
	// 赛事poolID
	public static final String MATCH_POOLID = "88e0b0c9c75411e6a38d0242ac110034";
	
	// 人脸属性返回
	public static final String FACE_FIELD = "age,beauty,expression,face_shape,gender,glasses,landmark,race,quality,eye_status,emotion,face_type";
	
	// 游泳健康承若卡poolID
	public static final String SWIM_POOLID = "0cdef1d98d6311e78ebc0242ac110045";
	
	// access_token
	public static final String APP_POOLID = "poolId";
	
	// access_token
    public static final String ACCESS_TOKEN_KEY = "access_token";
    
    // accessToken
    public static final String ACCESS_TOKEN_PARAM = "accessToken";
	
	// 百度 API 
	public static final String FACE_DOMAIN = "https://aip.baidubce.com";
	
	// Access Token获取
	public static final String GET_ACCESS_TOKEN = "/oauth/2.0/token?grant_type=client_credentials&client_id={clientId}&client_secret={clientSecret}";
	
	// 人脸检测 ?access_token={accessToken}
	public static final String POST_FACE_DETECT = "/rest/2.0/face/v3/detect";
	
	// 人脸对比 ?access_token={accessToken}
	public static final String POST_FACE_MATCH = "/rest/2.0/face/v3/match";
	
	// 人脸识别 ?access_token={accessToken}
	public static final String POST_FACE_IDENTIFY = "/rest/2.0/face/v3/identify";
	
	// 创建用户组 ?access_token={accessToken}
	public static final String POST_FACESET_GROUP = "/rest/2.0/face/v3/faceset/group/add";
	
	// 删除用户组 ?access_token={accessToken}
	public static final String POST_DELETE_FACESET_GROUP = "/rest/2.0/face/v3/faceset/group/delete";
	
	// 构建您的人脸库，如会员人脸注册，已有用户补全人脸信息等 ?access_token={accessToken}
	public static final String POST_FACESET_USER_ADD = "/rest/2.0/face/v3/faceset/user/add";
	
	// 人脸删除 ?access_token={accessToken}
	public static final String POST_FACESET_USER_DELETE = "/rest/2.0/face/v3/faceset/user/delete";
	
	// 用于对人脸库中指定用户，更新其下的人脸图像。 ?access_token={accessToken}
	public static final String POST_FACESET_USER_UPDATE = "/rest/2.0/face/v3/faceset/user/update";
	
	// 比对两张图片中人脸的相似度，并返回相似度分值 ?access_token={accessToken}
	public static final String POST_FACESET_MATCH = "/rest/2.0/face/v3/match";
	
	// 人脸搜索 ?access_token={accessToken}
	public static final String POST_FACESET_SEARCH = "/rest/2.0/face/v3/search";
	
	// 身份证识别 ?access_token={accessToken}
	public static final String POST_OCR_IDCARD = "/rest/2.0/ocr/v1/idcard";

	
}
