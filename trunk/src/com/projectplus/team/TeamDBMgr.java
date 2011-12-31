package com.projectplus.team;

import java.sql.ResultSet;

import com.projectplus.context.Result;
import com.projectplus.db.DBMgr;

public class TeamDBMgr extends DBMgr {
	/**
	 * 
	 * @param id 創始人
	 * @param name
	 * @param desc
	 * @param fax
	 * @param phone
	 * @param mail
	 * @return
	 */
	public static boolean addTeam(String id,String name,String desc,String fax,String phone,String mail)
	{
		if(id.length()==0 || name.length()==0 || fax.length()==0 || phone.length()==0 ||  mail.length()==0)
			return false;
		return true;
	}

	public static ResultSet queryMemberTeams(String member_email) {
		return null;
	}

	public static ResultSet queryTeamMembers(String id) {
		return null;
	}

	public static ResultSet queryTeam(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
