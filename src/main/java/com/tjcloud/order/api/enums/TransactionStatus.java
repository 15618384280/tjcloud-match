package com.tjcloud.order.api.enums;

/**
 * 交易状态: 1-交易中、2-交易成功、3-交易失败、8-交易超时、9-交易作废(场景用户点击付款后取消，然后15分钟后订单自动取消，这时需要作废交易，并且MQ异步给支付平台发送取消交易)
 * @author TJ_zhoupf
 *
 */
public enum TransactionStatus {
	
		DEAL_BEING ("交易中", 1),
		DEAL_SUCCESS("交易成功", 2),
		DEAL_FAIL("交易失败", 3),
		DEAL_OVERTIME("交易超时", 8),
		DEAL_INVALID ("交易作废", 9);
		
		private final String text;
		private final int status;

		private TransactionStatus(String text, int status)
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
			for (TransactionStatus e : TransactionStatus.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
