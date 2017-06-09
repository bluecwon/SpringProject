<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.subject.value==""){
			alert("제목을 입력 해주세요!");
			f.subject.focus();
			return false;
		}
		if(f.content.value==""){
			alert("내용을 입력 해주세요!");
			f.content.focus();
			return false;
		}
		if(f.passwd.value==""){
			alert("내용을 입력 해주세요!");
			f.passwd.focus();
			return false;
		}
		return true;
	}
	function listBoard(){
		location.href="board_list.do"
	}
</script>
<html>
<head>
<title>Update Form</title>
</head>
<body>

	<div align="center">
		<hr color=green width="300">
		<font size="4"><b>글 수 정</b></font>
		<hr color=green width="300">
	</div>
		<table align="center" border="1" width="600">
			<form name="f" action="board_update.do?num=${dto.num}" method="post" onsubmit="return check()">
				<tr>
					<td class="m2">작성자</td>
					<td><input type="text" name="writer" value="${dto.writer}" readonly></td>
					<input type="hidden" name="num" value="${dto.num}">
				</tr>
				<tr>
					<td class="m2" width="20%">제목</td>
					<td><input type="text" name="subject" value="${dto.subject}"></td>
				</tr>
				<tr>
					<td class="m2">email</td>
					<td><input type="text" name="email" value="${dto.email}"></td>
				</tr>
				<tr>
					<td class="m2">내용</td>
					<td><textarea name="content" rows="13" cols="65">${dto.content }</textarea></td>
				</tr>
				<tr>
					<td class="m2">비밀번호</td>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글수정" >
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="javascript:listBoard();">
					</td>
				</tr>
			</form>
		</table>
</body>
</html>