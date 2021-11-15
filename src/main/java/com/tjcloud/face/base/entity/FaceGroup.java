package com.tjcloud.face.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 人脸范围信息表(face_group)
 * @author auto bin.yin 2018.12.05
 */
public class FaceGroup extends AbstractEntity {
	private static final long serialVersionUID = 1543996502196L;

	private String poolId; //人脸库配置
	private String baiduGroupId; //百度用户组ID
	private String logid; //请求标识码，随机数，唯一
	private String groupName; //场馆ID
	public String getPoolId() {
		return poolId;
	}
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}
	public String getBaiduGroupId() {
		return baiduGroupId;
	}
	public void setBaiduGroupId(String baiduGroupId) {
		this.baiduGroupId = baiduGroupId;
	}
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	
}