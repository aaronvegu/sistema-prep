<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Sistema PREP | Registro</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Registro</h1>
		<form:form action="registrar-usuario" method="post" modelAttribute="usuario">
			<table class="table" style="max-width: 600px; margin: 50px 0px;">
				<tr>
					<td>Nombre:</td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td>Apellidos:</td>
					<td><form:input path="apellidos" /></td>
				</tr>
				<tr>
					<td>Correo:</td>
					<td><form:input path="correo" type="email" placeholder=""/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" type="password" placeholder=""/></td>
				</tr>
				<tr>
					<td>Calle:</td>
					<td><form:input path="calle" /></td>
				</tr>
				<tr>
					<td>Colonia:</td>
					<td><form:input path="colonia" /></td>
				</tr>
				<tr>
					<td>Numero Interior:</td>
					<td><form:input path="numInt" /></td>
				</tr>
				<tr>
					<td>Numero Exterior:</td>
					<td><form:input path="numExt" /></td>
				</tr>
				<tr>
					<td>Municipio:</td>
					<td><form:input path="municipio" /></td>
				</tr>
				<tr>
					<td>Estado:</td>
					<td><form:input path="estado" /></td>
				</tr>
				<tr>
					<td>Codigo Postal:</td>
					<td><form:input path="codigoPostal" /></td>
				</tr>
				<form:hidden path="aprobado" value="false"/>
				<form:hidden path="admin" value="false"/>
			</table>
			<input class="btn btn-primary" type="submit" value="Registrar"/>
		</form:form>
		<a href="/Prep"><button type="button" class="btn btn-secondary" style="margin: 22px;">Cancelar</button></a>
	</div>
</body>
</html>