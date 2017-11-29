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
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function poll() {
		$.ajax({
			url : 'check',
			success : function(data) {

				data = data;
				if (data[0] != "") {
					$("#che").css('visibility', 'visible');
					$("#che2").css('visibility', 'visible');
					$("#div1").html(data[0]);
					$("#subID").val(data[1]);
					console.log($("#consID").val());
				}
			}
		});
	}
	setInterval(poll, 2500);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager</title>
</head>
<body>
	<!--<a href="user">Back</a>-->

	<div class="container">
		<a href="logout" class="btn btn-info">Logout</a>
		<h1>Manager</h1>
		<table>
			<tr>
				<form:form action="manager.acc" method="post"
					modelAttribute="subsidiary">
					<td><h3 style="color: green; width: 300px;" id="div1"></h3></td>
					<td><form:hidden id="subID" path="subsidiaryID"
							class="form-control" /></td>
					<td><input id="che2" style="visibility: hidden;" type="submit"
						class="btn btn-info" name="action" value="Send Status Report" />
						<a href="manager/updateReport?subsidiaryID=1" class="btn btn-info">Update
							Report</a></td>
				</form:form>
			</tr>
		</table>
		<br> <br>

	</div>

</body>
</html>