<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/ProfileMain.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Project+</title>
<meta name="keywords" content="magic color, colorful theme, free CSS templates, CSS, HTML" />
<%
	// -------------------
	// Java 程式碼部分
	// -------------------
	boolean isLogin = false;
	boolean goLogin = false;
	
	if(session.getAttribute("isLogin")==null) {
		isLogin = false;
		goLogin = true;
	}

%>

<link href="/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="/css/bluetable.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/js/colorbox/colorbox.css" media="screen" />
<link type="text/css" href="/css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
<script language="javascript" type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.8.16.custom.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/jstorage.js"></script>
<script language="javascript" type="text/javascript" src="/js/langchange.js"></script>
<script type="text/javascript">

	// ------------------------------
	// 語言切換的CallBack所要執行的函式
	// ------------------------------
	function initPage(){

		var langTitle = $['langChanger'].langTag("top-lang-title");
		$("#lang-dialog").dialog( {autoOpen: false, width: 170, minHeight: 80, modal: true, title: langTitle} );
		
		var logoutTitle = $['langChanger'].langTag("top-logout-title");
		$("#logout-dialog").dialog( {autoOpen: false, minWidth: 270, minHeight: 80, modal: true, title: logoutTitle} );
					
	}	


	var i = 0;
	// ------------------------------
	// DOM Tree 完成後執行
	// ------------------------------	
	$(document).ready(function(){	
		
		<%if(goLogin){%>
			window.location = "/login.jsp";
		<%}%>
		
		// 更換介面語系
		$['langChanger'].addLangInitHandler(initPage);
		$['langChanger'].langInit({lang: "en", file: "/js/files/lang-example.xml", version: 2});
		
		// 初始化jQueryUI Button
		$( "button" ).button();
		
		// 綁定切換語系的按鈕
		$("#lang-check").click(function(){
			$("#lang-dialog").dialog('open');
		});
		
		// 切換語系的確認案紐
		$("#lang-btn").click(function(){
			var lang = $('#lang-select').val();
			$("body").changeLang({lang: lang});	
			//window.location.reload();
			$("#lang-dialog").dialog('close');
		});
		
		// 取消按鈕
		$("#lang-cancel").click(function(){
			$("#lang-dialog").dialog('close');
		});				
		
		// 登出按鈕
		$("#logout-check").click(function(){
			$("#logout-dialog").dialog('open');
		});
		
		// 登出確認按鈕
		$("#logout").click(function(){
			var op = 2;		
			$.getJSON('/MemberAction.do',  { op:op }, function(data) {
				//if(data.message=="ok") {
					window.location = "/login.jsp";
				//}
			});
		});
		
		// 登出取消按鈕
		$("#logout-cancel").click(function(){
			$("#logout-dialog").dialog('close');
		});		
		
		// 點及上方按鈕測試，必須讓提示值增加
		$(".top").click(function(){
			var last = 5;
			$("#tip_group_count").hide();
			$("#tip_group").hide();			
			$("#tip_group_count").html(i++);
			$("#tip_group_count").fadeIn(300);
			$("#tip_group").slideDown(300);
			
			$("#tip_mail_count").hide();
			$("#tip_mail").hide();			
			$("#tip_mail_count").html(i);
			$("#tip_mail_count").fadeIn(300);
			$("#tip_mail").slideDown(300);

			$("#tip_message_count").hide();
			$("#tip_message").hide();			
			$("#tip_message_count").html(i);
			$("#tip_message_count").fadeIn(300);
			$("#tip_message").slideDown(300);
		});
		
		//已開啟之menu則關閉
		function menu_adjust()
		{
			if($( "#div-float-teams" ).attr("style") == "display: block; ")
				$( "#teams_btn" ).click();
			if($( "#div-float-account" ).attr("style") == "display: block; ")
				$( "#account_btn" ).click();
			if($( "#div-float-team" ).attr("style") == "display: block; ")
				$( "#team_btn" ).click();
			if($( "#div-float-mail" ).attr("style") == "display: block; ")
				$( "#mail_btn" ).click();
			if($( "#div-float-message" ).attr("style") == "display: block; ")
				$( "#message_btn" ).click();	
		}	
			
		// 點擊右上角團隊按鈕拉出下拉選單
		$( "#teams_btn" ).toggle(
			function () { 
				menu_adjust();
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-teams" ).slideDown(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-teams" ).slideUp(250);
			}
		);
			
		// 點擊右上角個人按鈕拉出下拉選單				
		$( "#account_btn" ).toggle(
			function () { 
				menu_adjust();
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-account" ).slideDown(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-account" ).slideUp(250);
			}
		);

		// 點擊左上角團隊按鈕拉出下拉選單				
		$( "#team_btn" ).toggle(
			function () { 
				menu_adjust();
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-team" ).slideDown(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-team" ).slideUp(250);
			}
		);
		
		// 點擊左上角站內信按鈕拉出下拉選單		
		$( "#mail_btn" ).toggle(
			function () { 
				menu_adjust();
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-mail" ).slideDown(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-mail" ).slideUp(250);
			}
		);
			
		// 點擊左上角訊息按鈕拉出下拉選單				
		$( "#message_btn" ).toggle(
			function () { 
				menu_adjust();
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-message" ).slideDown(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-message" ).slideUp(250);
			}
		);	
			
		
		$( "#newteam_dialog" ).dialog( {autoOpen: false, minWidth: 200, minHeight: 120, modal: true} );
		
		// 點擊又上角新增團斷
		$( "#newteam_btn" ).click(function(){
			$("#newteam_dialog").dialog('open');
		});
		
		$( "#newteam_agree" ).click(function(){
			var op = 0;		
			var name = $('#team_name').val();
			var desc = $('#team_desc').val();
			var phone= $('#team_phone').val();
			var address= $('#team_address').val();
			var fax= $('#team_fax').val();
			var mail= $('#team_mail').val();
			
			$.getJSON('/TeamAction.do',  { op:op,name:name,description:desc,phone:phone,fax:fax,address:address,mail:mail}, function(data) {
			//console.log(data);
				if(data.message=="ok") {
					window.location = "/index.jsp";
				}
				else
					alert(data.message);
			});	
		});	
			
		$( "#newteam_cancel" ).click(function(){
			$("#newteam_dialog").dialog('close');
		});

	}); // End Ready
