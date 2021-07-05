<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Resultados al Momento</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Resultados al Momento</h1>
		<h3 style="margin: 20px;">Lista de votos por casillas</h3>
		<form:form method="POST" action="viewPDF" modelAttribute="resultados">
		<table class="table" style="max-width: 1200px; margin: 50px 0px;">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Candidatura</th>
					<th scope="col">Partido</th>
					<th scope="col">Tipo de Casilla</th>
					<th scope="col">Municipio</th>
					<th scope="col">Seccion</th>
					<th scope="col">Distrito</th>
					<th scope="col">Votos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listResultado }" var="resultado" varStatus="status">
				<tr>
					<td scope="row">${status.index + 1}</td>		
					<td>
					${resultado.candidatura}
					<c:choose>
						<c:when test="${resultado.local == true}">
					         Local
					    </c:when>    
					    <c:otherwise>
					         Federal
					    </c:otherwise>
					</c:choose>
					</td>
					<td>${resultado.partido}</td>
					<td>${resultado.tipo}</td>
					<td>${resultado.municipio}</td>
					<td>${resultado.seccion}</td>
					<td>${resultado.distrito}</td>
					<td style="background-color: #ADD8E6;"><b>${resultado.cantidad}</b></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<input class="btn btn-success" style="margin: 22px;" type="submit" value="Descargar PDF" />
		</form:form>
		<a href="/Prep/votos-partido"><button type="button" class="btn btn-primary" style="margin: 22px;">Votos Por Partido</button></a>
		<a href="/Prep/inicio"><button type="button" class="btn btn-secondary" style="margin: 22px;">Volver</button></a>
	</div>
</body>
</html>