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

		<!-- InstanceBeginEditable name="Head" -->Head<!-- InstanceEndEditable -->

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
                    Guide
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
					<span class="title">專案估算</span>
					<span class="subtitle">輕鬆的估算你目前專案的狀態.</span>
				</div>
				<!-- ENDS title -->
				
				<!-- page-content -->
				<div id="page-content">
				
					<!-- TABS -->
					<!-- the tabs -->
					<ul class="tabs">
						<li><a href="#" class="current">COCOMO</a></li>
						<li><a href="#" class="">Funcational Point</a></li>						
					</ul>
					
					<!-- tab "panes" -->
					<div class="panes">					
						<!-- COCOMO content  -->
						<div class="three-fourth" style="display: block; ">
							<h6 class="information-box">COCOMO定義</h6>
							<p class="dropcap">
COCOMO模式由Boehm依據TRW公司所開發過的63個專案資料，並假設軟體規模與發展時程為非線性關係，並且不同的開發環境有不同的估算方程式。其方法不僅提供衡量時程的方法，估算生命週期中每個階段如何分配人力。亦可利用敏感度分析(Sensitivity Analysis)，擬定不同的策略，調整成本因子。
							</p>
							<h6 class="red-box">COCOMO估算計算</h6>
							<p>
請填寫下表單中的各項屬性值，最後按下"計算"按鈕來估算專案。
							</p>
<form name="f1" method="post">

<input type="hidden" name="startCOCOMO" value="1">


      </td>
    </tr>

  </tbody>
</table>
<br>



<h6>Software Size</h6>

<br><table style="width: 100%; text-align: left; 
border=" 1"="" cellpadding="1" cellspacing="0"><tbody><tr><td style="width: 101px; vertical-align: top;"><br>

<table style="width: 60%; text-align: left;" border="0" cellpadding="2" cellspacing="2">

<tbody>

<tr>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top; text-align: center;"><a href="http://sunset.usc.edu/research/COCOMOII/expert_cocomo/sloc.html">SLOC</a></td>

<td style="vertical-align: top; text-align: center;"><font color="#000000"><i>&nbsp;</i>% Design Modified</font></td>

<td style="vertical-align: top; text-align: center;"><font color="#000000">% Code Modified</font></td>

<td style="vertical-align: top; text-align: center;"><font color="#000000">% Integration Required</font></td>

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

<td style="vertical-align: top;"><input type="text" name="new_size" size="8" maxlength="8" align="right" value=""> <br>

</td>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top;"><br>

</td>

<td style="vertical-align: top;"><br>

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

<br></td><td style="text-align: left; vertical-align: top;"></td>
</tr></tbody></table><b>&nbsp;Software Scale Drivers </b>



<table border="0"><tbody><tr valign="top">

<td>

  <table border="0"><tbody><tr>

  <td align="left">Precedentedness</td>

  <td><select name="prec">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

  </option></select></td>

  </tr><tr>

  <td align="left">Development Flexibility</td>

  <td><select name="flex">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

  </option></select></td>

  </tr>

<tr>

  <td><br>
  <b>Software Cost Drivers</b></td>

  </tr>

  <tr>

  <td><b>Product</b></td>

  </tr>

<tr>

<td align="left">Required Software Reliability</td>

<td>

<select name="rely">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Data Base Size</td>

<td>

<select name="data">

  <option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Product Complexity</td>

<td>

<select name="cplx">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

</option></select>

</td>

</tr>

<tr>

<td align="left">Developed for Reusability</td>

<td>

<select name="ruse">

  <option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

</option></select>

</td>

</tr><tr>

<td align="left">Documentation Match to Lifecycle Needs</td>

<td>

<select name="docu">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

  <td>&nbsp;</td>

  </tr>

  <tr>

  <td>&nbsp;</td>

  </tr>



     </tbody></table>

</td>

<td>

  <table border="0"><tbody><tr>

    <td align="left">Architecture / Risk Resolution</td>

  <td><select name="resl">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

  </option></select></td>  </tr>

    <tr><td align="left">Team Cohesion</td>

   <td><select name="team">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

  </option></select></td>

  </tr>

<tr>

  <td><b>&nbsp;</b></td>

  </tr>

<tr>

</tr><tr>

  <td><br><b>Personnel</b></td>

  </tr>

<tr>

<td align="left">Analyst Capability</td>

<td>

<select name="acap">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Programmer Capability</td>

<td>

<select name="pcap">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Personnel Continuity</td>

<td>

<select name="pcon">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Application Experience</td>

<td>

<select name="apex">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Platform Experience</td>

<td>

<select name="pexp">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Language and Toolset Experience</td>

<td>

<select name="ltex">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

  <tr>

    <td>&nbsp;</td>

  </tr>



    </tbody></table>

</td>

<td>

  <table border="0"><tbody><tr>

    <td align="left">Process Maturity</td>

   <td><select name="pmat">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

  </option></select></td>  </tr>

  <tr>

    <td>&nbsp;</td>

  </tr>

  <tr>

  </tr><tr>

  <td><b>&nbsp;</b></td>

  </tr>

<tr>

</tr><tr>

    <td><br><b>Platform</b></td>

  </tr>

<tr>

<td align="left">Time Constraint</td>

<td>

<select name="time">

  <option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

</option></select>

</td>

</tr>



<tr>

<td align="left">Storage Constraint</td>

<td>

<select name="stor">

  <option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

</option></select>

</td>

</tr>



<tr>

<td align="left">Platform Volatility</td>

<td>

<select name="pvol">

  <option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

   <tr>

    <td><br><b>Project</b></td>

  </tr>

<tr>

<td align="left">Use of Software Tools</td>

<td>

<select name="tool">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select>

</td>

</tr>

<tr>

<td align="left">Multisite Development</td>

<td>

<select name="site">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

  </option><option value="Extra High">Extra High

</option></select></td>

</tr>

<tr><td align="left">Required Development Schedule</td>

<td>

<select name="sced">

  <option value="Very Low">Very Low

  </option><option value="Low">Low

  </option><option value="Nominal" selected="">Nominal

  </option><option value="High">High

  </option><option value="Very High">Very High

</option></select></td>

</tr>

      </tbody></table>

</td></tr>

</tbody></table>

<b>Software Labor Rates</b><br>
Cost per Person-Month (Dollars)
<input type="text" name="software_labor_cost_per_PM" size="8" maxlength="8" align="right" value=""> 
<br>
<div><a id="compute" class="link-button">計算</a></div>
<hr>
</form>


						</div>
						<!-- ENDS tab 1 content -->
						
						<!-- Funcational Point content  -->
						<div style="display: none; ">
							<h6 class="information-box">Funcational Point定義</h6>
							<p class="dropcap">
COCOMO模式由Boehm依據TRW公司所開發過的63個專案資料，並假設軟體規模與發展時程為非線性關係，並且不同的開發環境有不同的估算方程式。其方法不僅提供衡量時程的方法，估算生命週期中每個階段如何分配人力。亦可利用敏感度分析(Sensitivity Analysis)，擬定不同的策略，調整成本因子。
							</p>
							<h6 class="red-box">尚未討論部分</h6>
                            <br><br><br><br>
						</div>
						<!-- ENDS tab 2 content -->
						
					
					</div>
					<!-- ENDS TABS -->


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