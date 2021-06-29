<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar/Editar Casilla</title>
</head>
<body>
	<div align="center">
		<h1>Registrar/Editar Casilla</h1>
		<form:form action="guardar-casilla" method="post" modelAttribute="casilla">
			<table>
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
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Registrar"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>