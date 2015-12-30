<%@page import="iedu.data.LoginData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="iedu.data.BeanData" id="bean" scope="page" />
	
	<jsp:setProperty name="bean" property="*" />

	당신의 ID 는 <%= bean.getId() %> 입니다. <br>
	당신의 PWD는 <%= bean.getPwd() %> 입니다. <br>
	당신의 이름은 <%= bean.getName() %> 입니다. <br>
	당신의 성별은 <%= bean.getGender() %> 입니다, <br>
	당신의 취미는 <%= bean.getHobbyStr() %> 입니다.<br>
	당신이 선택한 날짜는 <%= bean.getYear() + " 년 " + bean.getMonth() + " 월 " + bean.getDay() + " 일 " %> 입니다. <br>
	당신의 메세지는 <%= bean.getArea() %> 입니다.

</body>
</html>