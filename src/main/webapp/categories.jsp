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
	<h1>カテゴリ一覧</h1>
	<hr>
	
	<table border="1">
		<tr>
			<th>コード</th>
			<th>カテゴリ名</th>
			<th>更新</th>
			<th>削除</th>
		</tr>
		
		<c:forEach var="category" items="${list}">
			<tr>
				<td>${category.code}</td>
				<td>${category.name}</td>
				<td>
					<form action="CategoryServlet" method="get">
						<input type="hidden" name="action" value="update">
						<input type="hidden" name="code" value="${category.code}">
						<input type="submit" value="更新">
					</form>
				</td>
				<td>
					<form action="CategoryServlet" method="get">
						<input type="hidden" name="action" value="delete_execute">
						<input type="hidden" name="code" value="${category.code}">
						<input type="submit" value="削除">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="CategoryServlet?action=regist">新規登録</a>

</body>
</html>