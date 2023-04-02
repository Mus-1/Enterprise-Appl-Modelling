<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tax Calculator</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navbar -->
	<%@include file="navbar.jsp"%>

	<div class="container mt-3">
		<h1>Report Details</h1>
		<hr>
		<div class="row ">
			<div class="col-md-12">
				<p>
					Report Generation Date:
					<fmt:formatDate value="${taxform.tax_filing_date}"
						pattern="dd MMMM yyyy" />
				</p>
			</div>
			<div class="col-md-12">
				<p class="fw-bold">Year: ${taxform.year}</p>
				<p class="mb-0">${taxform.address}</p>
				<p class="mb-0">${taxform.city},${taxform.province}</p>
				<p class="mb=0">${taxform.postalcode}</p>
			</div>
			<div class="col-md-4">
				<p class="mb-0">
					Employment Income:
					<fmt:formatNumber value="${taxform.employment_income}"
						minFractionDigits="2" maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Other Income:
					<fmt:formatNumber value="${taxform.other_income}"
						minFractionDigits="2" maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Capital Gains or Losses:
					<fmt:formatNumber value="${taxform.capital_gains_losses}"
						minFractionDigits="2" maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Canada Pension Plan (CPP):
					<fmt:formatNumber value="${taxform.cpp}" minFractionDigits="2"
						maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Employment Insurance (EI):
					<fmt:formatNumber value="${taxform.ei}" minFractionDigits="2"
						maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Total RRSP:
					<fmt:formatNumber value="${taxform.total_rrsp}"
						minFractionDigits="2" maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Income taxes already paid:
					<fmt:formatNumber value="${taxform.capital_gains_losses}"
						minFractionDigits="2" maxFractionDigits="2" />
				</p>
			</div>
			<div class="col-md-4">
				<p class="mb-0">
					Estimated Provincial Tax:
					<fmt:formatNumber value="${taxCalculation.provincial_tax}"
						minFractionDigits="2" maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Estimated Federal Tax:
					<fmt:formatNumber value="${taxCalculation.federal_tax}"
						minFractionDigits="2" maxFractionDigits="2" />
				</p>
				<p class="mb-0">
					Total Tax to be paid:
					<fmt:formatNumber value="${taxCalculation.total_tax}"
						minFractionDigits="2" maxFractionDigits="2" />
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