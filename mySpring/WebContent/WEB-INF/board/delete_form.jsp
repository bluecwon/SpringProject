<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
<title>Delete Form</title>
</head>
<body>
	<div align="center">
		<hr color=green width="300">
		<font size="4"><b>�� ����</b></font>
		<hr color=green width="300">
	</div>
		<table align="center" border="1" width="300">
		<form name="f" action="board_delete.do" method="post">
				<tr>
					<td class="m2" align="center">��й�ȣ�� �Է��� �ּ���.</td>
				</tr>
				<tr>
					<td align="center">��й�ȣ <input type="password" name="passwd">
					<input type="hidden" name="num" value="${param.num}">
					</td>
				</tr>
				<tr>
					<td class="m2" align="center">
					<input type="submit" value="�ۻ���">
					<input type="button" value="��Ϻ���" onclick="window.location='board_list.do'">
					</td>
				</tr>
			</form>
		</table>
</body>
</html>