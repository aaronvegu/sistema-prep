<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Voto | PREP</title>
</head>
<body>
	<div align="center">
		<h1>Lista de casillas</h1>
		<h3>Elija una casilla sobre la cual registrar votos:</h3>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Tipo Casilla</th>
				<th>Municipio</th>
				<th>Seccion</th>
				<th>Distrito</th>
				<th>Accion</th>
			</tr>
			<c:forEach items="${ listarCasillas }" var="casillas" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>		
				<td>${casillas.tipoCasilla}</td>
				<td>${casillas.municipio}</td>
				<td>${casillas.seccion}</td>
				<td>${casillas.distrito}</td>
				<td>
					<a href="registrar-voto?id=${casillas.id}">Seleccionar</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<a href="/Prep/votos">Volver</a>
	</div>
</body>
</html>