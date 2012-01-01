package com.projectplus.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.projectplus.db.DBMgr;

public class ProjectDBMgr extends DBMgr {


	//move to taskdbmgr?????????
	/**
	 * 撈出該專案的所有任務
	 * 
	 * @param projectId
	 *            : 專案id
	 * @return 所有任務
	 */
	public static ResultSet listTask(String projectId) {
		return null;
	}

	
	
	//前端知道現在的TEAM是哪個嗎?是存什麼資料?!!!!!!!!!!!
	/**
	 * 
	 * @param email
	 * @return true:無相同名稱  false:有相同名稱
	 */
	static public boolean checkProjectName(String name,String team_id){
		if(name.length()==0)
			return false;
//		
//		//if(!isInit)
//		//	return null;
		ResultSet resultSet = null;
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM `project` where p_name='" + name + "' and g_id='" + team_id + "'"); 
		    
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
	 * @param destination
	 * @param pm_id
	 * @param startDate
	 * @param endDate
	 * @param add_id
	 * @param team_id
	 * @return
	 */

	public static boolean addProject(String name, String destination,String pm_id, String startDate, String endDate,String add_id,String team_id)
	{
		//SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		//Long to String
		//String sDate = sdf.format(startDate); 
		//String eDate = sdf.format(endDate); 
		if(name.length()==0 || destination.length()==0 || pm_id.length()==0 || startDate.length() ==0 || endDate.length()==0)
			return false;
		//日期Format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		

		if(!isInit)
			return false;
		try {
			pst = con.prepareStatement("insert into `project`(`p_name`,`p_desc`,`p_startdate`,`p_enddate`,`g_id`,`add_id`,`mdy_time`,`mdy_id`) "
					+ " value (?,?,?,?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, destination);
			pst.setString(3, startDate);
			pst.setString(4, endDate);
			pst.setString(5, pm_id);
			pst.setString(6, add_id);
			pst.setString(7, formatter.format(new Date()));
			pst.setString(8, add_id);
			//System.out.println(pst);
			pst.executeUpdate();
			ResultSet rs=pst.getGeneratedKeys();
			rs.next();
			String id = rs.getString(1);
			
			pst = con.prepareStatement("insert into `g_m_relation`(`m_id`,`g_id`,`status`,`l_id`) "
					+ " value (?,?,1,2)");
			pst.setString(1, pm_id);
			pst.setString(2, team_id);
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return false;
		}
	}
	
	
	/**
	 * member's project
	 * @param member_email
	 * @return
	 */
	public static ResultSet queryMemberProject(String member_email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  project資料(!!!!!!!!in team's project)
	 * @param name
	 * @return
	 */
	static public ResultSet queryProject(String id) {
		if(id.length()==0)
			return null;
		
		ResultSet resultSet=null;
		
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM `project` where p_id='" + id + "'"); 
		    return resultSet;

		    
		    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
		    //return 0;    		
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
			return null;
		} 
		
		
	}
	
	public static ResultSet queryTeamProjects(String teamId) {
		if(teamId.length()==0)
			return null;
		
		ResultSet resultSet=null;
		
		try {
			
			Statement stat = null; 
		    stat = con.createStatement(); 
		    resultSet = stat.executeQuery("SELECT * FROM `project` where g_id='" + teamId + "'"); 
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
		
		//差加入project後要增加一個關連g_m_relation
		
		//System.out.println(addTeam("超專業必殺公司","沒有不可能!沒有做不到!包準你滿意!不滿意退錢!不熱門退錢!","02-27712171","0972923997","超專業必殺秘密基地","beatrice0516@gmail.com","beatrice0516@gmail.com"));
		//System.out.println(checkProjectName("超專業必殺公司"));
		
//		ResultSet test = queryTeam("超專業必殺公司");
//		try {
//			test.next();
//			System.out.println(test.getString("g_introduction"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//	    Date date;
		//try {
			  //String to Long
			  //String date1="2011-12-31";
			  //DateFormat formatter1 ; 
			 // Date date2 ; 
			  //formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			  //date2 = (Date)formatter.parse(date1); 
			  //long longDate=date2.getTime();
			//System.out.println(longDate);
			//System.out.println(addProject("超完美專案", "只要完美!別無所求!","23", "2011-12-31", "2011-12-31","23","1"));
		//} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	    
	}
	

}
