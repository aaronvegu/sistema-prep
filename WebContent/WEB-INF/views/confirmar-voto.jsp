<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Confirmar registro de votos</h1>
		<h3>Ingrese la cantidad de votos a registrar:</h3>
		<form:form action="guardar-voto" method="post" modelAttribute="voto">
			<table>
				<form:hidden path="casilla"/>
				<form:hidden path="candidatura"/>
				<tr>
					<td>Cantidad de Votos:</td>
					<td><form:input path="cantidad" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Confirmar"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		<a href="/Prep/votos">Cancelar</a>
	</div>
</body>
</html>