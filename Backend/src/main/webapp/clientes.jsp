<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.clientes.modelos.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado clientes</title>
</head>
<body>

	<ul>
		<%
		for (Cliente c : (Iterable<Cliente>) request.getAttribute("clientes")) {
		%>
		<li><a href="cliente?id=<%=c.getId()%>"><%=c.getNombre()%></a></li>
		<%
		}
		%>
	</ul>
</body>
</html>