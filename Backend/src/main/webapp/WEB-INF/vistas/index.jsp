<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<ul>
	<c:forEach items="${clientes}" var="c">
		<li>
			<p>${c.nombre}</p>
			<p>${c.nif}</p>
			<p>${c.email}</p>
			<p>${c.telefono}</p>
			<p>${c.fechaNacimiento}</p>
			<p>
				<a href="cliente?id=${c.id}">Ver detalles</a>
			</p>
		</li>
	</c:forEach>
</ul>

<p>
	<a href="cliente">Añadir nuevo cliente</a>
</p>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>