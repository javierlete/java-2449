<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<ul>
	<c:forEach items="${clientes}" var="c">
		<li><a href="cliente?id=${c.id}">${c.nombre}</a> <a
			href="cliente?borrarId=${c.id}">X</a></li>
	</c:forEach>
</ul>

<p>
	<a href="cliente">Añadir nuevo cliente</a>
</p>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>