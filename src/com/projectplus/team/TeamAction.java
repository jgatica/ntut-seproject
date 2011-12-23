package com.projectplus.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TeamAction extends Action {
	
	public static final int ADDTEAM= 0;
	public static final int DELTEAM= 1;
	public static final int UPDTEAM= 2;
	public static final int QYTEAM = 3;
	public static final int QYMEMBER = 4;
	public static final int QYPROJECT = 5;
	public static final int ADDTEAMMEMBER = 6;
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		TeamActionForm form = (TeamActionForm) actionForm;
		
		int op = form.getOp();

		switch (op) {
			case ADDTEAM:
				addTeam(mapping, form, request, response, session);
			case DELTEAM:
				delTeam(mapping, form, request, response, session);
			case UPDTEAM:
				updateTeam(mapping, form, request, response, session);
			case QYTEAM:
				queryTeam(mapping, form, request, response, session);
			case ADDTEAMMEMBER:
				addTeamMember(mapping, form, request, response, session);
		}
		
		return null;
	}
	
	private void addTeamMember(ActionMapping mapping, TeamActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		// 呼叫 TeamDBMgr.addTeamMember(該會員id)
		
	}
	
	private void queryTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	private void updateTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}
	
	private void delTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
	}

	private void addTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
	}
}
