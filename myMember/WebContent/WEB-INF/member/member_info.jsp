<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
<title>내정보 확인</title>
</head>
<body>
<body>
	<div align="center">
	<h1>내정보 확인</h1>
	<table border="1" class="outline" width="600">
		<tr class="m2">
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>가입일</th>
		</tr>
		<tr>
			<td align="center">${dto.no}</td>
			<td align="center">${dto.id}</td>
			<td align="center">${dto.name}</td>
			<td align="center">${dto.email}</td>
			<td align="center">${dto.hp1}-${dto.hp2}-${dto.hp3}</td>
			<td align="center">${dto.joindate}</td>
		</tr>
		<tr>
			<td colspan="6" align="right">
				<a href="member_update_form.do">내 정보수정</a> | 
				<a href="index.jsp">뒤로</a>
			</td>
		</tr>
	</table>
	</div>
	
</body>
</body>
</html>