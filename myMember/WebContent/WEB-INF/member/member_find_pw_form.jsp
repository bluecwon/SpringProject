<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.id.value==""){
			alert("���̵� �Է��ϼ���")
			f.id.focus()
			return
		}
		if(!f.name.value){
			alert("�̸��� �Է��ϼ���")
			f.name.focus()
			return
		}
		if(!f.hp1.value||!f.hp2.value||!f.hp3.value){
			alert("��ȭ ��ȣ�� �Է��ϼ���")
			f.hp1.focus()
			return
		}
		document.f.submit()
	}
	</script>
<html>
<head>
	<title>��й�ȣ ã��</title>
</head>
	<body>
		<form name="f" method="POST" action="member_find_pw.do">
			<table width="400" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">��й�ȣ ã��</td>
 				</tr>
 				<tr>
					<td width="150" class="m3">���̵�</td>
					<td class="m3">
						<input type="text" name="id" class="box">
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">�̸�</td>
					<td class="m3">
						<input type="text" name="name" class="box">
					</td>
				</tr>
  				<tr>
					<td width="150" class="m3">��ȭ��ȣ</td>
					<td class="m3">
						<input type="text" name="hp1" class="box" maxlength="3" size="4"> -
						<input type="text" name="hp2" class="box" maxlength="4" size="4"> - 
						<input type="text" name="hp3" class="box" maxlength="4" size="4">
					</td>
  				</tr>
  				<tr>
  					<td align="center" colspan="2">
						<a href="javascript:check()">[����]</a>
						<a href="index.jsp">[���]</a>
					</td>
  				</tr>
  			</table>
		</form>
	</body>
</html>