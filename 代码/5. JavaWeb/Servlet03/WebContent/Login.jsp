<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="color:red;">${msg}</p>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		<label>用户名</label>
		<input type="text" name="username" />
		<label>密码</label>
		<input type="password" name="password" />
		<label>爱好</label>
		<button type="submit">登录</button>
	</form>
</body>
</html>