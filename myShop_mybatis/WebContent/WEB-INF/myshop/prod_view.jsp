<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/myshop/top.jsp" %>
<div align="center">
<table border="1" class="outline">
	<caption><b>��ǰ �� ����</b></caption>
	<tr>
		<td class="m2">ī�װ�</td>
		<td>${prodDTO.pcategory_fk}</td>
		<td class="m2">��ǰ��ȣ</td>
		<td>${prodDTO.pnum}</td>
	</tr>
	<tr>
		<td class="m2">��ǰ��</td>
		<td>${prodDTO.pname}</td>
		<td class="m2">����ȸ��</td>
		<td>${prodDTO.pcompany}</td>
	</tr>
	<tr>
		<td class="m2">��ǰ�̹���</td>
		<td colspan="3" align="center">
		<img src="${upPath}/${prodDTO.pimage}" width="100" height="100">
		</td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td>${prodDTO.pqty}</td>
		<td class="m2">��ǰ ����</td>
		<td>${prodDTO.price}</td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td>${prodDTO.pspec}</td>
		<td class="m2">��ǰ ����Ʈ</td>
		<td>${prodDTO.point}</td>
	</tr>
	<tr>
		<td class="m2">��ǰ �Ұ�</td>
		<td colspan="3"><textarea name="pcontents" rows="10" cols="60">${prodDTO.pcontents}</textarea></td>
	</tr>
	<form name="f" action="prod_list.do">
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="���ư���">
		</td>
	</tr>
	</form>
</table>
</div>
<%@ include file="/WEB-INF/myshop/bottom.jsp" %>