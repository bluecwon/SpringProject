<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function loginCheck(){
		if(f.id.value==""){
			alert("아이디를 입력하세요")
			f.id.focus()
			return
		}
		if(!f.passwd.value){
			alert("비밀번호를 입력하세요")
			f.passwd.focus()
			return
		}
		document.f.submit()
	}
</script>
<html>
<head>
	<title>Login Page</title>
</head>
<body>
<div align="center">
		<hr color=green width="300">
		<font size="4"><b>로 그 인</b></font>
		<hr color=green width="300">
</div>
<form name="f" action="member_login.do" method="post" >
	<table width="400" class="outline" border="1" align="center">
		<tr>
			<td class="m2" width="20%">아이디 : </td>
			<td><input name="id" type="text"></td>
			<td rowspan="2" valign="middle" align="left"><input type="button" value="로그인" onclick="javascript:loginCheck();"></td>
		</tr>
		<tr>
			<td class="m2" width="20%">패스워드 : </td>
			<td><input name="passwd" type="password"></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="button" value="회원가입" onclick="window.location='member_check_form.do'">
				<input type="button" value="아이디찾기" onclick="window.location='member_find_id_form.do'">
				<input type="button" value="비밀번호찾기" onclick="window.location='member_find_pw_form.do'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>