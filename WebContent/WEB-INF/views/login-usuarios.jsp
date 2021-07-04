<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Sistema Prep | Acceder a Usuarios</title>
</head>
<body>
	<div align="center" style="margin: 0 auto;">
		<h1 style="margin-top: 100px;">Acceso a Usuarios</h1>
		<br>
		<h3>Necesitas ingresar como administrador para continuar</h3>
		<form action="usuarios" method="post">
			<div class="mb-3" style="max-width: 300px;">
				<label for="email1" class="form-label">Nombre de usuario:</label>
				<input type="text" class="form-control" id="email1" name="username" required/>
			</div>
			<div class="mb-3" style="max-width: 300px;">
				<label for="pass" class="form-label">Password</label>
				<input type="password" class="form-control" id="pass" name="password" required/>
			</div>
			<button type="submit" class="btn btn-primary">Ingresar</button>
			
		</form>
	</div>
</body>
</html>