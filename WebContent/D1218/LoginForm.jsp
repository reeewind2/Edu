<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style>
img {
	float : auto;
	margin: 0 0 10px 10px;
}
</style>
</head>
<body>
<%
	String tempID = (String) session.getAttribute("CID");
	if(tempID == null || tempID.length() == 0) {
%>
	<form method="post" action="LoginProc.jsp">
		<table border="1" width="50%" align="center">
		
		
			<tr>
			<td width="20%">ID</td>
				<td>
				<input type="text" name="id">
				</td>
				<td>PASSWORD</td>
				<td>
				<input type="password" name="pw">
				</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
				<input type="submit" value="로그인">
				</td>
				<td colspan="2" align="center">
				<p><img src="sed.jpg" width="100" height="140"></p>
				</td>
				</tr>
		</table>
	</form>
	
<%
	}
	else {
%>
	
	<table width="50%" border="1" align="center">
		<tr>
			<td> <%= tempID %> 님 환영합니다.</td>
			</tr>
		<tr>
			<td align="center">
				<a href="LogoutProc.jsp">로그아웃</a>
			</td>
		</tr>
	</table>
<%
	}
%>
</body>
</html>