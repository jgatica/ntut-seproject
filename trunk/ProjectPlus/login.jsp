<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Project+ - 最佳的專案追蹤與估算解決方案</title>
<meta name="keywords" content="magic color, colorful theme, free CSS templates, CSS, HTML" />
<meta name="description" content="Magic Color Theme, Colorful Template, free website template by templatemo.com" /> 

<link href="/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="/css/bluetable.css" rel="stylesheet" type="text/css" />

<link type="text/css" href="/css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
<script language="javascript" type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
 
<!--jQueryUI-->
<script type="text/javascript" src="/js/jquery-ui-1.8.16.custom.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/jquery.lightbox-0.5.css" media="screen" />


<!--語系切換-->
<script language="javascript" type="text/javascript" src="/js/jstorage.js"></script>
<script language="javascript" type="text/javascript" src="/js/langchange.js"></script>

<!--colorbox-->
<script type="text/javascript" src="/js/colorbox/jquery.colorbox-min.js"></script>
<link rel="stylesheet" type="text/css" href="/js/colorbox/colorbox.css" media="screen" />

<script src="http://connect.facebook.net/en_US/all.js"></script>
<script language="javascript" type="text/javascript">
	$(document).ready(function(){
		var initPage;
		
		$['langChanger'].langInit({lang: "en", file: "/js/files/lang-example.xml", version: 2}, initPage);
		$( "#register_dialog" ).dialog( {autoOpen: false, minWidth: 200, minHeight: 120, modal: true} );
		$( "button" ).button();
		$('#facebook').click(loginFacebook);
		
		FB.init({
			appId  : '187257524702118',
			status : true, // check login status
			cookie : true, // enable cookies to allow the server to access the session
			xfbml  : true,  // parse XFBML
			oauth: true,
			channelUrl: 'http://localhost:8080/'
		});
		
		$('#register').click(function(){
			$( "#register_dialog" ).dialog("open");		
		});
	
		$("#agree").click(function(){
			var op = 0;		
			var email = $('#member_email').val();
			var name = $('#member_name').val();
			var nick_name = $('#member_nickname').val();
			var password = $('#member_password').val();
			$.getJSON('/MemberAction.do',  { op:'op',member_email:email,password:password,member_name:name,member_nickname:nick_name}, function(data) {
			//console.log(data);
				if(data.message=="ok") {
					window.location = "/index.jsp";
				}
				else
					alert(data.message);
			});
		});
		
		$('#cancel').click(function(){
			$("#register_dialog").dialog('close');		
		});
		
		$('#login').click(function(){
			var op = 1;		
			var email = $('#email').val();
			var password = $('#password').val();
			$.getJSON('/MemberAction.do',  { op:op, member_email:email, password:password }, function(data) {
			console.log(data);
				if(data.message=="ok") {
					window.location = "/index.jsp";
				}
				else
					alert(data.message);
			});			
		});
	});   

var responseLogin;
var responseLogout;
var responseStatusChange;
var responseSessionChange;

// 驗證登入
FB.Event.subscribe('auth.login', function(resp) {
  responseLogin = resp;
});

FB.Event.subscribe('auth.logout', function(resp) {
  responseLogin = resp;
});

FB.Event.subscribe('auth.statusChange', function(resp) {
  //responseStatusChange = resp;
});
			
FB.Event.subscribe('auth.sessionChange', function(resp) {
  responseSessionChange = resp;
});

function checkToken(resp){
  var fm = document.FBLoginForm;
  
  if (!resp.userID){
	return;
  }
  fm.uid.value = resp.userID;
  fm.accesstoken.value = resp.accessToken;
  $('#mainregion').hide();
  $('#progressregion').show();
  fm.submit();
}

//FaceBook登入
function loginFacebook(){	

FB.login(function(resp){
    if (resp.authResponse) {
	  checkToken(resp.authResponse);
    } else {
	
    }
  }, {scope:'read_stream,publish_stream,offline_access,email'});

}

<%if(session.getAttribute("isLogin")!=null /*&& session.getAttribute("isLogin")=="true"*/){%>
	window.location = "/index.jsp";
<%}%>

</script>

</head>
<body>


<div id="templatemo_body_wrapper">
	<div id="templatemo_wrapper">

