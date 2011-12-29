package com.projectplus.task;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projectplus.context.Result;
import com.projectplus.context.SessionContext;
import com.projectplus.member.MemberActionForm;
import com.projectplus.member.MemberDataStructure;
import com.projectplus.util.JSONWriter;

public class TaskAction extends Action {
	public static final int ADDTASK= 0;
	public static final int DELTASK= 1;
	public static final int UPDTASK= 2;
	public static final int ASSIGNTASK = 3;
	public static final int QYTASK = 4;
	public static final int QYMEMBERTASKS = 5;
	public static final int QYMPROJECTTASKS = 5;
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
		List<TaskDataStructure> dataList = TaskDBMgr.queryMemberTasks(data.hex_mrscid);
		
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
		TaskDataStructure task = TaskDBMgr.queryTask(form.id);
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
