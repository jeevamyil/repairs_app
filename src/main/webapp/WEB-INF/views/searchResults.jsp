<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/style/style.css" rel="stylesheet">
<title>Results</title>
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

	<div id="container">
		<div id="content">
			<h1 id="title">Available Technicians</h1>
			<!--  add our html table here -->
			<input id="sortbr" type="button" value="Sort by Customer Rating"
				onclick="location.href='/sortbyrating'"> <input id="home"
				type="button" value="Home" onclick="location.href='/secondPage'">
			<input id="sortbrd" type="button" value="Sort by Rate/day"
				onclick="location.href='/sortbyrate'">
			<table id="tb4">
				<tr>

					<th class="th4">TechnicianName</th>
					<th class="th4">TechnicianRating</th>
					<th class="th4">Skill</th>
					<th class="th4">Location</th>
					<th class="th4">Rate</th>
				</tr>
				<!-- loop over and print our packages -->
				<c:forEach var="pack" items="${lis}">
					<tr>

						<td class="td4">${pack.technicianName}</td>
						<td class="td4">${pack.technicianRating}</td>
						<td class="td4">${pack.technicianSkill}</td>
						<td class="td4">${pack.technicianLocation}</td>
						<td class="td4">${pack.technicianPay}</td>
						<td class="td4" class="cen"><a id="request"
							href="/request?technicianName=<c:out value="${pack.technicianName}"/>">
								Request </a></td>

					</tr>
				</c:forEach>
				<h1 id="alert">${alert}</h1>
			</table>
		</div>
	</div>
	<div class="footerclass">
		<footer>
			<p>Copyright &copy; 2020</p>
		</footer>
	</div>
</body>
</html>