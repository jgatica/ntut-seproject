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
 * 透過前端取得的Facebook AccessToken來連線
 * 
 * @author Augus
 * 
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
				// Step 2如以創建或是有該帳戶，以該mail拿取該用戶的id
				// Step 3將該id放入session中(這邊要做一些登入要做的事情)
				// 將登入訊息加入Session
				session.setAttribute("isLogin", true);

				RedirectingActionForward redirectingActionForward = new RedirectingActionForward(
						"/index.jsp");
				return redirectingActionForward;

			}
		}
		// 失敗
		else {
			RedirectingActionForward redirectingActionForward = new RedirectingActionForward(
					"/error.jsp");
			return redirectingActionForward;
		}
		return null;
	}

}
