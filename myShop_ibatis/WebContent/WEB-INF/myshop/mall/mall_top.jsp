<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<link rel="stylesheet" type="text/css" href="style.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
	<title>홈페이지</title>
</head>
<body>
	<div align="center">
	<table border="1" width="800" height="600">
		<tr height="10%">
			<td colspan="2" align="center">
			<a href="">HOME</a> |
			<a href="main.jsp">관리자홈</a> |
			<a href="mall.do">쇼핑몰홈</a> |
			<a href="mall_cartList.do">장바구니</a> |
			<a href="">회사소개</a>
			</td>
		</tr>
		<tr>
			<td align="center" valign="top" width="20%"><b>Tree/view</b><br>
				<table border="1">
				 <c:if test="${cateList.size()!=0}">
				 	<c:forEach var="dto" items="${cateList}">
						<tr>
							<td><a href="mall_cgprodlist.do?cate=${dto.code}">${dto.cname}[${dto.code}]</a></td>
						</tr>
					</c:forEach>
				</c:if>
				</table>
			</td>
			<td align="center" width="80%">
				