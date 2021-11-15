package com.tjcloud.tenant.base.entity;

import java.util.Date;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * (SportUser)表实体类
 *
 * @author makejava 2021-03-08 11:55:13
 */
public class SportUser extends AbstractEntity {
private static final long serialVersionUID = -48831820772359864L;
    //昵称
    private String nickName;
    //头像
    private String avatarUrl;
    //创建时间
    private Date createTime;
    //open id
    private String openId;
    //union id
    private String unionId;
    //手机号
    private String mobile;
    //用户类型
    private String userType;
    //城市
    private String cityId;
    //区域
    private String areaId;
    //街道
    private String streetId;
    //认证状态
    private String authState;
    //地址
    private String address;
    //证书封面
    private String credentialsCover;
    //证书内页
    private String credentialsPage;
    //等级
    private Integer userLevel;
    //审核备注
    private String applyRemark;
    //真实姓名
    private String realName;
    //身份证
    private String cid;

    private String education;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getAuthState() {
        return authState;
    }

    public void setAuthState(String authState) {
        this.authState = authState;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCredentialsCover() {
        return credentialsCover;
    }

    public void setCredentialsCover(String credentialsCover) {
        this.credentialsCover = credentialsCover;
    }

    public String getCredentialsPage() {
        return credentialsPage;
    }

    public void setCredentialsPage(String credentialsPage) {
        this.credentialsPage = credentialsPage;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}