<%@include file="navbar.jsp"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<html>
<head>

<c:url value="/resources/img" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>payment</title>

<link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>

<script src="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\js"></script>

<style>
label{
color:red;
}
h2{
color:green;
}
</style>
</head>
 <body background="${img}/bmw1.jpg">
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<h1>PAYMENT</h1>

    <div class="form-group">
     payment id:
	  <form:input type="text" path="pay_id" class="form-control" name="pay_id" placeholder="Enter pay_id"/>
    paymentmethod:
	<form:input type="text" path="paymentmethod" class="form-control" name="paymentmethod" placeholder="Enter paymentmethod"/>
	paymentstatus:
	<form:input type="text" path="paymentstatus" class="form-control" name="paymentstatus" placeholder="Enter paymentstatus"/>
	<br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
    </div>
	</div>
	</div>
</body>
</html>