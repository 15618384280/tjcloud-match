package com.tjcloud.stadium.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.StadiumItemOpeningTimeDayVO;

/**
 * 场馆营业时间关联表(stadium_item_openingtime_day)
 * @author auto bin.yin 2016.06.28
 */
@LogRequired
public class StadiumItemOpeningtimeDay extends AbstractEntity {
	private static final long serialVersionUID = 1467103891833L;

	private String openingTimeId; //场馆营业时间Id
	private Integer dayOfWeek; //1-7周一到周日,并且还有8-法定假日,9-双休日调班
	private List<StadiumItemOpeningtimeDate> dateList;

	public String getOpeningTimeId() {
		return this.openingTimeId;
	}
	public void setOpeningTimeId(String openingTimeId) {
		this.openingTimeId = openingTimeId;
	}

	public Integer getDayOfWeek() {
		return this.dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public StadiumItemOpeningTimeDayVO getStadiumItemOpeningTimeDayVO(){
		StadiumItemOpeningTimeDayVO stadiumItemOpeningTimeDayVO = new StadiumItemOpeningTimeDayVO();
		stadiumItemOpeningTimeDayVO.setId(getId());
		stadiumItemOpeningTimeDayVO.setDayOfWeek(dayOfWeek);
		stadiumItemOpeningTimeDayVO.setOpeningId(openingTimeId);
		return stadiumItemOpeningTimeDayVO;
	}

	public List<StadiumItemOpeningtimeDate> getDateList() {
		return this.dateList;
	}

	public void setDateList(List<StadiumItemOpeningtimeDate> dateList) {
		this.dateList = dateList;
	}
}