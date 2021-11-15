package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
/**
 * (online_assess_record)考核记录表
 * @author niuhao 2020.10.16
 */
public class OnlineAssessRecord  extends AbstractEntity {
    private static final long serialVersionUID = -3954044234488522332L;

    private String userSignRecordId;		//用户签到id
    private Integer score;					//分数
    private String remark;					//备注

    private Integer isScore;					//是否打分

    public Integer getIsScore() {
        return isScore;
    }

    public void setIsScore(Integer isScore) {
        this.isScore = isScore;
    }

    public String getUserSignRecordId() {
        return userSignRecordId;
    }

    public void setUserSignRecordId(String userSignRecordId) {
        this.userSignRecordId = userSignRecordId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
