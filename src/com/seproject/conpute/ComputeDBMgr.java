package com.seproject.conpute;

import java.util.ArrayList;

// 資料庫輔助類別
public class ComputeDBMgr {
	
	/**
	 * 列出會員列表
	 * @return
	 */
	static public ArrayList<String> listOption(){
		//
		// ---------------------------------------
		// 裡面處理sql語法，向資料庫撈到資料後已規定的回傳值型式回傳
		// ---------------------------------------
		ArrayList<String> options = new ArrayList<String>();
		options.add("+");
		options.add("-");
		options.add("*");
		options.add("/");
		
		return options;
	}
	
	/**
	 * 使用memberId搜尋會員資訊
	 * @param memberId 會員編號
	 * @return 
	 * ture 會員存在
	 * false 會員不存在
	 */
	static boolean qyMember(int memberId){
		// ---------------------------------------
		// 裡面處理sql語法，向資料庫撈到資料後已規定的回傳值型式回傳
		// ---------------------------------------
		return false;
	}
	
	// 在使用前可以在main測試
	public static void main(String[] args) {
		
		ArrayList<String> opsArrayList = listOption();
		System.out.println(opsArrayList);
		
	}
}
