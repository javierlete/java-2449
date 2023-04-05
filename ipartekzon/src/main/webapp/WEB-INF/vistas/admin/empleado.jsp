<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/empleado" method="post" class="container">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control" id="id" name="id"
				value="${empleado.id}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="nif" class="col-sm-2 col-form-label">NIF</label>
		<div class="col-sm">
			<input type="text"
				class="form-control ${errores.nif != null ? 'is-invalid': ''}"
				id="nif" name="nif" value="${empleado.nif}">
			<div class="invalid-feedback">El NIF es obligatorio y debe
				cumplir el formato 12345678A</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control ${errores.nombre != null ? 'is-invalid': ''}"
				id="nombre" name="nombre" value="${empleado.nombre}">
			<div class="invalid-feedback">El nombre es obligatorio y al
				menos debe tener 2 caracteres</div>
		</div>
	</div>

	<div class="row mb-3">
		<div class="offset-sm-2 col-sm">
			<button class="btn btn-primary">Aceptar</button>
		</div>
	</div>

	<div class="row mb-3 align-items-start">
		<table class="col-sm table table-hover table-striped table-bordered">
			<caption>Vacaciones</caption>
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Fecha</th>
					<th>OPCIONES</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${empleado.vacaciones}" var="v">
					<tr>
						<th>${v.id}</th>
						<td>${v.fecha}</td>
						<td><a class="btn btn-sm btn-danger" href="#">Borrar</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="col-sm table table-hover table-striped table-bordered">
			<caption>Empleados a su cargo</caption>
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Empleado</th>
					<th>OPCIONES</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${empleado.empleados}" var="e">
					<tr>
						<th>${e.id}</th>
						<td>${e.nombre}</td>
						<td><a class="btn btn-sm btn-danger" href="#">Borrar</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
