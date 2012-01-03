package com.projectplus.member;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ilinke.math.MD5Util;
import com.projectplus.db.DBMgr;

public class MemberDBMgr extends DBMgr{

	/**
	 * 
	 * @param email
	 * @return true:無人註冊  false:有人註冊
	 */
	static public boolean checkEmail(String email){
		if(email.length()==0)
			return false;
//		
//		//if(!isInit)
//		//	return null;
		ResultSet resultSet = null;
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM member where m_email='" + email + "'"); 
		    
		    if(resultSet.next()){ 
			    return false;
		    }
		    else
		    {
		    	return true;
		    }
		    
		    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
		    //return 0;    		
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		} 
		
		 
		//return 0;
	}
	
	/**
	 * 註冊會員
	 * @param name:真實姓名
	 * @param nickName:暱稱
	 * @param account:帳號
	 * @param password:密碼
	 * @param email
	 * @return true:註冊成功  false:註冊失敗
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	static public boolean register(String email, String password, String name, String nickName)  {
		//判斷是否無輸入,應該改在前端判斷!!!!!!!!!!!
		if(email.length()==0 || password.length()==0 ||name.length()==0 || password.length()==0 || nickName.length()==0)
			return false;
		//密碼加密md5
		MD5Util md5Util = new MD5Util();
		String md5_password = md5Util.getMD5HexStr(password, "utf8");
		//日期Format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
		
		
		if(!isInit)
			return false;
		try {
			pst = con.prepareStatement("insert into member(m_email,m_password,m_name,m_nickname,mdy_time) "
					+ " value (?,?,?,?,?)");
			pst.setString(1, email);
			pst.setString(2, md5_password);
			pst.setString(3, name);
			pst.setString(4, nickName);
			pst.setString(5, formatter.format(new Date()));
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		}
	}
	
	/**
	 * 會員資料
	 * @param email
	 */
	static public ResultSet queryMember(String email) {
		if(email.length()==0)
			return null;
		
		ResultSet resultSet=null;
		
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM member where m_email='" + email + "'"); 
		    return resultSet;

		    
		    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
		    //return 0;    		
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return null;
		} 
		
		
	}
	
	
	
	/**
	 * 會員登入
	 * @param account:登入帳戶
	 * @param password:登入密碼
	 * @return 0:登入成功  1:帳號或密碼錯誤 2:查無此帳號
	 * @throws NoSuchAlgorithmException 
	 */
	static public int checkLogin(String email, String password) {
		if(email.length()==0 || password.length()==0)
			return 1;
		
		//if(!isInit)
		//	return null;
		ResultSet resultSet = null;
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM member where m_email='" + email + "'"); 
		    
		    if(resultSet.next()){ 
		    	//加密md5
			    MD5Util md5Util = new MD5Util();
				String md5_password = md5Util.getMD5HexStr(password, "utf8");
				/*System.out.println(resultSet.getString("m_password"));
			    System.out.println(md5_password); */
			    if(md5_password.equals(resultSet.getString("m_password")))
			    	return 0;
			    else
			    	return 1;
		    }
		    else
		    {
		    	return 2;
		    }
		    
		    //return 0;    		
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return 1;
		} 
		
		 
		//return 0;
	}
	
	/**
	 * 
	 * @param m_name
	 * @return
	 */
	static public ResultSet queryNotInTeamMembers(String m_name, String team_id) {
		if(m_name.length()==0)
		{
			ResultSet resultSet=null;
			
			try {
				
				Statement stat = null; 
			    stat = con.createStatement(); 
			    resultSet = stat.executeQuery("SELECT * FROM member WHERE m_id not in (SELECT m_id FROM  g_m_relation where g_id='"+team_id+"')"); 
			    return resultSet;
	
			    
			    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
			    //return 0;    		
			} catch (SQLException e) {
				System.out.println("InsertDB Exception :" + e.toString());
				return null;
			} 
		}
		else
		{
			ResultSet resultSet=null;
			
			try {
				
				Statement stat = null; 
			    stat = con.createStatement(); 
			    resultSet = stat.executeQuery("SELECT * FROM member WHERE m_id not in (SELECT m_id FROM  g_m_relation where g_id='"+team_id+"') "+" where m_name like '%" + m_name + "%'"); 
			    return resultSet;
	
			    
			    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
			    //return 0;    		
			} catch (SQLException e) {
				System.out.println("InsertDB Exception :" + e.toString());
				return null;
			} 
		}
		
		
	}
	
	/**
	 * 
	 * @param m_id
	 * @param team_id
	 * @return
	 */
	static public boolean newMember(String m_id, String team_id) {
		
		if(!isInit)
			return false;
		try {
			pst = con.prepareStatement("insert into `g_m_relation`(`m_id`,`g_id`,`status`,`l_id`) "
					+ " value (?,?,1,3)");
			pst.setString(1, m_id);
			pst.setString(2, team_id);
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		}
	}
	
	/**
	 * 
	 * @param m_email
	 * @param m_name
	 * @param m_nickName
	 * @param m_gender
	 * @param m_birthday
	 * @param m_imageURL
	 * @param m_addr
	 * @param m_tel
	 * @param m_phone
	 * @param m_introduction
	 * @param m_web
	 * @param m_note
	 * @return true:修改成功 false:修改失敗
	 */
	static public boolean updDetail(String m_email, String m_name, String m_nickName, String m_gender, String m_birthday, String m_imageURL, String m_addr, String m_tel, String m_phone, String m_introduction,String m_web, String m_note) {
			
		//日期Format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
				
			
		if(!isInit)
			return false;
			try {
				pst = con.prepareStatement("update member set m_name='"+m_name+"' , m_nickName='"+m_nickName+"' , m_gender='"+m_gender+"' , m_birthday='"+m_birthday+"' , m_imageURL='"+m_imageURL+"' , m_addr='"+m_addr+"' , m_tel='"+m_tel+"' , m_phone='"+m_phone+"' , m_introduction='"+m_introduction+"' , m_web ='"+m_web+"' ,m_note='"+m_note+"' ,mdy_time='"+formatter.format(new Date())+"' where m_email='"+m_email+"'");
				pst.executeUpdate();
				return true;
					
			} catch (SQLException e) {
				System.out.println("InsertDB Exception :" + e.toString());
				return false;
			}
	}
	
	/**
	 * 修改密碼
	 * @param account:修改密碼
	 * @param password:新密碼
	 * @return true:成功  false:失敗
	 */
	static public boolean updPassword(String account, String password) {
		return true;
	}
	
	/**
	 * 會員解凍
	 * @param account:欲解凍帳號
	 * @return true:解凍成功 false:解凍失敗
	 */
	static public boolean unfreeze(String account){
		return true;
	}
	
	/**
	 * 凍結會員
	 * @param account:欲凍結會員帳號
	 * @return true:凍結成功 false:凍結o失敗
	 */
	static public boolean freeze(String account) {
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		//try{

			//System.out.println(register("beatrice051611@gmail.com","123456","楊先絜","先絜"));
			//System.out.println(checkLogin("beatrice0516@gmail.com", "123456"));
		//System.out.println(checkEmail("beatrice05o16@gmail.com"));
//		ResultSet test = queryMember("beatrice0516@gmail.com");
//		try {
//			test.next();
//			System.out.println(test.getString("m_email"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//}
		//catch(NoSuchAlgorithmException e)
		//{
			//System.out.println(e);
		//}
		//System.out.println(updDetail("beatri77666ce0251611@gmail.com",  "m_namjolke",  "m_nickName",  "男",  "1990-05-16",  "",  "m_addr",  "",  "",  "", "",  ""));
		
	}

	public static boolean delMember(String id, String teamId) {
		// TODO Auto-generated method stub
		return false;
	}
}
