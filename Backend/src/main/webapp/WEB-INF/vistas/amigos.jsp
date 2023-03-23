<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="d-flex justify-content-center">
	<ul class="col-lg-4 col-sm-6 col-12 list-group">
		<c:forEach items="${amigos}" var="a">
			<li class="list-group-item d-flex align-items-center justify-content-between"><span>${a.nombre}</span> <a
				class="btn text-danger" href="quitar-amigo?id=${a.id}"> <svg
						xmlns="http://www.w3.org/2000/svg" width="30" height="30"
						fill="currentColor" class="bi bi-x-square-fill"
						viewBox="0 0 16 16">
  <path
							d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z" />
</svg>
			</a></li>
		</c:forEach>
	</ul>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>