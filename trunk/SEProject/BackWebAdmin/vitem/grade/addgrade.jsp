<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page import="com.ilinke.nonn.vitem.grade.*"%>


<title>新增評價</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" charset="UTF-8"></script>
<script language="javascript" charset="utf-8">

function addGrade()
{
  var fm = $("#addgrade").get(0);
  if (fm.viprovid.value=="")
    alert ("請輸入viprovid。");
  else if (fm.remark.value=="")
    alert ("請輸入remark。");
  else if (fm.grade.value > 1 || fm.grade.value < -1){
	alert ("分數只能介於 -1 ~ 1。");
  }
  else
  {
    var argstr=$("#addgrade").serialize();
	//alert(argstr);
    $.post('/BackWebAdmin/vitem/grade/GradeAction.do',argstr,addProcess);
  }
}
function addProcess(xml)
{
  messageid = $(xml).find("rstdata").attr('msgid');
  if(messageid>0)
  {
	 alert($(xml).find("rstdata").attr('msg'));
  }
  else
    alert($(xml).find("rstdata").attr('msg'));
}


</script>
</head>

<body>

<div style="width:500px; margin-left:100px;">
<form id="addgrade" method="post" action="/BackWebAdmin/vitem/grade/GradeAction.do">	
  <input type="hidden" name="op" value="<%=GradeAction.OP_ADDGRADE%>"/>
  <br/>
  viprovid: <input type="text" name="viprovid" value="987654" readonly="readonly"/>
  <br/>
  grade: <select name="grade">
   			<option value="1">+1</option>
			<option value="0">0</option>
			<option value="-1">-1</option>
			<option value="-2">-2</option>
  		 </select>
  <br/>
  

remark: <textarea name="remark" cols="30" rows="3">test</textarea>
  <br/>
  <br/>
  <input type="button" value="send grade" onclick="javascript:addGrade()"/>
</form>
</div>

</body>
</html>
