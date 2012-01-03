package com.projectplus.project;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.projectplus.task.TaskDBMgr;
import com.projectplus.task.TaskDataStructure;
import com.projectplus.team.TeamDBMgr;
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
	public static final int QYPROJECTMEMBER = 12;

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
			return queryMemberProjects(mapping, form, request, response,
					session);
		case GANTT:
			return queryGantt(mapping, form, request, response, session);
		case QYPROJECT:
			return queryProject(mapping, form, request, response, session);
		case QYPROJECTMEMBER:
			return queryProjectMembers(mapping, form, request, response,
					session);
		}

		return null;
	}

	private ActionForward queryProjectMembers(ActionMapping mapping,
			ProjectActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ResultSet resultSet = ProjectDBMgr.queryProjectMembers(form.projectId);
		List<MemberDataStructure> dataList = new ArrayList<MemberDataStructure>();

		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					MemberDataStructure data = new MemberDataStructure();// 真的
					data.setId(resultSet.getString("m_id"));
					data.setImageURL(resultSet.getString("m_imageURL"));
					data.setMember_name(resultSet.getString("m_name"));
					dataList.add(data);
				}
			} else // 假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				/*
				 * for (int i = 0; i < 10; i++) { ProjectDataStructure project =
				 * new ProjectDataStructure(); project.setTeamId("1");
				 * project.setTeamName("軟體工程");
				 * project.setProjectId(Integer.toString(i));
				 * project.setProjectName("專案");
				 * project.setProjectTarget("完成所有需求");
				 * project.setProjectManagerId("1");
				 * project.setProjectManager("超級小可愛QQ");
				 * project.setStartDate(""); project.setEndDate(""); if (i > 4)
				 * project.setProjectState("finished"); else
				 * project.setProjectState("init");
				 * 
				 * dataList.add(project); }
				 */
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
			} else {
				// project = new ProjectDataStructure();
				// project.setProjectId(resultSet.getString(""));
				// project.setProjectManagerId(resultSet.getString(""));
				// project.setProjectManager(resultSet.getString(""));
				// project.setProjectName(resultSet.getString(""));
				// project.setProjectState(resultSet.getString(""));
				// project.setProjectTarget(resultSet.getString(""));
				// project.setStartDate(resultSet.getString(""));
				// project.setEndDate(resultSet.getString(""));
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

		// 前端會丟projectId過來 以這個id去撈資料給前端
		String projectId = form.getProjectId();
		System.out.println("aa=" + projectId);
		if (projectId != null) {
			ResultSet resultSet = TaskDBMgr.queryProjectTasks(projectId);

			// 以下面的格式組資料
			// resultSet.get()

			GanttScheme ganttScheme = new GanttScheme();
			ganttScheme.title = "甘特圖測試";
			ganttScheme.subtitle = "任務總表";

			if (resultSet != null) {
				try {
					while (resultSet.next()) {
						ganttScheme.xCategories.add(resultSet
								.getString("t_name"));
						SimpleDateFormat format = new java.text.SimpleDateFormat(
								"yyyy-MM-dd");
						Date beginDate = null;
						try {
							beginDate = format.parse(resultSet
									.getString("t_startdate"));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Date endDate = null;
						try {
							endDate = format.parse(resultSet
									.getString("t_enddate"));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						long day = (endDate.getTime() - beginDate.getTime())
								/ (24 * 60 * 60 * 1000);
						// System.out.println("相隔的天数="+day);
						ganttScheme.data.add((int) day);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// ganttScheme.xCategories.add("任務1");
			// ganttScheme.xCategories.add("任務2");
			// ganttScheme.xCategories.add("任務3");
			// ganttScheme.xCategories.add("任務4");
			// ganttScheme.xCategories.add("任務5");

			ganttScheme.xTitle = "";
			// ganttScheme.xTitle = "任務";
			ganttScheme.yTitle = "天數";

			// ganttScheme.data.add(200);
			// ganttScheme.data.add(300);
			// ganttScheme.data.add(200);
			// ganttScheme.data.add(700);
			// ganttScheme.data.add(400);

			try {
				JSONWriter.sendJSONResponse(response, ganttScheme);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
		ResultSet resultSet = TaskDBMgr.queryProjectTasks(form.projectId);
		ResultSet projectRresultSet = ProjectDBMgr.queryProject(form.projectId);
		List<TaskDataStructure> dataList = new ArrayList<TaskDataStructure>();

		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					TaskDataStructure task = new TaskDataStructure();
					task.setId(resultSet.getString("t_id"));
					task.setName(resultSet.getString("t_name"));
					task.setProjectId(resultSet.getString("p_id"));
					task.setMemberId(resultSet.getString("m_id"));
					task.setDescription(resultSet.getString("t_target"));
					task.setStartDate(resultSet.getString("t_startdate"));
					task.setEndDate(resultSet.getString("t_enddate"));
					task.setLayer(resultSet.getString("t_parent"));
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
			// System.out.println("Start Sort...");
			List<TaskDataStructure> dataSortList = new ArrayList<TaskDataStructure>();
			// System.out.println("size is :" + dataList.size());
			int preCount = 0;
			List<Integer> countList = new ArrayList<Integer>();
			for (int i = 4; dataList.size() != dataSortList.size(); i++) {
				int count = 0;
				for (int j = 0; j < dataList.size(); j++) {

					// System.out.println(dataList.get(j).getLayer());
					if (dataList.get(j).getLayer().length() == i) {
						count++;
						// System.out.println(dataList.get(j).getLayer());
						dataSortList.add(dataList.get(j));
					}
				}
				for (int k = preCount; k < preCount + count - 1; k++) {
					for (int l = preCount; l < preCount + count - 1; l++) {
						int preId = Integer.parseInt(dataSortList.get(l).id);
						int postId = Integer
								.parseInt(dataSortList.get(l + 1).id);
						if (preId > postId) {
							TaskDataStructure temp = dataSortList.get(l);
							dataSortList.set(l, dataSortList.get(l + 1));
							dataSortList.set(l + 1, temp);
						}
					}
				}
				countList.add(count);
				preCount += count;
			}
			int index = 0;
			for (int i = 0; i < countList.size(); i++) {
				for (int j = 0; j < countList.get(i); j++) {
					dataSortList.get(index).setLayer(
							dataSortList.get(index).getLayer() + (j + 1));
					System.out.println(dataSortList.get(index).getLayer());
					index++;
				}
			}
			ArrayList<WbsScheme> schemes = new ArrayList<WbsScheme>();
			try {
				projectRresultSet.next();
				String projectName = projectRresultSet.getString("p_name");
				String parent = projectName;
				WbsScheme scheme = WbsSchemeCreator.createWbsScheme("",
						projectName, "");
				schemes.add(scheme);
				for (int i = 0; i < dataSortList.size(); i++) {
					if (dataSortList.get(i).getLayer().length() == 5) {
						// System.out.println(dataSortList.get(i).getName());
						scheme = WbsSchemeCreator.createWbsScheme(parent,
								dataSortList.get(i).name, "");
					} else {
						String node = dataSortList.get(i).getLayer().substring(0,dataSortList.get(i).getLayer().length() - 1);
						for (int j = 0; j < dataSortList.size(); j++) {
							if (dataSortList.get(j).getLayer().equals(node)) {
								/*
								 * System.out.println(dataSortList.get(i).getLayer
								 * ());
								 * System.out.println(dataSortList.get(i).getName
								 * ());
								 */
								parent = dataSortList.get(j).name;
								scheme = WbsSchemeCreator.createWbsScheme(
										parent, dataSortList.get(i).name, "");
								break;
							}
						}
					}
					schemes.add(scheme);
				}
				// System.out.println(dataSortList.toString());
				JSONWriter.sendJSONResponse(response, schemes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
			isSuccess = ProjectDBMgr
					.addProject(form.projectName, form.projectTarget,
							form.projectManagerId, form.startDate,
							form.endDate, data.id, form.teamId, form.duration,
							"parent");

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
