<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	HashMap		map = new HashMap();
%>
	<form method="POST" action="../Board/BoardModify.bbs">
	<table width="50%" border="1" align="center">
		<tr>
 			<td>글번호</td>
 			<td><%= map.get("NO") %></td>
 			<td>조회수</td>
 			<td disabled><%= map.get("HIT") %></td>
 		</tr>
 		<tr>
 			<td>작성자</td>
 			<td><%= map.get("WRITER") %></td>
 			<td>작성일</td>
 			<td><%= map.get("DATE") %></td>
 		</tr>
 		<tr>
 			<td>제목</td>
 			<td colspan="3"><%= map.get("TITLE") %></td>
 		</tr>
 		<tr>
 			<td>본문</td>
 			<td colspan="3"><%= map.get("CONTENT") %></td>
 		</tr>
	</table>
	</form>
</body>
</html>