package com.projectplus.db;

public class MemberDBmgr extends DBMgr {
	public int start;
	public int length;
	public String hex_mrscid;
	public String ba_mrscid;
	public String password;
	public String member_name;
	public String member_nickname;
	public String member_descript;
	public String member_address;
	public String member_moblie;
	public String member_phone;
	public String member_birthday;
	public String member_email;
	
	public static boolean RegisterMember(String name,String password,String nickName,String desc,String address,String mobile,String phone ,String birthday,String email)
	{
		//String sqlStatement="Insert member Values("+name+")";
		//con.prepareStatement(sql)
		if(name.length()==0 || password.length()==0 || nickName.length()==0 || desc.length()==0 ||address.length()==0 ||mobile.length()==0 ||phone.length()==0 ||birthday.length()==0 ||email.length()==0 )
			return false;
		return true;
	}
	
	public static boolean LoginMember(String email,String password)
	{
		if(email.length()==0 || password.length()==0)
			return false;
		//String sqlStatement="Insert member Values("+name+")";
		//con.prepareStatement(sql)
		return true;
	}
}
