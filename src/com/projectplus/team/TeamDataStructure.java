package com.projectplus.team;

import java.util.List;

import com.projectplus.member.MemberDataStructure;

public class TeamDataStructure {
	public String id;
	public String imageURL;
	public String name;
	public String creator;
	public String phone;
	public String fax;
	public String mail;
	public String description;
	public String createDate;
	public List<MemberDataStructure> members;
	
	public List<MemberDataStructure> getMembers() {
		return members;
	}
	public void setMembers(List<MemberDataStructure> members) {
		this.members = members;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
