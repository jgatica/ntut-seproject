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
