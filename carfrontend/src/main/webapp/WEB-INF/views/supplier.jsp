
<%@include file="navbar.jsp"%>
<!doctype html>
<html lang="en">
<head>


<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>


<title>supplier</title>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>

<script src="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\js"></script>
<style>
body{
background-repeat:no-repeat;
background-size:1500px 1000px;
}</style>
</head>
<body  background="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\img\a44.jpg">
<div class="row">
<div class="col-sm-4">
</div>

<center>
<div class="col-sm-4">
<h1>SUPPLIER</h1>
<c:url value="/Supplier" var="sup"/>
 <form:form action="${sup}" method="post" commandName="supplier">
 <center><i style="font-size:90px" class="fa">&#xf2bd;</i></center>
 <form>
    <div class="form-group">
  
  sid:
  <form:input type="text" path="sid" class="form-control"/>
 
  
    sname:
  <form:input type="text" path="sname" class="form-control"  placeholder="Enter sname"/>
  
  
    address:
  <form:input type="text" path="address" class="form-control"  placeholder="Enter address"/>
  
  </div>
  </div>
 </div>
  <br>
<center><button id="button" class="btn btn-success" type="submit">submit</button></center>
	
	</br>
	
  </center>
  
  </form:form>

	<!-- -table-- -->
	<center>
	<table style="border:1px solid black">
	<tr style="background-color: #eee">
	<th style="border: 1px solid black">Supplier id</th>
	<th style="border: 1px solid black">Supplier name</th>
	<th style="border: 1px solid black">Supplier address</th>
	<th colspan="2" style="border: 1px solid black">Edit/Delete</th>
	</tr>
	
	<center>
	<tbody>
	<c1:forEach items="${suppliers}" var="supplier">
	<tr style="border: 1px solid black">
	<td style="border: 1px solid black">${supplier.getSid()}</td> 
	<td style="border: 1px solid black">${supplier.getSname()}</td>
	<td style="border: 1px solid black">${supplier.getAddress()}</td>
	
	<td style="border: 1px solid black"><a href="<c1:url value="/editsupplier/${supplier.getSid()}"/>" class="btn btn btn-info">edit</a></td>
	<td style="border: 1px solid black"><a href="<c1:url value="/deleteSupplier/${supplier.getSid()}"/>" class="btn btn btn-danger">delete</a></td>
	</tr>
	</c1:forEach>
	</tbody>
	</center>
	</table>
</body>
</html>