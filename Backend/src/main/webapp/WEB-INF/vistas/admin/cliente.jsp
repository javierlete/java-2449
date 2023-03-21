<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/cliente" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly
				class="form-control text-bg-${tema} ${cliente.errores.id != null ? 'is-invalid' : '' }"
				id="id" name="id" value="${cliente.id}">
			<div class="invalid-feedback">${cliente.errores.id}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control text-bg-${tema} ${cliente.errores.nombre != null ? 'is-invalid' : '' }"
				id="nombre" name="nombre" value="${cliente.nombre}">
			<div class="invalid-feedback">${cliente.errores.nombre}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nif" class="col-sm-2 col-form-label">NIF</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control text-bg-${tema} ${cliente.errores.nif != null ? 'is-invalid' : '' }"
				id="nif" name="nif" value="${cliente.nif}">
			<div class="invalid-feedback">${cliente.errores.nif}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control text-bg-${tema} ${cliente.errores.email != null ? 'is-invalid' : '' }"
				id="email" name="email" value="${cliente.email}">
			<div class="invalid-feedback">${cliente.errores.email}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="telefono" class="col-sm-2 col-form-label">Teléfono</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control text-bg-${tema} ${cliente.errores.telefono != null ? 'is-invalid' : '' }"
				id="telefono" name="telefono" value="${cliente.telefono}">
			<div class="invalid-feedback">${cliente.errores.telefono}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="fechaNacimiento" class="col-sm-2 col-form-label">Fecha
			de nacimiento</label>
		<div class="col-sm-10">
			<input type="date"
				class="form-control text-bg-${tema} ${cliente.errores.fechaNacimiento != null ? 'is-invalid' : '' }"
				id="fechaNacimiento" name="fechaNacimiento"
				value="${cliente.fechaNacimiento}">
			<div class="invalid-feedback">${cliente.errores.fechaNacimiento}</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button class="${boton}-primary">
				<c:choose>
					<c:when test="${cliente.id != null}">
					Modificar
				</c:when>
					<c:otherwise>
					Añadir
				</c:otherwise>
				</c:choose>
			</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>