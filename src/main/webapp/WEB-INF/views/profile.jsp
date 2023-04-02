<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navbar -->
	<%@include file="navbar.jsp"%>
	<div class="container">
		<h1 class="mt-3">Profile</h1>
		<div>
			<p>Name: ${sessionScope.taxpayer.fname}
				${sessionScope.taxpayer.lname}</p>
			<p>Email: ${sessionScope.taxpayer.email}</p>
			<p>Gender: ${sessionScope.taxpayer.gender}</p>
			<p>
				Date of Birth:
				<fmt:formatDate value="${sessionScope.taxpayer.dob}"
					pattern="dd MMMM yyyy" />
			</p>
			<p>Phone: ${sessionScope.taxpayer.phone}</p>
		</div>
		<div>
			<h2>Tax Reports</h2>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">S. No.</th>
						<th scope="col">Year</th>
						<th scope="col">Province</th>
						<th scope="col">Total Tax</th>
						<th scope="col">Report Date</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="formCalculation" items="${formCalculations}"
						varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${formCalculation.form.year}</td>
							<td>${formCalculation.form.province}</td>
							<td><fmt:formatNumber
									value="${formCalculation.calculation.total_tax}"
									minFractionDigits="2" maxFractionDigits="2" /></td>
							<td><fmt:formatDate
									value="${formCalculation.form.tax_filing_date}"
									pattern="MM/dd/yyyy" /></td>
							<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/form/${formCalculation.form.form_id}">View
									Details</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>