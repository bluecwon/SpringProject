<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/myshop/mall/mall_top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<script type="text/javascript">
	function cartAdd(){
		check=confirm("장바구니에 담으시겠습까?")
		if(check==true){
		document.f.action="mall_cartAdd.do";
		document.f.submit()
		}else{
		history.back();
		}
	}
	function order(){
		check=confirm("즉시구매하시겠습까?")
		if(check==true){
		document.f.action="mall_order.do";
		document.f.submit()
		}else{
		history.back();
		}
	}
</script>
<div align="center">
<table width="600" height="400" class="outline">
	<tr class="m1" height="10%"><td colspan="2" align="center"><font color="green" size="4"><b>[${dto.pname}] 상품정보</b></font></td></tr>
	<tr class="m3" height="45%">
		<td width="50%" align="center" class="m3"><img src="${uppath}/${dto.pimage}" width="200" height="200"></td>
		<td class="m3">
			상품번호 : ${dto.pnum}<br>
			상품이름 : ${dto.pname}<br>
			상품가격 : <font color="red"><b>${dto.price}</b></font>원<br>
			상품포인트 : <font color="red"><b>[${dto.point}]</b></font>point<br>
			<form name="f" method="post">
			<input type="hidden" name="mode" value="2">
			<input type="hidden" name="key" value="${key}">
			<input type="hidden" name="pname" value="${dto.pname}">
			<input type="hidden" name="price" value="${dto.price}">
			<input type="hidden" name="pnum" value="${dto.pnum}">
			상품갯수 : <input type="text" name="qty" value="1" maxlength="2" size="3">개<br><br>
			<a href="javascript:cartAdd();">장바구니</a> | <a href="javascript:order()">즉시구매</a>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="2" valign="top">
			<b>상품 상세 설명</b><br>
			${dto.pcontents}
		</td>
	</tr>
</table>
</div>
<%@include file="/WEB-INF/myshop/mall/mall_bottom.jsp"%>