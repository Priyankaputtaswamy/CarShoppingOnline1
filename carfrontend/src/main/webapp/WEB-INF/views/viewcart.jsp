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
<table>
<thread>
<tr>
<th></th>
<th>cart iten id</th>
<th>product name</th>
<th>description</th>
<th>price</th>
<th>quantity</th>
<th colspan="2">BUY/REMOVE</th>
</tr>
</thread>
<tbody>
<c1:forEach items="${viewcart}" var="cit">
<tr>
<td><img src="<c:url" value="resourses/images/${cit.getP_id()}.jpg"/>"></td>
<td></td>
<td>${view.getP_name()}</td>
<td>${view.getP_description()}</td>
<td>${view.getP_price()}</td>
<td>${view.getP_quantity()}</td>
<td><a href="<c:url value="/addtocart/${view.getP_id()"/>" class="btn btn-info"> BUY</td>
<td><a href="<c:url value="/Remove/${view.getP_id()"/>" class="btn btn-info" >REMOVE</a></td>
</tr>
</c1:forEach>
</tbody>
</table>
