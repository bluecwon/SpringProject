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
		<h1>메인 페이지</h1>
		<p>
		<c:if test="${sessionScope.dto.id!=null}">
		[${sessionScope.dto.name}]님 환영합니다<br>
			<a href="member_info.do">내정보확인</a>
			<a href="member_logout.do">로그아웃</a><br>
		</c:if>
		<c:if test="${sessionScope.dto.id=='admin'}">
		<br>
		[관리자님] 권한 : 
			<a href="member_list.do">전체회원보기</a>
		</c:if>
		<c:if test="${sessionScope.dto.id==null}">
			<a href="member_check_form.do">회원가입</a>
			<a href="member_login_form.do">로그인</a>
		</c:if>
	</div>
</body>
</html>