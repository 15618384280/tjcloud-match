package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 租户商户号信息
 */
public class TenantMch extends AbstractEntity {

    private String tenantId;

    private String mchId;

    private String mchCode;

    private String mchName;

    private String tid;

    private String bankMchId;

    private String platform;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchCode() {
        return mchCode;
    }

    public void setMchCode(String mchCode) {
        this.mchCode = mchCode;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBankMchId() {
        return bankMchId;
    }

    public void setBankMchId(String bankMchId) {
        this.bankMchId = bankMchId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
