<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
					<h1 class="text-center">List Products  Order:${orderController.order.id }</h1>
				</div>
				<div class="modal-body">
					<h2>Products</h2>
					<form class="form col-md-12 center-block"></form>
				</div>
				<div class="modal-footer">
					<div class="col-md-12">
						<f:view>
							<div class="form-group">
								<h:form styleClass="form col-md-12 center-block">
									<table width="267">
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Price</th>
										</tr>
										<c:forEach var="product" items="#{orderController.products}">
											<tr>
												<td>${product.id }</td>
												<td>${product.name}</td>
												<td>${product.price}</td>
											</tr>
										</c:forEach>
									</table>
									</div>
									<div class="modal-footer">
										<div class="form-group">
											ID PRODUCT:
											<h:inputText value="#{orderLineController.id}"
												required="true" requiredMessage="id is mandatory" id="id" />
											<h:message for="id" />
										</div>
										<div class="form-group">
											Quantity:
											<h:inputText value="#{orderLineController.quantity}"
												required="true" requiredMessage="quantity is mandatory"
												id="quantity" />
											<h:message for="quantity" />
										</div>
										<div class="form-group">
											<h:commandButton value="Submit"
												action="#{orderLineController.createOrderLine}" >
											<f:param name="idOrder" value="#{orderController.id }" />
											</h:commandButton>
										</div>

									</div>

								</h:form>
							</div>
						</f:view>
					</div>
				</div>
			</div>
		</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>





