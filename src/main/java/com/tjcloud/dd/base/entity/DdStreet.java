package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (dd_street)
 * @author auto bin.yin 2017.08.24
 */
public class DdStreet extends AbstractEntity {
	private static final long serialVersionUID = 1503560175568L;

	private Integer removemark; //
	private String street_name; //
	private Integer district_id; //

	public Integer getRemovemark() {
		return this.removemark;
	}
	public void setRemovemark(Integer removemark) {
		this.removemark = removemark;
	}
	public String getStreet_name() {
		return this.street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public Integer getDistrict_id() {
		return this.district_id;
	}
	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}
}