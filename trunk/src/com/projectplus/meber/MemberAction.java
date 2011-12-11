package com.projectplus.meber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MemberAction extends Action {
	
	public static final int REGISTER = 0;
	public static final int LOGIN = 1;
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
		      HttpServletRequest request, HttpServletResponse response) {
		
		    HttpSession session = request.getSession();
		    MemberActionForm form = (MemberActionForm)actionForm;
		    
		    int op = form.getOp();
		    
		    switch (op) {
		    // 註冊會員
			case REGISTER:
				return register(mapping, form, request, response, session);
			// 會員登入
			case LOGIN:
				return login(mapping, form, request, response, session);
			default:
				break;
			}
		    
		    return null;
	}

	
	/**
	 * 登入
	 */
	private ActionForward login(ActionMapping mapping, MemberActionForm form,
		HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		return null;
	}


	/**
	 * 註冊會員
	 */
	private ActionForward register(ActionMapping mapping, MemberActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		return null;
	}
}