</script>

<!-- InstanceBeginEditable name="Head" -->

<script language="JavaScript" type="text/javascript">
	/*
	 * 一開始讀取第零筆資料
	 */
	$(document).ready(function(){
		$( "button" ).button();
		$('#date_start').datepicker();
		$('#date_end').datepicker();
		
		$( "#agree" ).click(function(){
<<<<<<< .mine
			var op = 0;		
			var name = $('#project_name').val();
			var destination = $('#project_destination').val();
			var leader = $('#project_leader').val();
			var startDate = $('#project_startDate').val();
			var endDate = $('#project_endDate').val();
			$.getJSON('/ProjectAction.do',  { op:op,name:name,destination:destination,leader:leader,startDate:startDate,endDate:endDate}, function(data){
			//console.log(data);
				if(data.message=="ok") {
					$("#dialog").dialog('close');
					//window.location = "/index.jsp";
				}
				else
					alert(data.message);
			});	
=======
			<!-- 測試 addProject-->
			var op = 0;
			var name = $('#project_name').val();
			var target = $('#project_target').val();
			var manager = $('#project_manager').val();
			var state = $('#project_state').val();
			var start_date = $('#project_startDate').val();
			var end_date = $('#project_endDate').val();
			$.getJSON('/ProjectAction.do',  { op:op, projectName:name, projectTarget:target, projectManager:manager,projectState:state, startDate:start_date, endDate:end_date}, function(data) {
			//console.log(data);
			$("#agree").dialog('close');
			if(data.isSuccess)
				alert(data.message);
			});
>>>>>>> .r69
		});	
			
		$( "#cancel" ).click(function(){
			$("#dialog").dialog('close');
		});
				
		$( "#dialog" ).dialog( {autoOpen: false, minWidth: 200, minHeight: 120, modal: true} );
		$( "#dialog_btn" ).click(function(){
			$("#dialog").dialog('open');
		});	
		
		$( "#more" ).click(function(){
			var content = 	'<tr>' + 
							'<td>001</td>' +
							'<td><team>軟體工程</team>專案任務1</td>'+
							'<td><img src="/images/state_ok.png" width="16" /></td>'+
							'</tr>'+
							'<tr class="odd">'+
							'<td>002</td>'+
							'<td><team>軟體工程</team>專案任務1</td>'+
							'<td><img src="/images/state_ok.png" width="16" /></td>'+
							'</tr>'+
							'<tr>' + 
							'<td>001</td>' +
							'<td><team>軟體工程</team>專案任務1</td>'+
							'<td><img src="/images/state_ok.png" width="16" /></td>'+
							'</tr>'+
							'<tr class="odd">'+
							'<td>002</td>'+
							'<td><team>軟體工程</team>專案任務1</td>'+
							'<td><img src="/images/state_ok.png" width="16" /></td>'+
							'</tr>'
							'<tr>' + 
							'<td>001</td>' +
							'<td><team>軟體工程</team>專案任務1</td>'+
							'<td><img src="/images/state_ok.png" width="16" /></td>'+
							'</tr>'+
							'<tr class="odd">'+
							'<td>002</td>'+
							'<td><team>軟體工程</team>專案任務1</td>'+
							'<td><img src="/images/state_ok.png" width="16" /></td>'+
							'</tr>';
	
			var element = $(content+content+content).hide();
			element.appendTo($("#task-list"));
			element.show(1500);	
		});
		
	}); 

	  	

