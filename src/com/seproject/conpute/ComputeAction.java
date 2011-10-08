package com.seproject.conpute;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.seproject.util.JSONWriter;

public class ComputeAction extends Action {

	public static final int OP_ADD = 0;	// 處理加法操作
	public static final int OP_DIV = 1;	// 處理除法操作
	public static final int OP_LISTMEMBER = 2; //列出會員列表(測試DBMgr用)
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		ComputeForm computeForm = (ComputeForm) form;

		int op = computeForm.getOp();
		switch (op) {
		case OP_ADD:// OP 0 處理加法運算
			return addOP(mapping, computeForm, request, response, session);
		case OP_DIV:// OP 1 處理除法運算
			return divOP(mapping, computeForm, request, response, session);
		case OP_LISTMEMBER:
			return listMembers(mapping, computeForm, request, response, session);
		default:
			break;
		}
		return null;
	}

	/**
	 * OP 0 用來處理加法運算
	 * 
	 * @author Augus
	 * @throws IOException 
	 * @Time 2011/10/8
	 */
	private ActionForward addOP(ActionMapping mapping, ComputeForm computeForm,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {

		double arg1 = computeForm.getArg1();
		double arg2 = computeForm.getArg2();
		double anwser = compute(arg1, arg2, '+');
		request.setAttribute("anwser", anwser);
		JSONWriter.sendJSONRequest(response.getOutputStream(), anwser);
		
		return null;
	}

	/**
	 * OP 1 用來處理除法運算
	 * 
	 * @author Augus
	 * @throws IOException 
	 * @Time 2011/10/8
	 */
	private ActionForward divOP(ActionMapping mapping, ComputeForm computeForm,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		double arg1 = computeForm.getArg1();
		double arg2 = computeForm.getArg2();
		double anwser = compute(arg1, arg2, '/');
		JSONWriter.sendJSONRequest(response.getOutputStream(), anwser);
		
		return null;
	}

	/**
	 * OP 3 取得符號列表
	 * 使用DBMgr的範例
	 * @throws IOException
	 */
	private ActionForward listMembers(ActionMapping mapping,
			ComputeForm computeForm, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {
		
		ArrayList<String> opsArrayList = ComputeDBMgr.listOption();
		JSONWriter.sendJSONRequest(response.getOutputStream(), opsArrayList);
		
		return null;
	}
	
	private double compute(double arg1, double arg2, char symbol) {
		switch (symbol) {
		case '+':
			return arg1 + arg2;
		case '-':
			return arg1 - arg2;
		case '*':
			return arg1 * arg2;
		case '/':
			return arg1 / arg2;
		default:
			return arg1 + arg2;
		}
	}

}
