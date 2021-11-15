package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆管理员(stadium_manager)
 * @author auto bin.yin 2018.06.27
 */
public class StadiumManager extends AbstractEntity {
	private static final long serialVersionUID = 1530085702616L;

	private String tenantId; //租户id
	private String stadiumId; //场馆id
	private String stadiumItemId; //项目id
	private String employeeNo; //员工编号
	private String employeeName; //员工姓名
	private String employeePhone; //员工电话
	private String employeeImage; //员工照片
	private String employeeTitle;	//员工头衔
	private Boolean openGrade;		//开启评分
	private String grade; //综合评分
	
	public Boolean getOpenGrade() {
		return openGrade;
	}
	public void setOpenGrade(Boolean openGrade) {
		this.openGrade = openGrade;
	}
	public String getEmployeeTitle() {
		return employeeTitle;
	}
	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getEmployeeNo() {
		return this.employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return this.employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePhone() {
		return this.employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeImage() {
		return this.employeeImage;
	}
	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}
	public String getGrade() {
		return this.grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}