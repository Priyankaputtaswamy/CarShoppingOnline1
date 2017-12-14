<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>car</title>
</head>
<body>

<!-- navbar -->
<div class="container-fluid">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
	  </div>
	  <ul class="nav navbar-nav">
	  
      <li class="active"><a href="<c:url value="/home"/>">Home</a></li>
      <li><a href="<c:url value="/about"/>">about us</a></li>
      <li><a href="<c:url value="/contact"/>">contact us</a></li>
     <c1:if test="${pageContext.request.userPrincipal.name!=null}">
	  <security:authorize access="hasRole('ROLE_ADMIN')"> 
	  <li><a href="<c:url value="/product"/>">product</a></li>
	  <li><a href="<c:url value="/category"/>">category</a></li>
	  <li><a href="<c:url value="/supplier"/>">supplier</a></li>
 	  </security:authorize> 
	  </c1:if>
	  <li><a href="<c:url value="/bs"/>">bssss</a></li>
	  <li><a href="<c:url value="/table"/>">table</a></li>
	 <li><a href="<c:url value="/viewcart"/>">viewcart</a></li>
	  </ul>
	  <ul class="nav navbar-nav pull-right">
     
     <c1:if test="${pageContext.request.userPrincipal.name==null}">
	   <li><a href="<c:url value="/user"/>">register</a></li>
<li><a href="<c:url value="/sign"/>">sign in</a></li>
</c1:if>
<c1:if test="${pageContext.request.userPrincipal.name!=null}">
     welcome ${pageContext.request.userPrincipal.name}
     </c1:if>
    </ul>
  </div>
</nav>

</body>
</html>