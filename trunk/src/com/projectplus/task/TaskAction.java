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

import com.projectplus.context.Result;
import com.projectplus.context.SessionContext;
import com.projectplus.member.MemberDataStructure;
import com.projectplus.project.ProjectDBMgr;
import com.projectplus.util.JSONWriter;

public class TaskAction extends Action {
	public static final int ADDTASK = 0;
	public static final int DELTASK = 1;
	public static final int UPDTASK = 2;
	public static final int ASSIGNTASK = 3;
	public static final int QYTASK = 4;
	public static final int QYMEMBERTASKS = 5;
	public static final int QYMPROJECTTASKS = 6;
	public static final int QYPROJECTTASKS = 7;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		TaskActionForm form = (TaskActionForm) actionForm;

		int op = form.getOp();
		// System.out.println("the op  = " + op);

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
		case QYPROJECTTASKS:
			return queryProjectTasks(mapping, form, request, response, session);
		}
		return null;
	}

	private ActionForward queryProjectTasks(ActionMapping mapping,
			TaskActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ResultSet resultSet=TaskDBMgr.queryProjectTasks(form.projectId);
		List<TaskDataStructure> dataList = new ArrayList<TaskDataStructure>();
		
		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					TaskDataStructure task = new TaskDataStructure();
					task.setName(resultSet.getString(""));
					task.setProjectId(resultSet.getString(""));
					task.setMemberId(resultSet.getString(""));
					task.setDescription(resultSet.getString(""));
					task.setStartDate(resultSet.getString(""));
					task.setEndDate(resultSet.getString(""));
					task.setState(resultSet.getString(""));
					dataList.add(task);
				}
			} else // 假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				for (int i = 0; i < 5; i++) {
					TaskDataStructure task = new TaskDataStructure();
					task.setId(Integer.toString(i));
					task.setName("工作" + i);
					task.setProjectName("軟體工程");
					task.setProjectId(Integer.toString(i));
					task.setMemberId("1");
					task.setDescription("task" + i);
					task.setStartDate("");
					task.setEndDate("");
					task.setState("init");
					dataList.add(task);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			JSONWriter.sendJSONResponse(response, dataList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ActionForward queryMemberTasks(ActionMapping mapping,
			TaskActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		MemberDataStructure data = (MemberDataStructure) session
				.getAttribute(SessionContext.USERDATA);
		ResultSet resultSet = TaskDBMgr.queryMemberTasks(data.member_email);

		List<TaskDataStructure> dataList = new ArrayList<TaskDataStructure>();
		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					TaskDataStructure task = new TaskDataStructure();
					task.setName(resultSet.getString(""));
					task.setProjectId(resultSet.getString(""));
					task.setMemberId(resultSet.getString(""));
					task.setDescription(resultSet.getString(""));
					task.setStartDate(resultSet.getString(""));
					task.setEndDate(resultSet.getString(""));
					task.setState(resultSet.getString(""));
					dataList.add(task);
				}
			} else // 假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				for (int i = 0; i < 5; i++) {
					TaskDataStructure task = new TaskDataStructure();
					task.setId(Integer.toString(i));
					task.setName("工作" + i);
					task.setProjectName("軟體工程");
					task.setProjectId(Integer.toString(i));
					task.setMemberId("1");
					task.setDescription("task" + i);
					task.setStartDate("");
					task.setEndDate("");
					task.setState("init");
					dataList.add(task);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
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
			if (resultSet != null) {
				while (resultSet.next()) {
					task = new TaskDataStructure();
					task.setName(resultSet.getString(""));
					task.setProjectId(resultSet.getString(""));
					task.setMemberId(resultSet.getString(""));
					task.setDescription(resultSet.getString(""));
					task.setStartDate(resultSet.getString(""));
					task.setEndDate(resultSet.getString(""));
					task.setState(resultSet.getString(""));
				}
			} else // 假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				task = new TaskDataStructure();
				task.setId(form.id);
				task.setName("工作" + form.id);
				task.setProjectName("軟體工程");
				task.setProjectId(form.id);
				task.setMemberId("1");
				task.setDescription("task" + form.id);
				task.setStartDate("");
				task.setEndDate("");
				task.setState("init");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (task == null) {
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
		Result result = new Result();
		boolean isSuccess = TaskDBMgr.assigTask(form.id, form.memberId);
		result.isSuccess = isSuccess;
		if (result.isSuccess)
			result.message = "指派成功";
		else
			result.message = "指派失敗";
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	private ActionForward updateTask(ActionMapping mapping,
			TaskActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		Result result = new Result();
		boolean isSuccess = false;
		//名稱是否有重複
		boolean isChecked = TaskDBMgr.checkTaskName(form.getName(),
				form.getProjectId());
		if (isChecked) {
			isSuccess = TaskDBMgr.updateTask(form.getName(),
					form.getDescription(), String.valueOf(form.getStartDate()),
					String.valueOf(form.getEndDate()), form.getId(),
					form.getProjectId(), form.memberId);
			result.isSuccess = isSuccess;
			if (result.isSuccess)
				result.message = "更新工作成功";
			else
				result.message = "更新工作失敗";
		} else {
			result.isSuccess = isSuccess;
			result.message = "失敗,工作名稱有重複";
		}
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ActionForward delTask(ActionMapping mapping, TaskActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		Result result = new Result();
		boolean isSuccess = TaskDBMgr.deleteTask(form.id);
		result.isSuccess = isSuccess;
		if (result.isSuccess) {
			result.message = "刪除成功";
		} else
			result.message = "刪除失敗";
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ActionForward addTask(ActionMapping mapping, TaskActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		boolean isSuccess = false;
		//名稱是否有重複
		boolean isChecked = TaskDBMgr.checkTaskName(form.getName(),
				form.getProjectId());
		Result result = new Result();
		
		if (isChecked) {
			isSuccess = TaskDBMgr.addTask(form.getName(),
					form.getDescription(), form.getStartDate(),
					form.getEndDate(), form.getId(),
					form.getProjectId(), form.memberId);
			result.isSuccess = isSuccess;
			if (result.isSuccess){
				result.message = "加入工作成功";
			}
			else
				result.message = "加入工作失敗";
		} else {
			result.isSuccess = isSuccess;
			result.message = "失敗,工作名稱有重複";
		}
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
