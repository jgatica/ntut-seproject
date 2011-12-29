package com.projectplus.project;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ProjectActionForm extends ActionForm {
	public int op;
	public String name;
	public String destination;
	public String leader;
	public String startDate;
	public String endDate;
	
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
