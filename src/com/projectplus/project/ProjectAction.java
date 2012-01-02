package com.projectplus.project;

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

import com.projectplus.charts.GanttScheme;
import com.projectplus.charts.WbsScheme;
import com.projectplus.charts.WbsSchemeCreator;
import com.projectplus.context.Result;
import com.projectplus.context.SessionContext;
import com.projectplus.member.MemberDataStructure;
import com.projectplus.util.JSONWriter;

public class ProjectAction extends Action {

	public static final int ADDPROJECT = 0;
	public static final int DELPROJECT = 1;
	public static final int FREEZEPROJECT = 2;
	public static final int UNFREEZEPROJECT = 3;
	public static final int UPDPROJECT = 4;
	public static final int QYTEAMPROJECTS = 5;
	public static final int ASSIGNPM = 6;
	public static final int QYMEMBER = 7;
	public static final int WBSTREE = 8;
	public static final int QYMEMBERPROJECTS = 9;
	public static final int GANTT = 10;
	public static final int QYPROJECT = 11;

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ProjectActionForm form = (ProjectActionForm) actionForm;

		int op = form.getOp();
		// System.out.println("the op  = " + op);
		switch (op) {
		case ADDPROJECT:
			return addProject(mapping, form, request, response, session);
		case DELPROJECT:
			return delProject(mapping, form, request, response, session);
		case FREEZEPROJECT:
			return freezeProject(mapping, form, request, response, session);
		case UNFREEZEPROJECT:
			return unFreezeProject(mapping, form, request, response, session);
		case UPDPROJECT:
			return updateProject(mapping, form, request, response, session);
		case QYTEAMPROJECTS:
			return queryTeamProjects(mapping, form, request, response, session);
		case ASSIGNPM:
			return assignPM(mapping, form, request, response, session);
		case QYMEMBER:
			return queryMember(mapping, form, request, response, session);
		case WBSTREE:
			return queryWbsTree(mapping, form, request, response, session);
		case QYMEMBERPROJECTS:
			return queryMemberProjects(mapping, form, request, response, session);
		case GANTT:
			return queryGantt(mapping, form, request, response, session);
		case QYPROJECT:
			return queryProject(mapping, form, request, response, session);
		}

