<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de proveedores</h1>
	<c:choose>
	<c:when test="${listadoProveedores.size()==0}">
	<h2>No se encontraron resultados. Pruebe otra busqueda.</h2>
	</c:when>
	<c:otherwise>
	<table> 
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<td>Fecha de alta</td>
			<td>Id cliente</td>
		</tr>	
		<c:forEach var="proveedor" items="${listadoProveedores}">
			<tr>
				<td><c:out value="${proveedor.idProveedor}"></c:out></td>
				<td><c:out value="${proveedor.nombre}"></c:out></td>
				<td><c:out value="${proveedor.fechaAlta}"></c:out></td>
				<td><c:out value="${proveedor.idCliente}"></c:out></td>
			</tr>	
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
	<a href="Proveedor?opcion=inicio">volver</a>
</body>
</html>