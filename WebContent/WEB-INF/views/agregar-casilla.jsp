<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Registrar/Editar Casilla</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Registrar/Editar Casilla</h1>
		<form:form action="guardar-casilla" method="post" modelAttribute="casilla">
			<table class="table" style="max-width: 600px; margin: 50px 0px;">
				<form:hidden path="id"/>
				<tr>
					<td>Tipo de casilla:</td>
					<td><form:input path="tipoCasilla" /></td>
				</tr>
				<tr>
					<td>Municipio:</td>
					<td><form:input path="municipio" /></td>
				</tr>
				<tr>
					<td>Seccion:</td>
					<td><form:input path="seccion" /></td>
				</tr>
				<tr>
					<td>Distrito:</td>
					<td><form:input path="distrito" /></td>
				</tr>
				
			</table>
			<input class="btn btn-primary" type="submit" value="Registrar"/>
		</form:form>
		<a href="/Prep/casillas"><button type="button" class="btn btn-secondary btn-sm" style="margin: 22px;">Volver</button></a>
	</div>
</body>
</html>