</script>

<!-- InstanceEndEditable -->

</head>
<body>


<div id="templatemo_body_wrapper">
	<div id="templatemo_wrapper">
    
		<!--<div id="templatemo_header">
        	<div id="site_title"><h1><a href="http://www.templatemo.com" target="_parent">資訊學習網站</a></h1></div>
            <p style="float:right; padding:5px; font-size:15px;">            
            	<a class="ajax" rel="nofollow" href="/login.jsp"><strong>登入</strong></a>
                <strong> / </strong>
                <a class="ajax" rel="nofollow" href="/register.jsp"><strong>註冊</strong></a>
                <!--<a class="iframe" rel="nofollow" href="/addArticle.jsp"><strong>註冊</strong></a>
            </p>
            
        </div>
        -->
<!-- InstanceBeginEditable name="Menu" -->
<!-- InstanceEndEditable -->
<div id="templatemo_white">
</div>
        <div id="templatemo_menu">
            <ul>
            	<li><a href="/index.jsp" class="float_l"><img src="/images/logo.png" height="38" /></a>
			
				</li>
                <li>
                	<a  id="team_btn" href="#" class="float_l">
                        <p id="tip_group_count" class="tip">15</p>
                        <img class="top" src="/images/title_group.png" />
                    </a>				
                </li>
				
<div id="div-float-team">
					<div style="margin-left:20px;margin-top:10px;"><name langtag="top-teambox"></name></div>
					<div class="divider10"></div> 
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/2.jpg" alt="Image" width="32" height="32">
                      <p><name>陳至圓</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/3.jpg" alt="Image" width="32" height="32">
                      <p><name>楊先絜</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  				     
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/1.jpg" alt="Image" width="32" height="32">
                      <p><name>陳奕豪</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/4.jpg" alt="Image" width="32" height="32">
                      <p><name>郭奕成</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  				  
                                  	
</div>					
				
				
                <li>
                	<a  id="mail_btn" href="#" class="float_l">
                        <p id="tip_mail_count" class="tip">15</p>       
                    	<img class="top" src="/images/title_mail.png" />
                    </a>					
                </li>				
