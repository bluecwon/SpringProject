<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
<title>������ Ȯ��</title>
</head>
<body>
<body>
	<div align="center">
	<h1>������ Ȯ��</h1>
	<table border="1" class="outline" width="600">
		<tr class="m2">
			<th>��ȣ</th>
			<th>���̵�</th>
			<th>�̸�</th>
			<th>�̸���</th>
			<th>��ȭ��ȣ</th>
			<th>������</th>
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
				<a href="member_update_form.do">�� ��������</a> | 
				<a href="index.jsp">�ڷ�</a>
			</td>
		</tr>
	</table>
	</div>
	
</body>
</body>
</html>