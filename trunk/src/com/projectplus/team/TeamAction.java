package com.projectplus.team;

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
		//System.out.println("the op  = " + op);

		switch (op) {
			case ADDTEAM:
				return addTeam(mapping, form, request, response, session);
			case DELTEAM:
				return delTeam(mapping, form, request, response, session);
			case UPDTEAM:
				return updateTeam(mapping, form, request, response, session);
			case QYTEAM:
				return queryTeam(mapping, form, request, response, session);
			case ADDTEAMMEMBER:
				return addTeamMember(mapping, form, request, response, session);
		}
		
		return null;
	}
	
	private ActionForward addTeamMember(ActionMapping mapping, TeamActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
				return null;

		
		// 呼叫 TeamDBMgr.addTeamMember(該會員id)
		
	}
	
	private ActionForward queryTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}

	private ActionForward updateTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}
	
	private ActionForward delTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
				return null;
		
	}

	private ActionForward addTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		/*System.out.println("name:"+form.name);
		System.out.println("description:"+form.description);
		System.out.println("fax:"+form.fax);
		System.out.println("phone:"+form.phone);
		System.out.println("address:"+form.address);
		System.out.println("mail:"+form.mail);*/
		
		boolean isSuccess = TeamDBMgr.addTeam(form.name, form.description, form.fax, form.phone, form.address, form.mail);
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
		return null;
	}
	
}
