<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.name.value==""){
			alert("�̸��� �Է� ���ּ���!");
			f.name.focus();
			return false;
		}
		if(f.ssn1.value==""){
			alert("�ֹε�Ϲ�ȣ�� �Է� ���ּ���!");
			f.ssn1.focus();
			return false;
		}
		if(f.ssn2.value==""){
			alert("�ֹε�Ϲ�ȣ�� �Է� ���ּ���!");
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
		<h2>ȸ �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<form name="f" action="member_check.do" method="post" onsubmit="return check();">
			<table width="500" class="outline">
				<tr>
					<th>�̸�</th>
					<td align="left"><input type="text" name="name" class="box"></td>
				</tr>
				<tr>
					<th>�ֹε�Ϲ�ȣ</th>
					<td align="left"><input type="text" name="ssn1" class="box" maxlength="6"> - <input
						type="text" name="ssn2" class="box" maxlength="7"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Ȯ��"> <input
						type="reset" value="���"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>