<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/MainTemplate.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Project Planing Estimatation Tool</title>
		
		<!-- CSS -->
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/social-icons.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/styled-elements.css" type="text/css" media="screen" />
		<!--[if IE 8]>
			<link rel="stylesheet" type="text/css" media="screen" href="/css/ie8-hacks.css" />
		<![endif]-->
		<!-- ENDS CSS -->	
		
		<!-- GOOGLE FONTS -->
		<link href='http://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>
		
		<!-- JS -->
		<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript" src="js/jquery.scrollTo-1.4.2-min.js"></script>
		<script type="text/javascript" src="js/quicksand.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<!--[if IE]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
			<script>
	      		/* EXAMPLE */
	      		//DD_belatedPNG.fix('*');
	    	</script>
		<![endif]-->
		<!-- ENDS JS -->
		
		
		<!-- Nivo slider -->
		<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
		<script src="js/nivo-slider/jquery.nivo.slider.js" type="text/javascript"></script>
		<!-- ENDS Nivo slider -->
		
		<!-- tabs -->
		<link rel="stylesheet" href="css/tabs.css" type="text/css" media="screen" />
		<script type="text/javascript" src="js/tabs.js"></script>
  		<!-- ENDS tabs -->
  		
  		<!-- prettyPhoto -->
		<script type="text/javascript" src="js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<link rel="stylesheet" href="js/prettyPhoto/css/prettyPhoto.css" type="text/css" media="screen" />
		<!-- ENDS prettyPhoto -->
		
		<!-- superfish -->
		<link rel="stylesheet" media="screen" href="css/superfish.css" /> 
		<link rel="stylesheet" media="screen" href="css/superfish-left.css" /> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/hoverIntent.js"></script>
		<script type="text/javascript" src="js/superfish-1.4.8/js/superfish.js"></script>
		<script type="text/javascript" src="js/superfish-1.4.8/js/supersubs.js"></script>
		<!-- ENDS superfish -->
		
		<!-- poshytip -->
		<link rel="stylesheet" href="js/poshytip-1.0/src/tip-twitter/tip-twitter.css" type="text/css" />
		<link rel="stylesheet" href="js/poshytip-1.0/src/tip-yellowsimple/tip-yellowsimple.css" type="text/css" />
		<script type="text/javascript" src="js/poshytip-1.0/src/jquery.poshytip.min.js"></script>
		<!-- ENDS poshytip -->
		
		<!-- Tweet -->
		<link rel="stylesheet" href="css/jquery.tweet.css" media="all"  type="text/css"/> 
		<script src="js/tweet/jquery.tweet.js" type="text/javascript"></script> 
		<!-- ENDS Tweet -->
		
		<!-- Fancybox -->
		<link rel="stylesheet" href="js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.css" type="text/css" media="screen" />
		<script type="text/javascript" src="js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
		<!-- ENDS Fancybox -->
		
		<!-- SKIN -->
		<link rel="stylesheet" href="skins/plastic/style.css" type="text/css" media="screen" />

		<!-- InstanceBeginEditable name="Head" -->
        <script language="javascript" type="text/javascript">
			$(document).ready(function(){
				$("#compute").click(function(){
					var op =  $('#op').val();
					var arg1 = $("#arg1").val();
					var arg2 = $('#arg2').val();
					$.getJSON('/ComputeAction.do',  { op: op, arg1: arg1, arg2: arg2  }, function(data) {
						alert(data);					
					});
				});		
			});       
   		</script>
		<!-- InstanceEndEditable -->

</head>
	
	<body class="">
		
	
		<!-- WRAPPER -->
	  <div id="wrapper">
			
			<!-- HEADER 
            
            -->
			<div id="header">
