package com.tjcloud.order.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaojian on 2016/10/25.
 */
public class StaRentReportVO implements Serializable {
    private static final long serialVersionUID = -6861433100490974958L;
    private String stadiumName;
    private String stadiumId;
    private List<StaRentReportItemVO> rentReportItemVOs;

    public String getStadiumName() {
        return this.stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getStadiumId() {
        return this.stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public List<StaRentReportItemVO> getRentReportItemVOs() {
        return this.rentReportItemVOs;
    }

    public void setRentReportItemVOs(List<StaRentReportItemVO> rentReportItemVOs) {
        this.rentReportItemVOs = rentReportItemVOs;
    }
}
