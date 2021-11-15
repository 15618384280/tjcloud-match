package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaojian on 2016/7/14.
 */
public class FieldVO implements Serializable{
    private static final long serialVersionUID = 8308457320769921220L;
    private String fieldId;
    private String fiedlName;
    private String fieldCode;
    private List<FieldPriceVO> fieldPriceVOs;
    private String resourceDate;
    
    // 2016年12月20日 11:53:06 selFieldInfo
    private String fieldName;
    private Integer allowBookingTenantDays;
    private Integer allowBookingPlatformDays;
    //2018年10月17日14:17:19 JD sid
    private Long sid;


    
    public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Integer getAllowBookingTenantDays() {
		return allowBookingTenantDays;
	}
	public void setAllowBookingTenantDays(Integer allowBookingTenantDays) {
		this.allowBookingTenantDays = allowBookingTenantDays;
	}
	
	public Integer getAllowBookingPlatformDays() {
		return allowBookingPlatformDays;
	}
	public void setAllowBookingPlatformDays(Integer allowBookingPlatformDays) {
		this.allowBookingPlatformDays = allowBookingPlatformDays;
	}
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFiedlName() {
        return this.fiedlName;
    }

    public void setFiedlName(String fiedlName) {
        this.fiedlName = fiedlName;
    }

    public List<FieldPriceVO> getFieldPriceVOs() {
        return this.fieldPriceVOs;
    }

    public void setFieldPriceVOs(List<FieldPriceVO> fieldPriceVOs) {
        this.fieldPriceVOs = fieldPriceVOs;
    }

    public String getResourceDate() {
        return this.resourceDate;
    }

    public void setResourceDate(String resourceDate) {
        this.resourceDate = resourceDate;
    }
}
