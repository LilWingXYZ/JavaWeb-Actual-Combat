<%@page import="java.util.ArrayList"%>
<%@page import="com.ray.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td {
		border: 1px solid #000000;
	}
</style>
</head>
<body>
	<%
		pageContext.setAttribute("name", "zhangsan");
		User u1 = new User();
		u1.setUsername("zs");
		u1.setPassword("111");
		
		User u2 = new User();
		u2.setUsername("zs2");
		u2.setPassword("112");
		
		User u3 = new User();
		u3.setUsername("zs3");
		u3.setPassword("113");
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		pageContext.setAttribute("users", users);
	%>
	<c:out value="hello world"></c:out><br/>
	<c:out value="${name}"></c:out><br/>
	<!-- 设置 -->
	<c:set var="aaa" value="*****" scope="session"></c:set>
	${sessionScope.aaa}<br/>
	<c:set var="score" value="90"></c:set>
	<!-- 分支
		if() {
		
		}
	 -->
	<c:if test="${score >= 60}">
		<p>及格</p>
	</c:if>
	<hr/>
	<c:choose>
		<c:when test="${score >= 80}">优秀</c:when>
		<c:when test="${score < 80 and score >= 60}">及格</c:when>
		<c:otherwise>不及格</c:otherwise>
	</c:choose>
	<hr/>
	<!-- 循环 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		${i}<br/>
	</c:forEach>
	<hr/>
	<table>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>