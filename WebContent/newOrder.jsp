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
<title>Login</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/custom.css" rel="stylesheet">

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Gatto-Imburrato-commerce</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
        <f:view>
          <ul class="nav navbar-nav">
            <li ><a href='<c:url value="/faces/index.jsp" />'>Home</a></li>
            <li><h:form>
					<h:commandLink styleClass="c-link" action="#{productController.listProducts}" value="List all Products" />
				</h:form></li>
			
			<c:if test="${customerController.customer.email == null}" >
							<li> <a href='<c:url value="/faces/login.jsp" />'>Login</a></li>
							</c:if>
							<c:if test="${customerController.customer.email != null}">
							<li><a href='<c:url value="/faces/customer.jsp" />'>${customerController.customer.firstname}</a></li>
							<li class="active"><a href='<c:url value="/faces/newOrder.jsp" />'> New Order</a></li>
						</c:if>

          </ul>
       
        </div><!--/.nav-collapse -->
      </div>
    </nav> <br /> <br /><br /> <br />
    <div class="container">
    
<h:form>
    <div>Email: <h:inputText value="#{customerController.email}"
                     required="true"
                     requiredMessage="Email is mandatory"
                     id="email"/> <h:message for="email"/>
	</div>
    <div>Password: <h:inputSecret value="#{customerController.password}"
                     required="true"
                     requiredMessage="Password is mandatory"
                     id="password"/> <h:message for="password" />
	</div>
    
	<div>
		<h:commandButton value="Submit"  action="#{customerController.loginCustomer}"/>
	</div>
	
</h:form>
</f:view>
    </div>
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>