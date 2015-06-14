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

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Gatto-Imburrato-commerce</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<f:view>
					<ul class="nav navbar-nav">
						<li><a href='<c:url value="/faces/index.jsp" />'>Home</a></li>
						<li><h:form>
								<h:commandLink styleClass="c-link"
									action="#{productController.listProducts}"
									value="List all Products" />
							</h:form></li>
						<c:if test="${customerController.customer.email == null}">
							<li><a href='<c:url value="/faces/login.jsp" />'>Login</a></li>
						</c:if>
						<c:if test="${customerController.customer.email != null}">
							<li class="active"><a
								href='<c:url value="/faces/customer.jsp" />'>${customerController.customer.firstname}</a></li>
							<li><h:form>
								<h:commandLink styleClass="c-link" value="New Order"  action="#{customerController.createOrder}">
								</h:commandLink>
							</h:form>	</li>
						</c:if>
						<c:if test="${customerController.email == '@administrator.it'}">
							<li ><a
								href='<c:url value="/faces/newProduct.jsp" />'>New Product</a></li>
						</c:if>

					</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container ">
	
		<h:form>
			<br />
			<br />
			<br />
			<br />
			<h:form styleClass="form col-md-12 center-block">
				<div class="form-group">Email:
					${customerController.customer.email}</div>
				<div class="form-group">Name:
					${customerController.customer.firstname}</div>
				<div class="form-group">Last name:
					${customerController.customer.lastname}</div>
				<div class="form-group">Date of birth:
					${customerController.customer.dateofbirth}</div>	
				<div class="form-group">Register data:
					${customerController.customer.registerdate}</div>
			</h:form>
	</div>
	</h:form>
	<div class="container">
		<h:form>
          <div class="form-group">
              Address: <h:commandLink action="#{addressController.findAddress }" 
              						  value="#{customerController.customer.address.street}">
              				<f:param name="id" value="#{customerController.customer.address.id}" />
              		   </h:commandLink>
            </div>
            <div class="from-group">
			<h:commandLink action="#{customerController.listOrders}" value="List all Orders" />
			
			<c:if test="${customerController.email == '@administrator.it'}">
			<br><br>
			<h:inputText value="#{orderController.id}"
					id="id" />
				<h:commandButton value="Retrieves"
					action="#{orderController.retrievesClient}" />
					</c:if>
			</div>
			<br><br>
			<div class="form-group">
			<h:commandButton value="Log Out"  action="#{customerController.logoutCustomer}"/>
			</div>
			
			
		</h:form>
	</div>
	</f:view>
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