<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/usuario" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly
				class="form-control text-bg-${tema} ${requestScope.usuario.errores.id != null ? 'is-invalid' : '' }"
				id="id" name="id" value="${requestScope.usuario.id}">
			<div class="invalid-feedback">${requestScope.usuario.errores.id}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control text-bg-${tema} ${requestScope.usuario.errores.nombre != null ? 'is-invalid' : '' }"
				id="nombre" name="nombre" value="${requestScope.usuario.nombre}">
			<div class="invalid-feedback">${requestScope.usuario.errores.nombre}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="identificativo" class="col-sm-2 col-form-label">Identificativo</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control text-bg-${tema} ${requestScope.usuario.errores.identificativo != null ? 'is-invalid' : '' }"
				id="identificativo" name="identificativo" value="${requestScope.usuario.identificativo}">
			<div class="invalid-feedback">${requestScope.usuario.errores.identificativo}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<input type="password"
				class="form-control text-bg-${tema} ${requestScope.usuario.errores.password != null ? 'is-invalid' : '' }"
				id="password" name="password" value="${requestScope.usuario.password}">
			<div class="invalid-feedback">${requestScope.usuario.errores.password}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="rol" class="col-sm-2 col-form-label">Rol</label>
		<div class="col-sm-10">
			<select class="form-select text-bg-${tema} ${requestScope.usuario.errores.rol != null ? 'is-invalid' : '' }"
				id="rol" name="rol">
				<option value="0">Por favor, selecciona un rol</option>
				<c:forEach items="${roles}" var="r">
					<option value="${r.id}" ${r.id == requestScope.usuario.rol.id ? 'selected' : '' }>${r.nombre} ${r.descripcion}</option>
				</c:forEach>
			</select>
			<div class="invalid-feedback">${requestScope.usuario.errores.rol}</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button class="${boton}-primary">
				<c:choose>
					<c:when test="${requestScope.usuario.id != null}">
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