/*
 * JSP generated by Resin-4.0.19 (built Tue, 14 Jun 2011 02:11:07 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;

public class _index__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  private boolean _caucho_isNotModified;
  private com.caucho.jsp.PageManager _jsp_pageManager;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, "/", null, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, _jsp_state);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_pageManager.freePageContext(pageContext);
    }
  }
  
  private void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response,
              com.caucho.jsp.PageContextImpl pageContext,
              javax.servlet.ServletContext application,
              TagState _jsp_state)
    throws Throwable
  {
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.jsp.tagext.JspTag _jsp_parent_tag = null;
    com.caucho.jsp.PageContextImpl _jsp_parentContext = pageContext;
    response.setContentType("text/html; charset=utf-8");

    out.write(_jsp_string0, 0, _jsp_string0.length);
  }

  private com.caucho.make.DependencyContainer _caucho_depends
    = new com.caucho.make.DependencyContainer();

  public java.util.ArrayList<com.caucho.vfs.Dependency> _caucho_getDependList()
  {
    return _caucho_depends.getDependencies();
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    _caucho_depends.add(depend);
  }

  protected void _caucho_setNeverModified(boolean isNotModified)
  {
    _caucho_isNotModified = true;
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;

    if (_caucho_isNotModified)
      return false;

    if (com.caucho.server.util.CauchoSystem.getVersionId() != -6614012864817568278L)
      return true;

    return _caucho_depends.isModified();
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
    TagState tagState;
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("index.jsp"), -7215391816791109266L, false);
    _caucho_depends.add(depend);
  }

  final static class TagState {

    void release()
    {
    }
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void caucho_init(ServletConfig config)
  {
    try {
      com.caucho.server.webapp.WebApp webApp
        = (com.caucho.server.webapp.WebApp) config.getServletContext();
      init(config);
      if (com.caucho.jsp.JspManager.getCheckInterval() >= 0)
        _caucho_depends.setCheckInterval(com.caucho.jsp.JspManager.getCheckInterval());
      _jsp_pageManager = webApp.getJspApplicationContext().getPageManager();
      com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
      com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.InitPageContextImpl(webApp, this);
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/Main.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<title>Project+ - \u6700\u4f73\u7684\u5c08\u6848\u8ffd\u8e64\u8207\u4f30\u7b97\u89e3\u6c7a\u65b9\u6848</title>\r\n<meta name=\"keywords\" content=\"magic color, colorful theme, free CSS templates, CSS, HTML\" />\r\n<meta name=\"description\" content=\"Magic Color Theme, Colorful Template, free website template by templatemo.com\" />\r\n\r\n\r\n\r\n\r\n<link href=\"/css/templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<link href=\"/css/bluetable.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n\r\n<link type=\"text/css\" href=\"/css/ui-lightness/jquery-ui-1.8.16.custom.css\" rel=\"stylesheet\" />	\r\n<script language=\"javascript\" type=\"text/javascript\" src=\"/js/jquery-1.7.1.min.js\"></script>\r\n \r\n<!--jQueryUI-->\r\n<script type=\"text/javascript\" src=\"/js/jquery-ui-1.8.16.custom.min.js\"></script>\r\n\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/jquery.lightbox-0.5.css\" media=\"screen\" />\r\n\r\n<!--colorbox-->\r\n<script type=\"text/javascript\" src=\"/js/colorbox/jquery.colorbox-min.js\"></script>\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/colorbox/colorbox.css\" media=\"screen\" />\r\n\r\n<script type=\"text/javascript\">\r\nvar i = 0;\r\n	$(document).ready(function(){\r\n		\r\n		\r\n		$(\".ajax\").colorbox(); \r\n		$(\".iframe\").colorbox({iframe:true, width:\"100%\", height:\"100%\"}); \r\n		$( \"button\" ).button();\r\n		\r\n		\r\n		\r\n		// \u6e2c\u8a66\r\n		$(\".top\").click(function(){\r\n			var last = 5;\r\n			$(\"#tip_group_count\").hide();\r\n			$(\"#tip_group\").hide();			\r\n			$(\"#tip_group_count\").html(i++);\r\n			$(\"#tip_group_count\").fadeIn(300);\r\n			$(\"#tip_group\").slideDown(300);\r\n			\r\n			$(\"#tip_mail_count\").hide();\r\n			$(\"#tip_mail\").hide();			\r\n			$(\"#tip_mail_count\").html(i);\r\n			$(\"#tip_mail_count\").fadeIn(300);\r\n			$(\"#tip_mail\").slideDown(300);\r\n\r\n			$(\"#tip_message_count\").hide();\r\n			$(\"#tip_message\").hide();			\r\n			$(\"#tip_message_count\").html(i);\r\n			$(\"#tip_message_count\").fadeIn(300);\r\n			$(\"#tip_message\").slideDown(300);\r\n		});\r\n		\r\n		// \u9ede\u5e33\u865f\u6309\u9215\r\n		$( \"#account_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-account\" ).slideToggle(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-account\" ).slideToggle(250);\r\n			}\r\n		);\r\n		\r\n		// \u9ede\u5718\u968a\u6309\u9215\r\n		$( \"#team_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-team\" ).slideToggle(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-team\" ).slideToggle(250);\r\n			}\r\n		);\r\n		\r\n		// \u9ede\u4fe1\u7bb1\u6309\u9215\r\n		$( \"#mail_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-mail\" ).slideToggle(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-mail\" ).slideToggle(250);\r\n			}\r\n		);\r\n		\r\n		// \u9ede\u8a0a\u606f\u6309\u9215\r\n		$( \"#message_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-message\" ).slideToggle(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-message\" ).slideToggle(250);\r\n			}\r\n		);						\r\n\r\n\r\n		\r\n	});\r\n\r\n</script>\r\n\r\n<!-- InstanceBeginEditable name=\"Head\" -->\r\n\r\n<script language=\"javascript\" type=\"text/javascript\">\r\n	$(document).ready(function(){\r\n\r\n		var op = 5;\r\n		var start = 0;  // \u81ea\u7b2c0\u7b46\r\n		var length = 3; // \u53d63\u7b46\r\n		$.getJSON('/ArticleAction.do',  { op:op, start: start, length: length }, function(data) {\r\n			//console.log(data);\r\n			var content = \"\";\r\n			for(var i = 0; i < data.length; i++){\r\n				\r\n				content += \"<div class='lbe_box'>\";\r\n				content += \"<div class='lbe_date'>\";\r\n				content += new Date(data[i].edittime);\r\n				content += \"<span>\" + data[i].author + \"</span>\";\r\n				content += \"</div>\";\r\n				content += \"<div class='lbe_content'>\";\r\n				content += \"<h3><a href='#'>\" + data[i].title + \"</a></h3>\";\r\n				content +=\"<p>\" + data[i].content + \"</p>\";\r\n				content += \"</div>\";\r\n				content += \"<div class='cleaner'></div>\"\r\n				content += \"</div>\";\r\n				\r\n			}\r\n			$(\"#news_box\").append(content);		\r\n        });\r\n		\r\n	});    	\r\n\r\n</script>\r\n\r\n<!-- InstanceEndEditable -->\r\n\r\n</head>\r\n<body>\r\n\r\n\r\n<div id=\"templatemo_body_wrapper\">\r\n	<div id=\"templatemo_wrapper\">\r\n    \r\n		<!--<div id=\"templatemo_header\">\r\n        	<div id=\"site_title\"><h1><a href=\"http://www.templatemo.com\" target=\"_parent\">\u8cc7\u8a0a\u5b78\u7fd2\u7db2\u7ad9</a></h1></div>\r\n            <p style=\"float:right; padding:5px; font-size:15px;\">            \r\n            	<a class=\"ajax\" rel=\"nofollow\" href=\"/login.jsp\"><strong>\u767b\u5165</strong></a>\r\n                <strong> / </strong>\r\n                <a class=\"ajax\" rel=\"nofollow\" href=\"/register.jsp\"><strong>\u8a3b\u518a</strong></a>\r\n                <!--<a class=\"iframe\" rel=\"nofollow\" href=\"/addArticle.jsp\"><strong>\u8a3b\u518a</strong></a>\r\n            </p>\r\n            \r\n        </div>\r\n        -->\r\n<!-- InstanceBeginEditable name=\"Menu\" -->\r\n      \r\n<!-- InstanceEndEditable -->\r\n<div id=\"templatemo_white\">\r\n</div>\r\n        <div id=\"templatemo_menu\">\r\n            <ul>\r\n            	<li><a href=\"/index.jsp\" class=\"float_l\"><img src=\"/images/logo.png\" height=\"38\" /></a>\r\n			\r\n				</li>\r\n                <li>\r\n                	<a  id=\"team_btn\" href=\"#\" class=\"float_l\">\r\n                        <p id=\"tip_group_count\" class=\"tip\">15</p>\r\n                        <img class=\"top\" src=\"/images/title_group.png\" />\r\n                    </a>				\r\n                </li>\r\n				\r\n<div id=\"div-float-team\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\"><name>\u7d44\u54e1\u52a0\u5165</name></div>\r\n					<div class=\"divider10\"></div> \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profileimg.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u9673\u81f3\u5713</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profileimg.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u694a\u5148\u7d5c</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  				     \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profileimg.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u9673\u5955\u8c6a</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profileimg.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u90ed\u5955\u6210</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  				  \r\n                                  	\r\n</div>					\r\n				\r\n				\r\n                <li>\r\n                	<a  id=\"mail_btn\" href=\"#\" class=\"float_l\">\r\n                        <p id=\"tip_mail_count\" class=\"tip\">15</p>       \r\n                    	<img class=\"top\" src=\"/images/title_mail.png\" />\r\n                    </a>					\r\n                </li>				\r\n<div id=\"div-float-mail\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\"><name>\u7ad9\u5167\u4fe1\u901a\u77e5</name></div>\r\n					<div class=\"divider10\"></div> \r\n					<div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                    	<img src=\"/images/profileimg.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                        <p><name>\u9673\u5955\u8c6a</name>\u5bc4\u4e86\u4e00\u5c01<mail>\u6211\u60f3\u52a0\u5165</mail>\u4fe1\u4ef6\u7d66\u4f60\u3002</p>\r\n  	                </div>    \r\n            	\r\n</div>						\r\n				<li>\r\n                	<a  id=\"message_btn\" href=\"#\" class=\"float_l\">\r\n                        <p id=\"tip_message_count\" class=\"tip\">15</p>       \r\n                    	<img class=\"top\" src=\"/images/title_message.png\" />\r\n                    </a>\r\n                </li>\r\n<div id=\"div-float-message\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\"><name>\u8a0a\u606f\u901a\u77e5</name></div>\r\n					<div class=\"divider10\"></div> \r\n					<div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                    	<img src=\"/images/profileimg.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                        <p><name>\u9673\u5955\u8c6a</name>\u5728<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u65b0\u589e\u4e00\u7b46\u7559\u8a00\u3002</p>\r\n  	                </div>    \r\n					<div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                    	<img src=\"/images/profileimg.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                        <p><name>\u9673\u5955\u8c6a</name>\u4fee\u6539\u4e86<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u7684\u5167\u5bb9\u3002</p>\r\n  	                </div>      					                   \r\n				              	\r\n</div>	\r\n                <li>\r\n				<form method=\"get\" id=\"searchform\" action=\"#\">\r\n					<input type=\"text\" value=\"\u641c\u5c0b...\" name=\"s\" id=\"s\" onfocus=\"defaultInput(this)\" onblur=\"clearInput(this)\">\r\n						<input type=\"submit\" id=\"searchsubmit\" value=\" \" />\r\n				</form>      \r\n                </li>\r\n				<li>\r\n\r\n				<a  id=\"account_btn\" class=\"float_r\" href=\"#\"><img class=\"top\" src=\"/images/top_account.png\" /><label>\u5e33\u865f \u25bc </label></a>\r\n				<!--<div id=\"circles\" style=\"text-align:left; background-color:rgba(199, 199, 199, 0.7); width:120px; overflow:auto; position:absolute; padding:50px; max-height:60px;\">\r\n        		</div>-->\r\n\r\n				\r\n				</li>\r\n				<li><a class=\"float_r\" href=\"/member/basic.jsp\"><img class=\"top\" src=\"/images/top_profile.png\" />\r\n				<label>\u500b\u4eba</label></a></li>								\r\n				<li><a class=\"float_r\" href=\"/project/detail.jsp\"><img class=\"top\" src=\"/images/top_profile.png\" />\r\n				<label>\u5c08\u6848</label></a></li>\r\n				<li><a class=\"float_r\" href=\"/index.jsp\"><img class=\"top\" src=\"/images/top_home.png\" /><label>\u9996\u9801</label></a></li>\r\n				\r\n<div id=\"div-float-account\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\">\u5e33\u865f\u8a2d\u5b9a</div>\r\n					<div class=\"divider10\"></div>\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profile_img.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2>\u5e33\u865f\u8a2d\u5b9a</h2>                        \r\n                    </div>\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                    		<h2>\u96b1<img src=\"/images/profile_phone.png\" alt=\"Image\" width=\"24\" height=\"24\" />\u79c1\u8a2d\u5b9a</h2>\r\n                    </div>     \r\n                  <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profile_task.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                    <h2>\u4f7f\u7528\u8aaa\u660e</h2>\r\n                  </div>  \r\n                  <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profile_mail.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                    <h2>\u767b\u51fa</h2>\r\n                  </div>                    	\r\n</div>							\r\n            </ul>    	\r\n        </div> \r\n\r\n\r\n<!-- InstanceBeginEditable name=\"Content\" -->\r\n\r\n        <div id=\"templatemo_main\">\r\n            \r\n          <div class=\"col_w900 hr_divider\">\r\n          		\r\n				\r\n    \r\n				<div id=\"dropBox\" class=\"toggler col_w700 lp_box float_l margin_20rl\">		\r\n				<div class=\"subTopDiv\" >\r\n					<h2 class=\"uiHeaderTitle\">Project+<img class=\"arrow_right\" src=\"/images/arrow_right.png\" />\u6700\u4f73\u5c08\u6848\u8ffd\u8e64\u4f30\u7b97\u7cfb\u7d71</h2>\r\n				</div>	\r\n				<!--<img src=\"/images/subTitle.jpg\" alt=\"Image\" width=\"690\" height=\"29\" />-->\r\n\r\n\r\n					<ul class=\"lp_frontpage\">\r\n						<li><a href=\"#\"><img width=\"200\" height=\"100\" src=\"images/templatemo_image_01.jpg\" alt=\"Image 01\" /></a></li>\r\n						<li><a href=\"#\"><img width=\"200\" height=\"100\" src=\"images/templatemo_image_02.jpg\" alt=\"Image 02\" /></a></li>\r\n						<li><a href=\"#\"><img width=\"200\" height=\"100\" src=\"images/templatemo_image_03.jpg\" alt=\"Image 03\" /></a></li>\r\n						<li><a href=\"#\"><img width=\"200\" height=\"100\" src=\"images/templatemo_image_04.jpg\" alt=\"Image 04\" /></a></li>\r\n					</ul>   \r\n\r\n					<div class=\"subBottomDiv\" ></div>\r\n				\r\n                </div>\r\n      			<div id=\"slide_left\" class=\"col_p35 lp_box float_r\">\r\n					<div class=\"subTopDiv\" >\r\n						<h2 class=\"uiHeaderTitle\">\u767b\u5165Project+</h2>\r\n					</div>					\r\n					\r\n<div id=\"cp_contact_form\">\r\n            <form action=\"#\" method=\"post\" name=\"contact\" id=\"contact\">\r\n              <label for=\"author3\">\u5e33\u865f:</label>\r\n              <input type=\"text\" id=\"author3\" name=\"author\" class=\"input_field\" />\r\n              <div class=\"cleaner h10\"></div>\r\n              <label for=\"email\">\u5bc6\u78bc:</label>\r\n              <input type=\"password\" class=\"input_field\" name=\"email\" id=\"email\" />\r\n              \r\n              <div class=\"cleaner h10\"></div>\r\n			\r\n            <button>\u8a3b\u518a</button>\r\n			<button class=\"float_r\">\u767b\u5165</button>  \r\n            </form>\r\n      </div>\r\n\r\n						                 \r\n                                                         \r\n					<div class=\"subBottomDiv\" ></div>            \r\n            	</div>  	\r\n				\r\n      			<div id=\"slide_left\" class=\"col_p35 lp_box float_r\">\r\n					<div class=\"subTopDiv\" >\r\n						<h2 class=\"uiHeaderTitle\">\u6700\u65b0\u52d5\u614b</h2>\r\n					</div>					\r\n					<div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <a href=\"/member/basic.jsp\">\r\n					  <img src=\"/images/user.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2><name>\u9673\u5955\u8c6a</name>\u5728<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u65b0\u589e\u4e00\u7b46\u7559\u8a00\u3002</h2>\r\n					  </a>\r\n                    </div>   \r\n					<div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <a href=\"/member/basic.jsp\">\r\n					  <img src=\"/images/user.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2><name>\u9673\u5955\u8c6a</name>\u5bc4\u4e86\u4e00\u5c01<mail>\u6211\u60f3\u52a0\u5165</mail>\u4fe1\u4ef6\u7d66\u4f60\u3002</h2>\r\n					  </a>\r\n                    </div> \r\n					<div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <a href=\"/member/basic.jsp\">\r\n					  <img src=\"/images/user.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2><name>\u9673\u5955\u8c6a</name>\u5728<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u65b0\u589e\u4e00\u7b46\u7559\u8a00\u3002\u300c\u8d95\u5feb\u628a\u7f8e\u8853\u5f04\u5b8c\u5427!!!\u300d</h2>\r\n					  </a>\r\n                    </div> \r\n					<div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <a href=\"/member/basic.jsp\">\r\n					  <img src=\"/images/user.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2><name>\u9673\u5955\u8c6a</name>\u5728<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u65b0\u589e\u4e00\u7b46\u7559\u8a00\u3002</h2>\r\n					  </a>\r\n                    </div> \r\n					<div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <a href=\"/member/basic.jsp\">\r\n					  <img src=\"/images/user.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2><name>\u9673\u5955\u8c6a</name>\u5728<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u65b0\u589e\u4e00\u7b46\u7559\u8a00\u3002</h2>\r\n					  </a>\r\n                    </div> 																				                 \r\n                                                         \r\n					<div class=\"subBottomDiv\" ></div>            \r\n            	</div>  				\r\n							\r\n                <div class=\"cleaner\"></div>\r\n            </div>\r\n        </div> \r\n            <!--\r\n            <div class=\"testimonial\"><span class=\"close\"></span>\r\n                <p>Donec dolor lectus, rutrum id facilisis eu, condimentum ut enim. Sed quis dapi bus nisi. Mauris at tortor tortor, sit amet porttitor velit. Cras viverra interdum ligula, quis cursus nulla sollicitudin vitae. Sed adipiscing sem ac erat pharetra ac eleifend tellus eleifend. Morbi tempus pharetra gravida.</p>\r\n                <p class=\"clientname\">Free CSS Templates <span><a href=\"http://www.templatemo.com\" target=\"_parent\">Mojolay</a></span></p>\r\n            </div>\r\n            -->\r\n        </div> <!-- end of templatemo main -->\r\n<!-- InstanceEndEditable -->\r\n       \r\n    	\r\n  </div>\r\n</div>\r\n\r\n\r\n\r\n\r\n<div id=\"templatemo_footer_wrapper\">\r\n    <div id=\"templatemo_footer\">\r\n    	\r\n		<a href=\"index.html\">\u9996\u9801</a> | <a href=\"about.html\">\u95dc\u65bc\u6211\u5011</a> | <a href=\"blog.html\">\u6587\u7ae0\u5217\u8868</a> | <a href=\"gallery.html\">Gallery</a> | <a href=\"contact.html\" class=\"last\">Contact</a> <br /><br />\r\n        \r\n        Copyright \u00a9 2048 ITHub | IT / Developer Center<a href=\"http://www.templatemo.com\" target=\"_parent\"></a>\r\n    \r\n  </div> <!-- end of templatemo_footer -->\r\n</div>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>".toCharArray();
  }
}
