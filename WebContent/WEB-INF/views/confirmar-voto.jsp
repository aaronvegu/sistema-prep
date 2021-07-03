<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Confirmacion de voto | PREP</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1 style="margin: 20px;">Confirmar registro de votos</h1>
		<h5>Ingrese la cantidad de votos a registrar:</h5>
		<form:form action="guardar-voto" method="post" modelAttribute="voto">
			<div style="max-width: 600px; margin: 50px 0px;">
				<form:hidden path="casilla"/>
				<form:hidden path="candidatura"/>
				<div>
					<label class="form-label">Cantidad de Votos:</label>
					<form:input path="cantidad" class="form-control" style="max-width: 200px;"/>
				</div>
				<div style="margin: 30px;">
					<button type="submit" class="btn btn-primary">Confirmar</button>
					<a href="/Prep/votos"><button class="btn btn-secondary">Cancelar</button></a>
				</div>
			</div>
		</form:form>
	</div>
	
</body>
</html>