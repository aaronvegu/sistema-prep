<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Casillas Registradas</title>
</head>
<body>
	<div align="center">
		<h1>Lista de casillas registradas</h1>
		<h3><a href="agregar-casilla">Nueva Casilla</a></h3>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Tipo Casilla</th>
				<th>Municipio</th>
				<th>Seccion</th>
				<th>Distrito</th>
				<th>Accion</th>
			</tr>
			<c:forEach items="${ listCasilla }" var="casilla" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>		
				<td>${casilla.tipoCasilla}</td>
				<td>${casilla.municipio}</td>
				<td>${casilla.seccion}</td>
				<td>${casilla.distrito}</td>
				<td>
					<a href="editar-casilla?id=${casilla.id}">Editar</a>
					&nbsp;&nbsp;
					<a href="eliminar-casilla?id=${casilla.id}">Eliminar</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>