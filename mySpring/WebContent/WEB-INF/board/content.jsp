<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<div align="center">
	<hr color=green width="300">
	<font size="4"><b>�۳��� ����</b></font>
	<hr color=green width="300">
</div>
	<table align="center" border="1" width="600">
			<tr>
				<td class="m2" align="center" width="25%">�۹�ȣ</td>
				<td align="center" width="25%">${content.num}</td>
				<td class="m2" align="center" width="25%">��ȸ��</td>
				<td align="center" width="25%">${content.readcount}</td>
			</tr>
			<tr>
				<td class="m2" align="center" width="25%">�ۼ���</td>
				<td align="center" width="25%">${content.writer}</td>
				<td class="m2" align="center" width="25%">�ۼ���</td>
				<td align="center" width="25%">${content.reg_date}</td>
			</tr>
			<tr>
				<td class="m2" align="center" width="25%">������</td>
				<td align="center" colspan="3">${content.subject}</td>
			</tr>
			<tr>
				<td class="m2" align="center" width="25%">�۳���</td>
				<td align="left" colspan="3">${content.content}</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
				<input type="button" value="�ۻ���">
				<input type="button" value="�ۼ���">
				<input type="button" value="��۾���">
				<input type="button" value="��Ϻ���">
				</td>
			</tr>
		</table>
</html>