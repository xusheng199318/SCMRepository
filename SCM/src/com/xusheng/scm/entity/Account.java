package com.xusheng.scm.entity;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = -8066383754707727466L;

	private Integer accId;
	
	private String accLogin;
	
	private String accName;
	
	private String accPass;

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getAccLogin() {
		return accLogin;
	}

	public void setAccLogin(String accLogin) {
		this.accLogin = accLogin;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccPass() {
		return accPass;
	}

	public void setAccPass(String accPass) {
		this.accPass = accPass;
	}

	public Account(Integer accId, String accLogin, String accName,
			String accPass) {
		this.accId = accId;
		this.accLogin = accLogin;
		this.accName = accName;
		this.accPass = accPass;
	}

	public Account() {}

	public String toString() {
		return "Account [accId=" + accId + ", accLogin=" + accLogin
				+ ", accName=" + accName + ", accPass=" + accPass + "]";
	}
	
	
	
}
