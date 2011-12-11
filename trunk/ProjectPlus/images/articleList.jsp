<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Main.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
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


<script language="javascript" type="text/javascript">
	$(document).ready(function(){
		var start = 0;
		loadData(start);
	
	}); 
	
	function loadData(start) {
		var op = 5;		
		var length = 3; // 取3筆
		$.getJSON('/ArticleAction.do',  { op:op, start: start, length: length }, function(data) {
			//console.log(data);
			if(data != null){
				var content = "";
				for(var i = 0; i < data.length; i++){
					
					content += "<div class='post_box'>";
					content += "<div class='post_box_date'>";
					content += new Date(data[i].edittime);
					content += "<span>By " + data[i].author + "</span>";
					content += "</div>";
					content += "<div class='post_box_content'>";
					content += "<h2><a href='#'>" + data[i].title + "</a></h2>";
					content += "<img src='images/templatemo_image_08.jpg' alt='Image 08' />";
					content +="<p>" + data[i].content + "</p>";
					content += "</div>";
					content += "<div class='cleaner'></div>"
					content += "</div>";
					
				}
				$("#blogs_box").append(content);	
				
				// 如果沒資料了
				if (data.length < length) {
					$(window).unbind('scroll');
					$("#loading_box").hide();
				}
				// 有資料的話，綁定function給滾輪事件
				else {		
					$(window).scroll(function(){
						if($(window).scrollTop() == $(document).height() - $(window).height()){
							$("#loading_box").show();
							loadData(start+length);
						}
					});	
				}
					
			}
			else {
				$("#more_blog").hide();
			}
        });
	}   	

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
        <div id="templatemo_menu">
            <ul>
            	<li><a href="#"><img src="/images/templatemo_logo.png" /><img class="tip" src="/images/templatemo_logo.png" /></a></li>
                <li><a href="#"><img src="/images/title_group.png" /></a></li>
                <li><a href="#"><img src="/images/title_mail.png" /></a></li>
				<li><a href="#"><img src="/images/title_message.png" /></a></li>
                <li>
				<form method="get" id="searchform" action="#">
					<div>
						<input type="text" value="搜尋" name="s" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)" />
						<input type="submit" id="searchsubmit" value=" " />
					</div>
				</form>       
                </li>
            </ul>    	
        </div> 
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
                        <p id="tip_mail_count" class="tip">15</p>       
                    	<img class="top" src="/images/title_mail.png" />
                    </a>					
                </li>				
<div id="div-float-mail">
					<div style="margin-left:20px;margin-top:10px;"><name>站內信通知</name></div>
					<div class="divider10"></div> 
					<div class="col_allw370 frontpage_box hoverdiv">
                    	<img src="/images/profileimg.jpg" alt="Image" width="32" height="32">
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


<!-- InstanceBeginEditable name="Content" -->

        <div id="templatemo_main">
            
          <div class="col_w900 hr_divider">
            
            	<div class="col_w220 lp_box float_r">
           	    	<div class="h2_divider" >
	                    <h2>功能一覽</h2>                        
                	</div>
                    <div class="col_allw220 frontpage_box hoverdiv">
                      <img src="/images/user.png" alt="Image" width="24" height="24">
                      <h2>我的文章</h2>
                      <span class="taglinenomargin">查看您在<strong>ITHub</strong>上的文章</span>
                    </div>                    
                    <div class="col_allw220 frontpage_box hoverdiv">
                      <img src="/images/add_article.png" alt="Image" width="24" height="24">
                      <h2>發表文章</h2>
                        <span class="taglinenomargin">在<strong>ITHub</strong>上發表您的文章</span>
                    </div>
                    <div class="col_allw220 frontpage_box hoverdiv">
                      <img src="/images/collect_article.png" alt="Image" width="24" height="24">
                      <h2>收藏夾</h2>
                        <span class="taglinenomargin">您在<strong>ITHub</strong>上收藏的文章</span>
                    </div>     
                  <div class="col_allw220 frontpage_box hoverdiv">
                      <img src="/images/mail.png" alt="Image" width="24" height="24">
                    <h2>站內訊息</h2>
                      <span class="taglinenomargin">收發您的<strong>ITHub</strong>的信件</span>
                    </div>                                       
                    <div class="col_allw220 frontpage_box hoverdiv">
                      <img src="/images/subscribe_article.png" alt="Image" width="24" height="24">
                      <h2>訂閱文章</h2>
                        <span class="taglinenomargin">訂閱在<strong>ITHub</strong>上的文章</span>
                    </div>    
                </div>



                
                <div id="blogs_box" class="col_w580 float_l">
                    <!--<div class="post_box">
                        <div class="post_box_date">
                            MAY 28, 2048
                            <span>by Thomas</span>
                        </div>
						
                        <div class="post_box_content">
                            <h2><a href="#">Etiam a Dui et Eros Imperdiet Rhoncus</a></h2>
                            <img src="images/templatemo_image_08.jpg" alt="Image 08" />
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed magna nec justo aliquam pretium vitae ultrices nibh. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>.</p>
                        </div>
						
                        <div class="cleaner"></div>
                    </div> -->
				
					
                    
              </div>
                
                <div class="cleaner"><img id="loading_box" src="images/lightbox-ico-loading.gif"  style="visibility:hidden"/></div>
            </div>

            <div class="testimonial"><span class="close"></span>
                <p>Etiam velit dui, elementum nec hendrerit id, convallis in felis. Proin velit massa, lacinia non sagittis suscipit, pretium vitae est. Praesent lacinia ornare urna, eu pellentesque lacus dictum id. Vivamus viverra scelerisque metus eu pellentesque. Proin tincidunt bibendum leo. Curabitur at nisi et.</p>
                <p class="clientname">Flash Templates<span><a href="http://www.flashmo.com" target="_parent"> Nicky George</a></span></p>
            </div>
            

            
            
        </div> <!-- end of templatemo main -->
<!-- InstanceEndEditable -->
       
    	
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