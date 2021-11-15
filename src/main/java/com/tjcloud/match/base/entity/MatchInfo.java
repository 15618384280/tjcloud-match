package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 赛事主表(match_info)
 * @author auto bin.yin 2016.12.12
 */
public class MatchInfo extends AbstractEntity {
	private static final long serialVersionUID = 1481527808386L;

	private String tenantId; 									//租户Id
	private String matchName; 									//赛事名称
	private Integer maxNum; 									//参赛人数/参数队伍数量
	private Integer signCount; 									//已报名人数/已报名团队
	private Integer shamCount; 									//虚假已报名人数/已报名团队
	private Integer type; 										//赛制类型（0-个人,1-团体）
	private String shortName; 									//赛事短名
	private Long startTime; 									//赛事开始时间
	private Long endTime; 										//赛事结束时间
	private Long upStartTime; 									//赛事报名开始时间
	private Long upEndTime; 									//赛事报名结束时间
	private String matchCity; 									//赛事所在城市
	private String province; 									//省
	private String city; 										//市
	private String area; 										//区
	private String address; 									//详细地址
	private String backgroundHref; 								//赛事展示页面背景图—URL
	private String logoHref; 									//赛事LOGO—URL
	private String gradeUrl; 									//成绩证书图片
	private Integer state; 										//状态（0-保存,1-报名中,2-比赛中,3-已结束,4-报名截止,5-已删除）
	private Integer sortNo; 									//排序
	private String sportTypeCode; 								//运动类型code
	private String sportTypeName; 								//运动类型名称
	private Integer payMode;									//付款方式（0-免费、1-自费）
	private Integer openState; 									//公开状态（0-平台和线下都可见,1-仅线下可见）
	private String achievementHref; 							//成绩图片
	private Integer gradeType; 									//成绩展现类型
	private Integer stylePv; 									//赛事风采访问量
	private Integer limitReg; 									//报名限制：0-不限制，1-一个赛事允许报名一次，2-一个科目允许报名一次
	private String matchStyleUrl; 								//第三方赛事风采链接
	private Boolean isComac; 									//0-不是商飞，1-表示商飞
	private Boolean showHandbook; 									//隐藏、显示电子手册       0-不显示，1-显示

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getMatchName() {
		return this.matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public Integer getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	public Integer getSignCount() {
		return signCount;
	}
	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}
	public Integer getShamCount() {
		return shamCount;
	}
	public void setShamCount(Integer shamCount) {
		this.shamCount = shamCount;
	}
	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Long getStartTime() {
		return this.startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Long getUpStartTime() {
		return this.upStartTime;
	}
	public void setUpStartTime(Long upStartTime) {
		this.upStartTime = upStartTime;
	}
	public Long getUpEndTime() {
		return this.upEndTime;
	}
	public void setUpEndTime(Long upEndTime) {
		this.upEndTime = upEndTime;
	}
	public String getMatchCity() {
		return this.matchCity;
	}
	public void setMatchCity(String matchCity) {
		this.matchCity = matchCity;
	}
	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return this.area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBackgroundHref() {
		return this.backgroundHref;
	}
	public void setBackgroundHref(String backgroundHref) {
		this.backgroundHref = backgroundHref;
	}
	public String getLogoHref() {
		return this.logoHref;
	}
	public void setLogoHref(String logoHref) {
		this.logoHref = logoHref;
	}
	public String getGradeUrl() {
		return gradeUrl;
	}
	public void setGradeUrl(String gradeUrl) {
		this.gradeUrl = gradeUrl;
	}
	public Integer getState() {
		return this.state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	
	public String getSportTypeCode() {
		return sportTypeCode;
	}
	public void setSportTypeCode(String sportTypeCode) {
		this.sportTypeCode = sportTypeCode;
	}
	public String getSportTypeName() {
		return sportTypeName;
	}
	public void setSportTypeName(String sportTypeName) {
		this.sportTypeName = sportTypeName;
	}
	public Integer getPayMode() {
		return payMode;
	}
	public void setPayMode(Integer payMode) {
		this.payMode = payMode;
	}
	public Integer getOpenState() {
		return openState;
	}
	public void setOpenState(Integer openState) {
		this.openState = openState;
	}
	public String getAchievementHref() {
		return achievementHref;
	}
	public void setAchievementHref(String achievementHref) {
		this.achievementHref = achievementHref;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getGradeType() {
		return gradeType;
	}
	public void setGradeType(Integer gradeType) {
		this.gradeType = gradeType;
	}
	public Integer getStylePv() {
		return stylePv;
	}
	public void setStylePv(Integer stylePv) {
		this.stylePv = stylePv;
	}
	public Integer getLimitReg() {
		return limitReg;
	}
	public void setLimitReg(Integer limitReg) {
		this.limitReg = limitReg;
	}
	public Boolean getIsComac() {
		return isComac;
	}
	public void setIsComac(Boolean isComac) {
		this.isComac = isComac;
	}
	public Boolean getShowHandbook() {
		return showHandbook;
	}
	public void setShowHandbook(Boolean showHandbook) {
		this.showHandbook = showHandbook;
	}
	public String getMatchStyleUrl() {
		return matchStyleUrl;
	}
	public void setMatchStyleUrl(String matchStyleUrl) {
		this.matchStyleUrl = matchStyleUrl;
	}
	
}