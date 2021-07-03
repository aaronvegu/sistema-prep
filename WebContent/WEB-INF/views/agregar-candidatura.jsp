<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Registrar/Editar Candidatura</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Registrar/Editar Candidatura</h1>
		<form:form action="guardar-candidatura" method="post" modelAttribute="candidatura">
			<table class="table" style="max-width: 600px; margin: 50px 0px;">
				<form:hidden path="id"/>
				<tr>
					<td>Candidatura:</td>
					<td><form:input path="nombre_cand" /></td>
				</tr>
				<tr>
					<td>Partido:</td>
					<td><form:input path="partido" /></td>
				</tr>
				<tr>
					<td>Local:</td>
					<td><form:hidden path="local" value="1"/></td>
					<td><select>
						<option value="1" selected>Si</option>
  						<option value="0">No</option>
					</select></td>
				</tr>
				<tr>
					<td>Federal:</td>
					<td><form:hidden path="federal" value="0"/></td>
					<td><select>
						<option value="1">Si</option>
  						<option value="0" selected>No</option>
					</select></td>
				</tr>
			</table>
			<input class="btn btn-primary" type="submit" value="Registrar"/>
		</form:form>
		<a href="/Prep/candidaturas"><button type="button" class="btn btn-secondary btn-sm" style="margin: 22px;">Volver</button></a>
	</div>
</body>
</html>