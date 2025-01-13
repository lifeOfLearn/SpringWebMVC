<%@page import="java.util.Date"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get</title>
</head>
<body>
	<ol>
	<% 
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
	%>
		<li>name:<%= name %>, value:<%= value %></li>
	<% } %>
	</ol>
	
	<h1>隱含變數</h1>
	<hr>
	<h2>request<sup>***</sup></h2>
	<p> 請求方式: request.getMethod()- <%= request.getMethod() %></p><!-- 網址進入一定是GET -->
	<p> 請求網址(URL): request.getRequestURL()- <%= request.getRequestURL() %></p>
	<p> 請求網址(URI)資源的絕對路徑: request.getRequestURI()- <%= request.getRequestURI() %></p>
	<p> 請求協議: request.getProtocol()- <%= request.getProtocol() %></p>
	<p> 伺服器ContextPath: request.getContextPath()- <%= request.getContextPath() %></p>
	<p> 伺服器: request.getLocalName()- <%= request.getLocalName() %></p>
	<p> 伺服器位置: request.getLocalAddr()- <%= request.getLocalAddr() %></p>
	<p> 伺服器埠號: request.getLocalPort()- <%= request.getLocalPort() %></p>
	<p> getServletContext() <%=getServletContext() %></p>
	<p> getServletContext().getRealPath("你的contextpath後面路徑") <%=getServletContext().getRealPath("a") %></p>
	
	<p> 客戶端電腦名稱: request.getRemoteHost()- <%= request.getRemoteHost() %></p>
	<p> 客戶端位置: request.getRemoteAddr()- <%= request.getRemoteAddr() %></p>
	<p> 客戶端埠號: request.getRemotePort()- <%= request.getRemotePort() %></p>
	<hr>
	<p>瀏覽器使用語言: Accept-Language: <%=request.getHeader("Accept-Language") %><!-- 字串 大小寫都可 -->
	<p>瀏覽器版本: User-Agent: <%= request.getHeader("User-Agent") %>
	
	<hr>	
	<p> 設定編碼前: request.getCharacterEncoding(): <%= request.getCharacterEncoding() %></p>
	<% request.setCharacterEncoding("utf-8"); //讀取中文前要設定，不然亂碼 %>
		
	<p> 設定編碼後: request.getCharacterEncoding(): <%= request.getCharacterEncoding() %></p>
	
	
	<p> 讀取參數: request.getParameter(參數名稱="address")-<%= request.getParameter("address") %></p>
	<form method='POST'><!-- 設定請求方法 -->
		<label>請嘗試開啟setChar.和關閉setChar. </label>
		<input type = 'text' name = 'address' placeholder="請輸入中文地址">
		<input type = 'submit' value = 'Test POST' >
	</form>
	<hr><hr>
	
	
	<h2>out<sup>*</sup></h2>
	<hr>
	<p>out buffer size: <%=out.getBufferSize() %> kb</p>
	
	<hr><hr>
	<h2>response</h2>
	<p>response buffer size: <%= response.getBufferSize() %></p>
	<p>response content type: <b><%= response.getContentType() %></b> </p>
	<hr><hr>
	<h2>session<sup>**</sup></h2>
	<p>session id: <%= session.getId() %></p><!-- 獨一無二的號碼,同台電腦不同瀏覽器也會不同 。同瀏覽器不同分頁，也是相同 (除非開無痕全部都算另一個,也就是一個瀏覽器最多兩個sessionId)-->
	<p>session is new:是否新的  <%= session.isNew() %></p>
	<p>session timeout時間為: <%= session.getMaxInactiveInterval() %> 秒</p>
	<p>session created:何時建立起來的 <%= session.getCreationTime() %> millsecond</p>
	<p>session created:何時建立起來的 <%= new Date(session.getCreationTime()) %></p>
	<p>session access time(最後一次存取時間為何時)<%= session.getLastAccessedTime() %> millsecond</p>
	<p>session access time(最後一次存取時間為何時)<%= new Date(session.getLastAccessedTime()) %></p>
	<p>現在: <%= System.currentTimeMillis() %>
	<hr><hr>
	<h2>application<sup>*</sup></h2>
	<p>application.getContextPath() <%= application.getContextPath() %></p>
	<p>application.getRealPath() <%= application.getRealPath("/") %></p><!-- 別亂來...可怕 -->
	<hr>
</body>
</html>