<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@include file="navbar.jsp"%>
<!doctype html>
<html lang="en">
<head>
<body>

<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>

<title>product</title>
<link rel="stylesheet" href="${css}\bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>

<script src="C:\Users\priyanka\Desktop\bootstrap-3.3.7-dist\js"></script>

<style>
body{
background-repeat:no-repeat;
background-size:1500px 1000px;
}</style>
</head>


<%-- <body  background="${img}/a47.jpg"> --%>
<body>
<c:url value="/Product" var="prod"/>
<form:form action="${prod}" method="post" commandName="product" enctype="multipart/form-data">
<div class="container">
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<center>
<h1>product</h1>
</center>

    <center>

product id:
 <form:input type="text" path="p_id" class="form-control"  placeholder="Enter p_id"/>

 
 

product name:
<form:input type="text" path="p_name" class="form-control"  placeholder="Enter p_name"/>




product quantity:
	<form:input type="text" path="p_quantity" class="form-control"  placeholder="Enter p_quantity"/>
	
	
	
product price:
	<form:input type="text" path="p_price" class="form-control"  placeholder="Enter p_price"/>

	
	
product description: 
<form:input type="text" path="p_description" class="form-control"  placeholder="Enter p_description"/>



product image:
<form:input path="pimg" type="file" name="image" value="upload file"/>
</center>
  </div>
  </div>
  
  
  <br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
	
	
  </form:form>
	<!-- -table-- -->
	<center>
	<table style="border:1px solid black">
	<tr style="background-color: #eee">
	<th style="border: 1px solid black">Product id</th>
	<th style="border: 1px solid black">Product name</th>
	<th style="border: 1px solid black">Product quantity</th>
	<th style="border: 1px solid black">Product price</th>
	<th style="border: 1px solid black">Product description</th>
	<th style="border: 1px solid black">Product image</th>
	<th colspan="2" style="border: 1px solid black">Edit/Delete</th>
	</tr>
	
	<center>
	<tbody>
	<c1:forEach items="${products}" var="product">
	<tr style="border: 1px solid black">
	<td style="border: 1px solid black">${product.getP_id()}</td> 
	<td style="border: 1px solid black">${product.getP_name()}</td>
	<td style="border: 1px solid black">${product.getP_quantity()}</td>
	<td style="border: 1px solid black">${product.getP_price()}</td>
	<td style="border: 1px solid black">${product.getP_description()}</td>
	<td style="border: 1px solid black"><img src="<c:url value="resources/img/${product.getP_id()}.jpg"/>"></td>
	<td style="border: 1px solid black"><a href="<c1:url value="/editproduct/${product.getP_id()}"/>" class="btn btn btn-info">edit</a></td>
	<td style="border: 1px solid black"><a href="<c1:url value="/deleteproduct/${product.getP_id()}"/>" class="btn btn btn-danger">delete</a></td>
	</tr>
	</c1:forEach>
	</tbody>
	</center>
	</table>
 </body>
</html>