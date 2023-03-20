<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<c:if test="${cliente != null && !cliente.valido}">
		Hay errores en el formulario
	</c:if>

<form action="admin/cliente" method="post">
	<input name="id" value="${cliente.id}"> <input name="nombre"
		value="${cliente.nombre}"> <span class="error">${cliente.errores.nombre}</span>

	<input name="nif" value="${cliente.nif}"> <span class="error">${cliente.errores.nif}</span>

	<input name="telefono" value="${cliente.telefono}"> <input
		name="email" value="${cliente.email}"> <input
		name="fechaNacimiento" value="${cliente.fechaNacimiento}">

	<button>
		<c:choose>
			<c:when test="${cliente.id != null}">
					Modificar
				</c:when>
			<c:otherwise>
					Añadir
				</c:otherwise>
		</c:choose>
	</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>