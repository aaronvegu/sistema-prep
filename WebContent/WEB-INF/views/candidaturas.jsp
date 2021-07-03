<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Candidaturas | PREP</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Lista de candidaturas registradas</h1>
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
				<c:forEach items="${ listCandidatura }" var="candidato" varStatus="status">
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
						<a href="editar-candidatura?id=${candidato.id}">Editar</a>
						&nbsp;&nbsp;
						<a href="eliminar-candidatura?id=${candidato.id}">Eliminar</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="agregar-candidatura"><button type="button" class="btn btn-primary btn-sm" style="margin: 22px;">Nueva Candidatura</button></a>
		<a href="/Prep/inicio"><button type="button" class="btn btn-secondary btn-sm" style="margin: 22px;">Volver</button></a>
	</div>
</body>
</html>