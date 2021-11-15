package com.tjcloud.uac.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/5/10.
 */
public class OperationVO implements Serializable {

    private static final long serialVersionUID = -552304258458848894L;
    private String id;
    private String menuId; //菜单ID
    private String title; //名称
    private String label; //名称
    private String type;
    private String frontendView;
    private Integer orderNo;
    private Boolean choose;
    private String uniqueKey; //

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrontendView() {
        return frontendView;
    }

    public void setFrontendView(String frontendView) {
        this.frontendView = frontendView;
    }

    public Integer getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Boolean getChoose() {
        return choose;
    }

    public void setChoose(Boolean choose) {
        this.choose = choose;
    }

    public String getUniqueKey() {
        return this.uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
