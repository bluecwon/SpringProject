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
		<font size="4"><b>글 삭제</b></font>
		<hr color=green width="300">
	</div>
		<table align="center" border="1" width="300">
		<form name="f" action="board_delete.do" method="post">
				<tr>
					<td class="m2" align="center">비밀번호를 입력해 주세요.</td>
				</tr>
				<tr>
					<td align="center">비밀번호 <input type="password" name="passwd">
					<input type="hidden" name="num" value="${param.num}">
					</td>
				</tr>
				<tr>
					<td class="m2" align="center">
					<input type="submit" value="글삭제">
					<input type="button" value="목록보기" onclick="window.location='board_list.do'">
					</td>
				</tr>
			</form>
		</table>
</body>
</html>