<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,com.projectplus.member.MemberDataStructure" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/ProjectMain.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
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
		//div-float-team
		$.getJSON('/TeamAction.do',  { op:7 }, function(data) {
			if(data!=null)
			{
				//alert();
				//console.log(data); 
				//$("#div-float-teams").html("");
				var size = data.length,index;
					
				for(index = 0; index < size; index++)
				{
					var content = '<div class="col_allw170 frontpage_box hoverdiv">' +
								 '<a href="/team/detail.jsp?id='+ data[index].id +'">' +
								' <img src="' + data[index].imageURL + '" alt="Image" width="24" height="24">'+
								 '<h2>'+ data[index].name + '</h2></a</div>' ;
					$("#div-float-teams").append(content);
				}
			}
		});
		
		// 更換介面語系
		$['langChanger'].addLangInitHandler(initPage);
		$['langChanger'].langInit({lang: "en", file: "/js/files/lang-example.xml", version: 10});
		
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
			var fax= $('#team_fax').val();
			var mail= $('#team_mail').val();
			
			$.getJSON('/TeamAction.do',  { op:op,name:name,description:desc,phone:phone,fax:fax,mail:mail}, function(data) {
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
		
		funciton cal_COCOMOII()
		{
			//FP and Language------------------------------功能點值 與 程式語言類型
			var FP;
			var languageType;
			// Software Scale Drivers--------------------為權重值
			var pecedentednes;
			var architecture_risk_Resolution;
			var development_Flexibility;
			var team_Cohesion;
			var process_Maturity;
			
			//Software Cost Drivers --------------------------------------為權重值
			//Product======================
			var required_Software_Reliability;
			var data_Base_Size;
			var product_Complexity;
			var developed_for_Reusability;
			var documentation_Match_to_Lifecycle_Needs;
			
			//Personnel======================
			var analyst_Capability;
			var programmer Capability;	
			var personnel_Continuity;	
			var application_Experience;	
			var platform_Experience;
			var language_and_Toolset_Experience;
			
			//Platform======================
			var time_Constraint;
			var storage_Constraint;	
			var platform_Volatility;	
			
			//Project======================
			var use_of_Software_Tools;	
			var multisite_Development;
			var required_Development_Schedule;
			//-------------------------------------------------------------
			
			//Software Labor Rates--------------
			var cost_per_Person-Month;
			
			//----------------------------------------------------------------
			//1.計算B
			var B = 1.01 + 0.01 *(pecedentednes + architecture_risk_Resolution + development_Flexibility +team_Cohesion + process_Maturity);		}
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
				<div id="searchform" action="#">
					<input type="text" langtag="top-search" value="搜尋..." name="s" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)"/>
					<input type="submit" id="searchsubmit" value=" " />			
				</div>      
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
						<a href="/member/basic.jsp?id=123">
                        <img src="/images/user.png" alt="Image" width="24" height="24">
                        <h2 langtag="profile-basic"></h2>                        
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
						<a id="newteam_btn" href="#">
                        <img src="/images/task_group.png" alt="Image" width="24" height="24">
                        <h2 langtag="top-team-new"></h2>                        
						</a>
                    </div>									                 	
</div>	
				<li>
					<a class="float_r" href="/index.jsp"><img class="top" src="/images/top_home.png" />
					<label langtag="top-home"></label></a>
				</li>										
				
				
						
            </ul>    	
        </div> 



		<input type="hidden" id="projectId" value="<%= request.getParameter("id")%>" />
        <div id="templatemo_main">
            
          <div class="col_w900 hr_divider">
          		
      			<div class="col_w170 lp_box float_l">
				<div class="subTopDiv" >
						<h2 class="uiHeaderTitle">專案資料</h2></div>	
					
					<div class="col_allw170 frontpage_box hoverdiv">
					<a href="/project/detail.jsp?id=<%= request.getParameter("id")%>">
						<img src="/images/project_info.png" alt="Image" width="24" height="24">
						<h2>專案資訊</h2>
					</a> 
                    </div>            
					<div class="col_allw170 frontpage_box hoverdiv">
					<a href="/project/listMember.jsp?id=<%= request.getParameter("id")%>">
						<img src="/images/task_group.png" alt="Image" width="24" height="24">
						<h2>專案人員</h2>
					</a> 
                    </div>   					       
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/project/listTask.jsp?id=<%= request.getParameter("id")%>">
						<img src="/images/project_task.png" alt="Image" width="24" height="24">
						<h2>專案任務</h2>
                    </a>
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/project/wbs.html">
                      <img src="/images/project_chart.png" alt="Image" width="24" height="24">
                      <h2>WBS</h2>
					</a>
                    </div>     
					
					
                  <div class="frontpage_box col_allw170  hoverdiv">
				  <a href="/team/listProject.jsp?id=<%= request.getParameter("id")%>">
                      <img src="/images/profile_task.png" alt="Image" width="24" height="24">
                    <h2>專案估算系統</h2>
					</a>
                  </div>    
				                             
                <div class="subBottomDiv" ></div>     
            	</div>      
				<div id="dropBox" class="toggler col_w700 lp_box float_l margin_20rl">		
				<div class="subTopDiv" >
				<!-- InstanceBeginEditable name="PageTitle" -->
				<h2 class="uiHeaderTitle"><span id="teamNameArea"></span><img class="arrow_right" src="/images/arrow_right.png" />COCOMO II 估算</h2>	
				<!-- InstanceEndEditable -->
				</div>
                <!-- InstanceBeginEditable name="RightArea" -->
				
				<div style="padding:20px;">
				
<form name="f1" method="post">
<h3>Software Size - Sizing Method 
		<select name="size_type" onchange="f1.submit()">
				
				<option value="SLOC" selected="">Source Lines of Code</option>
				
				<option value="Function Points">Function Points</option>
				
		</select>

<br>
</h3>
<div style="padding:20px;border-radius: 10px;-moz-border-radius: 10px;-webkit-border-radius: 10px;border-color:transparent;background-color:#D3E4E5;">
<table style="width: 100%; text-align: left; border-color:transparent;"
border=" 1"="" cellpadding="1" cellspacing="0"><tbody><tr><td style="width: 50px; vertical-align: top;"><br>

<table style="width: 60%; text-align: left;" border="0" cellpadding="2" cellspacing="2">

<tbody>

<tr>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top; text-align: center;"><a href="http://sunset.usc.edu/research/COCOMOII/expert_cocomo/sloc.html">SLOC</a></td>

<td style="vertical-align: top; text-align: center;"><font color="#000000"><i>&nbsp;</i>% Design Modified</font></td>

<td style="vertical-align: top; text-align: center;"><font color="#000000">% Code Modified</font></td>

<td style="vertical-align: top; text-align: center;"><font color="#000000">% Integration Required</font></td>

</tr>

<tr>

<td style="vertical-align: top;">New<br>

</td>

<td style="vertical-align: top;"><input type="text" name="new_size" size="8" maxlength="8" align="right" value=""> <br>

</td>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top;"><br>
		
</td>

</tr>

<tr>

<td style="vertical-align: top;">Reused<br>

</td>

<td style="vertical-align: top;"><input type="text" name="reused_size" size="8" maxlength="8" align="right" value=""> <br>

</td>

<td style="vertical-align: top;"><center><input name="DM_reused" size="6" align="right" value="0" disabled=""></center>

</td>

<td style="vertical-align: top;"><center><input name="CM_reused" size="6" align="right" value="0" disabled=""></center>

</td>

<td style="vertical-align: top;"><center><input type="text" name="IM_reused" size="6" maxlength="6" align="right" value=""> <br></center>
		
</td>

</tr>

<tr>

<td style="vertical-align: top;">Modified<br>

</td>

<td style="vertical-align: top;"><input type="text" name="modified_size" size="8" maxlength="8" align="right" value=""> <br>

</td>

<td style="vertical-align: top;"><center>

<input type="text" name="DM_modified" size="6" maxlength="6" align="right" value=""> <br>

</center>

</td>

<td style="vertical-align: top;"><center>

<input type="text" name="CM_modified" size="6" maxlength="6" align="right" value=""> <br>

</center>

</td>

<td style="vertical-align: top;"><center>
		
		<input type="text" name="IM_modified" size="6" maxlength="6" align="right" value=""> <br>
		
		</center>
		
</td>

</tr>

</tbody>

</table>
<br />
<br />

<table style="width: 60%; text-align: left;" border="0" cellpadding="2" cellspacing="2">

<tbody>

<tr>

<td style="vertical-align: top;"><br>
		
</td>

<td style="vertical-align: top; text-align: center;"><font color="#000000">Assessment and Assimilation <br>
		
		(0%
		
		- 8%)</font></td>

<td style="vertical-align: top; text-align: center;"><font color="#000000">&nbsp;Software Understanding <br>

(0% - 50%)</font></td>

<td style="vertical-align: top; text-align: center;">

<center><font color="#000000">Unfamiliarity</font> <br>

<font color="#000000">(0-1)</font></center>

</td>

</tr>

<tr>

<td style="vertical-align: top;">New<br>
		
</td>

<td style="vertical-align: top;"><br>
		
</td>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top;"><br>

</td>

</tr>

<tr>

<td style="vertical-align: top;">Reused<br>
		
</td>

<td style="vertical-align: top;"><center>
		
		<input type="text" name="AA_reused" size="6" maxlength="6" align="right" value=""> <br>
		
		</center>
		
</td>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top;"><br>

</td>

</tr>

<tr>

<td style="vertical-align: top;">Modified<br>
		
</td>

<td style="vertical-align: top;"><center>
		
		<input type="text" name="AA_modified" size="6" maxlength="6" align="right" value=""> <br>
		
		</center>
		
</td>

<td style="vertical-align: top;"><center>

<input type="text" name="SU_modified" size="6" maxlength="6" align="right" value=""> <br>

</center>

</td>

<td style="vertical-align: top;"><center>

<input type="text" name="UNFM_modified" size="6" maxlength="6" align="right" value=""> <br>

</center>

</td>

</tr>

</tbody>

</table>



<br></td>


<td style="text-align: left; vertical-align: top;"></td>
</tr></tbody></table>
</div>
<br />

<div class="divider10"></div>

<h3>&nbsp;Software Scale Drivers </h3>


<div style="padding:20px;border-radius: 10px;-moz-border-radius: 10px;-webkit-border-radius: 10px;border-color:transparent;background-color:#D3E4E5;">
<table border="0" style="border-color:transparent;"><tbody><tr valign="top">

<td>

  <table><tbody ><tr>

  <td align="left">Precedentedness</td>

  <td><select name="prec">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

  </tr><tr>

  <td align="left">Development Flexibility</td>

  <td><select name="flex">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

  </tr>

<tr>

  <td><br>
  <b>Software Cost Drivers</b></td>
  <td></td>
  </tr>

  <tr>

  <td><b>Product</b></td> 
  <td></td>
  </tr>

<tr>

<td align="left">Required Software Reliability</td>

<td>

<select name="rely">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Data Base Size</td>

<td>

<select name="data">

  <option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Product Complexity</td>

<td>

<select name="cplx">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select>

</td>

</tr>

<tr>

<td align="left">Developed for Reusability</td>

<td>

<select name="ruse">

  <option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select>

</td>

</tr><tr>

<td align="left">Documentation Match to Lifecycle Needs</td>

<td>

<select name="docu">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>





     </tbody></table>

</td>

<td>

  <table border="0"><tbody><tr>

    <td align="left">Architecture / Risk Resolution</td>

  <td><select name="resl">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>  </tr>

    <tr><td align="left">Team Cohesion</td>

   <td><select name="team">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

  </tr>



<tr>

</tr><tr>

  <td><br><b>Personnel</b></td>
	<td></td>
  </tr>

<tr>

<td align="left">Analyst Capability</td>

<td>

<select name="acap">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Programmer Capability</td>

<td>

<select name="pcap">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Personnel Continuity</td>

<td>

<select name="pcon">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Application Experience</td>

<td>

<select name="apex">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Platform Experience</td>

<td>

<select name="pexp">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Language and Toolset Experience</td>

<td>

<select name="ltex">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>



    </tbody></table>

</td>

</tr>
<tr>
<td>

  <table border="0"><tbody><tr>

    <td align="left">Process Maturity</td>

   <td><select name="pmat">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>  </tr>

  <tr>

    <td>&nbsp;</td>
<td>&nbsp;</td>
  </tr>

  <tr>

  </tr><tr>

  <td><b>&nbsp;</b></td>
<td><b>&nbsp;</b></td>
  </tr>

<tr>

</tr><tr>

    <td><br><b>Platform</b></td>
<td><b>&nbsp;</b></td>
  </tr>

<tr>

<td align="left">Time Constraint</td>

<td>

<select name="time">

  <option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select>

</td>

</tr>



<tr>

<td align="left">Storage Constraint</td>

<td>

<select name="stor">

  <option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select>

</td>

</tr>



<tr>

<td align="left">Platform Volatility</td>

<td>

<select name="pvol">

  <option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

   <tr>

    <td><br><b>Project</b></td>
	<td><b>&nbsp;</b></td>
  </tr>

<tr>

<td align="left">Use of Software Tools</td>

<td>

<select name="tool">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Multisite Development</td>

<td>

<select name="site">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

</tr>

<tr><td align="left">Required Development Schedule</td>

<td>

<select name="sced">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select></td>

</tr>

      </tbody></table>

</td>
</tr>
</tbody></table></div><br />

<div class="divider10"></div>

<div style="padding:20px;border:#000000; border-radius: 10px;-moz-border-radius: 10px;-webkit-border-radius: 10px; border-color:transparent;background-color:#D3E4E5;">
	<h3>Software Labor Rates</h3><br>
	Cost per Person-Month (Dollars)  <input type="text" name="software_labor_cost_per_PM" size="8" maxlength="8" align="right" value=""> <button>進行估算</button>
</div>

</form>
				
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