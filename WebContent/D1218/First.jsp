<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.isNew()) {
			out.println("새로운 손님이군요<br>");
			out.println("당신의 일련번호는" + session.getId());
		}
		else {
			out.println("당신의 일련번호는" + session.getId());
		}
	%>
</body>
</html>