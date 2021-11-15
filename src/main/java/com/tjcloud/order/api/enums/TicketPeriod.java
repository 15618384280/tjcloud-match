package com.tjcloud.order.api.enums;

/**
 * 日期类型: 0-通用、1-工作日、2-周末
 * @author TJ_zhoupf
 *
 */
public enum TicketPeriod {
	
		COMMON("通用", 0),
		WEEKDAY("工作日", 1),
		WEEKEND("周末", 2);
		
		private final String text;
		private final int status;

		private TicketPeriod(String text, int status)
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
			for (TicketPeriod e : TicketPeriod.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
