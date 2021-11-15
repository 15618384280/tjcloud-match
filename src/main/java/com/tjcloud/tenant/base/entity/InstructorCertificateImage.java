package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 指导员认证图片(InstructorCertificateImage)表实体类
 *
 * @author makejava 2021-02-23 15:03:39
 */
public class InstructorCertificateImage extends AbstractEntity {
private static final long serialVersionUID = -48244949597222388L;
    //指导员认证ID
    private String instructorCertificatId;
    //图片地址
    private String imageUrl;
    //排序No
    private Integer orderNo;

    public String getInstructorCertificatId() {
        return instructorCertificatId;
    }

    public void setInstructorCertificatId(String instructorCertificatId) {
        this.instructorCertificatId = instructorCertificatId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}