<div id="div-float-mail">
					<div style="margin-left:20px;margin-top:10px;"><name langtag="top-mail"></name></div>
					<div class="divider10"></div> 
					<div class="col_allw370 frontpage_box hoverdiv">
                    	<img src="/images/1.jpg" alt="Image" width="32" height="32">
                        <p><name>陳奕豪</name>寄了一封<mail>我想加入</mail>信件給你。</p>
  	                </div>    
            	
</div>						
				<li>
                	<a  id="message_btn" href="#" class="float_l">
                        <p id="tip_message_count" class="tip">15</p>       
                    	<img class="top" src="/images/title_message.png" />
                    </a>
                </li>
<div id="div-float-message">
					<div style="margin-left:20px;margin-top:10px;"><name langtag="top-message"></name></div>
					<div class="divider10"></div> 
					<div class="col_allw370 frontpage_box hoverdiv">
                    	<img src="/images/1.jpg" alt="Image" width="32" height="32">
                        <p><name>陳奕豪</name>在<team>軟體工程</team>新增一筆留言。</p>
  	                </div>    
					<div class="col_allw370 frontpage_box hoverdiv">
                    	<img src="/images/2.jpg" alt="Image" width="32" height="32">
                        <p><name>陳至圓</name>修改了<team>軟體工程</team>的內容。</p>
  	                </div>      					                   
				              	
</div>	
                <li>
				<form method="get" id="searchform" action="#">
					<input type="text" langtag="top-search" value="搜尋..." name="s" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)"/>
						<input type="submit" id="searchsubmit" value=" " />
				</form>      
                </li>
				<li>

				<a  id="account_btn" class="float_r" href="#"><img class="top" src="/images/top_profile.png" /><label langtag="top-account"></label></a>
				<!--<div id="circles" style="text-align:left; background-color:rgba(199, 199, 199, 0.7); width:120px; overflow:auto; position:absolute; padding:50px; max-height:60px;">
        		</div>-->

				
				</li>
<div id="div-float-account">
					<div style="margin-left:20px;margin-top:10px;"><label langtag="top-personal"></label></div>
					<div class="divider10"></div> <!--分隔線-->
                    
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a id="newteam_btn" href="#">
                        <img src="/images/task_group.png" alt="Image" width="24" height="24">
                        <h2 langtag="top-team-new"></h2>                        
						</a>
                    </div>
                    
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a href="/member/task.jsp?id=123">
						<img src="/images/task.png" alt="Image" width="24" height="24" />
						<h2 langtag="top-account-task"></h2>
						</a>
                    </div>   
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a href="/member/mail.jsp?id=123">
                        <img src="/images/mail.png" alt="Image" width="24" height="24">
                        <h2 langtag="top-account-mail"></h2>                        
						</a>
                    </div>					  
                  <div id="lang-check" class="col_allw170 frontpage_box hoverdiv">
                      <img src="/images/lang.png" alt="Image" width="24" height="24">
                    <h2 langtag="top-account-language"></h2>
                  </div>  

				<div id="logout-check" class="col_allw170 frontpage_box hoverdiv">	
                      <img src="/images/logout.png" alt="Image" width="24" height="24">
                      <h2 langtag="top-account-logout"></h2>             	
				</div>
</div>
			
				<li>
					<a id="teams_btn" class="float_r" href="/member/basic.jsp"><img class="top" src="/images/top_account.png" />
					<label langtag="top-team"></label></a>
				</li>	
