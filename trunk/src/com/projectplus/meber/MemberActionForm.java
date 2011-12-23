package com.projectplus.meber;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class MemberActionForm extends ActionForm {

	public int op;
	public int start;
	public int length;
	
	public String hex_mrscid;
	public String ba_mrscid;
	public String password;
	public String member_name;
	public String member_nickname;
	public String member_descript;
	public String member_address;
	public String member_moblie;
	public String member_phone;
	public String member_birthday;
	public String member_email;
	
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getHex_mrscid() {
		return hex_mrscid;
	}
	public void setHex_mrscid(String hex_mrscid) {
		this.hex_mrscid = hex_mrscid;
	}
	public String getBa_mrscid() {
		return ba_mrscid;
	}
	public void setBa_mrscid(String ba_mrscid) {
		this.ba_mrscid = ba_mrscid;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_descript() {
		return member_descript;
	}
	public void setMember_descript(String member_descript) {
		this.member_descript = member_descript;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_moblie() {
		return member_moblie;
	}
	public void setMember_moblie(String member_moblie) {
		this.member_moblie = member_moblie;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_birthday() {
		return member_birthday;
	}
	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	
}
