package com.projectplus.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
		// TODO Auto-generated method stub
		
	}
}
