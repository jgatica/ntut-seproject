package com.projectplus.task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectplus.db.DBMgr;
import com.projectplus.member.MemberDataStructure;

public class TaskDBMgr extends DBMgr{
	
	public static TaskDataStructure queryTask(String id)
	{
		ResultSet resultSet=null;
		TaskDataStructure task = null;
		
		try {
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
					task = new TaskDataStructure();
					task.setName(resultSet.getString(""));
					task.setProjectId(resultSet.getString(""));
					task.setMemberId(resultSet.getString(""));
					task.setDescription(resultSet.getString(""));
					task.setStartDate(1234);
					task.setEndDate(5678);
					task.setStatus(resultSet.getString(""));
				}
			}
			else //假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				task = new TaskDataStructure();
				task.setId(id);
				task.setName("工作"+id);
				task.setProjectName("軟體工程");
				task.setProjectId(id);
				task.setMemberId("1");
				task.setDescription("task"+id);
				task.setStartDate(100);
				task.setEndDate(200);
				task.setStatus("init");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}
	
	public static List<TaskDataStructure> queryMemberTasks(String memberId)
	{
		ResultSet resultSet=null;
		List<TaskDataStructure> dataList=new ArrayList<TaskDataStructure>();
		try {
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
					TaskDataStructure task = new TaskDataStructure();
					task.setName(resultSet.getString(""));
					task.setProjectId(resultSet.getString(""));
					task.setMemberId(resultSet.getString(""));
					task.setDescription(resultSet.getString(""));
					task.setStartDate(1234);
					task.setEndDate(5678);
					task.setStatus(resultSet.getString(""));
					dataList.add(task);
				}
			}
			else //假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				for(int i=0;i<5;i++)
				{
					TaskDataStructure task = new TaskDataStructure();
					task.setId(Integer.toString(i));
					task.setName("工作"+i);
					task.setProjectName("軟體工程");
					task.setProjectId(Integer.toString(i));
					task.setMemberId("1");
					task.setDescription("task"+i);
					task.setStartDate(i*100);
					task.setEndDate(i*100+100);
					task.setStatus("init");
					dataList.add(task);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}
}