<a href="index.html"><img id="logo" src="img/logo.png" alt="Nova" /></a>
			<!-- Social 
			<div id="social-holder">
				<ul class="social">
					<li><a href="http://www.facebook.com" class="poshytip facebook" title="Become a fan"></a></li>
					<li><a href="http://www.twitter.com" class="poshytip twitter" title="Follow our tweets"></a></li>
					<li><a href="http://www.dribbble.com" class="poshytip dribbble" title="View our work"></a></li>
					<li><a href="http://www.addthis.com" class="poshytip addthis" title="Tell everybody"></a></li>
					<li><a href="http://www.vimeo.com" class="poshytip vimeo" title="View our videos"></a></li>
					<li><a href="http://www.youtube.com" class="poshytip youtube" title="View our videos"></a></li>
				</ul>
			</div>
            -->
			<!-- ENDS Social -->
			
			<!-- Navigation -->
			<ul id="nav" class="sf-menu">
				<li><a href="/index.jsp">首     頁</a></li>
                <li><a href="/teamMember.jsp">成員名單</a><li>
                <li><a href="projectList.jsp">專案管理</a>
					<ul>
						<li><a href="addProject.jsp"><span> 專案新增</span></a></li>
                        <li><a href="projectList.jsp"><span> 專案列表</span></a></li>
                    </ul>
				</li>
                <li><a href="/PES.jsp">專案估算</a><li>  
				<li><a href="/projectDiagram.jsp">歷史報表</a><li>  
                <!--                            
				<li><a href="features.html">頁面元素</a>
					<ul>
						<li><a href="features-appearance.html"><span> 外表</span></a></li>
						<li><a href="features-columns.html"><span> 標題</span></a></li>
						<li><a href="features-accordion.html"><span> 動畫</span></a></li>
						<li><a href="features-toggle.html"><span> 觸發盒</span></a></li>
						<li><a href="features-tabs.html"><span> 標籤</span></a></li>
						<li><a href="features-infobox.html"><span> 文字方塊</span></a></li>
						<li><a href="features-monobox.html"><span> 圖示</span></a></li>
					</ul>
				</li>
				<li><a href="blog.html">部落格</a></li>
				<li><a href="portfolio.html">文件夾</a></li>
				<li><a href="gallery.html">畫廊</a>
					<ul>
						<li><a href="gallery.html"><span> 四欄 </span></a></li>
						<li><a href="gallery-3.html"><span> 三欄 </span></a></li>
						<li><a href="gallery-2.html"><span> 兩欄 </span></a></li>
							<li><a href="video-gallery.html"><span> 影片畫廊 </span></a></li>
					</ul>
				</li>
				<li><a href="contact.html">聯絡我們</a></li>
                -->
			</ul>
			<!-- Navigation -->	
			
			<!-- search -->
			<div class="top-search">
				<form  method="get" id="searchform" action="#">
					<div>
						<input type="text" value="搜尋..." name="s" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)" />
						<input type="submit" id="searchsubmit" value=" " />
					</div>
				</form>
			</div>
			<!-- ENDS search -->
				
                <!-- Breadcrumb-->
                <div id="breadcrumbs">
					<!-- InstanceBeginEditable name="Guide" -->
                    <a title="Home" href="index.html">首頁</a>
					<!-- InstanceEndEditable -->
              </div>
				<!-- ENDS Breadcrumb-->	
                
                

				
		  </div>
			<!-- ENDS HEADER -->
			
			<!-- MAIN -->
			<div id="main">
				<!-- InstanceBeginEditable name="Main" -->

		<div id="content">
				
				<!-- title -->
				<div id="page-title">
					<span class="title">功能測試頁面</span>
					<span class="subtitle">呼叫某OP使用對話框檢視結果.</span>
				</div>
				<!-- ENDS title -->
				
				<!-- page-content -->
				<div id="page-content">
					
					<!-- toggle -->
					<h6 class="toggle-trigger active"><a href="#">OP操作0~2</a></h6>
					<div class="toggle-container" style="display: block; ">
					    <div class="block">
						<p>
                            <form action="ComputeAction.do" method="post">
                                
                                參數一 <input id="arg1" type="text" name="arg1" value="">
                                參數二 <input id="arg2" type="text" name="arg2" value="">
                                OP : <input id="op" type="text" name="op"/>
                                <a id="compute" class="link-button">計算</a>
                                
                            </form>
                        
                        </p>
					    </div>
					</div>
					<h6 class="toggle-trigger active"><a href="#">Toogle this box</a></h6>
					<div class="toggle-container" style="display: block; ">
					    <div class="block">
						<p>
                        	<p class="green-box">OP操作3~5</p>
                            <form action="ComputeAction.do" method="post">
                                
                                參數一 <input id="arg1" type="text" name="arg1" value="">
                                參數二 <input id="arg2" type="text" name="arg2" value="">
                                OP : <input id="op" type="text" name="op"/>
                                <a id="compute" class="link-button">計算</a>
                                
                            </form>
                        
                        </p>
					    </div>
					</div>

					<!-- ENDS toggle -->
					
					

				</div>
				<!-- ENDS page-content -->

			</div>
                
                <!-- InstanceEndEditable -->
            </div>
			<!-- ENDS MAIN -->
			
			<!-- FOOTER -->
			<div id="footer">
				
				<!-- footer-cols -->
				<ul id="footer-cols">
					<li class="col">
						<h6>關於SEProject</h6>
						這個專案為台北科技大學- 軟體工程課程所研發，我們訴求將專案分析做到一個整合。
					</li>
					<li class="col">
						<h6>Categories</h6>
						<ul>
							<li><a href="#">Webdesign</a></li>
							<li><a href="#/">Wordpress</a></li>
							<li><a href="#">Photo</a></li>
							<li><a href="#">Code</a></li>
						</ul>
					</li>
					<li class="col">
						<h6>Categories</h6>
						<ul>
							<li><a href="#">Webdesign</a></li>
							<li><a href="#/">Wordpress</a></li>
							<li><a href="#">Photo</a></li>
							<li><a href="#">Code</a></li>
						</ul>
					</li>
				</ul>
				<!-- ENDS footer-cols -->
				
				<!-- Bottom -->
				<div id="bottom">
					樣板作者為 <a href="http://www.luiszuno.com"> Luiszuno</a> 版權所有
					
					<div id="to-top" class="poshytip" title="To top"></div>
					
				</div>
				<!-- ENDS Bottom -->
			</div>
			<!-- ENDS FOOTER -->
		
		</div>
		<!-- ENDS WRAPPER -->
	
	</body>
	
<!-- InstanceEnd --></html>