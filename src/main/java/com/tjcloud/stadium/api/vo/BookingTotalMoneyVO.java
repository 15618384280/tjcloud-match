package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaojian on 2016/9/18.
 */
public class BookingTotalMoneyVO implements Serializable{
    private static final long serialVersionUID = -2642368565655756301L;

    private String memberCategoryId;
    private String phone;
    private String date;
    private List<FindPriceRuleVO> findPriceRuleVOs;

    public List<FindPriceRuleVO> getFindPriceRuleVOs() {
        return this.findPriceRuleVOs;
    }

    public void setFindPriceRuleVOs(List<FindPriceRuleVO> findPriceRuleVOs) {
        this.findPriceRuleVOs = findPriceRuleVOs;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemberCategoryId() {
        return this.memberCategoryId;
    }

    public void setMemberCategoryId(String memberCategoryId) {
        this.memberCategoryId = memberCategoryId;
    }
}
