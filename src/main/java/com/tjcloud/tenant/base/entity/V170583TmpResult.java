package com.tjcloud.tenant.base.entity;

/**
 * 学生成绩信息(V170583TmpResult)表实体类
 *
 * @author makejava 2021-07-22 16:15:33
 */
public class V170583TmpResult {
    private static final long serialVersionUID = -41581548935473419L;
    //序号
    private Long id;
    //学号
    private String xh;
    //姓名
    private String xm;
    //课程ID
    private String kcdm;
    //课程名称
    private String kczwmc;
    //任务点完成率（已完成任务点数/总任务点数）
    private Double job_rate;
    //考试成绩
    private String Result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getKcdm() {
        return kcdm;
    }

    public void setKcdm(String kcdm) {
        this.kcdm = kcdm;
    }

    public String getKczwmc() {
        return kczwmc;
    }

    public void setKczwmc(String kczwmc) {
        this.kczwmc = kczwmc;
    }

    public Double getJob_rate() {
        return job_rate;
    }

    public void setJob_rate(Double job_rate) {
        this.job_rate = job_rate;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}