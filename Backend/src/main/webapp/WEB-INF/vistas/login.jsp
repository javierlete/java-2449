<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form class="offset-sm-3 col-sm-6" action="login" method="post">
	<div class="row mb-3">
		<label for="user" class="col-sm-3 col-form-label">Usuario</label>
		<div class="col-sm-9">
			<input type="text" class="form-control text-bg-${tema}" id="user"
				name="user" value="${usuario.identificativo}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="password" class="col-sm-3 col-form-label">Contraseña</label>
		<div class="col-sm-9">
			<input type="password" class="form-control text-bg-${tema}"
				id="password" name="password">
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-3 col-sm-9">
			<button class="${boton}-primary">Login</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>