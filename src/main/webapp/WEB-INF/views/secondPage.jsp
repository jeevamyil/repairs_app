<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/resources/style/style.css" rel="stylesheet">
<title>Home page</title>
</head>
<body>
	<div class="divcls">
		<ul>

			<li class="logo"><h1 class=h1>
					<img src="/resources/images/logo.png" height="40" width="40">
				</h1></li>
			<li><h1 class=h1>Repairs</h1></li>
			<li class="loc"><h1 class=h1>Current location: ${location}
				</h1></li>
			<li class="mfloat"><h1 class=h1>
					<a href=/profile><img src="/resources/images/profile.png"
						height="40" width="40"></a>
				</h1></li>

		</ul>
	</div>
	<h2 id="title">Welcome ${name}</h2>


	<table id="tb3">
		<form action="menu" method="post">
			<tr>
				<td><label>Required Service:</label></td>
				<td><input type="text" name="techSkill" /></td>
			</tr>
			<tr>
				<td><label>Rate:</label></td>
				<td><input type="number" name="techRate" /></td>
			</tr>


			<tr>
				<td><input class="search" type="submit" value="Search"></td>
				<td><input class="clear" type="reset" value="Clear"></td>
			</tr>
		</form>

	</table>
	<div class="footerclass">
		<footer>
			<p>Copyright &copy; 2020</p>
		</footer>
	</div>

</body>
</html>