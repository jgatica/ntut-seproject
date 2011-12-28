package com.projectplus.project;

import java.sql.ResultSet;

import com.projectplus.db.DBMgr;

public class ProjectDBMgr extends DBMgr{

	String name;
	String destination;
	String leader;
	String startDate;
	String endDate;
	
	public static boolean addProject(String name,String destination,String leader,String startDate,	String endDate)
	{
		if(name.length()==0 || destination.length()==0 ||  leader.length()==0 || startDate.length()==0 || endDate.length()==0)
			return false;
		return true;
	}
	
	/**
	 * 撈出該專案的所有任務
	 * @param projectId : 專案id
	 * @return 所有任務
	 */
	public static ResultSet listTask(String projectId){
		return null;
	}
	
	
	
	public static void main(String[] args) {
		
	}
	
}
