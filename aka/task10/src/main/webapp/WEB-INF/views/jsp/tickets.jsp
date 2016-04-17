<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Booking service</title>

  <%--<spring:url value="/resources/core/css/hello.css" var="coreCss" />--%>
  <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
  <link href="${bootstrapCss}" rel="stylesheet" />
  <%--<link href="${coreCss}" rel="stylesheet" />--%>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="index">Boocking service</a>
      <a class="navbar-brand" href="#">Tickets</a>
    </div>
  </div>
</nav>
<div class="jumbotron">
  <div class="container">
    <h1>Tickets list: </h1>
    <c:forEach items="${ticketsList}" var="ticket">
      ${ticket.user.firstName}  ${ticket.user.lastName}  ${ticket.movieName}<br>
    </c:forEach>
  </div>
</div>

<%--<spring:url value="/resources/core/js/bookingAjax.js" var="bookingAjax" />--%>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />

<%--<script src="${bookingAjax}"></script>--%>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>