<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function check(){
		if(f.writer.value==""){
			alert("�ۼ��ڸ� �Է� ���ּ���!");
			f.writer.focus();
			return false;
		}
		if(f.subject.value==""){
			alert("������ �Է� ���ּ���!");
			f.subject.focus();
			return false;
		}
		if(f.content.value==""){
			alert("������ �Է� ���ּ���!");
			f.content.focus();
			return false;
		}
		if(f.passwd.value==""){
			alert("��й�ȣ�� �Է� ���ּ���!");
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
		<font size="4"><b>�� �� ��</b></font>
		<hr color=green width="300">
	</div>
		<table align="center" border="1" width="600">
			<form name="f" action="board_insert.do" method="post" onsubmit="return check()">
				<tr>
					<td class="m2">�ۼ���</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td class="m2" width="20%">����</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td class="m2">email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td class="m2">����</td>
					<td><textarea name="content" rows="13" cols="65"></textarea></td>
				</tr>
				<!-- <tr>
					<td class="m2">����</td>
					<td><input type="file" name="filename"></td>
				</tr> -->
				<tr>
					<td class="m2">��й�ȣ</td>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="�۾���">
					<input type="reset" value="�ٽ��ۼ�">
					<input type="button" value="��Ϻ���" onclick="javascript:listBoard();">
					</td>
				</tr>
			</form>
		</table>
</body>
</html>