/*
 * JSP generated by Resin-4.0.19 (built Tue, 14 Jun 2011 02:11:07 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _register__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, null, 8192, true, false);

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
    depend = new com.caucho.vfs.Depend(appDir.lookup("register.jsp"), -7680503316742781037L, false);
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
    _jsp_string0 = "\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<title>\u8a3b\u518a\u6703\u54e1</title>\r\n<script language=\"javascript\" type=\"text/javascript\" src=\"/js/jquery-1.7.1.min.js\"></script>\r\n<link href=\"/css/templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<script language=\"javascript\" type=\"text/javascript\" src=\"/js/email.checker.js\"></script>\r\n\r\n<script>\r\n$(document).ready(function(){\r\n	$(\"#email_error\").hide();	\r\n	$(\"#repassword_error\").hide();		\r\n	\r\n	$(\"#email\").focusout(function(){\r\n		var email = $(\"#email\").val();\r\n		if(isEmail(email)){\r\n			$(this).removeClass(\"input_field_error\");\r\n			$(this).addClass(\"input_field\");			\r\n			$(\"#email_error\").hide();			\r\n		}\r\n		else {\r\n			$(this).removeClass(\"input_field\");\r\n			$(this).addClass(\"input_field_error\");\r\n			$(\"#email_error\").show();			\r\n		}\r\n	});\r\n	\r\n	$(\"#repassword\").focusout(function(){\r\n		var repassword = $(\"#repassword\").val();\r\n		var password = $(\"#password\").val();\r\n		if(password == repassword){\r\n			$(this).removeClass(\"input_field_error\");\r\n			$(this).addClass(\"input_field\");			\r\n			$(\"#repassword_error\").hide();			\r\n		}\r\n		else {\r\n			$(this).removeClass(\"input_field\");\r\n			$(this).addClass(\"input_field_error\");\r\n			$(\"#repassword_error\").show();			\r\n		}\r\n	});\r\n	\r\n	\r\n	\r\n});\r\n</script>\r\n\r\n\r\n</head>\r\n\r\n<body>\r\n<div id=\"templatemo_login\">\r\n  <div class=\"col_w400 hr_divider\">\r\n    \r\n      <h2>ITHub</h2>\r\n    <p><a href=\"http://jigsaw.w3.org/css-validator/check/referer\" rel=\"nofollow\"><strong>\u8a3b\u518a</strong></a>\u60a8\u5728ITHub\u7684\u5e33\u865f</p>\r\n    \r\n    <div class=\"col_w420 float_l\">\r\n          <div id=\"cp_contact_form\">\r\n            <form action=\"#\" method=\"post\" name=\"contact\" id=\"contact\">\r\n              <label for=\"author3\">\u672c\u540d:</label>\r\n              <input type=\"text\" id=\"author3\" name=\"author\" class=\"required input_field\" />\r\n              \r\n              <label for=\"email\">Email:</label>\r\n              \r\n              <input type=\"text\" id=\"email\" name=\"author\" class=\"required input_field\" />\r\n              <img id=\"email_error\" src=\"/images/register_error.png\" width=\"20\" height=\"20\"/>\r\n              \r\n              \r\n              <label for=\"email\">\u5bc6\u78bc:</label>\r\n              <input type=\"password\" class=\"validate-email required input_field\" name=\"email\" id=\"password\" />\r\n              <label for=\"email\">\u78ba\u8a8d\u5bc6\u78bc:</label>\r\n              <input type=\"password\" class=\"validate-email required input_field\" name=\"email\" id=\"repassword\" />\r\n              <img id=\"repassword_error\" src=\"/images/register_error.png\" width=\"20\" height=\"20\"/>              \r\n              <div class=\"cleaner h10\"></div>\r\n              <input type=\"reset\" value=\"\u78ba\u8a8d\u8a3b\u518a\" id=\"reset\" name=\"reset\" class=\"submit_btn float_r\" />\r\n            </form>\r\n      </div>\r\n    </div>\r\n    </div>\r\n    <div class=\"col_w400\"></div> \r\n    <div class=\"col_w400\"></div>    \r\n  \r\n</div>\r\n\r\n</body>\r\n</html>".toCharArray();
  }
}
