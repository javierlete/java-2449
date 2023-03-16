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
				<a href="cliente?id=${c.id}">${c.nombre}</a>
				<a href="cliente?borrarId=${c.id}">X</a>
			</li>
		</c:forEach>
	</ul>
	
	<p>
		<a href="cliente">Añadir nuevo cliente</a>
	</p>
</body>
</html>