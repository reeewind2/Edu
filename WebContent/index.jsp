<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<h1 style="text-align:center"> Hello World</h1>
	<%-- 설문조사 페이지로 하이퍼 링크 할 수 있도록 해준다. --%>
	<li><a href="http://localhost:8080/IDEAWeb/Member/LoginForm.jsp">로그잉</a></li>
	<li><a href="http://localhost:8080/IDEAWeb/Survey/SurveyList.jsp">설문조사 문항 보기</a></il>
	<li><a href="http://localhost:8080/IDEAWeb/Guest/GuestList.jsp">방명록</a></il>
	<li><a href="http://localhost:8080/IDEAWeb/Board/BoardList.bbs">댓글 게시판</a></li>
	</ul>
</body>
</html>