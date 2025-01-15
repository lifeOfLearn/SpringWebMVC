<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404</title>
</head>
<body>
	<%-- Spring 6.x -> tomcat 10 -> 使用jakarta --%>
	<div>message:<%= request.getAttribute("jakarta.servlet.error.message") %></div>
	<div>code:<%= request.getAttribute("jakarta.servlet.error.status_code") %></div>
	<div>路徑:<%= request.getAttribute("jakarta.servlet.error.request_uri") %> 找不到</div>
	<%-- <!-- Spring 5.X -> tomcat 9 -> 使用javax 
	<div>message:<%= request.getAttribute("javax.servlet.error.message") %></div>
	<div>code:<%= request.getAttribute("javax.servlet.error.status_code") %></div>
	<div>路徑:<%= request.getAttribute("javax.servlet.error.request_uri") %> 找不到</div>
	 --> --%>
</body>
</html>