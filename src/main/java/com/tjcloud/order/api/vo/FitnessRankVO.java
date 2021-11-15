package com.tjcloud.order.api.vo;

import java.io.Serializable;

public class FitnessRankVO implements Serializable {

    private static final long serialVersionUID = 4428644700341002810L;

    private String stadiumName;              // 场所名称
    private String stadiumId;          // 场所id
    private String areaRegion;          // 区
    private String ratio;               // 比例
    private Integer scanNum;              // 扫码人数
    private Integer cardNum;              // 刷卡人数
    private Integer totalNum;           // 总人数
    private Integer faceNum;            // 人脸入场人数

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getAreaRegion() {
        return areaRegion;
    }

    public void setAreaRegion(String areaRegion) {
        this.areaRegion = areaRegion;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public Integer getScanNum() {
        return scanNum;
    }

    public void setScanNum(Integer scanNum) {
        this.scanNum = scanNum;
    }

    public Integer getCardNum() {
        return cardNum;
    }

    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getFaceNum() {
        return faceNum;
    }

    public void setFaceNum(Integer faceNum) {
        this.faceNum = faceNum;
    }
}
