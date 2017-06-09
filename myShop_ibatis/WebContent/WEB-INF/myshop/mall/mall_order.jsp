<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/myshop/mall/mall_top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<table width="99%" border="1" align="center">
	<tr class="m2"> 
		<td colspan="3" align="center">
			<h4>결재 내역서 보기</h4>
		</td>
	</tr>
	<tr class="m1">
		<th width="50%">상품명</th>
		<th width="15%">수량</th>
		<th width="35%">금액</th>
	</tr>
	<c:if test="${mode==1}">
	<c:if test="${list.size()==0}">		
	<tr>
		<td colspan="3">결재 내역이 없습니다.</td>
	</tr>	
	</c:if>
	<c:if test="${list.size()!=0}">	
		<c:forEach var="dto" items="${list}">
		<tr>
			<td align="center">
				<b>${dto.pname}</b>
			</td>
			<td align="right">
				<b>${dto.pqty}개</b>
			</td>
			<td align="right">
			<b>${dto.price*dto.pqty}원<br>
			</td>	
		</tr>
		</c:forEach>
	<tr class="m1">
		<td align="center" colspan="3"><b>결재하실 총액은 : </b> : 
			<font color="red">${cartTotalPrice}원<br></font>	
		</td>
	</tr>
	</c:if>
	</c:if>
	<c:if test="${mode==2}">		
	<tr>
		<td align="center">
			<b>${pname}</b>
		</td>
		<td align="right">
			<b>${qty}개</b>
		</td>
		<td align="right">
		<b>${totalprice}원<br>
		</td>
	</tr>
	<tr class="m1">
		<td align="center" colspan="3"><b>결재하실 총액은 : </b> 
			<font color="red">${totalprice}원<br></font>	
		</td>
	</tr>
</c:if>
</table>
<%@include file="/WEB-INF/myshop/mall/mall_bottom.jsp"%>