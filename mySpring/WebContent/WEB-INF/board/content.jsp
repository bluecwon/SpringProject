<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<div align="center">
	<hr color=green width="300">
	<font size="4"><b>글내용 보기</b></font>
	<hr color=green width="300">
</div>
	<table align="center" border="1" width="600">
			<tr>
				<td class="m2" align="center" width="25%">글번호</td>
				<td align="center" width="25%">${content.num}</td>
				<td class="m2" align="center" width="25%">조회수</td>
				<td align="center" width="25%">${content.readcount}</td>
			</tr>
			<tr>
				<td class="m2" align="center" width="25%">작성자</td>
				<td align="center" width="25%">${content.writer}</td>
				<td class="m2" align="center" width="25%">작성일</td>
				<td align="center" width="25%">${content.reg_date}</td>
			</tr>
			<tr>
				<td class="m2" align="center" width="25%">글제목</td>
				<td align="center" colspan="3">${content.subject}</td>
			</tr>
			<tr>
				<td class="m2" align="center" width="25%">글내용</td>
				<td align="left" colspan="3">${content.content}</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
				<input type="button" value="글삭제">
				<input type="button" value="글수정">
				<input type="button" value="답글쓰기">
				<input type="button" value="목록보기">
				</td>
			</tr>
		</table>
</html>