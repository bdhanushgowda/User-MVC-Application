<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verification</title>
<style type="text/css">
body {
	background-color: #b5aeb4;
}

.table {
	margin: auto;
	border: 2px solid black;
	height: 300px;
	width: 100px;
	border-radius: 5px;
	background-color: white;
	border: 6px double black;
	margin: auto;
}

form label {
	font-style: bold;
	color: black;
}

h1 {
	text-align: center;
	font-size: 50px;
	color: #f20c3a;
	font-weight: bold;
	border: 2px solid black;
	margin-left: 250px;
	margin-right: 250px;
	background-color: black;
}

form {
	font-size: 30px;
	font-style: bold;
}

form input {
	height: 30px;
	border-radius: 5px;
}

form button {
	background-color: #f71707;
	font-size: 24px;
	font-weight: bold;
	color: black;
}
</style>
</head>
<body>
	<h1>Verify Email & Password Form</h1>
	<form:form modelAttribute="u" method="post" action="id">
		<table class="table">
			<tr>
				<td><form:label path="id">Id:</form:label></td>
				<td><form:input path="id" /></td>
			</tr>

			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="2" colspan="2"
					style="text-align: center; margin: auto;"><form:button>Verify</form:button></td>
			</tr>


		</table>

	</form:form>
</body>
</html>