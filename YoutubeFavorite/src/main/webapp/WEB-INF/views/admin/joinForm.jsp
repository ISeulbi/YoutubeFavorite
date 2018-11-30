<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form:form>
		<label for="u_id">아이디</label>
		<input type="text" id="u_id" name="u_id" value="user1"><br>
		<label for="u_pw">패스워드</label>
		<input type="text" id="u_pw" name="u_pw" value="1212"><br>
		<label for="u_name">이름</label>
		<input type="text" id="u_name" name="u_name" value="이슬비"><br>
		<label for="u_auth">권한</label>
		<input type="text" id="u_auth" name="u_auth" value="ADM"><br>
		<button type="submit">회원가입</button>
	</form:form>
</body>
</html>