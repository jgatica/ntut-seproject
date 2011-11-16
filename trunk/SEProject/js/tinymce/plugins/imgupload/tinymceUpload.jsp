<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@page import="com.ilinke.fbsweb.commonfile.CommonFileAction"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/front/jumpWindows.css" rel="stylesheet" type="text/css" />
<link href="/css/front/reset.css" rel="stylesheet" type="text/css" />
<link href="/css/front/table.css" rel="stylesheet" type="text/css" />
<link href="/css/front/buttons.css" rel="stylesheet" type="text/css" />
<link media="screen" rel="stylesheet" href="/colorbox/colorbox.css" />
<style type="text/css">
<!--

#files {
    width:530px;
    margin:0px auto;
}
#files li {
    width:100px;
    height:110px;
    float:left;
    margin-left:30px;
    display:inline;
}
#files li a {
    display:block;
}
#files li a .img {
    border:1px solid #666;
    padding:1px;
}
#files li span a {
    width:100px;
    height:30px;
    line-height:24px;
    text-align:center;
 white-space:nowrap;
    text-overflow:ellipsis; 
    overflow: hidden;
}
-->
</style>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.timeago.js"></script>
<script type="text/javascript" src="/js/jquery.timeago.zh-TW.js"></script>
<script type="text/javascript" src="/js/dateToISOString.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script> 
<script type="text/javascript" src="js/dialog.js"></script>
<script type="text/javascript" src="../../tiny_mce_popup.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".dialogBox").hide();
		$("#upload").click(function(){
			if($("#file").val() != ""){
				$("#uploadform").ajaxSubmit({
					dataType: "json",
					success: function(data){
						$("#file").val("");
						loadFilelistByTag();
					}}
				);
			}
			else{
				alert('請選擇上傳的檔案');
			}
		});	
		loadFilelistByTag();
		
		$("#tagname").keyup(function(){
			var tagname = $("#tagname").val();
			if(tagname!="" & tagname.length >= 2)
				loadFilelistByTag(tagname);
			else
				loadFilelistByTag();
		});
		
		$("#showUpload").click(function(){
			$("#files").height(200);
			$(".dialogBox").slideToggle(210,function(){
				if($(this).is(":hidden")){
					$("#files").height(340);
				}
				else{
					$("#files").height(210);
				}
			});
		});
		
	});
	
	loadFilelistByTag = function(tagname){
		$.getJSON('/CommonFileAction.do', {op: 2}, function(data) {
			console.log(data);
			$("#files").html('')
			
			var content = "";
			for(var i = data.files.length-1; i > 0; i--){
				if(tagname!=null){
					var tags = data.files[i].tags;
					for(var j = 0; j < tags.length; j++){
						if(contains(tags[j], tagname, true)){
							content += "<li>";
							content += "<a class='fileimg' href='#' filename='" + data.files[i].filename + "' title='" + data.files[i].tags + "'><img class='img' width='100' height='75' src='/" +  data.files[i].filename + ".memberGallery' alt=''/></a>";
							content += "<a href='#' style='float: right;' class='deleteimg' title='刪除'filename='" + data.files[i].filename + "'><img src='img/close.png'/></a>";
							content += "<span class='time' title='"+ toISOString(new Date(data.files[i].createtime)) + "'></span>"; 
							content += "</li>"
						}
					}
				}
				else{
					content += "<li>";
					content += "<a class='fileimg' href='#' filename='" + data.files[i].filename + "' title='" + data.files[i].tags + "'><img class='img' width='100' height='75' src='/" +  data.files[i].filename + ".memberGallery' alt=''/></a>";
					content += "<a href='#' style='float: right;' class='deleteimg' title='刪除'filename='" + data.files[i].filename + "'><img src='img/close.png'/></a>";
					content += "<span class='time' title='"+ toISOString(new Date(data.files[i].createtime)) + "'></span>";  
					content += "</li>"
				}
			}
			$("#files").append(content);
			$('span.time').timeago();
			content = "";
			
			$(".fileimg").live('click', function(){
				var filename = $(this).attr('filename');
				var image = "<img src='/" +  filename + ".memberGallery' alt=''/>"
				tinyMCEPopup.editor.execCommand('mceInsertContent', false, image);
				tinyMCEPopup.close();
			});
			
			$(".deleteimg").live('click', function(){
				var filename = $(this).attr('filename');
				$.getJSON('/CommonFileAction.do', {op: 3, filename: filename}, function(data) {
					loadFilelistByTag();
				});
			});
	    });
	}
	function contains(string,substr,isIgnoreCase)
	{
	    if(isIgnoreCase)
	    {
	     string=string.toLowerCase();
	     substr=substr.toLowerCase();
	    }
	     var startChar=substr.substring(0,1);
	     var strLen=substr.length;
	         for(var j=0;j<string.length-strLen+1;j++)
	         {
	             if(string.charAt(j)==startChar)//如果匹配起始字元,開始查找
	             {
	                   if(string.substring(j,j+strLen)==substr)//如果從j開始的字元與str匹配，那ok
	                   {
	                         return true;
	                   }   
	             }
	         }
	         return false;
	}

	
</script>
<title></title>
</head>

<body>
<h5 class="title">faceboss上傳圖片</h5>  
    <div class="dialogBox" style="border:dashed; border-width:1px; border-color:gray; padding: 5px; margin: 5px;">
        <div id="formsList"> 
            <form id="uploadform" action="/CommonFileAction.do" method="post" enctype="multipart/form-data">  
            	<input type="hidden" name="op" value="<%=CommonFileAction.OP_UPDFILE %>" />
				<p style="margin: 5px; overflow:auto;"><label style="float:left;">標籤　</label><input id="tag" name="filetag" type="text"/><font color="#999" >(使用空白鍵分隔標籤)</font></p>
                <p style="margin: 5px; overflow:auto;"><input id="file" class="boxSetting" name="commonfile" type="file" size="50" /></p>
            	<div class="buttonsBorder1"> 
                	<a id="upload" class="ovalbutton"><span>上傳</span></a>
                </div>
            </form>
        </div><!--end of formsList-->
	    
	    
    </div><!--end of dialogBox-->
    <div style="border:dashed; border-width:1px; border-color:gray; padding-left: 5px; padding-right: 5px; margin: 5px;">
    	<div style="padding: 5px; overflow:auto;">
	    	<font color="#999" >(搜尋標籤)</font>
	    	<img id="showUpload" src="img/uploadfile.png" style="float:right; overflow:auto;"/>
	    	<input type="text" id="tagname"/>
    	</div>
    	<Hr Align="Left"|"Center"|"Right"><br>
    	<ul id="files" style="width:600px;height:340px;overflow:auto;">

		</ul>
    </div>
    
    
    <!--buttons Set-->
</body>
</html>