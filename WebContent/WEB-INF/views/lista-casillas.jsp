<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Registrar Voto | PREP</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Lista de casillas</h1>
		<h5>Elija una casilla sobre la cual registrar votos:</h5>
		<table class="table" style="max-width: 600px; margin: 50px 0px;">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Tipo Casilla</th>
					<th scope="col">Municipio</th>
					<th scope="col">Seccion</th>
					<th scope="col">Distrito</th>
					<th scope="col">Accion</th>
				</tr>
			</thead>
			</tbody>
				<c:forEach items="${ listarCasillas }" var="casillas" varStatus="status">
				<tr>
					<td scope="row">${status.index + 1}</td>		
					<td>${casillas.tipoCasilla}</td>
					<td>${casillas.municipio}</td>
					<td>${casillas.seccion}</td>
					<td>${casillas.distrito}</td>
					<td>
						<a href="registrar-voto?id=${casillas.id}">Seleccionar</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="margin: 0 auto;">
			<a href="/Prep/votos"><button type="button" class="btn btn-secondary" style="margin: 10px;">Volver</button></a>
		</div>
	</div>
</body>
</html>