package com.tjcloud.stadium.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.stadium.api.vo.StadiumItemOpeningTimeVO;

/**
 * 场馆项目设定保存时，保证至少有：2条正常营业时间记录，即always=true,dateType=1和always=true,dateType=2的记录。弹出提醒【注意：至少输入一个节假日（或工作日）营业时间，否则系统将不生成节假日（或工作日）的订场资源】(stadium_item_openingtime)
 * @author auto bin.yin 2016.06.28
 */
@LogRequired
public class StadiumItemOpeningtime extends AbstractEntity {
	private static final long serialVersionUID = 1467103889028L;

	private String stadiumItemId; //项目Id
	private Boolean always; //一直生效，用于标示正常营业时间true和临时营业时间false
	private Long beginEffectDate; //生效开始日期
	private Long endEffectDate; //生效结束日期
	private Boolean active; //激活,后台，TRUE
	private List<StadiumItemOpeningtimeDay> dayList;

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public Boolean getAlways() {
		return this.always;
	}
	public void setAlways(Boolean always) {
		this.always = always;
	}

	public Long getBeginEffectDate() {
		return this.beginEffectDate;
	}
	public void setBeginEffectDate(Long beginEffectDate) {
		this.beginEffectDate = beginEffectDate;
	}

	public Long getEndEffectDate() {
		return this.endEffectDate;
	}
	public void setEndEffectDate(Long endEffectDate) {
		this.endEffectDate = endEffectDate;
	}

	public Boolean getActive() {
		return this.active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public StadiumItemOpeningTimeVO getStadiumItemOpeningTimeVO(){
		StadiumItemOpeningTimeVO stadiumItemOpeningTimeVO = new StadiumItemOpeningTimeVO();
//		stadiumItemOpeningTimeVO.setId(super.getId());
		stadiumItemOpeningTimeVO.setAlways(always);
		if(!always) {
			stadiumItemOpeningTimeVO.setBeginEffecDate(DateUtils.formatDate(beginEffectDate, "yyyy-MM-dd"));
			stadiumItemOpeningTimeVO.setEndEffecDate(DateUtils.formatDate(endEffectDate, "yyyy-MM-dd"));
		}
		stadiumItemOpeningTimeVO.setStadiumItemId(stadiumItemId);
		stadiumItemOpeningTimeVO.setId(getId());
		return stadiumItemOpeningTimeVO;
	}

	public List<StadiumItemOpeningtimeDay> getDayList() {
		return this.dayList;
	}

	public void setDayList(List<StadiumItemOpeningtimeDay> dayList) {
		this.dayList = dayList;
	}
}