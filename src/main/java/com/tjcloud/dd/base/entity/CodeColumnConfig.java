package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 代码生成字段信息存储(CodeColumnConfig)表实体类
 *
 * @author lucheng 2020-11-16 15:15:55
 */
public class CodeColumnConfig extends AbstractEntity {
    private static final long serialVersionUID = -32558329057977052L;
    //表名
    private String tableName;
    //数据库字段名称
    private String columnName;
    //数据库字段类型
    private String columnType;
    //字典名称
    private String dictName;
    //字段额外的参数
    private String extra;
    //是否在列表显示
    private Boolean formShow;
    //表单类型
    private String formType;
    //数据库字段键类型
    private String keyType;
    //是否在列表显示
    private Boolean listShow;
    //是否必填
    private Boolean notNull;
    //查询 1:模糊 2：精确
    private String queryType;
    //数据库字段描述
    private String remark;
    //日期注解
    private String dateAnnotation;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Boolean getFormShow() {
        return formShow;
    }

    public void setFormShow(Boolean formShow) {
        this.formShow = formShow;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public Boolean getListShow() {
        return listShow;
    }

    public void setListShow(Boolean listShow) {
        this.listShow = listShow;
    }

    public Boolean getNotNull() {
        return notNull;
    }

    public void setNotNull(Boolean notNull) {
        this.notNull = notNull;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDateAnnotation() {
        return dateAnnotation;
    }

    public void setDateAnnotation(String dateAnnotation) {
        this.dateAnnotation = dateAnnotation;
    }

}