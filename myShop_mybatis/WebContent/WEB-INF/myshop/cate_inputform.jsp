<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/myshop/top.jsp" %>
	<form name="f" action="cate_input.do" method="post">
	<h5>ī�װ� ���</h5>
	<table border="1" class="outline">
		<tr>
			<td bgcolor="yellow">ī�װ� �ڵ�</td>
			<td><input type="text" name="code"></td>
		</tr>
		<tr>
			<td bgcolor="yellow">ī�װ� �̸�</td>
			<td><input type="text" name="cname"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" class="m2">
				<input type="submit" value="���">
				<input type="reset" value="���">
			</td>
		</tr>
	</table>
	</form>
<%@ include file="/WEB-INF/myshop/bottom.jsp" %>