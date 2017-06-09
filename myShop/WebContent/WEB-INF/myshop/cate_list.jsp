<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/myshop/top.jsp" %>
<% request.setCharacterEncoding("EUC-KR"); %>
<h5>카테고리 목록</h5>
<table border="1" width="400" class="outline">
	<tr bgcolor="yellow" height="10%">
		<th class="m2">번호</th>
		<th class="m2">카테고리코드</th>
		<th class="m2">카테고리명</th>
		<th class="m2">삭제</th>
	</tr>
	<c:if test="${cateList.size()==0 }">
	<tr align="center">
		<td colspan="4" class="box"><font color="red">등록된 카테고리가 없습니다.</font></td>
	</tr>
	</c:if>
	<c:if test="${cateList.size()!=0 }">
	<c:forEach var="dto" items="${cateList }">
	<tr align="center">
		<td class="box">${dto.cnum}</td>
		<td class="box">${dto.code}</td>
		<td class="box">${dto.cname}</td>
		<td class="box"><a href="cate_delete.do?cnum=${dto.cnum }">삭제</a></td>
	</tr>
	</c:forEach>
	</c:if>
</table>
<%@ include file="/WEB-INF/myshop/bottom.jsp" %>