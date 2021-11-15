package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 平台发布列表(PltfmPubItem)
 * @author willj 2019.11.13
 */
public class PltfmPubItem extends AbstractEntity {
    private static final long serialVersionUID = 1619719231731L;

    private String itemType; //种类 policy/notice/download/slide
    private String title; //标题
    private String subtitle; //摘要
    private String content; //内容
    private String image; //图片
    private String source; //来源
    private String url; //链接地址
    private Long releaseTime; //发布时间

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Long releaseTime) {
        this.releaseTime = releaseTime;
    }
}