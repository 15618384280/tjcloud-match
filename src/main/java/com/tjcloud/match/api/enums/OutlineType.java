package com.tjcloud.match.api.enums;

/**
 * 赛事自定义文本域:1-赛事概要、2-赛事申明、3-赛事科目概要、4-赛事科目申明
 * @author TJ_zhoupf
 *
 */
public enum OutlineType {
	
		MATCH_SUMMARY ("赛事概要", 1),
		MATCH_STATEMENT ("赛事申明", 2),
		MATCH_SUBJECT_SUMMARY ("赛事科目概要", 3),
		MATCH_SUBJECT_STATEMENT ("赛事科目申明", 4),
		MATCH_WEBHTML ("赛事官网", 5),
		MATCH_SUBJECT_WEBHTML ("赛事科目官网", 6),
		MATCH_GRADE ("赛事成绩", 7),
		MATCH_SUBJECT_GRADE ("赛事科目成绩", 8),
		MATCH_LEAD_CONTENT ("领物", 9),
		MATCH_WCOMPETITION_RULES ("竞赛规程", 10),
		MATCH_STARTING_POINT_LAYOUT ("起点布局", 11),
		MATCH_TRAFFIC_GUIDANCE ("交通指南", 12),
		MATCH_INCENTIVES_TO ("奖励办法", 13);
		
		private final String text;
		private final int status;

		private OutlineType(String text, int status)
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
			for (OutlineType e : OutlineType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
