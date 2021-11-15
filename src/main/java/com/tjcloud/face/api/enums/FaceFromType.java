package com.tjcloud.face.api.enums;

/**
 * 人脸库类型：0-租户，1-场馆，2-区域
 *
 */
public enum FaceFromType {
	
		FROM_TENANT ("租户", 0),
		FROM_STADIUM ("场馆", 1),
		FROM_AREA ("区域", 2),;
		
		private final String text;
		private final int status;

		private FaceFromType(String text, int status)
		{
			this.text = text;
			this.status = status;
		}

		public String getText()
		{
			return text;
		}

		public int getStatus()
		{
			return status;
		}

		public static String getText(int status)
		{
			for (FaceFromType e : FaceFromType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
