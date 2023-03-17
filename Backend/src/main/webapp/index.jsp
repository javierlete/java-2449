<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.clientes.modelos.Cliente"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado clientes</title>
</head>
<body>

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
</body>
</html>