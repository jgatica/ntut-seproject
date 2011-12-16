package com.projectplus.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ProjectAction extends Action {

	
	public static final int ADDPROJECT= 3;
	public static final int DELPROJECT= 4;
	public static final int FREEZEPROJECT= 5;
	public static final int UNFREEZEPROJECT= 6;
	public static final int UPDPROJECT= 7;
	public static final int QYPROJECT = 10;
	
	
	public static final int ASSIGNPM = 4;
	public static final int QYMEMBER = 6;
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ProjectActionForm form = (ProjectActionForm) actionForm;
		
		int op = form.getOp();

		switch (op) {
		}
		
		return null;
	}
}
