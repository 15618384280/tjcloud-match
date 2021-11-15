package com.tjcloud.match.api.enums;

/**
 * 状态（0-保存,1-报名中,2-报名截止,3-比赛中,4-已结束,5-已删除）
 * @author TJ_zhoupf
 *
 */
public enum MatchState {
	
		MATCH_STATE_SAVE ("保存", 0),
		MATCH_STATE_SIGN ("报名中", 1),
		MATCH_STATE_CLOSE ("报名截止", 2),
		MATCH_STATE_BEING ("比赛中", 3),
		MATCH_STATE_END ("已结束", 4),
		MATCH_STATE_REMOVE ("已删除", 5),;
		
		private final String text;
		private final int status;

		private MatchState(String text, int status)
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
			for (MatchState e : MatchState.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
