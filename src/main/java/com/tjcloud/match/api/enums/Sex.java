package com.tjcloud.match.api.enums;

/**
 * 性别(0-女,1-男,2-混合)
 * @author TJ_zhoupf
 *
 */
public enum Sex {
	
		WOMAN ("女", 0),
		MAN ("男", 1),;
		
		private final String text;
		private final int status;

		private Sex(String text, int status)
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
			for (Sex e : Sex.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
