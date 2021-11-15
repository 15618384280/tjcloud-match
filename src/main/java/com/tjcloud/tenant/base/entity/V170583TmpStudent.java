package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 学生信息表(V170583TmpStudent)表实体类
 *
 * @author makejava 2021-07-22 16:15:35
 */
public class V170583TmpStudent {
    private static final long serialVersionUID = -57136256752269257L;
    //序号
    private Long id;
    //学号
    private String xh;
    //姓名
    private String xm;

    private String password;

    private String idno;
    //性别 男|女
    private String xb;
    //指导员等级
    private String Level;
    //如2-1，多方向时用;分隔	指导员方向
    private String Direction;
    //注册年份
    private String Year;
    //指导员注册区域
    private String Zone;
    //手机号
    private String tel;
    //邮箱
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}