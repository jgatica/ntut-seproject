package com.projectplus.practice;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.projectplus.db.DBMgr;


public class ArticleDBMgr extends DBMgr{


	// 完整使用完資料庫後,記得要關閉所有Object
	// 否則在等待Timeout時,可能會有Connection poor的狀況
//	private void Close() {
//		try {
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//			if (stat != null) {
//				stat.close();
//				stat = null;
//			}
//			if (pst != null) {
//				pst.close();
//				pst = null;
//			}
//		} catch (SQLException e) {
//			System.out.println("Close Exception :" + e.toString());
//		}
//	}
	/**
	 * 新增文章
	 * @param title 文章標題
	 * @param content 文章內容
	 * @param tag 文章標籤
	 * @param author 作者
	 * @return true:新增成功  false:新增失敗
	 */
	static public boolean addArticle(String title, String content, String tag, String author) {
		if(!isInit)
			return false;
		try {
			pst = con.prepareStatement("insert into article(idarticle,title,content,tag,author,createtime,edittime) "
					+ "select ifNULL(max(idarticle),0)+1,?,?,?,?,?,? FROM article");
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, tag);
			pst.setString(4, author);
			pst.setLong(5, System.currentTimeMillis());
			pst.setLong(6, System.currentTimeMillis());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		} 
		return true;
	}
	
	/**
	 * 更新文章資料
	 * @param articleId 欲更新文章之id
	 * @param title 文章標題
	 * @param content 文章內容
	 * @param tag 文章標籤
	 * @param author 作者
	 * @return true:更新成功  false:更新失敗
	 */
	static public boolean updArticle(int articleId, String title, String content, String tag, String author) {
		if(!isInit)
			return false;
		try {
			pst = con.prepareStatement("UPDATE article SET title='"+title
														 +"', content='"+content
														 +"', tag='"+tag
														 +"', author='"+author
														 +"', edittime='"+System.currentTimeMillis()
														 +"' WHERE idarticle="+ articleId);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		} 
		return true;
	}
	
	/**
	 * 刪除文章
	 * @param articleId 欲刪除文章ID
	 * @return true:刪除成功  false:刪除失敗
	 */
	static public boolean delArticle(int articleId){
		if(!isInit)
			return false;
		try {
			pst = con.prepareStatement("DELETE FROM article WHERE idarticle="+ articleId);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		} 
		
		return true;
	}
	
	/**
	 * 查詢列表
	 * @return
	 */
	static public ResultSet listArticle(int start, int length){
		if(!isInit)
			return null;
		ResultSet resultSet = null;
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM article Limit " + start + "," + length); 
		    
//		    while(resultSet.next()) 
//		      { 
//		        System.out.println(resultSet.getInt("idarticle")+"\t\t"+ 
//		        		resultSet.getString("title")+"\t\t"+resultSet.getString("content")); 
//		      } 
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return null;
		} 
		return resultSet;
	}
	
	/**
	 * 查詢單筆資料
	 * @param articleId
	 * @return
	 */
	static public ResultSet queryArticle(int articleId){
		if(!isInit)
			return null;
		ResultSet resultSet = null;
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM article WHERE idarticle="+ articleId); 
		    
//		    while(resultSet.next()) 
//		      { 
//		        System.out.println(resultSet.getInt("idarticle")+"\t\t"+ 
//		        		resultSet.getString("title")+"\t\t"+resultSet.getString("content")); 
//		      } 
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return null;
		} 
		return resultSet;
	}
	
	
	public static void main(String[] args) {
//		addArticle("Title111", "Content", "Tag", "augus");
//		updArticle(5, "Title44", "Content2", "Tag2", "augus2");
//		delArticle(5);
//		queryArticle(2);
		listArticle(2,3);
	}
}
