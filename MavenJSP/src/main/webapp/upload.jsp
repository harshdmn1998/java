<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>File Upload in Java</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
	<input type="file" name="myfile" multiple>
	<input type="submit" value="Upload"> 
	</form>
</body>
</html>