package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 赛事科目表(match_subject)
 * @author auto bin.yin 2016.12.12
 */
public class MatchSubject extends AbstractEntity {
	private static final long serialVersionUID = 1481527808581L;

	private String matchId; 									//赛事Id
	private String subject; 									//科目名称
	private String matchName; 									//赛事名称
	private Integer maxNum; 									//参赛人数/参数队伍数量
	private Integer signCount; 									//已报名人数/已报名团队
	private Integer shamCount; 									//虚假已报名人数/已报名团队
	private Integer expenses;									//报名费
	private Integer type; 										//赛制类型（0-个人,1-团体）
	private Integer teamNumMin; 								//团队报名至少人数(如果人数不为零：校验团队人数才能提交)
	private Integer teamNum; 									//团队报名最多人数(如果人数不为零：校验团队人数才能提交)
	private Long gameTime; 										//比赛开始时间
	private Long gameEndTime; 									//比赛结束时间
	private Long upStartTime; 									//科目报名开始时间
	private Long upEndTime; 									//科目报名结束时间
	private Integer openState; 									//公开状态（0-平台和线下都可见,1-仅线下可见）
	private Integer state; 										//状态（0-保存,1-报名中,2-比赛中,3-已结束,4-报名截止,5-已删除）
	private Integer transfer; 									//名额转让
	private Integer auditing; 									//是否需要审核
	private Boolean mailNotice; 								//报名邮件通知
	private Boolean smsNotice; 									//报名短信通知
	private Integer cancelSingup; 								//是否允许取消报名
	private Boolean checkCardId; 								//身份证校验
	private String promptMessage; 								//报名页面提示信息
	private Integer payMode;									//付款方式（0-免费、1-自费）
	private String tenantId;									//租户Id
	private Boolean systemMatchNo; 								//是否自动生成参赛号码
	private String manMatchNoHead; 								//男性参赛者号码前缀
	private Integer manMatchNoLength; 							//男性参赛者号码数字位数
	private Integer manMatchNoNumber; 							//男性参赛者号码当前数字开始号
	private String womanMatchNoHead; 							//女性参赛者号码前缀
	private Integer womanMatchNoLength; 						//女性参赛者号码数字位数
	private Integer womanMatchNoNumber; 						//女性参赛者号码当前数字开始号
	
	public String getMatchId() {
		return this.matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getMaxNum() {
		return this.maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	public Integer getSignCount() {
		return this.signCount;
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
	public Integer getExpenses() {
		return expenses;
	}
	public void setExpenses(Integer expenses) {
		this.expenses = expenses;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getTeamNum() {
		return teamNum;
	}
	public void setTeamNum(Integer teamNum) {
		this.teamNum = teamNum;
	}
	public Long getGameTime() {
		return this.gameTime;
	}
	public void setGameTime(Long gameTime) {
		this.gameTime = gameTime;
	}
	public Long getGameEndTime() {
		return this.gameEndTime;
	}
	public void setGameEndTime(Long gameEndTime) {
		this.gameEndTime = gameEndTime;
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
	public Integer getOpenState() {
		return this.openState;
	}
	public void setOpenState(Integer openState) {
		this.openState = openState;
	}
	public Integer getState() {
		return this.state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getTransfer() {
		return transfer;
	}
	public void setTransfer(Integer transfer) {
		this.transfer = transfer;
	}
	public Integer getAuditing() {
		return auditing;
	}
	public void setAuditing(Integer auditing) {
		this.auditing = auditing;
	}
	public Boolean getMailNotice() {
		return mailNotice;
	}
	public void setMailNotice(Boolean mailNotice) {
		this.mailNotice = mailNotice;
	}
	public Boolean getSmsNotice() {
		return smsNotice;
	}
	public void setSmsNotice(Boolean smsNotice) {
		this.smsNotice = smsNotice;
	}
	public Integer getCancelSingup() {
		return cancelSingup;
	}
	public void setCancelSingup(Integer cancelSingup) {
		this.cancelSingup = cancelSingup;
	}
	public String getPromptMessage() {
		return promptMessage;
	}
	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}
	public Integer getPayMode() {
		return payMode;
	}
	public void setPayMode(Integer payMode) {
		this.payMode = payMode;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Integer getTeamNumMin() {
		return teamNumMin;
	}
	public void setTeamNumMin(Integer teamNumMin) {
		this.teamNumMin = teamNumMin;
	}
	public Boolean getSystemMatchNo() {
		return systemMatchNo;
	}
	public void setSystemMatchNo(Boolean systemMatchNo) {
		this.systemMatchNo = systemMatchNo;
	}
	public String getManMatchNoHead() {
		return manMatchNoHead;
	}
	public void setManMatchNoHead(String manMatchNoHead) {
		this.manMatchNoHead = manMatchNoHead;
	}
	public Integer getManMatchNoLength() {
		return manMatchNoLength;
	}
	public void setManMatchNoLength(Integer manMatchNoLength) {
		this.manMatchNoLength = manMatchNoLength;
	}
	public Integer getManMatchNoNumber() {
		return manMatchNoNumber;
	}
	public void setManMatchNoNumber(Integer manMatchNoNumber) {
		this.manMatchNoNumber = manMatchNoNumber;
	}
	public String getWomanMatchNoHead() {
		return womanMatchNoHead;
	}
	public void setWomanMatchNoHead(String womanMatchNoHead) {
		this.womanMatchNoHead = womanMatchNoHead;
	}
	public Integer getWomanMatchNoLength() {
		return womanMatchNoLength;
	}
	public void setWomanMatchNoLength(Integer womanMatchNoLength) {
		this.womanMatchNoLength = womanMatchNoLength;
	}
	public Integer getWomanMatchNoNumber() {
		return womanMatchNoNumber;
	}
	public void setWomanMatchNoNumber(Integer womanMatchNoNumber) {
		this.womanMatchNoNumber = womanMatchNoNumber;
	}
	public Boolean getCheckCardId() {
		return checkCardId;
	}
	public void setCheckCardId(Boolean checkCardId) {
		this.checkCardId = checkCardId;
	}
	
}