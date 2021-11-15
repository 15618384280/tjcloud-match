package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by gaojian on 2016/7/4.
 */
public class FindPriceRuleVO implements Serializable{
    private static final long serialVersionUID = 6195273343099466336L;

    private String memberCategoryId;     //卡等级
    private Integer dayOfWeek;  //日期类型
    private String fieldId;       //场地id
    private String fieldName;

    private String beginTime;
    private String endTime;

    private Boolean always; //永久还是临时

    private int price;

    private BigDecimal Bprice;

    private Long date;//这个日期是为了在查询临时价格时，拿这个long型日期去数据库里查询。
    
    private String dateStr;

    public String getMemberCategoryId() {
        return this.memberCategoryId;
    }

    public void setMemberCategoryId(String memberCategoryId) {
        this.memberCategoryId = memberCategoryId;
    }

    public Integer getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getAlways() {
        return this.always;
    }

    public void setAlways(Boolean always) {
        this.always = always;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getDate() {
        return this.date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public BigDecimal getBprice() {
        return this.Bprice;
    }

    public void setBprice(BigDecimal bprice) {
        this.Bprice = bprice;
    }
}
