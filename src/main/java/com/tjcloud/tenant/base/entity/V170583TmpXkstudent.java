package com.tjcloud.tenant.base.entity;

/**
 * 学生信息表(V170583TmpStudent)表实体类
 *
 * @author makejava 2021-07-22 16:15:35
 */
public class V170583TmpXkstudent {
    private static final long serialVersionUID = -57136256752260257L;
    //序号
    private Long id;
    //学号
    private String xh;
    //姓名
    private String xm;

    //指导员等级
    private String Level;
    //如2-1，多方向时用;分隔	指导员方向
    private String Direction;
    private Integer Directionid;
    //注册年份
    private String Year;
    //指导员注册区域
    private String Zone;

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

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public Integer getDirectionid() {
        return Directionid;
    }

    public void setDirectionid(Integer directionid) {
        Directionid = directionid;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }
}