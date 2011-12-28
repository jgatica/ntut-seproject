package com.projectplus.member;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projectplus.context.Result;
import com.projectplus.context.SessionContext;
import com.projectplus.util.JSONWriter;

public class MemberAction extends Action {
	
	public static final int REGISTER = 0;
	public static final int LOGIN = 1;
	public static final int LOGOUT = 2;
	public static final int QYDATA = 3;
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
		      HttpServletRequest request, HttpServletResponse response) {
			
		    HttpSession session = request.getSession();
		    MemberActionForm form = (MemberActionForm)actionForm;
		    
		    int op = form.getOp();
		    
		    System.out.println("the op  = " + op);
		    
		    switch (op) {
		    // 註冊會員
			case REGISTER:
				return register(mapping, form, request, response, session);
			// 會員登入
			case LOGIN:
				return login(mapping, form, request, response, session);
				
			case LOGOUT:
				return logout(mapping, form, request, response, session);
			case QYDATA:
				return quaryData(mapping, form, request, response, session);
			default:
				break;
			}
		    
		    return null;
	}

	
	private ActionForward quaryData(ActionMapping mapping,
			MemberActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
		MemberDataStructure data = (MemberDataStructure)session.getAttribute(SessionContext.USERDATA);
//		MemberDataStructure data = null;
		Result result = new Result();
		result.isSuccess=data!=null;
		if(result.isSuccess)
		{
			result.message="ok";
		}
		else
		{
			//session.setAttribute(SessionContext.ISLOGIN, "false");
			result.message="輸入不完整.";
		}
		try {
			if(data==null)
			{
				/*data=new MemberDataStructure(); 
				data.imageURL="/images/2.jpg";
				data.member_address="Taichung";
				data.member_blood="AB";
				data.member_birthday="1990-02-16";
				data.member_descript="NTUT 圓圓";
				data.member_Gender="男";
				data.member_name="陳至圓";
				data.member_nickname="圓圓";*/
				System.out.println("未登入");
			}
			data.setResult(result);
			JSONWriter.sendJSONResponse(response, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	private ActionForward logout(ActionMapping mapping, MemberActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		session.removeAttribute(SessionContext.ISLOGIN);
		session.removeAttribute(SessionContext.USERDATA);
		Result result = new Result();
		result.isSuccess=true;
		result.message="ok";
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 登入
	 */
	private ActionForward login(ActionMapping mapping, MemberActionForm form,
		HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//MemberDBmgr dbMgr= new MemberDBmgr();
	//DON'T NEW
		boolean isSuccess = MemberDBMgr.checkLogin(form.member_email, form.password);
		Result result = new Result();
		result.isSuccess=isSuccess;
		if(isSuccess)
		{
			session.setAttribute(SessionContext.ISLOGIN, isSuccess);
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


	/**
	 * 註冊會員
	 */
	private ActionForward register(ActionMapping mapping, MemberActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		/*System.out.println("name:"+form.member_name);
		System.out.println("password:"+form.password);
		System.out.println("member_nickname:"+form.member_nickname);
		System.out.println("member_email:"+form.member_email);*/
		MemberDataStructure data = MemberDBMgr.register(form.member_name,form.member_nickname,form.member_email,form.password);
		//boolean isSuccess = MemberDBMgr.register(form.member_name,form.member_nickname,form.member_email,form.password);
		
		Result result = new Result();
		result.isSuccess=data!=null;
		//System.out.println("Session time:"+session.getMaxInactiveInterval());
		
		if(result.isSuccess)
		{
			session.setAttribute(SessionContext.ISLOGIN, result.isSuccess);
			session.setAttribute(SessionContext.USERDATA, data);
			result.message="ok";
			System.out.println("ok");
		}
		else
		{
			//session.setAttribute(SessionContext.ISLOGIN, "false");
			result.message="輸入不完整.";
			System.out.println("no");
		}
		try {
			if(data==null)
				data=new MemberDataStructure(); 
			data.setResult(result);
			JSONWriter.sendJSONResponse(response, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
