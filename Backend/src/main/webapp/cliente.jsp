<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.clientes.modelos.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario cliente</title>
</head>
<body>

	<% Cliente c = (Cliente)request.getAttribute("cliente"); %>
	
	<form action="cliente" method="post">
		<input name="id" value="<%=c.getId()%>">
		<input name="nombre" value="<%=c.getNombre()%>">
		<input name="nif" value="<%=c.getNif()%>">
		<input name="telefono" value="<%=c.getTelefono()%>">
		<input name="email" value="<%=c.getEmail()%>">
		<input name="fechaNacimiento" value="<%=c.getFechaNacimiento()%>">
		
		<button>Aceptar</button>
	</form>
</body>
</html>