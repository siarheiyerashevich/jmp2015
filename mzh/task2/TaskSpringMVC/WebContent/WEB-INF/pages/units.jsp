<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<div>
		<p>List units</p>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<c:if test="${!empty units}">
				<table border="2">
					<tr>
						<th>Unit Name</th>
						<th></th>
					</tr>
					<c:forEach items="${units}" var="unit">
						<tr>
							<td><c:out value="${unit.name}" /></td>
							<td><a href="<c:url value='/unit/${unit.id}/remove' />">Remove</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<a href="<c:url value="/employees" />">Employees</a>
			<a href="<c:url value="/files" />">Files</a>
			<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
		</c:if>
	</div>
</body>
</html>