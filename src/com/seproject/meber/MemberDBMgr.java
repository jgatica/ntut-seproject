package com.seproject.meber;

import java.util.ArrayList;


// 資料庫輔助類別
public class MemberDBMgr {
	
	/**
	 * 列出會員列表
	 * @return
	 */
	static public ArrayList<MemberDataStructure> listOption(){
		//
		// ---------------------------------------
		// 裡面處理sql語法，向資料庫撈到資料後已規定的回傳值型式回傳
		// ---------------------------------------
		ArrayList<MemberDataStructure> options = new ArrayList<MemberDataStructure>();
		MemberDataStructure memberDataStructure = new MemberDataStructure();
		memberDataStructure.name = "陳奕豪";
		memberDataStructure.blame = "未確認";
		memberDataStructure.mail = "augus790302@gmail.com";
		
		MemberDataStructure memberDataStructure2 = new MemberDataStructure();
		memberDataStructure2.name = "陳至圓";
		memberDataStructure2.blame = "未確認";
		memberDataStructure2.mail = "@gmail.com";
		
		MemberDataStructure memberDataStructure3 = new MemberDataStructure();
		memberDataStructure3.name = "楊先絜";
		memberDataStructure3.blame = "未確認";
		memberDataStructure3.mail = "@gmail.com";
		
		MemberDataStructure memberDataStructure4 = new MemberDataStructure();
		memberDataStructure4.name = "郭奕成";
		memberDataStructure4.blame = "未確認";
		memberDataStructure4.mail = "@gmail.com";
		
		MemberDataStructure memberDataStructure5 = new MemberDataStructure();
		memberDataStructure5.name = "BL";
		memberDataStructure5.blame = "未確認";
		memberDataStructure5.mail = "@gmail.com";
		
		options.add(memberDataStructure);
		options.add(memberDataStructure2);
		options.add(memberDataStructure3);
		options.add(memberDataStructure4);
		options.add(memberDataStructure5);
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
		
		ArrayList<MemberDataStructure> opsArrayList = listOption();
		System.out.println(opsArrayList);
		
	}
}
