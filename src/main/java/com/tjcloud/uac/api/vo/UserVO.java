package com.tjcloud.uac.api.vo;

import java.io.Serializable;

import com.tjcloud.uac.base.entity.Account;
import com.tjcloud.uac.base.entity.UserCertificationHf;

/**
 * Created by gaojian on 2016/8/4.
 */
public class UserVO implements Serializable {
    private static final long serialVersionUID = 2793928245728045549L;

    private String id;
    private String name;    //名称
    private String idCard;    //身份证
    private String avatar;
    private String channel;
    private String birthday;
    private String nickname;        //昵称
    private String username;        //用户名
    private String gender;          //性别
    private String email;           //邮箱
    private String mobile;          //手机号码
    private String qq;              //QQ
    private String weChatOpenId;
    private String miniOpenid;
    private String ydhfMiniOpenId;      //运动合肥id
    private Boolean idCertification;    //是否已实名认证
    private Account account;        //账户信息
    private UserCertificationHf certificationHf; //运动合肥实名认证信息

    private Integer openStatus;         // vip开通状态 （0-未开通，1-已开通，2-已过期）
    private String valEndTime;        // vip有效期结束时间
    private Integer instructorType;      //   指导员类型(0.未认证,1.指导员,2.非指导员)

    public Integer getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Integer openStatus) {
        this.openStatus = openStatus;
    }

    public String getValEndTime() {
        return valEndTime;
    }

    public void setValEndTime(String valEndTime) {
        this.valEndTime = valEndTime;
    }

    public UserCertificationHf getCertificationHf() {
        return certificationHf;
    }

    public void setCertificationHf(UserCertificationHf certificationHf) {
        this.certificationHf = certificationHf;
    }

    public Boolean getIdCertification() {
        return idCertification;
    }

    public void setIdCertification(Boolean idCertification) {
        this.idCertification = idCertification;
    }

    public String getYdhfMiniOpenId() {
        return ydhfMiniOpenId;
    }

    public void setYdhfMiniOpenId(String ydhfMiniOpenId) {
        this.ydhfMiniOpenId = ydhfMiniOpenId;
    }

    public String getMiniOpenid() {
        return miniOpenid;
    }

    public void setMiniOpenid(String miniOpenid) {
        this.miniOpenid = miniOpenid;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChatOpenId() {
        return this.weChatOpenId;
    }

    public void setWeChatOpenId(String weChatOpenId) {
        this.weChatOpenId = weChatOpenId;
    }

    public Integer getInstructorType() {
        return instructorType;
    }

    public void setInstructorType(Integer instructorType) {
        this.instructorType = instructorType;
    }
}