<div id="templatemo_white">
</div>
        <div id="templatemo_menu"></div> 



        <div id="templatemo_main">
            
          <div class="col_w900 hr_divider">
          		
				
    
				<div id="dropBox" class="toggler col_w700 lp_box float_l margin_20rl">		
				<div class="subTopDiv" >
					<h2 class="uiHeaderTitle">Project+<img class="arrow_right" src="/images/arrow_right.png" /><label langtag="login-ads-title"></label></h2>
				</div>	
				


					<ul class="lp_frontpage">
						<li><a href="#"><img width="200" height="100" src="images/templatemo_image_01.jpg" alt="Image 01" /></a></li>
						<li><a href="#"><img width="200" height="100" src="images/templatemo_image_02.jpg" alt="Image 02" /></a></li>
						<li><a href="#"><img width="200" height="100" src="images/templatemo_image_03.jpg" alt="Image 03" /></a></li>
						<li><a href="#"><img width="200" height="100" src="images/templatemo_image_04.jpg" alt="Image 04" /></a></li>
					</ul>   

					<div class="subBottomDiv" ></div>
				
                </div>
      			<div id="slide_left" class="col_p35 lp_box float_r">
					<div class="subTopDiv" >
						<h2 class="uiHeaderTitle" langtag="login-login-title">登入Project+</h2>
					</div>					
					
<div id="cp_contact_form">

              <label for="email" langtag="login-login-account"></label>
              <input type="text" id="email" class="input_field" />
              <div class="cleaner h10"></div>
              <label for="password" langtag="login-login-password"></label>
              <input type="password" class="input_field"  id="password" />
              
              <div class="cleaner h10"></div>
			
            <button id="register" class="float_l" ><name langtag="login-login-register"></name></button>
			<button id="login" class="float_r"><team langtag="login-login-login"></team></button>  
			<button id="facebook" class="float_r" ><name langtag="login-login-facebook"></name></button>

      </div>
	  <div id="register_dialog" title="註冊帳號">
					<table width="100%">				
					<form>
						<tr>
							<td width="25%"><label for="member_email">E-mail</label></td>
							<td width="75%"><input type="text" id="member_email" class="text ui-widget-content ui-corner-all" /></td>
						</tr>
                        
                        <tr>
							<td width="25%"><label for="member_password">密碼</label></td>
							<td width="75%"><input class="text ui-widget-content ui-corner-all" type="password" id="member_password" /></td>    
						</tr>
                        
						<tr>
							<td width="25%"><label for="member_name">姓名</label></td>
							<td width="75%"><input type="text" class="text ui-widget-content ui-corner-all" id="member_name"/></td>
						</tr>
                        						
						<tr>
							<td width="25%"><label for="member_nickname">暱稱</label></td>
							<td width="75%"><input type="text" class="text ui-widget-content ui-corner-all" id="member_nickname"/></td>
						</tr>							
					</form>	
					</table>
					
					<div class="divider"></div>
					<div style="text-align:right;">
						<button id="agree">確定</button>
						<button id="cancel">取消</button>
					</div>
					<!--<p>你確定要刪除該專案嗎?</p>
					<button>確定</button> <button>取消</button> -->
				</div>		
						                 
                                                         
					<div class="subBottomDiv" ></div>            
            	</div>  	
				
							
                <div class="cleaner"></div>
            </div>
        </div> 
		
		
<div id="fb-root"></div>
<form name="hiddenForm" method="post"> 
  <input type="hidden" name="token">
</form>
<form name="FBLoginForm" id="FBLoginForm" method="post" action="/FacebookLoginAction.do">
  <input type="hidden" name="uid"/>
  <input type="hidden" name="accesstoken"/>
</form>		

        </div> <!-- end of templatemo main -->

       
    	
  </div>
</div>




<div id="templatemo_footer_wrapper">
    <div id="templatemo_footer">
    	
		<a href="index.html">首頁</a> | <a href="about.html">關於我們</a> | <a href="blog.html">文章列表</a> | <a href="gallery.html">Gallery</a> | <a href="contact.html" class="last">Contact</a> <br /><br />
        
        Copyright © 2011 Project+ | 最佳的專案追蹤與估算工具
    
  </div> 
</div>

</body>
</html>