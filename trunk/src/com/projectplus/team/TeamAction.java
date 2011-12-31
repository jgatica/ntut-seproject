package com.projectplus.team;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projectplus.context.Result;
import com.projectplus.context.SessionContext;
import com.projectplus.member.MemberDataStructure;
import com.projectplus.task.TaskDBMgr;
import com.projectplus.task.TaskDataStructure;
import com.projectplus.util.JSONWriter;

public class TeamAction extends Action {
	
	public static final int ADDTEAM= 0;
	public static final int DELTEAM= 1;
	public static final int UPDTEAM= 2;
	public static final int QYTEAM = 3;
	public static final int QYMEMBER = 4;
	public static final int QYPROJECT = 5;
	public static final int ADDTEAMMEMBER = 6;
	public static final int QYMEMBERTEAMS = 7;
	public static final int QYTEAMMEMBERS = 8;
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		TeamActionForm form = (TeamActionForm) actionForm;
		
		int op = form.getOp();
		//System.out.println("the op  = " + op);

		switch (op) {
			case ADDTEAM:
				return addTeam(mapping, form, request, response, session);
			case DELTEAM:
				return delTeam(mapping, form, request, response, session);
			case UPDTEAM:
				return updateTeam(mapping, form, request, response, session);
			case QYTEAM:
				return queryTeam(mapping, form, request, response, session);
			case ADDTEAMMEMBER:
				return addTeamMember(mapping, form, request, response, session);
			case QYMEMBERTEAMS:
				return queryMemberTeams(mapping, form, request, response, session);
			case QYTEAMMEMBERS:
				return queryTeamMembers(mapping, form, request, response, session);
		}
		
		return null;
	}
	
	private ActionForward queryTeamMembers(ActionMapping mapping,
			TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ResultSet resultSet = TeamDBMgr.queryTeamMembers(form.id);
		ResultSet teamResultSet = TeamDBMgr.queryTeam(form.id);
		TeamDataStructure team = new TeamDataStructure();
		List<MemberDataStructure> dataList=new ArrayList<MemberDataStructure>();
		
		try {
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
					MemberDataStructure member = new MemberDataStructure();
					member.setId(resultSet.getString(""));
					member.setImageURL(resultSet.getString(""));
					member.setMember_name(resultSet.getString(""));
					dataList.add(member);
				}
			}
			else //假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				for(int i=1;i<6;i++)
				{
					MemberDataStructure member = new MemberDataStructure();
					member.setId(Integer.toString(i));
					member.setImageURL("/images/default.jpg");
					member.setMember_name("成員"+i);
					dataList.add(member);
				}
			}
			if(teamResultSet!=null && teamResultSet.next())
				team.setName(teamResultSet.getString(""));
			else
				team.setName("團隊" + form.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			team.setMembers(dataList);
			JSONWriter.sendJSONResponse(response, team);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ActionForward queryMemberTeams(ActionMapping mapping,
			TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		MemberDataStructure data = (MemberDataStructure)session.getAttribute(SessionContext.USERDATA);
		ResultSet resultSet = TeamDBMgr.queryMemberTeams(data.member_email);
		List<TeamDataStructure> dataList=new ArrayList<TeamDataStructure>();
		try {
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
					TeamDataStructure team = new TeamDataStructure();
					team.setName(resultSet.getString(""));
					team.setImageURL(resultSet.getString(""));
					dataList.add(team);
				}
			}
			else //假的(測試用) 如有真資料請將此部分刪除 直接return
			{
				for(int i=1;i<6;i++)
				{
					TeamDataStructure team = new TeamDataStructure();
					team.setId(Integer.toString(i));
					team.setName("團隊"+i);
					team.setImageURL("/images/group.jpg");
					dataList.add(team);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			JSONWriter.sendJSONResponse(response, dataList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private ActionForward addTeamMember(ActionMapping mapping, TeamActionForm form,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
				return null;

		
		// 呼叫 TeamDBMgr.addTeamMember(該會員id)
		
	}
	
	private ActionForward queryTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ResultSet resultSet = TeamDBMgr.queryTeam(form.id);
		TeamDataStructure team = null;
		try {
			if(resultSet!=null && resultSet.next())
			{
				team = new TeamDataStructure();
				team.setCreator(resultSet.getString(""));
				team.setId(resultSet.getString(""));
				team.setName(resultSet.getString(""));
				team.setFax(resultSet.getString(""));
				team.setPhone(resultSet.getString(""));
				team.setDescription(resultSet.getString(""));
				team.setMail(resultSet.getString(""));
				team.setImageURL(resultSet.getString(""));
				team.setCreateDate(resultSet.getString(""));
			}
			else
			{
				team = new TeamDataStructure();
				team.setCreator("創始人"+form.id);
				team.setId(form.id);
				team.setName("團隊"+form.id);
				team.setFax("123");
				team.setPhone("321");
				team.setDescription("團隊"+form.id + "的專案描述");
				team.setMail("anyo0928@gmail.com");
				team.setImageURL("/images/group.jpg");
				team.setCreateDate(form.id + "/1/2012");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			JSONWriter.sendJSONResponse(response, team);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	private ActionForward updateTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
				return null;
		// TODO Auto-generated method stub
		
	}
	
	private ActionForward delTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
				return null;
		
	}

	private ActionForward addTeam(ActionMapping mapping, TeamActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		/*System.out.println("name:"+form.name);
		System.out.println("description:"+form.description);
		System.out.println("fax:"+form.fax);
		System.out.println("phone:"+form.phone);
		System.out.println("address:"+form.address);
		System.out.println("mail:"+form.mail);*/
		
		MemberDataStructure userData = (MemberDataStructure)session.getAttribute(SessionContext.USERDATA);
		boolean isSuccess = TeamDBMgr.addTeam(userData.id,form.name, form.description, form.fax, form.phone,form.mail);
		Result result = new Result();
		result.isSuccess = isSuccess;
		if(isSuccess)
		{
			result.message = "ok";
		}	
		else
		{
			result.message = "輸入不完整";
		}
		try {
			JSONWriter.sendJSONResponse(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
