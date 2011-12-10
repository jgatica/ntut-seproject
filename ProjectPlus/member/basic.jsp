<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/ProfileMain.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
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
			/*
			$("#tip_mail_count").hide();
			$("#tip_mail").hide();			
			$("#tip_mail_count").html(i++);
			$("#tip_mail_count").fadeIn(300);
			$("#tip_mail").slideDown(300);

			$("#tip_message_count").hide();
			$("#tip_message").hide();			
			$("#tip_message_count").html(i++);
			$("#tip_message_count").fadeIn(300);
			$("#tip_message").slideDown(300);*/
		});
		
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
		$('#date').datepicker();
		$('#date_start').datepicker();
		$('#date_end').datepicker();
		$( "button" ).button();
		$( "#draggable" ).draggable();
		$( "#droppable" ).droppable({
			drop: function( event, ui ) {
				$( this )
					.addClass( "ui-state-highlight" )
					.find( "p" )
						.html( "Dropped!" );
			}
		});	
		

		// dialog
		$( "#dialog" ).dialog( {autoOpen: false, minWidth: 70, minHeight: 100, modal: true} );
		$( "#dialog_btn" ).click(function(){
			$("#dialog").dialog('open');
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
<!-- end of templatemo_menu -->
<!-- InstanceEndEditable -->
<div id="templatemo_white">
</div>
        <div id="templatemo_menu">
            <ul>
            	<li><a href="/index.jsp" class="float_l"><img src="/images/logo.png" height="38" /></a>
			
				</li>
                <li>
                	<a  id="team_btn" href="#" class="float_l">
                		<img id="tip_group" class="tip" src="/images/exclamation.png" />
                        <p id="tip_group_count" class="tip">15</p>
                        <img class="top" src="/images/title_group.png" />
                    </a>				
                </li>
				
<div id="div-float-team">
					<div style="margin-left:20px;margin-top:10px;"><fat-font>組員加入</fat-font></div>
					<div class="divider10"></div> 
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
                      <p><name>陳至圓</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
                      <p><name>楊先絜</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  				     
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
                      <p><name>陳奕豪</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  
                  <div class="col_allw370 frontpage_box hoverdiv">
                      <img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
                      <p><name>郭奕成</name>想要加入<team>軟體工程</team>專案團隊  <button>確定</button> <button>取消</button>
					  </p>   
                  </div>  				  
                                  	
</div>					
				
				
                <li>
                	<a  id="mail_btn" href="#" class="float_l">
                		<img id="tip_mail" class="tip" src="/images/exclamation.png" />
                        <p id="tip_mail_count" class="tip">15</p>       
                    	<img class="top" src="/images/title_mail.png" />
                    </a>					
                </li>				
<div id="div-float-mail">
					<div style="margin-left:20px;margin-top:10px;"><fat-font>站內信通知</fat-font></div>
					<div class="divider10"></div> 
					<div class="col_allw370 frontpage_box hoverdiv">
                    	<img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
                        <p><name>陳奕豪</name>寄了一封<mail>我想加入</mail>信件給你。</p>
  	                </div>    
            	
</div>						
				<li>
                	<a  id="message_btn" href="#" class="float_l">
                		<img id="tip_message" class="tip" src="/images/exclamation.png" />
                        <p id="tip_message_count" class="tip">15</p>       
                    	<img class="top" src="/images/title_message.png" />
                    </a>
                </li>
<div id="div-float-message">
					<div style="margin-left:20px;margin-top:10px;"><fat-font>訊息通知</fat-font></div>
					<div class="divider10"></div> 
					<div class="col_allw370 frontpage_box hoverdiv">
                    	<img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
                        <p><name>陳奕豪</name>在<team>軟體工程</team>新增一筆留言。</p>
  	                </div>    
					<div class="col_allw370 frontpage_box hoverdiv">
                    	<img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
                        <p><name>陳奕豪</name>修改了<team>軟體工程</team>的內容。</p>
  	                </div>      					                   
				              	
</div>	
                <li>
				<form method="get" id="searchform" action="#">
					<input type="text" value="搜尋..." name="s" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)">
						<input type="submit" id="searchsubmit" value=" " />
				</form>      
                </li>
				<li>

				<a  id="account_btn" class="float_r" href="#"><img class="top" src="/images/top_account.png" /><label>帳號 ▼ </label></a>
				<!--<div id="circles" style="text-align:left; background-color:rgba(199, 199, 199, 0.7); width:120px; overflow:auto; position:absolute; padding:50px; max-height:60px;">
        		</div>-->

				
				</li>
				<li><a class="float_r" href="/member/basic.jsp"><img class="top" src="/images/top_profile.png" />
				<label>個人</label></a></li>								
				<li><a class="float_r" href="/project/detail.jsp"><img class="top" src="/images/top_profile.png" />
				<label>專案</label></a></li>
				<li><a class="float_r" href="/index.jsp"><img class="top" src="/images/top_home.png" /><label>首頁</label></a></li>
				
<div id="div-float-account">
					<div style="margin-left:20px;margin-top:10px;">帳號設定</div>
					<div class="divider10"></div>
                    <div class="col_allw170 frontpage_box hoverdiv">
                      <img src="/images/profile_img.png" alt="Image" width="24" height="24">
                      <h2>帳號設定</h2>                        
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
                    		<h2>隱<img src="/images/profile_phone.png" alt="Image" width="24" height="24" />私設定</h2>
                    </div>     
                  <div class="col_allw170 frontpage_box hoverdiv">
                      <img src="/images/profile_task.png" alt="Image" width="24" height="24">
                    <h2>使用說明</h2>
                  </div>  
                  <div class="col_allw170 frontpage_box hoverdiv">
                      <img src="/images/profile_mail.png" alt="Image" width="24" height="24">
                    <h2>登出</h2>
                  </div>                    	
</div>							
            </ul>    	
        </div> 




        <div id="templatemo_main">
            
          <div class="col_w900 hr_divider">
          		
      			<div id="slide_left" class="col_w170 lp_box float_l">
				<div class="subTopDiv" ><img src="/images/profileTitle.png"/></div>	
					
					<div class="col_allw170 frontpage_box hoverdiv">
                      <a href="/member/basic.jsp">
					  <img src="/images/user.png" alt="Image" width="24" height="24">
                      <h2>基本資料</h2>
					  </a>
                    </div>                    
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/member/photo.jsp">
						<img src="/images/profile_img.png" alt="Image" width="24" height="24">
						<h2>大頭貼照</h2>
					</a>	
                    </div>
                    <div class="col_allw170 frontpage_box hoverdiv">
					<a href="/member/contact.jsp">
						<img src="/images/profile_phone.png" alt="Image" width="24" height="24">
						<h2>聯絡資料</h2>
					</a>	
                    </div>     
					<div class="col_allw170 frontpage_box hoverdiv">
					<a href="/member/task.jsp">
						<img src="/images/profile_task.png" alt="Image" width="24" height="24">
						<h2>目前工作</h2>
					</a>
					</div>                                                         
			<div class="subBottomDiv" ></div>            
            </div>      
				<div id="dropBox" class="toggler col_w700 lp_box float_l margin_20rl">		
				<div class="subTopDiv" >
				<!-- InstanceBeginEditable name="PageTitle" -->
				<h2 class="uiHeaderTitle">陳奕豪<img class="arrow_right" src="/images/arrow_right.png" />基本資料</h2>
				<!-- InstanceEndEditable -->
				
				</div>	
				<!--<img src="/images/subTitle.jpg" alt="Image" width="690" height="29" />-->
                <!-- InstanceBeginEditable name="RightArea" -->
                <div class="table-content">
					
				 
						<table summary="站內信箱" width="100%">
							<!--<caption>Table designs</caption>-->
							<thead>
							<tr>
								<th width="20%" scope="col">聯絡方式</th>
								<th width="80%" scope="col">資訊</th>
							</tr>
							</thead>
							<tfoot>
							<tr>
								<th scope="row"></th>
								<td colspan="4"></td>
							</tr>
							</tfoot>
							<tbody>
								<tr>
									<td>姓名</td>
									<td>陳奕豪</td>									
								</tr>
								<tr class="odd">									
									<td>性別</td>
									<td>男生</td>									
								</tr>					
								<tr>
									<td>現居城市</td>
									<td>新北市</td>									
								</tr>
								<tr class="odd">									
									<td>生日</td>
									<td>1990/03/02</td>									
								</tr>		
								<tr>
									<td>血型</td>
									<td>A型</td>									
								</tr>
								<tr class="odd">									
									<td>關於我</td>
									<td>我是北科大的學生。</td>									
								</tr>																															
							</tbody>
						</table>			

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




<div id="templatemo_footer_wrapper">
    <div id="templatemo_footer">
    	
		<a href="index.html">首頁</a> | <a href="about.html">關於我們</a> | <a href="blog.html">文章列表</a> | <a href="gallery.html">Gallery</a> | <a href="contact.html" class="last">Contact</a> <br /><br />
        
        Copyright © 2048 ITHub | IT / Developer Center<a href="http://www.templatemo.com" target="_parent"></a>
    
  </div> <!-- end of templatemo_footer -->
</div>

</body>
<!-- InstanceEnd --></html>