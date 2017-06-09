<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/myshop/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
<table border="1" class="outline">
<form name="prodin" action="prod_update.do" method="post" enctype="multipart/form-data">
	<tr>
		<td class="m2">ī�װ�</td>
			<td><input type="text" name="pcategory_fk" value="${prodDTO.pcategory_fk}" readonly></td>
	</tr>
	<tr>
		<td class="m2">��ǰ��ȣ</td>
		<td>${prodDTO.pnum}<input type="hidden" name="pnum" value="${prodDTO.pnum}"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ��</td>
		<td><input type="text" name="pname" value="${prodDTO.pname}"></td>
	</tr>
	<tr>
		<td class="m2">����ȸ��</td>
		<td><input type="text" name="pcompany" value="${prodDTO.pcompany}"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ�̹���</td>
		<td>
		<img src="${upPath}/${prodDTO.pimage}" width="60" height="60">
		<input type="hidden" name="pimage1" value="${prodDTO.pimage}">
		<input type="file" name="pimage">
		</td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td><input type="text" name="pqty" value="${prodDTO.pqty}"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td><input type="text" name="price" value="${prodDTO.price}"></td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����</td>
		<td>
		<select name="pspec">
			<c:forEach var="i" items="${spec}">
				<c:if test="${prodDTO.pspec == i}">
					<option value="${i}" selected/> ::${i}::
				</c:if>
				<c:if test="${prodDTO.pspec != i}">
					<option value="${i}"/> ::${i}::
				</c:if>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td class="m2">��ǰ �Ұ�</td>
		<td><textarea name="pcontents" rows="10" cols="60">${prodDTO.pcontents}</textarea></td>
	</tr>
	<tr>
		<td class="m2">��ǰ ����Ʈ</td>
		<td><input type="text" name="point" value="${prodDTO.point}"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="���� ����">
			<input type="reset" value="���">
		</td>
	</tr>
	</form>
</table>
</div>
<%@ include file="/WEB-INF/myshop/bottom.jsp" %>