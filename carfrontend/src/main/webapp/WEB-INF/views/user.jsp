<%@include file="navbar.jsp"%>
<!doctype html>
<html lang="en">
<head>
<title>register</title>
<link rel="stylesheet" href="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\css\bootstrap.min.css">
<script src="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\js"></script>
<c:url value="/resources/img" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>category</title>

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
<body  background="${img}/.jpg">
<div class="page">

</div>
<div class="container">
<c:url value="/User" var="user"/>
 <form:form action="${bs}" method="post" commandName="user">
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4"> 
<center>
<h1>register</h1>
</center>

 customer id:
<form:input type="text" path="uid" class="form-control" name="uid" placeholder="Enter user id"/>
user name:
<form:input type="text" path="uname" class="form-control" name="uname" placeholder="Enter user name"/>
password:
	<form:input path="password" type="password" class="form-control" name="password" placeholder="Enter password"/>
address:
	<form:input type="text" path="address" class="form-control" name="address" placeholder="Enter address"/>
email:
<form:input type="text" path="email" class="form-control" name="email" placeholder="Enter email"/>
phone:
<form:input type="number" path="phone" class="form-control" name="phone" placeholder="Enter phone number"/>



bid:
  <input type="text" path="b_id" calss="form-control" name="billing id" placeholder="Enter billing id">
  
bname:
  <input type="text" path="b_no" class="form-control" name="billing name" placeholder="enter billing name">
baddress:
  <input type="text" path="b_street" class="form-control" name="billing address" placeholder="enter billing address">
blocality:
  <input type="text" path="b_locality" class="form-control" name="billing locality" placeholder="enter billing locality">
bcity:
  <input type="text" path="b_city" class="form-control" name="billing city" placeholder="enter billing address">
bstate:
  <input type="text" path="b_state" class="form-control" name="billing state" placeholder="enter billing address">
bpincode:
  <input type="text" path="b_pincode" class="form-control" name="billing pincode" placeholder="enter billing address">
  <br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
	</div>
	</form:form>
 </body>
</html>