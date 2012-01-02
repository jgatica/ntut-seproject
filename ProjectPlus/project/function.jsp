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
		$( "#uiradio" ).buttonset();
		$( "#uiradio2" ).buttonset();
		$( "#uiradio3" ).buttonset();
		$( "#uiradio4" ).buttonset();
		$( "#uiradio5" ).buttonset();
		
		//var data = $("label[value*="+ name +"]");
		function cal_function_point()
		{
			var data = $("input[checked^=checked]");
			/*var size = data.length,index;
			for(index = 0; index < size; index++)
			{
				console.log(data[index].id);
				console.log($("label[for="+ data[index].id +"]").text());
			}*/
			//-------------------------------------------------------will Cal Unadjusted Function Point
			// Measurement Parameter Count 之後請與各個cot2對應!!!!
			var EI = $("#EI").val(); //External Input File => number_of_user_inputs
			var EO = $("#EO").val(); //External Output File => number_of_outputs
			var EQ = $("#EQ").val(); //external Inquire File => number_of_inquires
			var ILF = $("#ILF").val(); // Internal Logical File => number_of_files
			var EIF = $("#EIF").val(); //External Logical File => number_of_external_interface
			
			
			//Weighting Factor  之後請與按鈕對應 !!!
			var EI_WF = $("label[for="+ data[0].id +"]").text();
			var EO_WF = $("label[for="+ data[1].id +"]").text();
			var EQ_WF = $("label[for="+ data[2].id +"]").text(); 
			var ILF_WF =$("label[for="+ data[3].id +"]").text();
			var EIF_WF =$("label[for="+ data[4].id +"]").text();
			
			//--------------------------------------------------------will Cal value adjustment factor
			//The ratings parameter is between 0 - 5 之後請對應輸入的位置!!!
			var f1 = $("#F1").val(); // Does the system require reliable backup and recovery?
			var f2 = $("#F2").val(); // Are data communications required?
			var f3 = $("#F3").val();; //Are there distributed processing functions?
			var f4 = $("#F4").val();; // Is performance critical?
			var f5 = $("#F5").val();; // Will the system run in a existing, heavily utilized operational environment?
			var f6 = $("#F6").val();; //Does the system require on-line data entry?
			var f7 = $("#F7").val();; // Does the on-line data entry require the input transaction to be built over multiple screens or operations?
			var f8 = $("#F8").val();; // Are the master files updated on-line?
			var f9 = $("#F9").val();; //Are the inputs, outputs, files or inquiries complex?
			var f10 =$("#F10").val();;//Is the internal processing complex?
			var f11 = $("#F11").val();;//Is the code designed to be reusable?
			var f12 = $("#F12").val();;//Are conversion and installation included in the design?
			var f13 = $("#F13").val();;//Is the system designed for multiple installations in different organizations?
			var f14 = $("#F14").val();;// Is the application designed to facilitate change and ease of use by the user?
			//-------------------------------------------------------
			//1.先計算未調整功能點UDP
			var UDF = ( EI *  EI_WF) + ( EIF * EIF_WF) +  ( ILF * ILF_WF) + ( EO * EO_WF) + ( EQ *  EQ_WF) ; 
			//console.log(UDF);
			//2.再計算數值調整因子VAF 透過14個通用系統特性GSC’s
			var VAF = 0.65 +  (  f1 +   f2 +   f3 +   f4 +   f5 +   f6 +   f7 +   f8 +   f9 +  f10 +  f11+  f12 +f13 +f14) /100;
			//console.log(VAF);
			//3.Function points(FP) = UAF *VAF
			var FP = parseInt(UDF * VAF);
			console.log('FP = %d,VAF=%d,UDF=%d',FP,VAF,UDF); //會出現91 ok 
			
		}
		cal_function_point();
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
					<a href="/example.html">
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
				<style>
					.radioButton{
						width: 40px;
					}
				</style>
				<div style="padding:0px 20px 0px 20px;">
				<ul class="" style="padding:10px ;list-style-type:none; 
												border-radius: 10px;
												-moz-border-radius: 10px;
												-webkit-border-radius: 10px;
												border-color:transparent;
												background-color:#D3E4E5;
												">
					<li>
						<input id="EI" type="text" style="width: 20px;" value="6"/>   *   
							<span id="uiradio">
								<input type="radio" id="radio1" name="radio" /><label class="radioButton" for="radio1">3</label>
								<input type="radio" id="radio2" name="radio" checked="checked" /><label class="radioButton" for="radio2">4</label>
								<input type="radio" id="radio3" name="radio" /><label class="radioButton" for="radio3">6</label>
							</span>
							=  <input type="text" style="width: 30px; text-align:center;" value="20" disabled="disabled"/>
					</li>
					<li>
						<input id="EO" type="text" style="width: 20px;" value="5"/>   *   
							<span id="uiradio2">
								<input type="radio" id="radio4" name="radio2" /><label class="radioButton" for="radio4">4</label>
								<input type="radio" id="radio5" name="radio2" checked="checked" /><label class="radioButton" for="radio5">5</label>
								<input type="radio" id="radio6" name="radio2" /><label class="radioButton" for="radio6">7</label>
							</span>
							=  <input type="text" style="width: 30px; text-align:center;" value="20" disabled="disabled"/>
					</li>		
					<li>
						<input id="EQ" type="text" style="width: 20px;" value="3"/>   *   
							<span id="uiradio3">
								<input type="radio" id="radio7" name="radio3" /><label class="radioButton" for="radio7">7</label>
								<input type="radio" id="radio8" name="radio3" checked="checked" /><label class="radioButton" for="radio8">10</label>
								<input type="radio" id="radio9" name="radio3" /><label class="radioButton" for="radio9">15</label>
							</span>
							=  <input type="text" style="width: 30px; text-align:center;" value="20" disabled="disabled"/>
					</li>	
					<li>
						<input id="ILF" type="text" style="width: 20px;" value="2"/>   *   
							<span id="uiradio5">
								<input type="radio" id="radio13" name="radio5" /><label class="radioButton" for="radio13">3</label>
								<input type="radio" id="radio14" name="radio5" checked="checked" /><label class="radioButton" for="radio14">4</label>
								<input type="radio" id="radio15" name="radio5" /><label class="radioButton" for="radio15">6</label>
							</span>
							=  <input type="text" style="width: 30px; text-align:center;" value="20" disabled="disabled"/>
					</li>					
					<li>
						<input id="EIF" type="text" style="width: 20px;" value="1"/>   *   
							<span id="uiradio4">
								<input type="radio" id="radio10" name="radio4" /><label class="radioButton" for="radio10">5</label>
								<input type="radio" id="radio11" name="radio4" checked="checked" /><label class="radioButton" for="radio11">7</label>
								<input type="radio" id="radio12" name="radio4" /><label class="radioButton" for="radio12">10</label>
							</span>
							=  <input type="text" style="width: 30px; text-align:center;" value="20" disabled="disabled"/>
					</li>	
					<li style="margin: 20px; text-align: right;">
						<h3>Total : <input type="text" style="width: 70px; height:50px; text-align:center; font-size:25pt;" value="20" disabled="disabled"/></h3>
					</li>																		
				</ul>
