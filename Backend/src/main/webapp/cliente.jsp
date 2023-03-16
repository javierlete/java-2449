<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.clientes.modelos.Cliente"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario cliente</title>
</head>
<body>
	<c:if test="${cliente != null && !cliente.valido}">
		Hay errores en el formulario
	</c:if>
	
	<form action="cliente" method="post">
		<input name="id" value="${cliente.id}">
		
		<input name="nombre" value="${cliente.nombre}">
		<span class="error">${cliente.errores.nombre}</span>
		
		<input name="nif" value="${cliente.nif}">
		<span class="error">${cliente.errores.nif}</span>
		
		<input name="telefono" value="${cliente.telefono}">
		
		<input name="email" value="${cliente.email}">
		
		<input name="fechaNacimiento" value="${cliente.fechaNacimiento}">
		
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
</body>
</html>