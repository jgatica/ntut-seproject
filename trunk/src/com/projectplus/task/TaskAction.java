package com.projectplus.task;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projectplus.context.SessionContext;
import com.projectplus.member.MemberDataStructure;
import com.projectplus.util.JSONWriter;

public class TaskAction extends Action {
	public static final int ADDTASK= 0;
	public static final int DELTASK= 1;
	public static final int UPDTASK= 2;
	public static final int ASSIGNTASK = 3;
	public static final int QYTASK = 4;
	public static final int QYMEMBERTASKS = 5;
	public static final int QYMPROJECTTASKS = 6;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 HttpSession session = request.getSession();
		 TaskActionForm form = (TaskActionForm)actionForm;
		    
		    int op = form.getOp();
		    System.out.println("the op  = " + op);
		    
		    switch (op) {
			    // 註冊會員
				case ADDTASK:
					return addTask(mapping, form, request, response, session);
				case DELTASK:
					return delTask(mapping, form, request, response, session); 
				case UPDTASK:
					return updateTask(mapping, form, request, response, session); 
				case ASSIGNTASK:
					return assignTask(mapping, form, request, response, session);
				case QYTASK:
					return queryTask(mapping, form, request, response, session);
				case QYMEMBERTASKS:
					return queryMemberTasks(mapping, form, request, response, session);				
		    }
		return null;
	}
	
	private ActionForward queryMemberTasks(ActionMapping mapping,
			TaskActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		MemberDataStructure data = (MemberDataStructure)session.getAttribute(SessionContext.USERDATA);
		ResultSet resultSet = TaskDBMgr.queryMemberTasks(data.member_email);
		
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
		
		try {
			if(dataList==null)
			{
				System.out.println("無工作");
			}
			JSONWriter.sendJSONResponse(response, dataList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private ActionForward queryTask(ActionMapping mapping, TaskActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ResultSet resultSet = TaskDBMgr.queryTask(form.id);
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
				task.setId(form.id);
				task.setName("工作"+form.id);
				task.setProjectName("軟體工程");
				task.setProjectId(form.id);
				task.setMemberId("1");
				task.setDescription("task"+form.id);
				task.setStartDate(100);
				task.setEndDate(200);
				task.setStatus("init");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(task==null)
			{
				System.out.println("無此工作");
			}
			JSONWriter.sendJSONResponse(response, task);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private ActionForward assignTask(ActionMapping mapping,
			TaskActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
	private ActionForward updateTask(ActionMapping mapping,
			TaskActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
	private ActionForward delTask(ActionMapping mapping, TaskActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
	private ActionForward addTask(ActionMapping mapping, TaskActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
}
