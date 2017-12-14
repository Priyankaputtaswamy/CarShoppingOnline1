<%@include file="navbar.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<c:url value="/resources/img" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
  <title>car</title>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
     margin auto;
 }
  </style>
</head>

<body background="${img}/wal1.jpg"> 
<body>

<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!---- Wrapper for slides ---->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${img}/bmw4.jpg"  width="1500" height="245">
      </div>
	 
      <div class="item">
        <img src="${img}/bmw5.jpg"  width="1600" height="245">
      </div>
    
      <div class="item">
        <img src="${img}/wal2.jpg"  width="1600" height="445">
      </div>

      <div class="item">
        <img src="${img}/wal3.jpg"  width="1600" height="445">
      </div>

      <div class="item">
        <img src="${img}/a80.jpg"  width="1600" height="445">
      </div>

      <div class="item">
        <img src="${img}/a81.jpg"  width="1600" height="445">
      </div>

      <div class="item">
        <img src="${img}/bmw1.jpg"  width="560" height="445">
      </div>
</div>

     

    <!---- Left and right controls ---->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>


<h1></h1>
<div class="row">
<div class="col-sm-4" >
<a href="<c:url value="/image1"/>"><img class="img-rounded"  src="${img}/benz1.jpg" width="200" height="200"/>
<h3> mercedes-benz</h3>
</div>
<div class="col-sm-4">
<a href="<c:url value="/image2"/>"><img class="img-circle" src="${img}/audi.jpg" width="200" height="200"/>
<h3>audi</h3>
</div>
<div class="col-sm-4">
<a href="<c:url value="/image3"/>"><img class="img-circle" src="${img}/bmw.jpg" width="250" height="200"/>
<h3>bmw</h3>
</div>
</div>




