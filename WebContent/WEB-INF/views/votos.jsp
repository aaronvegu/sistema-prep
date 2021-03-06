<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Votos | PREP</title>
</head>
<body>
	<div class="container" align="center">
	<br>
	<h1>Seccion de Votos</h1>
	<br>
		<div class="alert alert-success d-flex align-items-center"
			role="alert" style="margin: 0 auto; max-width: 500px;">
			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
				fill="currentColor"
				class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2"
				viewBox="0 0 16 16" role="img" aria-label="Success:">
    <path
					d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
  </svg>
			<div>Votos Totales al momento: ${totalVotos}</div>
		</div>
		<br>
		<div style="margin: 0 auto;">
			<a href="/Prep/lista-casillas"><button type="button" class="btn btn-primary" style="margin: 10px;">Registrar Votos</button></a>
			<a href="/Prep/inicio"><button type="button" class="btn btn-secondary" style="margin: 10px;">Volver</button></a>
		</div>
	</div>
</body>
</html>