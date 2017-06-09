<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.writer.value==""){
			alert("작성자를 입력 해주세요!");
			f.writer.focus();
			return false;
		}
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
			alert("비밀번호를 입력 해주세요!");
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
<title>Insert Form</title>
</head>
<body>
	<div align="center">
		<hr color=green width="300">
		<font size="4"><b>글 쓰 기</b></font>
		<hr color=green width="300">
	</div>
		<table align="center" border="1" width="600">
			<form name="f" action="board_insert.do" method="post" onsubmit="return check()">
				<tr>
					<td class="m2">작성자</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td class="m2" width="20%">제목</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td class="m2">email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td class="m2">내용</td>
					<td><textarea name="content" rows="13" cols="65"></textarea></td>
				</tr>
				<!-- <tr>
					<td class="m2">파일</td>
					<td><input type="file" name="filename"></td>
				</tr> -->
				<tr>
					<td class="m2">비밀번호</td>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="javascript:listBoard();">
					</td>
				</tr>
			</form>
		</table>
</body>
</html>