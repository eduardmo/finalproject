<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="../resources/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="../resources/js/customerValidation.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jquery.timepicker.min.js"></script>
<link href="../resources/css/jquery-ui.css" rel="stylesheet">
<link href="../resources/css/jquery.timepicker.min.css" rel="stylesheet">
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"></link>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
</head>
<body>
	<div class="container">
		<a href="../owner" class="btn btn-info">Back</a>
		<form:form action="add.add" method="post" modelAttribute="subsidiary"
			data-toggle="validator">
			<h2>Subsidiary</h2>
			<div class="form-group col-xs-4">
				<label class="control-label col-xs-4">Name:</label>
				<form:input class="form-control" path="subsidiaryName" value=""
					required="true" />
				<label class="control-label col-xs-4">Manager PNC:</label>
				<form:input class="form-control" path="subsidiaryManagerPNC"
					value="" required="true" pattern="^[1-9]{1}[0-9]{12}$" />
				<input type="submit" class="btn btn-info" name="action" value="Add" />
			</div>
		</form:form>
	</div>
</body>
</html>