<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/myshop/mall/mall_top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<script type="text/javascript">
	function cartAdd(){
		check=confirm("��ٱ��Ͽ� �����ðڽ���?")
		if(check==true){
		document.f.action="mall_cartAdd.do";
		document.f.submit()
		}else{
		history.back();
		}
	}
	function order(){
		check=confirm("��ñ����Ͻðڽ���?")
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
	<tr class="m1" height="10%"><td colspan="2" align="center"><font color="green" size="4"><b>[${dto.pname}] ��ǰ����</b></font></td></tr>
	<tr class="m3" height="45%">
		<td width="50%" align="center" class="m3"><img src="${uppath}/${dto.pimage}" width="200" height="200"></td>
		<td class="m3">
			��ǰ��ȣ : ${dto.pnum}<br>
			��ǰ�̸� : ${dto.pname}<br>
			��ǰ���� : <font color="red"><b>${dto.price}</b></font>��<br>
			��ǰ����Ʈ : <font color="red"><b>[${dto.point}]</b></font>point<br>
			<form name="f" method="post">
			<input type="hidden" name="mode" value="2">
			<input type="hidden" name="key" value="${key}">
			<input type="hidden" name="pname" value="${dto.pname}">
			<input type="hidden" name="price" value="${dto.price}">
			<input type="hidden" name="pnum" value="${dto.pnum}">
			��ǰ���� : <input type="text" name="qty" value="1" maxlength="2" size="3">��<br><br>
			<a href="javascript:cartAdd();">��ٱ���</a> | <a href="javascript:order()">��ñ���</a>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="2" valign="top">
			<b>��ǰ �� ����</b><br>
			${dto.pcontents}
		</td>
	</tr>
</table>
</div>
<%@include file="/WEB-INF/myshop/mall/mall_bottom.jsp"%>