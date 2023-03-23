<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="imgs/${cliente.id}.jpg" class="img-fluid rounded-start" alt="">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${cliente.nombre}</h5>
				<p class="card-text">
					NIF: ${cliente.nif}
				</p>
				
				<p class="card-text">
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque et arcu eu ante dictum eleifend vel dictum augue. Maecenas quis aliquet ipsum, nec varius metus. Morbi ultricies eros arcu, nec ornare ipsum molestie non. Phasellus quis eros facilisis, laoreet ex feugiat, rutrum nulla. Integer quis tempus velit, et laoreet diam. Vivamus scelerisque tellus lorem. Suspendisse porta efficitur placerat. Proin ipsum ex, tristique in maximus et, pharetra sed est. Praesent malesuada nulla nec libero aliquam vehicula. Donec vel mi ex. Curabitur non magna urna. Praesent gravida tincidunt ligula at aliquet. Donec id elit sapien. Aliquam dignissim luctus tempus.
				</p>
				
				<p class="card-text">
					<a href="amigo?id=${cliente.id}" class="btn btn-primary">Añadir amigo</a>
				</p>
				<p class="card-text">
					<small class="text-muted">${cliente.fechaNacimiento}</small>
				</p>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>