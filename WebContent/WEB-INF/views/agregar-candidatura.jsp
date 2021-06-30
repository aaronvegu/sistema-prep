<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar/Editar Casilla</title>
</head>
<body>
	<div align="center">
		<h1>Registrar/Editar Candidatura</h1>
		<form:form action="guardar-candidatura" method="post" modelAttribute="candidatura">
			<table>
				<form:hidden path="id"/>
				<tr>
					<td>Candidatura:</td>
					<td><form:input path="nombre_cand" /></td>
				</tr>
				<tr>
					<td>Partido:</td>
					<td><form:input path="partido" /></td>
				</tr>
				<tr>
					<td>Local:</td>
					<td><form:hidden path="local" value="1"/></td>
					<td><select>
						<option value="1" selected>Si</option>
  						<option value="0">No</option>
					</select></td>
				</tr>
				<tr>
					<td>Federal:</td>
					<td><form:hidden path="federal" value="0"/></td>
					<td><select>
						<option value="1">Si</option>
  						<option value="0" selected>No</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Registrar"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>