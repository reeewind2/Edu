<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"" action="Result2.jsp">
	아 이 디 <input type="text" name="id">  <br><br>
	비밀번호 <input type="password" name="pwd"><br><br>
	이름 <input type="text" name="name"><br><br>
	<input type="radio" name="gender" value="M"> 남자 
	<input type="radio" name="gender" value="W"> 여자 <br><br>
	<input type="checkbox" name="hobby" value="음악감상"> 음악감상 <br>
	<input type="checkbox" name="hobby" value="독서"> 독서 <br>
	<input type="checkbox" name="hobby" value="여행"> 여행 <br>
	<input type="checkbox" name="hobby" value="게임"> 게임 <br>
	<input type="checkbox" name="hobby" value="낮잠"> 낮잠 <br><br>
	<select name="year">
	<% for(int i = 1900; i<2100; i++){
	%>
		<option value="<%= i %>" > <%= i %></option>	
	<%
	}
	%>
	</select>
	<select name="month">
	<% for(int i = 1; i<=12; i++){
	%>
		<option value="<%= i %>" > <%= i %></option>	
	<%
	}
	%>
	</select>
	<select name="day">
	<% for(int i = 1; i<=31; i++){
	%>
		<option value="<%= i %>" > <%= i %></option>	
	<%
	}
	%>
	</select> <br><br>
	
	<textarea name="area" rows="10" cols="50"></textarea>
	<input type="submit" value="전송">
	</form>
</body>
</html>