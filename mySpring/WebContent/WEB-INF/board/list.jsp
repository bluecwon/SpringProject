<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
	<title>spring게시판</title>
</head>
<body>
	<div align="center">
	<h1>게시판 리스트</h1>
	<table border="1" class="outline" width="600">
		<tr class="m2">
			<th>번호</th>
			<th>제목</th>
			<th>등록자</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="dto" items="${boardList}">
			<tr>
				<td align="center">${dto.num}</td>
				<td align="center"><a href="board_content.do?num=${dto.num}">${dto.subject}</a></td>
				<td align="center">${dto.writer}</td>
				<td align="center">${dto.reg_date}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="right"><a href="insert_form.do">글쓰기</a></td>
		</tr>
	</table>
	</div>
	
</body>
</html>