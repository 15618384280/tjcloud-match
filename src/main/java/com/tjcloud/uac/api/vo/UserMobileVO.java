package com.tjcloud.uac.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/7/27.
 */
public class UserMobileVO implements Serializable {
    private static final long serialVersionUID = -8087154582577231391L;

    private String mobile;
    private String code;
    private String authId;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAuthId() {
        return this.authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }
}
