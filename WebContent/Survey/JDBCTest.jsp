<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 드라이버 로딩
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch(Exception e) {
		System.out.println("드라이버 로딩 실패");
	}
	// 컨넥션
	Connection	con = null;
	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.49:1521:orcl","scott", "tiger");
		System.out.println("접속 성공");
	}
	catch(Exception e) {
		System.out.println("접속 실패");
	}
	finally {
		try{
			con.close();
		}
		catch(Exception e) {}
	}
	
%>


</body>
</html>