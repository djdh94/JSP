<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/MyFirstWeb/boardUpdate" method="post">
	<input type="hidden" name="board_num" value="${board.board_num }">
	글제목 : <input type="text" name="title" value="${board.title }">
	글쓴이 : <input type="text" value="${board.writer }" readonly>
	조회수 : ${board.hit }<br/>
	쓴날짜 : <input type="text" value="${board.bdate }" readonly>
	마지막 수정날짜 : ${board.mdate }<br/>
	본문 : <textarea rows="15" cols="50" name="content">${board.content }</textarea><br/>
	<input type="submit" value="수정"/>
	</form>
	
</body>
</html>