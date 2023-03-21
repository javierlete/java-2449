<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Aplicación</title>
<base href="${pageContext.request.contextPath}/">

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.bundle.min.js"></script>

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

<c:set var="tema"
	value="${cookie.tema.value == 'oscuro' ? 'dark' : 'light'}"></c:set>
<c:set var="temaInverso"
	value="${cookie.tema.value == 'oscuro' ? 'light' : 'dark'}"></c:set>
<c:set var="boton"
	value="${cookie.tema.value == 'oscuro' ? 'btn btn-outline' : 'btn btn'}"></c:set>

<body class="text-bg-${tema}">


	<nav
		class="navbar navbar-expand-lg navbar-${temaInverso} bg-${temaInverso}">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Aplicación</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="admin/clientes">Administración</a></li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
					<li class="nav-item navbar-text px-3">${usuario}</li>
				</ul>
				<form class="d-flex align-items-baseline" action="cookies"
					method="post">
					<div
						class="d-flex align-items-baseline form-check form-check-inline form-switch">
						<input onclick="document.forms[0].submit()"
							class="form-check-input" id="tema" name="tema" type="checkbox"
							role="switch" ${cookie.tema.value == 'oscuro' ? 'checked' : ''}>
						<label
							class="ps-3 navbar-text form-check-label ${tema == 'light' ? 'text-white' : 'text-black'}"
							for="tema"><svg xmlns="http://www.w3.org/2000/svg"
								width="30" height="30" fill="currentColor"
								class="bi bi-moon-stars-fill" viewBox="0 0 16 16">
  <path
									d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z" />
  <path
									d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z" />
</svg></label>
					</div>
				</form>
			</div>
		</div>
	</nav>
	<c:if test="${alerta != null}">
		<div class="alert alert-${alerta.nivel} alert-dismissible fade show"
			role="alert">
			${alerta.texto}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<main class="container py-3">