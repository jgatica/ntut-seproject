package com.projectplus.project;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
		}
		
		return null;
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
