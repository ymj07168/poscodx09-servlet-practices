<%@page import="emaillist.vo.EmaillistVo"%>
<%@page import="emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	EmaillistDao dao = new EmaillistDao();
	dao.insert(vo);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 정보</title>
</head>
<body>
	<%=firstName %> <br/>
	<%=lastName %> <br/>
	<%=email %>
	
	<p><a href="/emaillist01/">리스트 바로가기</a></p>
</body>
</html>