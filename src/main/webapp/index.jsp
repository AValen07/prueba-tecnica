<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página principal</title>
</head>
<body>
	<h1>Inicio</h1>
	
	<form action="Proveedor" method="get">
	<input type="hidden" name="opcion" value="listar">
		<table>
			<tr>Codigo cliente: </tr>
			<tr><input type="number" name="codCliente"></input> </tr>	
			<tr><input type="submit" value="Buscar"></input>	</tr>
			<tr>(Para obtener todos los proveedores introduzca 0 como codigo de cliente)</tr>	
		</table>	
	</form>

</body>
</html>