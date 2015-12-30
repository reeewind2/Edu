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
	<%-- 설문 조사 참여를 부탁하면 데이터베이스에 기록할 문서 --%>
<%
	// 할일
	//	1. 클라이언트가 어떤 항목을 선택했는지 알아낸다.
	String	dap = request.getParameter("dap");
	// 2. 이 항목을 데이터베이스에 UPDATE 한다.
	Connection	con = null;
	Statement	stmt = null;
	try{
		// 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 컨넥션
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.49:1521:orcl","scott", "tiger");
		// 스테이트먼트
		stmt = con.createStatement();
		// 질의실행
		String		sql = "UPDATE Survey SET " + dap + " = " + dap + " + 1";
		// 만약 1번 항목을 선택했으면...
		// UPDATE Survey SET s_dap1 = s_dap1 + 1;
		// 만약 2번 항목을 선택했으면...
		// UPDATE Survey SET s_dap2 = s_dap2 + 1;
		stmt.execute(sql);
	}
	catch(Exception e) {
		stmt.close();
		con.close();
	}
	// 3. 결과를 보여준다.
	// 아시다시피 등록한 결과는 보여줄 것이 없다.
	// 게시판 등록을 하면 등록 결과대신 목록 보기로 보여주는 원리와 같다.
	
	// 여기서도 마찬가지로 등록을 하면 다시 설문 조사 문항보기를 보여주고 싶다.
	response.sendRedirect("SurveyList.jsp");
	
%>

	
</body>
</html>