package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 代码生成器配置(CodeGenConfig)表实体类
 *
 * @author lucheng 2020-11-16 14:57:30
 */
public class CodeGenConfig extends AbstractEntity {
    private static final long serialVersionUID = -84614347156609168L;
    //表名
    private String tableName;
    //作者
    private String author;
    //是否覆盖
    private Boolean cover;
    //模块名称
    private String moduleName;
    //至于哪个包下
    private String pack;
    //前端代码生成的路径
    private String path;
    //前端Api文件路径
    private String apiPath;
    //表前缀
    private String prefix;
    //接口名称
    private String apiAlias;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getApiAlias() {
        return apiAlias;
    }

    public void setApiAlias(String apiAlias) {
        this.apiAlias = apiAlias;
    }

}