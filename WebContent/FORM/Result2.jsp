<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("irum");
	String gender = request.getParameter("gender");
	String h1 = request.getParameter("hobby1");
	String h2 = request.getParameter("hobby2");
	String h3 = request.getParameter("hobby3");
	String h4 = request.getParameter("hobby4");
	String h5 = request.getParameter("hobby5");
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String area = request.getParameter("area");
%>
	당신의 ID 는 <%= id %> 입니다. <br>
	당신의 PWD는 <%= pwd %> 입니다. <br>
	당신의 이름은 <%= name %> 입니다. <br>
	당신의 성별은 <%= gender %> 입니다, <br>
	당신의 취미는 <%= h1 + " " + h2 + " " + h3 + " " + h4 + " " + h5 %> 입니다.<br>
	당신이 선택한 날짜는 <%= year + " 년 " + month + " 월 " + day + " 일 " %> 입니다. <br>
	당신의 메세지는 <%= area %> 입니다.
	
</body>
</html>