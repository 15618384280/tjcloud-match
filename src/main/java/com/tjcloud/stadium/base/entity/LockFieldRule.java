package com.tjcloud.stadium.base.entity;
import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.LockFieldRuleVO;

/**
 * 注释(lock_field_rule)
 * @author auto bin.yin 2016.10.10
 */
@LogRequired
public class LockFieldRule extends AbstractEntity {
	private static final long serialVersionUID = 1476095044053L;

	private String beginPeriod; //开始周期
	private String endPeriod; 	//结束日期
	private String beginTime;	//开始时间
	private String endTime;		//结束时间
	private String tenantId; 	//租户ID
	private String stadiumId; 	//场馆ID
	private String stadiumName; //场馆名称
	private String stadiumItemId; 	//子场馆id
	private String stadiumItemName; //子场馆
	private String mobile;			//手机号码
	private String note; //

	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBeginPeriod() {
		return this.beginPeriod;
	}
	public void setBeginPeriod(String beginPeriod) {
		this.beginPeriod = beginPeriod;
	}

	public String getEndPeriod() {
		return this.endPeriod;
	}
	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public LockFieldRule() {
		super();
	}
	
	public LockFieldRule(LockFieldRuleVO lockFieldRuleVO) {
		setId(lockFieldRuleVO.getLockFieldRuleId());
		setTenantId(lockFieldRuleVO.getTenantId());
		setStadiumId(lockFieldRuleVO.getStadiumId());
		setStadiumName(lockFieldRuleVO.getStadiumName());
		setStadiumItemId(lockFieldRuleVO.getStadiumItemId());
		setStadiumItemName(lockFieldRuleVO.getStadiumItemName());
		setBeginPeriod(lockFieldRuleVO.getBeginPeriod());
		setEndPeriod(lockFieldRuleVO.getEndPeriod());
		setBeginTime(lockFieldRuleVO.getBeginTime());
		setEndTime(lockFieldRuleVO.getEndTime());
		setMobile(lockFieldRuleVO.getMobile());
		setNote(lockFieldRuleVO.getNote());
	}
}