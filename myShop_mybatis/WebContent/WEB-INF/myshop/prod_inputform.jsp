<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/myshop/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
<table border="1" class="outline">
<form name="prodin" action="prod_input.do" method="post" enctype="multipart/form-data">
	<tr>
		<td class="m2">ī�װ�</td>
		<td>
			<select name="categorycode">
				<c:forEach var="dto" items="${cateList}">
				<option value="${dto.code}"/>${dto.cname} [${dto.code}]
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td class="m2">��ǰ��</td>
		<td><input type="text" name="pname"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ�ڵ�</td>
		<td><input type="text" name="productcode"></td>
	</tr>
	<tr>
		<td class="m2">����ȸ��</td>
		<td><input type="text" name="pcompany"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ�̹���</td>
		<td><input type="file" name="pimage"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td><input type="text" name="pqty"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td><input type="text" name="price"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td>
		<select name="pspec">
			<option value="NORMAL"> ::NORMAL::
			<option value="HIT"> ::HIT::
			<option value="BEST"> ::BEST::
			<option value="NEW"> ::NEW::
		</select>
		</td>
	</tr>
	<tr>
		<td class="m2">��ǰ �Ұ�</td>
		<td><textarea name="pcontents" rows="5" cols="60"></textarea></td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����Ʈ</td>
		<td><input type="text" name="point"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="��ǰ ���">
			<input type="reset" value="���">
		</td>
	</tr>
	</form>
</table>
</div>
<%@ include file="/WEB-INF/myshop/bottom.jsp" %>