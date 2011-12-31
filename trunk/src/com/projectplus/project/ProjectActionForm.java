package com.projectplus.project;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ProjectActionForm extends ActionForm {
	public int op;
	public String teamId;
	
	public String projectId;
	public String projectName;
	public String projectTarget;
	
	public String projectManagerId;
	public String projectState;
	public long startDate;
	public long endDate;
	
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getProjectManagerId() {
		return projectManagerId;
	}
	public void setProjectManagerId(String projectManagerId) {
		this.projectManagerId = projectManagerId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectTarget() {
		return projectTarget;
	}
	public void setProjectTarget(String projectTarget) {
		this.projectTarget = projectTarget;
	}
	
	public String getProjectState() {
		return projectState;
	}
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
}
