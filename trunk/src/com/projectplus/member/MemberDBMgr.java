package com.projectplus.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectplus.db.DBMgr;

public class MemberDBMgr extends DBMgr{

	
	/**
	 * 註冊會員
	 * @param name:真實姓名
	 * @param nickName:暱稱
	 * @param account:帳號
	 * @param password:密碼
	 * @param email
	 * @return true:註冊成功  false:註冊失敗
	 */
	static public MemberDataStructure register(String name, String nickName, String account, String password) {
		if(account.length()==0 || password.length()==0 ||name.length()==0 || password.length()==0 || nickName.length()==0)
			return null;
		// 註解部分是我別的專案的  可以參考使用
//		if(!isInit)
//			return false;
//		try {
//			pst = con.prepareStatement("insert into article(idarticle,title,content,tag,author,createtime,edittime) "
//					+ "select ifNULL(max(idarticle),0)+1,?,?,?,?,?,? FROM article");
//			pst.setString(1, title);
//			pst.setString(2, content);
//			pst.setString(3, tag);
//			pst.setString(4, author);
//			pst.setLong(5, System.currentTimeMillis());
//			pst.setLong(6, System.currentTimeMillis());
//			pst.executeUpdate();
//			
//		} catch (SQLException e) {
//			System.out.println("InsertDB Exception :" + e.toString());
//			return false;
//		}
		ResultSet resultSet=null;
		MemberDataStructure data =null;
		try {
			if(resultSet!=null && resultSet.next())
			{
				data = new MemberDataStructure();//真的
				data.setHex_mrscid(resultSet.getString(""));
				data.setBa_mrscid(resultSet.getString(""));
				data.setImageURL(resultSet.getString(""));
				data.setMember_name(resultSet.getString(""));
				data.setMember_Gender(resultSet.getString(""));
				data.setMember_address(resultSet.getString(""));
				data.setMember_birthday(resultSet.getString(""));
				data.setMember_descript(resultSet.getString(""));
				data.setMember_email(resultSet.getString(""));
				data.setMember_mobile(resultSet.getString(""));
				data.setMember_phone(resultSet.getString(""));
				data.setMember_nickname(resultSet.getString(""));
			}
			else//假的(測試用) 如有真資料請將此部分刪除 直接return null
			{
				data = new MemberDataStructure();
				data.setHex_mrscid("1234");
				data.setBa_mrscid("xxxx");
				data.setImageURL("/images/2.jpg");
				data.setMember_name(name);
				data.setMember_Gender("男");
				data.setMember_address("台中");
				data.setMember_birthday("1990-02-16");
				data.setMember_descript("哇系圓圓");
				data.setMember_email(account);
				data.setMember_mobile("0952630832");
				data.setMember_phone("0952630832");
				data.setMember_nickname(nickName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
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
	
	/**
	 * 會員登入
	 * @param account:登入帳戶
	 * @param password:登入密碼
	 * @return 0:登入成功  1:密碼錯誤 2:查無此帳號
	 */
	static public boolean checkLogin(String account, String password) {
		if(account.length()==0 || password.length()==0)
			return false;
		return true;
	}
	
	/**
	 * 更新會員的資料
	 * @param name:名字
	 * @param nickName:暱稱
	 * @param email:
	 * @param phone:電話
	 * @param address:地址
	 * -----------------除以上等資料  尚有其他資訊需補齊
	 * @return true:修改成功 false:修改失敗
	 */
	static public boolean updDetail(String name, String nickName, String email, String phone, String address) {
		
		return true;
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
	
	public static void main(String[] args) {
		
	}
}
