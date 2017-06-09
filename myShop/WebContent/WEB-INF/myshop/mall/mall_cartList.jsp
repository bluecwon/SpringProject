<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/myshop/mall/mall_top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table width="99%" border="1" align="center">
	<tr class="m2"> 
		<td colspan="6" align="center">
			<h4>��ٱ��� ����</h4>
		</td>
	</tr>
	<tr class="m1">
		<th width="10%">��ȣ</th>
		<th width="30%">��ǰ��</th>
		<th width="10%">����</th>
		<th width="20%">�ܰ�</th>
		<th width="20%">�ݾ�</th>
		<th width="10%">����</th>
	</tr>	
	<c:if test="${list.size()==0}">
	<tr>
		<td colspan="6">��ٱ��ϰ� ������ϴ�.</td>
	</tr>
	</c:if>
	<c:if test="${list.size()!=0}">
		<c:forEach var="dto" items="${list}">
	<tr>
		<td align="center">${dto.pnum}</td>
		<td align="center">
			<img src="${uppath}/${dto.pimage}" width="40" height="40"><br>
			<b>${dto.pname}</b>
		</td>
		<td align="center">
			<form name="f" method="post" action="mall_cartEdit.do">
				<br>
				<input type="text" size="3" name="pqty" value="${dto.pqty }">��
				<input type="hidden" name="pnum" value="${dto.pnum}">
				<input type="submit" value="����">
			</form>			
		</td>
		<td align="right">
			<b>${dto.price}��<br>
			[${dto.point}] point</b>
		</td>	
		<td align="right">
			<font color="red">
			<b>${dto.price*dto.pqty}��<br>
			[${dto.point*dto.pqty}] point</b>
			</font>
		</td>
		<td align="center">
			<a href="mall_cartDel.do?pnum=${dto.pnum}">����</a>	
		</td>
	</tr>
	</c:forEach>
	<tr class="m1">
		<td colspan="4"><b>��ٱ��� �Ѿ�</b> : 
			<font color="red">${cartTotalPrice}��<br></font>
			<font color="green">�� ���� ����Ʈ : [${cartTotalPoint}] point</font>	
		</td>
		<td colspan="2">
			<a href="mall_order.do">[�ֹ��ϱ�]</a>
			<a href="javascript:history.go(-2);">[��Ӽ���]</a>
		</td>
	</tr>	
</c:if>
</table>	
<%@include file="/WEB-INF/myshop/mall/mall_bottom.jsp"%>