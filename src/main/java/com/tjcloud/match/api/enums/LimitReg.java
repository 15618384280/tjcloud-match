package com.tjcloud.match.api.enums;

/**
 * 报名限制：0-不限制，1-一个赛事允许报名一次，2-一个科目允许报名一次
 * @author TJ_zhoupf
 *
 */
public enum LimitReg {
	
		MATCH_NO_LIMIT ("不限制", 0),
		MATCH_ALLOW_ONCE ("一个赛事允许报名一次", 1),
		SUBJECT_ALLOW_ONCE ("一个科目允许报名一次", 2);
		
		private final String text;
		private final int status;

		private LimitReg(String text, int status)
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
			for (LimitReg e : LimitReg.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
