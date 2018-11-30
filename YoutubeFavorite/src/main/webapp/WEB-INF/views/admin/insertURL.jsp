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
		var form = document.getElementById("frm");
		var y_url = form.y_url.value;
		var target = "https://www.googleapis.com/youtube/v3/videos?id="+y_url+"&key=AIzaSyCMSuuXZM7N908Jj7hdXIEx85Hi7c1t1Mg&part=snippet"
		
		var xhttp = new XMLHttpRequest();
	    xhttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	        	
	        	var obj = JSON.parse(this.responseText);	            
	             
	        	if(obj.items[0] != undefined) {
	        		var y_title = document.getElementById("y_title")
		            y_title.value = obj.items[0].snippet.title	
		            form.submit();
	        	}
	       }
	    };
	    xhttp.open("GET", target, true);
	    xhttp.send(); 
	    
		return false;
	}
</script>
<form:form id="frm" onsubmit="return beforeSend()">
	URL : <input type="text" name="y_url">
	<input type="hidden" id="y_title" name="y_title">
	<button type="submit">URL UPLOAD</button>
</form:form>
</body>
</html>