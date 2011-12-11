package com.projectplus.practice;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projectplus.util.JSONWriter;



public class ArticleAction extends Action {
	
	public static final int ADD_ARTICLE = 0; 	// 新增文章
	public static final int QY_ARTICLE = 4; 	// 查詢文章
	public static final int LIST_ARTICLE = 5; 	// 列表文章
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
		      HttpServletRequest request, HttpServletResponse response) {
		
		    HttpSession session = request.getSession();
		    
		    ArticleForm form = (ArticleForm)actionForm;
		    
		    int op = form.getOp();
		    
		    switch (op) {
		    	// 新增文章
		    	case ADD_ARTICLE:
		    		return addArticle(mapping, form, request, response, session);
		    	// 查詢文章	
		    	case QY_ARTICLE:
		    		return qyArticle(mapping, form, request, response, session);
		    	// 列表文章	
		    	case LIST_ARTICLE:
		    		return listArticle(mapping, form, request, response, session);
		    }
		    return null;
	}


	/**
	 * OP 5
	 * 列表文章
	 */
	private ActionForward listArticle(ActionMapping mapping, ArticleForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		int start = form.getStart();
		int length = form.getLength();
		
		ArrayList<ArticleDataStructure> list = new ArrayList<ArticleDataStructure>();
		ResultSet resultSet = ArticleDBMgr.listArticle(start, length);
		try {
			while(resultSet.next()){
				ArticleDataStructure articleDataStructure = new ArticleDataStructure();
				articleDataStructure.id = resultSet.getInt("idarticle");
				articleDataStructure.title = resultSet.getString("title");
				articleDataStructure.content = resultSet.getString("content");
				articleDataStructure.tag = resultSet.getString("tag");
				articleDataStructure.author = resultSet.getString("author");
				articleDataStructure.createtime = resultSet.getLong("createtime");
				articleDataStructure.edittime = resultSet.getLong("edittime");
				list.add(articleDataStructure);
				System.out.println(list);
			}
			JSONWriter.sendJSONResponse(response, list);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * OP 4
	 * 查詢文章 
	 */
	private ActionForward qyArticle(ActionMapping mapping, ArticleForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		int articleId = form.getId();
		ArrayList<ArticleDataStructure> list = new ArrayList<ArticleDataStructure>();
		ResultSet resultSet = ArticleDBMgr.queryArticle(articleId);
		try {
			while(resultSet.next()){
				ArticleDataStructure articleDataStructure = new ArticleDataStructure();
				articleDataStructure.id = resultSet.getInt("idarticle");
				articleDataStructure.title = resultSet.getString("title");
				articleDataStructure.content = resultSet.getString("content");
				articleDataStructure.tag = resultSet.getString("tag");
				articleDataStructure.author = resultSet.getString("author");
				articleDataStructure.createtime = resultSet.getLong("createtime");
				articleDataStructure.edittime = resultSet.getLong("edittime");
				list.add(articleDataStructure);
				System.out.println(list);
			}
			JSONWriter.sendJSONResponse(response, list);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}



	/**
	 * OP 0
	 * 新增文章
	 */
	private ActionForward addArticle(ActionMapping mapping, ArticleForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		return null;
	}
}
