<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 1. 컨텍스트 패스를 알아내자.
	// 컨텍스트 패스란?	클라이언트가 어떤 방식으로 요청을 했는지를 알아내는 것
	String path = request.getContextPath();
	out.println("컨텍스트 패스 = " + path + "<br>");
	// 2. 요청 방식을 알아내자.
	String method = request.getMethod();
	out.println("요청 방식 = " + method + "<br>");
	
	// 문제
	// 클라이언트가 번호를 알려주면 해당 번호에 대한 사용자 이름을 출력하는 문서를 만들자
	String[] names = {"지윤", "가윤", "현아", "지현", "소현", "지은", "고은", "지수", "혜연", "연주"};
	// 사용자가 번호를 알려주기로 약속했는데		?num=$
	// 클라이언트가 알려준 번호를 알아내자
	/* String strNum = request.getParameter("num");
	int num = Integer.parseInt(strNum); */
	
	/* Enumeration enm = request.getParameterNames();
	
	while(enm.hasMoreElements()){
		String key = (String)enm.nextElement();
		out.println(key + "<br>");
	} */
	
	String[] name = request.getParameterValues("num");
	for(int i = 0; i < name.length; i++) {
		int num = Integer.parseInt(name[i]);
		out.println("보고싶은 사람 = " + names[num] + "이군요 <br>");
	}
	
	// 데이터베이스 중에서보고싶은 게시물의 번호를 알려주면 그 게시물을 보여주는 것이다.
%>
<%--  당신이 선택한 사람은 <%= names[num] %> 입니다. --%>
</body>
</html>