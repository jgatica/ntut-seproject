package com.projectplus.member;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public static final int QYMEMBERBYCMP = 4;
	public static final int ADDTEAMMEMBER = 5;
	public static final int DELTEAMMEMBER = 6;
	public static final int UPDINFO = 7;

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		MemberActionForm form = (MemberActionForm) actionForm;

		int op = form.getOp();

		//System.out.println("the op  = " + op);

		switch (op) {
			// 註冊會員
		case REGISTER:
			return register(mapping, form, request, response, session);
			// 會員登入
		case LOGIN:
			return login(mapping, form, request, response, session);
			// 會員登出
		case LOGOUT:
			return logout(mapping, form, request, response, session);
			// 會員資料查詢
		case QYDATA:
			return queryData(mapping, form, request, response, session);
			// 模糊比對會員
		case QYMEMBERBYCMP:
			return queryMemberByCMP(mapping, form, request, response, session);
			// 新增團隊成員
		case ADDTEAMMEMBER:
			return addTeamMember(mapping, form, request, response, session);
			// 刪成團隊成員
		case DELTEAMMEMBER:
			return delTeamMember(mapping, form, request, response, session);
		case UPDINFO:
			return updateMemberInfo(mapping, form, request, response, session);
		default:
			break;
		}

		return null;
	}

	private ActionForward updateMemberInfo(ActionMapping mapping, MemberActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String email = form.getMember_email();
		String phone = form.getMember_phone();
		String mobile = form.getMember_mobile();
		String address = form.getMember_address();
		
		
		
		
		
		return null;
	}

	private ActionForward delTeamMember(ActionMapping mapping,
			MemberActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		boolean isSuccess = MemberDBMgr.delMember(form.id, form.teamId);
		Result result = new Result();
		result.isSuccess = isSuccess;
		if (result.isSuccess)
			result.message = "ok";
		else
			result.message = "faild";
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ActionForward addTeamMember(ActionMapping mapping,
			MemberActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		/*
		 * System.out.println(form.id); System.out.println(form.teamId);
		 */
		boolean isSuccess = MemberDBMgr.newMember(form.id, form.teamId);
		Result result = new Result();
		result.isSuccess = isSuccess;
		if (result.isSuccess)
			result.message = "ok";
		else
			result.message = "faild";
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ActionForward queryMemberByCMP(ActionMapping mapping,
			MemberActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		boolean check = form.member_name != null
				&& form.member_name.length() != 0;
		ResultSet resultSet = null;
		if (check)
			resultSet = MemberDBMgr.queryNotInTeamMembers(form.member_name,form.teamId);
		List<MemberDataStructure> dataList = new ArrayList<MemberDataStructure>();

		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					MemberDataStructure data = new MemberDataStructure();// 真的
					data.setId(resultSet.getString("m_id"));
					data.setImageURL(resultSet.getString("m_imageURL") == null ? "/images/default.jpg"
							: resultSet.getString("m_imageURL"));
					data.setMember_name(resultSet.getString("m_name"));
					dataList.add(data);
				}
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

	private ActionForward queryData(ActionMapping mapping,
			MemberActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		MemberDataStructure userData = (MemberDataStructure) session
				.getAttribute(SessionContext.USERDATA);
		String member_mail = userData.member_email;
		ResultSet resultSet = MemberDBMgr.queryMember(member_mail);

		MemberDataStructure data = null;
		try {
			if (resultSet != null && resultSet.next()) {
				data = new MemberDataStructure();// 真的
				data.setId(resultSet.getString("m_id"));
				data.setImageURL(resultSet.getString("m_imageURL"));
				data.setMember_name(resultSet.getString("m_name"));
				data.setMember_gender(resultSet.getString("m_gender"));
				data.setMember_address(resultSet.getString("m_addr"));
				data.setMember_birthday(resultSet.getString("m_birthday"));
				data.setMember_descript(resultSet.getString("m_introduction"));
				data.setMember_email(member_mail);
				data.setMember_mobile(resultSet.getString("m_phone"));
				data.setMember_phone(resultSet.getString("m_tel"));
				data.setMember_nickname(resultSet.getString("m_nickname"));
			} /*
			 * else// 假的(測試用) 如有真資料請將此部分刪除 直接return null { data = new
			 * MemberDataStructure(); data.setImageURL("/images/2.jpg");
			 * data.setMember_name(userData.member_name);
			 * data.setMember_gender(userData.member_gender);
			 * data.setMember_address(userData.member_address);
			 * data.setMember_birthday(userData.member_birthday);
			 * data.setMember_descript(userData.member_descript);
			 * data.setMember_email(userData.member_email);
			 * data.setMember_mobile(userData.member_mobile);
			 * data.setMember_phone(userData.member_phone);
			 * data.setMember_nickname(userData.member_nickname); }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Result result = new Result();
		result.isSuccess = resultSet != null;
		if (result.isSuccess) {
			result.message = "ok";
		} else {
			// session.setAttribute(SessionContext.ISLOGIN, "false");
			result.message = "輸入不完整.";
		}
		try {
			data.setResult(result);
			session.setAttribute(SessionContext.USERDATA, data);
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
		result.isSuccess = true;
		result.message = "ok";
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
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		/*
		 * System.out.println("name:"+form.member_name);
		 * System.out.println("password:"+form.password);
		 * System.out.println("member_nickname:"+form.member_nickname);
		 * System.out.println("member_email:"+form.member_email);
		 */
		String message[] = { "登入成功", "帳號或密碼錯誤", "查無此帳號" };
		boolean check = (form.member_email == null || form.password == null)
				|| (form.member_email.length() == 0 || form.password.length() == 0);

		int state = MemberDBMgr.checkLogin(form.member_email, form.password);
		ResultSet resultSet = null;
		MemberDataStructure data = new MemberDataStructure();
		Result result = new Result();
		result.isSuccess = state == 0 && !check;
		if (result.isSuccess)
			resultSet = MemberDBMgr.queryMember(form.member_email);
		try {
			if (resultSet != null && resultSet.next()) {
				data = new MemberDataStructure();// 真的
				data.setId(resultSet.getString("m_id"));
				data.setImageURL(resultSet.getString("m_imageURL"));
				data.setMember_name(resultSet.getString("m_name"));
				data.setMember_gender(resultSet.getString("m_gender"));
				data.setMember_address(resultSet.getString("m_addr"));
				data.setMember_birthday(resultSet.getString("m_birthday"));
				data.setMember_descript(resultSet.getString("m_introduction"));
				data.setMember_email(form.member_email);
				data.setMember_mobile(resultSet.getString("m_phone"));
				data.setMember_phone(resultSet.getString("m_tel"));
				data.setMember_nickname(resultSet.getString("m_nickname"));
				session.setAttribute(SessionContext.ISLOGIN, result.isSuccess);
				session.setAttribute(SessionContext.USERDATA, data);
				result.message = "ok";

			} else {
				// session.setAttribute(SessionContext.ISLOGIN, "false");
				result.message = message[state];
			}
			try {
				data.setResult(result);
				JSONWriter.sendJSONResponse(response, data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 註冊會員
	 */
	private ActionForward register(ActionMapping mapping,
			MemberActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		/*
		 * System.out.println("name:"+form.member_name);
		 * System.out.println("password:"+form.password);
		 * System.out.println("member_nickname:"+form.member_nickname);
		 * System.out.println("member_email:"+form.member_email);
		 */
		boolean check = form.member_email.length() == 0
				|| form.password.length() == 0
				|| form.member_name.length() == 0
				|| form.member_nickname.length() == 0
				|| form.password.length() == 0;
		boolean isSuccess = MemberDBMgr.register(form.member_email,
				form.password, form.member_name, form.member_nickname);

		Result result = new Result();
		result.isSuccess = isSuccess && !check;
		MemberDataStructure data = null;

		if (result.isSuccess) {
			data = new MemberDataStructure();
			data.setImageURL("/images/2.jpg");
			data.setMember_name(form.member_name);
			data.setMember_gender(form.member_gender);
			data.setMember_address(form.member_address);
			data.setMember_birthday(form.member_birthday);
			data.setMember_descript(form.member_descript);
			data.setMember_email(form.member_email);
			data.setMember_mobile(form.member_mobile);
			data.setMember_phone(form.member_phone);
			data.setMember_nickname(form.member_nickname);
			session.setAttribute(SessionContext.ISLOGIN, isSuccess);
			session.setAttribute(SessionContext.USERDATA, data);
			result.message = "ok";
		} else {
			data = new MemberDataStructure();
			result.message = "輸入不完整.";
			// System.out.println("no");
		}
		try {
			data.setResult(result);
			JSONWriter.sendJSONResponse(response, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
