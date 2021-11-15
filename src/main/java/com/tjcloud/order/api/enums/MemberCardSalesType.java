package com.tjcloud.order.api.enums;

public enum MemberCardSalesType {
		NEW_CARD("办卡", 1),
		RENEWAL("充值", 2),
		RECHARGE("续卡", 3),
		REPAIR("补卡", 4),
		ENVELOP("封卡", 5);

		private final String text;
		private final int status;

		private MemberCardSalesType(String text, int status)
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
			for (MemberCardSalesType e : MemberCardSalesType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
