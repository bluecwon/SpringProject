<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- index.jsp -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>member management</title>
</head>
<body>
	<div align="center">
		<h1>���� ������</h1>
		<p>
		<c:if test="${sessionScope.dto.id!=null}">
		[${sessionScope.dto.name}]�� ȯ���մϴ�<br>
			<a href="member_info.do">������Ȯ��</a>
			<a href="member_logout.do">�α׾ƿ�</a><br>
		</c:if>
		<c:if test="${sessionScope.dto.id=='admin'}">
		<br>
		[�����ڴ�] ���� : 
			<a href="member_list.do">��üȸ������</a>
		</c:if>
		<c:if test="${sessionScope.dto.id==null}">
			<a href="member_check_form.do">ȸ������</a>
			<a href="member_login_form.do">�α���</a>
		</c:if>
	</div>
</body>
</html>