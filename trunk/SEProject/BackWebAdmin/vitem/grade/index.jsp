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
		<!-- �ϥ�static�ܼƷ�form��value�� -->
		<%
			int op1 = GradeAction.OP_ADDGRADE;
			int op2 = GradeAction.OP_LISTGRADELOG;
			int op3 = GradeAction.OP_UPDREMARK;
			int op4 = GradeAction.OP_DYNAMIC_LISTGRADELOG;
		%>
		<!-- �s�W����  -->
		<form action="addgrade.jsp">
			<input name="op" value="�[�J" type="submit">
		</form>
		
		<!-- �����C��  -->
		<form action="GradeAction.do">
			<input type="hidden" name="op" value="<%=op2%>"/>
			<input value="�C��" type="submit">
		</form>
	
		<!-- �ʺA�C��  -->
		<form action="GradeAction.do">
			<input type="hidden" name="op" value="<%=op4%>"/>
			<input value="�ʺA�C��" type="submit">
		</form>
	
	</body>
</html>