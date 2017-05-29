<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.id.value==""){
			alert("아이디를 입력하세요")
			f.id.focus()
			return
		}
		if(!f.name.value){
			alert("이름을 입력하세요")
			f.name.focus()
			return
		}
		if(!f.hp1.value||!f.hp2.value||!f.hp3.value){
			alert("전화 번호를 입력하세요")
			f.hp1.focus()
			return
		}
		document.f.submit()
	}
	</script>
<html>
<head>
	<title>비밀번호 찾기</title>
</head>
	<body>
		<form name="f" method="POST" action="member_find_pw.do">
			<table width="400" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">비밀번호 찾기</td>
 				</tr>
 				<tr>
					<td width="150" class="m3">아이디</td>
					<td class="m3">
						<input type="text" name="id" class="box">
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="name" class="box">
					</td>
				</tr>
  				<tr>
					<td width="150" class="m3">전화번호</td>
					<td class="m3">
						<input type="text" name="hp1" class="box" maxlength="3" size="4"> -
						<input type="text" name="hp2" class="box" maxlength="4" size="4"> - 
						<input type="text" name="hp3" class="box" maxlength="4" size="4">
					</td>
  				</tr>
  				<tr>
  					<td align="center" colspan="2">
						<a href="javascript:check()">[전송]</a>
						<a href="index.jsp">[취소]</a>
					</td>
  				</tr>
  			</table>
		</form>
	</body>
</html>