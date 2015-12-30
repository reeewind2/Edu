<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, iedu.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
<%--
	목록 보기를 만들고
 --%>
 <%
 	//	모델이 알려준 데이터를 꺼낸다.
 	ArrayList		list = (ArrayList) request.getAttribute("DATA");
 	PageInfo		pInfo = (PageInfo) request.getAttribute("PINFO");
 //	모델에서 넘겨준 것이 무엇인가에 따라 받는 방식도 달라진다.
 //	즉		모델에서		session.setAttribute();	로 넘기면
 //			받을때도		session.getAttribute()로 받는다.
 %>
		<table border="1" width="80%" align="center">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
<%	
	for(int i = 0; i < list.size(); i++) {
		if (! list.isEmpty()) {
			
	
		HashMap	map = (HashMap) list.get(i);	
%>
			<tr>
				<td><%= map.get("NO") %></td>
				<td>
				<a href="../Board/BoardDetail.bbs?oriNO=<%= map.get("NO")%>"><%= map.get("TITLE") %></a>
				</td>
<%--
	GET 방식으로 요청할 때 파라메터		요청내용?키값=데이터&키값=데이터
 --%>				
				<td><%= map.get("ID") %></td>
				<td><%= map.get("DATE") %></td>
				<td><%= map.get("HIT") %></td>
			</tr>
<%
		}
	}
%>
 		</table>
<%--
	기타 부가적인 기능을 만든다.
	목록보기 상태에서 필요한 부가적인 기능은 글쓰기 단추를 만들어 주는 것이다.
 --%> 
		<table border="1" width="80%" align="center">
			<tr>
				<td align="center">
					<a href="../Board/BoardInsertForm.bbs">글쓰기</a>
				</td>
			</tr>
		</table>
<%-- 
	페이지 이동 기능 만들기
	[1][2][3][4][5][6][7]...
 --%>
 		<table	 border="1" width="80%" align="center">
 			<tr>
 				<td align="center">
<% 		
 		if(pInfo.startPage == 1) {
%>
 			[◀]
<%
 		}
 		else {
%>
 			[<a href="../Board/BoardList.bbs?nowPage=<%= pInfo.startPage - 1 %>">◀</a>]
<%
 		}				
		for(int i = pInfo.startPage; i <= pInfo.endPage; i++) {
			if(i == pInfo.nowPage) {				
%>
				[<%= i %>]
<%				
			}
			else {
%>				
				[<a href="../Board/BoardList.bbs?nowPage=<%= i %>"><%= i %></a>]
<%
			}	
		}
		if(pInfo.endPage == pInfo.totalPage) {
%>
				[▶]
<%
		}
		else {
%>		
 			[<a href="../Board/BoardList.bbs?nowPage=<%= pInfo.endPage + 1 %>">▶</a>]		
<%
		}
%>
				</td>
			</tr>
 		</table>
	</body>
</html>
