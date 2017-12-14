<%@include file="navbar.jsp"%>

<!DOCTYPE html>

<html>
<head>

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
 <body background="${img}/bmw1.jpg">
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<h1>CATEGORY</h1>
<c:url value="/Category" var="cat"/>
 <form:form action="${cat}" method="post" commandName="category">
    <div class="form-group">
      Category id:
	  <form:input type="text" path="cat_id" class="form-control" name="cid" placeholder="Enter cid"/>
    category name:
	<form:input type="text" path="cat_name" class="form-control" name="cname" placeholder="Enter cname"/>
	<br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
    </div>
	</div>
	</div>
	

	</form:form>
	<!-- -table-- -->
	<center>
	<table style="border:1px solid black">
	<tr style="background-color: #eee">
	<th style="border: 1px solid black">Category id</th>
	<th style="border: 1px solid black">Category name</th>
	<th colspan="2" style="border: 1px solid black">Edit/Delete</th>
	</tr>
	
	<center>
	<tbody>
	<c1:forEach items="${categorys}" var="category">
	<tr style="border: 1px solid black">
	<td style="border: 1px solid black">${category.getCat_id()}</td> 
	<td style="border: 1px solid black">${category.getCat_name()}</td>
	<td style="border: 1px solid black"><a href="<c1:url value="/editcategory/${category.getCat_id()}"/>" class="btn btn btn-info">edit</a></td>
	<td style="border: 1px solid black"><a href="<c1:url value="/deleteCategory/${category.getCat_id()}"/>" class="btn btn btn-danger">delete</a></td>
	</tr>
	</c1:forEach>
	</tbody>
	</center>
	</table>
	
</body>
</html>