<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicación</title>
<base href="${pageContext.request.contextPath}/">
<style>
.claro {
	background-color: white;
	color: black;
}

.oscuro {
	background-color: black;
	color: white;
}
</style>
</head>
<body class="${cookie.tema.value}">
	<h1>Aplicación</h1>
	<nav>
		<ul>
			<li><a href="admin/clientes">Administración</a></li>
			<li><a href="login">Login</a></li>
			<li><a href="logout">Logout</a></li>
			<li>Tema: ${cookie.tema.value}</li>
			<li>Usuario: ${usuario}</li>
		</ul>
	</nav>
	<form action="cookies" method="post">
		<select name="tema">
			<option value="claro">Claro</option>
			<option value="oscuro">Oscuro</option>
		</select>
		<button>Aceptar</button>
	</form>