</div>
<div style="text-align:center;  padding:20px;">				
<table border="0" width="100%" style="	
	border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-color:transparent;"
	> 
  <tbody>
  
  <tr>
    <td width="99%"><h4>Rate each factor (Fi, i=1 to14) on a scale of 0 to 5:</h4></td>
    <td></td>
  </tr>  
  <tr>
    <td width="89%">F1.&nbsp;&nbsp; Does the system require reliable backup and
      recovery?</td>
    <td width="11%" align="right"><input id="F1" name="F1" size="1" value="0">  </td>
  </tr>
  <tr>
    <td width="89%">F2.&nbsp;&nbsp; Are data communications required?</td>
    <td width="11%" align="right"><input id="F2" name="F1" size="1" value="1">  </td>
  </tr>
  <tr>
    <td width="89%">F3.&nbsp;&nbsp; Are there distributed processing functions?</td>
    <td width="11%" align="right"><input id="F3" name="F1" size="1" value="2">  </td>
  </tr>
  <tr>
    <td width="89%">F4.&nbsp;&nbsp; Is performance critical?</td>
    <td width="11%" align="right"><input id="F4" name="F1" size="1" value="3">  </td>
  </tr>
  <tr>
    <td width="89%">F5.&nbsp;&nbsp; Will the system run in a existing, heavily utilized
      operational environment?</td>
    <td width="11%" align="right"><input id="F5" name="F1" size="1" value="4">  </td>
  </tr>
  <tr>
    <td width="89%">F6.&nbsp;&nbsp; Does the system require on-line data entry?</td>
    <td width="11%" align="right"><input id="F6" name="F1" size="1" value="5">  </td>
  </tr>
  <tr>
    <td width="89%">F7.&nbsp;&nbsp; Does the on-line data entry require the input
      transaction to be built over multiple screens or operations?</td>
    <td width="11%" align="right"><input id="F7" name="F1" size="1" value="0">  </td>
  </tr>
  <tr>
    <td width="89%">F8.&nbsp;&nbsp; Are the master files updated on-line?</td>
    <td width="11%" align="right"><input id="F8" name="F1" size="1" value="1">  </td>
  </tr>
  <tr>
    <td width="89%">F9.&nbsp; Are the inputs, outputs, files or inquiries
      complex?</td>
    <td width="11%" align="right"><input id="F9" name="F1" size="1" value="2">  </td>
  </tr>
  <tr>
    <td width="89%">F10. Is the internal processing complex?</td>
    <td width="11%" align="right"><input id="F10" name="F1" size="1" value="3">  </td>
  </tr>
  <tr>
    <td width="89%">F11. Is the code designed to be reusable?</td>
    <td width="11%" align="right"><input id="F11" name="F1" size="1" value="4">  </td>
  </tr>
  <tr>
    <td width="89%">F12. Are conversion and installation included in the design?</td>
    <td width="11%" align="right"><input id="F12" name="F1" size="1" value="5">  </td>
  </tr>
  <tr>
    <td width="89%">F13. Is the system designed for multiple installations in
      different organizations?</td>
    <td width="11%" align="right"><input id="F13" name="F1" size="1" value="5">  </td>
  </tr>
  <tr>
    <td width="89%">F14. Is the application designed to facilitate change and
      ease of use by the user?</td>
    <td width="11%" align="right"><input id="F14" name="F1" size="1" value="4">  </td>
  </tr>
</tbody></table>
</div>
<div style="padding:0px 20px 0px 20px; margin-bottom: 20px;">
				<div class="" style="padding:10px;list-style-type:none; 
												border-radius: 10px;
												-moz-border-radius: 10px;
												-webkit-border-radius: 10px;
												border-color:transparent;
												background-color:#D3E4E5;">
<p><input type="button" value="Calculate" name="B1" onclick="checkDataEntry(); calculate()"> 
     <input type="reset" value="Reset" name="B2"></p>
<p><i><u><font size="4"><b>Result</b>.</font></u></i>&nbsp; According to the input your project has:&nbsp;
<input type="text" name="Result" disabled="" size="10" style="font-weight: bold; font-size: 14pt; font-family: Arial; border-style: inset">
</p>
</div>
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