package com.tjcloud.tenant.base.entity;

import java.util.Date;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (MEM_MEMBERS)
 * @author auto bin.yin 2017.10.09
 */
public class MemMembers extends AbstractEntity {
	private static final long serialVersionUID = 1507533436496L;

	private Integer REMOVEMARK; //
	private String ACCOUNT_BALANCE; //
	private Integer CREATED_BY; //
	private Date CREATION_DATE; //
	private Date LAST_UPDATE_DATE; //
	private Integer LAST_UPDATED_BY; //
	private Date LOGIN_DATE; //
	private String LOGIN_PASS; //
	private String MEMBER_ACCOUNT; //
	private Integer MEMBER_POINT; //
	private Integer MEMBER_TYPE_ID; //
	private String NICKNAME; //
	private String PAY_PASS; //
	private String PERSON_ID; //
	private String PHOTO; //
	private String QQ_NUMBER; //
	private Date REG_DATE; //
	private String VALID_EMAIL_FLAG; //
	private String VALID_PHONE_FLAG; //
	private Integer ORIG_REGSITER_GYMNASIUM_ID; //
	private Integer ORIG_REGSITER_COMPANY_ID; //
	private Date LAST_VALID_EMAIL_DATE; //
	private String LAST_VALID_EMAIL_CODE; //
	private Integer LAST_VALID_EMAIL_TIMES; //
	private Date LAST_VALID_SMS_DATE; //
	private String LAST_VALID_SMS_CODE; //
	private Integer LAST_VALID_SMS_TIMES; //
	private String IC_NUMBER; //
	private Date LAST_RETRIEVE_PASS_SMS_DATE; //
	private Date LAST_RETRIEVE_PASS_EMAIL_DATE; //
	private Integer RETRIEVE_PASS_SMS_TIMES; //
	private Integer RETRIEVE_PASS_EMAIL_TIMES; //
	private String VALID_FLAG; //
	private Integer synchroAccount; //同步账号(0.未同步,1.已同步，2.异常)

