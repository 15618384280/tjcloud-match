package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.StringUtils;

import java.util.List;

/**
 * 场地代码表(dc_placecode)
 * @author auto bin.yin 2019.02.20
 */
public class DcPlacecode extends AbstractEntity {
	private static final long serialVersionUID = 1550639073654L;
	
	private String code; //代码
	private String parentCode; //父级代码
	private String name; //名称
	private String parentName; //父级名称
	private String enname; //英文名称
	private String ensname; //英文简称
	private String telcode; //区号
	private String zipcode; //邮编
	private String type; //0-场地代码,1-调查表场地代码,2-调查表子级场地代码

	private List<DcPlacecode> listObject;
	
	
	public List<DcPlacecode> getListObject() {
		return listObject;
	}
	public void setListObject(List<DcPlacecode> listObject) {
		this.listObject = listObject;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return this.parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getEnname() {
		return this.enname;
	}
	public void setEnname(String enname) {
		this.enname = enname;
	}
	public String getEnsname() {
		return this.ensname;
	}
	public void setEnsname(String ensname) {
		this.ensname = ensname;
	}
	public String getTelcode() {
		return this.telcode;
	}
	public void setTelcode(String telcode) {
		this.telcode = telcode;
	}
	public String getZipcode() {
		return this.zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCodeName() {
		return (StringUtils.isNotEmpty(this.name) && StringUtils.isNotEmpty(this.code) ) ? this.getCode() + "  " + this.getName() : "";
	}
}