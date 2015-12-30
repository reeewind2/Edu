<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HashMap map = new HashMap();
	map.put("가나다", "동해물과 백두산이 마르고 닳도록");
	map.put("나다라", "하느님이 보우하사 우리나라 만세");
	map.put("다라마", "무궁화 삼천리 화려강산");
	map.put("라마바", "대한사람 대한으로 길이 보전하세");
	map.put("마바사", "수 고 하 셨 습 니 다");
	
	String	key = request.getParameter("name");
	String	data = (String) map.get(key);
%>
	<dl>
		<dt><%= key %>	</dt>
		<dd><%= data %></dd>
	</dl>
</body>
</html>