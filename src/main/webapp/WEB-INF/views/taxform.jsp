<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tax Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navbar -->
	<%@include file="navbar.jsp"%>

	<div class="container mt-3" style="width: 75%">
		<h1>Tax Form</h1>
		<form class="row g-3"
			action="${pageContext.request.contextPath}/taxform" method="POST">
			<div class="col-md-6">
				<input type="hidden" class="form-control" id="taxpayer_id"
					name="taxpayer_id" value=${sessionScope.taxpayer.taxpayer_id}>
			</div>
			<div class="col-md-12">
				<label for="year" class="form-label">Year</label> <select
					name="year" id="year" class="form-select mb-3">
					<option value="2022">2022</option>
					<option value="2023">2023</option>
				</select>
			</div>
			<div class="col-md-12">
				<label for="address" class="form-label">Address</label> <input
					type="text" class="form-control" id="address" name="address">
			</div>
			<div class="col-md-6">
				<label for="city" class="form-label">City</label> <input type="text"
					class="form-control" id="city" name="city">
			</div>
			<div class="col-md-6">
				<label for="province" class="form-label">Province </label> <select
					name="province" id="province" class="form-select mb-3">
					<option value="ON">Ontario</option>
					<option value="AB">Alberta</option>
					<option value="BC">British Columbia</option>
					<option value="NB">New Brunswick</option>
					<option value="MB">Manitoba</option>
					<option value="NL">Newfoundland and Labrador</option>
					<option value="NS">Nova Scotia</option>
					<option value="PE">Prince Edward Island</option>
					<option value="QC">Quebec</option>
					<option value="SK">Saskatchewan</option>
					<option value="NT">Northwest Territories</option>
					<option value="NU">Nunavut</option>
					<option value="YT">Yukon</option>
				</select>
			</div>
			<div class="col-md-6">
				<label for="postalcode" class="form-label">Postal code</label> <input
					type="text" class="form-control" id="postalcode" name="postalcode">
			</div>
			<div class="col-md-6">
				<label for="martial_status" class="form-label">Martial
					status</label> <select name="martial_status" id="martial_status"
					class="form-select mb-3">
					<option value="Single">Single</option>
					<option value="Married">Married</option>
					<option value="Widowed">Widowed</option>
					<option value="Separated">Separated</option>
					<option value="Divorced">Divorced</option>
				</select>
			</div>
			<div class="col-md-6">
				<label for="employment_income" class="form-label">Employment
					income</label> <input type="text" class="form-control"
					id="employment_income" name="employment_income">
			</div>
			<div class="col-md-6">
				<label for="other_income" class="form-label">Other income</label> <input
					type="text" class="form-control" id="other_income"
					name="other_income">
			</div>
			<div class="col-md-12">
				<label for="capital_gains_losses" class="form-label">Capital
					gains or losses</label> <input type="text" class="form-control"
					id="capital_gains_losses" name="capital_gains_losses"> <small
					class="text-primary">Please enter income in negative if you
					incurred loss</small>
			</div>
			<div class="col-md-6">
				<label for="income_taxes_paid" class="form-label">Income
					taxes paid</label> <input type="text" class="form-control"
					id="income_taxes_paid" name="income_taxes_paid">
			</div>
			<div class="col-md-6">
				<label for="total_rrsp" class="form-label">Total RRSP</label> <input
					type="text" class="form-control" id="total_rrsp" name="total_rrsp">
			</div>
			<div class="col-md-4 mb-3">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>

		</form>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>