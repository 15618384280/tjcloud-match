package com.tjcloud.face.api.enums;

public enum FaceErrorCode {
	
		OPERATION_IS_SUCCESSFUL ("0", "Operation is successful", "操作成功"),
		
		ACCESS_TOKEN_INVALID ("110", "Access token invalid or no longer valid", "token失效"),
		
		OPEN_API_REQUEST_LIMIT_REACHED ("4", "Open api request limit reached", "集群超限额"),
		
		PARAM_FORMAT_ERROR ("222030", "param[match_threshold] format error", "参数格式错误"),
	
		IMAGE_CHECK_FAIL ("222203", "image check fail", "请上传含有人脸的照片"),

		USER_IS_NOT_EXIST ("223103", "user is not exist", "找不到该用户"),
	
		PIC_NOT_HAS_FACE ("222202", "pic not has face", "图片中没有人脸");
	
	
		
		private final String code;
		private final String error;
		private final String message;

		private FaceErrorCode(String code, String error, String message)
		{
			this.code = code;
			this.error = error;
			this.message = message;
		}

		public static String getMessage(String code)
		{
			for (FaceErrorCode e : FaceErrorCode.values())
			{
				if (e.getCode().equals(code))
				{
					return e.getMessage();
				}
			}
			return "";
		}
		
		public String getCode() {
			return code;
		}

		public String getError() {
			return error;
		}

		public String getMessage() {
			return message;
		}
		
}
