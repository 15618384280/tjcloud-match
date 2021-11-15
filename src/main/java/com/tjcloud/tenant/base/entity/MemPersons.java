package com.tjcloud.tenant.base.entity;

import java.util.Date;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (MEM_PERSONS)
 * @author auto bin.yin 2017.10.09
 */
public class MemPersons extends AbstractEntity {
	private static final long serialVersionUID = 1507533443548L;

	private Integer PERSON_ID; //
	private Integer REMOVEMARK; //
	private Integer CREATED_BY; //
	private Date CREATION_DATE; //
	private String EMAIL_ADDRESS; //
	private String GENDER_TYPE; //
	private String ID_NUMBER; //
	private Date LAST_UPDATE_DATE; //
	private Integer LAST_UPDATED_BY; //
	private String LIVING_ADDRESS; //
	private String MOBILE_PHONE; //
	private Date PERSON_BIRTHDAY; //
	private String PERSON_NAME; //
	private String PERSON_SOURCE; //
	private String POSTALCODE; //
	private String TELEPHONE_NUMBER; //
	private Integer HOME_PROVINCE; //
	private Integer LIVING_PROVINCE; //
	private Integer HOME_CITY; //
	private Integer HOME_DISTRIC; //
	private Integer LIVING_DISTRICT; //
	private Integer LIVING_CITY; //
	private String PHOTO; //
	private String NOTE; //
	private String ADDRESS; //
	private String CARD_TYPE; //

	public Integer getPERSON_ID() {
		return this.PERSON_ID;
	}
	public void setPERSON_ID(Integer PERSON_ID) {
		this.PERSON_ID = PERSON_ID;
	}
	public Integer getREMOVEMARK() {
		return this.REMOVEMARK;
	}
	public void setREMOVEMARK(Integer REMOVEMARK) {
		this.REMOVEMARK = REMOVEMARK;
	}
	public Integer getCREATED_BY() {
		return this.CREATED_BY;
	}
	public void setCREATED_BY(Integer CREATED_BY) {
		this.CREATED_BY = CREATED_BY;
	}
	public Date getCREATION_DATE() {
		return this.CREATION_DATE;
	}
	public void setCREATION_DATE(Date CREATION_DATE) {
		this.CREATION_DATE = CREATION_DATE;
	}
	public String getEMAIL_ADDRESS() {
		return this.EMAIL_ADDRESS;
	}
	public void setEMAIL_ADDRESS(String EMAIL_ADDRESS) {
		this.EMAIL_ADDRESS = EMAIL_ADDRESS;
	}
	public String getGENDER_TYPE() {
		return this.GENDER_TYPE;
	}
	public void setGENDER_TYPE(String GENDER_TYPE) {
		this.GENDER_TYPE = GENDER_TYPE;
	}
	public String getID_NUMBER() {
		return this.ID_NUMBER;
	}
	public void setID_NUMBER(String ID_NUMBER) {
		this.ID_NUMBER = ID_NUMBER;
	}
	public Date getLAST_UPDATE_DATE() {
		return this.LAST_UPDATE_DATE;
	}
	public void setLAST_UPDATE_DATE(Date LAST_UPDATE_DATE) {
		this.LAST_UPDATE_DATE = LAST_UPDATE_DATE;
	}
	public Integer getLAST_UPDATED_BY() {
		return this.LAST_UPDATED_BY;
	}
	public void setLAST_UPDATED_BY(Integer LAST_UPDATED_BY) {
		this.LAST_UPDATED_BY = LAST_UPDATED_BY;
	}
	public String getLIVING_ADDRESS() {
		return this.LIVING_ADDRESS;
	}
	public void setLIVING_ADDRESS(String LIVING_ADDRESS) {
		this.LIVING_ADDRESS = LIVING_ADDRESS;
	}
	public String getMOBILE_PHONE() {
		return this.MOBILE_PHONE;
	}
	public void setMOBILE_PHONE(String MOBILE_PHONE) {
		this.MOBILE_PHONE = MOBILE_PHONE;
	}
	public Date getPERSON_BIRTHDAY() {
		return this.PERSON_BIRTHDAY;
	}
	public void setPERSON_BIRTHDAY(Date PERSON_BIRTHDAY) {
		this.PERSON_BIRTHDAY = PERSON_BIRTHDAY;
	}
	public String getPERSON_NAME() {
		return this.PERSON_NAME;
	}
	public void setPERSON_NAME(String PERSON_NAME) {
		this.PERSON_NAME = PERSON_NAME;
	}
	public String getPERSON_SOURCE() {
		return this.PERSON_SOURCE;
	}
	public void setPERSON_SOURCE(String PERSON_SOURCE) {
		this.PERSON_SOURCE = PERSON_SOURCE;
	}
	public String getPOSTALCODE() {
		return this.POSTALCODE;
	}
	public void setPOSTALCODE(String POSTALCODE) {
		this.POSTALCODE = POSTALCODE;
	}
	public String getTELEPHONE_NUMBER() {
		return this.TELEPHONE_NUMBER;
	}
	public void setTELEPHONE_NUMBER(String TELEPHONE_NUMBER) {
		this.TELEPHONE_NUMBER = TELEPHONE_NUMBER;
	}
	public Integer getHOME_PROVINCE() {
		return this.HOME_PROVINCE;
	}
	public void setHOME_PROVINCE(Integer HOME_PROVINCE) {
		this.HOME_PROVINCE = HOME_PROVINCE;
	}
	public Integer getLIVING_PROVINCE() {
		return this.LIVING_PROVINCE;
	}
	public void setLIVING_PROVINCE(Integer LIVING_PROVINCE) {
		this.LIVING_PROVINCE = LIVING_PROVINCE;
	}
	public Integer getHOME_CITY() {
		return this.HOME_CITY;
	}
	public void setHOME_CITY(Integer HOME_CITY) {
		this.HOME_CITY = HOME_CITY;
	}
	public Integer getHOME_DISTRIC() {
		return this.HOME_DISTRIC;
	}
	public void setHOME_DISTRIC(Integer HOME_DISTRIC) {
		this.HOME_DISTRIC = HOME_DISTRIC;
	}
	public Integer getLIVING_DISTRICT() {
		return this.LIVING_DISTRICT;
	}
	public void setLIVING_DISTRICT(Integer LIVING_DISTRICT) {
		this.LIVING_DISTRICT = LIVING_DISTRICT;
	}
	public Integer getLIVING_CITY() {
		return this.LIVING_CITY;
	}
	public void setLIVING_CITY(Integer LIVING_CITY) {
		this.LIVING_CITY = LIVING_CITY;
	}
	public String getPHOTO() {
		return this.PHOTO;
	}
	public void setPHOTO(String PHOTO) {
		this.PHOTO = PHOTO;
	}
	public String getNOTE() {
		return this.NOTE;
	}
	public void setNOTE(String NOTE) {
		this.NOTE = NOTE;
	}
	public String getADDRESS() {
		return this.ADDRESS;
	}
	public void setADDRESS(String ADDRESS) {
		this.ADDRESS = ADDRESS;
	}
	public String getCARD_TYPE() {
		return this.CARD_TYPE;
	}
	public void setCARD_TYPE(String CARD_TYPE) {
		this.CARD_TYPE = CARD_TYPE;
	}
}