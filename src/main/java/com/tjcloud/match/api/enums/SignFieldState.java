package com.tjcloud.match.api.enums;

/**
 * 状态（0-保存,1-报名中,2-比赛中,3-已结束,4-已删除）
 * @author TJ_zhoupf
 *
 */
public enum SignFieldState {
	
		SIGN_FIELD_STATE_HIDE ("不显示", 0),
		SIGN_FIELD_STATE_SHOW ("显示", 1),
		SIGN_FIELD_STATE_REQUIRED ("显示且必填", 2),;
		
		private final String text;
		private final int status;

		private SignFieldState(String text, int status)
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
			for (SignFieldState e : SignFieldState.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
