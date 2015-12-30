<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	border-style : dashed;
	border-width : 1.5px;
	border-color : darkgray;
}
 tr, td {
	border-style : solid;
	border-width : 1.5px;
	border-color : lightgray;
	
}
</style>
</head>
<body>

<%
	// 웹은 우리가 제작할 때는 하이퍼 링크를 이용해서 접근하도록 해놓았다.
	// 하지만 검색 결과등을 이용할 경우에는 직접 주소를 치고 들어오는 경우도 존재한다.
	// 이 경우에는 사용자의 상태가 원하지 않는 상태일 수도 있다.
	// 예>	로그인을 해야만 방명록을 이용할 수 있는데 
	// 이 페이지를 사용할 수 있는 권한이 있는지를 매번 점검 해주어야 한다.
	
	String id = (String) session.getAttribute("ID");
	if(id == null || id.length() == 0) {
		response.sendRedirect("../Member/LoginForm.jsp");
	}

%>
<%-- 
		아시다시피 방명록을 먼저 현재까지 방명록 내용을 보여주고
		마지막 부분에 방명록을 쓸수 있는 폼을 보여주는 형식을 취한다.
 --%>
 
 <%--
	 	방명록 내용보기
  --%>
<%
	// 방명록 내용을 보려면 방명록을 셀렉트한 결과를 얻어와야 한다.
	GuestDao		dao = new GuestDao();
	ArrayList		list = dao.getGuest();
	dao.close();
%>
<%
	for(int i = 0; i < list.size(); i++) {
		HashMap	map = (HashMap) list.get(i);
%>
		<table width="75%" border="1" align="center">
			<tr>
				<td width="10%">글번호</td>
				<td width="90%"><%= map.get("NO") %></td>
			</tr>
			
			<tr>
				<td width="10%">글쓴이</td>
				<td width="90%"><%= map.get("WRITER") %></td>
			</tr>
			
			<tr>
				<td width="10%">날짜</td>
				<td width="90%"><%= map.get("DATE") %></td>
			</tr>
			
			<tr>
				<td width="10%">본문</td>
				<td width="90%"><%= map.get("CONTENT") %></td><br>
			</tr>
		</table>
<%
	}
%>
 <%--
	 	방명록 글쓰기 폼
  --%>
  
  	<form method="POST" action="GuestInsert.jsp">
  		<table border="1" width="75%" align="center">
  			<tr>
  				<td width="10%">글쓴이</td>
  				<td width="90%">
  					<input type="text" disabled value="<%= session.getAttribute("ID") %>">
  				</td>
  			</tr>
  			
  			<tr>
  				<td width="10%">본문</td>
  				<td width="90%">
  					<textarea  name="body" rows="5" cols="75"></textarea>
  				</td>
  			</tr>
  			
  			<tr>
  				<td colspan="2" align="center">
  					<input type="submit" value="방명록 작성">
  				</td><br>
  			</tr>
  		</table>
  	</form>
</body>
</html>