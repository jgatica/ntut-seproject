/*
 * JSP generated by Resin-4.0.19 (built Tue, 14 Jun 2011 02:11:07 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _teammember__jsp extends com.caucho.jsp.JavaPage
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("teamMember.jsp"), 2117657064459055254L, false);
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
    _jsp_string0 = "\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/MainTemplate.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n	<head>\r\n		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n		<title>Shinra</title>\r\n		\r\n		<!-- CSS -->\r\n		<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"screen\" />\r\n		<link rel=\"stylesheet\" href=\"css/social-icons.css\" type=\"text/css\" media=\"screen\" />\r\n        <link rel=\"stylesheet\" href=\"css/styled-elements.css\" type=\"text/css\" media=\"screen\" />\r\n		<!--[if IE 8]>\r\n			<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"/css/ie8-hacks.css\" />\r\n		<![endif]-->\r\n		<!-- ENDS CSS -->	\r\n		\r\n		<!-- GOOGLE FONTS -->\r\n		<link href='http://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>\r\n		\r\n		<!-- JS -->\r\n		<script type=\"text/javascript\" src=\"js/jquery-1.5.1.min.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/jquery-ui-1.8.13.custom.min.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/easing.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/jquery.scrollTo-1.4.2-min.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/quicksand.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/jquery.cycle.all.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/custom.js\"></script>\r\n		<!--[if IE]>\r\n			<script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n		<![endif]-->\r\n		\r\n		<!--[if IE 6]>\r\n			<script type=\"text/javascript\" src=\"js/DD_belatedPNG.js\"></script>\r\n			<script>\r\n	      		/* EXAMPLE */\r\n	      		//DD_belatedPNG.fix('*');\r\n	    	</script>\r\n		<![endif]-->\r\n		<!-- ENDS JS -->\r\n		\r\n		\r\n		<!-- Nivo slider -->\r\n		<link rel=\"stylesheet\" href=\"css/nivo-slider.css\" type=\"text/css\" media=\"screen\" />\r\n		<script src=\"js/nivo-slider/jquery.nivo.slider.js\" type=\"text/javascript\"></script>\r\n		<!-- ENDS Nivo slider -->\r\n		\r\n		<!-- tabs -->\r\n		<link rel=\"stylesheet\" href=\"css/tabs.css\" type=\"text/css\" media=\"screen\" />\r\n		<script type=\"text/javascript\" src=\"js/tabs.js\"></script>\r\n  		<!-- ENDS tabs -->\r\n  		\r\n  		<!-- prettyPhoto -->\r\n		<script type=\"text/javascript\" src=\"js/prettyPhoto/js/jquery.prettyPhoto.js\"></script>\r\n		<link rel=\"stylesheet\" href=\"js/prettyPhoto/css/prettyPhoto.css\" type=\"text/css\" media=\"screen\" />\r\n		<!-- ENDS prettyPhoto -->\r\n		\r\n		<!-- superfish -->\r\n		<link rel=\"stylesheet\" media=\"screen\" href=\"css/superfish.css\" /> \r\n		<link rel=\"stylesheet\" media=\"screen\" href=\"css/superfish-left.css\" /> \r\n		<script type=\"text/javascript\" src=\"js/superfish-1.4.8/js/hoverIntent.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/superfish-1.4.8/js/superfish.js\"></script>\r\n		<script type=\"text/javascript\" src=\"js/superfish-1.4.8/js/supersubs.js\"></script>\r\n		<!-- ENDS superfish -->\r\n		\r\n		<!-- poshytip -->\r\n		<link rel=\"stylesheet\" href=\"js/poshytip-1.0/src/tip-twitter/tip-twitter.css\" type=\"text/css\" />\r\n		<link rel=\"stylesheet\" href=\"js/poshytip-1.0/src/tip-yellowsimple/tip-yellowsimple.css\" type=\"text/css\" />\r\n		<script type=\"text/javascript\" src=\"js/poshytip-1.0/src/jquery.poshytip.min.js\"></script>\r\n		<!-- ENDS poshytip -->\r\n		\r\n		<!-- Tweet -->\r\n		<link rel=\"stylesheet\" href=\"css/jquery.tweet.css\" media=\"all\"  type=\"text/css\"/> \r\n		<script src=\"js/tweet/jquery.tweet.js\" type=\"text/javascript\"></script> \r\n		<!-- ENDS Tweet -->\r\n		\r\n		<!-- Fancybox -->\r\n		<link rel=\"stylesheet\" href=\"js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.css\" type=\"text/css\" media=\"screen\" />\r\n		<script type=\"text/javascript\" src=\"js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.pack.js\"></script>\r\n		<!-- ENDS Fancybox -->\r\n		\r\n		<!-- SKIN -->\r\n		<link rel=\"stylesheet\" href=\"skins/plastic/style.css\" type=\"text/css\" media=\"screen\" />\r\n\r\n		<!-- InstanceBeginEditable name=\"Head\" -->Head<!-- InstanceEndEditable -->\r\n\r\n</head>\r\n	\r\n	<body class=\"\">\r\n		\r\n	\r\n		<!-- WRAPPER -->\r\n	  <div id=\"wrapper\">\r\n			\r\n			<!-- HEADER -->\r\n			<div id=\"header\">\r\n<a href=\"index.html\"><img id=\"logo\" src=\"img/logo.png\" alt=\"Nova\" /></a>\r\n			<!-- Social -->\r\n			<div id=\"social-holder\">\r\n				<ul class=\"social\">\r\n					<li><a href=\"http://www.facebook.com\" class=\"poshytip facebook\" title=\"Become a fan\"></a></li>\r\n					<li><a href=\"http://www.twitter.com\" class=\"poshytip twitter\" title=\"Follow our tweets\"></a></li>\r\n					<li><a href=\"http://www.dribbble.com\" class=\"poshytip dribbble\" title=\"View our work\"></a></li>\r\n					<li><a href=\"http://www.addthis.com\" class=\"poshytip addthis\" title=\"Tell everybody\"></a></li>\r\n					<li><a href=\"http://www.vimeo.com\" class=\"poshytip vimeo\" title=\"View our videos\"></a></li>\r\n					<li><a href=\"http://www.youtube.com\" class=\"poshytip youtube\" title=\"View our videos\"></a></li>\r\n				</ul>\r\n			</div>\r\n			<!-- ENDS Social -->\r\n			\r\n			<!-- Navigation -->\r\n			<ul id=\"nav\" class=\"sf-menu\">\r\n				<li><a href=\"/index.jsp\">\u9996 \u9801</a></li>\r\n                <li><a href=\"/teamMember.jsp\">\u6210\u54e1\u540d\u55ae</a><li>\r\n				<li><a href=\"features.html\">\u9801\u9762\u5143\u7d20</a>\r\n					<ul>\r\n						<li><a href=\"features-appearance.html\"><span> \u5916\u8868</span></a></li>\r\n						<li><a href=\"features-columns.html\"><span> \u6a19\u984c</span></a></li>\r\n						<li><a href=\"features-accordion.html\"><span> \u52d5\u756b</span></a></li>\r\n						<li><a href=\"features-toggle.html\"><span> \u89f8\u767c\u76d2</span></a></li>\r\n						<li><a href=\"features-tabs.html\"><span> \u6a19\u7c64</span></a></li>\r\n						<li><a href=\"features-infobox.html\"><span> \u6587\u5b57\u65b9\u584a</span></a></li>\r\n						<li><a href=\"features-monobox.html\"><span> \u5716\u793a</span></a></li>\r\n					</ul>\r\n				</li>\r\n				<li><a href=\"blog.html\">\u90e8\u843d\u683c</a></li>\r\n				<li><a href=\"portfolio.html\">\u6587\u4ef6\u593e</a></li>\r\n				<li><a href=\"gallery.html\">\u756b\u5eca</a>\r\n					<ul>\r\n						<li><a href=\"gallery.html\"><span> \u56db\u6b04 </span></a></li>\r\n						<li><a href=\"gallery-3.html\"><span> \u4e09\u6b04 </span></a></li>\r\n						<li><a href=\"gallery-2.html\"><span> \u5169\u6b04 </span></a></li>\r\n							<li><a href=\"video-gallery.html\"><span> \u5f71\u7247\u756b\u5eca </span></a></li>\r\n					</ul>\r\n				</li>\r\n				<li><a href=\"contact.html\">\u806f\u7d61\u6211\u5011</a></li>\r\n			</ul>\r\n			<!-- Navigation -->	\r\n			\r\n			<!-- search -->\r\n			<div class=\"top-search\">\r\n				<form  method=\"get\" id=\"searchform\" action=\"#\">\r\n					<div>\r\n						<input type=\"text\" value=\"\u641c\u5c0b...\" name=\"s\" id=\"s\" onfocus=\"defaultInput(this)\" onblur=\"clearInput(this)\" />\r\n						<input type=\"submit\" id=\"searchsubmit\" value=\" \" />\r\n					</div>\r\n				</form>\r\n			</div>\r\n			<!-- ENDS search -->\r\n				\r\n                <!-- Breadcrumb-->\r\n                <div id=\"breadcrumbs\">\r\n					<!-- InstanceBeginEditable name=\"Guide\" -->\r\n                    Guide\r\n					<!-- InstanceEndEditable -->\r\n              </div>\r\n				<!-- ENDS Breadcrumb-->	\r\n                \r\n                \r\n\r\n				\r\n		  </div>\r\n			<!-- ENDS HEADER -->\r\n			\r\n			<!-- MAIN -->\r\n			<div id=\"main\">\r\n				<!-- InstanceBeginEditable name=\"Main\" -->\r\n			<div id=\"content\">\r\n				\r\n				<!-- title -->\r\n				<div id=\"page-title\">\r\n					<span class=\"title\">\u529f\u80fd\u6e2c\u8a66\u9801\u9762</span>\r\n					<span class=\"subtitle\">\u547c\u53eb\u67d0OP\u4f7f\u7528\u5c0d\u8a71\u6846\u6aa2\u8996\u7d50\u679c.</span>\r\n				</div>\r\n				<!-- ENDS title -->\r\n				\r\n				<!-- page-content -->\r\n				<div id=\"page-content\">\r\n                    <h4 class=\"line-divider\">\u7d44\u54e1\u540d\u55ae</h4>\r\n                    <table>				\r\n						<tbody>\r\n							<tr>\r\n								<th>\u7de8\u865f</th>\r\n								<th>\u59d3\u540d</th>\r\n								<th>\u8ca0\u8cac\u4e8b\u9805</th>\r\n								<th>\u4fe1\u7bb1</th>\r\n							</tr>\r\n							<tr>\r\n								<td>001</td>\r\n                                <td>\u9673\u5955\u8c6a</td>\r\n                                <td>\u5f85\u78ba\u8a8d</td>\r\n                                <td>@gmail.com</td>\r\n							</tr>\r\n							<tr>\r\n								<td>002</td>\r\n                                <td>\u9673\u81f3\u5713</td>\r\n                                <td>\u5f85\u78ba\u8a8d</td>\r\n                                <td>@gmail.com</td>\r\n							</tr>\r\n							<tr>\r\n								<td>003</td>\r\n                                <td>\u694a\u5148\u7d5c</td>\r\n                                <td>\u5f85\u78ba\u8a8d</td>\r\n                                <td>@gmail.com</td>\r\n							</tr>\r\n							<tr>\r\n								<td>004</td>\r\n                                <td>\u90ed\u5955\u6210</td>\r\n                                <td>\u5f85\u78ba\u8a8d</td>\r\n                                <td>@gmail.com</td>\r\n							</tr>\r\n							<tr>\r\n								<td>005</td>\r\n                                <td>\u9ec3\u81e3\u9038</td>\r\n                                <td>\u5f85\u78ba\u8a8d</td>\r\n                                <td>@gmail.com</td>\r\n						</tbody>\r\n					</table>\r\n                </div>\r\n           </div>\r\n                <!-- InstanceEndEditable -->\r\n            </div>\r\n			<!-- ENDS MAIN -->\r\n			\r\n			<!-- FOOTER -->\r\n			<div id=\"footer\">\r\n				\r\n				<!-- footer-cols -->\r\n				<ul id=\"footer-cols\">\r\n					<li class=\"col\">\r\n						<h6>\u95dc\u65bcSEProject</h6>\r\n						\u9019\u500b\u5c08\u6848\u70ba\u53f0\u5317\u79d1\u6280\u5927\u5b78- \u8edf\u9ad4\u5de5\u7a0b\u8ab2\u7a0b\u6240\u7814\u767c\uff0c\u6211\u5011\u8a34\u6c42\u5c07\u5c08\u6848\u5206\u6790\u505a\u5230\u4e00\u500b\u6574\u5408\u3002\r\n					</li>\r\n					<li class=\"col\">\r\n						<h6>Categories</h6>\r\n						<ul>\r\n							<li><a href=\"#\">Webdesign</a></li>\r\n							<li><a href=\"#/\">Wordpress</a></li>\r\n							<li><a href=\"#\">Photo</a></li>\r\n							<li><a href=\"#\">Code</a></li>\r\n						</ul>\r\n					</li>\r\n					<li class=\"col\">\r\n						<h6>Categories</h6>\r\n						<ul>\r\n							<li><a href=\"#\">Webdesign</a></li>\r\n							<li><a href=\"#/\">Wordpress</a></li>\r\n							<li><a href=\"#\">Photo</a></li>\r\n							<li><a href=\"#\">Code</a></li>\r\n						</ul>\r\n					</li>\r\n				</ul>\r\n				<!-- ENDS footer-cols -->\r\n				\r\n				<!-- Bottom -->\r\n				<div id=\"bottom\">\r\n					\u6a23\u677f\u4f5c\u8005\u70ba <a href=\"http://www.luiszuno.com\"> Luiszuno</a> \u7248\u6b0a\u6240\u6709\r\n					\r\n					<div id=\"to-top\" class=\"poshytip\" title=\"To top\"></div>\r\n					\r\n				</div>\r\n				<!-- ENDS Bottom -->\r\n			</div>\r\n			<!-- ENDS FOOTER -->\r\n		\r\n		</div>\r\n		<!-- ENDS WRAPPER -->\r\n	\r\n	</body>\r\n	\r\n<!-- InstanceEnd --></html>".toCharArray();
  }
}
