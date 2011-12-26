package com.projectplus.project;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ProjectActionForm extends ActionForm {
<<<<<<< .mine
	public int op;
	public String name;
	public String destination;
	public String leader;
	public String startDate;
	public String endDate;
	
	public String getName() {
		return name;
	}
=======
	
	public int op;
	public String projectName;
	public String projectTarget;
	public String projectManager;
	public String projectState;
	public long startDate;
	public long endDate;
	
	public long getStartDate() {
		return startDate;
	}
>>>>>>> .r70

<<<<<<< .mine
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

=======
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String project_name) {
		this.projectName = project_name;
	}

	public String getProjectTarget() {
		return projectTarget;
	}

	public void setProjectTarget(String project_description) {
		this.projectTarget = project_description;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String project_manager) {
		this.projectManager = project_manager;
	}

	public String getProjectState() {
		return projectState;
	}

	public void setProjectState(String project_state) {
		this.projectState = project_state;
	}
>>>>>>> .r70
	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}
	
}
