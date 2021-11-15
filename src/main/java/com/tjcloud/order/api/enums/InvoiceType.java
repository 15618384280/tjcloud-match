package com.tjcloud.order.api.enums;

/**
 * 发票类型: 0-纸质发票 1-电子发票
 * @author TJ_zhoupf
 *
 */
public enum InvoiceType {
		PAPER("纸质发票", 0),
		ELECTRONIC("电子发票", 1);

		private final String text;
		private final int status;

		private InvoiceType(String text, int status)
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
			for (InvoiceType e : InvoiceType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
