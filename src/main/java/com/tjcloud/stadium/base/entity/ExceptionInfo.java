package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 异常信息
 *
 */

public class ExceptionInfo extends AbstractEntity {
	private static final long serialVersionUID = -2819629246687896263L;

	private String name;//场馆姓名
	private String adminName; //管理员姓名
	private String account; //账号
	private String problem;//问题
	private String solve;//解决措施

	private String stadiumId; //场馆id
	private String addPeopleId; //添加人id

	private String selectTime;//查询时间

	private String phone; //电话

	private List<HelperImage>   exceptionInfoImageList;	//异常图片集

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolve() {
		return solve;
	}

	public void setSolve(String solve) {
		this.solve = solve;
	}

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getAddPeopleId() {
		return addPeopleId;
	}

	public void setAddPeopleId(String addPeopleId) {
		this.addPeopleId = addPeopleId;
	}

	public List<HelperImage> getExceptionInfoImageList() {
		return exceptionInfoImageList;
	}

	public void setExceptionInfoImageList(List<HelperImage> exceptionInfoImageList) {
		this.exceptionInfoImageList = exceptionInfoImageList;
	}

	public String getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}