		return null;
	}

	private ActionForward queryProject(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ResultSet resultSet = ProjectDBMgr.queryProject(form.projectId);
		ProjectDataStructure project = null;
		try {
			if (resultSet != null && resultSet.next()) {
				project = new ProjectDataStructure();
				project.setProjectId(resultSet.getString("p_id"));
				project.setProjectManagerId(resultSet.getString("m_id"));
				project.setProjectManager(resultSet.getString("m_name"));
				project.setProjectName(resultSet.getString("p_name"));
				project.setProjectState("");
				project.setProjectTarget(resultSet.getString("p_desc"));
				project.setStartDate(resultSet.getString("p_startdate"));
				project.setEndDate(resultSet.getString("p_enddate"));
			} 
			else
			{
//				project = new ProjectDataStructure();
//				project.setProjectId(resultSet.getString(""));
//				project.setProjectManagerId(resultSet.getString(""));
//				project.setProjectManager(resultSet.getString(""));
//				project.setProjectName(resultSet.getString(""));
//				project.setProjectState(resultSet.getString(""));
//				project.setProjectTarget(resultSet.getString(""));
//				project.setStartDate(resultSet.getString(""));
//				project.setEndDate(resultSet.getString(""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			JSONWriter.sendJSONResponse(response, project);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * op 10 列出甘特圖
	 * 
	 * @return
	 */
	private ActionForward queryGantt(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		GanttScheme ganttScheme = new GanttScheme();
		ganttScheme.title = "甘特圖測試";
		ganttScheme.subtitle = "任務總表";

		ganttScheme.xCategories.add("任務1");
		ganttScheme.xCategories.add("任務2");
		ganttScheme.xCategories.add("任務3");
		ganttScheme.xCategories.add("任務4");
		ganttScheme.xCategories.add("任務5");

		ganttScheme.xTitle = "";
		// ganttScheme.xTitle = "任務";
		ganttScheme.yTitle = "時間";

		ganttScheme.data.add(200);
		ganttScheme.data.add(300);
		ganttScheme.data.add(200);
		ganttScheme.data.add(700);
		ganttScheme.data.add(400);

		try {
			JSONWriter.sendJSONResponse(response, ganttScheme);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private ActionForward queryMemberProjects(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// MemberDataStructure userData = (MemberDataStructure) session
		// .getAttribute(SessionContext.USERDATA);
		// if (userData == null)
		// return null;
		// ResultSet resultSet = ProjectDBMgr
		// .queryMemberProject(userData.member_email);
		// List<ProjectDataStructure> dataList = new
		// ArrayList<ProjectDataStructure>();
		// try {
		// if (resultSet != null) {
		//
		// while (resultSet.next()) {
		// ProjectDataStructure project = new ProjectDataStructure();
		// project.setProjectId(resultSet.getString(""));
		// project.setProjectName(resultSet.getString(""));
		// project.setProjectManagerId(resultSet.getString(""));
		// project.setProjectManager(resultSet.getString(""));
		// project.setProjectTarget(resultSet.getString(""));
		// project.setProjectState(resultSet.getString(""));
		// project.setStartDate(resultSet.getString(""));
		// project.setEndDate(resultSet.getString(""));
		//
		// // new stri
		// }
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return null;
	}

	/**
	 * OP 8 建構WBS TREE並回傳給前端顯示
	 * 
	 * @return
	 */
	private ActionForward queryWbsTree(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		// ResultSet resultSet = null;
		ArrayList<WbsScheme> schemes = new ArrayList<WbsScheme>();
		// Step:1 由DB撈出所有的Task
		// resultSet = ProjectDBMgr.listTask("projectId:123456");

		// if(resultSet != null){
		// try {
		// while(resultSet.next()){
		// Step:2 使用WbsSchemeCreator.createWbsScheme 建構節點
		WbsScheme scheme = WbsSchemeCreator.createWbsScheme("", "jQuery開發團",
				"我是根結點");
		WbsScheme scheme2 = WbsSchemeCreator.createWbsScheme("jQuery開發團",
				"開發WBS系統", "根");
		WbsScheme scheme3 = WbsSchemeCreator.createWbsScheme("jQuery開發團",
				"開發登入系統", "二之二");
		WbsScheme scheme4 = WbsSchemeCreator.createWbsScheme("jQuery開發團",
				"開發估算系統", "三之三");
		WbsScheme scheme5 = WbsSchemeCreator.createWbsScheme("開發WBS系統", "美化外觀",
				"二之一");
		WbsScheme scheme6 = WbsSchemeCreator.createWbsScheme("開發WBS系統",
				"更改超連結功能", "二之一");
		WbsScheme scheme7 = WbsSchemeCreator.createWbsScheme("開發登入系統", "資料庫實作",
				"二之一");
		WbsScheme scheme8 = WbsSchemeCreator.createWbsScheme("開發登入系統",
				"fb登入模式實作", "二之一");
		WbsScheme scheme9 = WbsSchemeCreator.createWbsScheme("開發估算系統",
				"COCOMO開發", "二之一");
		WbsScheme scheme10 = WbsSchemeCreator.createWbsScheme("開發估算系統",
				"Function Point開發", "二之一");

		/*
		 * 根階層 : WbsTreeLevel.ROOT 第二階層 : WbsTreeLevel.ROOT + 1 第三階層 :
		 * WbsTreeLevel.ROOT + 2 ... 以此類推
		 */

		// Step:3 將節點組成ArrayList
		schemes.add(scheme);
		schemes.add(scheme2);
		schemes.add(scheme3);
		schemes.add(scheme4);
		schemes.add(scheme5);
		schemes.add(scheme6);
		schemes.add(scheme7);
		schemes.add(scheme8);
		schemes.add(scheme9);
		schemes.add(scheme10);

		// Step:4 轉換該ArrayList為WBS Tree JSON字串傳回給客戶
		try {
			JSONWriter.sendJSONResponse(response, schemes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
	}

	private ActionForward queryMember(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		return null;
		// TODO Auto-generated method stub

	}

	private ActionForward assignPM(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		Result result = new Result();
		boolean isSuccess = ProjectDBMgr
				.assignProjectManager(form.projectManagerId);
		if (isSuccess)
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

	private ActionForward unFreezeProject(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		return null;
		// TODO Auto-generated method stub

	}

	private ActionForward queryTeamProjects(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		ResultSet resultSet = ProjectDBMgr.queryTeamProjects(form.teamId);
		List<ProjectDataStructure> dataList = new ArrayList<ProjectDataStructure>();
		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					ProjectDataStructure project = new ProjectDataStructure();
					project.setTeamId(form.teamId);
					project.setTeamName("null");
					project.setProjectId(resultSet.getString("p_id"));
					project.setProjectName(resultSet.getString("p_name"));
					project.setProjectTarget(resultSet.getString("p_desc"));
					project.setProjectManagerId("缺少");
					project.setProjectManager("缺少");
					project.setStartDate(resultSet.getString("p_startdate"));
					project.setEndDate(resultSet.getString("p_enddate"));
					project.setProjectState("finished");
					dataList.add(project);
				}
			} else // 假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				for (int i = 0; i < 10; i++) {
					ProjectDataStructure project = new ProjectDataStructure();
					project.setTeamId("1");
					project.setTeamName("軟體工程");
					project.setProjectId(Integer.toString(i));
					project.setProjectName("專案");
					project.setProjectTarget("完成所有需求");
					project.setProjectManagerId("1");
					project.setProjectManager("超級小可愛QQ");
					project.setStartDate("");
					project.setEndDate("");
					if (i > 4)
						project.setProjectState("finished");
					else
						project.setProjectState("init");

					dataList.add(project);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (dataList == null) {
				System.out.println("無專案");
			}
			JSONWriter.sendJSONResponse(response, dataList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub

	}

	private ActionForward updateProject(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		Result result = new Result();
		MemberDataStructure data = (MemberDataStructure) session
				.getAttribute(SessionContext.USERDATA);
		boolean isSuccess = false;
		// 名稱是否有重複
		boolean isChecked = ProjectDBMgr.checkProjectName(
				form.getProjectName(), form.getProjectId());
		if (isChecked) {
			isSuccess = ProjectDBMgr.updateProject(form.projectName,
					form.projectTarget, form.projectManagerId, form.startDate,
					form.endDate, data.id, form.teamId);
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

	private ActionForward freezeProject(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		return null;
		// TODO Auto-generated method stub

	}

	private ActionForward delProject(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		Result result = new Result();
		boolean isSuccess = ProjectDBMgr.deleteProject(form.projectId);
		result.isSuccess = isSuccess;
		if (result.isSuccess)
			result.message = "刪除成功";
		else
			result.message = "刪除失敗";
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	private ActionForward addProject(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		// System.out.println("name:" + form.projectName);
		// System.out.println("destination:" + form.projectTarget);
		// System.out.println("leader:" + form.projectManagerId);
		// System.out.println("startDate:" + form.startDate);
		// System.out.println("endDate:" + form.endDate);
		MemberDataStructure data = (MemberDataStructure) session
				.getAttribute(SessionContext.USERDATA);
		// System.out.println("startDate:" + form.startDate);
		// boolean isSuccess =true;
		boolean check = form.projectName.length() == 0
				&& !ProjectDBMgr
						.checkProjectName(form.projectName, form.teamId);
		boolean isSuccess = false;
		if (!check)
			isSuccess = ProjectDBMgr.addProject(form.projectName,
					form.projectTarget, form.projectManagerId, form.startDate,
					form.endDate, data.id, form.teamId,form.duration);

		Result result = new Result();
		result.isSuccess = isSuccess && !check;
		if (result.isSuccess) {
			// session.setAttribute(SessionContext.ISLOGIN, isSuccess);
			result.message = "ok";
		} else {
			// session.setAttribute(SessionContext.ISLOGIN, "false");
			result.message = "未輸入完全";
		}
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
