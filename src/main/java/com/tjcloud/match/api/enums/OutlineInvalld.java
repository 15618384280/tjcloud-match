package com.tjcloud.match.api.enums;

/**
 * 是否有效:0-有效、1-失效
 * @author TJ_zhoupf
 *
 */
public enum OutlineInvalld {
	
		OUTLINE_NOT_INVALLD  ("有效", 0),
		OUTLINE_IS_INVALLD ("失效", 1),;
		
		private final String text;
		private final int status;

		private OutlineInvalld(String text, int status)
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
			for (OutlineInvalld e : OutlineInvalld.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