	public Integer getREMOVEMARK() {
		return this.REMOVEMARK;
	}
	public void setREMOVEMARK(Integer REMOVEMARK) {
		this.REMOVEMARK = REMOVEMARK;
	}
	public String getACCOUNT_BALANCE() {
		return this.ACCOUNT_BALANCE;
	}
	public void setACCOUNT_BALANCE(String ACCOUNT_BALANCE) {
		this.ACCOUNT_BALANCE = ACCOUNT_BALANCE;
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
	public Date getLOGIN_DATE() {
		return this.LOGIN_DATE;
	}
	public void setLOGIN_DATE(Date LOGIN_DATE) {
		this.LOGIN_DATE = LOGIN_DATE;
	}
	public String getLOGIN_PASS() {
		return this.LOGIN_PASS;
	}
	public void setLOGIN_PASS(String LOGIN_PASS) {
		this.LOGIN_PASS = LOGIN_PASS;
	}
	public String getMEMBER_ACCOUNT() {
		return this.MEMBER_ACCOUNT;
	}
	public void setMEMBER_ACCOUNT(String MEMBER_ACCOUNT) {
		this.MEMBER_ACCOUNT = MEMBER_ACCOUNT;
	}
	public Integer getMEMBER_POINT() {
		return this.MEMBER_POINT;
	}
	public void setMEMBER_POINT(Integer MEMBER_POINT) {
		this.MEMBER_POINT = MEMBER_POINT;
	}
	public Integer getMEMBER_TYPE_ID() {
		return this.MEMBER_TYPE_ID;
	}
	public void setMEMBER_TYPE_ID(Integer MEMBER_TYPE_ID) {
		this.MEMBER_TYPE_ID = MEMBER_TYPE_ID;
	}
	public String getNICKNAME() {
		return this.NICKNAME;
	}
	public void setNICKNAME(String NICKNAME) {
		this.NICKNAME = NICKNAME;
	}
	public String getPAY_PASS() {
		return this.PAY_PASS;
	}
	public void setPAY_PASS(String PAY_PASS) {
		this.PAY_PASS = PAY_PASS;
	}
	public String getPERSON_ID() {
		return this.PERSON_ID;
	}
	public void setPERSON_ID(String PERSON_ID) {
		this.PERSON_ID = PERSON_ID;
	}
	public String getPHOTO() {
		return this.PHOTO;
	}
	public void setPHOTO(String PHOTO) {
		this.PHOTO = PHOTO;
	}
	public String getQQ_NUMBER() {
		return this.QQ_NUMBER;
	}
	public void setQQ_NUMBER(String QQ_NUMBER) {
		this.QQ_NUMBER = QQ_NUMBER;
	}
	public Date getREG_DATE() {
		return this.REG_DATE;
	}
	public void setREG_DATE(Date REG_DATE) {
		this.REG_DATE = REG_DATE;
	}
	public String getVALID_EMAIL_FLAG() {
		return this.VALID_EMAIL_FLAG;
	}
	public void setVALID_EMAIL_FLAG(String VALID_EMAIL_FLAG) {
		this.VALID_EMAIL_FLAG = VALID_EMAIL_FLAG;
	}
	public String getVALID_PHONE_FLAG() {
		return this.VALID_PHONE_FLAG;
	}
	public void setVALID_PHONE_FLAG(String VALID_PHONE_FLAG) {
		this.VALID_PHONE_FLAG = VALID_PHONE_FLAG;
	}
	public Integer getORIG_REGSITER_GYMNASIUM_ID() {
		return this.ORIG_REGSITER_GYMNASIUM_ID;
	}
	public void setORIG_REGSITER_GYMNASIUM_ID(Integer ORIG_REGSITER_GYMNASIUM_ID) {
		this.ORIG_REGSITER_GYMNASIUM_ID = ORIG_REGSITER_GYMNASIUM_ID;
	}
	public Integer getORIG_REGSITER_COMPANY_ID() {
		return this.ORIG_REGSITER_COMPANY_ID;
	}
	public void setORIG_REGSITER_COMPANY_ID(Integer ORIG_REGSITER_COMPANY_ID) {
		this.ORIG_REGSITER_COMPANY_ID = ORIG_REGSITER_COMPANY_ID;
	}
	public Date getLAST_VALID_EMAIL_DATE() {
		return this.LAST_VALID_EMAIL_DATE;
	}
	public void setLAST_VALID_EMAIL_DATE(Date LAST_VALID_EMAIL_DATE) {
		this.LAST_VALID_EMAIL_DATE = LAST_VALID_EMAIL_DATE;
	}
	public String getLAST_VALID_EMAIL_CODE() {
		return this.LAST_VALID_EMAIL_CODE;
	}
	public void setLAST_VALID_EMAIL_CODE(String LAST_VALID_EMAIL_CODE) {
		this.LAST_VALID_EMAIL_CODE = LAST_VALID_EMAIL_CODE;
	}
	public Integer getLAST_VALID_EMAIL_TIMES() {
		return this.LAST_VALID_EMAIL_TIMES;
	}
	public void setLAST_VALID_EMAIL_TIMES(Integer LAST_VALID_EMAIL_TIMES) {
		this.LAST_VALID_EMAIL_TIMES = LAST_VALID_EMAIL_TIMES;
	}
	public Date getLAST_VALID_SMS_DATE() {
		return this.LAST_VALID_SMS_DATE;
	}
	public void setLAST_VALID_SMS_DATE(Date LAST_VALID_SMS_DATE) {
		this.LAST_VALID_SMS_DATE = LAST_VALID_SMS_DATE;
	}
	public String getLAST_VALID_SMS_CODE() {
		return this.LAST_VALID_SMS_CODE;
	}
	public void setLAST_VALID_SMS_CODE(String LAST_VALID_SMS_CODE) {
		this.LAST_VALID_SMS_CODE = LAST_VALID_SMS_CODE;
	}
	public Integer getLAST_VALID_SMS_TIMES() {
		return this.LAST_VALID_SMS_TIMES;
	}
	public void setLAST_VALID_SMS_TIMES(Integer LAST_VALID_SMS_TIMES) {
		this.LAST_VALID_SMS_TIMES = LAST_VALID_SMS_TIMES;
	}
	public String getIC_NUMBER() {
		return this.IC_NUMBER;
	}
	public void setIC_NUMBER(String IC_NUMBER) {
		this.IC_NUMBER = IC_NUMBER;
	}
	public Date getLAST_RETRIEVE_PASS_SMS_DATE() {
		return this.LAST_RETRIEVE_PASS_SMS_DATE;
	}
	public void setLAST_RETRIEVE_PASS_SMS_DATE(Date LAST_RETRIEVE_PASS_SMS_DATE) {
		this.LAST_RETRIEVE_PASS_SMS_DATE = LAST_RETRIEVE_PASS_SMS_DATE;
	}
	public Date getLAST_RETRIEVE_PASS_EMAIL_DATE() {
		return this.LAST_RETRIEVE_PASS_EMAIL_DATE;
	}
	public void setLAST_RETRIEVE_PASS_EMAIL_DATE(Date LAST_RETRIEVE_PASS_EMAIL_DATE) {
		this.LAST_RETRIEVE_PASS_EMAIL_DATE = LAST_RETRIEVE_PASS_EMAIL_DATE;
	}
	public Integer getRETRIEVE_PASS_SMS_TIMES() {
		return this.RETRIEVE_PASS_SMS_TIMES;
	}
	public void setRETRIEVE_PASS_SMS_TIMES(Integer RETRIEVE_PASS_SMS_TIMES) {
		this.RETRIEVE_PASS_SMS_TIMES = RETRIEVE_PASS_SMS_TIMES;
	}
	public Integer getRETRIEVE_PASS_EMAIL_TIMES() {
		return this.RETRIEVE_PASS_EMAIL_TIMES;
	}
	public void setRETRIEVE_PASS_EMAIL_TIMES(Integer RETRIEVE_PASS_EMAIL_TIMES) {
		this.RETRIEVE_PASS_EMAIL_TIMES = RETRIEVE_PASS_EMAIL_TIMES;
	}
	public String getVALID_FLAG() {
		return this.VALID_FLAG;
	}
	public void setVALID_FLAG(String VALID_FLAG) {
		this.VALID_FLAG = VALID_FLAG;
	}
	public Integer getSynchroAccount() {
		return synchroAccount;
	}
	public void setSynchroAccount(Integer synchroAccount) {
		this.synchroAccount = synchroAccount;
	}
	
}