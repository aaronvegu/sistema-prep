<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Sistema PREP | Usuarios</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Lista de usuarios registrados</h1>
		<table class="table" style="max-width: 1600px; margin: 50px 0px;">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Nombre</th>
					<th scope="col">Correo</th>
					<th scope="col">Direccion</th>
					<th scope="col">Estatus</th>
					<th scope="col">Accion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listUsuario }" var="usuario" varStatus="status">
				<tr>
					<td scope="row">${status.index + 1}</td>		
					<td>${usuario.nombre} ${usuario.apellidos}</td>
					<td>${usuario.correo}</td>
					<td>${usuario.calle} #${usuario.numInt} ext ${usuario.numInt} 
					col ${usuario.colonia}, c.p. ${usuario.codigoPostal}, 
					${usuario.municipio}, ${usuario.estado}</td>
					<c:choose>
						<c:when test="${usuario.aprobado == true}">
					        <td>Aprobado</td>
					    </c:when>    
					    <c:otherwise>
					        <td>No Aprobado</td>
					    </c:otherwise>
					</c:choose>
					<td>
					<c:choose>
						<c:when test="${usuario.aprobado == true}">
					        <a href="cambiar-status?id=${usuario.id}&status=false">Desaprobar</a>
					    </c:when>    
					    <c:otherwise>
					        <a href="cambiar-status?id=${usuario.id}&status=true">Aprobar</a>
					    </c:otherwise>
					</c:choose>
					    &nbsp;&nbsp;
						<a href="editar-usuario?id=${usuario.id}">Editar</a>
						&nbsp;&nbsp;
						<a href="eliminar-usuario?id=${usuario.id}">Eliminar</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/Prep/inicio"><button type="button" class="btn btn-secondary btn-sm" style="margin: 22px;">Volver</button></a>
	</div>
</body>
</html>