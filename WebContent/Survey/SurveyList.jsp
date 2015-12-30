<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border-style : dashed;
	border-color : lightpink;
	border-width : 1.5px;
}
</style>
<script>
 function send() {
	 var frm = document.getElementById("frm");
	 frm.submit();
 }
</script>
</head>
<body>
<%-- 설문조사 문항보기 페이지 --%>
	<form method="post" action="SurveyInsert.jsp" id="frm">
	<table width="70%" border="1" align="center">
		<tr>
			<td colspan="2" align="center">
			크리스마스를 같이 보내고 싶은 사람은 누구인가?
			</td>
		</tr>
		<tr>
			<td>1. <input type="radio" name="dap" value="s_dap1" checked></td>
			<td>전지윤</td>
		</tr>
		<tr>
			<td>2. <input type="radio" name="dap" value="s_dap2"></td>
			<td>심으뜸</td>
		</tr>
		<tr>
			<td>3. <input type="radio" name="dap" value="s_dap3"></td>
			<td>이지은</td>
		</tr>
		<tr>
			<td>4. <input type="radio" name="dap" value="s_dap4"></td>
			<td>빌리</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<a href="JavaScript:send()">참여하기</a>
			<!-- <input type="submit" value="설문 참여하기"> -->
<%--
	우리가 만든 모든 페이지는 하이퍼 링크 방식으로 사용자가 접근할 수 있도록 준비를 해주어야 한다.
	주소를 치고 들어가야 하는 문제는 없어야 한다. 
 --%>
 		<a href="SurveyResult.jsp">결과보기</a>
			</td>
		</tr>
	</table>
</form>

</body>
</html>