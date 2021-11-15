package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.InstructorSignTaskRecord;

public class InstructorSignTaskRecordVo extends InstructorSignTaskRecord {

    // 打卡次数
    private Integer signNum;

    private String placeName;

    private String signTime;

    private String phone;

    private String insName;

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public Integer getSignNum() {
        return signNum;
    }

    public void setSignNum(Integer signNum) {
        this.signNum = signNum;
    }


}
