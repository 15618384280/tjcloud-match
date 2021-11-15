package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 地标点亮记录表(MarkRecord)表实体类
 *
 * @author lucheng 2020-10-19 11:51:23
 */
public class MarkRecord extends AbstractEntity {
    private static final long serialVersionUID = -39295132933173293L;
    //租户Id
    private String tenantId;
    //地标Id
    private String markId;
    //地标排序
    private Long markSortNo;
    //地标logo
    private String markLogo;
    //赛事报名ID
    private String matchSignId;
    //用户ID
    private String userId;
    // 用户点亮地标记录总数
    private Integer markRecordCount;
    // 用户是否完成任务
    private Boolean finish;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getMarkId() {
        return markId;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }

    public String getMarkLogo() {
        return markLogo;
    }

    public void setMarkLogo(String markLogo) {
        this.markLogo = markLogo;
    }

    public String getMatchSignId() {
        return matchSignId;
    }

    public void setMatchSignId(String matchSignId) {
        this.matchSignId = matchSignId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMarkRecordCount() {
        return markRecordCount;
    }

    public void setMarkRecordCount(Integer markRecordCount) {
        this.markRecordCount = markRecordCount;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public Long getMarkSortNo() {
        return markSortNo;
    }

    public void setMarkSortNo(Long markSortNo) {
        this.markSortNo = markSortNo;
    }
}