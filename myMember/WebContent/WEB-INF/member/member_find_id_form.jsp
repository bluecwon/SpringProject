<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.name.value==""){
			alert("이름을 입력하세요")
			f.name.focus()
			return
		}
		if(!f.ssn1.value){
			alert("주민등록 번호를 입력하세요")
			f.ssn1.focus()
			return
		}
		if(!f.ssn2.value){
			alert("주민등록 번호를 입력하세요")
			f.ssn2.focus()
			return
		}
		document.f.submit()
	}
	function back(){
		history.back();
	}
	</script>
<html>
<head>
	<title>아이디 찾기</title>
</head>
	<body>
		<form name="f" method="POST" action="member_find_id.do">
			<table width="400" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">아이디 찾기</td>
 				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="name" class="box">
					</td>
				</tr>
  				<tr>
					<td width="150" class="m3">주민번호</td>
					<td class="m3">
						<input type="text" name="ssn1" class="box" maxlength="6" size="7"> -
					<input type="password" name="ssn2" class="box" maxlength="7" size="7">
					</td>
  				</tr>
				<tr>
  					<td align="center" colspan="2">
						<a href="javascript:check()">[전송]</a>
						<a href="javascript:back()">[취소]</a>
					</td>
  				</tr>
  			</table>
		</form>
	</body>
</html>