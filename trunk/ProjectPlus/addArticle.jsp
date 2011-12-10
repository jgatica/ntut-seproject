<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>註冊會員</title>
<script language="javascript" type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<link href="/css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/tinymce/tiny_mce.js"></script>
    <script type="text/javascript" src="/js/tinymce/jquery.tinymce.js"></script>
    <script language="javascript" type="text/javascript">
	$(document).ready(function(){
		$(function() {
			
					$('textarea.tinymce').tinymce({
						// Location of TinyMCE script
						script_url : '/js/tinymce/tiny_mce.js',
	
						// General options
						theme : "advanced",
						plugins : "pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",
	
						// Theme options
						theme_advanced_buttons1 : "bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,bullist,numlist|,forecolor,backcolor,fontsizeselect",
						theme_advanced_buttons2 : "",
						theme_advanced_buttons3 : "",
						theme_advanced_buttons4 : "",
						theme_advanced_toolbar_location : "top",
						theme_advanced_toolbar_align : "left",
						theme_advanced_statusbar_location : "bottom",
						theme_advanced_resizing : true,
	
						// Example content CSS (should be your site CSS)
						content_css : "css/content.css",
	
						// Drop lists for link/image/media/template dialogs
						template_external_list_url : "lists/template_list.js",
						external_link_list_url : "lists/link_list.js",
						external_image_list_url : "lists/image_list.js",
						media_external_list_url : "lists/media_list.js",
	
						// Replace values for the template plugin
						template_replace_values : {
								username : "Some User",
								staffid : "991234"
						}
					});
			});	
	});
	</script>
</head>

<body>
<div id="templatemo_article">
  <div class="col_w900 hr_divider">
    
      <h2>ITHub</h2>
    <p><a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>登入</strong></a>你<a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>註冊</strong></a>時的帳號與密碼</p>
    
    <div class="col_w900 float_l">
          
          
            <textarea id="content" name="content" class="tinymce" style="width:100%">
            </textarea>          
              <input type="reset" value="登入" id="reset" name="reset" class="submit_btn float_r" />
              <input type="button" value="忘記密碼" id="register" class="submit_btn float_l" />
      
    </div>
    </div>

  
</div>
</body>
</html>