<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<style type="text/css">
h1 {
	color: #ed424e;
	text-align: center;
	font-weight: bold;
	font-size: 50px;
	border: 2px solid black;
	margin-left: 180px;
	margin-right: 180px;
	background-color: black;
}

body {
	background-color: #b5aeb4;
}

.dotted-border {
	background-color: white;
	border: 6px double black;
}
</style>
</head>
<body>
	<h1>
		Welcome To User MVC Application
		<!-- &#128519 -->
	</h1>
	<div class="dotted-border">
		<ol>

			<!-- 
		<li>
			<h2>
				<a href="test">Click here to test configuration</a>
			</h2>
		</li>
		 -->

			<li>
				<h2>
					<a href="open-register">Click here to register the User</a>
				</h2>
			</li>
			<!--
			<li>
				<h2>
					<a href="open-phone">Click here to verify user by Phone &
						Password</a>
				</h2>
			</li>
			-->

			
			<li>
				<h2>
					<a href="open-updation">Click here to update the User</a>
				</h2>
			</li>

			<li>
				<h2>
					<a href="open-find">Click here to find user by Id</a>
				</h2>
			</li>

			<li>
				<h2>
					<a href="open-phone">Click here to verify user by Phone &
						Password</a>
				</h2>
			</li>

			<li>
				<h2>
					<a href="open-email">Click here to verify user by Email &
						Password</a>
				</h2>
			</li>

			<li>
				<h2>
					<a href="open-id">Click here to verify User by Id & Password</a>
				</h2>
			</li>

			<li>
				<h2>
					<a href="open-delete">Click here to delete User by Id</a>
				</h2>
			</li> 
		</ol>
	</div>


</body>
</html>