<div id="div-float-teams">
					<div style="margin-left:20px;margin-top:10px;"><label langtag="top-myteam"></label></div>
					<div class="divider10"></div> <!--分隔線-->
                    <div class="col_allw170 frontpage_box hoverdiv">
					  <a href="/team/detail.jsp?id=123">
                      	<img src="/images/profile_img.png" alt="Image" width="24" height="24">
                      	<h2>軟體工程</h2>                        
					  </a>
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a href="/team/detail.jsp?id=123">
						<img src="/images/android-icon.png" alt="Image" width="24" height="24">
						<h2>Android開發社</h2>   
						</a>                     
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a href="/team/detail.jsp?id=123">
						<img src="/images/jquery-icon.gif" alt="Image" width="24" height="24">
						<h2>jQuery研究社</h2>                        
						</a>
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a href="/team/detail.jsp?id=123">
						<img src="/images/c++-icon.png" alt="Image" width="24" height="24">
						<h2>C++專研區</h2>                        
						</a>
                    </div>										                 	
</div>	
				<li>
					<a class="float_r" href="/index.jsp"><img class="top" src="/images/top_home.png" />
					<label langtag="top-home"></label></a>
				</li>										
				
				
						
            </ul>    	
        </div> 




        <div id="templatemo_main">
            
          <div class="col_w900 hr_divider ">
          		
      			<div id="slide_left" class="col_w170 lp_box float_l">
				<div class="subTopDiv" ><h2 class="uiHeaderTitle" langtag="profile-title"></h2></div>	
					
					<div class="col_allw170 frontpage_box hoverdiv">
                      <a href="/member/basic.jsp">
					  <img src="/images/user.png" alt="Image" width="24" height="24">
                      <h2 langtag="profile-basic"></h2>
					  </a>
                    </div>                    
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/member/photo.jsp">
						<img src="/images/profile_img.png" alt="Image" width="24" height="24">
						<h2 langtag="profile-bigpic"></h2>
					</a>	
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/member/contact.jsp">
						<img src="/images/profile_phone.png" alt="Image" width="24" height="24">
						<h2 langtag="profile-contact"></h2>
					</a>	
                    </div>     
					<div class="col_allw170 frontpage_box hoverdiv">
					<a href="/member/task.jsp">
						<img src="/images/profile_task.png" alt="Image" width="24" height="24">
						<h2 langtag="profile-tasks"></h2>
					</a>
					</div>                                                         
			<div class="subBottomDiv" ></div>            
            </div>      
				<div id="dropBox" class="toggler col_w700 lp_box float_l margin_20rl">		
				<div class="subTopDiv" >
				<!-- InstanceBeginEditable name="PageTitle" -->
                <h2 class="uiHeaderTitle">軟體工程<img class="arrow_right" src="/images/arrow_right.png" />專案列表</h2>
				<!-- InstanceEndEditable -->
				
				</div>	
				<!--<img src="/images/subTitle.jpg" alt="Image" width="690" height="29" />-->
                <!-- InstanceBeginEditable name="RightArea" -->
                <div class="table-content">
					
					<table summary="任務列表" width="100%" style="height:300px;">
						<!--<caption>Table designs</caption>-->
						<thead>
						<tr>
							<th width="20%" scope="col">任務編號</th>
							<th width="100%" scope="col">任務名稱</th>
							<th width="16" scope="col"></th>
						</tr>
						</thead>
						<tbody id="task-list">
							<tr>
								<td>001</td>
								<td><team>軟體工程</team>專案任務1</td>
								<td><img src="/images/state_ok.png" width="16" title="完成"/></td>									
							</tr>
							<tr class="odd">									
								<td>002</td>
								<td><team>軟體工程</team>專案任務1</td>	
								<td><img src="/images/state_ok.png" width="16" /></td>									
							</tr>					
							<tr>
								<td>003</td>
								<td><team>軟體工程</team>專案任務1</td>		
								<td><img src="/images/state_delay.png" width="16" /></td>							
							</tr>
							<tr class="odd">									
								<td>004</td>
								<td><team>軟體工程</team>專案任務1</td>	
								<td><img src="/images/state_doing.png" width="16" /></td>								
							</tr>		
							<tr>
								<td>005</td>
								<td><team>軟體工程</team>專案任務1</td>		
								<td><img src="/images/state_doing.png" width="16" /></td>							
							</tr>
							<tr class="odd">									
								<td>006</td>
								<td><team>軟體工程</team>專案任務1</td>		
								<td><img src="/images/state_doing.png" width="16" /></td>				
							</tr>	
							<tr>
								<td>005</td>
								<td><team>軟體工程</team>專案任務1</td>
								<td><img src="/images/state_doing.png" width="16" /></td>									
							</tr>
							<tr class="odd">									
								<td>006</td>
								<td><team>軟體工程</team>專案任務1</td>
								<td><img src="/images/state_doing.png" width="16" /></td>						
							</tr>
							<tr>
								<td>005</td>
								<td><team>軟體工程</team>專案任務1</td>	
								<td><img src="/images/state_doing.png" width="16" /></td>								
							</tr>																																																																		
						</tbody>
					</table>						
					<div class="divider"></div>
					<div style="text-align:right;">
						<button id="dialog_btn">新增</button>
						<button id="more">更多...</button>
					</div>

				 </div>





				<div id="dialog" title="新增專案">
					<p>在<team>軟體工程</team>新增一個專案</p>
					<table width="100%">				
					<form>
						<tr>
