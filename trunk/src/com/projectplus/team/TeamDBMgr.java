package com.projectplus.team;

import com.projectplus.db.DBMgr;

public class TeamDBMgr extends DBMgr {
	public static boolean addTeam(String name,String desc,String fax,String phone,String address,String mail)
	{
		if(name.length()==0 || fax.length()==0 || phone.length()==0 || address.length()==0 || mail.length()==0)
			return false;
		return true;
	}
	
	
	
	
}
