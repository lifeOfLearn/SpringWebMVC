<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404</title>
</head>
<body>
	<div>路徑:<%= request.getAttribute("javax.servlet.error.request_uri") %> 找不到</div>
</body>
</html>