<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/style/style.css" rel="stylesheet">
<title>FixApps</title>
</head>
<body id="bg">
	<h1 id="title">Repairs App</h1>
	<nav>
		<a id="link" href="/">Register</a> <a id="link1" href="/log">Login</a>
	</nav>
	<table id="tb2">
		<f:form action="logstatus" modelAttribute="customerModel"
			onsubmit="return loginValidate()">
			<tr>
				<td><label>User Name:</label></td>
				<td><f:input type="text" path="customerName" id="name" /></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><f:input type="password" path="customerPhone" id="number" /></td>
			</tr>
			<tr>
				<td><input class="search" type="submit" value="Login"></td>
				<td><input class="clear" type="reset" value="Clear"></td>
			</tr>
		</f:form>
	</table>
	<script src="/resources/js/script.js"></script>
	<div class="footerclass">
		<footer>
			<p>Copyright &copy; 2020</p>
		</footer>
	</div>
</body>
</html>