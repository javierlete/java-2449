<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<ul class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4 list-unstyled">
	<c:forEach items="${clientes}" var="c">
		<li class="col">
			<div class="card h-100 text-bg-${tema}">
				<img src="imgs/${c.id}.jpg" class="card-img-top" alt="">
				<div class="card-body d-flex flex-column">
					<h5 class="card-title">${c.nombre}</h5>
					<p class="card-text">${c.nif}</p>
					<p class="card-text">${c.email}</p>
					<p class="card-text">${c.telefono}</p>
					<a class="mt-auto btn btn-primary w-100" href="detalle?id=${c.id}">Ver
						detalles</a>
				</div>
				<div class="card-footer">
					<small class="text-muted">${c.fechaNacimiento == null ? 'No se sabe' : c.fechaNacimiento}</small>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>