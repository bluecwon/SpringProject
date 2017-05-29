<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.name.value==""){
			alert("이름을 입력 해주세요!");
			f.name.focus();
			return false;
		}
		if(f.ssn1.value==""){
			alert("주민등록번호를 입력 해주세요!");
			f.ssn1.focus();
			return false;
		}
		if(f.ssn2.value==""){
			alert("주민등록번호를 입력 해주세요!");
			f.ssn2.focus();
			return false;
		}
		return true;
	}
</script>
<html>
<head>
<title>SSN check</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>회 원 가 입 유 무</h2>
		<hr color="green" width="300">
		<form name="f" action="member_check.do" method="post" onsubmit="return check();">
			<table width="500" class="outline">
				<tr>
					<th>이름</th>
					<td align="left"><input type="text" name="name" class="box"></td>
				</tr>
				<tr>
					<th>주민등록번호</th>
					<td align="left"><input type="text" name="ssn1" class="box" maxlength="6"> - <input
						type="text" name="ssn2" class="box" maxlength="7"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"> <input
						type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>