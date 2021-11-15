package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 项目类型(ps_image_item)
 * @author auto niu 2020.03.24
 */
public class ImageItem extends AbstractEntity {

    private static final long serialVersionUID = -7086308671910721231L;
    private String objectId; //场所子项目Id
    private String imageUrl; //图片url
    private Integer orderNo; //序号

    public String getObjectId() {
        return objectId;
    }
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getOrderNo() {
        return this.orderNo;
    }
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
