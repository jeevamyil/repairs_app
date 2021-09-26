<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="/resources/style/style.css" rel="stylesheet">

<title>User Profile</title>
<script type="text/javascript">
	function show(shown, hidden) {
		document.getElementById(shown).style.display = 'block';
		document.getElementById(hidden).style.display = 'none';
		return false;
	}
</script>
</head>
<body id="body1">
	<nav>
		<a id="link2" href="#" onclick="return show('tb1','tb2')">Profile</a>
		<a id="link3" href="#" onclick="return show('tb2','tb1')">Edit</a>
	</nav>
	<div class="prfl" id="tb1">
		<ul id="prof">
			<li class="proff"><h1>Name: ${name}</h1></li>
			<li class="proff"><h1>Current location: ${location}</h1></li>
			<li class="proff"><h1>Contact Number: ${contact}</h1></li>
		</ul>

		<input id="sortbr" type="button" value="Delete account"
			onclick="location.href='/delete'">
		<!-- <input type="button" value="Edit" onclick="location.href='/edit'">-->
		<input id="sortbrd" type="button" value="Home"
			onclick="location.href='/secondPage'"> <input id="home1"
			type="button" value="Logout" onclick="location.href='/'">
		<h1 id="alert">${news}</h1>
	</div>


	<div class="prfl" id="tb2" style="display: none">
		<ul id="prof">
			<li class="proff"><h1>Name: ${name}</h1></li>
			<li class="proff"><h1>
					<f:form action="edit" modelAttribute="customerModel"
						onsubmit="return locValidate()" method="post">
						<tr>
							<td><label>Location:</label></td>
							<td><f:input type="text" path="customerLocation"
									id="location" /></td>
							<td><input type="submit" value="done"></td>
						</tr>
					</f:form>
				</h1></li>
			<li class="proff"><h1>Contact Number: ${contact}</h1></li>
		</ul>
		<input id="sortbr" type="button" value="Delete account"
			onclick="location.href='/delete'">
		<!--<input type="button" value="Edit" onclick="location.href='/edit'">  -->
		<input id="sortbrd" type="button" value="Home"
			onclick="location.href='/secondPage'">
	</div>
	<script src="/resources/js/script.js"></script>
	<div class="footerclass">
		<footer>
			<p>Copyright &copy; 2020</p>
		</footer>
	</div>

</body>
</html>