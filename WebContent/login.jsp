<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Gatto Imburrato</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/custom.css" rel="stylesheet">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
</head>


<body>
<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block">
            <div class="form-group">
            <f:view>
            <h:form>
					<p>Email <h:inputText value="#{customerController.email}" 
                     required="true"
                     requiredMessage="Email is mandatory"
                     id="email"/> <h:message for="email" />  </p>
              </h:form>          
            </div>
            <div class="form-group">
              <h:form>
					Password<h:inputText value="#{customerController.password}" 
                     required="true"
                     requiredMessage="Email is mandatory"
                     id="password"/> <h:message for="password"  />  
              </h:form> 
            </div>
            <div class="form-group">
            
              <button class="btn btn-primary btn-lg btn-block">Sign In</button>
              <span class="pull-right"><a href="#">Register</a>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
          <h:commandButton styleClass="btn"  value="Cancel" action="index.jsp" />
          </f:view>
		  </div>	
      </div>
  </div>
  </div>
</div>
	<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>

</html>