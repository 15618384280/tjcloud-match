package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 调查表与调查场地关联表(dc_po_relevance)
 * @author auto bin.yin 2019.02.20
 */
public class DcPoRelevance extends AbstractEntity {
	private static final long serialVersionUID = 1550639073763L;

	private String tenantId; //
	private String poId; //调查表ID
	private String poStadiumId; //调查场地ID
	private String poStadiumItemId; //调查场地明细ID

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getPoId() {
		return this.poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getPoStadiumId() {
		return this.poStadiumId;
	}
	public void setPoStadiumId(String poStadiumId) {
		this.poStadiumId = poStadiumId;
	}
	public String getPoStadiumItemId() {
		return this.poStadiumItemId;
	}
	public void setPoStadiumItemId(String poStadiumItemId) {
		this.poStadiumItemId = poStadiumItemId;
	}
}