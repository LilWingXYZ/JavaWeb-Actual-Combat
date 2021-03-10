<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP脚本 
		   在网页中写Java代码
	 -->
	<%-- JSP注释 --%>
	<%
		System.out.println("************");
		//内置对象-----不用创建就可以使用的对象  out  response.getWriter();
		out.print("hello world");
		
		int age = 10;
	%>
	
	<%
		out.print(age);
	
		String[] arr = {"***", "&&&&", "^^^^"};
		for(String str : arr) {
			out.print(str);
		}
	%>
	<hr/>
	<%=age %>
	
</body>
</html>