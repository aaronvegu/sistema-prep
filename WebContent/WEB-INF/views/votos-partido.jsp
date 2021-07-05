<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Resultados al Momento | Votos por Partido</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Resultados al Momento</h1>
		<h3 style="margin: 20px;">Votos Totales por Partido</h3>
		<table class="table" style="max-width: 1200px; margin: 50px 0px;">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Partido</th>
					<th scope="col">Votos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listResultado }" var="resultado" varStatus="status">
				<tr>
					<td scope="row">${status.index + 1}</td>		
					<td>${resultado.partido}</td>
					<td style="background-color: #ADD8E6;"><b>${resultado.cantidad}</b></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/Prep/resultados"><button type="button" class="btn btn-secondary" style="margin: 22px;">Volver</button></a>
	</div>
</body>
</html>