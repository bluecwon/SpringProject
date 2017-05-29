<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR"); %>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
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
	<title>정보 수정 페이지</title>
</head>
	<body>
		<form name="f" method="POST" action="member_update.do">
		<input type="hidden" name="no" value="${sessionScope.dto.no}">
			<table width="600" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">정보 수정</td>
 				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="name" class="box" value="${sessionScope.dto.name}" readonly>
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">아이디</td>
					<td class="m3">
						<input type="text" name="id" class="box" value="${sessionScope.dto.id}" readonly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">기존 비밀번호</td>
					<td class="m3">
						<input type="password" name="oldpasswd" class="box">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">새 비밀번호</td>
					<td class="m3">
						<input type="password" name="passwd" class="box">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">주민번호</td>
					<td class="m3">
						<input type="text" name="ssn1" class="box" value="${sessionScope.dto.ssn1}" readonly> -
				<input type="password" name="ssn2" class="box" value="${sessionScope.dto.ssn2}" readonly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">이메일</td>
					<td class="m3">
						<input type="text" name="email" class="box" value="${sessionScope.dto.email}">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">연락처</td>
					<td class="m3">
						<input type="text" name="hp1" class="box" size="3" maxlength="3" value="${sessionScope.dto.hp1}"> -
						<input type="text" name="hp2" class="box" size="4" maxlength="4" value="${sessionScope.dto.hp2}"> -
						<input type="text" name="hp3" class="box" size="4" maxlength="4" value="${sessionScope.dto.hp3}">
					</td>
  				</tr>
  				<tr>
					<td colspan="2" align="center">
						<a href="javascript:check()">[전송]</a>
						<a href="index.jsp">[취소]</a>
					</td>
  				</tr>
  			</table>
		</form>
	</body>
</html>