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

		function conver(str) {
			if(str=="Very_Low"){
				return 0;
			}
			else if(str=="Low"){
				return 1;
			}
			else if(str=="Nominal"){
				return 2;
			}
			else if(str=="High"){
				return 3;
			}
			else if(str=="Very_High"){
				return 4;
			}
			else if(str=="Extra_High"){
				return 5;
			}
		}

	/*
	 * 一開始讀取第零筆資料
	 */
	$(document).ready(function(){
		
		$("table").attr('style','border:none;');
		$( "#dialog" ).dialog( {autoOpen: false, minWidth: 350, minHeight: 150, modal: true} );
		
		// 取得該取得的資料直
		// Soft Cost Drivers
		var precedentedness = $("#precedentedness").val();
		var flexibility = $("#flexibility").val();
		var architecture = $("#architecture").val();
		var cohesion = $("#cohesion").val();
		var maturity = $("#maturity").val();
		
		// Product
		var reliability = $("#reliability").val();
		var database = $("#database").val();
		var complexity = $("#complexity").val();
		var reusability = $("#reusability").val();
		var docu = $("#docu").val(); // documentation match to lifecycle needs
		var resl = $("#resl").val(); // Architecture / Risk Resolution
		var team = $("#team").val(); // Team Cohesion
		
		// Personnel
		var acap = $("#acap").val(); // Analyst Capablility
		var pcap = $("#pcap").val(); // Programmer Capability
		var pcon = $("#pcon").val(); // Personnel Continuity
		var apex = $("#apex").val(); // Application Experience
		var pexp = $("#pexp").val(); // Platform Experience
		var ltex = $("#ltex").val(); // Language and Toolset Experience
		var pmat = $("#pmat").val(); // Process Maturity
		
		
		// Platform
		var time = $("#time").val(); // Time Constraint
		var stor = $("#stor").val(); // Storage Constraint
		var pvol = $("#pvol").val(); // Platform Volatility
		
		// Project		
		var tool = $("#tool").val(); // Use of Software Tools
		var site = $("#site").val(); // Multisite Development
		var sced = $("#sced").val(); // Required Development Schedule
	
	
		// 各項權重
	
		// Scale Factors
		var Precedentedness = [4.05, 3.24, 2.43, 1.62, 0.81, 0.00];
		var DevelopmentFlexibilit = [6.07, 4.86, 3.64, 2.43, 1.21, 0.00];
		var ArchitectureRiskResolution = [4.22, 3.38, 2.53, 1.69, 0.84, 0.00];
		var TeamCohesion =  [4.94, 3.95, 2.97, 1.98, 0.99, 0.00];
		var ProcessMaturity = [4.54, 3.64, 2.73, 1.82, 0.91, 0.00];
		
		// Cost Drivers
		var RELY = [0.75, 0.88, 1.00, 1.15, 1.39, 0.0];
		var DATA = [0.0, 0.93, 1.00, 1.09, 1.19, 0.0];
		var CPLX = [0.75, 0.88, 1.00, 1.15, 1.30, 1.66];
		var RUSE = [0.0, 0.91, 1.00, 1.14, 1.29, 1.49];
		var DOCU = [0.89, 0.95, 1.00, 1.06, 1.13, 0];
		var TIME = [0, 0, 1.00, 1.11, 1.31, 1.67];
		var STOR = [0, 0, 1.00, 1.11, 1.06, 1.57];
		var PVOL = [0, 0.87, 1.00, 1.15, 1.30, 0];
		var ACAP = [1.50, 1.22, 1.00, 0.83, 0.67, 0];
		var PCAP = [1.37, 1.16, 1.00, 0.87, 0.74, 0];
		var PCON = [1.24, 1.10, 1.00, 0.92, 0.84, 0];
		var AEXP = [1.22, 1.10, 1.00, 0.89, 0.81, 0];
		var PEXP = [1.25, 1.12, 1.00, 0.88, 0.81, 0];
		var LTEX = [1.22, 1.10, 1.00, 0.91, 0.84, 0];
		var TOOL = [1.24, 1.12, 1.00, 0.86, 0.72, 0];
		var SITE = [1.25, 1.10, 1.00, 0.92, 0.84, 0.78];
		var SCED = [1.29, 1.10, 1.00, 1.00, 1.00, 0];
		
		//alert(Precedentedness[conver($("#precedentedness").val())]);
		
		function cal_COCOMOII()
		{
			//目前寫入的值是測試用的資料,之後請對應實際的按鈕或輸入框取得的數值!!!!
			
			//UFP and Language-----------------------------未調整功能點值 與 選擇的程式語言類型所對應的SLOC
			var UFP = $("#UFP").val();
			var source__line_of_code_languageType = 128;   // C: 128 ,c++:29
			// Software Scale Drivers--------------------為權重值
			var pecedentednes = Precedentedness[conver(precedentedness)] ;
			var architecture_risk_Resolution = ArchitectureRiskResolution[conver(architecture)];
			var development_Flexibility = DevelopmentFlexibilit[conver(flexibility)];
			var team_Cohesion = TeamCohesion[conver(cohesion)];
			var process_Maturity = ProcessMaturity[conver(maturity)];
			
			//Software Cost Drivers --------------------------------------為權重值
			//Product======================
			var required_Software_Reliability = RELY[conver(reliability)];
			var data_Base_Size = DATA[conver(database)];
			var product_Complexity = CPLX[conver(complexity)];
			var developed_for_Reusability = RUSE[conver(reusability)];
			var documentation_Match_to_Lifecycle_Needs = DOCU[conver(docu)];
			
			//Personnel======================
			var analyst_Capability = ACAP[conver(acap)];
			var programmer_Capability = PCAP[conver(pcap)];
			var personnel_Continuity = PCON[conver(pcon)];
			var application_Experience = AEXP[conver(apex)];
			var platform_Experience = PEXP[conver(pexp)];
			var language_and_Toolset_Experience = LTEX[conver(ltex)];
			
			//Platform======================
			var time_Constraint = TIME[conver(time)];
			var storage_Constraint = STOR[conver(stor)];
			var platform_Volatility = PVOL[conver(pvol)];
			
			//Project======================
			var use_of_Software_Tools = TOOL[conver(tool)];	
			var multisite_Development = SITE[conver(site)];
			var required_Development_Schedule = SCED[conver(sced)];
			//-------------------------------------------------------------
			
			//Software Labor Rates--------------
			var cost_per_Person_Month = +$("#PM").val();
			//----------------------------------------------------------------
			//1.計算B
			var B = 1.01 + 0.01 *(pecedentednes + architecture_risk_Resolution + development_Flexibility +team_Cohesion + process_Maturity);
			$("#result_B").val(B);
			
			//2.計算透過為調整功能點所轉換的程式語言行數 
			var size = UFP * source__line_of_code_languageType; 
			$("#result_size").val(size);
			
			//3.計算人月
			var effort_PM = 2.94 + Math.pow(UFP,B) +  (required_Software_Reliability * data_Base_Size * product_Complexity * developed_for_Reusability * documentation_Match_to_Lifecycle_Needs * analyst_Capability * programmer_Capability * personnel_Continuity * application_Experience * platform_Experience * language_and_Toolset_Experience  * time_Constraint * storage_Constraint * platform_Volatility * use_of_Software_Tools * multisite_Development * required_Development_Schedule)
			$("#result_effort").val(effort_PM);
			
			//4.計算花費		
			var cost = effort_PM * cost_per_Person_Month;
			$("#result_cose").val(cost);
		}
		
		// 計算按鈕
		$("#caculate").click(function(){
			cal_COCOMOII();
			$("#dialog").dialog('open');
		});
		
		$('#cancel').click(function(){
			$("#dialog").dialog('close');		
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
				

<h3>Cocomo II - 
		
<br>
</h3>
<div style="padding:20px;border-radius: 10px;-moz-border-radius: 10px;-webkit-border-radius: 10px;border-color:transparent;background-color:#D3E4E5;">

<table style="width: 100%; text-align: left; 
border=" 1"="" cellpadding="1" cellspacing="0"><tbody><tr><td style="width: 101px; vertical-align: top;"><table border="0">

  <tbody><tr><td align="right">Unadjusted Function Points</td>

  <td> <input id="UFP" type="text" name="function_points" size="8" maxlength="8" value="10">  </td>

  <td align="right">Language</td>

  <td><select name="language">

  <option>Basic</option><option selected="">C</option><option>Database - Default</option><option>Java</option><option>PERL</option><option>3rd Generation Language</option></select></td>

</tr></tbody></table>

<br></td><td style="text-align: left; vertical-align: top;"></td>
</tr></tbody></table>


</div>
<br />

<div class="divider10"></div>

<h3>&nbsp;</h3>


<div style="padding:20px;border-radius: 10px;-moz-border-radius: 10px;-webkit-border-radius: 10px;border-color:transparent;background-color:#D3E4E5;">
<table border="0"><tbody><tr valign="top">

<td>

  <table border="0"><tbody>

<tr>

  <td>
  <h4>Software Scale Drivers</h4></td>
  </tr>
<tr>

  <td align="left">Precedentedness</td>

  <td><select id="precedentedness" name="prec">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

  </tr><tr>

  <td align="left">Development Flexibility</td>

  <td><select id="flexibility" name="flex">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

  </tr>
  
  
<tr>

    <td align="left">Architecture / Risk Resolution</td>

  <td><select id="architecture" name="resl">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>  </tr>
  
    
  
  <tr>
<tr><td align="left">Team Cohesion</td>

   <td><select id="cohesion" name="team">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

  </tr>
  
<tr>

    <td align="left">Process Maturity</td>

   <td><select id="maturity" name="pmat">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>  </tr>  



  <td><h4>Software Cost Drivers</h4>
  				<h4>Product</h4></td>

  </tr>

<tr>

<td align="left">Required Software Reliability</td>

<td>

<select id="reliability" name="rely">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Data Base Size</td>

<td>

<select id="database" name="data">

  <option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

<td align="left">Product Complexity</td>

<td>

<select id="complexity" name="cplx">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select>

</td>

</tr>

<tr>

<td align="left">Developed for Reusability</td>

<td>

<select id="reusability" name="ruse">

  <option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select>

</td>

</tr><tr>

<td align="left">Documentation Match to Lifecycle Needs</td>

<td>

<select id="docu" name="docu">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>

</td>

</tr>

<tr>

    <td align="left">Architecture / Risk Resolution</td>

  <td><select id="resl" name="resl">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>  </tr>

    <tr><td align="left">Team Cohesion</td>

   <td><select id="team" name="team">

  <option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>

  </tr>


    </table>

</td>

<td>
		
		<table border="0"><tbody>
				
				
		<tr>
				
		</tr><tr>
				
				<td><br><h4>Personnel</h4></td>
				
				</tr>
				
		<tr>
				
		<td align="left">Analyst Capability</td>
				
		<td>
				
		<select id="acap" name="acap">
				
				<option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>
				
		</td>
				
		</tr>
				
		<tr>
				
		<td align="left">Programmer Capability</td>
				
		<td>
				
		<select id="pcap" name="pcap">
				
				<option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>
				
		</td>
				
		</tr>
				
		<tr>
				
		<td align="left">Personnel Continuity</td>
				
		<td>
				
		<select id="pcon" name="pcon">
				
				<option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>
				
		</td>
				
		</tr>
				
		<tr>
				
		<td align="left">Application Experience</td>
				
		<td>
				
		<select id="apex" name="apex">
				
				<option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>
				
		</td>
				
		</tr>
				
		<tr>
				
		<td align="left">Platform Experience</td>
				
		<td>
				
		<select id="pexp" name="pexp">
				
				<option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>
				
		</td>
				
		</tr>
				
		<tr>
				
		<td align="left">Language and Toolset Experience</td>
				
		<td>
				
		<select id="ltex" name="ltex">
				
				<option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option></select>
				
		</td>
				
		</tr>
		<tr>
				
				<td align="left">Process Maturity</td>
				
				<td><select id="pmat" name="pmat">
						
						<option value="Very_Low">Very Low</option><option value="Low">Low</option><option value="Nominal" selected="">Nominal</option><option value="High">High</option><option value="Very_High">Very High</option><option value="Extra_High">Extra High</option></select></td>  </tr>
				
				
				
				</tbody></table>
		
</td>

</tr>

</tbody></table>
</td>

</tr>
<tr>
<td>

  
</td>
</tr>
</tbody></table>
<table border="0">
		<tbody>
				<tr valign="top">
						<td><table border="0">
								<tbody>
										<tr></tr>
										<tr>
												<td><br />
														<h4>Platform</h4></td>
										</tr>
										<tr>
												<td align="left">Time Constraint</td>
												<td><select id="time" name="time">
														<option value="Nominal" selected="selected">Nominal</option>
														<option value="High">High</option>
														<option value="Very_High">Very High</option>
														<option value="Extra_High">Extra High</option>
												</select></td>
										</tr>
										<tr>
												<td align="left">Storage Constraint</td>
												<td><select id="stor" name="stor">
														<option value="Nominal" selected="selected">Nominal</option>
														<option value="High">High</option>
														<option value="Very_High">Very High</option>
														<option value="Extra_High">Extra High</option>
												</select></td>
										</tr>
										<tr>
												<td align="left">Platform Volatility</td>
												<td><select id="pvol" name="pvol">
														<option value="Low">Low</option>
														<option value="Nominal" selected="selected">Nominal</option>
														<option value="High">High</option>
														<option value="Very_High">Very High</option>
												</select></td>
										</tr>
										<tr>
												<td><br />
														<h4>Project</h4></td>
										</tr>
										<tr>
												<td align="left">Use of Software Tools</td>
												<td><select id="tool" name="tool">
														<option value="Very_Low">Very Low</option>
														<option value="Low">Low</option>
														<option value="Nominal" selected="selected">Nominal</option>
														<option value="High">High</option>
														<option value="Very_High">Very High</option>
												</select></td>
										</tr>
										<tr>
												<td align="left">Multisite Development</td>
												<td><select id="site" name="site">
														<option value="Very_Low">Very Low</option>
														<option value="Low">Low</option>
														<option value="Nominal" selected="selected">Nominal</option>
														<option value="High">High</option>
														<option value="Very_High">Very High</option>
														<option value="Extra_High">Extra High</option>
												</select></td>
										</tr>
										<tr>
												<td align="left">Required Development Schedule</td>
												<td><select id="sced" name="sced">
														<option value="Very_Low">Very Low</option>
														<option value="Low">Low</option>
														<option value="Nominal" selected="selected">Nominal</option>
														<option value="High">High</option>
														<option value="Very_High">Very High</option>
												</select></td>
										</tr>
								</tbody>
						</table></td>
				</tr>
		</tbody>
</table>
</div><br />

<div class="divider10"></div>

<div style="padding:20px;border:#000000; border-radius: 10px;-moz-border-radius: 10px;-webkit-border-radius: 10px; border-color:transparent;background-color:#D3E4E5;">
	<h3>Software Labor Rates</h3><br>
	Cost per Person-Month (Dollars)  <input id="PM" type="text" name="software_labor_cost_per_PM" size="8" maxlength="8" align="right" value=""> <button id="caculate" >進行估算</button>
</div>

				
</div>				
			
			
			
				<div id="dialog" title="估算結果">
					<p>你所<team>估算</team>的結果</p>
						<table summary="站內信箱" width="100%">

							<thead>
							<tr>
								<th scope="col">項目</th>
								<th scope="col">結果</th>
							</tr>
							</thead>
							<tbody>
                            	<tr class="odd">
									<td>B</td>
									<td><input id="result_B" type="text" disabled="disabled"/></td>									
								</tr>
                                <tr>									
									<td>大小</td>
									<td><input id="result_size" type="text" disabled="disabled"/></td>									
								</tr>	
                                <tr class="odd">									
									<td>人月</td>
									<td><input id="result_effort" type="text" disabled="disabled"/></td>									
								</tr>		
								<tr>
									<td>花費</td>
									<td><input id="result_cose" type="text" disabled="disabled"/></td>									
								</tr>																																						
							</tbody>
						</table>			

								
					<div class="divider"></div>
					<div style="text-align:right;">
						<button id="cancel">關閉</button>
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