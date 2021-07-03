<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Sistema PREP | Inicio</title>
</head>
<body>
	<div align="center" style="margin: 100px;">
		<h1>Programa de Resultados Electorales Preliminares</h1>
	</div>
	<div class="container">
		<div class="card" style="width: 18rem; margin: 0 auto;">
			<div class="card-body" style="text-align: center;">
				<h3 class="card-title">Registrar Nueva Casilla</h3>
				<a href="/Prep/casillas">Ir a casillas</a> <br>
			</div>
		</div>
		<br>
		<br>
		<div class="card" style="width: 18rem; margin: 0 auto;">
			<div class="card-body" style="text-align: center;">
				<h3 class="card-title">Registrar Nueva Candidatura</h3>
				<a href="/Prep/candidaturas">Ir a candidaturas</a>
			</div>
		</div>
		<br>
		<br>
		<div class="card" style="width: 18rem; margin: 0 auto;">
			<div class="card-body" style="text-align: center;">
				<h3 class="card-title">Registrar Votos</h3>
				<a href="/Prep/votos">Ir a votos</a>
			</div>
		</div>
		<div align="center" style="margin: 50px;">
			<a href="/Prep"><button type="button" class="btn btn-secondary" style="margin: 22px;">Salir</button></a>
		</div>
	</div>
</body>
</html>