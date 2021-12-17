<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>게시글 상세 조회</h1></div>
	<div>
		<table border="1">
			<tr>
				<th width="100">작성자</th>
				<td width="150" align="center">${board.writer }</td>
				<th width="100">작성일자</th>
				<td width="150" align="center">${board.wdate }</td>
				<th width="100">조회수</th>
				<td width="50" align="center">${board.hit }</td>
			</tr>
			<tr>
				<th width="100">제목</th>
				<td colspan="5">${board.title }</td>
			</tr>
			<tr>
				<th width="100">내용</th>
				<td colspan="5">
					<textarea rows="10" cols="90">${board.title }</textarea>
				</td>
			</tr>
		</table>
	</div><br>
	<div>
		<button type="button" onclick="location.href=''">글수정</button>&nbsp;&nbsp;
		<button type="button" onclick="history.go(-1)">목록보기</button>
	</div>
	
</div>
</body>
</html>