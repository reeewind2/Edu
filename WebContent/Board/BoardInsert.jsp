<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
<%--	이 뷰는 등록한 결과를 보여주는 뷰이다. 
		지금까지도 그래왔듯이 등록 후에는 보여줄 내용이 없다.
		강제로 목록보기로 보내도록 하자.
--%>
<%
	response.sendRedirect("../Board/BoardList.bbs");
%>
	</body>
</html>