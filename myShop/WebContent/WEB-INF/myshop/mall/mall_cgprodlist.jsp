<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/myshop/mall/mall_top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<h3>Welcome to My Mall</h3>
	<c:if test="${list.size()==0}">
		<h4><font color="red">관련상품이 없습니다.</font></h4>
	</c:if>
	<c:if test="${list.size()!=0}">
		<hr color="green" width="600">
		<font color="red" size="5" face="굴림"><b>${cname}</b></font>
		<hr color="green" width="600">
		<table width="600">
		<tr align="center">
	
		<c:forEach var="pdto" items="${list}">
			<td align="center">
				<a href="mall_prodview.do?pnum=${pdto.pnum}&cate=${cate}"><img src="${uppath}/${pdto.pimage}" width="80" height="80"></a><br>
				${pdto.pname}<br>
				<font color="red">${pdto.price}</font>원<br>
				[${pdto.point}] Point
			</td>
		</c:forEach>
	</table>
	</c:if>
	