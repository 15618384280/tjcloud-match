package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class Course extends AbstractEntity {
    private static final long serialVersionUID = 7424033785376099585L;

    private String trainId;   //培训Id
    private String courseName; //课程名
    private String introduction; // 简介
    private String content; //内容
    private String image; //图片

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
}
