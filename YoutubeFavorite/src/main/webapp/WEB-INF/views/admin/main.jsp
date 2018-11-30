<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
메인
<a href="insertURL">URL업로드</a>
<a href="insertGallary">image 업로드</a>
<a href="list">Youtube List</a>
<form:form action="${pageContext.request.contextPath }/logout" method="post">
	<input type="submit" value="로그아웃" />
</form:form>
</body>
</html>