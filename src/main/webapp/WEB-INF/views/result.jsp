<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Estimated Tax</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container mt-3">
		<!-- Navbar -->
		<h1>Tax Calculation</h1>
		<div class="card" style="width: 40%">
			<h5 class="card-header">Estimated Tax Calculation</h5>
			<div class="card-body">
				<p class="card-text">
					Provincial Tax: $
					<fmt:formatNumber value="${taxCalculation.provincial_tax}"
						pattern="#.##" />
				</p>
				<p class="card-text">
					Federal Tax: $
					<fmt:formatNumber value="${taxCalculation.federal_tax}"
						pattern="#.##" />
				</p>
				<p class="card-text">
					Total Tax to be paid: $
					<fmt:formatNumber value="${taxCalculation.total_tax}"
						pattern="#.##" />
				</p>
			</div>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>