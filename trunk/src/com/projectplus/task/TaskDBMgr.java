package com.projectplus.task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.projectplus.db.DBMgr;

public class TaskDBMgr extends DBMgr{
	

	
	//前端知道現在的Project&Team是哪個嗎?是存什麼資料?!!!!!!!!!!!
		/**
		 * 
		 * @param name
		 * @return true:無相同名稱  false:有相同名稱
		 */
		static public boolean checkTaskName(String name,String project_id){
			if(name.length()==0 || project_id.length()==0)
				return false;
//			
//			//if(!isInit)
//			//	return null;
			ResultSet resultSet = null;
			try {
				
				Statement stat = null; 
			    stat = con.createStatement(); 
			    resultSet = stat.executeQuery("SELECT * FROM `task` where t_name='" + name + "' and p_id='" + project_id + "'"); 
			    
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
		//team's name(id) & project's name(id)
		public static boolean addTask(String name, String destination, String startDate, String endDate, String add_id, String project_id, String asign_id)
		{
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			
			//Long to String
			//String sDate = sdf.format(startDate); 
			//String eDate = sdf.format(endDate); 
			if(name.length()==0 || destination.length()==0 || startDate.length() ==0 || endDate.length()==0)
				return false;
			//日期Format
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			

			if(!isInit)
				return false;
			try {
				pst = con.prepareStatement("insert into `task`(`t_name`,`t_desc`,`t_startdate`,`t_enddate`,`add_id`,`mdy_time`,`mdy_id`,`m_id`,`g_id`) "
						+ " value (?,?,?,?,?,?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, destination);
				pst.setString(3, startDate);
				pst.setString(4, endDate);
				pst.setString(5, add_id);
				pst.setString(6, formatter.format(new Date()));
				pst.setString(7, add_id);
				pst.setString(8, project_id);
				pst.setString(9, asign_id);
				System.out.println(pst);
				pst.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				System.out.println("InsertDB Exception :" + e.toString());
				return false;
			}
		}

		
		
		/**
		 * member's task (for project???????)
		 * @param member_email
		 * @return
		 */
		public static ResultSet queryMemberTasks(String member_email) {
			// TODO Auto-generated method stub
			ResultSet resultSet=null;
			return resultSet;
		}

		
		/**
		 * Team's project
		 * @param teamName
		 * @return
		 */
		public static ResultSet queryProjectTask(String teamName) {
			// TODO Auto-generated method stub
			return null;
		}
		
		/**
		 *  task資料(!!!!!!!!in team's project's task)
		 * @param name
		 * @return
		 */
		static public ResultSet queryTask(String id) {
			if(id.length()==0)
				return null;
			
			ResultSet resultSet=null;
			
			try {
				
				Statement stat = null; 
			    stat = con.createStatement(); 
			    resultSet = stat.executeQuery("SELECT * FROM `task` where t_id='" + id + "'"); 
			    return resultSet;

			    
			    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
			    //return 0;    		
			} catch (SQLException e) {
				System.out.println("InsertDB Exception :" + e.toString());
				return null;
			} 
			
			
		}
		
		
		
//		/**
//		 * 會員登入
//		 * @param account:登入帳戶
//		 * @param password:登入密碼
//		 * @return 0:登入成功  1:帳號或密碼錯誤 2:查無此帳號
//		 * @throws NoSuchAlgorithmException 
//		 */
//		static public int checkLogin(String email, String password) {
//			if(email.length()==0 || password.length()==0)
//				return 1;
//			
//			//if(!isInit)
//			//	return null;
//			ResultSet resultSet = null;
//			try {
//				
//				Statement stat = null; 
//			    stat = con.createStatement(); 
//			    resultSet = stat.executeQuery("SELECT * FROM member where m_email='" + email + "'"); 
//			    
//			    if(resultSet.next()){ 
//			    	//加密md5
//				    MD5Util md5Util = new MD5Util();
//					String md5_password = md5Util.getMD5HexStr(password, "utf8");
//			        
//				    if(md5_password.equals(resultSet.getString("m_password")))
//				    	return 0;
//				    else
//				    	return 1;
//			    }
//			    else
//			    {
//			    	return 2;
//			    }
//			    
//			    //System.out.println(resultSet.getString("m_password")+"\t\t"); 
//			    //return 0;    		
//			} catch (SQLException e) {
//				System.out.println("InsertDB Exception :" + e.toString());
//				return 1;
//			} 
//			
//			 
//			//return 0;
//		}
		public static void main(String[] args) {
			
			//差加入task後要增加一個關連g_m_relation
			
			//System.out.println(addTeam("超專業必殺公司","沒有不可能!沒有做不到!包準你滿意!不滿意退錢!不熱門退錢!","02-27712171","0972923997","超專業必殺秘密基地","beatrice0516@gmail.com","beatrice0516@gmail.com"));
			//System.out.println(checkTeamName("超專業必殺公司"));
			
//			ResultSet test = queryTeam("超專業必殺公司");
//			try {
//				test.next();
//				System.out.println(test.getString("g_introduction"));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		    Date date;
//			try {
//				  //String to Long
//				  String date1="2011-12-31";
//				  DateFormat formatter1 ; 
//				  Date date2 ; 
//				  formatter1 = new SimpleDateFormat("yyyy-MM-dd");
//				  date2 = (Date)formatter.parse(date1); 
//				  long longDate=date2.getTime();
//				System.out.println(longDate);
//				System.out.println(addProject("超完美專案", "只要完美!別無所求!","beatrice0516@gmail.com", longDate, longDate,"beatrice0516@gmail.com"));
//				
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
}

