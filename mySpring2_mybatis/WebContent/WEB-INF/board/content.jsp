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
				<td align="center" width="25%">${content.readcount+1}</td>
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
				<input type="button" value="�ۻ���" onclick="window.location='board_delete.do?num=${content.num}'">
				<input type="button" value="�ۼ���" onclick="window.location='board_update.do?num=${content.num}'">
				<input type="button" value="��Ϻ���" onclick="window.location='board_list.do'">
				</td>
			</tr>
		</table>
</html>