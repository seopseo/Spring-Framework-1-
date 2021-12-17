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
	<div><h1>멤버 세부 정보</h1></div>
	<div>
		아이디 : ${member.id }<br>
		패스워드 : ${member.password}<br>
		이 름 : ${member.name }<br>
		전화번호 : ${member.tel }<br>
		주 소 : ${member.address }<br>
		권 한 : ${member.author }<br>		
	</div><br>
	<div>
		<button type="button" onclick="location.href='memberSelectList.do'">목록보기</button>
	</div>
</div>
</body>
</html>