<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-bordered table-striped">
	<thead class="table-${temaInverso}">
		<tr>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th>Identificativo</th>
			<th>Contraseña</th>
			<th class="text-center">OPCIONES</th>
		</tr>
	</thead>
	<tbody class="table-${tema}">
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<th class="text-end">${u.id}</th>
				<td>${u.nombre}</td>
				<td>${u.identificativo}</td>
				<td>${u.password}</td>
				<td class="text-center"><a class="btn-sm ${boton}-primary"
					href="admin/usuario?id=${u.id}">Editar</a> <a
					class="btn-sm ${boton}-danger" href="admin/usuario?borrarId=${u.id}">Borrar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-${temaInverso}">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="text-center"><a class="btn btn-sm btn-primary" href="admin/usuario">Añadir
					nuevo usuario</a></td>
		</tr>

	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>