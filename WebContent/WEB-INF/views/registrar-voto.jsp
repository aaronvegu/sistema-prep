<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Registrar Votos | PREP</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Lista de Candidaturas</h1>
		<h5>Elija una candidatura sobre la cual registrar votos:</h5>
		<table class="table" style="max-width: 600px; margin: 50px 0px;">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Candidatura</th>
					<th scope="col">Partido</th>
					<th scope="col">Local</th>
					<th scope="col">Federal</th>
					<th scope="col">Accion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ modelos.listCandidatura }" var="candidato" varStatus="status">
				<tr>
					<td scope="row">${status.index + 1}</td>		
					<td>${candidato.nombre_cand}</td>
					<td>${candidato.partido}</td>
					<c:choose>
					    <c:when test="${candidato.local =='1'}">
					        <td>SI</td>
					    </c:when>    
					    <c:otherwise>	
					        <td>NO</td>
					    </c:otherwise>
					</c:choose>
					<c:choose>
					    <c:when test="${candidato.federal =='1'}">
					        <td>SI</td>
					    </c:when>    
					    <c:otherwise>
					        <td>NO</td>
					    </c:otherwise>
					</c:choose>
					<td>
						<a href="confirmar-voto?idCasilla=${modelos.casilla.id}&idCandidatura=${candidato.id}">Seleccionar</a>
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