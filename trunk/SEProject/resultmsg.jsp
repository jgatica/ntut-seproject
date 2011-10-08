<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>
resultmsg
</title>
</head>
<%
 Object _title = request.getAttribute("title");
 Object _message = request.getAttribute("msg");

 String title = _title.toString();
 String message =_message.toString();

%>

<body bgcolor="#ffffff">
<h1>
Here is Result Message
</h1>
  Title = <%=title%><br>
  Message =<%=message%>

</body>
</html>
