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
		//pageContext作用域仅仅限于当前页面
		pageContext.setAttribute("pageTest", "**************");
	%>
	
	<%
		String pageTest = (String)pageContext.getAttribute("pageTest");
	%>
	<%=pageTest %>
	
	<%
		//pageContext代理session域
		pageContext.setAttribute("addr", "dxy", pageContext.SESSION_SCOPE);
		String addr = (String)session.getAttribute("addr");
		out.print(addr);
	%>
	
	<hr/>
	
	<%
		pageContext.setAttribute("key", "pageContext");
		request.setAttribute("key", "request");
		session.setAttribute("key", "session");
		application.setAttribute("key", "application");
	
		//全域查找
		String key = (String)pageContext.findAttribute("key");
		out.print(key);
	%>
	<hr/>
	${pageTest}
	<hr/>
	${key}
	<hr/>
	${10+1}
	${10+1 eq 11}
	<hr/>
	${abcd}
</body>
</html>