<<<<<<< .mine
							<td width="25%"><label for="name">專案名稱</label></td>
							<td width="75%"><input type="text"id="project_name" class="text ui-widget-content ui-corner-all" /></td>
=======
							<td width="25%"><label for="project_name">專案名稱</label></td>
							<td width="75%"><input type="text" name="name" id="project_name" class="text ui-widget-content ui-corner-all" /></td>
>>>>>>> .r69
						</tr>
						<tr>
<<<<<<< .mine
							<td width="25%"><label for="name">專案目標</label></td>
							<td width="75%"><input type="text" id="project_destination" class="text ui-widget-content ui-corner-all" /></td>
=======
							<td width="25%"><label for="project_target">專案目標</label></td>
							<td width="75%"><input type="text" name="name" id="project_target" class="text ui-widget-content ui-corner-all" /></td>
>>>>>>> .r69
						</tr>						
						<tr>
<<<<<<< .mine
							<td width="25%"><label for="email">負責人</label></td>
							<td width="75%"><input type="text" id="project_leader" value="" class="text ui-widget-content ui-corner-all" /></td>
=======
							<td width="25%"><label for="project_manager">負責人</label></td>
							<td width="75%"><input type="text" name="email" id="project_manager" value="" class="text ui-widget-content ui-corner-all" /></td>
>>>>>>> .r69
						</tr>
						<tr>
<<<<<<< .mine
							<td width="25%"><label for="password">開始時間</label></td>
							<td width="75%"><input class="text ui-widget-content ui-corner-all" type="text" name="date" id="project_startDate" /></td>    
=======
                        <!-- 多加一個狀態-->
                        	<td width="25%"><label for="project_state">狀態</label></td>
							<td width="75%"><input type="text" name="email" id="project_state" value="" class="text ui-widget-content ui-corner-all" /></td>
>>>>>>> .r69
						</tr>
						<tr>
<<<<<<< .mine
							<td width="25%"><label for="password">結束時間</label></td>
							<td width="75%"><input class="text ui-widget-content ui-corner-all" type="text" name="date" id="project_endDate" /></td>
=======
							<td width="25%"><label for="project_startDate">開始時間</label></td>
							<td width="75%"><input class="text ui-widget-content ui-corner-all" type="text" name="date" id="project_startDate" /></td>    
						</tr>
						<tr>
							<td width="25%"><label for="project_endDate">結束時間</label></td>
							<td width="75%"><input class="text ui-widget-content ui-corner-all" type="text" name="date" id="project_endDate" /></td>
