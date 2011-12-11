<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Main2.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
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

<!--colorbox-->
<script type="text/javascript" src="/js/colorbox/jquery.colorbox-min.js"></script>
<link rel="stylesheet" type="text/css" href="/js/colorbox/colorbox.css" media="screen" />

<script type="text/javascript">
var i = 0;
	$(document).ready(function(){
		
		
		$(".ajax").colorbox(); 
		$(".iframe").colorbox({iframe:true, width:"100%", height:"100%"}); 
		$( "button" ).button();
		
		
		
		// 測試
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
		
		// 點團隊s按鈕
		
		$( "#teams_btn" ).toggle(
			function () { 
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-teams" ).slideToggle(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-teams" ).slideToggle(250);
			}
		);
		// 點帳號按鈕
		$( "#account_btn" ).toggle(
			function () { 
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-account" ).slideToggle(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-account" ).slideToggle(250);
			}
		);
		
		// 點團隊按鈕
		$( "#team_btn" ).toggle(
			function () { 
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-team" ).slideToggle(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-team" ).slideToggle(250);
			}
		);
		
		// 點信箱按鈕
		$( "#mail_btn" ).toggle(
			function () { 
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-mail" ).slideToggle(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-mail" ).slideToggle(250);
			}
		);
		
		// 點訊息按鈕
		$( "#message_btn" ).toggle(
			function () { 
				$( this ).addClass("menu_li_toogle");
				$( "#div-float-message" ).slideToggle(250);
			},		
			function () {
				$( this ).removeClass("menu_li_toogle");
				$( "#div-float-message" ).slideToggle(250);
			}
		);						


		
	});

</script>

<!-- InstanceBeginEditable name="Head" -->


<script language="JavaScript" type="text/javascript">
	/*
	 * 一開始讀取第零筆資料
	 */
	$(document).ready(function(){
		
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
					<div style="margin-left:20px;margin-top:10px;"><name>組員加入</name></div>
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
					<div style="margin-left:20px;margin-top:10px;"><name>站內信通知</name></div>
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
					<div style="margin-left:20px;margin-top:10px;"><name>訊息通知</name></div>
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
					<input type="text" value="搜尋..." name="s" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)">
						<input type="submit" id="searchsubmit" value=" " />
				</form>      
                </li>
				<li>

				<a  id="account_btn" class="float_r" href="#"><img class="top" src="/images/top_profile.png" /><label>個人 ▼ </label></a>
				<!--<div id="circles" style="text-align:left; background-color:rgba(199, 199, 199, 0.7); width:120px; overflow:auto; position:absolute; padding:50px; max-height:60px;">
        		</div>-->

				
				</li>
<div id="div-float-account">
					<div style="margin-left:20px;margin-top:10px;">個人功能</div>
					<div class="divider10"></div> <!--分隔線-->
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a href="/member/task.jsp?id=123">
						<img src="/images/task.png" alt="Image" width="24" height="24" />
						<h2>目前工作</h2>
						</a>
                    </div>   
                    <div class="col_allw170 frontpage_box hoverdiv">
						<a href="/member/mail.jsp?id=123">
                        <img src="/images/mail.png" alt="Image" width="24" height="24">
                        <h2>我的信箱</h2>                        
						</a>
                    </div>					  
                  <div class="col_allw170 frontpage_box hoverdiv">
                      <img src="/images/profile_task.png" alt="Image" width="24" height="24">
                    <h2>使用說明</h2>
                  </div>  
                  <div class="col_allw170 frontpage_box hoverdiv">
                      <img src="/images/logout.png" alt="Image" width="24" height="24">
                    <h2>登出</h2>
                  </div>                    	
</div>	

			
				<li>
					<a id="teams_btn" class="float_r" href="/member/basic.jsp"><img class="top" src="/images/top_account.png" />
					<label>團隊 ▼ </label></a>
				</li>	
<div id="div-float-teams">
					<div style="margin-left:20px;margin-top:10px;">我的團隊</div>
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
					<label>首頁</label></a>
				</li>										
				
				
						
            </ul>    	
        </div> 


<!-- InstanceBeginEditable name="Content" -->

        <div id="templatemo_main">
            
          <div class="col_w900 hr_divider">
          		
      			<div class="col_w170 lp_box float_l">
				<div class="subTopDiv" ><h2 class="uiHeaderTitle">團隊資料</h2></div>	
					
					<div class="col_allw170 frontpage_box hoverdiv">
					<a href="/team/detail.jsp">
						<img src="/images/project_info.png" alt="Image" width="24" height="24">
						<h2>團隊資訊</h2>
					</a> 
                    </div>            
					<div class="col_allw170 frontpage_box hoverdiv">
					<a href="/team/listMember.jsp">
						<img src="/images/task_group.png" alt="Image" width="24" height="24">
						<h2>成員名單</h2>
					</a> 
                    </div>   					       
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/project/listTask.jsp">
						<img src="/images/project_task.png" alt="Image" width="24" height="24">
						<h2>開發專案</h2>
                    </a>
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/project/listTask.jsp">
                      <img src="/images/project_chart.png" alt="Image" width="24" height="24">
                      <h2>查詢進度</h2>
					</a>
                    </div>     
					
					
                  <div class="frontpage_box col_allw170  hoverdiv">
				  <a href="/project/listTask.jsp">
                      <img src="/images/profile_task.png" alt="Image" width="24" height="24">
                    <h2>專案估算系統</h2>
					</a>
                  </div>    
				                             
                <div class="subBottomDiv" ></div>     
            	</div>      
				<div id="dropBox" class="toggler col_w700 lp_box float_l margin_20rl">		
				<div class="subTopDiv" >
				<!-- TemplateBeginEditable name="PageTitle" -->PageTitle<!-- TemplateEndEditable -->
				</div>
                <!-- TemplateBeginEditable name="RightArea" -->RightArea<!-- TemplateEndEditable -->
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
<!-- InstanceEndEditable -->
       
    	
  </div>
</div>




<div id="templatemo_footer_wrapper">
    <div id="templatemo_footer">
    	
		<a href="index.html">首頁</a> | <a href="about.html">關於我們</a> | <a href="blog.html">文章列表</a> | <a href="gallery.html">Gallery</a> | <a href="contact.html" class="last">Contact</a> <br /><br />
        
        Copyright © 2011 Project+ | 最佳的專案追蹤與估算工具
    
  </div> <!-- end of templatemo_footer -->
</div>

</body>
<!-- InstanceEnd --></html>