<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Registration form</h1>

	<frm:form modelAttribute="emp">
		<table border="0" bgcolor="cyan" align="center">
			<tr>
				<td>Employee No::</td>
				<td><frm:input path="eid" readonly="true" /></td>
			</tr>
			
			<tr>
				<td>Employee Name::</td>
				<td><frm:input path="ename" /></td>
			</tr>
			
			<tr>
				<td>Employee Salary::</td>
				<td><frm:input path="sal" /></td>
			</tr>
			<tr>
				<td>Employee Job::</td>
				<td><frm:input path="job" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="edit"></td>
			</tr>

		</table>




	</frm:form>
	
	<h2 style="color: red; text-align: center;" ><a href="./">Home</a></h2>
	



</body>
</html>