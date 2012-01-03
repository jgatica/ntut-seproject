package com.projectplus.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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
		if(!isInit)
		{
			System.out.println("Load property");
			// 從config檔讀取參數
			props = new Properties();
	        try {
	             props.load(new FileInputStream("config/dbconfig.properties"));
	        } catch (FileNotFoundException e) {
	             e.printStackTrace();
	        } catch (IOException e) {
	             e.printStackTrace();
	        }
			
	        driver = props.getProperty("driver");
	        url = props.getProperty("url");
	        user = props.getProperty("user");
	        password = props.getProperty("password");
			
	        System.out.println("Load driver:" + driver);
			try {
				Class.forName(driver);
				System.out.println("Load driver finished");
				// 註冊driver
				System.out.println("Cnnect...");
				System.out.println("Host address:" + url);
				System.out.println("User:" + user);
				System.out.println("Password:" + password);
				con = DriverManager.getConnection(url, user, password);
				System.out.println("Cnnected");
			}
			catch (ClassNotFoundException e) {
				System.out.println("DriverClassNotFound :" + e.toString());
			}
			catch (SQLException x) {
				System.out.println("Exception :" + x.toString());
			} finally{
				isInit  = true;
			}
			
		}
	}
	
}
