<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1>Clientes</h1>

<table class="table table-hover table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Nif</th>
			<th>OPCIONES</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${clientes}" var="c">
			<tr>
				<th>${c.id}</th>
				<td>${c.nombre}</td>
				<td>${c.nif}</td>
				<td>
					<form action="admin/clientes" method="post">
						<a class="btn btn-sm btn-primary" href="admin/cliente?id=${c.id}">Editar</a>
						<input type="hidden" name="id" value="${c.id}">
						<button class="btn btn-sm btn-danger">Borrar</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<a class="btn btn-sm btn-primary" href="admin/cliente">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
