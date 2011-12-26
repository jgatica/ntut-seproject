package com.projectplus.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RedirectingActionForward;

import com.ilinke.util.StringUtil;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

/**
 * 
 * 功能說明 : 用戶可以利用現有的FB帳號登入我們的系統
 * 		        如果是第一次使用FB登入我們系統，系統未自動以FB資訊在本系統註冊
 * 		        如果不是第一次登入，則透過該FB id去DB存取本系統資料並存入Session中
 * 
 * 透過前端取得的Facebook AccessToken來連線
 * @author Augus
 */
public class FacebookLoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		FacebookLoginForm form = (FacebookLoginForm) actionForm;

		System.out.println("test");

		// 取得Facebook AccessToken
		String accessToken = form.getAccesstoken();

		// 成功
		if (accessToken != null & !accessToken.equals("")) {
			FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
			User user = facebookClient.fetchObject("me", User.class);
			if (facebookClient != null) {
				String fb_uid = user.getId();
				String fb_name = user.getName();
				String fb_url = user.getLink();
				String fb_email = user.getEmail();
				String fb_locale = user.getLocale();
				if (!StringUtil.isEmptyString(user.getEmail()))
					fb_email = user.getEmail().toLowerCase().trim();

				System.out.println("fb_uid = " + fb_uid);
				System.out.println("fb_name = " + fb_name);
				System.out.println("fb_url = " + fb_url);
				System.out.println("fb_email = " + fb_email);
				System.out.println("fb_locale = " + fb_locale);

				// Step 1 如果是第一次登入，拿取該email(等資訊)，註冊我們的帳戶
				// 查詢該會員是否存在，若為Null表示為第一次以FB帳號進入系統
//				ResultSet resultSet = MemberDBMgr.queryMember(fb_uid);
//				if(resultSet == null){
//					// Step 2如以創建或是有該帳戶，以該mail拿取該用戶的id
//					MemberDBMgr.register(fb_email, fb_name, fb_url, fb_locale, fb_email);
//					
//				}
				// Step 3將該id放入session中(這邊要做一些登入要做的事情)
				// 將登入訊息加入Session
				session.setAttribute("isLogin", true);
				
				
				
				RedirectingActionForward redirectingActionForward = new RedirectingActionForward(
						"/index.jsp");
//				mapping.findForward("homepage");
				return redirectingActionForward;

			}
		}
		
		// 若登入失敗，引導客戶到錯誤葉面
		RedirectingActionForward redirectingActionForward = new RedirectingActionForward(
					"/error.jsp");
		return redirectingActionForward;
	}

}