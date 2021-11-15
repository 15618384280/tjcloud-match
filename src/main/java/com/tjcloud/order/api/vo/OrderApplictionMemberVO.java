package com.tjcloud.order.api.vo;

import com.tjcloud.core.entity.AbstractEntity;

public class OrderApplictionMemberVO extends AbstractEntity{

    /**
     *
     */
    private static final long serialVersionUID = -1286820036236486058L;
    /**
     *
     */
    private String phone;        					//电话
    private String userName;     					//用户名
    private String idCard;	     					//身份证
    private String memberId;     					// 会员id
    private String fee;		     					// 其他费用   工本费
    private String cardNo;		 					// 卡号
    private String insideNo;      					//会员卡内卡号码
    private String cardCategoryId; 					//场馆卡号
    private String cardHeadURL;						// 背景图
    private String expiryDate;						//时间期至         2019-05-22 这种
    private String DurationDays;                    // 有效数        如几个月
    private String ruleId;							//充值规则

    private int operationalStatus;				//操作状态  (0:办卡 ，1:充值 ，2:续费)
    private String memberCardId;

    private String detailedType;               //方法type(0,1,2)

    public String getDetailedType() {
        return detailedType;
    }
    public void setDetailedType(String detailedType) {
        this.detailedType = detailedType;
    }
    public String getMemberCardId() {
        return memberCardId;
    }
    public void setMemberCardId(String memberCardId) {
        this.memberCardId = memberCardId;
    }
    public int getOperationalStatus() {
        return operationalStatus;
    }
    public void setOperationalStatus(int operationalStatus) {
        this.operationalStatus = operationalStatus;
    }
    public String getRuleId() {
        return ruleId;
    }
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getDurationDays() {
        return DurationDays;
    }
    public void setDurationDays(String durationDays) {
        DurationDays = durationDays;
    }
    public String getCardHeadURL() {
        return cardHeadURL;
    }
    public void setCardHeadURL(String cardHeadURL) {
        this.cardHeadURL = cardHeadURL;
    }


    public String getCardCategoryId() {
        return cardCategoryId;
    }
    public void setCardCategoryId(String cardCategoryId) {
        this.cardCategoryId = cardCategoryId;
    }
    public String getInsideNo() {
        return insideNo;
    }
    public void setInsideNo(String insideNo) {
        this.insideNo = insideNo;
    }
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getFee() {
        return fee;
    }
    public void setFee(String fee) {
        this.fee = fee;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

}
