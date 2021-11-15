package com.tjcloud.uac.api.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by gaojian on 2016/5/10.
 */
public class MenuVO implements Serializable {

    private static final long serialVersionUID = 3296253888180100141L;

    private String id;
    private String title; //标题
    private String name; //标题
    private String label; //标题
    private String parentId; //父级ID
    private JSONArray childMenu;
    private JSONArray children;
    private String type;
    private String icon;
    private String frontendView;
    private Integer orderNo;
    private Boolean choose;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public JSONArray getChildMenu() {
        return this.childMenu;
    }

    public void setChildMenu(JSONArray childMenu) {
        this.childMenu = childMenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONArray getChildren() {
        return children;
    }

    public void setChildren(JSONArray children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
