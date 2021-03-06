<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Gatto Imburrato</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/custom.css" rel="stylesheet">

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
</head>


<body>
	<!--login modal-->
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href='<c:url value="/faces/index.jsp" />'>Gatto-Imburrato-commerce</a>
					</div>
				</div>
				</nav>
				<div class="modal-header">
					<h1 class="text-center">${addressController.address.street}</h1>
				</div>
				<div class="modal-body">
			<h2>Details</h2>
			<form class="form col-md-12 center-block"></form>
			</div>
			<div class="modal-footer">
				<div class="col-md-12">
					<form class="form col-md-12 center-block">
						<div class="form-group">City :
							${addressController.address.city}</div>
						<div class="form-group">State:
							${addressController.address.state}</div>
						<div class="form-group">Zip Code:
							${addressController.address.zipcode}</div>
						<div class="form-group">Country:
							${addressController.address.country}</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- script references -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
</f:view>