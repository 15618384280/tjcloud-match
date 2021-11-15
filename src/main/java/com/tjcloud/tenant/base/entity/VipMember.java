package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
/**
 * vip会员表(vip_member)
 * @author auto bin.yin 2016.06.30
 */
public class VipMember extends AbstractEntity {

    private static final long serialVersionUID = 3385260738180943285L;
    private String userId; 				// 绑定的用户Id
    private String phone;               // 绑定用户的手机号
    private Integer openStatus;         // 开通状态 （0-未开通，1-已开通，2-已过期）
    private Long valBeginTime;		// 有效期开始时间
    private Long valEndTime;  		// 有效期结束时间
    private int cancelAllTimeNum;          // 退订总次数
    private int remainTimeNum;          // 剩余次数
    private int openTimes;             //开通次数
    private Long allRechargeAmount;    //累计充值金额
    private String openEndTime;    //末次开通时间
    private Long endAmount;         //末次付费金额

    public Long getAllRechargeAmount() {
        return allRechargeAmount;
    }

    public void setAllRechargeAmount(Long allRechargeAmount) {
        this.allRechargeAmount = allRechargeAmount;
    }

    public String getOpenEndTime() {
        return openEndTime;
    }

    public void setOpenEndTime(String openEndTime) {
        this.openEndTime = openEndTime;
    }

    public Long getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(Long endAmount) {
        this.endAmount = endAmount;
    }

    public int getOpenTimes() {
        return openTimes;
    }

    public void setOpenTimes(int openTimes) {
        this.openTimes = openTimes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Integer openStatus) {
        this.openStatus = openStatus;
    }

    public Long getValBeginTime() {
        return valBeginTime;
    }

    public void setValBeginTime(Long valBeginTime) {
        this.valBeginTime = valBeginTime;
    }

    public Long getValEndTime() {
        return valEndTime;
    }

    public void setValEndTime(Long valEndTime) {
        this.valEndTime = valEndTime;
    }

    public int getCancelAllTimeNum() {
        return cancelAllTimeNum;
    }

    public void setCancelAllTimeNum(int cancelAllTimeNum) {
        this.cancelAllTimeNum = cancelAllTimeNum;
    }

    public int getRemainTimeNum() {
        return remainTimeNum;
    }

    public void setRemainTimeNum(int remainTimeNum) {
        this.remainTimeNum = remainTimeNum;
    }
}
