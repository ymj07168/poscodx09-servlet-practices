<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="/guestbook02/gb">
	<input type='hidden' name="a" value="delete">
	<input type='hidden' name="id" value="<%=id %>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td></td>
		</tr>
	</table>
	</form>
	<br/>
	<a href="/guestbook02/gb">메인으로 돌아가기</a>
</body>
</html>