<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>URL 업로드</title>
</head>
<body>
<script type="text/javascript">
	function beforeSend(){
		var title = document.getElementById("title").value;
		var image = document.getElementById("image").value;
		
		if(title == ""){
			alert("제목을 입력해 주세요")
			return false;
		} else if(image == ""){
			alert("파일을 선택해 주세요")
			return false;
		} 
		return true;
	}
</script>
<form:form id="frm" onsubmit="return beforeSend()" enctype="multipart/form-data">
	제목 : <input type="text" name="title" id="title"><br>
	이미지 : <input type="file" name="img" accept="image/*" id="image"><br>
	<button type="submit">Image UPLOAD</button>
</form:form>
</body>
</html>