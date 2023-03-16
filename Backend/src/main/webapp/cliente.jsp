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
	
	<form action="cliente" method="post">
		<input name="id" value="${cliente.id}">
		<input name="nombre" value="${cliente.nombre}">
		<input name="nif" value="${cliente.nif}">
		<input name="telefono" value="${cliente.telefono}">
		<input name="email" value="${cliente.email}">
		<input name="fechaNacimiento" value="${cliente.fechaNacimiento}">
		
		<button>
			<c:choose>
				<c:when test="${cliente != null}">
					Modificar
				</c:when>
				<c:otherwise>
					Añadir
				</c:otherwise>
			</c:choose>
			<%-- <c:if test="${cliente != null}">
				Modificar
			</c:if>
			
			<c:if test="${cliente == null}">
				Añadir
			</c:if> --%>
		</button>
	</form>
</body>
</html>