>>>>>>> .r69
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
                <!-- InstanceEndEditable -->
				<div class="subBottomDiv" ></div>
				
                </div>
				
				<div class="col_p20 lp_box float_r">
					<div class="subTopDiv" >
						<h2 class="uiHeaderTitle">贊助</h2>
					</div>	
						<div style="text-align:center; padding:5px;">
							<img width="100%" class="bigpic" src="/images/templatemo_image_05.jpg" />
							<p><message>廣告贊助</message></p>
						</div>
						<div style="text-align:center; padding:5px;">
							<img width="100%" class="bigpic" src="/images/templatemo_image_05.jpg" />
							<p><message>廣告贊助</message></p>
						</div>
						<div style="text-align:center; padding:5px;">
							<img width="100%" class="bigpic" src="/images/templatemo_image_05.jpg" />
							<p><message>廣告贊助</message></p>
						</div>	
                    <div class="subBottomDiv" ></div>     
            	</div>
								
                <div class="cleaner"></div>
            </div>
        </div> 
<!-- end of templatemo main -->

       
    	
  </div>
</div>


<div id="newteam_dialog" title="新增團隊">
					<p>在<team>軟體工程</team>新增一個團隊</p>
					<table width="100%">				
					<form>
						<tr>
							<td width="25%"><label for="name">團隊名稱</label></td>
							<td width="75%"><input type="text"  id="team_name" class="text ui-widget-content ui-corner-all" /></td>
						</tr>
						<tr>
							<td width="25%"><label for="name">團隊介紹</label></td>
							<td width="75%"><input type="text" id="team_desc" class="text ui-widget-content ui-corner-all" /></td>
						</tr>	
                        <tr>
							<td width="25%"><label for="name">聯絡電話</label></td>
							<td width="75%"><input type="text" id="team_phone" class="text ui-widget-content ui-corner-all" /></td>
						</tr>	
                        <tr>
							<td width="25%"><label for="name">聯絡信箱</label></td>
							<td width="75%"><input type="text" id="team_mail" class="text ui-widget-content ui-corner-all" /></td>
						</tr>	
                        <tr>
							<td width="25%"><label for="name">傳真</label></td>
							<td width="75%"><input type="text" id="team_fax" class="text ui-widget-content ui-corner-all" /></td>
						</tr>	
                        <tr>
							<td width="25%"><label for="name">地址</label></td>
							<td width="75%"><input type="text" id="team_address" class="text ui-widget-content ui-corner-all" /></td>
						</tr>							
					</form>	
					</table>
					
					<div class="divider"></div>
					<div style="text-align:right;">
						<button id="newteam_agree">確定</button>
						<button id="newteam_cancel">取消</button>
					</div>
					<!--<p>你確定要刪除該專案嗎?</p>
					<button>確定</button> <button>取消</button> -->
				</div>	

<div id="templatemo_footer_wrapper">
    <div id="templatemo_footer">
    	
		<a href="index.html">首頁</a> | <a href="about.html">關於我們</a> | <a href="blog.html">文章列表</a> | <a href="gallery.html">Gallery</a> | <a href="contact.html" class="last">Contact</a> <br /><br />
        
        Copyright © 2011 Project+ | 最佳的專案追蹤與估算工具
    
  </div> <!-- end of templatemo_footer -->
</div>
		<div id="logout-dialog"  title="">
			<p langtag="top-logout-msg" title="登出"></p>
						
			<div class="divider"></div>
			<div style="text-align:center;">
				<button id="logout"><label langtag="top-logout-ok"></label></button>
				<button id="logout-cancel"><label langtag="top-logout-cancel"></label></button>
			</div>
		</div>		

		<div id="lang-dialog" title="更改語言">
			<p langtag="top-lang-msg"></p>
			<select id="lang-select">
				<option value="tw">繁體中文</option>
				<option value="cn">简体中文</option>
				<option value="en">English</option>
			</select>		
			<div class="divider"></div>
			<div style="text-align:center;">
				<button id="lang-btn"><label langtag="top-logout-ok"></label></button>
				<button id="lang-cancel"><label langtag="top-logout-cancel"></label></button>
			</div>
		</div>	


</body>
<!-- InstanceEnd --></html>