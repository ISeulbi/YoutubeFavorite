<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<table>
	<c:forEach var="item" items="${list}">
		<tr><td>${item.getY_title()}</td></tr>
		<tr><td><img src="http://img.youtube.com/vi/${item.getY_url()}/maxresdefault.jpg" style="width:300px"></td></tr>
	</c:forEach>
</table>
</body>
</html>