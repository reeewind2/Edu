<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="Result.jsp">
		<select name="kind" size="3">
			<option value="소나타">소나타</option>
			<option value="제네시스">제네시스</option>
			<option value="포르쉐">포르쉐</option>
			<option value="부가티베이론">부가티베이론</option>
			<option value="롤스로이스">롤스로이스</option>
		</select><br>
		<textarea name="area" rows="10" cols="50"></textarea>
		<input type="submit" value="보내기">
	</form>
</body>
</html>