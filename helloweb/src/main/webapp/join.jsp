<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String birthYear = request.getParameter("birthYear");
	String gender = request.getParameter("gender");
	String profile = request.getParameter("profile");
	
	String[] hobbies = request.getParameterValues("hobby");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=email %>
	<br/>
	<%=password %>
	<br/>
	<%=birthYear %>년생
	<br/>
	<%=gender %>
	<br/>
	<%=profile %>
	<br/>
	
	<%
		for(String hobby:hobbies){
	%>
	<strong><%=hobby %></strong>
	<%
		}
	%>
</body>
</html>