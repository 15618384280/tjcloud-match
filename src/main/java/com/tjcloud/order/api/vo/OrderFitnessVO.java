package com.tjcloud.order.api.vo;

import com.tjcloud.order.base.entity.OrderFitnessHistory;

/**
 * 订单VO
 * @author TJ_zhoupf
 *
 */
public class OrderFitnessVO extends OrderFitnessHistory {

	private static final long serialVersionUID = 3789728453603525603L;
	private String cardHeadURL; 								//身份证头像URL
	private String memberCardId; 							//卡片ID
	private Boolean inOrOut;

	public Boolean getInOrOut() {
		return inOrOut;
	}

	public void setInOrOut(Boolean inOrOut) {
		this.inOrOut = inOrOut;
	}

	public String getCardHeadURL() {
		return cardHeadURL;
	}
	public void setCardHeadURL(String cardHeadURL) {
		this.cardHeadURL = cardHeadURL;
	}
	public String getMemberCardId() {
		return memberCardId;
	}
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}
	
}
