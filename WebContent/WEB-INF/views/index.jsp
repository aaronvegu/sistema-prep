<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Sistema Prep | Ingreso</title>
</head>
<body>
	<div align="center" style="margin: 0 auto;">
		<h1>Programa de Resultados Electorales Preliminares</h1>
		<br>
		<h3>Ingresar</h3>
		<form action="login" method="post">
			<div class="mb-3" style="max-width: 300px;">
				<label for="email1" class="form-label">Correo</label>
				<input type="email" class="form-control" id="email1" name="username" />
			</div>
			<div class="mb-3" style="max-width: 300px;">
				<label for="pass" class="form-label">Password</label>
				<input type="password" class="form-control" id="pass" name="password" />
			</div>
			<button type="submit" class="btn btn-primary">Ingresar</button>
			
		</form>
	</div>
</body>
</html>