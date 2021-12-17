<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>공지사항 목록</h1></div>
	<div>
		<table border="1">
			<tr>
				<th width="70">순번</th>
				<th width="150">작성자</th>
				<th width="250">제목</th>
				<th width="150">작성일자</th>
				<th width="70">조회수</th>
			</tr>
			<c:forEach items="${boards }" var="board">
				<tr onmouseover="this.style.background='#c3d0e1'" 
					onmouseout="this.style.background='white'"
					onclick="boardSearch('${board.no }')">
					<td align="center">${board.no }</td>
					<td align="center">${board.writer }</td>
					<td>${board.title }</td>
					<td align="center">${board.wdate }</td>
					<td align="center">${board.hit }</td>
				</tr>
			</c:forEach>
		</table>
	</div><br>
	<div>
		<form id="frm" action="boardSelect.do" method="post">
			<input type="hidden" id="no" name="no">
			<button type="button" onclick="location.href='home.do'">홈 가기</button>&nbsp;&nbsp;
			<button type="button" onclick="location.href='boardInsertForm.do'">글쓰기</button>
		</form>	
	</div>
</div>

<script type="text/javascript">
	function boardSearch(n) {
		frm.no.value = n;
		frm.submit();
	}
</script>
</body>
</html>