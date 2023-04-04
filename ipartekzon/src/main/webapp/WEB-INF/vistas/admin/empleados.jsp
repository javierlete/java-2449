<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Empleados</h1>

<table class="table table-hover table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Nif</th>
			<th>Sueldo</th>
			<th>Jefe</th>
			<th>OPCIONES</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${empleados}" var="e">
			<tr>
				<th>${e.id}</th>
				<td>${e.nombre}</td>
				<td>${e.nif}</td>
				<td>${e.sueldo}</td>
				<td>${e.jefe.nombre}</td>
				<td><a class="btn btn-sm btn-primary"
					href="admin/empleado?id=${e.id}">Vacaciones</a>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
