<%@include file="navbar.jsp"%>
<!doctype html>
<html>
<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>
<title>sign</title>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
<style>
label{
color:red;
}
h2{
color:green;
}

 
  <style>
 body{
  background-repeat:repeat;
  background-size:1400px 800px;
  }
  </style>
</head>
<body  background="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\img\wal1.jpg">
<div class="page">
<br>

</div>

 <link rel="stylesheet" href="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\css\bootstrap.min.css">
<script src="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\js"></script>
</head>
<body>
<center>
<h1>sign in!!</h1>
<div class="row">
<div class="col-sm-4">
</div>
<table>
<div class="col-sm-4">
<form:form action="/j_spring_security_check" method="post">

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="j_username">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="j_password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
</table>
</center>



