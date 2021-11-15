package com.tjcloud.face.api.enums;

public enum FaceLib {
	
		LIB_NO1 ("0", "崇明游泳馆人脸库", "14804106", "jRA0tYEIMf9nwmlz1Gag9CnP", "yiPeF4jyiZ7Qi6dQcOtUgLF5pW42piT3"),
		LIB_NO2 ("58e0b0c9c75411e6a38d0242ac110034", "崇明游泳馆人脸库", "14804106", "jRA0tYEIMf9nwmlz1Gag9CnP", "yiPeF4jyiZ7Qi6dQcOtUgLF5pW42piT3"),
		LIB_NO3 ("2786df5b729411e7854a5cb9018915e0", "崇明游泳馆人脸库", "14804106", "jRA0tYEIMf9nwmlz1Gag9CnP", "yiPeF4jyiZ7Qi6dQcOtUgLF5pW42piT3"),
		LIB_NO4 ("TestGroupId", "公司考勤人脸库", "14804106", "jRA0tYEIMf9nwmlz1Gag9CnP", "yiPeF4jyiZ7Qi6dQcOtUgLF5pW42piT3");
		
		private final String groupId;
		private final String appName;
		private final String appID;
		private final String apiKey;
		private final String secretKey;

		private FaceLib(String groupId, String appName, String appID, String apiKey, String secretKey)
		{
			this.groupId = groupId;
			this.appName = appName;
			this.appID = appID;
			this.apiKey = apiKey;
			this.secretKey = secretKey;
		}

		public static String getAppName(String groupId)
		{
			for (FaceLib e : FaceLib.values())
			{
				if (e.getGroupId().equals(groupId))
				{
					return e.getAppName();
				}
			}
			return "";
		}
		
		public static String getAppID(String groupId)
		{
			for (FaceLib e : FaceLib.values())
			{
				if (e.getGroupId().equals(groupId))
				{
					return e.getAppID();
				}
			}
			return "";
		}
		
		public static String getApiKey(String groupId)
		{
			for (FaceLib e : FaceLib.values())
			{
				if (e.getGroupId().equals(groupId))
				{
					return e.getApiKey();
				}
			}
			return "";
		}
		
		public static String getSecretKey(String groupId)
		{
			for (FaceLib e : FaceLib.values())
			{
				if (e.getGroupId().equals(groupId))
				{
					return e.getSecretKey();
				}
			}
			return "";
		}

		public String getGroupId() {
			return groupId;
		}

		public String getAppName() {
			return appName;
		}

		public String getAppID() {
			return appID;
		}

		public String getApiKey() {
			return apiKey;
		}

		public String getSecretKey() {
			return secretKey;
		}
		
		
}
