/*
 * JSP generated by Resin-4.0.19 (built Tue, 14 Jun 2011 02:11:07 PDT)
 */

package _jsp._project;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;

public class _listtask__jsp extends com.caucho.jsp.JavaPage
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
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, "/project/", session, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, session, _jsp_state);
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
              javax.servlet.http.HttpSession session,
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
    
	boolean goIndex = false;
	boolean isLogin = false;
	
	isLogin = (session.getAttribute("isLogin")!=null);
	
	if(!isLogin) 
		goIndex = true;
	

    out.write(_jsp_string1, 0, _jsp_string1.length);
    if(goIndex){
    out.write(_jsp_string2, 0, _jsp_string2.length);
    }
    out.write(_jsp_string3, 0, _jsp_string3.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("project/listTask.jsp"), -3411861529702753396L, false);
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

  private final static char []_jsp_string3;
  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  static {
    _jsp_string3 = "\r\n\r\n		$(\".ajax\").colorbox(); \r\n		$(\".iframe\").colorbox({iframe:true, width:\"100%\", height:\"100%\"}); \r\n		$( \"button\" ).button();\r\n\r\n		// \u6e2c\u8a66\r\n		$(\".top\").click(function(){\r\n			var last = 5;\r\n			$(\"#tip_group_count\").hide();\r\n			$(\"#tip_group\").hide();			\r\n			$(\"#tip_group_count\").html(i++);\r\n			$(\"#tip_group_count\").fadeIn(300);\r\n			$(\"#tip_group\").slideDown(300);\r\n			\r\n			$(\"#tip_mail_count\").hide();\r\n			$(\"#tip_mail\").hide();			\r\n			$(\"#tip_mail_count\").html(i);\r\n			$(\"#tip_mail_count\").fadeIn(300);\r\n			$(\"#tip_mail\").slideDown(300);\r\n\r\n			$(\"#tip_message_count\").hide();\r\n			$(\"#tip_message\").hide();			\r\n			$(\"#tip_message_count\").html(i);\r\n			$(\"#tip_message_count\").fadeIn(300);\r\n			$(\"#tip_message\").slideDown(300);\r\n		});\r\n		\r\n		// \u9ede\u5718\u968as\u6309\u9215\r\n		$( \"#teams_btn\" ).focusout(function(e) {\r\n			$( \"#teams_btn\" ).removeClass(\"menu_li_toogle\");\r\n			$( \"#div-float-teams\" ).slideUp(250);\r\n		});\r\n		\r\n		$( \"#teams_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-teams\" ).slideDown(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-teams\" ).slideUp(250);\r\n			}\r\n		);\r\n		// \u9ede\u5e33\u865f\u6309\u9215\r\n		$( \"#account_btn\" ).focusout(function(e) {\r\n			$( \"#account_btn\" ).removeClass(\"menu_li_toogle\");\r\n			$( \"#div-float-account\" ).slideUp(250);\r\n		});\r\n				\r\n		$( \"#account_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-account\" ).slideDown(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-account\" ).slideUp(250);\r\n			}\r\n		);\r\n		\r\n		// \u9ede\u5718\u968a\u6309\u9215\r\n		$( \"#team_btn\" ).focusout(function(e) {\r\n			$( \"#team_btn\" ).removeClass(\"menu_li_toogle\");\r\n			$( \"#div-float-team\" ).slideUp(250);\r\n		});\r\n				\r\n		$( \"#team_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-team\" ).slideDown(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-team\" ).slideUp(250);\r\n			}\r\n		);\r\n		\r\n		// \u9ede\u4fe1\u7bb1\u6309\u9215\r\n		$( \"#mail_btn\" ).focusout(function(e) {\r\n			$( \"#mail_btn\" ).removeClass(\"menu_li_toogle\");\r\n			$( \"#div-float-mail\" ).slideUp(250);\r\n		});		\r\n		\r\n		$( \"#mail_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-mail\" ).slideDown(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-mail\" ).slideUp(250);\r\n			}\r\n		);\r\n		\r\n		// \u9ede\u8a0a\u606f\u6309\u9215\r\n		$( \"#message_btn\" ).focusout(function(e) {\r\n			$( \"#message_btn\" ).removeClass(\"menu_li_toogle\");\r\n			$( \"#div-float-message\" ).slideUp(250);\r\n		});	\r\n				\r\n		$( \"#message_btn\" ).toggle(\r\n			function () { \r\n				$( this ).addClass(\"menu_li_toogle\");\r\n				$( \"#div-float-message\" ).slideDown(250);\r\n			},		\r\n			function () {\r\n				$( this ).removeClass(\"menu_li_toogle\");\r\n				$( \"#div-float-message\" ).slideUp(250);\r\n			}\r\n		);						\r\n\r\n\r\n		\r\n	});\r\n\r\n</script>\r\n\r\n<!-- InstanceBeginEditable name=\"Head\" -->\r\n\r\n\r\n<script language=\"JavaScript\" type=\"text/javascript\">\r\n	/*\r\n	 * \u4e00\u958b\u59cb\u8b80\u53d6\u7b2c\u96f6\u7b46\u8cc7\u6599\r\n	 */\r\n	$(document).ready(function(){\r\n		$( \"button\" ).button();\r\n		$('#date_start').datepicker();\r\n		$('#date_end').datepicker();		\r\n		$( \"#dialog\" ).dialog( {autoOpen: false, minWidth: 200, minHeight: 120, modal: true} );\r\n		$( \"#dialog_btn\" ).click(function(){\r\n			$(\"#dialog\").dialog('open');\r\n		});	\r\n		\r\n		$( \"#more\" ).click(function(){\r\n			var content = 	'<tr>' + \r\n							'<td>001</td>' +\r\n							'<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>'+\r\n							'<td><img src=\"/images/state_ok.png\" width=\"16\" /></td>'+\r\n							'</tr>'+\r\n							'<tr class=\"odd\">'+\r\n							'<td>002</td>'+\r\n							'<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>'+\r\n							'<td><img src=\"/images/state_ok.png\" width=\"16\" /></td>'+\r\n							'</tr>'+\r\n							'<tr>' + \r\n							'<td>001</td>' +\r\n							'<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>'+\r\n							'<td><img src=\"/images/state_ok.png\" width=\"16\" /></td>'+\r\n							'</tr>'+\r\n							'<tr class=\"odd\">'+\r\n							'<td>002</td>'+\r\n							'<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>'+\r\n							'<td><img src=\"/images/state_ok.png\" width=\"16\" /></td>'+\r\n							'</tr>'\r\n							'<tr>' + \r\n							'<td>001</td>' +\r\n							'<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>'+\r\n							'<td><img src=\"/images/state_ok.png\" width=\"16\" /></td>'+\r\n							'</tr>'+\r\n							'<tr class=\"odd\">'+\r\n							'<td>002</td>'+\r\n							'<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>'+\r\n							'<td><img src=\"/images/state_ok.png\" width=\"16\" /></td>'+\r\n							'</tr>';\r\n	\r\n			var element = $(content+content+content).hide();\r\n			element.appendTo($(\"#task-list\"));\r\n			element.show(1500);	\r\n		});\r\n		\r\n	}); \r\n\r\n	  	\r\n\r\n</script>\r\n\r\n\r\n<!-- InstanceEndEditable -->\r\n\r\n</head>\r\n<body>\r\n\r\n\r\n<div id=\"templatemo_body_wrapper\">\r\n	<div id=\"templatemo_wrapper\">\r\n    \r\n		<!--<div id=\"templatemo_header\">\r\n        	<div id=\"site_title\"><h1><a href=\"http://www.templatemo.com\" target=\"_parent\">\u8cc7\u8a0a\u5b78\u7fd2\u7db2\u7ad9</a></h1></div>\r\n            <p style=\"float:right; padding:5px; font-size:15px;\">            \r\n            	<a class=\"ajax\" rel=\"nofollow\" href=\"/login.jsp\"><strong>\u767b\u5165</strong></a>\r\n                <strong> / </strong>\r\n                <a class=\"ajax\" rel=\"nofollow\" href=\"/register.jsp\"><strong>\u8a3b\u518a</strong></a>\r\n                <!--<a class=\"iframe\" rel=\"nofollow\" href=\"/addArticle.jsp\"><strong>\u8a3b\u518a</strong></a>\r\n            </p>\r\n            \r\n        </div>\r\n        -->\r\n<!-- InstanceBeginEditable name=\"Menu\" -->\r\n<!-- end of templatemo_menu -->\r\n<!-- InstanceEndEditable -->\r\n<div id=\"templatemo_white\">\r\n</div>\r\n        <div id=\"templatemo_menu\">\r\n            <ul>\r\n            	<li><a href=\"/index.jsp\" class=\"float_l\"><img src=\"/images/logo.png\" height=\"38\" /></a>\r\n			\r\n				</li>\r\n                <li>\r\n                	<a  id=\"team_btn\" href=\"#\" class=\"float_l\">\r\n                        <p id=\"tip_group_count\" class=\"tip\">15</p>\r\n                        <img class=\"top\" src=\"/images/title_group.png\" />\r\n                    </a>				\r\n                </li>\r\n				\r\n<div id=\"div-float-team\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\"><name>\u7d44\u54e1\u52a0\u5165</name></div>\r\n					<div class=\"divider10\"></div> \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/2.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u9673\u81f3\u5713</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/3.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u694a\u5148\u7d5c</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  				     \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/1.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u9673\u5955\u8c6a</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  \r\n                  <div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/4.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                      <p><name>\u90ed\u5955\u6210</name>\u60f3\u8981\u52a0\u5165<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u5718\u968a  <button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button>\r\n					  </p>   \r\n                  </div>  				  \r\n                                  	\r\n</div>					\r\n				\r\n				\r\n                <li>\r\n                	<a  id=\"mail_btn\" href=\"#\" class=\"float_l\">\r\n                        <p id=\"tip_mail_count\" class=\"tip\">15</p>       \r\n                    	<img class=\"top\" src=\"/images/title_mail.png\" />\r\n                    </a>					\r\n                </li>				\r\n<div id=\"div-float-mail\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\"><name>\u7ad9\u5167\u4fe1\u901a\u77e5</name></div>\r\n					<div class=\"divider10\"></div> \r\n					<div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                    	<img src=\"/images/1.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                        <p><name>\u9673\u5955\u8c6a</name>\u5bc4\u4e86\u4e00\u5c01<mail>\u6211\u60f3\u52a0\u5165</mail>\u4fe1\u4ef6\u7d66\u4f60\u3002</p>\r\n  	                </div>    \r\n            	\r\n</div>						\r\n				<li>\r\n                	<a  id=\"message_btn\" href=\"#\" class=\"float_l\">\r\n                        <p id=\"tip_message_count\" class=\"tip\">15</p>       \r\n                    	<img class=\"top\" src=\"/images/title_message.png\" />\r\n                    </a>\r\n                </li>\r\n<div id=\"div-float-message\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\"><name>\u8a0a\u606f\u901a\u77e5</name></div>\r\n					<div class=\"divider10\"></div> \r\n					<div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                    	<img src=\"/images/1.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                        <p><name>\u9673\u5955\u8c6a</name>\u5728<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u65b0\u589e\u4e00\u7b46\u7559\u8a00\u3002</p>\r\n  	                </div>    \r\n					<div class=\"col_allw370 frontpage_box hoverdiv\">\r\n                    	<img src=\"/images/2.jpg\" alt=\"Image\" width=\"32\" height=\"32\">\r\n                        <p><name>\u9673\u81f3\u5713</name>\u4fee\u6539\u4e86<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u7684\u5167\u5bb9\u3002</p>\r\n  	                </div>      					                   \r\n				              	\r\n</div>	\r\n                <li>\r\n				<form method=\"get\" id=\"searchform\" action=\"#\">\r\n					<input type=\"text\" value=\"\u641c\u5c0b...\" name=\"s\" id=\"s\" onfocus=\"defaultInput(this)\" onblur=\"clearInput(this)\">\r\n						<input type=\"submit\" id=\"searchsubmit\" value=\" \" />\r\n				</form>      \r\n                </li>\r\n				<li>\r\n\r\n				<a  id=\"account_btn\" class=\"float_r\" href=\"#\"><img class=\"top\" src=\"/images/top_profile.png\" /><label>\u500b\u4eba \u25bc </label></a>\r\n				<!--<div id=\"circles\" style=\"text-align:left; background-color:rgba(199, 199, 199, 0.7); width:120px; overflow:auto; position:absolute; padding:50px; max-height:60px;\">\r\n        		</div>-->\r\n\r\n				\r\n				</li>\r\n<div id=\"div-float-account\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\">\u500b\u4eba\u529f\u80fd</div>\r\n					<div class=\"divider10\"></div> <!--\u5206\u9694\u7dda-->\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n						<a href=\"/member/task.jsp?id=123\">\r\n						<img src=\"/images/task.png\" alt=\"Image\" width=\"24\" height=\"24\" />\r\n						<h2>\u76ee\u524d\u5de5\u4f5c</h2>\r\n						</a>\r\n                    </div>   \r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n						<a href=\"/member/mail.jsp?id=123\">\r\n                        <img src=\"/images/mail.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                        <h2>\u6211\u7684\u4fe1\u7bb1</h2>                        \r\n						</a>\r\n                    </div>					  \r\n                  <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n                      <img src=\"/images/profile_task.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                    <h2>\u4f7f\u7528\u8aaa\u660e</h2>\r\n                  </div>  \r\n\r\n				<div class=\"col_allw170 frontpage_box hoverdiv\">	\r\n                      <img src=\"/images/logout.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2>\u767b\u51fa</h2> \r\n                  	\r\n				</div>\r\n</div>\r\n			\r\n				<li>\r\n					<a id=\"teams_btn\" class=\"float_r\" href=\"/member/basic.jsp\"><img class=\"top\" src=\"/images/top_account.png\" />\r\n					<label>\u5718\u968a \u25bc </label></a>\r\n				</li>	\r\n<div id=\"div-float-teams\">\r\n					<div style=\"margin-left:20px;margin-top:10px;\">\u6211\u7684\u5718\u968a</div>\r\n					<div class=\"divider10\"></div> <!--\u5206\u9694\u7dda-->\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n					  <a href=\"/team/detail.jsp?id=123\">\r\n                      	<img src=\"/images/profile_img.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      	<h2>\u8edf\u9ad4\u5de5\u7a0b</h2>                        \r\n					  </a>\r\n                    </div>\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n						<a href=\"/team/detail.jsp?id=123\">\r\n						<img src=\"/images/android-icon.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n						<h2>Android\u958b\u767c\u793e</h2>   \r\n						</a>                     \r\n                    </div>\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n						<a href=\"/team/detail.jsp?id=123\">\r\n						<img src=\"/images/jquery-icon.gif\" alt=\"Image\" width=\"24\" height=\"24\">\r\n						<h2>jQuery\u7814\u7a76\u793e</h2>                        \r\n						</a>\r\n                    </div>\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n						<a href=\"/team/detail.jsp?id=123\">\r\n						<img src=\"/images/c++-icon.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n						<h2>C++\u5c08\u7814\u5340</h2>                        \r\n						</a>\r\n                    </div>										                 	\r\n</div>	\r\n				<li>\r\n					<a class=\"float_r\" href=\"/index.jsp\"><img class=\"top\" src=\"/images/top_home.png\" />\r\n					<label>\u9996\u9801</label></a>\r\n				</li>										\r\n				\r\n				\r\n						\r\n            </ul>    	\r\n        </div> \r\n\r\n\r\n\r\n\r\n        <div id=\"templatemo_main\">\r\n            \r\n          <div class=\"col_w900 hr_divider\">\r\n          		\r\n      			<div class=\"col_w170 lp_box float_l\">\r\n				<div class=\"subTopDiv\" ><img src=\"/images/profileTitle.png\"/></div>	\r\n					\r\n					<div class=\"col_allw170 frontpage_box hoverdiv\">\r\n					<a href=\"/project/detail.jsp\">\r\n						<img src=\"/images/project_info.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n						<h2>\u5c08\u6848\u8cc7\u8a0a</h2>\r\n					</a> \r\n                    </div>            \r\n					       \r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n					<a href=\"/project/listTask.jsp\">\r\n						<img src=\"/images/project_task.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n						<h2>\u5c08\u6848\u4efb\u52d9</h2>\r\n                    </a>\r\n                    </div>\r\n                    <div class=\"col_allw170 frontpage_box hoverdiv\">\r\n					<a href=\"/project/listTask.jsp\">\r\n                      <img src=\"/images/project_chart.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                      <h2>\u67e5\u8a62\u9032\u5ea6</h2>\r\n					</a>\r\n                    </div>     \r\n					\r\n					\r\n                  <div class=\"frontpage_box col_allw170  hoverdiv\">\r\n				  <a href=\"/project/listTask.jsp\">\r\n                      <img src=\"/images/profile_task.png\" alt=\"Image\" width=\"24\" height=\"24\">\r\n                    <h2>\u4f30\u7b97\u7cfb\u7d71</h2>\r\n					</a>\r\n                  </div>    \r\n				                             \r\n                <div class=\"subBottomDiv\" ></div>     \r\n            	</div>      \r\n				<div id=\"dropBox\" class=\"toggler col_w700 lp_box float_l margin_20rl\">		\r\n				<div class=\"subTopDiv\" >\r\n				<!-- InstanceBeginEditable name=\"PageTitle\" -->\r\n				<h2 class=\"uiHeaderTitle\">\u8edf\u9ad4\u5de5\u7a0b<img class=\"arrow_right\" src=\"/images/arrow_right.png\" />\u5c08\u6848\u4efb\u52d9\u5217\u8868</h2>\r\n				<!-- InstanceEndEditable -->\r\n				</div>\r\n                <!-- InstanceBeginEditable name=\"RightArea\" -->\r\n				<div class=\"table-content\">\r\n					\r\n					<table summary=\"\u4efb\u52d9\u5217\u8868\" width=\"100%\" style=\"height:300px;\">\r\n						<!--<caption>Table designs</caption>-->\r\n						<thead>\r\n						<tr>\r\n							<th width=\"20%\" scope=\"col\">\u4efb\u52d9\u7de8\u865f</th>\r\n							<th width=\"100%\" scope=\"col\">\u4efb\u52d9\u540d\u7a31</th>\r\n							<th width=\"16\" scope=\"col\"></th>\r\n						</tr>\r\n						</thead>\r\n						<tbody id=\"task-list\">\r\n							<tr>\r\n								<td>001</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>\r\n								<td><img src=\"/images/state_ok.png\" width=\"16\" title=\"\u5b8c\u6210\"/></td>									\r\n							</tr>\r\n							<tr class=\"odd\">									\r\n								<td>002</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>	\r\n								<td><img src=\"/images/state_ok.png\" width=\"16\" /></td>									\r\n							</tr>					\r\n							<tr>\r\n								<td>003</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>		\r\n								<td><img src=\"/images/state_delay.png\" width=\"16\" /></td>							\r\n							</tr>\r\n							<tr class=\"odd\">									\r\n								<td>004</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>	\r\n								<td><img src=\"/images/state_doing.png\" width=\"16\" /></td>								\r\n							</tr>		\r\n							<tr>\r\n								<td>005</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>		\r\n								<td><img src=\"/images/state_doing.png\" width=\"16\" /></td>							\r\n							</tr>\r\n							<tr class=\"odd\">									\r\n								<td>006</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>		\r\n								<td><img src=\"/images/state_doing.png\" width=\"16\" /></td>				\r\n							</tr>	\r\n							<tr>\r\n								<td>005</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>\r\n								<td><img src=\"/images/state_doing.png\" width=\"16\" /></td>									\r\n							</tr>\r\n							<tr class=\"odd\">									\r\n								<td>006</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>\r\n								<td><img src=\"/images/state_doing.png\" width=\"16\" /></td>						\r\n							</tr>\r\n							<tr>\r\n								<td>005</td>\r\n								<td><team>\u8edf\u9ad4\u5de5\u7a0b</team>\u5c08\u6848\u4efb\u52d91</td>	\r\n								<td><img src=\"/images/state_doing.png\" width=\"16\" /></td>								\r\n							</tr>																																																																		\r\n						</tbody>\r\n					</table>						\r\n					<div class=\"divider\"></div>\r\n					<div style=\"text-align:right;\">\r\n						<button id=\"dialog_btn\">\u65b0\u589e</button>\r\n						<button id=\"more\">\u66f4\u591a...</button>\r\n					</div>\r\n\r\n				 </div>\r\n\r\n\r\n\r\n\r\n\r\n				<div id=\"dialog\" title=\"\u65b0\u589e\u4efb\u52d9\">\r\n					<p>\u5728<team>\u8edf\u9ad4\u5de5\u7a0b</team>\u65b0\u589e\u4e00\u500b\u4efb\u52d9</p>\r\n					<table width=\"100%\">				\r\n					<form>\r\n						<tr>\r\n							<td width=\"25%\"><label for=\"name\">\u4efb\u52d9\u540d\u7a31</label></td>\r\n							<td width=\"75%\"><input type=\"text\" name=\"name\" id=\"name\" class=\"text ui-widget-content ui-corner-all\" /></td>\r\n						</tr>\r\n						<tr>\r\n							<td width=\"25%\"><label for=\"name\">\u4efb\u52d9\u76ee\u6a19</label></td>\r\n							<td width=\"75%\"><input type=\"text\" name=\"name\" id=\"name\" class=\"text ui-widget-content ui-corner-all\" /></td>\r\n						</tr>						\r\n						<tr>\r\n							<td width=\"25%\"><label for=\"email\">\u8ca0\u8cac\u4eba</label></td>\r\n							<td width=\"75%\"><input type=\"text\" name=\"email\" id=\"email\" value=\"\" class=\"text ui-widget-content ui-corner-all\" /></td>\r\n						</tr>\r\n						<tr>\r\n							<td width=\"25%\"><label for=\"password\">\u958b\u59cb\u6642\u9593</label></td>\r\n							<td width=\"75%\"><input class=\"text ui-widget-content ui-corner-all\" type=\"text\" name=\"date\" id=\"date_start\" /></td>    \r\n						</tr>\r\n						<tr>\r\n							<td width=\"25%\"><label for=\"password\">\u7d50\u675f\u6642\u9593</label></td>\r\n							<td width=\"75%\"><input class=\"text ui-widget-content ui-corner-all\" type=\"text\" name=\"date\" id=\"date_end\" /></td>\r\n						</tr>								\r\n					</form>	\r\n					</table>\r\n					\r\n					<div class=\"divider\"></div>\r\n					<div style=\"text-align:right;\">\r\n						<button>\u78ba\u5b9a</button>\r\n						<button>\u53d6\u6d88</button>\r\n					</div>\r\n					<!--<p>\u4f60\u78ba\u5b9a\u8981\u522a\u9664\u8a72\u5c08\u6848\u55ce?</p>\r\n					<button>\u78ba\u5b9a</button> <button>\u53d6\u6d88</button> -->\r\n				</div>		\r\n				<!-- InstanceEndEditable -->\r\n				<div class=\"subBottomDiv\" ></div>\r\n                </div>\r\n                \r\n				<div class=\"col_p20 lp_box float_r\">\r\n					<div class=\"subTopDiv\" >\r\n						<h2 class=\"uiHeaderTitle\">\u8d0a\u52a9</h2>\r\n					</div>	\r\n						<div style=\"text-align:center; padding:5px;\">\r\n							<img width=\"100%\" class=\"bigpic\" src=\"/images/templatemo_image_05.jpg\" />\r\n							<p><message>\u5ee3\u544a\u8d0a\u52a9</message></p>\r\n						</div>\r\n						<div style=\"text-align:center; padding:5px;\">\r\n							<img width=\"100%\" class=\"bigpic\" src=\"/images/templatemo_image_05.jpg\" />\r\n							<p><message>\u5ee3\u544a\u8d0a\u52a9</message></p>\r\n						</div>\r\n						<div style=\"text-align:center; padding:5px;\">\r\n							<img width=\"100%\" class=\"bigpic\" src=\"/images/templatemo_image_05.jpg\" />\r\n							<p><message>\u5ee3\u544a\u8d0a\u52a9</message></p>\r\n						</div>	\r\n                    <div class=\"subBottomDiv\" ></div>     \r\n            	</div>                     \r\n                \r\n\r\n                \r\n                <div class=\"cleaner\"></div>\r\n\r\n            </div>\r\n\r\n\r\n            \r\n\r\n            \r\n            \r\n        </div> \r\n<!-- end of templatemo main -->\r\n\r\n       \r\n    	\r\n  </div>\r\n</div>\r\n\r\n\r\n\r\n\r\n<div id=\"templatemo_footer_wrapper\">\r\n    <div id=\"templatemo_footer\">\r\n    	\r\n		<a href=\"index.html\">\u9996\u9801</a> | <a href=\"about.html\">\u95dc\u65bc\u6211\u5011</a> | <a href=\"blog.html\">\u6587\u7ae0\u5217\u8868</a> | <a href=\"gallery.html\">Gallery</a> | <a href=\"contact.html\" class=\"last\">Contact</a> <br /><br />\r\n        \r\n        Copyright \u00a9 2011 Project+ | \u6700\u4f73\u7684\u5c08\u6848\u8ffd\u8e64\u8207\u4f30\u7b97\u5de5\u5177\r\n    \r\n  </div> <!-- end of templatemo_footer -->\r\n</div>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>".toCharArray();
    _jsp_string0 = "\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/ProjectMain.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n".toCharArray();
    _jsp_string2 = "\r\n			window.location = \"/login.jsp\";\r\n		".toCharArray();
    _jsp_string1 = "\r\n\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<title>Project+ - \u6700\u4f73\u7684\u5c08\u6848\u8ffd\u8e64\u8207\u4f30\u7b97\u89e3\u6c7a\u65b9\u6848</title>\r\n<meta name=\"keywords\" content=\"magic color, colorful theme, free CSS templates, CSS, HTML\" />\r\n<meta name=\"description\" content=\"Magic Color Theme, Colorful Template, free website template by templatemo.com\" /> \r\n\r\n<link href=\"/css/templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<link href=\"/css/bluetable.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n\r\n<link type=\"text/css\" href=\"/css/ui-lightness/jquery-ui-1.8.16.custom.css\" rel=\"stylesheet\" />	\r\n<script language=\"javascript\" type=\"text/javascript\" src=\"/js/jquery-1.7.1.min.js\"></script>\r\n \r\n<!--jQueryUI-->\r\n<script type=\"text/javascript\" src=\"/js/jquery-ui-1.8.16.custom.min.js\"></script>\r\n\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/jquery.lightbox-0.5.css\" media=\"screen\" />\r\n\r\n<!--colorbox-->\r\n<script type=\"text/javascript\" src=\"/js/colorbox/jquery.colorbox-min.js\"></script>\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/colorbox/colorbox.css\" media=\"screen\" />\r\n\r\n<script type=\"text/javascript\">\r\nvar i = 0;\r\n	$(document).ready(function(){\r\n\r\n		".toCharArray();
  }
}
