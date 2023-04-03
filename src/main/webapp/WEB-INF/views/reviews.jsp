<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reviews</title>
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
		<h1>Reviews</h1>
		<button class="btn btn-primary" id="add-review-btn">Add a
			Review</button>

		<form action="reviews" id="review-form" style="display: none;"
			method="POST">
			<input type="hidden" name="taxpayer_id"
				value="${sessionScope.taxpayer.taxpayer_id}"> <label
				for="title" class="form-label mt-3">Title:</label> <input
				class="form-control" type="text" name="title" id="title"> <label
				for="description" class="form-label">Description:</label>
			<textarea name="description" class="form-control" id="description"
				col="10" rows="4"></textarea>
			<button type="submit" class="btn btn-primary mt-3">Submit</button>
		</form>
		<hr>
		<c:forEach var="r" items="${reviewTaxpayerMap}" varStatus="status">
			<div class="row">
				<div class="col-md-12">
					<p class="text-primary fw-bold">${r.value.fname} ${r.value.lname}</p>
					<h6>${r.key.title}</h6>
				</div>
				<div class="col-md-12">
					<p>${r.key.description}</p>
				</div>
			</div>
			<hr>
		</c:forEach>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<script>
	document.querySelector('#add-review-btn').addEventListener('click',
			function() {
				document.getElementById('review-form').style.display = 'block';
			});
</script>
</html>