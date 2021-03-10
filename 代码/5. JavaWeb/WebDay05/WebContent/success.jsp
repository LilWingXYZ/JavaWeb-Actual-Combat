<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = (String)session.getAttribute("username");
		if(username != null) {
			
	%>
	欢迎<%=username%>
	<%
		} else {
			
	%>
	<p style = color:red;">您还没有登录，请先登录！</p>
	<%
		}
	%>
</body>
</html>