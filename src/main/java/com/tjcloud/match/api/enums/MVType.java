package com.tjcloud.match.api.enums;

/**
 * 0-图片，1-视频
 */
public enum MVType {
	
		IMAGE ("图片", 0),
		VIDEO ("视频", 1),;
		
		private final String text;
		private final int status;

		private MVType(String text, int status)
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
			for (MVType e : MVType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
