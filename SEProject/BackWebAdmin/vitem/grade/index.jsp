<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.ilinke.nonn.vitem.grade.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; chars	et=BIG5">
<title>Insert title here</title>
</head>
	<body>
		<!-- 使用static變數當成form的value值 -->
		<%
			int op1 = GradeAction.OP_ADDGRADE;
			int op2 = GradeAction.OP_LISTGRADELOG;
			int op3 = GradeAction.OP_UPDREMARK;
			int op4 = GradeAction.OP_DYNAMIC_LISTGRADELOG;
		%>
		<!-- 新增評價  -->
		<form action="addgrade.jsp">
			<input name="op" value="加入" type="submit">
		</form>
		
		<!-- 評價列表  -->
		<form action="GradeAction.do">
			<input type="hidden" name="op" value="<%=op2%>"/>
			<input value="列表" type="submit">
		</form>
	
		<!-- 動態列表  -->
		<form action="GradeAction.do">
			<input type="hidden" name="op" value="<%=op4%>"/>
			<input value="動態列表" type="submit">
		</form>
	
	</body>
</html>