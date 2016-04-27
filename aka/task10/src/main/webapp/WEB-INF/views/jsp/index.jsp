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
            <a class="navbar-brand" href="#">Boocking service</a>
            <a class="navbar-brand" href="tickets">Tickets</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>Movies list: </h1>
            <c:forEach items="${movieList}" var="movie">
                ${movie.movieName}  ${movie.movieStartDateString}  ${movie.movieEndDateString}<br>
            </c:forEach>

    </div>
</div>

<div class="container">

    <div class="row">
        <div class="col-md-2">
            <p>
                <a class="btn btn-default" href="2016-04-18" role="button">Monday 18.04.2016</a>
            </p>

        </div>
        <div class="col-md-2">
            <p>
                <a class="btn btn-default" href="2016-04-19" role="button">Tuesday 19.04.2016</a>
            </p>
        </div>
        <div class="col-md-2">
            <p>
                <a class="btn btn-default" href="2016-04-20" role="button">Wednesday 20.04.2016</a>
            </p>
        </div>
        <div class="col-md-2">
            <p>
                <a class="btn btn-default" href="2016-04-21" role="button">Thursday 21.04.2016</a>
            </p>
        </div>
        <div class="col-md-2">
            <p>
                <a class="btn btn-default" href="2016-04-22" role="button">Friday 22.04.2016</a>
            </p>
        </div>
        <div class="col-md-2">
            <p>
                <a class="btn btn-default" href="2016-04-23" role="button">Saturday 23.04.2016</a>
            </p>
        </div>

    </div>
    <div class="row">
        <c:if test="${showParticularDay}">
            <div class="col-md-4">
                First Name:   <input type="text" id="firstName" name="firstName"> <br>
                Last Name:    <input type="text" id="lastName" name="lastName"> <br>
                Place Number: <input type="number" id="place" name="place"> <br>
            </div>

            <div class="col-md-8">
                <br>
                <c:forEach items="${movieResponse}" var="movie">
                    <div class="col-md-6">
                            ${movie.movieName}
                    </div>
                    <div class="col-md-6">
                        <a class="btn btn-default" href="#" onclick="buyTicket('${movie.movieName};17:00')" role="button">17:00-cost:15$</a>
                        <a class="btn btn-default" href="#" onclick="buyTicket('${movie.movieName};19:00')" role="button">19:00-cost:15$</a> <br>
                    </div>
                </c:forEach>
            </div>

        </c:if>
    </div>
    <div class="row">
        <div class="col-md-8">
            <div id="buyTicketResponse"></div>
        </div>
    </div>
</div>

<spring:url value="/resources/core/js/bookingAjax.js" var="bookingAjax" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />

<script src="${bookingAjax}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>