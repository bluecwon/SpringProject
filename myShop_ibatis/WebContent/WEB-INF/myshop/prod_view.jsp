<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/myshop/top.jsp" %>
<div align="center">
<table border="1" class="outline">
	<caption><b>상품 상세 보기</b></caption>
	<tr>
		<td class="m2">카테고리</td>
		<td>${prodDTO.pcategory_fk}</td>
		<td class="m2">상품번호</td>
		<td>${prodDTO.pnum}</td>
	</tr>
	<tr>
		<td class="m2">상품명</td>
		<td>${prodDTO.pname}</td>
		<td class="m2">제조회사</td>
		<td>${prodDTO.pcompany}</td>
	</tr>
	<tr>
		<td class="m2">상품이미지</td>
		<td colspan="3" align="center">
		<img src="${upPath}/${prodDTO.pimage}" width="100" height="100">
		</td>
	</tr>
	<tr>
		<td class="m2">상품 수량</td>
		<td>${prodDTO.pqty}</td>
		<td class="m2">상품 가격</td>
		<td>${prodDTO.price}</td>
	</tr>
	<tr>
		<td class="m2">상품 스펙</td>
		<td>${prodDTO.pspec}</td>
		<td class="m2">상품 포인트</td>
		<td>${prodDTO.point}</td>
	</tr>
	<tr>
		<td class="m2">상품 소개</td>
		<td colspan="3"><textarea name="pcontents" rows="10" cols="60">${prodDTO.pcontents}</textarea></td>
	</tr>
	<form name="f" action="prod_list.do">
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="돌아가기">
		</td>
	</tr>
	</form>
</table>
</div>
<%@ include file="/WEB-INF/myshop/bottom.jsp" %>