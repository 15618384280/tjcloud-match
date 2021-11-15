package com.tjcloud.match.api.enums;

/**
 * 团队性别(0-女,1-男,2-混合)
 * @author TJ_zhoupf
 *
 */
public enum TeamSex {
	
		WOMAN ("女", 0),
		MAN ("男", 1),
		BLEND ("混合", 2),;
		
		private final String text;
		private final int status;

		private TeamSex(String text, int status)
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
			for (TeamSex e : TeamSex.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
