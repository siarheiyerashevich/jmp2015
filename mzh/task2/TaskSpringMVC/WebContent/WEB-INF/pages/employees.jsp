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
		<p>List employees</p>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<c:if test="${!empty employees}">
				<table border="2">
					<tr>
						<th>Last Name</th>
						<th>First Name</th>
						<th>Status</th>
						<th>Address</th>
						<th>Passport Number</th>
						<th>Driver License Number</th>
						<th>Unit</th>
						<th>Projects</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td><c:out value="${employee.lastName}" /></td>
							<td><c:out value="${employee.firstName}" /></td>
							<td><c:out value="${employee.status}" /></td>
							<td><c:out value="${employee.address.country}" /> <br /> <c:out
									value="${employee.address.city}" /></td>
							<td><c:out value="${employee.personalInfo.passportNumber}" /></td>
							<td><c:out
									value="${employee.personalInfo.driverLicenseNumber}" /></td>
							<td><c:out value="${employee.unit.name}" /></td>
							<td><c:forEach items="${employee.projects}" var="project">
									<c:out value="${project.name}" />
								</c:forEach></td>
							<td><a href="<c:url value='/employee/${employee.id}' />">Update</a></td>
							<td><a
								href="<c:url value='/employee/${employee.id}/remove' />">Remove</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<a href="<c:url value="/employee" />">Add</a>
			<a href="<c:url value="/files" />">Files</a>
			<a href="<c:url value="/units" />">Units</a>
			<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
		</c:if>
	</div>
</body>
</html>