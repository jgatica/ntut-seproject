package com.projectplus.project;

import java.io.IOException;
import java.sql.ResultSet;
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
		System.out.println("the op  = " + op);
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
			case QYPROJECT:
				return queryProject(mapping, form, request, response, session);
			case ASSIGNPM:
				return assignPM(mapping, form, request, response, session);
			case QYMEMBER:
				return queryMember(mapping, form, request, response, session);
			case WBSTREE:
				return queryWbsTree(mapping, form, request, response, session);
		}
		
		return null;
	}

	
	/**
	 * OP 8
	 * 建構WBS TREE並回傳給前端顯示
	 * @return 
	 */
	private ActionForward queryWbsTree(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ResultSet resultSet = null;
		ArrayList<WbsScheme> schemes = new ArrayList<WbsScheme>();
		// Step:1 由DB撈出所有的Task
//		resultSet = ProjectDBMgr.listTask("projectId:123456");
		
//		if(resultSet != null){
//			try {
//				while(resultSet.next()){
					// Step:2 使用WbsSchemeCreator.createWbsScheme 建構節點
					WbsScheme scheme = WbsSchemeCreator.createWbsScheme("", "jQuery開發團", "我是根結點");
					WbsScheme scheme2 = WbsSchemeCreator.createWbsScheme("jQuery開發團", "開發WBS系統", "根");
					WbsScheme scheme3 = WbsSchemeCreator.createWbsScheme("jQuery開發團", "開發登入系統", "二之二");
					WbsScheme scheme4 = WbsSchemeCreator.createWbsScheme("jQuery開發團", "開發估算系統", "三之三");
					WbsScheme scheme5 = WbsSchemeCreator.createWbsScheme("開發WBS系統", "美化外觀", "二之一");
					WbsScheme scheme6 = WbsSchemeCreator.createWbsScheme("開發WBS系統", "更改超連結功能", "二之一");
					WbsScheme scheme7 = WbsSchemeCreator.createWbsScheme("開發登入系統", "資料庫實作", "二之一");
					WbsScheme scheme8 = WbsSchemeCreator.createWbsScheme("開發登入系統", "fb登入模式實作", "二之一");
					WbsScheme scheme9 = WbsSchemeCreator.createWbsScheme("開發估算系統", "COCOMO開發", "二之一");
					WbsScheme scheme10 = WbsSchemeCreator.createWbsScheme("開發估算系統", "Function Point開發", "二之一");
					
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
					schemes.add(scheme9);
					schemes.add(scheme10);
					
					// Step:4 轉換該ArrayList為WBS Tree JSON字串傳回給客戶
					try {
						JSONWriter.sendJSONResponse(response, schemes);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
					
//				}
//			} catch (SQLException e) {
//					e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

	private ActionForward queryMember(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}

	private ActionForward assignPM(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}

	private ActionForward unFreezeProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}

	private ActionForward queryProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
				return null;
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

	private ActionForward updateProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}

	private ActionForward freezeProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}

	private ActionForward delProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}

	private ActionForward addProject(ActionMapping mapping, ProjectActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		/*System.out.println("name:"+form.name);
		System.out.println("destination:"+form.destination);
		System.out.println("leader:"+form.leader);
		System.out.println("startDate:"+form.startDate);
		System.out.println("endDate:"+form.endDate);*/
		//boolean isSuccess =true;
		boolean isSuccess = ProjectDBMgr.addProject(form.name, form.destination, form.leader, form.startDate, form.endDate);
		Result result = new Result();
		result.isSuccess = isSuccess;
		result.message = "ok";
		result.isSuccess=isSuccess;
		if(isSuccess)
		{
			//session.setAttribute(SessionContext.ISLOGIN, isSuccess);
			result.message="ok";
		}
		else
		{
			//session.setAttribute(SessionContext.ISLOGIN, "false");
			result.message="帳號或密碼位輸入";
		}
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
