<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.name.value==""){
			alert("�̸��� �Է��ϼ���")
			f.name.focus()
			return
		}
		if(!f.ssn1.value){
			alert("�ֹε�� ��ȣ�� �Է��ϼ���")
			f.ssn1.focus()
			return
		}
		if(!f.ssn2.value){
			alert("�ֹε�� ��ȣ�� �Է��ϼ���")
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
	<title>���̵� ã��</title>
</head>
	<body>
		<form name="f" method="POST" action="member_find_id.do">
			<table width="400" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">���̵� ã��</td>
 				</tr>
				<tr>
					<td width="150" class="m3">�̸�</td>
					<td class="m3">
						<input type="text" name="name" class="box">
					</td>
				</tr>
  				<tr>
					<td width="150" class="m3">�ֹι�ȣ</td>
					<td class="m3">
						<input type="text" name="ssn1" class="box" maxlength="6" size="7"> -
					<input type="password" name="ssn2" class="box" maxlength="7" size="7">
					</td>
  				</tr>
				<tr>
  					<td align="center" colspan="2">
						<a href="javascript:check()">[����]</a>
						<a href="javascript:back()">[���]</a>
					</td>
  				</tr>
  			</table>
		</form>
	</body>
</html>