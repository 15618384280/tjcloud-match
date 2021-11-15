package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 功能资源表(uac_operation_resource)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class OperationResource extends AbstractEntity {
	private static final long serialVersionUID = 1462848091573L;

	private String operationId; //功能ID
	private String resourceId; //资源ID

	public String getOperationId() {
		return this.operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getResourceId() {
		return this.resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
}