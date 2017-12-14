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
<form>
</div>

<div class="container">


<div class="row">
<div class="col-sm-4">
bid:
  <input type="text" path="b_id" class="form-control" name="billing id" placeholder="Enter billing id">
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
<div class="col-sm-4">
<h2>ADDRESS ORDER</h2>
</div>
<div class="col-sm-4"> 
sid:
  <input type="text" path="s_id" class="form-control" name="shipping id" placeholder="Enter shipping id">
  <label for="text">sname:</label>
  <input type="text" path="s_no" class="form-control" name="shipping name" placeholder="enter shipping name">
saddress:
  <input type="text" path="s_street" class="form-control" name="shipping address" placeholder="enter shipping address">
slocality:
  <input type="text" path="s_locality" class="form-control" name="shipping locality" placeholder="enter shipping locality">
scity:
  <input type="text" path="s_city" class="form-control" name="shipping city" placeholder="enter shipping address">
sstate:
  <input type="text" path="s_state" class="form-control" name="shipping state" placeholder="enter shipping address">
spincode:
  <input type="text" path="s_pincode" class="form-control" name="shipping pincode" placeholder="enter shipping address">
  <br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
</div>
</div>
</form>
</body>
</html>