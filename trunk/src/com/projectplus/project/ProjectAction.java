package com.projectplus.project;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projectplus.charts.WbsScheme;
import com.projectplus.charts.WbsSchemeCreator;
import com.projectplus.charts.WbsTreeLevel;
import com.projectplus.context.Result;
import com.projectplus.util.JSONWriter;

public class ProjectAction extends Action {

	public static final int ADDPROJECT= 0;
	public static final int DELPROJECT= 1;
	public static final int FREEZEPROJECT= 2;
	public static final int UNFREEZEPROJECT= 3;
	public static final int UPDPROJECT= 4;
	public static final int QYPROJECT = 5;
	public static final int ASSIGNPM = 6;
	public static final int QYMEMBER = 7;
	public static final int WBSTREE = 8;
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ProjectActionForm form = (ProjectActionForm) actionForm;
		
		int op = form.getOp();
		//System.out.println("the op  = " + op);
		switch (op) {
			case ADDPROJECT:
				addProject(mapping, form, request, response, session);
			case DELPROJECT:
				delProject(mapping, form, request, response, session);
			case FREEZEPROJECT:
				freezeProject(mapping, form, request, response, session);
			case UNFREEZEPROJECT:
				unFreezeProject(mapping, form, request, response, session);
			case UPDPROJECT:
				updateProject(mapping, form, request, response, session);
			case QYPROJECT:
				queryProject(mapping, form, request, response, session);
			case ASSIGNPM:
				assignPM(mapping, form, request, response, session);
			case QYMEMBER:
				queryMember(mapping, form, request, response, session);
			case WBSTREE:
				queryWbsTree(mapping, form, request, response, session);
		}
		
		return null;
	}

	
	/**
	 * OP 8
	 * 建構WBS TREE並回傳給前端顯示
	 */
	private void queryWbsTree(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ResultSet resultSet = null;
		ArrayList<WbsScheme> schemes = new ArrayList<WbsScheme>();
		// Step:1 由DB撈出所有的Task
//		resultSet = ProjectDBMgr.listTask("projectId:123456");
		
//		if(resultSet != null){
//			try {
//				while(resultSet.next()){
					// Step:2 使用WbsSchemeCreator.createWbsScheme 建構節點
					WbsScheme scheme = WbsSchemeCreator.createWbsScheme("", WbsTreeLevel.ROOT, "Root", "我是根結點");
					WbsScheme scheme2 = WbsSchemeCreator.createWbsScheme("Root", WbsTreeLevel.ROOT + 1, "根", "根");
					WbsScheme scheme4 = WbsSchemeCreator.createWbsScheme("Root", WbsTreeLevel.ROOT + 2, "二之二", "二之二");
					WbsScheme scheme7 = WbsSchemeCreator.createWbsScheme("Root", WbsTreeLevel.ROOT + 3, "三之三", "三之三");
					WbsScheme scheme3 = WbsSchemeCreator.createWbsScheme("根", WbsTreeLevel.ROOT + 1, "二之一", "二之一");
					WbsScheme scheme5 = WbsSchemeCreator.createWbsScheme("二之一", WbsTreeLevel.ROOT + 3, "三之一", "三之一");
					WbsScheme scheme6 = WbsSchemeCreator.createWbsScheme("二之一", WbsTreeLevel.ROOT + 3, "三之二", "三之二");
					WbsScheme scheme8 = WbsSchemeCreator.createWbsScheme("三之三", WbsTreeLevel.ROOT + 4, "四之一", "四之一");
					
					/*
					 * 根階層 : WbsTreeLevel.ROOT
					 * 第二階層 : WbsTreeLevel.ROOT + 1
					 * 第三階層 : WbsTreeLevel.ROOT + 2
					 * ... 以此類推
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
					
					// Step:4 轉換該ArrayList為WBS Tree JSON字串傳回給客戶
					try {
						JSONWriter.sendJSONResponse(response, schemes);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
//				}
//			} catch (SQLException e) {
//					e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

	private void queryMember(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	private void assignPM(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	private void unFreezeProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	private void queryProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		/*
		ProjectDataStructure projectDataStructure = new ProjectDataStructure();
		projectDataStructure.projectName = form.getProjectName();
		projectDataStructure.projectDescription = form.getProjectDescription() ;
		projectDataStructure.projectManager =  form.getProjectManager();
		projectDataStructure.projectState = form.getProjectState();
		projectDataStructure.startDate = form.getStartDate();
		projectDataStructure.endDate = form.getEndDate();*/
	}

	private void updateProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	private void freezeProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	private void delProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	private void addProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("name:"+form.name);
		System.out.println("destination:"+form.destination);
		System.out.println("leader:"+form.leader);
		System.out.println("startDate:"+form.startDate);
		System.out.println("endDate:"+form.endDate);
		boolean isSuccess = ProjectDBMgr.addProject(form.name, form.destination, form.leader, form.startDate, form.endDate);
//		boolean isSuccess =true;
		Result result = new Result();
		result.isSuccess = isSuccess;
		if(isSuccess)
		{
			result.message = "ok";
		}	
		else
		{
			result.message = "輸入不完整";
		}
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}