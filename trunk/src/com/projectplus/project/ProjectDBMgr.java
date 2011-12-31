package com.projectplus.project;

import java.sql.ResultSet;

import com.projectplus.db.DBMgr;

public class ProjectDBMgr extends DBMgr {

	public static boolean addProject(String name, String destination,
			String managerId, long startDate, long endDate) {
		return true;
	}
	
	/**
	 * 撈出該專案的所有任務
	 * 
	 * @param projectId
	 *            : 專案id
	 * @return 所有任務
	 */
	public static ResultSet listTask(String projectId) {
		return null;
	}

	public static void main(String[] args) {

	}

	public static ResultSet queryMemberProject(String member_email) {
		// TODO Auto-generated method stub
		return null;
	}
	public static ResultSet queryProject(String team_id) {
		// TODO Auto-generated method stub
		ResultSet  resultSet = null;
		return resultSet;
	}
}
