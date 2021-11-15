package com.tjcloud.order.api.enums;

/**
 * 状态：0-终止、1-生效
 * @author TJ_zhoupf
 *
 */
public enum LongOrderRuleStatus {
	
		STOPS("终止", 0),
		VALID("生效", 1),;
		
		private final String text;
		private final int status;

		private LongOrderRuleStatus(String text, int status)
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
			for (LongOrderRuleStatus e : LongOrderRuleStatus.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
