<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ管理</title>
</head>
<body>
	<h1>カテゴリ登録</h1>
	<hr>
	
	<form action="CategoryServlet" method="post">
		<input type="hidden" name="action" value="regist_execute">
		
		<table border="1">
			<tr>
				<th>カテゴリ名</th>
				<td><input type="text" name="name"></td>
			</tr>
		</table>
		
		<input type="submit" value="登録">
	</form>
	
</body>
</html>