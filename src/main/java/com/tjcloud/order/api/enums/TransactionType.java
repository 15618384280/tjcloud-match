package com.tjcloud.order.api.enums;

/**
 * 交易类型: 1-收入、2-支出
 * @author TJ_zhoupf
 *
 */
public enum TransactionType {
	
		INCOME ("收入", 1),
		COST ("支出", 2),;
		
		private final String text;
		private final int status;

		private TransactionType(String text, int status)
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
			for (TransactionType e : TransactionType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
