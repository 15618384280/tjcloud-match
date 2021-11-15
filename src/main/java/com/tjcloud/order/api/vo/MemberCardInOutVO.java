package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/11/2.
 */
public class MemberCardInOutVO implements Serializable {
    private static final long serialVersionUID = 3815268627576879534L;
    private String memberCardId;
    private String cardNo;
    private String userId;
    private String memAmount;
    private int payType;
    private String payTypes;
    private String note;
    private String operatorId;
    private Long operationTime;
    private String balance;

    private String operationTimeS;

    private String userName;
    private String operator;

    private String orderNo;			//订单号
    private Integer orderType;		//订单类型
    private String orderTypeStr;	//订单类型
    
    public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public String getOrderTypeStr() {
		return orderTypeStr;
	}
	public void setOrderTypeStr(String orderTypeStr) {
		this.orderTypeStr = orderTypeStr;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getMemberCardId() {
		return memberCardId;
	}
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}

	public String getCardNo() {
        return this.cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMemAmount() {
        return this.memAmount;
    }
    public void setMemAmount(String memAmount) {
        this.memAmount = memAmount;
    }

    public int getPayType() {
        return this.payType;
    }
    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Long getOperationTime() {
        return this.operationTime;
    }

    public void setOperationTime(Long operationTime) {
        this.operationTime = operationTime;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperationTimeS() {
        return operationTimeS;
    }

    public void setOperationTimeS(String operationTimeS) {
        this.operationTimeS = operationTimeS;
    }

    public String getPayTypes() {
        return payTypes;
    }

    public void setPayTypes(String payTypes) {
        this.payTypes = payTypes;
    }
}
