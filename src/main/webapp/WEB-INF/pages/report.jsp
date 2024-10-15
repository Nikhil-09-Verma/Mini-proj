<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report</title>
</head>
<body>
	

	<c:choose>
		<c:when test="${!empty empinfo }">
			<table bgcolor="cyan" align="center">
				<tr bgcolor="yellow">
					<th>EmpNO</th>
					<th>EmpName</th>
					<th>Job</th>
					<th>salary</th>
					<th>operations</th>

				</tr>
				<c:forEach var="emp" items="${empinfo }">
					<tr bgcolor="pink">
						<td>${emp.eid }</td>
						<td>${emp.ename }</td>
						<td>${emp.job }</td>
						<td>${emp.sal}</td>
						<td>
						<a href="edit?no=${emp.eid }">Edit</a>
						<a href="delete?no=${emp.eid }" onclick="return confirm('are you sure to delete')">delete</a>
						</td>
					</tr>


				</c:forEach>

			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center;">Record not found</h1>

		</c:otherwise>
	</c:choose>
	<h2 style="color: pink; text-align: center;">${resultMsg }</h2>
	<h1 style="color: red; text-align: center;"><a href="./">Home</a></h1>
	<br>
	<h1 style="color: red; text-align: center;"><a href="register">register</a></h1>
	
</body>
</html>