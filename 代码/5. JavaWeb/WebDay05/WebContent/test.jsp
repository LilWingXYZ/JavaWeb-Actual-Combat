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
		pageContext.setAttribute("pageTest","***********");
	%>
	
	<%
		String pageTest = (String)pageContext.getAttribute("pageTest");
	%>
	<%=pageTest %>
	
	<%
		pageContext.setAttribute("addr", "dxy",pageContext.SESSION_SCOPE);
	%>
	
	<hr/>
	
	<%
		pageContext.setAttribute("key", "pageContext");
		request.setAttribute("key", "request");
		session.setAttribute("key", "session");
		application.setAttribute("key", "application");
	
		String key =(String)pageContext.findAttribute("key");
		out.print(key);
		
	%>
</body>
</html>