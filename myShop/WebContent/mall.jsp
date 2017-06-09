<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/myshop/mall/mall_top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<h3>Welcome to My Mall</h3>
<c:if test="${HIT.size()==0}">
	<h4><font color="red">HIT��ǰ�� �����ϴ�.</font></h4>
</c:if>
<c:if test="${HIT.size()!=0}">
		<hr color="green" width="600">
		<font color="red" size="5" face="����"><b>HIT</b></font>
		<hr color="green" width="600">
		<table width="600">
			<tr align="center">
			<c:forEach var="dto" items="${HIT}">
			<td align="center">
				<a href="mall_prodview.do?pspec=HIT&pnum=${dto.pnum}"><img src="${uppath}/${dto.pimage}" width="80" height="80"></a><br>
				${dto.pname}<br>
				<font color="red">${dto.price }</font>��<br>
				[${dto.point }] Point
			</c:forEach>
			</td>
			</tr>
		</table>
</c:if>
<c:if test="${NEW.size()==0}">
	<h4><font color="red">NEW��ǰ�� �����ϴ�.</font></h4>
</c:if>
<c:if test="${NEW.size()!=0}">
		<hr color="green" width="600">
		<font color="red" size="5" face="����"><b>NEW</b></font>
		<hr color="green" width="600">
		<table width="600">
			<tr align="center">
			<c:forEach var="dto" items="${NEW}">
			<td align="center">
				<a href="mall_prodview.do?pspec=NEW&pnum=${dto.pnum}"><img src="${uppath}/${dto.pimage}" width="80" height="80"></a><br>
				${dto.pname}<br>
				<font color="red">${dto.price }</font>��<br>
				[${dto.point }] Point
			</c:forEach>
			</td>
			</tr>
		</table>
</c:if>
<c:if test="${BEST.size()==0}">
	<h4><font color="red">BEST��ǰ�� �����ϴ�.</font></h4>
</c:if>
<c:if test="${BEST.size()!=0}">
		<hr color="green" width="600">
		<font color="red" size="5" face="����"><b>BEST</b></font>
		<hr color="green" width="600">
		<table width="600">
			<tr align="center">
			<c:forEach var="dto" items="${BEST}">
			<td align="center">
				<a href="mall_prodview.do?pspec=NEW&pnum=${dto.pnum}"><img src="${uppath}/${dto.pimage}" width="80" height="80"></a><br>
				${dto.pname}<br>
				<font color="red">${dto.price }</font>��<br>
				[${dto.point }] Point
			</c:forEach>
			</td>
			</tr>
		</table>
</c:if>
	<%@include file="/WEB-INF/myshop/mall/mall_bottom.jsp"%>