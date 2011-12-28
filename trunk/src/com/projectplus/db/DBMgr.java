package com.projectplus.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.*;
public class DBMgr {

	private static Properties props;
	protected static Connection con = null; // Database objects
	protected static PreparedStatement pst = null;
	protected static boolean isInit = false;
	
	protected static String driver = null; 
	protected static String url = null; 
	protected static String user = null;
	protected static String password = null;
	
	/*
	 * DB初始化連線設定 
	 * */
	
	static {
//		if(!isInit)
//		{
//			// 從config檔讀取參數
//			/*props = new Properties();
//	        try {
//	             props.load(new FileInputStream("config/dbconfig.properties"));
//	        } catch (FileNotFoundException e) {
//	             e.printStackTrace();
//	        } catch (IOException e) {
//	             e.printStackTrace();
//	        }*/
//			
//	        driver = "com.mysql.jdbc.Driver";//props.getProperty("driver");
//	        url = "jdbc:mysql://localhost/projectplus";//props.getProperty("url");
//	        user = "root";//props.getProperty("user");
//	        password = "123456";//props.getProperty("password");
//			
//	        
//			try {
//				Class.forName(driver);
//				// 註冊driver
//				con = DriverManager.getConnection(url, user, password);
//			}
//			catch (ClassNotFoundException e) {
//				System.out.println("DriverClassNotFound :" + e.toString());
//			}
//			catch (SQLException x) {
//				System.out.println("Exception :" + x.toString());
//			} finally{
//				isInit  = true;
//			}
//		}
	}
	
}
