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
	// 할일
	// 로그인을 한 경우와 하지 않은 경우는 CID라는 키값으로 데이터가 있는지 여부를 보고 판단할 수 있다.
	// 로그아웃은?
	// CID라는 키값의 데이터만 지우면 될것이다.
	session.removeAttribute("CID");
	
	response.sendRedirect("LoginForm.jsp");

%>
</body>
</html>