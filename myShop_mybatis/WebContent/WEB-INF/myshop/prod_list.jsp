<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/myshop/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("EUC-KR");%>
<script type="text/javascript">
	function checkDel(pnum,pimage){
		check=confirm("������ �����Ͻðڽ��ϱ�?")
		if(check==true){
		location.href("prod_delete.do?pnum="+pnum+"&pimage="+pimage)
		}else{
		location.href("prod_list.do")
		}
	}
</script>
<h5>��ǰ ���</h5>
<table border="1" width="800" class="outline">
	<tr bgcolor="yellow" height="10%">
		<th class="m2">��ȣ</th>
		<th class="m2">��ǰ�ڵ�</th>
		<th class="m2">��ǰ��</th>
		<th class="m2">�̹���</th>
		<th class="m2">����</th>
		<th class="m2">������</th>
		<th class="m2">����</th>
		<th class="m2">����/����</th>
	</tr>
	<c:if test="${prodList.size()==0}">
	<tr align="center">
		<td colspan="8" class="box"><font color="red">��ϵ� ��ǰ�� �����ϴ�.</font></td>
	</tr>
	</c:if>
	<c:if test="${prodList.size()!=0}">
		<c:forEach var="dto" items="${prodList}">
		<tr align="center">
			<td class="box">${dto.pnum}</td>
			<td class="box">${dto.pcategory_fk}</td>
			<td class="box">${dto.pname}</td>
			<td class="box"><a href="prod_view.do?pnum=${dto.pnum }"><img src="${upPath}/${dto.pimage}" width="60" height="60"></a></td>
			<td class="box">${dto.price}</td>
			<td class="box">${dto.pcompany}</td>
			<td class="box">${dto.pqty}</td>
			<td class="box">
			<a href="prod_update.do?pnum=${dto.pnum}">����</a> | 
			<a href="javascript:checkDel('${dto.pnum}','${dto.pimage}');">����</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
</table>
<%@ include file="/WEB-INF/myshop/bottom.jsp" %>
