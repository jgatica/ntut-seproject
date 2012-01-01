package com.projectplus.team;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ilinke.math.MD5Util;
import com.projectplus.db.DBMgr;

public class TeamDBMgr extends DBMgr {
	
	/**
	 * 
	 * @param email
	 * @return true:無相同名稱  false:有相同名稱
	 */
	static public boolean checkTeamName(String name){
		if(name.length()==0)
			return false;
//		
//		//if(!isInit)
//		//	return null;
		ResultSet resultSet = null;
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM `group` where g_name='" + name + "'"); 
		    
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
	 * 
	 * @param name
	 * @param desc
	 * @param fax
	 * @param phone
	 * @param address
	 * @param mail
	 * @param add_id 做此操作的email
	 * @return
	 */
	public static boolean addTeam(String name,String desc,String fax,String phone,String mail,String add_id)
	{
		if(name.length()==0 || fax.length()==0 || phone.length()==0 || mail.length()==0)
			return false;
		//日期Format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
		

		if(!isInit)
			return false;
		try {
			pst = con.prepareStatement("insert into `group`(`g_name`,`g_introduction`,`g_contact_fax`,`g_contact_phone`,`g_mail`,`add_id`,`mdy_time`,`mdy_id`) "
					+ " value (?,?,?,?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, desc);
			pst.setString(3, fax);
			pst.setString(4, phone);
			pst.setString(5, mail);
			pst.setString(6, add_id);
			pst.setString(7, formatter.format(new Date()));
			pst.setString(8, add_id);
			
			//int rows = pst.executeUpdate(pst.toString(),Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			ResultSet rs=pst.getGeneratedKeys();
			rs.next();
			String id = rs.getString(1);
			
			pst = con.prepareStatement("insert into `g_m_relation`(`m_id`,`g_id`,`status`,`l_id`) "
					+ " value (?,?,1,1)");
			pst.setString(1, add_id);
			pst.setString(2, id);
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		}
	}
	
	
	
	

	
	/**
	 *  公司資料
	 * @param name
	 * @return
	 */
	static public ResultSet queryTeam(String id) {
		if(id.length()==0)
			return null;
		
		ResultSet resultSet=null;
		
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM `group` as g left join `member` as m on g.add_id=m_id where g_id='" + id + "'"); 
		    return resultSet;

		    
		    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
		    //return 0;    		
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return null;
		} 
		
		
	}
	
	public static ResultSet queryTeamMembers(String team_id) {
		if(team_id.length()==0)
			return null;
		
		ResultSet resultSet=null;
		
		try {
			
			Statement stat = null; 
			
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT distinct m_id,m_name,m_imageURL FROM `g_m_relation` as gm left join `member` as m on gm.m_id=m.m_id where gm.g_id='" + team_id + "'"); 
		    return resultSet;

		    
		    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
		    //return 0;    		
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return null;
		} 
	}

	public static ResultSet queryMemberTeams(String m_id) {
		if(m_id.length()==0)
			return null;
		
		ResultSet resultSet=null;
		
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM `g_m_relation` as gm left join `group` as g on gm.g_id=g.g_id where gm.m_id='" + m_id + "'"); 
		    return resultSet;

		    
		    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
		    //return 0;    		
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return null;
		} 
	}
	
//	/**
//	 * 會員登入
//	 * @param account:登入帳戶
//	 * @param password:登入密碼
//	 * @return 0:登入成功  1:帳號或密碼錯誤 2:查無此帳號
//	 * @throws NoSuchAlgorithmException 
//	 */
//	static public int checkLogin(String email, String password) {
//		if(email.length()==0 || password.length()==0)
//			return 1;
//		
//		//if(!isInit)
//		//	return null;
//		ResultSet resultSet = null;
//		try {
//			
//			Statement stat = null; 
//		    stat = con.createStatement(); 
//		    resultSet = stat.executeQuery("SELECT * FROM member where m_email='" + email + "'"); 
//		    
//		    if(resultSet.next()){ 
//		    	//加密md5
//			    MD5Util md5Util = new MD5Util();
//				String md5_password = md5Util.getMD5HexStr(password, "utf8");
//		        
//			    if(md5_password.equals(resultSet.getString("m_password")))
//			    	return 0;
//			    else
//			    	return 1;
//		    }
//		    else
//		    {
//		    	return 2;
//		    }
//		    
//		    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
//		    //return 0;    		
//		} catch (SQLException e) {
//			System.out.println("InsertDB Exception :" + e.toString());
//			return 1;
//		} 
//		
//		 
//		//return 0;
//	}
	public static void main(String[] args) {
		
		//差加入公司後要增加一個關連g_m_relation
		
		//System.out.println(addTeam("超專業必殺公司","沒有不可能!沒有做不到!包準你滿意!不滿意退錢!不熱門退錢!","02-27712171","0972923997","超專業必殺秘密基地","beatrice0516@gmail.com","23"));
		//System.out.println(checkTeamName("超專業必殺公司"));
		
//		ResultSet test = queryTeam("超專業必殺公司");
//		try {
//			test.next();
//			System.out.println(test.getString("g_introduction"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ResultSet test = queryTeamMembers("11");
//		try {
//			test.next();
//			System.out.println(test.getString("m_name"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		ResultSet test = queryMemberTeams("35");
//		try {
//			test.next();
//			System.out.println(test.getString("g_name"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	
	
	
}
