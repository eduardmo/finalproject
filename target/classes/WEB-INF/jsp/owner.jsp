<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/customerValidation.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/myCSS.css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Management</title>
</head>
<body>


	<div class="container">
		<a class="btn btn-info" href="logout">Logout</a>
		<h1>Subsidiaries</h1>
		<!--Search Form -->
		<form:form action="owner.get" method="get" id="seachPatientForm"
			modelAttribute="subsidiary">
			<div class="form-group col-xs-5">
				<form:input type="text" path="subsidiaryName" class="form-control"
					required="true" value="" />
			</div>
			<input type="submit" class="btn btn-info" name="action"
				value="Search" />
			<input type="submit" class="btn btn-info" name="action"
				value="Show All" />
			<br></br>
			<br></br>
		</form:form>
		<a href="owner/add" class="btn btn-info">Add Subsidiary</a>

		<c:choose>
			<c:when test="${not empty subsidiaryList}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Subsidiary ID</td>
							<td>Subsidiary Name</td>
							<td>Subsidiary Profits</td>
							<td>Subsidiary Manager PNC</td>
							<td>Action</td>
						</tr>
					</thead>
					<c:forEach var="subsl" items="${subsidiaryList}">
						<c:set var="classSucess" value="" />
						<form:form action="owner.action" method="post"
							id="seachPatientForm" modelAttribute="subsidiary">
							<tr class="${classSucess}">
								<td><form:input path="subsidiaryID"
										value="${subsl.subsidiaryID}" readonly="true"
										cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
								<td><form:input path="subsidiaryName"
										value="${subsl.subsidiaryName}" readonly="true"
										cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
								<td><form:input path="subsidiaryProfits"
										value="${subsl.subsidiaryProfits}" readonly="true"
										cssStyle="border:0px; width:100px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
								<td><form:input path="subsidiaryManagerPNC"
										value="${subsl.subsidiaryManagerPNC}" readonly="true"
										cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);"></form:input></td>
								<td><a
									href="owner/update?subsidiaryID=${subsl.subsidiaryID}"
									class="btn btn-info">Update</a> <input type="submit"
									class="btn btn-info" name="action" value="Delete" /> <input
									type="submit" class="btn btn-info" name="action"
									value="Request Reports" /></td>
							</tr>
						</form:form>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<br />
				<div class="alert alert-info">No people found matching your
					search criteria</div>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>