package com.projectplus.team;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class TeamActionForm extends ActionForm {

	int op;
	
	String phone;
	String fax;
	String address;
	String mail;
	String name;
	String description;
	long createDate;
	
	
	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	
	
}
