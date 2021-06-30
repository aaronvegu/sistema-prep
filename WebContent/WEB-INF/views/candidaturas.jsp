<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidaturas | PREP</title>
</head>
<body>
	<div align="center">
		<h1>Lista de candidaturas registradas</h1>
		<h3><a href="agregar-candidatura">Nueva Candidatura</a></h3>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Candidatura</th>
				<th>Partido</th>
				<th>Local</th>
				<th>Federal</th>
				<th>Accion</th>
			</tr>
			<c:forEach items="${ listCandidatura }" var="candidato" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>		
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
		</table>
	</div>
</body>
</html>