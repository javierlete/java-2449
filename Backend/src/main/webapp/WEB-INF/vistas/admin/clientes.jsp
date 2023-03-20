<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-bordered table-striped">
	<thead class="table-${temaInverso}">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>NIF</th>
			<th>Teléfono</th>
			<th>Email</th>
			<th>Fecha Nacimiento</th>
			<th>OPCIONES</th>
		</tr>
	</thead>
	<tbody class="table-${tema}">
		<c:forEach items="${clientes}" var="c">
			<tr>
				<th>${c.id}</th>
				<td>${c.nombre}</td>
				<td>${c.nif}</td>
				<td>${c.telefono}</td>
				<td>${c.email}</td>
				<td><tags:localDate date="${c.fechaNacimiento}"/></td>
				<td><a class="btn-sm ${boton}-primary"
					href="admin/cliente?id=${c.id}">Editar</a> <a
					class="btn-sm ${boton}-danger" href="admin/cliente?borrarId=${c.id}">Borrar</a>
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
			<td></td>
			<td></td>

			<td><a class="btn btn-sm btn-primary" href="admin/cliente">Añadir
					nuevo cliente</a></td>
		</tr>

	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>