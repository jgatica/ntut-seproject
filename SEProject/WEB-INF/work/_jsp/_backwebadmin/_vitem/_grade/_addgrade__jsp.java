/*
 * JSP generated by Resin-4.0.19 (built Tue, 14 Jun 2011 02:11:07 PDT)
 */

package _jsp._backwebadmin._vitem._grade;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import com.ilinke.nonn.vitem.grade.*;

public class _addgrade__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, "/BackWebAdmin/vitem/grade/", session, 8192, true, false);

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
    response.setContentType("text/html; charset=UTF-8");

    out.write(_jsp_string0, 0, _jsp_string0.length);
    out.print((GradeAction.OP_ADDGRADE));
    out.write(_jsp_string1, 0, _jsp_string1.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("BackWebAdmin/vitem/grade/addgrade.jsp"), 9135237036179421564L, false);
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
  private final static char []_jsp_string1;
  static {
    _jsp_string0 = "\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n\r\n\r\n<title>\u65b0\u589e\u8a55\u50f9</title>\r\n<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js\" charset=\"UTF-8\"></script>\r\n<script language=\"javascript\" charset=\"utf-8\">\r\n\r\nfunction addGrade()\r\n{\r\n  var fm = $(\"#addgrade\").get(0);\r\n  if (fm.viprovid.value==\"\")\r\n    alert (\"\u8acb\u8f38\u5165viprovid\u3002\");\r\n  else if (fm.remark.value==\"\")\r\n    alert (\"\u8acb\u8f38\u5165remark\u3002\");\r\n  else if (fm.grade.value > 1 || fm.grade.value < -1){\r\n	alert (\"\u5206\u6578\u53ea\u80fd\u4ecb\u65bc -1 ~ 1\u3002\");\r\n  }\r\n  else\r\n  {\r\n    var argstr=$(\"#addgrade\").serialize();\r\n	//alert(argstr);\r\n    $.post('/BackWebAdmin/vitem/grade/GradeAction.do',argstr,addProcess);\r\n  }\r\n}\r\nfunction addProcess(xml)\r\n{\r\n  messageid = $(xml).find(\"rstdata\").attr('msgid');\r\n  if(messageid>0)\r\n  {\r\n	 alert($(xml).find(\"rstdata\").attr('msg'));\r\n  }\r\n  else\r\n    alert($(xml).find(\"rstdata\").attr('msg'));\r\n}\r\n\r\n\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div style=\"width:500px; margin-left:100px;\">\r\n<form id=\"addgrade\" method=\"post\" action=\"/BackWebAdmin/vitem/grade/GradeAction.do\">	\r\n  <input type=\"hidden\" name=\"op\" value=\"".toCharArray();
    _jsp_string1 = "\"/>\r\n  <br/>\r\n  viprovid: <input type=\"text\" name=\"viprovid\" value=\"987654\" readonly=\"readonly\"/>\r\n  <br/>\r\n  grade: <select name=\"grade\">\r\n   			<option value=\"1\">+1</option>\r\n			<option value=\"0\">0</option>\r\n			<option value=\"-1\">-1</option>\r\n			<option value=\"-2\">-2</option>\r\n  		 </select>\r\n  <br/>\r\n  \r\n\r\nremark: <textarea name=\"remark\" cols=\"30\" rows=\"3\">test</textarea>\r\n  <br/>\r\n  <br/>\r\n  <input type=\"button\" value=\"send grade\" onclick=\"javascript:addGrade()\"/>\r\n</form>\r\n</div>\r\n\r\n</body>\r\n</html>\r\n".toCharArray();
  }
}
